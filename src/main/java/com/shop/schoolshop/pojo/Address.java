package com.shop.schoolshop.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 地址实体类
 */

@Data
@ApiModel("地址类")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Address {

    @ApiModelProperty("地址id")
    private Integer addressId;

    @ApiModelProperty("收货人姓名")
    private String receName;

    @ApiModelProperty("收货人手机号")
    private String addressPhone;

    @ApiModelProperty("收货人地址")
    private String addressInfo;

    @ApiModelProperty("是否为默认地址")
    private String isDefault;

    @ApiModelProperty("账号id")
    private String userId;
}
