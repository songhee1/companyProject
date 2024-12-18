package org.run;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import org.data.Data;
import org.inputSystem.InputBundle;
import org.outputSystem.OutputBundle;
import org.program.OrderProgram;
import org.service.ProductServiceImpl;
import org.state.OrderContext;
import org.view.EndView;
import org.view.ProductView;
import org.view.StartView;

public class Main {
    public static void main(String[] args) throws IOException{

        Data.getItems();
        OrderProgram orderProgram = new OrderProgram(
        new BufferedReader(new InputStreamReader(System.in)),
        OutputBundle.getOutputBundle(),
        new StartView(),
        new EndView(),
        new ProductView(),
        new InputBundle(),
        new ProductServiceImpl(),
        new OrderContext()
        );

        orderProgram.programStart_new();
        /**
        * 예전에 작성한 방식
         * OrderProgram orderProgramController = new OrderProgram();
         * orderProgramController.programStart();
        * */
    }

    /*public int orderWithProductId(ProductService productService) throws IOException {
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
    }*/
}