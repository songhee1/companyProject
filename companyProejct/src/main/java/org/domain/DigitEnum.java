package org.domain;

public enum DigitEnum {
    DIGIT_MINIMUM_ORDER_PRICE(50000),
    DIGIT_DELIVERY_FEE(2500);
    private final int num;

    DigitEnum(int num) {
        this.num = num;
    }

    public int getNum() {
        return num;
    }
}
