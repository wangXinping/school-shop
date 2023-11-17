package com.shop.schoolshop.service.impl;

import com.shop.schoolshop.mapper.AddressMapper;
import com.shop.schoolshop.pojo.Address;
import com.shop.schoolshop.pojo.ResultBean;
import com.shop.schoolshop.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 地址服务类
 */

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressMapper addressMapper;
    /**
     * 根据账号获取收货地址
     * @param userId
     * @return
     */
    @Override
    public List<Address> getAllAddress(String userId) {

        return addressMapper.getAllAddress(userId);
    }

    /**
     * 新增收货地址
     * @param address
     * @return
     */
    @Override
    public ResultBean InsertAddress(Address address) {
        int result = addressMapper.InsertAddress(address);
        if (result > 0){
            return ResultBean.success("新增收货地址成功",address);
        }
        return ResultBean.error(500,"新增地址失败");
    }

    /**
     * 删除收货地址
     * @param address
     * @return
     */
    @Override
    public ResultBean deleteAddress(Address address) {
        int result = addressMapper.deleteAddress(address);
        if (result>0){
            return ResultBean.success("删除地址成功");
        }
        return ResultBean.error(500,"删除地址失败");
    }

    /**
     * 更新收货地址
     * @param address
     * @return
     */
    @Override
    public ResultBean updateAddress(Address address) {
        int result = addressMapper.updateAddress(address);
        if (result > 0){
            return ResultBean.success("更新地址成功",address);
        }
        return ResultBean.error(500,"更新地址失败");
    }

    /**
     * 更新默认地址
     * @param address
     * @return
     */
    @Override
    @Transactional
    public ResultBean updateDefaultAddress(Address address) {
        Address address1 = addressMapper.getAddressByDefault(address);
        //判断是否已经有设为默认的地址，若有，则修改默认地址
        if ( null != address1 && address1.getAddressId() != address.getAddressId() ){
            address1.setIsDefault("否");
            addressMapper.updateDefaultAddress(address1);
        }
        int result = addressMapper.updateDefaultAddress(address);
        if (result >0){
            return ResultBean.success("默认地址设置成功");
        }
        return ResultBean.error(500,"默认地址设置失败");
    }


}
