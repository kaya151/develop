package com.tuomi.develop.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tuomi.develop.base.LayUIResult;
import com.tuomi.develop.entity.Admin;
import com.tuomi.develop.service.DemoService;

@RequestMapping("/admin")
@Controller
public class DemoController  {
	
	@Autowired
	private DemoService demoService;
	@RequestMapping("/getAll1")
	@ResponseBody
	public LayUIResult index1() {
		  List<Admin> findAll = demoService.findAll();
		return  new LayUIResult(1L, findAll);
	}

	
}
