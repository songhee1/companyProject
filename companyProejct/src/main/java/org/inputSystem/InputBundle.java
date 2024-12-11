package org.inputSystem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import jdk.internal.util.xml.impl.Input;
import org.domain.OrderEnum;
import org.exception.UserException;
import org.validation.ValidateLogic;

public class InputBundle {
    public InputBundle(){}

    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public String orderOrQuitCommand() throws IOException {
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
    public int orderProduct() throws IOException {
        String userInputProductId = br.readLine();
        if(userInputProductId.isEmpty()){
            return 0;
        }else{
            return Integer.parseInt(userInputProductId);
        }
    }
}
