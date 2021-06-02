package com.magicshroom.bishe.bean;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import java.sql.Date;
import java.util.List;

@Data
public class Product {

    private Integer productId;
    private String productName;
    private String productInfo;

    private String productType;
    private Date productDate;
    private Integer productSales;
    private List<Color> colorList;
    private List<Specification> specificationList;
    private List<Thumbnail> thumbnailList;
    private List<InfoImage> infoImageList;
}
