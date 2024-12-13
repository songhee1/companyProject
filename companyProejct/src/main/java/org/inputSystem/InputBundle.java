package org.inputSystem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import jdk.internal.util.xml.impl.Input;
import org.domain.OrderEnum;
import org.exception.UserException;
import org.repository.ProductDAO;
import org.service.ProductService;
import org.validation.ValidateLogic;

public class InputBundle {
    public InputBundle(){}
    //Scanner가 더 좋다!
    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public String orderOrQuitCommand() throws IOException {
        //넘어가기
        String userInputOrderOrQuitCommand = null;
        while(true){
            System.out.print(OrderEnum.ORDER_START.getOrderData());
            userInputOrderOrQuitCommand = br.readLine();
            try{
                ValidateLogic.validateOrderOrQuitCommand(userInputOrderOrQuitCommand);
                break;
            }catch(UserException exception){
                System.out.println(exception.getMessage());
            }
        }

        return userInputOrderOrQuitCommand;
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
    public int orderWithProductAmount() throws IOException {
        String userInputProductAmount = null;
        while (true) {
            userInputProductAmount = br.readLine();
            try {
                ValidateLogic.validateIsNumber(userInputProductAmount);
                break;
            } catch (UserException exception) {
                System.out.println(exception.getMessage());
            }
        }
        return Integer.parseInt(userInputProductAmount);
    }
}
