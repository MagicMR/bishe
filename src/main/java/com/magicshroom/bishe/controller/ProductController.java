package com.magicshroom.bishe.controller;

import com.magicshroom.bishe.bean.Product;
import com.magicshroom.bishe.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author 27250
 */
@RequestMapping("/product")
@RestController
public class ProductController {

    @Autowired
    ProductService productService;

    @RequestMapping("/productList")
    public List<Product> getProduct(@RequestParam String type,
                                    @RequestParam String param){

        return productService.getProductList(type,param);
    }

    @RequestMapping("/productByProductId")
    public Product getProductByProductId(@RequestParam Integer id){
        return productService.getProductByProductId(String.valueOf(id));
    }

    @RequestMapping("/homeProduct")
    public Map<String,Object> homeProduct(@RequestParam String[] type){
        return productService.homeProduct(type);
    }
}
