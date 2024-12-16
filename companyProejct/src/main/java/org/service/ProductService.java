package org.service;

import com.google.common.collect.ImmutableMap;
import java.io.IOException;
import org.domain.Product;
import org.domain.ShoppingBasket;
import org.exception.UserException;

public interface ProductService {
    public void orderProduct(int productId, int productAmount) throws UserException, IOException;
    public void addProductToBasket(int productId, int productAmount, ShoppingBasket basket)
        throws IOException;
    public ImmutableMap<Integer, Product> getAllProductEntries() throws IOException;
    public boolean hasProductId(Integer productId) throws IOException;
}
