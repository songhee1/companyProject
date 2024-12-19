package org.view;

import java.util.List;
import org.domain.OrderEnum;
import org.domain.ShoppingBasket;
import org.domain.UnitEnum;
import org.dto.OrderProductDTO;

public class ReceiptView {
    private static final String LONG_HYPHEN = "----------------------------------\n";
    private static final String SHORT_HYPHEN = " - ";
    public void displayReceipt(ShoppingBasket basket) {
        StringBuilder sb = new StringBuilder();
        sb.append(OrderEnum.ORDER_HISTORY_OF_ORDER.getOrderData()).append(LONG_HYPHEN);

        displayOrderedProducts(basket, sb);
        displayTotalOrderPrice(basket, sb);
        displayDeliveryFee(basket, sb);
        displayTotalPrice(basket, sb);

        System.out.println(sb);
    }

    private static void displayTotalPrice(ShoppingBasket basket, StringBuilder sb) {
        sb.append(LONG_HYPHEN)
          .append(OrderEnum.ORDER_PAYMENT_OF_AMOUNT.getOrderData())
          .append(String.format(UnitEnum.UNIT_COUNT_OF_THOUSAND.getUnitData(), basket.getPaymentAmount()))
          .append(UnitEnum.UNIT_CURRENCY_KOREAN.getUnitData())
          .append(LONG_HYPHEN);
    }

    private static void displayDeliveryFee(ShoppingBasket basket, StringBuilder sb) {
        int deliveryFee = basket.getDeliveryFee();
        if(deliveryFee > 0){
            sb.append(OrderEnum.ORDER_DELIVERY_FEE.getOrderData())
              .append(String.format(UnitEnum.UNIT_COUNT_OF_THOUSAND.getUnitData(), basket.getDeliveryFee()))
              .append(UnitEnum.UNIT_CURRENCY_KOREAN.getUnitData());
        }
    }

    private static void displayTotalOrderPrice(ShoppingBasket basket, StringBuilder sb) {
        sb.append(LONG_HYPHEN)
          .append(OrderEnum.ORDER_PRICE_OR_ORDER.getOrderData())
          .append(String.format(UnitEnum.UNIT_COUNT_OF_THOUSAND.getUnitData(), basket.getOrderPrice()))
          .append(UnitEnum.UNIT_CURRENCY_KOREAN.getUnitData());
    }

    private static void displayOrderedProducts(ShoppingBasket basket, StringBuilder sb) {
        List<OrderProductDTO> list = basket.getList();
        list.forEach(product->
            sb.append(product.getProductName())
              .append(SHORT_HYPHEN)
              .append(product.getOrderAmount())
              .append(UnitEnum.UNIT_COUNT.getUnitData()));
    }
}
