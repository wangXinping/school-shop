package com.shop.schoolshop.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 上皮图片类
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ApiModel("商品图片类")
public class GoodsImage {

    @ApiModelProperty("图片编号")
    private Integer imagesId;
    @ApiModelProperty("图片名称")
    private String imagesName;
    @ApiModelProperty("商品编号")
    private String goodsId;
}
