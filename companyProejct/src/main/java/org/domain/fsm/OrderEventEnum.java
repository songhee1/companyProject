package org.domain.fsm;

import java.awt.desktop.QuitEvent;

public enum OrderEventEnum {
    InitialWaitingEvent,
    OrderStartedEvent,
    QuitEvent,
    SelectProductEvent,
    ShortOfGoodsInStockEvent,
    OrderRejectedEvent,
    ReceiptsIssuedEvent,
    OrderEndEvent,
    OrderInitializedEvent,
    StateInitializedEvent
}
