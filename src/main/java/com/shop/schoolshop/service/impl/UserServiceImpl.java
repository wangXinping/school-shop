package com.shop.schoolshop.service.impl;

import com.shop.schoolshop.mapper.UserMapper;
import com.shop.schoolshop.pojo.ResultBean;
import com.shop.schoolshop.pojo.User;
import com.shop.schoolshop.service.UserService;
import com.shop.schoolshop.util.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springfox.documentation.service.ParameterType;


import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    /**
     * 查询用户所有信息
     * @return
     */
    @Override
    public List<User> getAllUser() {
        return userMapper.getAllUser();
    }

    /**
     * 登录用户账号
     * @param userPhone
     * @param passWord
     * @param request
     * @return
     */
    @Override
    public ResultBean byLogin(String userPhone, String passWord, HttpServletRequest request) {
        if (userPhone == "" ||userPhone == null || passWord == "" || passWord == null){
            return ResultBean.error(500,"用户账号或密码不能为空！");
        }
       User user = userMapper.getByphoneAndpassWord(userPhone,passWord);
       if (user != null){
           //将用户信息存入到session中
           request.getSession().setAttribute("user",user);

           //将用户信息利用token加密
           String token = JwtTokenUtil.setToken(userPhone,passWord);
           return ResultBean.success("登录成功",token);
       }
        return ResultBean.error(500,"登录失败");
    }
}
