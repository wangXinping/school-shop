package com.shop.schoolshop.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ApiModel("购物车实体类")
public class ShoppingCar {
    @ApiModelProperty("购物车id")
    private int shoppingId;

    @ApiModelProperty("存入到购物车的商品个数")
    private int selectNumber;

    @ApiModelProperty("用户id")
    private String userId;
    @ApiModelProperty("用户类")
    private User user;

    @ApiModelProperty("商品id")
    private String goodsId;
    @ApiModelProperty("商品类")
    private SellGoods sellGoods;
}
