package com.shop.schoolshop.service.impl;

import com.shop.schoolshop.mapper.OrderMapper;
import com.shop.schoolshop.pojo.Order;
import com.shop.schoolshop.pojo.ResultBean;
import com.shop.schoolshop.service.OrderService;
import com.shop.schoolshop.util.RandomUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 订单详情实现类
 */

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public List<Order> getAllOrder() {
        return null;
    }

    /**
     * 生成一个订单
     * @param order
     * @return
     */
    @Override
    public ResultBean addOrder(Order order) {
        if (order.getSelectNumber() > order.getSellGoods().getGoodsNumber()){
            return ResultBean.error(500,"商品数量不足");
        }
        order.setOrderId(RandomUtil.createOrder());
        int result = orderMapper.addOrder(order);
        if (result <= 0){
            return ResultBean.error(500,"商品权限不足");
        }
      return ResultBean.success(order);
    }
}
