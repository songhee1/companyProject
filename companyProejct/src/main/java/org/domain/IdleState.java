package org.domain;

public class IdleState implements State{

    @Override
    public void handleEvent(OrderContext context, OrderEvent event) {
        switch (event){
            case ORDER:
                context.setState(new OrderState());
                System.out.println("orderstate 진입");
                break;
            case QUIT:
                context.setState(new QuitState());
                System.out.println("quitstate 진입");
                break;
            default:
                System.out.println("invalid event for idle state");
        }
    }
}
