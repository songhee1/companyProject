package org.service;

import com.google.common.collect.ImmutableMap;
import java.io.IOException;
import org.domain.Product;
import org.domain.ShoppingBasket;
import org.dto.OrderProductDTO;
import org.exception.UserException;
import org.repository.ProductDAO;
import org.repository.ProductDAOImpl;
import org.validation.ValidateLogic;

public class ProductServiceImpl implements ProductService{
    private final ProductDAO productDAO = new ProductDAOImpl();
    @Override
    public void orderProduct(int productId, int productAmount) throws UserException, IOException {
        ValidateLogic.validateOrderAmount(productId, productAmount, productDAO);
        Product product = productDAO.getProduct(productId);
        product.reduceStockAmount(productAmount);

    }
    @Override
    public void addProductToBasket(int productId, int productAmount, ShoppingBasket basket)
        throws IOException {
        Product product = productDAO.getProduct(productId);
        basket.addProduct(new OrderProductDTO(product.getName(), productAmount, productAmount*product.getPrice()));
    }

    @Override
    public ImmutableMap<Integer, Product> getAllProductEntries() throws IOException {
        return productDAO.getAllProductEntries();
    }

    @Override
    public boolean hasProductId(Integer productId) throws IOException {
        return productDAO.hasProductId(productId);
    }
}






