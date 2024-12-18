package org.state;

import java.io.BufferedReader;
import java.io.IOException;
import org.domain.fsm.OrderEventEnum;
import org.dto.PreOrderProductDTO;
import org.service.ProductService;

public class ActiveState implements State {
    @Override
    public void handleEvent(OrderContext context, OrderEventEnum event, BufferedReader br, ProductService productService)
        throws IOException {

        switch (event) {
            case ShortOfGoodsInStockEvent:
                context.setState(new BlockedState());
                System.out.println("active amount state 진입");
                break;
            case OrderRejectedEvent:
                context.setState(new InactiveState());
                System.out.println("inactive state 진입");
                break;
            case ReceiptsIssuedEvent:
                context.setState(new CompletedState());
                System.out.println("completed state 지입");
            default:
                System.out.println("invalid event for idle state");
        }
    }
}
