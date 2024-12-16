package org.domain.fsm;

public enum OrderEventEnum {
    OrderStartedEvent,
    QuitEvent,
    SelectProductEvent,
    SelectAmountEvent,
    ShortOfGoodsInStockEvent,
    OrderRejectedEvent,
    ReceiptsIssuedEvent,
    OrderEndEvent,
    OrderInitializedEvent,
    StateInitializedEvent
}
