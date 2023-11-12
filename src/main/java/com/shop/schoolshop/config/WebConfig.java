package com.shop.schoolshop.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Arrays;
import java.util.List;

/**
 * 拦截器配置类
 */
//@Slf4j
@Configuration
public class WebConfig implements WebMvcConfigurer {



    /**
     * 不需要拦截-白名单
     */
    private static final String[] WHITELISH = {
            "/system/login",
            "/swagger-resources/**",
            "/webjars/**",
            "/v2/**",
            "/swagger-ui.html/**",
            "/code/generateCode",
            "/register/",
            "/goods/"
    };


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        List<String> list = Arrays.asList(WHITELISH);
        InterceptorRegistration registration = registry.addInterceptor(jwtInterceptor());
        registration.addPathPatterns("/**") //拦截所有请求
                .excludePathPatterns(list); //排除的请求
    }

    @Bean
    public JwtInterceptor jwtInterceptor(){
        return new JwtInterceptor();
    }
}
