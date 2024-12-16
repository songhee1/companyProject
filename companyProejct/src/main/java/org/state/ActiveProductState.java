package org.state;

import org.domain.fsm.OrderEventEnum;

public class ActiveProductState implements State{

    @Override
    public void handleEvent(OrderContext context, OrderEventEnum event) {
        switch (event){
            case SelectAmountEvent:
                context.setState(new ActiveAmountState());
                System.out.println("active amount state 진입");
                break;
            case OrderRejectedEvent:
                context.setState(new InactiveState());
                System.out.println("inactive state 진입");
                break;
            default:
                System.out.println("invalid event for idle state");
        }
    }
}
