package com.shop.schoolshop.controller.goods;

import com.shop.schoolshop.pojo.SellGoods;
import com.shop.schoolshop.service.SellGoodsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 商品管理控制类
 */
@RestController
@RequestMapping("/goods")
@Api(tags = "商品管理接口")
public class SellGoodsController {

    @Autowired
    private SellGoodsService goodsService;

    /**
     * 查询所有商品
     * @return
     */
    @GetMapping("/")
    @ApiOperation("查询所有商品")
    public List<SellGoods> getAllGoods(SellGoods sellGoods){
        return goodsService.getAllGoods(sellGoods);
    }
}
