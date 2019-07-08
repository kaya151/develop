package com.tuomi.develop.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
/**
 * 上传类
 * @author PC
 *
 */
@Controller
@RequestMapping("/upload")
public class UploadImgController {

	/**
	 * 图片上传方法
	 * @param file
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/headImg", method = {RequestMethod.POST})
	@ResponseBody
	public Object headImg(
			@RequestParam(value="file",required=false) MultipartFile file, 
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		String prefix="";
	    String dateStr="";
	    String originalName ="";
		//保存上传
	     OutputStream out = null;
	    InputStream fileInput=null;
	    try{
	        if(file!=null){
	            originalName = file.getOriginalFilename();
	            prefix=originalName.substring(originalName.lastIndexOf(".")+1);
	            SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
	            dateStr = sdf.format(new Date());
	            //String filepath = request.getSession().getServletContext().getRealPath("/develop/")+originalName;
	            String filepath ="/opt/apache-tomcat-8.5.42/develop/"+originalName;
	            //String filepath="http://47.99.138.92:8081/develop/static/upload/";
				File files=new File(filepath);
	            //打印查看上传路径
	            System.out.println(filepath);
	            if(!files.getParentFile().exists()){
	                files.getParentFile().mkdirs();
	            }
	            file.transferTo(files);
	        }
	    }catch (Exception e){
	    	
	    }finally{
	        try {
	            if(out!=null){
	                out.close();
	            }
	            if(fileInput!=null){
	                fileInput.close();
	            }
	        } catch (IOException e) {
	        }
	    }
	    Map<String,Object> map2=new HashMap<>();
	    Map<String,Object> map=new HashMap<>();
	    map.put("code",0);
	    map.put("msg","");
	    map.put("data",map2);
	    map2.put("src","http://47.99.138.92:8081/develop/static/upload/"+ dateStr +"_"+originalName);
	    return map;
	}
}
