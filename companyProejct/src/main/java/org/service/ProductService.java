package org.service;

import java.util.Map;
import org.domain.Product;
import org.domain.ShoppingBasket;
import org.exception.UserException;

public interface ProductService {
    public void orderProduct(int productId, int productAmount) throws UserException;
    public void addProductToBasket(int productId, int productAmount, ShoppingBasket basket);
    public Map<Integer, Product> getAllProductEntries();
}
