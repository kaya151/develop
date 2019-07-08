package com.tuomi.develop.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tuomi.develop.base.BaseResult;
import com.tuomi.develop.base.Constant;
import com.tuomi.develop.entity.DevelopAss;
import com.tuomi.develop.entity.ManualAss;
import com.tuomi.develop.service.DevelopAssService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
/**
 * @version: V1.0
 * @description: 开发评估父级controller类
 * @date 2019/6/4 11:31
 */
import java.util.Map;
@Controller
public class DevelopAssController {

    @Autowired
    private DevelopAssService developAssService;

    /**
     * @version: V1.0
     * @description: 查询开发评估父级菜单list方法
     * @date 2019/6/4 11:31
     */
    @RequestMapping(value = "/selectDevelopAssList",produces= {"application/json;charset=UTF-8"},method=RequestMethod.GET)
    @ResponseBody
    public String selectDevelopAssList(){
        List<DevelopAss> developAsses = developAssService.selectList();
        for (DevelopAss developAss :developAsses) {
            if (!developAss.getFile().equals("")){
                developAss.setFile("/develop/static/upload/"+developAss.getFile());
            }
        } 
        BaseResult baseResult = new BaseResult(1,Constant.success,developAsses);
        String toJSONString = JSON.toJSONString(baseResult);
        return toJSONString;
    }
    /**
     * @version: V1.0
     * @description: 查询开发评估父级菜单
     * @date 2019/6/28
     */
    @RequestMapping("/getFirstParentMenu")
    @ResponseBody
    public Map<String, Object> getFirstParentMenut(
    		@RequestParam(defaultValue = "1",value = "page",required=true)int pageNum,
    		@RequestParam(defaultValue = "10",value = "limit",required=true)int pageSize) {
    	Map<String, Object> map=new HashMap<>();
    	PageHelper.startPage(pageNum, pageSize);
    	List<DevelopAss> list = developAssService.selectList();
    	for (DevelopAss developAss : list) {
    		if (!developAss.getFile().equals("")){
                developAss.setFile("http://47.99.138.92:8081/develop/static/upload/"+developAss.getFile());
            } 
		}
    	PageInfo<DevelopAss> info = new PageInfo<>(list);
    	map.put("code", "0");
    	map.put("msg", "ok");
    	map.put("count", info.getTotal());
    	map.put("data", info.getList());
    	return map;
    }
    /**
     * @version: V1.0
     * @description: 查询开发评估一级菜单
     * @date 2019/6/28
     */
    @RequestMapping("/DevelopAssSaveOrEdit")
    @ResponseBody
    public Map<String, Object> saveOrEdit(DevelopAss ass){
    	Map<String, Object> map=new HashMap<>();
    	try {
			if(ass.getId()!=null) {
				developAssService.edit(ass);
			}else {
				developAssService.save(ass);
			}
			map.put("success", true);
		} catch (Exception e) {
			map.put("success", false);
		}
    	return map;
    }
    /**
     * @version: V1.0
     * @description: 查询ass所有数据
     * @date 2019/6/28
     */
    @RequestMapping("/getAssAll")
    @ResponseBody
    public List<DevelopAss> list(){
    	return developAssService.getAll();
    }
    /**
     * @version: V1.0
     * @description: 查询一条数据根据id
     * @date 2019/6/28
     */
    @RequestMapping("/getAssById")
    @ResponseBody
    public DevelopAss getAssById(Integer id){
    	return developAssService.selectByPrimaryKey(id);
    }
    /**
     * @version: V1.0
     * @description: 查询所有数据根据类型
     * @date 2019/6/28
     */
    @RequestMapping("/getAllByType")
    @ResponseBody
    public List<DevelopAss> lists(){
    	return developAssService.getAllByType();
    }
    /**
     * @version: V1.0
     * @description: 删除develop根据id
     * @date 2019/6/28
     */
    @RequestMapping("/DevelopDel")
    @ResponseBody
    public Map<String, Object> del(Integer id){
    	Map<String, Object> map =new HashMap<>();
    	try {
    		developAssService.del(id);
    		map.put("success", true);
		} catch (Exception e) {
			e.printStackTrace();
			map.put("success", false);
		}
    	return map;
    }
}
