package org.program;

import java.io.IOException;
import org.domain.OrderEnum;
import org.domain.ShoppingBasket;
import org.domain.fsm.OrderEventEnum;
import org.exception.UserException;
import org.inputSystem.InputBundle;
import org.outputSystem.OutputBundle;
import org.service.ProductService;
import org.state.OrderContext;

public class OrderProgram {
    private final OutputBundle outputBundle;
    private final InputBundle inputBundle;
    private final ProductService productService;
    private final OrderContext orderContext;

    public OrderProgram(OutputBundle outputBundle, InputBundle inputBundle,
        ProductService productService, OrderContext orderorderContext) {
        this.outputBundle = outputBundle;
        this.inputBundle = inputBundle;
        this.productService = productService;
        this.orderContext = orderorderContext;
    }

    public void programStart_new() throws IOException {
        orderContext.handleEvent(OrderEventEnum.InitialWaitingEvent);
        /** 입력값 : o ➡️ OrderStartedEvent 발생
         *  입력값 : q ➡️ QuitEvent 발생
         *  ✅ orderContext.handleEvent(OrderEventEnum.<선택한 이벤트명>);
         */

        String command = orderContext.getCommand();
        if(command.equals(OrderEnum.ORDER.getOrderData())){
            orderContext.handleEvent(OrderEventEnum.OrderStartedEvent);
            orderContext.handleEvent(OrderEventEnum.SelectProductEvent);
            int productId = orderWithProductId();
            if(productId == 0){
//                break;
            }
            int productAmount = orderWithProductAmount();
            try{
                productService.orderProduct(productId, productAmount);
                productService.addProductToBasket(productId, productAmount, orderContext.getBasket());
            }catch(UserException exception){
                System.out.println(exception.getMessage());
//                isReset = true;
//                break;
            }

        }else if(command.equals(OrderEnum.QUIT.getOrderData())){
            orderContext.handleEvent(OrderEventEnum.QuitEvent);
            orderContext.handleEvent(OrderEventEnum.OrderEndEvent);
        }
    }
    public void programStart() throws IOException {
        boolean isReset = false;
        while(inputBundle.orderOrQuitCommand().equals(OrderEnum.ORDER.getOrderData())){
            // 로직, 아키텍쳐적으로 bad..
            // SOLID 대충 그런 의미..지켜주면 좋다 --OCP에 취약하다, 수정이 쉽고 변경은 최소화필요
            // 핵심 : SHELL 작업 + 재고처리 후 동시성 thread safe..fsm
            outputBundle.printProductList(productService);
            ShoppingBasket basket = new ShoppingBasket();
            isReset = shoppingResetController(isReset, basket);
            if(isReset){
                isReset = false;
                continue;
            }
            CalculateProgram.calculatePaymentAmount(basket);
            outputBundle.printReceipt(basket);
        }
        outputBundle.printEnd();
    }

    private boolean shoppingResetController(boolean isReset, ShoppingBasket basket) throws IOException {
        for(;;){
            int productId = orderWithProductId();
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
        }
        return isReset;
    }

    private int orderWithProductId() throws IOException {
        outputBundle.printToOrderProduct();
        return inputBundle.orderWithProductId(productService);
    }
    private int orderWithProductAmount() throws IOException {
        outputBundle.printToOrderProductAmount();
        return inputBundle.orderWithProductAmount();
    }
}
