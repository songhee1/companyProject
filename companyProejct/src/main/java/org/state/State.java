package org.state;

import java.io.BufferedReader;
import java.io.IOException;
import org.domain.fsm.OrderEventEnum;
import org.service.ProductService;
import org.view.OrderView;
import org.view.ReceiptView;

public interface State {
    void handleEvent(OrderContext orderContext, OrderEventEnum event, BufferedReader br, ProductService productService,
        OrderView orderView, ReceiptView receiptView) throws IOException;
}
