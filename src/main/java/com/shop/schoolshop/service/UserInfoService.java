package com.shop.schoolshop.service;

import com.shop.schoolshop.pojo.ResultBean;
import com.shop.schoolshop.pojo.User;
import org.springframework.web.multipart.MultipartFile;

/**
 * 个人信息服务接口
 */
public interface UserInfoService {


    /**
     * 查看个人信息
     * @param phone
     * @return
     */
    User getByUserInfo(String phone);

    /**
     * 修改个人信息
     * @param user
     * @return
     */
    ResultBean updateByUserInfo(User user);

    /**
     * 修改密码
     * @param userId
     * @param password
     * @param newpassword
     * @param repassword
     * @return
     */
    ResultBean updateByPassword(String userId, String password,String newpassword,String repassword);

    /**
     * 注销用户
     * @param userId
     * @return
     */
    ResultBean deleteUser(String userId);

    /**
     * 更新用户头像
     * @param fileName
     * @param userId
     * @return
     */
    ResultBean updateByFace(String fileName, String userId);
}
