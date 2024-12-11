package org.domain;

public enum OrderEnum {
    ORDER_START("입력(o[order]: 주문, q[quit]: 종료) : "),
    ORDER("o"),
    ORDER_END("고객님의 주문 감사합니다."),
    ORDER_NUMBER_OF_PRODUCT("상품번호 : "),
    ORDER_HISTORY_OF_ORDER("주문 내역:\n"),
    ORDER_PRICE_OR_ORDER("주문금액: "),
    ORDER_DELIVERY_FEE("배송비: "),
    ORDER_PAYMENT_OF_AMOUNT("지불금액: ");
    private final String orderData;
    OrderEnum(String orderData){
        this.orderData = orderData;
    }

    public String getOrderData() {
        return orderData;
    }
}
