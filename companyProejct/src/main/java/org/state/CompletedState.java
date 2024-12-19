package org.state;

import java.io.BufferedReader;
import org.domain.fsm.OrderEventEnum;
import org.service.ProductService;
import org.view.EndView;
import org.view.OrderView;
import org.view.ReceiptView;
import org.view.StartView;

public class CompletedState implements State{

    @Override
    public void handleEvent(OrderContext context, OrderEventEnum event, BufferedReader br, ProductService productService,
        OrderView orderView, ReceiptView receiptView, StartView startView, EndView endView) {
        switch (event){
            case OrderEndEvent:

                break;
            default:
                System.out.println("invalid event for completed state");
        }
    }
}
