package com.shop.schoolshop.controller.user;

import com.shop.schoolshop.pojo.User;
import com.shop.schoolshop.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/user")
@Api(tags = "用户管理接口")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 查询所有用户信息
     * @return
     */
    @ApiOperation("查询所有用户信息及分页")
    @GetMapping( "/")
    public List<User> getAllUser(){
        return userService.getAllUser();
    }

}
