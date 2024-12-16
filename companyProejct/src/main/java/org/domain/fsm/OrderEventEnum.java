package org.domain.fsm;

import java.awt.desktop.QuitEvent;

public enum OrderEventEnum {
    InitialWaitingEvent,
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
