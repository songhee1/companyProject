package org.outputSystem;

import java.util.List;
import java.util.Map;
import org.controller.CalculateController;
import org.data.DataItem;
import org.domain.OrderEnum;
import org.domain.Product;
import org.domain.ShoppingBasket;
import org.domain.UnitEnum;
import org.dto.OrderProductDTO;

public class OutputBundle {
    private final String LONG_DASHI = "----------------------------------\n";
    private final String SHORT_DASHI = " - ";

    public void printEnd(){
        System.out.println(OrderEnum.ORDER_END.getOrderData());
    }
    public void printToOrderProduct(){
        System.out.print(OrderEnum.ORDER_NUMBER_OF_PRODUCT.getOrderData());
    }
    public void printToOrderProductAmount(){
        System.out.print(UnitEnum.UNIT_COUNT_OF_TO_BUY.getUnitData());
    }

    public void printReceipt(ShoppingBasket basket) {
        StringBuilder sb = new StringBuilder();
        sb.append(OrderEnum.ORDER_HISTORY_OF_ORDER.getOrderData()).append(LONG_DASHI);
        List<OrderProductDTO> list = basket.getList();
        for (OrderProductDTO product : list) {
            sb.append(product.getProductName()).append(SHORT_DASHI).append(product.getOrderAmount()).append(UnitEnum.UNIT_COUNT.getUnitData());
        }
        sb.append(LONG_DASHI).append(OrderEnum.ORDER_PRICE_OR_ORDER.getOrderData()).append(String.format(UnitEnum.UNIT_COUNT_OF_THOUSAND.getUnitData(), basket.getOrderPrice())).append(UnitEnum.UNIT_CURRENCY_KOREAN.getUnitData());
        int deliveryFee = basket.getDeliveryFee();
        if(deliveryFee > 0){
            sb.append(OrderEnum.ORDER_DELIVERY_FEE.getOrderData()).append(String.format(UnitEnum.UNIT_COUNT_OF_THOUSAND.getUnitData(), basket.getDeliveryFee())).append(UnitEnum.UNIT_CURRENCY_KOREAN.getUnitData());
        }
        sb.append(LONG_DASHI).append(OrderEnum.ORDER_PAYMENT_OF_AMOUNT.getOrderData()).append(String.format(UnitEnum.UNIT_COUNT_OF_THOUSAND.getUnitData(), basket.getPaymentAmount())).append(UnitEnum.UNIT_CURRENCY_KOREAN.getUnitData()).append(LONG_DASHI);
        System.out.println(sb);
    }

    public void printProductList() {
        Map<Integer, Product> productMap = DataItem.getMap();
        StringBuilder sb = new StringBuilder();
        sb.append("상품번호\t\t\t상품명\t\t\t판매가격\t\t\t재고수\n");

        for (Map.Entry<Integer, Product> entry : productMap.entrySet()) {
            Product product = entry.getValue();
            sb.append(entry.getKey()).append("\t").append(product.getName()).append("\t")
                .append(product.getPrice()).append("\t").append(product.getStockAmount()).append("\n");
        }
        System.out.println(sb);
    }
}
