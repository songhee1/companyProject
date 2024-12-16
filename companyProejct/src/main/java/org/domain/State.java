package org.domain;

public interface State {
    void handleEvent(OrderContext context, OrderEvent event);
}
