package org.repository;

import com.google.common.collect.ImmutableMap;
import java.io.IOException;
import org.domain.Product;

public interface ProductDAO {
    public Product getProduct(int productId) throws IOException;
    public ImmutableMap<Integer, Product> getAllProductEntries() throws IOException;
    public boolean hasProductId(Integer productId) throws IOException;

}
