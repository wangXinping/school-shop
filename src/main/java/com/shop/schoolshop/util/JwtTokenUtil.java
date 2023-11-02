package com.shop.schoolshop.util;


import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.shop.schoolshop.pojo.User;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * token工具类
 */

@Component
public class JwtTokenUtil {
    //token密钥
    private static final String KEY = "tye_key";


    /**
     * 获取token
     */
    public static String setToken(User user){

        //获取jwt生成器
        JWTCreator.Builder jwtBuild = JWT.create();

        //由于该生成器设置的Header的参数为一个<String,Object>的Map
        Map<String,Object> header = new HashMap<>();
        header.put("typ","JWT");  //设置token的type为jwt
        header.put("alg","HS256");  //表明加密的算法为hs256

        //开始生成token
        String token = jwtBuild.withHeader(header)  //设置头部信息
                .withClaim("phone",user.getPhone())
                .withClaim("userName",user.getUserName())
                .withClaim("password",user.getPassword())
                .withExpiresAt(new Date(System.currentTimeMillis() +  1000 * 60 * 60 * 24))  //设置token过期时间，为24小时
                .withIssuedAt(new Date(System.currentTimeMillis()))  //执行token时间，为系统当前时间
                .withIssuer("wxp")  //执行者
                .sign(Algorithm.HMAC256(KEY));  //进行签名，选择加密算法，以字符串秘钥为参数


        return token;

    }




}
