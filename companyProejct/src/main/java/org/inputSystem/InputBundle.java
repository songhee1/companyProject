package org.inputSystem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import org.domain.OrderEnum;
import org.exception.UserException;
import org.service.ProductService;
import org.state.IdleState;
import org.validation.ValidateLogic;

public class InputBundle {
    public InputBundle(){}
    //Scanner가 더 좋다! 궁금한점:그런데 장점이 더 많은건 BufferedReader 아닌가요??
    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//    public String orderOrQuitCommand() throws IOException {
//        //넘어가기
//        String userInputOrderOrQuitCommand = IdleState.getString(br);
//
//        return userInputOrderOrQuitCommand;
//    }
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
