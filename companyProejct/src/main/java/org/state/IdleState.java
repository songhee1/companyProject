package org.state;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import org.domain.OrderEnum;
import org.domain.fsm.OrderEventEnum;
import org.exception.UserException;
import org.service.ProductService;
import org.validation.ValidateLogic;
import org.view.EndView;
import org.view.OrderView;
import org.view.ReceiptView;
import org.view.StartView;

public class IdleState implements State{
    private String userInputOrderOrQuitCommand = null;
    @Override
    public void handleEvent(OrderContext context, OrderEventEnum event, BufferedReader br, ProductService productService,
        OrderView orderView, ReceiptView receiptView, StartView startView, EndView endView) throws IOException {
        switch(event){
            case InitialWaitingEvent:
                context.setState(new WaitingState());
                System.out.println("waiting state 진입");

                //주문/종료 입력
                getUserInputOrderOrQuitCommand(br, startView);
                context.setCommand(checkUserInputOrderOrQuit(userInputOrderOrQuitCommand));

                break;
            default:
                System.out.println("invalid event for idle! state");
                break;
        }
    }
    public void getUserInputOrderOrQuitCommand(BufferedReader br, StartView startView) throws IOException {
        while(readRightUserInput(br, startView)){

        }
    }
    public boolean readRightUserInput(BufferedReader br, StartView startView) throws IOException {
        startView.displayStartMessage();
        userInputOrderOrQuitCommand = br.readLine();
        try{
            ValidateLogic.validateOrderOrQuitCommand(userInputOrderOrQuitCommand);
            return false;
        }catch(UserException exception){
            System.out.println(exception.getMessage());
        }
        return true;
    }

    public boolean checkUserInputOrderOrQuit(String input){
        return input.equals(OrderEnum.QUIT.getOrderData());
    }
}
