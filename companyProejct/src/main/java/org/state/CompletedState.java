package org.state;

import java.io.BufferedReader;
import org.domain.fsm.OrderEventEnum;
import org.service.ProductService;
import org.view.OrderView;

public class CompletedState implements State{

    @Override
    public void handleEvent(OrderContext context, OrderEventEnum event, BufferedReader br, ProductService productService,
        OrderView orderView) {
        switch (event){
            case OrderEndEvent:

                break;
            default:
                System.out.println("invalid event for idle state");
        }
    }
}
