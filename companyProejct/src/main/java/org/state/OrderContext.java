package org.state;

import java.io.BufferedReader;
import java.io.IOException;
import org.domain.ShoppingBasket;
import org.domain.fsm.OrderEventEnum;
import org.service.ProductService;
import org.view.EndView;
import org.view.OrderView;
import org.view.ReceiptView;
import org.view.StartView;

public class OrderContext {
    private State state;
    private boolean command; // 주문 : false, 종료 : true
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

    public State getState() {
        return state;
    }

    public void handleEvent(OrderEventEnum event, BufferedReader br, ProductService productService,
        OrderView orderView, ReceiptView receiptView, StartView startView, EndView endView) throws IOException {
        state.handleEvent(this, event, br, productService, orderView, receiptView, startView, endView);
    }
}
