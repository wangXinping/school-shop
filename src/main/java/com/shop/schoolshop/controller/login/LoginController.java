package com.shop.schoolshop.controller.login;

import com.shop.schoolshop.pojo.ResultBean;
import com.shop.schoolshop.pojo.UserLogin;
import com.shop.schoolshop.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@Api(tags = "登录管理接口")
@RequestMapping("/system")
public class LoginController {

    @Autowired
    private UserService userService;

    /**
     * 登录用户账号
     * @param userLogin
     * @param request
     * @return
     */
    @ApiOperation("登录用户账号返回token")
    @PostMapping("/login")
    @ResponseBody
    public ResultBean login(@RequestBody UserLogin userLogin, HttpServletRequest request){
        return userService.byLogin(userLogin,request);
    }
}
