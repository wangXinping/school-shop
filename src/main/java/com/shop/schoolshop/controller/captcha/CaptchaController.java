package com.shop.schoolshop.controller.captcha;

import com.ramostear.captcha.HappyCaptcha;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 生成验证码
 */
@RestController
@RequestMapping("/code")
public class CaptchaController {

    /**
     * 生成验证码
     * @param response
     * @param request
     */
    @GetMapping("/generateCode")
    @ApiOperation(value = "生成验证码",produces = "image/jpeg")
    public void generateCode(HttpServletResponse response, HttpServletRequest request){
        HappyCaptcha.require(request, response)
                //.style(CaptchaStyle.ANIM)   //设置动态样式
                .build()
                .finish();
    }

}
