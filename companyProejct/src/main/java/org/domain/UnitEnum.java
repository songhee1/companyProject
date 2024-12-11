package org.domain;

public enum UnitEnum {
    UNIT_COUNT_OF_TO_BUY("수량 : "),
    UNIT_CURRENCY_KOREAN("원\n"),
    UNIT_COUNT("개\n"),
    UNIT_COUNT_OF_THOUSAND("%,d");

    private final String unitData;
    UnitEnum(String unitData){
        this.unitData = unitData;
    }

    public String getUnitData() {
        return unitData;
    }
}
