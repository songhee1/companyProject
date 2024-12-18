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
import org.view.StartView;

public class IdleState implements State{
    private String userInputOrderOrQuitCommand = null;
    @Override
    public void handleEvent(OrderContext context, OrderEventEnum event) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        switch(event){
            case InitialWaitingEvent:
                context.setState(new WaitingState());
                System.out.println("waiting state 진입");

                getString(br);
                context.setCommand(checkUserInputOrderOrQuit(userInputOrderOrQuitCommand));

                break;
            default:
                System.out.println("invalid event for idle state");
                break;
        }
    }
    public void getString(BufferedReader br) throws IOException {
        while(readRightUserInput(br)){

        }
    }
    public boolean readRightUserInput(BufferedReader br) throws IOException {
        userInputOrderOrQuitCommand = br.readLine();
        try{
            ValidateLogic.validateOrderOrQuitCommand(userInputOrderOrQuitCommand);
            return true;
        }catch(UserException exception){
            System.out.println(exception.getMessage());
        }
        return false;
    }

    public boolean checkUserInputOrderOrQuit(String input){
        return input.equals(OrderEnum.ORDER.getOrderData());
    }
}
