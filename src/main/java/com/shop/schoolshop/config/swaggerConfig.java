package com.shop.schoolshop.config;


import com.shop.schoolshop.pojo.ResultBean;
import com.shop.schoolshop.util.JwtTokenUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.*;
import springfox.documentation.schema.ScalarType;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.List;

/**
 *  swagger2 配置类
 */

@EnableSwagger2 //启用swagger2功能
@Configuration  //配置类
public class swaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.shop.schoolshop.controller"))
                .paths(PathSelectors.any())
                .build()
                .globalRequestParameters(this.getRequestParameters());
    }

    /**
     * 设置全局请求头参数
     * @return
     */
    private List<RequestParameter> getRequestParameters() {
        List<RequestParameter> parameters = new ArrayList<>();
        parameters.add(new RequestParameterBuilder()
                .name("Authorization")
                .description("Authorization")
                .required(true)
                .in(ParameterType.HEADER)
                .required(false)
                .build()
        );
        return parameters;
    }


    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("乐享校园二手服务平台")  //标题
                .description("乐享校园二手服务平台")  //描述
                .version("1.0")  //版本
                .contact(new Contact("wxp", "http:localhost:8082/doc.html", "2889703293@qq.com"))  //联系信息
                .build();
    }
}
