package org.validation;

import org.data.DataItem;
import org.domain.Product;
import org.exception.UserException;

public class StockAmountAndOrderAmount {
    public static void orderAmountValidation(int productId, int orderAmount) throws UserException {
        Product product = DataItem.getMap().get(productId);
        if(product.getStockAmount()<orderAmount){
            throw new UserException("SoldOutE")
        }
    }
}
