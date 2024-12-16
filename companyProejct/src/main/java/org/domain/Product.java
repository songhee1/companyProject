package org.domain;

import com.google.common.collect.ImmutableMap.Builder;

public class Product {
    private String name;
    private int price;
    private int stockAmount;

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getStockAmount() {
        return stockAmount;
    }
    public void setStockAmount(int stockAmount){
        this.stockAmount = stockAmount;
    }

    public void reduceStockAmount(int count){
        stockAmount -= count;
        if(stockAmount <0){
            stockAmount = 0;
        }
    }

    public Product(String name, int price) {
        this.name = name;
        this.price = price;
    }
}
