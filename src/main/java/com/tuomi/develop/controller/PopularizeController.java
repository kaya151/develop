package com.tuomi.develop.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tuomi.develop.base.BaseResult;
import com.tuomi.develop.base.Constant;
import com.tuomi.develop.entity.DevelopPro;
import com.tuomi.develop.entity.PopularizeAss;
import com.tuomi.develop.entity.PopularizePro;
import com.tuomi.develop.service.PopularizeAssService;
import com.tuomi.develop.service.PopularizeProService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * @version: V1.0
 * @description: 推广评估controller类
 * @date 2019/6/4 16:42
 */
@Controller
public class PopularizeController {

    @Autowired
    private PopularizeAssService popularizeAssService;

    @Autowired
    private PopularizeProService popularizeProService;

    /**
     * @version: V1.0
     * @description: 查出所有的父级、子级菜单
     * @date 2019/6/4 16:42
     */
    @RequestMapping(value = "/selectPopuList",produces= {"application/json;charset=UTF-8"},method=RequestMethod.POST)
    @ResponseBody
    public String selectPopuList(){
        List<PopularizeAss> popularizeAsses = popularizeAssService.selectList();
        for (PopularizeAss popularizeAss :popularizeAsses) {
            if (!popularizeAss.getImg().equals("")){
                popularizeAss.setImg("/develop/static/upload/"+popularizeAss.getImg());
            }
        }
        List<PopularizePro> popularizePros = popularizeProService.selectList();
        for (PopularizePro popularizePro :popularizePros) {
            if (!popularizePro.getImg().equals("")){
                popularizePro.setImg("/develop/static/upload/"+popularizePro.getImg());
            }
        }
        for (int i = 0;i<popularizeAsses.size();i++) {
            List<PopularizePro> list = new ArrayList<>();
            for (int j = 0;j<popularizePros.size();j++){
                if (popularizeAsses.get(i).getId() == popularizePros.get(j).getFatherId()){
                    list.add(popularizePros.get(j));
                    popularizeAsses.get(i).setList(list);
                }
            }
        }
        BaseResult baseResult = new BaseResult(1,Constant.success,popularizeAsses);
        String toJSONString = JSON.toJSONString(baseResult);
        return toJSONString;
    }

    /**
     * @version: V1.0
     * @description: 根据用户选择的菜单查出价格
     * @date 2019/6/4 16:43
     */
    @RequestMapping(value = "/selectPrice",produces= {"application/json;charset=UTF-8"},method=RequestMethod.POST)
    @ResponseBody
    public String selectPrice(String popuId){
        String toJSONString = "";
        BaseResult baseResult = null;
        if (popuId != null){
            String[] split = popuId.split(",");
            Integer cost = 0 ;
            for (String id:split) {
                PopularizePro popularizePro = popularizeProService.selectByPrimaryKey(Integer.valueOf(id));
                cost += popularizePro.getPrice();
            }
            baseResult = new BaseResult(1,Constant.success,cost);
            toJSONString = JSON.toJSONString(baseResult);
        }else{
            baseResult = new BaseResult(0,Constant.error);
            toJSONString = JSON.toJSONString(baseResult);
        }
        return toJSONString;
    }
    /**
     * @version: V1.0
     * @description: 推广评估一级的所有数据分页
     * @date 2019/7/2
     */
    @RequestMapping("/getPopularizeAssAll")
    @ResponseBody
    public Map<String, Object> page(
    		@RequestParam(defaultValue = "1",value = "page",required=true)int pageNum,
    		@RequestParam(defaultValue = "10",value = "limit",required=true)int pageSize){
    	Map<String, Object> map=new HashMap<>();
    	PageHelper.startPage(pageNum, pageSize);
    	List<PopularizeAss> all = popularizeAssService.getAll();
    	for (PopularizeAss developPro : all) {
    			developPro.setImg("http://47.99.138.92:8081/develop/static/upload/"+developPro.getImg());
		}
    	PageInfo<PopularizeAss> info = new PageInfo<>(all);
    	map.put("code", "0");
    	map.put("msg", "ok");
    	map.put("count", info.getTotal());
    	map.put("data", info.getList());
    	return map;
    }
    /**
     * @version: V1.0
     * @description: 推广评估一级的保存与修改
     * @date 2019/7/2
     */
    @RequestMapping("/PopularizeAssSaveOrEdit")
    @ResponseBody
    public Map<String, Object> saveOrEdit(PopularizeAss ass){
    	Map<String, Object> map=new HashMap<>();
    	try {
			if(ass.getId()!=null) {
				popularizeAssService.edit(ass);
			}else {
				popularizeAssService.save(ass);
			}
			map.put("success", true);
		} catch (Exception e) {
			map.put("success", false);
		}
    	return map;
    }
    /**
     * @version: V1.0
     * @description: 推广评估一级的删除
     * @date 2019/7/2
     */
    @RequestMapping("/PopularizeAssDel")
    @ResponseBody
    public Map<String, Object> del(Integer id){
    	Map<String, Object> map =new HashMap<>();
    	try {
    		popularizeAssService.del(id);
    		map.put("success", true);
		} catch (Exception e) {
			e.printStackTrace();
			map.put("success", false);
		}
    	return map;
    }
    /**
     * @version: V1.0
     * @description: 推广评估一级的一条数据根据id
     * @date 2019/7/2
     */
    @RequestMapping("/getPopularizeAssById")
    @ResponseBody
    public PopularizeAss getPopularizeAssList(Integer id){
    	return popularizeAssService.selectByPrimaryKey(id);
    }
    /**
     * @version: V1.0
     * @description: 推广评估一级的所有数据
     * @date 2019/7/2
     */
    @RequestMapping("/getPopularizeAssList")
    @ResponseBody
    public List<PopularizeAss> getPopularizeAssList1(){
    	return popularizeAssService.getAll();
    }
    
    
    /**
     * @version: V1.0
     * @description: 推广评估二级的所有数据分页
     * @date 2019/7/2
     */
    @RequestMapping("/getPopularizeProAll")
    @ResponseBody
    public Map<String, Object> page1(
    		@RequestParam(defaultValue = "1",value = "page",required=true)int pageNum,
    		@RequestParam(defaultValue = "10",value = "limit",required=true)int pageSize){
    	Map<String, Object> map=new HashMap<>();
    	PageHelper.startPage(pageNum, pageSize);
    	List<PopularizePro> all = popularizeProService.getAll();
    	for (PopularizePro developPro : all) {
    			developPro.setImg("http://47.99.138.92:8081/develop/static/upload/"+developPro.getImg());
		}
    	PageInfo<PopularizePro> info = new PageInfo<>(all);
    	map.put("code", "0");
    	map.put("msg", "ok");
    	map.put("count", info.getTotal());
    	map.put("data", info.getList());
    	return map;
    }
    /**
     * @version: V1.0
     * @description: 推广评估二级的保存与修改
     * @date 2019/7/2
     */
    @RequestMapping("/PopularizeProSaveOrEdit")
    @ResponseBody
    public Map<String, Object> saveOrEdit1(PopularizePro ass){
    	Map<String, Object> map=new HashMap<>();
    	try {
			if(ass.getId()!=null) {
				popularizeProService.edit(ass);
			}else {
				popularizeProService.save(ass);
			}
			map.put("success", true);
		} catch (Exception e) {
			map.put("success", false);
		}
    	return map;
    }
    /**
     * @version: V1.0
     * @description: 推广评估二级的删除方法
     * @date 2019/7/2
     */
    @RequestMapping("/PopularizeProDel")
    @ResponseBody
    public Map<String, Object> del1(Integer id){
    	Map<String, Object> map =new HashMap<>();
    	try {
    		popularizeProService.del(id);
    		map.put("success", true);
		} catch (Exception e) {
			e.printStackTrace();
			map.put("success", false);
		}
    	return map;
    }
}
