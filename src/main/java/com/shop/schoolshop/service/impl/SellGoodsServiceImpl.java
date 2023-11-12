package com.shop.schoolshop.service.impl;

import com.shop.schoolshop.mapper.SellGoodsMapper;
import com.shop.schoolshop.pojo.ResultBean;
import com.shop.schoolshop.pojo.SellGoods;
import com.shop.schoolshop.service.SellGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 商品服务实现类
 */
@Service
public class SellGoodsServiceImpl implements SellGoodsService {


    @Autowired
    private SellGoodsMapper sellGoodsMapper;

    /**
     * 查询所有商品
     * @return
     */
    @Override
    public List<SellGoods> getAllGoods(SellGoods sellGoods) {
        return sellGoodsMapper.getAllGoods(sellGoods);
    }

    @Override
    public ResultBean insertImages(String[] fileName) {
        String goodsId = "4567899152545";
        int result = sellGoodsMapper.insertImages(fileName,goodsId);
        if (result > 0){
            return ResultBean.success("新增" + result + "条数据");
        }
        return ResultBean.error(500,"新增失败");
    }
}
