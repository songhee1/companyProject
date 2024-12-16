package org.run;

import java.io.IOException;
import org.data.Data;
import org.domain.OrderEnum;
import org.domain.ShoppingBasket;
import org.domain.fsm.OrderEventEnum;
import org.exception.UserException;
import org.inputSystem.InputBundle;
import org.outputSystem.OutputBundle;
import org.program.OrderProgram;
import org.service.ProductService;
import org.service.ProductServiceImpl;
import org.state.OrderContext;
import org.state.OrderState;
import org.validation.ValidateLogic;

public class Main {
    public static void main(String[] args) throws IOException{

        Data.getItems();
        OrderProgram orderProgram = new OrderProgram(
        OutputBundle.getOutputBundle(),
        new InputBundle(),
        new ProductServiceImpl(),
        new OrderContext()
        );


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