package com.shop.schoolshop.mapper;

import com.shop.schoolshop.pojo.SellGoods;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 商品 mapper接口
 */
@Mapper
public interface SellGoodsMapper {

    /**
     * 查询所有商品
     * @return
     */
    List<SellGoods> getAllGoods(@Param("sellGoods") SellGoods sellGoods);

    /**
     * 添加图片
     *
     * @param imagesNames
     * @param goodsId
     * @return
     */
    int insertImages(@Param("imagesNames") String[] imagesNames,@Param("goodsId") String goodsId);
}
