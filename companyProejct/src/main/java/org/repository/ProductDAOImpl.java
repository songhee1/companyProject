package org.repository;

import com.google.common.collect.ImmutableMap;
import java.io.IOException;
import org.data.Data;
import org.domain.Product;

public class ProductDAOImpl implements ProductDAO{

    @Override
    public Product getProduct(int productId) throws IOException {
        return Data.getItems().get(productId);
    }

    @Override
    public ImmutableMap<Integer, Product> getAllProductEntries() throws IOException {
        return Data.getItems();
    }

    @Override
    public boolean hasProductId(Integer productId) throws IOException {
        return Data.getItems().containsKey(productId);
    }
}
