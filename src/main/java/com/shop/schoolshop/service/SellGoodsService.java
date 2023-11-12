package com.shop.schoolshop.service;

import com.shop.schoolshop.pojo.ResultBean;
import com.shop.schoolshop.pojo.SellGoods;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 商品服务接口
 */
public interface SellGoodsService {

    /**
     * 查询所有商品
     * @return
     */
    List<SellGoods> getAllGoods(@Param("sellGoods") SellGoods sellGoods);

    ResultBean insertImages(String[] fileName);
}
