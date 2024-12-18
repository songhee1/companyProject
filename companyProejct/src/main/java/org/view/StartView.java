package org.view;

import org.domain.OrderEnum;

public class StartView {
    public void displayStartMessage(){
        System.out.print(OrderEnum.ORDER_START.getOrderData());
    }
}
