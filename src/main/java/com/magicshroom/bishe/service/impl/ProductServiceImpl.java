package com.magicshroom.bishe.service.impl;

import com.magicshroom.bishe.bean.Product;
import com.magicshroom.bishe.mapper.ProductMapper;
import com.magicshroom.bishe.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductMapper productMapper;

    @Override
    public List<Product> getProductList(String type) {
        List<Product> list=null;
        if ("2021新产品".equals(type)){
             list= productMapper.getAllByDate("2021");
        }
        return list;
    }

    @Override
    public Product getProductByProductId(String productId) {
        return productMapper.getProductByProductId(productId);
    }

    @Override
    public List<Product> getProductList(String type, String param) {
        List<Product> list=null;
        switch (type){
            case "2021新产品":{
                list= productMapper.getAllByDate(param);
                break;
            }
            case "家电":
            case "配件": {
                list = productMapper.getAllByType(param);
                break;
            }
            case "search":{
                list = productMapper.getAllByName(param);
                break;
            }
            default:{
            }
        }
        return list;
    }

    @Override
    public Map<String, Object> homeProduct(String[] type) {
        Map<String,Object> map = new HashMap<>();
        List<Product> hotProduct = productMapper.getEightBySales();
        List<List<Product>> list = new ArrayList<>();
        for (String s : type) {
            list.add(productMapper.getProductByPriority(s));
        }
        map.put("hotProduct",hotProduct);
        map.put("list",list);
        return map;
    }
}
