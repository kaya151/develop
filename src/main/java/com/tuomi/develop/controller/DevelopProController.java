package com.tuomi.develop.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tuomi.develop.base.BaseResult;
import com.tuomi.develop.base.Constant;
import com.tuomi.develop.entity.CoPro;
import com.tuomi.develop.entity.DevelopAss;
import com.tuomi.develop.entity.DevelopPro;
import com.tuomi.develop.entity.DevelopTwo;
import com.tuomi.develop.service.DevelopProService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @version: V1.0
 * @description: 开发评估controller类
 * @date 2019/6/3 17:17
 */
@Controller
public class DevelopProController {

    @Autowired
    private DevelopProService developProService;

    /**
     * @version: V1.0
     * @description: 开发评估价格页面的查询方法
     * @date 2019/6/3 17:18
     */
    @RequestMapping(value = "/selectDevelopPro",produces= {"application/json;charset=UTF-8"},method=RequestMethod.POST)
    @ResponseBody
    public String selectDevelopPro(Integer id){
        DevelopPro developPro = developProService.selectByPrimaryKey(id);
        BaseResult baseResult = new BaseResult(1,Constant.success,developPro);
        String toJSONString = JSON.toJSONString(baseResult);
        return toJSONString;
    }

    /**
     * @version: V1.0
     * @description: APP或小程序3级页面的方法
     * @date 2019/6/4 14:48
     */
    @RequestMapping(value = "/selectListByTwoId",produces= {"application/json;charset=UTF-8"},method=RequestMethod.POST)
    @ResponseBody
    public String selectListByTwoId(Integer twoId){
        List<DevelopPro> developPros = developProService.selectListByTwoId(twoId);
        for (DevelopPro developPro :developPros) {
            if (!developPro.getImg().equals("")){
                developPro.setImg("/develop/static/upload/"+developPro.getImg());
            }
        }
        BaseResult baseResult = new BaseResult(1,Constant.success,developPros);
        String toJSONString = JSON.toJSONString(baseResult);
        return toJSONString;
    }

    /**
     * @version: V1.0
     * @description: 其他开发评估模块2级页面的方法
     * @date 2019/6/4 15:18
     */
    @RequestMapping(value = "/selectListByDevAssId",produces= {"application/json;charset=UTF-8"},method=RequestMethod.POST)
    @ResponseBody
    public String selectListByDevAssId(Integer fatherId){
        List<DevelopPro> developPros = developProService.selectListByFatherId(fatherId);
        BaseResult baseResult = null;
        String toJSONString = "";
        if (developPros != null){
            for (DevelopPro developPro :developPros) {
                if (!developPro.getImg().equals("")){
                    developPro.setImg("/develop/static/upload/"+developPro.getImg());
                }
            }
            baseResult = new BaseResult(1,Constant.success,developPros);
            toJSONString = JSON.toJSONString(baseResult);
        }else {
            baseResult = new BaseResult(0,Constant.error,developPros);
            toJSONString = JSON.toJSONString(baseResult);
        }

        return toJSONString;
    }
    /**
     * @version: V1.0
     * @description: DevelopPro的所有数据根据一级id和二级id
     * @date 2019/6/28 15:18
     */
    @RequestMapping("/getPrById")
    @ResponseBody
    public List<DevelopPro> list(Integer fatherId,Integer twoId){
    	return developProService.getPrByFidAndTid(fatherId, twoId);
    }
    /**
     * @version: V1.0
     * @description: 查询DevelopPro的一条数据根据id
     * @date 2019/6/28 15:18
     */
    @RequestMapping("/findPrById")
    @ResponseBody
    public DevelopPro lists(Integer id){
    	return developProService.selectByPrimaryKey(id);
    }
    /**
     * @version: V1.0
     * @description: 修改方法DevelopPro
     * @date 2019/6/28 15:18
     */
    @RequestMapping(value = "/editPr",method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> edit(DevelopPro developPro,Integer id){
    	System.out.println(developPro);
    	System.out.println(id);
    	Map<String, Object> map =new HashMap<String, Object>();
    	try {
    		developProService.editPr(developPro);
    		map.put("success", true);
		} catch (Exception e) {
			e.printStackTrace();
			map.put("success", false);
		}
    	return map;
    }
    /**
     * @version: V1.0
     * @description: 查询DevelopPro根据父id
     * @date 2019/6/28 15:18
     */
    @RequestMapping("/getPrErId")
    @ResponseBody
    public List<DevelopPro> prer(Integer fid){
    	return developProService.findPrByFid(fid);
    }
    /**
     * @version: V1.0
     * @description: 查询DevelopPro一条数据根据id
     * @date 2019/6/28 15:18
     */
    @RequestMapping("/getPrsId")
    @ResponseBody
    public DevelopPro prer1(Integer id){
    	return developProService.selectByPrimaryKey(id);
    }
    /**
     * @version: V1.0
     * @description: 查询DevelopPro所有数据
     * @date 2019/6/28 15:18
     */
    @RequestMapping("/getPrList")
    @ResponseBody
    public List<DevelopPro> getPrList(){
    	return developProService.getAll();
    }
    /**
     * @version: V1.0
     * @description: 查询三级所有数据分页
     * @date 2019/6/28 15:18
     */
    @RequestMapping("/getDevelopProAll")
    @ResponseBody
    public Map<String, Object> page(
    		@RequestParam(defaultValue = "1",value = "page",required=true)int pageNum,
    		@RequestParam(defaultValue = "10",value = "limit",required=true)int pageSize){
    	Map<String, Object> map=new HashMap<>();
    	PageHelper.startPage(pageNum, pageSize);
    	List<DevelopPro> all = developProService.getAll();
    	for (DevelopPro developPro : all) {
    			developPro.setImg("http://47.99.138.92:8081/develop/static/upload/"+developPro.getImg());
    			//developPro.setCompetingProducts();
    			List<CoPro> productsId = developPro.getCompetingProductsId();
    			if(productsId.size()>0) {
    				String str="";
    				for (CoPro coPro : productsId) {
    					str+=coPro.getName()+",";
    				}
        			if(str.endsWith(",")) {
        				str = str.substring(0,str.length() - 1);
        			}
        			developPro.setCompetingProducts(str);
    			}
    			
		}
    	PageInfo<DevelopPro> info = new PageInfo<>(all);
    	map.put("code", "0");
    	map.put("msg", "ok");
    	map.put("count", info.getTotal());
    	map.put("data", info.getList());
    	return map;
    }
    /**
     * @version: V1.0
     * @description: 保存与修改方法
     * @date 2019/6/28 15:18
     */
    @RequestMapping("/DevelopProSaveOrEdit")
    @ResponseBody
    public Map<String, Object> saveOrEdit(DevelopPro pro){
    	Map<String, Object> map=new HashMap<>();
    	try {
			if(pro.getId()!=null) {
				developProService.edit(pro);
			}else {
				developProService.save(pro);
			}
			map.put("success", true);
		} catch (Exception e) {
			map.put("success", false);
		}
    	return map;
    }
    /**
     * @version: V1.0
     * @description: 三级的删除方法根据id
     * @date 2019/6/28 15:18
     */
    @RequestMapping("/DevelopProDel")
    @ResponseBody
    public Map<String, Object> del(Integer id){
    	Map<String, Object> map =new HashMap<>();
    	try {
    		developProService.del(id);
    		map.put("success", true);
		} catch (Exception e) {
			e.printStackTrace();
			map.put("success", false);
		}
    	return map;
    }
    
}
