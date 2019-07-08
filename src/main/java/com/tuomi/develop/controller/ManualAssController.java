package com.tuomi.develop.controller;

import com.alibaba.fastjson.JSON;
import com.tuomi.develop.base.BaseResult;
import com.tuomi.develop.base.Constant;
import com.tuomi.develop.entity.ManualAss;
import com.tuomi.develop.entity.Notice;
import com.tuomi.develop.entity.User;
import com.tuomi.develop.push.PushIos;
import com.tuomi.develop.service.ManualAssService;
import com.tuomi.develop.service.NoticeService;
import com.tuomi.develop.service.UserService;
import com.tuomi.develop.util.FileUpload;


import com.tuomi.develop.util.TimeUtil;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.util.WebUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

/**
 * @version: V1.0
 * @description: 人工评估controller类
 * @date 2019/6/4 16:41
 */
@Controller
public class ManualAssController {

    @Autowired
    private ManualAssService manualAssService;
    @Autowired
    private UserService userService;
    @Autowired
    private NoticeService noticeService;

    /**
     * @version: V1.0
     * @description: 接受用户输入的人工评估信息，并存入数据库
     * @date 2019/6/4 16:41
     */
    @RequestMapping(value = "/insertManualAss",produces= {"application/json;charset=UTF-8"},method=RequestMethod.POST)
    @ResponseBody
    public String insertManualAss(ManualAss manualAss, HttpServletRequest request){
        System.out.println(manualAss);
        String toJSONString = "";
        BaseResult baseResult = null;
        MultipartFile file = null;
        if (manualAss.getProduct() != null){
            manualAss.setStatus(0);
            boolean isMultipart = ServletFileUpload.isMultipartContent(request);
            if (isMultipart){
                MultipartHttpServletRequest multipartRequest =
                        WebUtils.getNativeRequest(request,MultipartHttpServletRequest.class);
                file = multipartRequest.getFile("file1");
            }
            //文件上传
            if (file != null){
                FileUpload.upload(file,request);
                String originalFilename = file.getOriginalFilename();
                manualAss.setFile(originalFilename);
                manualAss.setIsFile(1);
                baseResult = new BaseResult(1,"文件上传成功",manualAss);
                toJSONString = JSON.toJSONString(baseResult);
            }else {
                manualAss.setIsFile(0);
                baseResult = new BaseResult(1,"不带文件上传成功",manualAss);
                toJSONString = JSON.toJSONString(baseResult);
            }
            int i = manualAssService.insertSelective(manualAss);
        }else {
            baseResult = new BaseResult(0,"上传失败",manualAss);
            toJSONString = JSON.toJSONString(baseResult);
        }
        return toJSONString;
    }

    /**
     * @version: V1.0
     * @description: 根据用户id查询所有人工评估数据的方法
     * @date 2019/6/6 10:24
     */
    @RequestMapping(value = "/selectManualByUserId",produces= {"application/json;charset=UTF-8"},method=RequestMethod.POST)
    @ResponseBody
    public String selectManualByUserId(Integer userId){
        List<ManualAss> manualAsses = manualAssService.selectManualByUserId(userId);
        for (ManualAss manualAss :manualAsses) {
            if (manualAss.getFile()!=null){
                manualAss.setFile("/develop/static/upload/"+manualAss.getFile());
            }
        }
        BaseResult baseResult = new BaseResult(1,Constant.success,manualAsses);
        String toJSONString = JSON.toJSONString(baseResult);
        return toJSONString;
    }

    /**
     * @version: V1.0
     * @description: 根据id删除人工评估
     * @date 2019/6/17 15:08
     */
    @RequestMapping(value = "/deleteManualAssById",produces= {"application/json;charset=UTF-8"},method=RequestMethod.POST)
    @ResponseBody
    public String deleteManualAssById(Integer id){
        int i = manualAssService.deleteByPrimaryKey(id);
        int i1 = noticeService.deleteByManualId(id);
        BaseResult baseResult = new BaseResult(1,Constant.success);
        String toJSONString = JSON.toJSONString(baseResult);
        return toJSONString;
    }

    /**
     * @version: V1.0
     * @description: 后台查询所有人工评估
     * @date 2019/6/17 15:09
     */
    @RequestMapping(value = "/selectAllManual")
    @ResponseBody
    public String selectAllManual(){
        List<ManualAss> manualAsses = manualAssService.selectAll();
        for (ManualAss manualAss :manualAsses) {
            if (manualAss.getFile()!=null){
                manualAss.setFile("/develop/static/upload/"+manualAss.getFile());
            }
        }
        BaseResult baseResult = new BaseResult(1,Constant.success,manualAsses);
        String toJSONString = JSON.toJSONString(baseResult);
        return toJSONString;
    }

    /**
     * @version: V1.0
     * @description: 查询未回复的人工评估
     * @date 2019/6/17 15:09
     */
    @RequestMapping(value = "/selectNoResp")
    @ResponseBody
    public String selectNoResp(){
        List<ManualAss> manualAsses = manualAssService.selectNoResp();
        for (ManualAss manualAss :manualAsses) {
            if (manualAss.getFile()!=null){
                manualAss.setFile("/develop/static/upload/"+manualAss.getFile());
            }
        }
        BaseResult baseResult = new BaseResult(1,Constant.success,manualAsses);
        String toJSONString = JSON.toJSONString(baseResult);
        return toJSONString;
    }

    /**
     * @version: V1.0
     * @description: 查询已回复的人工评估
     * @date 2019/6/17 15:10
     */
    @RequestMapping(value = "/selectResp")
    @ResponseBody
    public String selectResp(){
        List<ManualAss> manualAsses = manualAssService.selectResp();
        for (ManualAss manualAss :manualAsses) {
            if (manualAss.getFile()!=null){
                manualAss.setFile("/develop/static/upload/"+manualAss.getFile());
            }
        }
        BaseResult baseResult = new BaseResult(1,Constant.success,manualAsses);
        String toJSONString = JSON.toJSONString(baseResult);
        return toJSONString;
    }

    /**
     * @version: V1.0
     * @description: 根据id查询人工评估
     * @date 2019/6/17 15:11
     */
    @RequestMapping(value = "/selectManualById",produces= {"application/json;charset=UTF-8"},method=RequestMethod.POST)
    @ResponseBody
    public String selectManualById(Integer id , Integer noticeId){
        ManualAss manualAss = manualAssService.selectByPrimaryKey(id);
        if (manualAss.getFile()!=null){
            manualAss.setFile("/develop/static/upload/"+manualAss.getFile());
        }
        if (noticeId != null){
            Notice notice = noticeService.selectByPrimaryKey(noticeId);
            notice.setStatus(1);
            noticeService.updateByPrimaryKeySelective(notice);
        }
        BaseResult baseResult = new BaseResult(1,Constant.success,manualAss);
        String toJSONString = JSON.toJSONString(baseResult);
        return toJSONString;
    }

    /**
     * @version: V1.0
     * @description: 根据id修改人工评估
     * @date 2019/6/17 15:11
     */
    @RequestMapping(value = "/updateManualById")
    @ResponseBody
    public String updateManualById(ManualAss manualAss) throws Exception {
        System.out.println(manualAss);
        manualAss.setStatus(1);
        int i = manualAssService.updateByPrimaryKeySelective(manualAss);
        Notice notice = new Notice();
        notice.setProduct(manualAss.getProduct());
        notice.setTips("你要评估的产品已经回复啦，快去查看吧！");
        notice.setStatus(0);
        notice.setIsFile(manualAss.getIsFile());
        notice.setReplyTime(TimeUtil.getTime(new Date()));
        notice.setUserId(manualAss.getUserId());
        notice.setpId(manualAss.getId());
        Notice notice1 = noticeService.selectByManualId(manualAss.getId());
        if (notice1 != null){
            noticeService.updateByPrimaryKeySelective(notice);
        }else{
            noticeService.insertSelective(notice);
        }
        Integer lastId = noticeService.selectMaxId();
        Integer noticeId = lastId + 1;
        //回复后发单用户推送
        User user = userService.selectByPrimaryKey(manualAss.getUserId());
        PushIos pushIos = new PushIos();
        pushIos.sendIOSUnicast(user.getToken(),Constant.message,String.valueOf(manualAss.getId()),String.valueOf(noticeId));
        user.setStatus(0);
        int i1 = userService.updateByPrimaryKeySelective(user);
        String toJSONString = "";
        BaseResult baseResult = null;
        if (i==1 && i1==1 && user != null){
            baseResult = new BaseResult(1,"回复成功！",manualAss);
            toJSONString = JSON.toJSONString(baseResult);
        }else{
            baseResult = new BaseResult(0,"回复失败！");
            toJSONString = JSON.toJSONString(baseResult);
        }
        return toJSONString;
    }
}
