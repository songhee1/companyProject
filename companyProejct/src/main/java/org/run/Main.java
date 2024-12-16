package org.run;

import java.io.IOException;
import org.data.Data;
import org.domain.OrderEnum;
import org.domain.fsm.OrderEventEnum;
import org.exception.UserException;
import org.outputSystem.OutputBundle;
import org.service.ProductService;
import org.service.ProductServiceImpl;
import org.state.OrderContext;
import org.state.OrderState;
import org.validation.ValidateLogic;

public class Main {
    public static void main(String[] args) throws IOException{

        Data.getItems();
        OrderContext context = new OrderContext();
        context.handleEvent(OrderEventEnum.InitialWaitingEvent);

        /** 입력값 : o ➡️ OrderStartedEvent 발생
         *  입력값 : q ➡️ QuitEvent 발생
         *  ✅ context.handleEvent(OrderEventEnum.<선택한 이벤트명>);
         */

        String command = context.getCommand();
        if(command.equals(OrderEnum.ORDER.getOrderData())){
            context.handleEvent(OrderEventEnum.OrderStartedEvent);
            context.handleEvent(OrderEventEnum.SelectProductEvent);
            int productId = orderWithProductId(productService);
            if(productId == 0){
                break;
            }
            int productAmount = orderWithProductAmount();
            try{
                productService.orderProduct(productId, productAmount);
                productService.addProductToBasket(productId, productAmount, basket);
            }catch(UserException exception){
                System.out.println(exception.getMessage());
                isReset = true;
                break;
            }

        }else if(command.equals(OrderEnum.QUIT.getOrderData())){
            context.handleEvent(OrderEventEnum.QuitEvent);
            context.handleEvent(OrderEventEnum.OrderEndEvent);
        }

        /**
        * 예전에 작성한 방식
         * OrderProgram orderProgramController = new OrderProgram();
         * orderProgramController.programStart();
        * */
    }

    public int orderWithProductId(ProductService productService) throws IOException {
        String userInputProductId = null;
        while(true){
            userInputProductId = br.readLine();
            if(userInputProductId.isEmpty()) {
                return 0;
            }
            try{
                ValidateLogic.validateIsNumber(userInputProductId);
                ValidateLogic.validateProductId(userInputProductId, productService);
                break;
            }catch(UserException exception){
                System.out.println(exception.getMessage());
            }
        }
        return Integer.parseInt(userInputProductId);
    }
}