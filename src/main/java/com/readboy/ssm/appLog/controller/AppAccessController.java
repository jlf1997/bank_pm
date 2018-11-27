package com.readboy.ssm.appLog.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.readboy.ssm.appLog.model.SysBasQypz;
import com.readboy.ssm.appLog.service.AppAccessService;
import com.readboy.ssm.utils.Constants;


@RestController
@RequestMapping("/mobile/qyoz")
public class AppAccessController {
	
	@Autowired
	private AppAccessService appAccessService;

	//获取区域列表
	@RequestMapping(value="/list.action")
	public List<SysBasQypz> getSysBasQypzList(){
		
		
		return appAccessService.getSysBasQypzList();
		
	}
	
	//获取区域列表 分页
	@RequestMapping(value="/page.action")
	public Map getSysBasQypzPage(
			Integer pageSize,
			Integer pageIndex
			){
		return appAccessService.getSysBasQypzListPate(pageSize, pageIndex);
		
	}
	@RequestMapping(value="/save.action")
	public String save(SysBasQypz sysBasQypz){
		 if(appAccessService.save(sysBasQypz)) {
			 return Constants.SUCCESS_CODE1;
		 }
		 return Constants.ERROR_CODE3;
		
	}
	
	
}
