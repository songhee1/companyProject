package org.state;

import org.domain.OrderEnum;
import org.domain.fsm.OrderEventEnum;

public class QuitState implements State{

    @Override
    public void handleEvent(OrderContext context, OrderEventEnum event) {
        switch (event){
            case OrderEndEvent:
                System.out.println(OrderEnum.ORDER_END.getOrderData());
                break;
            default:
                System.out.println("invalid event for idle state");
        }
    }
}
