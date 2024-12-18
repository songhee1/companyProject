package org.view;

import com.google.common.collect.ImmutableMap;
import java.io.IOException;
import java.util.Map;
import org.domain.Product;
import org.service.ProductService;

public class ProductView {
    public void displayProductList(ProductService productService) throws IOException {
        ImmutableMap<Integer, Product> items = productService.getAllProductEntries();
        StringBuilder sb = new StringBuilder();
        sb.append("상품번호\t\t\t상품명\t\t\t판매가격\t\t\t재고수\n");

        for (Map.Entry<Integer, Product> entry : items.entrySet()) {
            Product product = entry.getValue();
            sb.append(entry.getKey()).append("\t").append(product.getName()).append("\t")
                .append(product.getPrice()).append("\t").append(product.getStockAmount()).append("\n");
        }
        System.out.println(sb);
    }
}
