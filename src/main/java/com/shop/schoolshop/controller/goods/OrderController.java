package com.shop.schoolshop.controller.goods;

import com.shop.schoolshop.pojo.Order;
import com.shop.schoolshop.pojo.ResultBean;
import com.shop.schoolshop.service.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
@Api(tags = "商品订单详情管理接口")
public class OrderController {

    @Autowired
    private OrderService orderService;

    //获取订单详情
    @GetMapping("/")
    @ApiOperation("获取订单")
    public List<Order> getAllOrder(){
        return orderService.getAllOrder();
    }

    /**
     * 生成一个订单
     * @param order
     * @return
     */
    @PostMapping("/")
    @ApiOperation("生成一个订单")
    public ResultBean addOrder(@RequestBody Order order){
        return orderService.addOrder(order);
    }
}
