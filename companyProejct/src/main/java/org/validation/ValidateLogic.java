package org.validation;

import org.data.DataItem;
import org.domain.Product;
import org.exception.UserException;

public class ValidateLogic {
    private static final String ORDER_AMOUNT_IS_BIGGER_THAN_STOCK_AMOUNT = "SoldOutException 발생. 주문한 상품량이 재고량보다 큽니다.";
    public static void validateOrderAmount(int productId, int orderAmount) throws UserException {
        Product product = DataItem.getMap().get(productId);
        if(product.getStockAmount()<orderAmount){
            throw new UserException(ORDER_AMOUNT_IS_BIGGER_THAN_STOCK_AMOUNT);
        }
    }
}
