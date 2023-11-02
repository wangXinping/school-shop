package com.shop.schoolshop.controller.user;

import com.auth0.jwt.JWT;
import com.shop.schoolshop.pojo.ResultBean;
import com.shop.schoolshop.pojo.User;
import com.shop.schoolshop.service.UserInfoService;
import com.shop.schoolshop.util.FileUpLoadAndDownLoadUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;

/**
 * 个人信息控制类
 */

@RestController
@RequestMapping("/userInfo")
@Api(tags = "用户个人信息管理接口")
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    private FileUpLoadAndDownLoadUtil fileUpLoadAndDownLoadUtil;

    /**
     * 查看个人信息
     * @return
     */
    @ApiOperation(value = "查看用户个人信息")
    @GetMapping("/")
    public User getByUserInfo(@RequestHeader("Authorization") String token, HttpServletResponse response){
        //根据token获取用户手机号（手机号是唯一的）
        String phone = JWT.decode(token).getClaim("phone").asString();
        //根据手机号查询个人信息
        User user = userInfoService.getByUserInfo(phone);
        return user;
    }

    /**
     * 修改个人信息
     */
    @PutMapping("/updateByuserInfo")
    @ApiOperation("修改个人信息")
    public ResultBean updateByUserInfo(@RequestBody User user){
        return userInfoService.updateByUserInfo(user);
    }

    /**
     * 修改用户密码
     * @param userId
     * @param password
     * @param repassword
     * @return
     */
    @PutMapping("/updateBypassword")
    @ApiOperation("修改密码")
    public ResultBean updateByPassword(@RequestParam String userId,@RequestParam String password,@RequestParam String newpassword,@RequestParam String repassword){
        return userInfoService.updateByPassword(userId,password,newpassword,repassword);
    }

    /**
     * 更新用户头像
     * @param file
     * @param userId
     * @return
     */
    @PostMapping("/updataByFace")
    @ApiOperation("更新用户头像")
    public ResultBean updateByFace(@RequestPart MultipartFile file,@RequestParam String userId){

        //获取头像文件名称
        String fileName = fileUpLoadAndDownLoadUtil.fileUpLoad(file);

        return userInfoService.updateByFace(fileName,userId);
    }

    /**
     * 注销用户
     * @param userId
     * @return
     */
    @DeleteMapping("/")
    @ApiOperation("注销用户")
    public ResultBean deleteUser(String userId){
        return userInfoService.deleteUser(userId);
    }

}
