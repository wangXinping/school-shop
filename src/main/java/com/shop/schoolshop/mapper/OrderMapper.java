package com.shop.schoolshop.mapper;

import com.shop.schoolshop.pojo.Order;
import com.shop.schoolshop.pojo.ResultBean;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 订单 Mapper接口
 */
@Mapper
public interface OrderMapper {

    /**
     * 生成一个订单
     * @param order
     * @return
     */
    int addOrder(@Param("order") Order order);
}
