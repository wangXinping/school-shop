package com.shop.schoolshop.service;

import com.shop.schoolshop.pojo.Order;
import com.shop.schoolshop.pojo.ResultBean;

import java.util.List;

/**
 * 订单详情接口
 */
public interface OrderService {


    List<Order> getAllOrder();

    /**
     * 生成一个订单
     * @param order
     * @return
     */
    ResultBean addOrder(Order order);
}
