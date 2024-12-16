package org.state;

import java.io.IOException;
import org.domain.fsm.OrderEventEnum;
import org.outputSystem.OutputBundle;
import org.service.ProductService;

public interface State {
    void handleEvent(OrderContext context, OrderEventEnum event, ProductService productService, OutputBundle outputBundle) throws IOException;

    void handleEvent(OrderContext orderContext, OrderEventEnum event);
}
