package org.state;

import org.domain.fsm.OrderEventEnum;

public class QuitState implements State{

    @Override
    public void handleEvent(OrderContext context, OrderEventEnum event) {
        switch (event){
            case OrderEndEvent:
                break;
            default:
                System.out.println("invalid event for idle state");
        }
    }
}
