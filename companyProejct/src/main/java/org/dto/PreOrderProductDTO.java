package org.dto;

public class PreOrderProductDTO {
    private int productId;
    private int productAmount;

    public PreOrderProductDTO(int productId, int productAmount) {
        this.productId = productId;
        this.productAmount = productAmount;
    }

    public int getProductId() {
        return productId;
    }

    public int getProductAmount() {
        return productAmount;
    }
}
