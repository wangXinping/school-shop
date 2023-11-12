package com.shop.schoolshop.controller.shoppingcar;

import com.shop.schoolshop.pojo.ResultBean;
import com.shop.schoolshop.pojo.ShoppingCar;
import com.shop.schoolshop.service.ShoppingCarService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 购物车控制类
 */
import java.util.List;

@RestController
@RequestMapping("/shoppingcar")
@Api(tags = "购物车管理接口")
public class ShoppingCarController {

    @Autowired
    private ShoppingCarService shoppingCarService;

    @ApiOperation("获取个人购物车信息")
    @GetMapping("/")
    public List<ShoppingCar> getShoppingCarInfo(@RequestParam String userId){
        return shoppingCarService.getShoppingCarInfo(userId);
    }

    @ApiOperation("将商品添加到购物车")
    @PostMapping("/")
    public ResultBean InsertShoppingCarInfo(@RequestBody ShoppingCar shoppingCar){
        return shoppingCarService.InsertShoppingCarInfo(shoppingCar.getUserId(),shoppingCar.getGoodsId());
    }

    @ApiOperation("将商品在购物车中去除")
    @DeleteMapping("/")
    public ResultBean deleteShoppingCarInfo(@RequestBody ShoppingCar shoppingCar){
        return shoppingCarService.deleteShoppingCarInfo(shoppingCar);
    }

    @ApiOperation("清空购物车")
    @DeleteMapping("/all")
    public ResultBean deleteAllShoppingCarInfo(@RequestBody ShoppingCar shoppingCar){
        return shoppingCarService.deleteAllShoppingCarInfo(shoppingCar);
    }
}
