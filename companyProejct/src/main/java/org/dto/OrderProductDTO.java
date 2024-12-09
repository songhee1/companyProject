package org.dto;

public class OrderProductDTO {
    private int productName;
    private int orderAmount;
    private int productPrice;

    public int getProductName() {
        return productName;
    }

    public int getOrderAmount() {
        return orderAmount;
    }

    public int getProductPrice() {
        return productPrice;
    }

    public OrderProductDTO(int productName, int orderAmount, int productPrice) {
        this.productName = productName;
        this.orderAmount = orderAmount;
        this.productPrice = productPrice;
    }
}
