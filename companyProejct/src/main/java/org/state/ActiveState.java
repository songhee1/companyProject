package org.state;

import java.io.BufferedReader;
import java.io.IOException;
import org.domain.fsm.OrderEventEnum;
import org.program.CalculateProgram;
import org.service.ProductService;
import org.view.EndView;
import org.view.OrderView;
import org.view.ReceiptView;
import org.view.StartView;

public class ActiveState implements State {
    @Override
    public void handleEvent(OrderContext context, OrderEventEnum event, BufferedReader br, ProductService productService,
        OrderView orderView, ReceiptView receiptView, StartView startView, EndView endView)
        throws IOException {

        switch (event) {
            case ShortOfGoodsInStockEvent:
                context.setState(new BlockedState());
                System.out.println("active amount state 진입");
                break;

            case ReceiptsIssuedEvent:
                context.setState(new CompletedState());
                System.out.println("completed state 진입");

                CalculateProgram.calculatePaymentAmount(context.getBasket());
                receiptView.displayReceipt(context.getBasket());
                break;

            case SelectProductEvent:
                context.setState(new OrderState());
                System.out.println("order state 진입");
            default:
                System.out.println("invalid event for active state");
        }
    }
}
