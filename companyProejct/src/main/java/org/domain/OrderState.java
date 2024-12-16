package org.domain;

public class OrderState implements State{

    @Override
    public void handleEvent(OrderContext context, OrderEvent event) {
        switch (event){
            case SELECT_PRODUCT:
                context.setState(new ActiveProduct());
                System.out.println("activeProduct state 진입");
                break;
            default:
                System.out.println("invalid event for idle state");
        }
    }
}
