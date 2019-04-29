package com.readboy.ssm.newtest.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.readboy.ssm.newtest.domain.DemoQq;
import com.readboy.ssm.newtest.service.IDemoQqService;
import com.readboy.ssm.newtest.util.domain.Assist;
import com.readboy.ssm.newtest.util.domain.PageData;

@RestController
@RequestMapping("/demo/demoQqRest")
public class DemoQqController {

	@Autowired
	private IDemoQqService demoQqService;
	
	
	/**
	* 分页查询
	*/
	@RequestMapping("/page")
	public PageData<DemoQq> page()  {
		Assist assist = new Assist();
		PageData<DemoQq> pageData = demoQqService.selectPageCommon(assist,1,10);
		return pageData;
	}
	
	/**
	* 插入
	*/
	@RequestMapping("/insert")
	public int insert()  {
		DemoQq demoQq = new DemoQq();
		demoQq.setDatePart(new Date());
		demoQq.setDoublePart(33.4);
		demoQq.setStrPart("str");
		return demoQqService.insertDemoQq(demoQq);
	}
	
	/**
	* 条件查询全部
	*/
	@RequestMapping("/list")
	public List<DemoQq> list()  {
		Assist assist = new Assist();
//		assist.setRequires(Assist.andEq("str_part", "str"));
		return demoQqService.selectListCommon(assist);
	}
	
	/**
	* 根据id查询
	*/
	@RequestMapping("/selectById ")
	public DemoQq selectById(int id)  {
		return demoQqService.selectDemoQqById(id);
	}
	
	
	/**
	* 条件更新
	*/
	@RequestMapping("/updateObjCommon ")
	public int updateObjCommon()  {
		Assist assist = new Assist();
		assist.setRequires(Assist.andEq("str_part", "str"));
		DemoQq demoQq = new DemoQq();
		demoQq.setDatePart(new Date());
		return demoQqService.updateObjCommon(demoQq, assist);
	}
	
	
	
	/**
	* 条件删除
	*/
	@RequestMapping("/deleteObjCommon ")
	public int deleteObjCommon()  {
		Assist assist = new Assist();
		assist.setRequires(Assist.andEq("str_part", "str1"));
		return demoQqService.deleteObjCommon(assist);
	}
	
	
	
	
}
