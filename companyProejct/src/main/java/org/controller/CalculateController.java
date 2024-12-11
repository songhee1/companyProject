package org.controller;

import org.domain.ShoppingBasket;

public class CalculateController {
    private static final int MINIMUM_ORDER_PRICE = 50000;
    private static final int DELIVERY_FEE = 2500;
    public static void calculatePaymentAmount(ShoppingBasket basket){
        int orderPrice = basket.getOrderPrice();
        int deliveryFee = calculateDeliveryFee(orderPrice);
        basket.setDeliveryFee(deliveryFee);
        basket.setPaymentAmount(orderPrice+deliveryFee);
    }

    private static int calculateDeliveryFee(int orderPrice) {
        if(orderPrice >=MINIMUM_ORDER_PRICE){
            return 0;
        }else{
            return DELIVERY_FEE;
        }
    }
}
