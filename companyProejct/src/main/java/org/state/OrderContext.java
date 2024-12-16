package org.state;

import org.domain.fsm.OrderEventEnum;

public class OrderContext {
    private State state;
    public OrderContext(){
        state = new IdleState();
    }

    public void setState(State state) {
        this.state = state;
    }
    public void handleEvent(OrderEventEnum event){
        state.handleEvent(this, event);
    }
}
