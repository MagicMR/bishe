package com.magicshroom.bishe.service;

import com.magicshroom.bishe.bean.Product;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface ProductService {

    List<Product> getProductList(String type);

    Product getProductByProductId(String productId);

    List<Product> getProductList(String type, String param);

    Map<String, Object> homeProduct(String[] type);
}
