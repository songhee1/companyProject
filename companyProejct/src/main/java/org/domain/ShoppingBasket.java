package org.domain;

import java.util.ArrayList;
import java.util.List;

public class ShoppingBasket {
    private List<Product> list = new ArrayList<>();
    private int orderPrice;
//    private int deliveryCharge;
//    private int paymentAmount;
//    private final int MINIMUM_AMOUNT = 50000;
//    private final int DELIVERY_FEE = 2500;

    public List<Product> getList() {
        return list;
    }

    public int getOrderPrice() {
        return orderPrice;
    }

    public void addProduct(Product product) {
        this.list.add(product);
        orderPrice += product.getPrice();
    }

}
