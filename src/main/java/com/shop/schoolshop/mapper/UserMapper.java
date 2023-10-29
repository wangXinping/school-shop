package com.shop.schoolshop.mapper;

import com.shop.schoolshop.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;


import java.util.List;

/**
 * mapper接口
 */
@Mapper
public interface UserMapper {

    /**
     * 获取所有用户信息
     * @return
     */
    @Select("select * from t_user")
    List<User> getAllUser();

    /**
     * 用户登录
     * @param userPhone
     * @param passWord
     * @return
     */
    User getByphoneAndpassWord(@Param("userPhone") String userPhone, @Param("passWord") String passWord);
}
