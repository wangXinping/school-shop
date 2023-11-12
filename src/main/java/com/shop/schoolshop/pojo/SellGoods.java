package com.shop.schoolshop.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 商品实体类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ApiModel("商品实体类")
public class SellGoods {

    @ApiModelProperty("商品编号")
    private String goodsId;
    @ApiModelProperty("商品名称")
    private String goodsName;
    @ApiModelProperty("商品价格")
    private Double price;

    @ApiModelProperty("用户id")
    private String userId;

    @ApiModelProperty("用户类")
    private User user;

    @ApiModelProperty("类型编号")
    private Integer categoryId;
    @ApiModelProperty("商品类型名称")
    private String categoryName;

    @ApiModelProperty("商品介绍")
    private String present;
    @ApiModelProperty("创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date createTime;

    @ApiModelProperty("商品图片")
    private GoodsImage goodsImage;

    @ApiModelProperty("购物车信息")
    private ShoppingCar shoppingCar;
}
