package com.shop.schoolshop.exception;

import com.shop.schoolshop.pojo.ResultBean;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalException {

    @ExceptionHandler(ServiceException.class)
    @ResponseBody
    public ResultBean serviceExcpetion(ServiceException e){
        return ResultBean.error(e.getCode(),e.getMessage());
    }
}
