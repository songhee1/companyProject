package org.service;

import org.data.DataItem;
import org.domain.Product;
import org.exception.UserException;
import org.validation.ValidateLogic;

public class ProductService {

    public void orderProduct(int productId, int productAmount) throws UserException {
        ValidateLogic.validateOrderAmount(productId, productAmount);
        int stockAmount = DataItem.getMap().get(productId).reduceStockAmount(productAmount);
        if(stockAmount == 0){
            DataItem.getMap().remove(productId);
        }
    }
}
