package com.tuomi.develop.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tuomi.develop.base.BaseResult;
import com.tuomi.develop.base.Constant;
import com.tuomi.develop.entity.DevelopAss;
import com.tuomi.develop.entity.DevelopTwo;
import com.tuomi.develop.service.DevelopTwoService;
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
 * @description: 二级页面controller类
 * @date 2019/6/4 14:49
 */
import java.util.Map;
@Controller
public class DevelopTwoController {

    @Autowired
    private DevelopTwoService developTwoService;

    /**
     * @version: V1.0
     * @description: 查询APP或小程序2级页面方法
     * @date 2019/6/4 14:49
     */
    @RequestMapping(value = "/selectListByFatherId",produces= {"application/json;charset=UTF-8"},method=RequestMethod.POST)
    @ResponseBody
    public String selectListByFatherId(Integer fatherId){
        List<DevelopTwo> developTwos = developTwoService.selectListByFatherId(fatherId);
        for (DevelopTwo developTwo :developTwos) {
            if (!developTwo.getImg().equals("")){
                developTwo.setImg("/develop/static/upload/"+developTwo.getImg());
            }
        }
        BaseResult baseResult = new BaseResult(1,Constant.success,developTwos);
        String toJSONString = JSON.toJSONString(baseResult);
        return toJSONString;
    }
    /**
     * @version: V1.0
     * @description: 查询DevelopTwo根据父id
     * @date 2019/6/27 
     */
    @RequestMapping("/getTwoById")
    @ResponseBody
    public List<DevelopTwo> list(Integer fatherId){
    	return developTwoService.selectListByFatherId(fatherId);
    }
    /**
     * @version: V1.0
     * @description: 查询DevelopTwo一条数据根据id
     * @date 2019/6/27 
     */
    @RequestMapping("/getTwoByKeyId")
    @ResponseBody
    public DevelopTwo getTwoByKeyId(Integer id){
    	return developTwoService.selectByPrimaryKey(id);
    }
    /**
     * @version: V1.0
     * @description: 查询二级所有数据分页
     * @date 2019/6/27 
     */
    @RequestMapping("/getTwoAll")
    @ResponseBody
    public Map<String, Object> page(
    		@RequestParam(defaultValue = "1",value = "page",required=true)int pageNum,
    		@RequestParam(defaultValue = "10",value = "limit",required=true)int pageSize){
    	PageHelper.startPage(pageNum, pageSize);
    	List<DevelopTwo> list = developTwoService.getAll();
    	for (DevelopTwo developTwo :list) {
            if (!developTwo.getImg().equals("")){
                developTwo.setImg("http://47.99.138.92:8081/develop/static/upload/"+developTwo.getImg());
            }
        }
    	PageInfo<DevelopTwo> info = new PageInfo<>(list);
    	Map<String, Object> map=new HashMap<String, Object>();
    	map.put("code", "0");
    	map.put("msg", "ok");
    	map.put("count", info.getTotal());
    	map.put("data", info.getList());
    	return map;
    }
    /**
     * @version: V1.0
     * @description: 二级菜单的保存与修改
     * @date 2019/6/27 
     */
    @RequestMapping("/DevelopTwoSaveOrEdit")
    @ResponseBody
    public Map<String, Object> saveOrEdit(DevelopTwo two){
    	Map<String, Object> map=new HashMap<>();
    	try {
			if(two.getId()!=null) {
				developTwoService.edit(two);
			}else {
				developTwoService.save(two);
			}
			map.put("success", true);
		} catch (Exception e) {
			map.put("success", false);
		}
    	return map;
    }
    /**
     * @version: V1.0
     * @description: 二级菜单的删除
     * @date 2019/6/27 
     */
    @RequestMapping("/DevelopTwoDel")
    @ResponseBody
    public Map<String, Object> del(Integer id){
    	Map<String, Object> map =new HashMap<>();
    	try {
    		developTwoService.del(id);
    		map.put("success", true);
		} catch (Exception e) {
			e.printStackTrace();
			map.put("success", false);
		}
    	return map;
    }
    /**
     * @version: V1.0
     * @description: 查询二级菜单的所有数据
     * @date 2019/6/27 
     */
    @RequestMapping("/DevelopTwoAlls")
    @ResponseBody
    public List<DevelopTwo> getlist(){
    	return developTwoService.getAll();
    }
}
