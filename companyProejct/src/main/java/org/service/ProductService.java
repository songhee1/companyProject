package org.service;

import org.domain.ShoppingBasket;
import org.exception.UserException;

public interface ProductService {
    void orderProduct(int productId, int productAmount) throws UserException;
    void addProductToBasket(int productId, int productAmount, ShoppingBasket basket);
}
