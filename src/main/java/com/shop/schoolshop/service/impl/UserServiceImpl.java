package com.shop.schoolshop.service.impl;

import com.shop.schoolshop.mapper.UserMapper;
import com.shop.schoolshop.pojo.ResultBean;
import com.shop.schoolshop.pojo.User;
import com.shop.schoolshop.service.UserService;
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
     * @param userPhone
     * @param passWord
     * @param request
     * @return
     */
    @Override
    public ResultBean byLogin(String userPhone, String passWord, HttpServletRequest request) {
       User user = userMapper.getByphoneAndpassWord(userPhone,passWord);
       if (user != null){
           request.getSession().setAttribute("user",user);
           return ResultBean.success("验证成功",user);
       }
        return ResultBean.error("验证失败");
    }
}
