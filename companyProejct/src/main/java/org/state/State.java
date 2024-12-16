package org.state;

import org.domain.fsm.OrderEventEnum;

public interface State {
    void handleEvent(OrderContext context, OrderEventEnum event);
}
