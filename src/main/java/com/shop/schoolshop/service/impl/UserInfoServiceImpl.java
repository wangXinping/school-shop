package com.shop.schoolshop.service.impl;

import com.shop.schoolshop.mapper.UserInfoMapper;
import com.shop.schoolshop.pojo.ResultBean;
import com.shop.schoolshop.pojo.User;
import com.shop.schoolshop.service.UserInfoService;
import com.shop.schoolshop.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * 用户个人服务实现类
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoMapper userInfoMapper;

    /**
     * 查询用户个人信息
     * @param phone
     * @return
     */
    @Override
    public User getByUserInfo(String phone) {
        User user = new User();
        user.setPhone(phone);
        return userInfoMapper.getByUserInfo(user);
    }

    /**
     * 修改用户信息
     * @param user
     * @return
     */
    @Override
    @Transactional
    public ResultBean updateByUserInfo(User user) {
         //判断手机号是否存在
        User user1 = userInfoMapper.getByuserPhone(user.getPhone());
        System.out.println(user1.getClass());
        System.out.println(user.getClass());
        if (!user1.getUserId().equals(user.getUserId()) ){
            return ResultBean.error(500,"该手机号已绑定其他账号");
        }
        int result =userInfoMapper.updateByUserInfo(user);
        if (1 == result){
            return ResultBean.success("更新信息成功");
        }
        return ResultBean.error(500,"更新失败");
    }

    /**
     * 修改密码
     * @param userId
     * @param password
     * @param repassword
     * @return
     */
    @Override
    @Transactional
    public ResultBean updateByPassword(String userId, String password,String newpassword,String repassword) {
        if(password == null || password == ""){
            return ResultBean.error(500,"密码为空，请重新输入");
        }
        User user = new User();
        user.setUserId(userId);
        String pwd = MD5Util.MD5(password);
        user.setPassword(pwd);
        //判断旧密码输入是否正确
        user = userInfoMapper.getByUserInfo(user);
        if (user == null){
            return ResultBean.error(401,"请正确输入旧密码");
        }
        //判断两次输入的新密码是否一致
        if (!newpassword.equals(repassword)){
            return ResultBean.error(500,"两次输入新密码不一致");
        }
        String npwd = MD5Util.MD5(newpassword);
        user.setPassword(npwd);
        int result = userInfoMapper.updateByUserInfo(user);
        if (result == 1){
            return ResultBean.success("修改密码成功");
        }
        return ResultBean.error(500,"修改密码失败");
    }

    /**
     * 注销用户
     * @param userId
     * @return
     */
    @Override
    public ResultBean deleteUser(String userId) {
        int result = userInfoMapper.deleteUserInfo(userId);
        if (1 == result){
            return ResultBean.success("注销成功");
        }
        return ResultBean.error(500,"注销失败");
    }

    /**
     * 更新用户头像
     * @param fileName
     * @param userId
     * @return
     */
    @Override
    public ResultBean updateByFace(String fileName, String userId) {
        User user = new User();
        user.setUserId(userId);
        user.setUserFace(fileName);
        int result = userInfoMapper.updateByUserInfo(user);
        if (1 == result){
            return ResultBean.success("更新头像成功");
        }
        return ResultBean.error(500,"更新头像失败");
    }


}
