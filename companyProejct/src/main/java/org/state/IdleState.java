package org.state;

import org.domain.fsm.OrderEventEnum;

public class IdleState implements State{

    @Override
    public void handleEvent(OrderContext context, OrderEventEnum event) {
        switch (event){
            case InitialWaitingEvent:

                context.setState(new WaitingState());
                System.out.println("waiting state 진입");
                break;
            default:
                System.out.println("invalid event for idle state");
        }
    }
}
