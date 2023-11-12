package com.shop.schoolshop.service;


import com.shop.schoolshop.pojo.ResultBean;
import com.shop.schoolshop.pojo.ShoppingCar;

import java.util.List;

/**
 * 购物车实现接口
 */
public interface ShoppingCarService {


    /**
     * 获取个人的购物车信息
     * @return
     * @param userId
     */
    List<ShoppingCar> getShoppingCarInfo(String userId);

    /**
     * 添加到购物车
     * @param userId
     * @param goodId
     * @return
     */
    ResultBean InsertShoppingCarInfo(String userId,String goodId);

    /**
     * 将商品从购物车去除
     * @param shoppingCar
     * @return
     */
    ResultBean deleteShoppingCarInfo(ShoppingCar shoppingCar);

    /**
     * 清空购物车
     * @param shoppingCar
     * @return
     */
    ResultBean deleteAllShoppingCarInfo(ShoppingCar shoppingCar);
}
