package com.shop.schoolshop.mapper;

import com.shop.schoolshop.pojo.Address;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 地址 Mapper接口
 */
@Mapper
public interface AddressMapper {

    /**
     * 根据账号获取收货地址
     * @param userId
     * @return
     */
    @Select("select * from t_address where user_id = #{userId} ORDER BY is_default")
    List<Address> getAllAddress(@Param("userId") String userId);

    /**
     * 新增一条收货地址
     * @param address
     * @return
     */
    int InsertAddress(@Param("address") Address address);

    /**
     * 删除收货地址
     * @param address
     * @return
     */
    int deleteAddress(@Param("address") Address address);

    /**
     * 更新收货地址
     * @param address
     * @return
     */
    int updateAddress(@Param("address") Address address);

    /**
     * 查询默认地址的信息
     * @param address
     * @return
     */
    @Select("SELECT * FROM t_address WHERE user_id=#{address.userId} AND is_default='是'")
    Address getAddressByDefault(@Param("address") Address address);

    /**
     * 更新默认地址
     * @param address
     */
    int updateDefaultAddress(@Param("address") Address address);
}
