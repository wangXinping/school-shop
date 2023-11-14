package com.shop.schoolshop.service.impl;

import com.shop.schoolshop.mapper.ShoppingCarMapper;
import com.shop.schoolshop.pojo.ResultBean;
import com.shop.schoolshop.pojo.SellGoods;
import com.shop.schoolshop.pojo.ShoppingCar;
import com.shop.schoolshop.pojo.User;
import com.shop.schoolshop.service.ShoppingCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 购物车实现类
 */
import java.util.List;
@Service
public class ShoppingCarServiceImpl implements ShoppingCarService {

    @Autowired
    private ShoppingCarMapper shoppingCarMapper;

    /**
     * 查询购物车中的信息
     * @param userId
     * @return
     */
    @Override
    public List<ShoppingCar> getShoppingCarInfo(String userId) {
        return shoppingCarMapper.getShoppingCarInfo(userId);
    }

    /**
     * 将商品添加到购物车中
     * @param userId
     * @param goodId
     * @return
     */
    @Override
    @Transactional
    public ResultBean InsertShoppingCarInfo(String userId,String goodId) {
        //查看购物车中是否已经存在该商品
        ShoppingCar shoppingCar1 = shoppingCarMapper.getShoppingCarByGood(userId,goodId);
        if (shoppingCar1 != null){
            return ResultBean.error(500,"该商品已加入到购物车中！");
        }
        int result1 = shoppingCarMapper.InsertShoppingCarInfo(userId,goodId);
        if (result1 > 0){
            return ResultBean.success("商品添加购物车成功！");
        }
        return ResultBean.error(500,"商品添加购物车失败！");
    }

    /**
     * 将商品从购物车去除
     * @param shoppingCar
     * @return
     */
    @Override
    public ResultBean deleteShoppingCarInfo(ShoppingCar shoppingCar) {
        if (shoppingCar.getUserId()==null && shoppingCar.getGoodsId() == null){
            shoppingCar.setGoodsId(shoppingCar.getSellGoods().getGoodsId());
            shoppingCar.setUserId(shoppingCar.getUser().getUserId());
        }
        int result = shoppingCarMapper.deleteShoppingCarInfo(shoppingCar.getUserId(),shoppingCar.getGoodsId());
        if (result > 0){
            return ResultBean.success("商品已移除购物车！");
        }
        return ResultBean.error(500,"商品移除失败！");
    }

    /**
     * 清空购物车
     * @param shoppingCar
     * @return
     */
    @Override
    public ResultBean deleteAllShoppingCarInfo(ShoppingCar shoppingCar) {
        User user = shoppingCar.getUser();
        int result = shoppingCarMapper.deleteAllShoppingCarInfo(user);
        if (result > 0){
            return ResultBean.success("购物车清空成功！");
        }
        return ResultBean.error(500,"购物车清空失败！");
    }
}
