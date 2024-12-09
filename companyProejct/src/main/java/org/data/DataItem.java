package org.data;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.domain.Product;

public class DataItem {
    private static Map<Integer, Product> map = new HashMap<>();
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final String REGEX_INPUT = ",(?=(?:[^\\\"]*\\\"[^\\\"]*\\\")*[^\\\"]*$)";

    public static Map<Integer, Product> getMap() {
        return map;
    }

    public static void setData() throws IOException {
        for(int i=1;i<20;i++){
            String[] splitData = br.readLine().replace("\uFEFF", "").split(REGEX_INPUT);
            int productId = Integer.parseInt(splitData[0]);
            String productName = splitData[1];
            int productPrice = Integer.parseInt(splitData[2]);
            int productStockAmount = Integer.parseInt(splitData[3]);
            map.put(productId, new Product(productName, productPrice, productStockAmount));
        }
    }
}
