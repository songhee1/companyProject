package org.service;

import java.util.Objects;
import org.data.DataItem;
import org.domain.Product;
import org.domain.ShoppingBasket;
import org.dto.OrderProductDTO;
import org.exception.UserException;
import org.validation.ValidateLogic;

public class ProductService {
    private static ProductService productService;
    private ProductService(){}
    public static ProductService getProductService(){
        if(Objects.isNull(productService)){
            productService = new ProductService();
        }
        return productService;
    }

    public void orderProduct(int productId, int productAmount) throws UserException {
        ValidateLogic.validateOrderAmount(productId, productAmount);
        DataItem.getMap().get(productId).reduceStockAmount(productAmount);
    }
    public void addProductToBasket(int productId, int productAmount, ShoppingBasket basket){
        Product product = DataItem.getMap().get(productId);
        basket.addProduct(new OrderProductDTO(product.getName(), productAmount, productAmount*product.getPrice()));
    }
}
