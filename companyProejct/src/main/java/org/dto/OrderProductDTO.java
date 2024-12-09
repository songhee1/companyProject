package org.dto;

public class OrderProductDTO {
    private String productName;
    private int orderAmount;
    private int productPrice;

    public String getProductName() {
        return productName;
    }

    public int getOrderAmount() {
        return orderAmount;
    }

    public int getProductPrice() {
        return productPrice;
    }

    public OrderProductDTO(String productName, int orderAmount, int productPrice) {
        this.productName = productName;
        this.orderAmount = orderAmount;
        this.productPrice = productPrice;
    }
}
