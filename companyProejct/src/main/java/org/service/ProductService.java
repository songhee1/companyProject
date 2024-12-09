package org.service;

import org.data.DataItem;
import org.domain.Product;
import org.domain.ShoppingBasket;
import org.dto.OrderProductDTO;
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
    public void addProductToBasket(int productId, int productAmount, ShoppingBasket basket){
        Product product = DataItem.getMap().get(productId);
        basket.addProduct(new OrderProductDTO(product.getName(), productAmount, productAmount*product.getPrice()));
    }
}
