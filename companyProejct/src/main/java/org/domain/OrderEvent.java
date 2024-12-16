package org.domain;

public enum OrderEvent {
    OrderStartedEvent,
    QuitEvent,
    SelectProductEvent,
    SelectAmountEvent,
    ShortOfGoodsInStockEvent,
    OrderRejectedEvent,
    ReceiptsIssuedEvent,
    OrderEndEvent,
    OrderInitializedEvent
}
