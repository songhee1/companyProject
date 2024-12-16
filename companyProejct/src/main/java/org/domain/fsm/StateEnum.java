package org.domain.fsm;

public enum StateEnum {
    IDLE,
    ORDER,
    ACTIVE_PRODUCT,
    ACTIVE_AMOUNT,
    INACTIVE,
    BLOCKED,
    WAITING,
    COMPLETED,
    QUIT
}
