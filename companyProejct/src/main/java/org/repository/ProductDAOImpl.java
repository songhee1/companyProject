package org.repository;

import java.util.Objects;
import org.data.DataItem;
import org.domain.Product;

public class ProductDAOImpl implements ProductDAO{
    public ProductDAOImpl() {
    }

    @Override
    public Product getProduct(int productId) {
        return DataItem.getMap().get(productId);
    }
}
