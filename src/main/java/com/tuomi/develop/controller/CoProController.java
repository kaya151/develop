package com.tuomi.develop.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tuomi.develop.entity.CoPro;
import com.tuomi.develop.service.CoProService;
/**
 * 
 * @version: V1.0
 * @description: 竞品管理类
 * @author wangcong
 * @date 2019/7/3
 *
 */
@Controller
@RequestMapping("/copro")
public class CoProController {

	@Autowired
	private CoProService coProService;
	/**
	 * @description:获取所有数据
	 * @param pageNum
	 * @param pageSize
	 * @return layui要求的格式
	 */
	@RequestMapping("/getAll")
	@ResponseBody
	public Map<String, Object> page(
			@RequestParam(defaultValue = "1",value = "page",required=true)int pageNum,
    		@RequestParam(defaultValue = "10",value = "limit",required=true)int pageSize){
		Map<String, Object> map=new HashMap<>();
		PageHelper.startPage(pageNum, pageSize);
		List<CoPro> list = coProService.getAll();
		PageInfo<CoPro> info = new PageInfo<>(list);
		map.put("code", "0");
    	map.put("msg", "ok");
    	map.put("count", info.getTotal());
    	map.put("data", info.getList());
    	return map;
	}
	/***
	 * @description:保存和修改方法
	 * @param coPro
	 * @return layui要求的格式
	 */
	@RequestMapping("/saveOrEdit")
	@ResponseBody
	public Map<String, Object> saveOrEdit(CoPro coPro){
		Map<String, Object> map=new HashMap<>();
		try {
			if(coPro.getId()!=null) {
				coProService.edit(coPro);
			}else {
				coProService.save(coPro);
			}
			map.put("success", true);
		} catch (Exception e) {
			e.printStackTrace();
			map.put("success", false);
		}
		return map;
	}
	/**
	 * @description:删除方法
	 * @param id
	 * @return layui要求的格式
	 */
	@RequestMapping("/del")
	@ResponseBody
	public Map<String, Object> del(Long id){
		Map<String, Object> map=new HashMap<>();
		try {
			coProService.del(id);
			map.put("success", true);
		} catch (Exception e) {
			e.printStackTrace();
			map.put("success", false);
		}
		return map;
	}
}
