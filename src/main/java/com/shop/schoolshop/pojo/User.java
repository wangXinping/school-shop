package com.shop.schoolshop.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 用户实体类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ApiModel(value = "用户实体类")
public class User {

    @ApiModelProperty(value = "乐享账号")
    private String userId;

    @ApiModelProperty(value = "用户昵称")
    private String userName;

    @ApiModelProperty(value = "性别")
    private String sex;

    @ApiModelProperty(value = "手机号")
    private String phone;

    @ApiModelProperty(value = "密码")
    private String password;

    @ApiModelProperty(value = "头像")
    private String userFace;

    @ApiModelProperty(value = "是否VIP")
    private String isVip;

    @ApiModelProperty(value = "个人介绍")
    private String introduce;
}
