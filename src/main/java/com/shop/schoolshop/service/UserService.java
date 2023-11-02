package com.shop.schoolshop.service;

import com.shop.schoolshop.pojo.ResultBean;
import com.shop.schoolshop.pojo.User;
import com.shop.schoolshop.pojo.UserLogin;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 用户服务接口
 */
public interface UserService {

    /**
     * 查询用户所有信息
     * @return
     * @param currentPage
     * @param size
     */
    List<User> getAllUser(Integer currentPage, Integer size);

    /**
     * 登录用户账号
     * @param userLogin
     * @param request
     * @return
     */
    ResultBean byLogin(UserLogin userLogin, HttpServletRequest request);

}
