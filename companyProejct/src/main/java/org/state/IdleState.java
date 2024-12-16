package org.state;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;
import org.domain.OrderEnum;
import org.domain.fsm.OrderEventEnum;
import org.exception.UserException;
import org.outputSystem.OutputBundle;
import org.service.ProductService;
import org.validation.ValidateLogic;

public class IdleState implements State{
    @Override
    public void handleEvent(OrderContext context, OrderEventEnum event, ProductService productService, OutputBundle outputBundle) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        switch(event){
            case InitialWaitingEvent:
                context.setState(new WaitingState());
                System.out.println("waiting state 진입");

                String userInputOrderOrQuitCommand = getString(br);
                context.setCommand(userInputOrderOrQuitCommand);
                break;
            default:
                System.out.println("invalid event for idle state");
                break;
        }
    }
    public static String getString(BufferedReader br) throws IOException {
        String userInputOrderOrQuitCommand;
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
}
