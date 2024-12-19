package org.state;

import java.io.BufferedReader;
import java.io.IOException;
import org.domain.fsm.OrderEventEnum;
import org.service.ProductService;
import org.view.OrderView;

public class WaitingState implements State{

    @Override
    public void handleEvent(OrderContext context, OrderEventEnum event, BufferedReader br, ProductService productService,
        OrderView orderView) throws IOException {
        switch (event){
            case OrderStartedEvent:
                context.setState(new OrderState());
                System.out.println("order state 진입");

                break;
            case QuitEvent:
                context.setState(new QuitState());
                System.out.println("quitstate 진입");
                break;
            default:
                System.out.println("invalid event for idle state");
        }
    }
}
