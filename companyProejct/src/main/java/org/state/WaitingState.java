package org.state;

import java.io.IOException;
import org.domain.fsm.OrderEventEnum;
import org.outputSystem.OutputBundle;
import org.service.ProductService;
import org.service.ProductServiceImpl;

public class WaitingState implements State{

    @Override
    public void handleEvent(OrderContext context, OrderEventEnum event, ProductService productService, OutputBundle outputBundle) throws IOException {
        switch (event){
            case OrderStartedEvent:
                context.setState(new OrderState());
                System.out.println("order state 진입");

                outputBundle.printProductList(productService);

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
