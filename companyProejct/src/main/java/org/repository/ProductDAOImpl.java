package org.repository;

import java.util.Map;
import java.util.Objects;
import org.data.DataItem;
import org.domain.Product;

public class ProductDAOImpl implements ProductDAO{
    @Override
    public Product getProduct(int productId) {
        return DataItem.getMap().get(productId);
    }

    @Override
    public Map<Integer, Product> getAllProductEntries() {
        return DataItem.getMap();
    }
}
