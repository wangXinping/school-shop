package com.shop.schoolshop.service.impl;

import com.shop.schoolshop.mapper.UserMapper;
import com.shop.schoolshop.pojo.ResultBean;
import com.shop.schoolshop.pojo.User;
import com.shop.schoolshop.pojo.UserLogin;
import com.shop.schoolshop.service.UserService;
import com.shop.schoolshop.util.JwtTokenUtil;
import com.shop.schoolshop.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.servlet.http.HttpServletRequest;
import java.util.List;

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
     * @param userLogin
     * @param request
     * @return
     */
    @Override
    public ResultBean byLogin(UserLogin userLogin, HttpServletRequest request) {
        if (userLogin.getUserPhone() == "" ||userLogin.getUserPhone() == null
                || userLogin.getPassWord() == "" || userLogin.getPassWord() == null){
            return ResultBean.error(500,"用户账号或密码不能为空！");
        }
        //使用MD5工具类对密码进行加密
        String pwd = MD5Util.MD5(userLogin.getPassWord());

        //user表中查找用户是否存在
       User user = userMapper.getByphoneAndpassWord(userLogin.getUserPhone(),pwd);
       if (user != null){
           //将用户信息存入到session中
           request.getSession().setAttribute("user",user);

           //将用户信息利用token加密
           String token = JwtTokenUtil.setToken(userLogin.getUserPhone(),pwd);
           return ResultBean.success("登录成功",token);
       }
        return ResultBean.error(500,"登录失败");
    }
}
