package org.domain;

public class Product {
    private int id;
    private String name;
    private int price;
    private int stockAmount;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getStockAmount() {
        return stockAmount;
    }

    public Product(String name, int price, int stockAmount) {
        this.name = name;
        this.price = price;
        this.stockAmount = stockAmount;
    }
    public void reduceStockAmount(int count){
        stockAmount -= count;
        if(stockAmount <0){
            stockAmount = 0;
        }
    }
}
