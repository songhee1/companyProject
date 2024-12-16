package org.state;

import org.domain.fsm.OrderEventEnum;

public class BlockedState implements State{

    @Override
    public void handleEvent(OrderContext context, OrderEventEnum event) {
        switch (event){
            case OrderInitializedEvent:
                context.setState(new OrderState());
                System.out.println("order state 진입");
                break;
            default:
                System.out.println("invalid event for idle state");
        }
    }
}
