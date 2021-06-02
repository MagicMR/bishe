package com.magicshroom.bishe.mapper;

import com.magicshroom.bishe.bean.Product;

import java.util.List;

public interface ProductMapper {

    public List<Product> getAll();

    public List<Product> getAllByDate(String date);

    public Product getProductByProductId(String productId);

    List<Product> getAllByType(String param);

    List<Product> getEightBySales();

    List<Product> getProductByPriority(String s);

    List<Product> getAllByName(String param);
}
