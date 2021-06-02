package com.magicshroom.bishe.mapper;

public interface ThumbnailMapper {

    /**
     * 获得第一张图片
     * @return 图片地址
     * @param productId 商品id
     */
    String selectImgPathByPid(String productId);

}
