package com.shop.schoolshop.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 商品类型
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ApiModel("商品类型类")
public class Category {

    @ApiModelProperty("商品类型编号")
    private Integer categoryId;
    @ApiModelProperty("商品类型名称")
    private String categoryName;
}
