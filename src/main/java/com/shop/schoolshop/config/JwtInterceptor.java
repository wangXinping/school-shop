package com.shop.schoolshop.config;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.github.xiaoymin.knife4j.core.util.StrUtil;
import com.shop.schoolshop.exception.ServiceException;
import lombok.SneakyThrows;
import lombok.var;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * Jwt token 拦截器
 */
public class JwtInterceptor implements HandlerInterceptor {

    private static final String KEY = "tye_key";

    /**
     * controller 执行之前
     * @param request
     * @param response
     * @param handler
     * @return
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler){
        //从请求头中获取token
        String token = request.getHeader("Authorization");
        //如果不是映射到方法直接通过
        if(!(handler instanceof HandlerMethod)){
            return true;
        }

        //判断如果请求的类是swagger的控制器，直接通行
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        if (handlerMethod.getBean().getClass().getName().equals("springfox.documentation.swagger.web.ApiResourceController")){
            return true;
        }

        //判断token是否存在，若不存在，则验证失败（跳转登录页）
        if (StrUtil.isBlank(token)){
            throw new ServiceException(401,"token为空,请重新登录");
        }


        try {
            //获取jwt的验证器对象，传入的算法参数、秘钥字符串必须和加密时相同
            JWTVerifier verifier = JWT.require(Algorithm.HMAC256(KEY)).build();
            //开始验证，验证token是否修改，以及是否过期，验证成功会生成一个解码对象
            //如果token修改了或者已经过期，就会抛出异常
            DecodedJWT decodedJWT = verifier.verify(token);
        } catch (Exception e) {
            //抛出异常，验证失败
            throw new ServiceException(401,"token修改或过期,验证失败");
        }

        //判断所有自定义参数是否为空，若为空，则验证失败
//        Map<String, Claim> claims = decode.getClaims();
//        if (claims == null){
//            throw new ServiceException(401,"验证失败");
//        }
//        claims.forEach((k, v) -> System.out.println(k + " " + v.asString()));

        return true;

    }

}
