package com.shop.schoolshop.mapper;

import com.shop.schoolshop.pojo.SellGoods;
import com.shop.schoolshop.pojo.ShoppingCar;
import com.shop.schoolshop.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 购物车Mapper接口
 */
@Mapper
public interface ShoppingCarMapper {

    /**
     * 获取个人购物车信息
     * @return
     * @param userId
     */
    List<ShoppingCar> getShoppingCarInfo(String userId);

    /**
     * 查看购物车是否已经存在该商品
     * @param userId
     * @param goodsId
     */
    @Select("select * from shopping_car where user_id = #{userId} AND goods_id = #{goodsId}")
    ShoppingCar getShoppingCarByGood(String userId,String goodsId);

    /**
     * 将商品添加到购物车
     * @param userId
     * @param goodsId
     * @return
     */
    int InsertShoppingCarInfo(String userId,String goodsId);

    /**
     * 将商品从购物车去除
     * @param userId
     * @param goodsId
     * @return
     */
    int deleteShoppingCarInfo(String userId,String goodsId);

    /**
     * 清空购物车
     * @param user
     * @return
     */
    int deleteAllShoppingCarInfo(@Param("user") User user);
}
