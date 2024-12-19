package org.state;

import java.io.BufferedReader;
import java.io.IOException;
import org.domain.fsm.OrderEventEnum;
import org.exception.UserException;
import org.service.ProductService;
import org.validation.ValidateLogic;
import org.view.EndView;
import org.view.OrderView;
import org.view.ReceiptView;
import org.view.StartView;

public class OrderState implements State{
    private String userInputProductId;
    private String userInputProductAmount;
    @Override
    public void handleEvent(OrderContext context, OrderEventEnum event, BufferedReader br, ProductService productService,
        OrderView orderView, ReceiptView receiptView, StartView startView, EndView endView)
        throws IOException {
        switch (event){
            case SelectProductEvent:

                // 상품번호 입력
                getOrderWithProductId(br, productService, orderView);
                if(userInputProductId.isEmpty()){
                    context.setCommand(true);
                    System.out.println("탈출함");
                    context.setState(new ActiveState());
                    System.out.println("active state 진입");
                    break;
                }
                getOrderWithProductAmount(br, orderView);
                try {
                    productService.orderProduct(Integer.parseInt(userInputProductId),
                        Integer.parseInt(userInputProductAmount), context.getBasket());
                }catch(UserException exception){
                    System.out.println(exception.getMessage());
                    context.setState(new BlockedState());
                }

                break;
            default:
                System.out.println("invalid event for order state");
        }
    }

    private void getOrderWithProductId(
        BufferedReader br, ProductService productService, OrderView orderView) throws IOException {
        while(readRightUserInput(br, productService, orderView)){

        }
    }

    private boolean readRightUserInput(BufferedReader br, ProductService productService, OrderView orderView) throws IOException {
        orderView.displayToOrderProductId();
        userInputProductId = br.readLine();
        if(userInputProductId.isEmpty()) return false;

        try{
            ValidateLogic.validateIsNumber(userInputProductId);
            ValidateLogic.validateProductId(userInputProductId, productService);
            return false;
        }catch(UserException exception){
            System.out.println(exception.getMessage());
        }
        return true;
    }
    private void getOrderWithProductAmount(BufferedReader br, OrderView orderView) throws IOException {
        while(readRightUserInputAmount(br, orderView)){

        }
    }

    private boolean readRightUserInputAmount(BufferedReader br, OrderView orderView) throws IOException {
        orderView.displayToOrderProductAmount();
        userInputProductAmount = br.readLine();
        try{
            ValidateLogic.validateIsNumber(userInputProductAmount);
            return false;
        }catch(UserException exception){
            System.out.println(exception.getMessage());
        }
        return true;
    }

}
