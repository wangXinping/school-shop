package com.shop.schoolshop.mapper;

import com.shop.schoolshop.pojo.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 *  用户个人信息 Mapper 接口
 */
@Mapper
public interface UserInfoMapper {

    /**
     * 获取个人信息
     * @param user
     * @return
     */
    User getByUserInfo(@Param("user") User user);

    /**
     * 更新用户信息
     * @param user
     * @return
     */
    int updateByUserInfo(@Param("user") User user);

    /**
     * 判断手机号是否存在
     * @param phone
     * @return
     */
    @Select("select * from t_user where phone = #{phone}")
    User getByuserPhone(String phone);

    /**
     * 注销用户
     * @param userId
     * @return
     */
    @Delete("delete from t_user where user_id = #{userId}")
    int deleteUserInfo(String userId);

    /**
     * 注册用户信息
     * @param user
     * @return
     */
    int InsertUser(User user);
}
