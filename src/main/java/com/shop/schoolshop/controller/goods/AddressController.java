package com.shop.schoolshop.controller.goods;

import com.shop.schoolshop.pojo.Address;
import com.shop.schoolshop.pojo.ResultBean;
import com.shop.schoolshop.service.AddressService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 地址控制类
 */
@RestController
@RequestMapping("/address")
@Api(tags = "地址管理接口")
public class AddressController {

    @Autowired
    private AddressService addressService;

    /**
     * 根据账号获取收货地址
     * @param userId
     * @return
     */
    @GetMapping("/")
    @ApiOperation("根据账号获取收货地址")
    public List<Address> getAllAddress(@RequestParam String userId){
        return addressService.getAllAddress(userId);
    }

    /**
     * 新增收货地址
     * @param address
     * @return
     */
    @PostMapping("/")
    @ApiOperation("新增一条收货地址")
    public ResultBean InsertAddress(@RequestBody Address address){
        return addressService.InsertAddress(address);
    }

    /**
     * 删除收货地址
     * @param address
     * @return
     */
    @DeleteMapping("/")
    @ApiOperation("删除收货地址")
    public ResultBean deleteAddress(@RequestBody Address address ){
        return addressService.deleteAddress(address);
    }

    /**
     * 更新收货地址
     * @param address
     * @return
     */
    @PutMapping("/")
    @ApiOperation("更新收货地址")
    public ResultBean updateAddress(@RequestBody Address address){
        return  addressService.updateAddress(address);
    }

    /**
     * 更新默认地址
     * @param address
     * @return
     */
    @PutMapping("/default")
    @ApiOperation("更新默认地址")
    public ResultBean updateDefaultAddress(@RequestBody Address address){
        return addressService.updateDefaultAddress(address);
    }
}
