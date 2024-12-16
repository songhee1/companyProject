package org.domain;

public class OrderContext {
    private State state;
    public OrderContext(){
        state = new IdleState();
    }

    public void setState(State state) {
        this.state = state;
    }
    public void handleEvent(OrderEvent event){
        state.handleEvent(this, event);
    }
}
