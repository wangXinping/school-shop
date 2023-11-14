package com.shop.schoolshop.service.impl;

import com.shop.schoolshop.exception.ServiceException;
import com.shop.schoolshop.mapper.UserInfoMapper;
import com.shop.schoolshop.pojo.ResultBean;
import com.shop.schoolshop.pojo.User;
import com.shop.schoolshop.pojo.UserLogin;
import com.shop.schoolshop.service.UserInfoService;
import com.shop.schoolshop.util.MD5Util;
import com.shop.schoolshop.util.RandomUtil;
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

        if (null != user1 && !user.getUserId().equals(user1.getUserId()) ){
            return ResultBean.error(500,"该手机号已绑定其他账号");
        }
        int result =userInfoMapper.updateByUserInfo(user);
        if (1 == result){
            return ResultBean.success("更新信息成功",user);
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
            return ResultBean.success("修改密码成功,请重新登录！");
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
        try {
            int result = userInfoMapper.deleteUserInfo(userId);
            if (1 == result){
                return ResultBean.success("注销成功");
            }
        }catch (Exception e){
            return ResultBean.error(500,"该用户绑定其他商品无法注销！");
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

    /**
     * 注册用户信息
     * @param userRegister
     * @return
     */
    @Transactional
    @Override
    public ResultBean InsertUser(UserLogin userRegister) {
        User user = new User();
        //产生随机的账号
        String userId = RandomUtil.createRandom();
        user.setUserId(userId);
        //手机号必须唯一
        User byuserPhone = userInfoMapper.getByuserPhone(userRegister.getUserPhone());
        if (byuserPhone != null){
            return ResultBean.error(500,"该手机号已绑定其他账号");
        }
        user.setPhone(userRegister.getUserPhone());
        //判断两次输入的密码是否一致
        if (!userRegister.getPassWord().equals(userRegister.getConfirmPwd())){
            return ResultBean.error(500,"两次输入的密码不一致");
        }
        //密码进行加密
        String md5password = MD5Util.MD5(userRegister.getPassWord());
        user.setPassword(md5password);
        user.setUserName(userRegister.getUserName());
        user.setUserFace("face.jpg");
        int result = userInfoMapper.InsertUser(user);
        if (1 == result){
            return ResultBean.success("注册成功");
        }
        return ResultBean.error(500,"注册失败");
    }


}
