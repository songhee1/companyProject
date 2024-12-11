package org.service;

import org.domain.Product;
import org.domain.ShoppingBasket;
import org.dto.OrderProductDTO;
import org.exception.UserException;
import org.repository.ProductDAO;
import org.repository.ProductDAOImpl;
import org.validation.ValidateLogic;

public class ProductServiceImpl implements ProductService{
    private final ProductDAO productDAO = new ProductDAOImpl();
    public ProductServiceImpl(){}

    public void orderProduct(int productId, int productAmount) throws UserException {
        ValidateLogic.validateOrderAmount(productId, productAmount);
        Product product = productDAO.getProduct(productId);
        product.reduceStockAmount(productAmount);
    }
    public void addProductToBasket(int productId, int productAmount, ShoppingBasket basket){
        Product product = productDAO.getProduct(productId);
        basket.addProduct(new OrderProductDTO(product.getName(), productAmount, productAmount*product.getPrice()));
    }
}
