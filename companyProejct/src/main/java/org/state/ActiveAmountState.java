package org.state;

import org.domain.fsm.OrderEventEnum;

public class ActiveAmountState implements State{

    @Override
    public void handleEvent(OrderContext context, OrderEventEnum event) {
        switch (event){
            case SelectProductEvent:
                context.setState(new ActiveProductState());
                System.out.println("active product state 진입");
                break;
            case ShortOfGoodsInStockEvent:
                context.setState(new BlockedState());
                System.out.println("blocked state 진입");
                break;
            case ReceiptsIssuedEvent:
                context.setState(new CompletedState());
                System.out.println("completed state 진입");
                break;
            default:
                System.out.println("invalid event for idle state");
        }
    }
}
