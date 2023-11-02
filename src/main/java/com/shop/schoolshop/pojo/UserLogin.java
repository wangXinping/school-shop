package com.shop.schoolshop.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 用户登录实体类
 */
@Data
@NoArgsConstructor
@EqualsAndHashCode
@AllArgsConstructor
@ApiModel(value = "用户登录")
public class UserLogin {

    @ApiModelProperty("昵称")
    private String userName;
    @ApiModelProperty("登录账号")
    private String userPhone;
    @ApiModelProperty("密码")
    private String passWord;
    @ApiModelProperty("确认密码")
    private String confirmPwd;
    @ApiModelProperty("验证码")
    private String code;

}
