package org.repository;

import java.util.Map;
import org.domain.Product;

public interface ProductDAO {
    public Product getProduct(int productId);
    public Map<Integer, Product> getAllProductEntries();
}
