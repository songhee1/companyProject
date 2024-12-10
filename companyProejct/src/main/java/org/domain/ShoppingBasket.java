package org.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.dto.OrderProductDTO;

public class ShoppingBasket {
    private List<OrderProductDTO> list = new ArrayList<>();
    private int orderPrice;
    private int deliveryFee;
    private int paymentAmount;

    public List<OrderProductDTO> getList() {
        return list;
    }

    public int getOrderPrice() {
        return orderPrice;
    }

    public void setDeliveryFee(int deliveryFee) {
        this.deliveryFee = deliveryFee;
    }

    public int getDeliveryFee() {
        return deliveryFee;
    }

    public void addProduct(OrderProductDTO orderProductDTO) {
        this.list.add(orderProductDTO);
        orderPrice += orderProductDTO.getProductPrice();
    }

    public void setPaymentAmount(int paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public int getPaymentAmount() {
        return paymentAmount;
    }
}
