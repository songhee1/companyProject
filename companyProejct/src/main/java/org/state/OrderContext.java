package org.state;

import java.io.IOException;
import org.domain.ShoppingBasket;
import org.domain.fsm.OrderEventEnum;
import org.outputSystem.OutputBundle;
import org.service.ProductService;
import org.service.ProductServiceImpl;

public class OrderContext {
    private State state;
    private boolean command;
    private ShoppingBasket basket;
    public OrderContext(){
        state = new IdleState();
    }
    public void setState(State state) {
        this.state = state;
    }
    public void setCommand(boolean command) {
        this.command = command;
    }

    public void setBasket(ShoppingBasket basket) {
        this.basket = basket;
    }

    public ShoppingBasket getBasket() {
        return basket;
    }

    public boolean getCommand() {
        return command;
    }

    public void handleEvent(OrderEventEnum event) throws IOException {
        state.handleEvent(this, event);
    }
}
