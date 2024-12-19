package org.state;

import java.io.BufferedReader;
import java.io.IOException;
import org.domain.fsm.OrderEventEnum;
import org.service.ProductService;
import org.view.EndView;
import org.view.OrderView;
import org.view.ReceiptView;
import org.view.StartView;

public class QuitState implements State {
    @Override
    public void handleEvent(OrderContext context, OrderEventEnum event, BufferedReader br, ProductService productService,
        OrderView orderView, ReceiptView receiptView, StartView startView, EndView endView)
        throws IOException {

        switch (event) {
            case QuitEvent:
                context.setState(new QuitState());
                System.out.println("quit state 진입");
                endView.displayEnd();

                break;

            default:
                System.out.println("invalid event for quit state");
        }
    }
}
