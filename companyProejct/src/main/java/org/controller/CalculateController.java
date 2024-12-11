package org.controller;

import org.domain.DigitEnum;
import org.domain.ShoppingBasket;

public class CalculateController {
    public static void calculatePaymentAmount(ShoppingBasket basket){
        int orderPrice = basket.getOrderPrice();
        int deliveryFee = calculateDeliveryFee(orderPrice);
        basket.setDeliveryFee(deliveryFee);
        basket.setPaymentAmount(orderPrice+deliveryFee);
    }

    private static int calculateDeliveryFee(int orderPrice) {
        if(orderPrice >= DigitEnum.DIGIT_MINIMUM_ORDER_PRICE.getNum()){
            return 0;
        }else{
            return DigitEnum.DIGIT_DELIVERY_FEE.getNum();
        }
    }

    public CalculateController() {
    }


}
