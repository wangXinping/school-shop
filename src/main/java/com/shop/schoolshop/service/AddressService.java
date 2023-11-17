package com.shop.schoolshop.service;

import com.shop.schoolshop.pojo.Address;
import com.shop.schoolshop.pojo.ResultBean;

import java.util.List;

public interface AddressService {

    /**
     * 根据账号获取收货地址
     * @param userId
     * @return
     */
    List<Address> getAllAddress(String userId);

    /**
     * 新增收货地址
     * @param address
     * @return
     */
    ResultBean InsertAddress(Address address);

    /**
     * 删除收货地址
     * @param address
     * @return
     */
    ResultBean deleteAddress(Address address);

    /**
     * 更新收货地址
     * @param address
     * @return
     */
    ResultBean updateAddress(Address address);

    /**
     * 修改默认地址
     * @param address
     * @return
     */
    ResultBean updateDefaultAddress(Address address);
}
