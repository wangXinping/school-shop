package com.shop.schoolshop.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.UUID;

/**
 * 上传与下载图片
 */
@Component
public class FileUpLoadAndDownLoadUtil {

    @Value("${lex.filepath}")
    private String filepath;

    /**
     * 上传图片
     * @param file
     * @return
     */
    public String fileUpLoad(MultipartFile file){
        //截取文件后缀名
        String suffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));

        //随机生成文件名，防止重复文件覆盖
        String fileName = UUID.randomUUID().toString() + suffix;

        //创建一个目录文件
        File dir = new File(filepath);
        if (!dir.exists()){
            //若目录不存在，在需要创建
            dir.mkdirs();
        }

        try {
            //将文件存放到相应的路径中
            file.transferTo(new File(filepath + fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileName;
    }

    /**
     * 下载图片
     * @param fileName
     * @param response
     */
    public void fileDownLoad(String fileName, HttpServletResponse response){

        try {
            //输入流，通过输入流读取文件内容
            FileInputStream fileInputStream = new FileInputStream(new File(filepath + fileName));

            //输出流，通过输出流写回浏览器并显示
            ServletOutputStream outputStream = response.getOutputStream();

            int len = 0;
            byte[] bytes = new byte[1024];
            while ((len = fileInputStream.read(bytes)) != -1){
                outputStream.write(bytes,0,len);//写入浏览器
                outputStream.flush();//刷新
            }

            outputStream.close();
            fileInputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
