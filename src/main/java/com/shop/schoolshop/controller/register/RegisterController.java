package com.shop.schoolshop.controller.register;

import com.shop.schoolshop.pojo.ResultBean;
import com.shop.schoolshop.pojo.UserLogin;
import com.shop.schoolshop.service.UserInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 注册控制类
 */
@RestController
@RequestMapping("/register")
@Api(tags = "注册管理接口")
public class RegisterController {

    @Autowired
    private UserInfoService userInfoService;

    /**
     * 注册用户信息
     * @param userRegister
     * @return
     */
    @ApiOperation("注册用户")
    @PostMapping("/")
    public ResultBean RegisterUser(@RequestBody UserLogin userRegister){
        return userInfoService.InsertUser(userRegister);
    }
}
