package com.tuomi.develop.util;



import org.apache.commons.io.FileUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

public class FileUpload {

    public static void upload(MultipartFile file, HttpServletRequest request) {
        String path = request.getContextPath();
        String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
        String realPath ="/opt/apache-tomcat-8.5.42/develop/";  //获取保存的路径,本地磁盘中的一个文件夹
        //使用Apache的FileUtils方法来进行保存
        try {
            FileUtils.copyInputStreamToFile(file.getInputStream(), new File(realPath, file.getOriginalFilename()));
        } catch (IOException e) {
            e.printStackTrace();
        }finally {

        }
    }


}
