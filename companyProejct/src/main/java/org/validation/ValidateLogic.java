package org.validation;

import org.data.DataItem;
import org.domain.Product;
import org.exception.UserException;

public class ValidateLogic {
    private static final String ORDER_AMOUNT_IS_BIGGER_THAN_STOCK_AMOUNT = "SoldOutException 발생. 주문한 상품량이 재고량보다 큽니다.";
    private static final String ORDER_SIGN_IS_WRONG = "입력한 값은 o 또는 q가 아닙니다.";
    public static void validateOrderAmount(int productId, int orderAmount) throws UserException {
        Product product = DataItem.getMap().get(productId);
        if(product.getStockAmount()<orderAmount){
            throw new UserException(ORDER_AMOUNT_IS_BIGGER_THAN_STOCK_AMOUNT);
        }
    }
    public static void validateOrderSign(String order) throws UserException {
        if(!order.equals("o") && !order.equals("q")){
            throw new UserException(ORDER_SIGN_IS_WRONG);
        }
    }
}
