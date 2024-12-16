package org.state;

import org.domain.fsm.OrderEventEnum;

public class OrderState implements State{

    @Override
    public void handleEvent(OrderContext context, OrderEventEnum event) {
        switch (event){
            case SelectProductEvent:
                context.setState(new ActiveProductState());
                System.out.println("activeProduct state 진입");
                break;
            default:
                System.out.println("invalid event for idle state");
        }
    }
}
