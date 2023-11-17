package com.shop.schoolshop.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@ApiModel("商品订单类")
@Data
@AllArgsConstructor
@EqualsAndHashCode
@NoArgsConstructor
public class Order {

    @ApiModelProperty("订单编号")
    private String orderId;

    @ApiModelProperty("商品")
    private SellGoods sellGoods;
    @ApiModelProperty("用户")
    private User user;
    @ApiModelProperty("选择商品件数")
    private Integer selectNumber;
}
