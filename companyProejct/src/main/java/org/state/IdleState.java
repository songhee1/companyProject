package org.state;

import org.domain.fsm.OrderEventEnum;

public class IdleState implements State{

    @Override
    public void handleEvent(OrderContext context, OrderEventEnum event) {
        switch (event){
            case OrderStartedEvent:
                context.setState(new OrderState());
                System.out.println("order state 진입");
                break;
            case QuitEvent:
                context.setState(new QuitState());
                System.out.println("quitstate 진입");
                break;
            default:
                System.out.println("invalid event for idle state");
        }
    }
}
