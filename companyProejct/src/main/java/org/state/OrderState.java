package org.state;

import java.io.BufferedReader;
import java.io.IOException;
import org.domain.Product;
import org.domain.ShoppingBasket;
import org.domain.fsm.OrderEventEnum;
import org.dto.OrderProductDTO;
import org.dto.PreOrderProductDTO;
import org.exception.UserException;
import org.service.ProductService;
import org.validation.ValidateLogic;

public class OrderState implements State{
    private String userInputProductId;
    private String userInputProductAmount;
    @Override
    public void handleEvent(OrderContext context, OrderEventEnum event, BufferedReader br, ProductService productService)
        throws IOException {
        switch (event){
            case SelectProductEvent:
                context.setState(new ActiveState());
                System.out.println("activeProduct state 진입");

                context.setBasket(new ShoppingBasket());
                // 상품번호 입력
                getOrderWithProductId(br, productService);
                if(userInputProductId.isEmpty()){
                    context.setCommand(true);
                    break;
                }
                getOrderWithProductAmount(br);
                try {
                    productService.orderProduct(Integer.parseInt(userInputProductId),
                        Integer.parseInt(userInputProductAmount), context.getBasket());
                }catch(UserException exception){
                    System.out.println(exception.getMessage());
                }

                break;
            default:
                System.out.println("invalid event for idle state");
        }
    }

    private void getOrderWithProductId(
        BufferedReader br, ProductService productService) throws IOException {
        while(readRightUserInput(br, productService)){

        }
    }

    private boolean readRightUserInput(BufferedReader br, ProductService productService) throws IOException {
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
    private void getOrderWithProductAmount(BufferedReader br) throws IOException {
        while(readRightUserInputAmount(br)){

        }
    }

    private boolean readRightUserInputAmount(BufferedReader br) throws IOException {
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
