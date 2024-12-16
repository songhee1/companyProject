package org.domain;

public class QuitState implements State{

    @Override
    public void handleEvent(OrderContext context, OrderEvent event) {
        switch (event){
            case END:
                context.setState(new ActiveProduct());
                System.out.println("activeProduct state 진입");
                break;
            default:
                System.out.println("invalid event for idle state");
        }
    }
}
