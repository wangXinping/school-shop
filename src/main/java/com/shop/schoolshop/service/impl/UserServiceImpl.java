package com.shop.schoolshop.service.impl;

import com.ramostear.captcha.HappyCaptcha;
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

/**
 * 用户服务实现类
 */
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
        //验证码进行检验
        boolean verification = HappyCaptcha.verification(request, userLogin.getCode(), true);
        if (!verification) {
            return ResultBean.error(500,"验证码输入错误，请重新输入");
        }


        //使用MD5工具类对密码进行加密
        String pwd = MD5Util.MD5(userLogin.getPassWord());

        //user表中查找用户是否存在
       User user = userMapper.getByphoneAndpassWord(userLogin.getUserPhone(),pwd);
       if (user != null){
           //如果通过,清除当前验证码验证
           HappyCaptcha.remove(request);

           //将用户信息利用token加密
           String token = JwtTokenUtil.setToken(user);
           return ResultBean.success("登录成功",token);
       }
        return ResultBean.error(500,"登录失败,用户名或密码输入错误");
    }


}
