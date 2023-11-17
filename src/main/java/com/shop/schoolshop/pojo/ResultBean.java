package com.shop.schoolshop.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 统一返回的对象
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResultBean {

    private Integer code;  //状态码
    private String msg;   //提示信息
    private Object data;  //返回的数据

    /**
     * 成功返回结果
     * @param msg
     * @return
     */
    public static ResultBean success(String msg){
        ResultBean resultBean = new ResultBean();
        resultBean.setCode(200);
        resultBean.setMsg(msg);
        return resultBean;

    }
    public static ResultBean success(Object data){
        ResultBean resultBean = new ResultBean();
        resultBean.setCode(200);
        resultBean.setMsg("");
        resultBean.setData(data);
        return resultBean;

    }

    /**
     * 成功返回结果
     * @param msg
     * @return
     */
    public static ResultBean success(String msg,Object data){
        ResultBean resultBean = new ResultBean();
        resultBean.setCode(200);
        resultBean.setMsg(msg);
        resultBean.setData(data);
        return resultBean;
    }

    /**
     * 失败返回结果
     * @param msg
     * @return
     */
    public static ResultBean error(Integer code,String msg){
        ResultBean resultBean = new ResultBean();
        resultBean.setCode(code);
        resultBean.setMsg(msg);
        return resultBean;
    }


}
