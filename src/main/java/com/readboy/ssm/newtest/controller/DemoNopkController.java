package com.readboy.ssm.newtest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.readboy.ssm.newtest.domain.DemoNopk;
import com.readboy.ssm.newtest.service.IDemoNopkService;
import com.readboy.ssm.newtest.util.domain.Assist;
import com.readboy.ssm.newtest.util.domain.PageData;

@RestController
@RequestMapping("/demo/demoNopkRest")
public class DemoNopkController {

	@Autowired
	private IDemoNopkService demoNopkService;
	
	
	/**
	* 分页查询
	*/
	@RequestMapping("/page")
	public PageData<DemoNopk> page()  {
		Assist assist = new Assist();
		assist.setRequires(Assist.andEq("t1", "tt"));
		PageData<DemoNopk> pageData = demoNopkService.selectPageCommon(assist,1,10);
		return pageData;
	}
	
	/**
	* 插入
	*/
	@RequestMapping("/insert")
	public int insert()  {
		DemoNopk demoNopk = new DemoNopk();
		demoNopk.setDfdf("dd");
		demoNopk.setT1("tt");
		return demoNopkService.insertDemoNopk(demoNopk);
	}
	
	/**
	* 条件查询全部
	*/
	@RequestMapping("/list")
	public List<DemoNopk> list()  {
		Assist assist = new Assist();
		assist.setRequires(Assist.andEq("t1", "tt"));
		return demoNopkService.selectListCommon(assist);
	}
	
	
	
	
	/**
	* 条件更新
	*/
	@RequestMapping("/updateObjCommon ")
	public int updateObjCommon()  {
		Assist assist = new Assist();
		assist.setRequires(Assist.andEq("t1", "tt"));
		DemoNopk demoNopk = new DemoNopk();
		demoNopk.setDfdf("newddd");
		return demoNopkService.updateObjCommon(demoNopk, assist);
	}
	
	
	/**
	* 条件删除
	*/
	@RequestMapping("/deleteObjCommon ")
	public int deleteObjCommon()  {
		Assist assist = new Assist();
		assist.setRequires(Assist.andEq("t1", "tt"));
		return demoNopkService.deleteObjCommon(assist);
	}
	
}
