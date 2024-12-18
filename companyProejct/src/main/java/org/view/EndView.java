package org.view;

import org.domain.OrderEnum;

public class EndView {
    public void displayEnd(){
        System.out.println(OrderEnum.ORDER_END.getOrderData());
    }
}
