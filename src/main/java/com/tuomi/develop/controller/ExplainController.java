package com.tuomi.develop.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tuomi.develop.base.BaseResult;
import com.tuomi.develop.base.Constant;
import com.tuomi.develop.entity.Explain;
import com.tuomi.develop.service.ExplainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
/**
 * @version: V1.0
 * @description: 名词解释controller类
 * @date 2019/6/6 10:16
 */
import java.util.Map;
@Controller
public class ExplainController {

    @Autowired
    private ExplainService explainService;

    /**
     * @version: V1.0
     * @description: 根据类别名称查询名词接受类容的方法
     * @date 2019/6/6 10:16
     */
    @RequestMapping(value = "/selectByCategory",produces= {"application/json;charset=UTF-8"},method=RequestMethod.POST)
    @ResponseBody
    public String selectByCategory( String category){
        List<Explain> explains = explainService.selectByCategory(category);
        BaseResult baseResult = new BaseResult(1,Constant.success,explains);
        String toJSONString = JSON.toJSONString(baseResult);
        return toJSONString;
    }
    /**
     * @version: V1.0
     * @description: 帮助管理的所有数据分页
     * @date 2019/6/27 
     */
    @RequestMapping("/getExplainAll")
    @ResponseBody
    public Map<String, Object> page(
    		@RequestParam(defaultValue = "1",required = true,value = "page")int page,
    		@RequestParam(defaultValue = "10",required = true,value = "limit")int limit){
    	PageHelper.startPage(page, limit);
    	List<Explain> list = explainService.getExplainAll();
    	PageInfo<Explain> info = new PageInfo<>(list);
    	Map<String, Object> map=new HashMap<>();
    	map.put("code", "0");
    	map.put("msg", "ok");
    	map.put("count", info.getTotal());
    	map.put("data", info.getList());
    	return map;
    }
    /**
     * @version: V1.0
     * @description: 帮助管理的保存与修改
     * @date 2019/6/27 
     */
    @RequestMapping("/ExplainSaveOrEdit")
    @ResponseBody
    public Map<String, Object> saveOrEdit(Explain explain){
    	System.out.println(explain);
    	Map<String, Object> map=new HashMap<>();
    	try {
			if(explain.getId()!=null) {
				explainService.edit(explain);
			}else {
				explainService.save(explain);
			}
			map.put("success", true);
		} catch (Exception e) {
			e.printStackTrace();
			map.put("success", false);
		}
    	return map;
    }
    /**
     * @version: V1.0
     * @description: 帮助管理的删除
     * @date 2019/6/27 
     */
    @RequestMapping("/ExplainDel")
    @ResponseBody
    public Map<String, Object> del(Integer id){
    	Map<String, Object> map=new HashMap<>();
    	try {
    		explainService.del(id);
			map.put("success", true);
		} catch (Exception e) {
			e.printStackTrace();
			map.put("success", false);
		}
    	return map;
    }
    
}
