package org.outputSystem;

import java.util.List;
import java.util.Map;
import org.controller.CalculateController;
import org.data.DataItem;
import org.domain.Product;
import org.domain.ShoppingBasket;
import org.dto.OrderProductDTO;

public class OutputBundle {
    private final String LONG_DASHI = "----------------------------------\n";
    private final String SHORT_DASHI = " - ";
    private final String UNIT_COUNT = "개\n";
    private final String UNIT_CURRENCY_KOREAN = "원\n";

    public void printEnd(){
        System.out.println("고객님의 주문 감사합니다.");
    }
    public void printToOrderProduct(){
        System.out.print("상품번호 : ");
    }
    public void printToOrderProductAmount(){
        System.out.print("수량 : ");
    }

    public void printReceipt(ShoppingBasket basket) {
        StringBuilder sb = new StringBuilder();
        sb.append("주문 내역:\n").append(LONG_DASHI);
        List<OrderProductDTO> list = basket.getList();
        for (OrderProductDTO product : list) {
            sb.append(product.getProductName()).append(SHORT_DASHI).append(product.getOrderAmount()).append(UNIT_COUNT);
        }
        sb.append(LONG_DASHI).append("주문금액: ").append(String.format("%,d", basket.getOrderPrice())).append(UNIT_CURRENCY_KOREAN);
        int deliveryFee = basket.getDeliveryFee();
        if(deliveryFee > 0){
            sb.append("배송비: ").append(String.format("%,d", basket.getDeliveryFee())).append(UNIT_CURRENCY_KOREAN);
        }
        sb.append(LONG_DASHI).append("지불금액: ").append(String.format("%,d", basket.getPaymentAmount())).append(UNIT_CURRENCY_KOREAN).append(LONG_DASHI);
        System.out.println(sb);
    }

    public void printProductList() {
        Map<Integer, Product> productMap = DataItem.getMap();
        StringBuilder sb = new StringBuilder();
        sb.append("상품번호\t상품명\t판매가격\t재고수\n");

        for (Map.Entry<Integer, Product> entry : productMap.entrySet()) {
            Product product = entry.getValue();
            sb.append(entry.getKey()).append("\t").append(product.getName()).append("\t")
                .append(product.getPrice()).append("\t").append(product.getStockAmount()).append("\n");
        }
        System.out.println(sb);
    }
}
