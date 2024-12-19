package org.view;

import org.domain.OrderEnum;
import org.domain.UnitEnum;

public class OrderView {
    public void displayToOrderProductId(){
        System.out.print(OrderEnum.ORDER_NUMBER_OF_PRODUCT.getOrderData());
    }
    public void displayToOrderProductAmount(){
        System.out.print(UnitEnum.UNIT_COUNT_OF_TO_BUY.getUnitData());
    }
}
