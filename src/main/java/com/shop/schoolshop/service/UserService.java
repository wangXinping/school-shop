package com.shop.schoolshop.service;

import com.shop.schoolshop.pojo.ResultBean;
import com.shop.schoolshop.pojo.User;

import javax.servlet.http.HttpServletRequest;
import javax.xml.transform.Result;
import java.util.List;

public interface UserService {

    /**
     * 查询用户所有信息
     * @return
     */
    List<User> getAllUser();

    /**
     * 登录用户账号
     * @param userPhone
     * @param passWord
     * @param request
     * @return
     */
    ResultBean byLogin(String userPhone, String passWord, HttpServletRequest request);
}
