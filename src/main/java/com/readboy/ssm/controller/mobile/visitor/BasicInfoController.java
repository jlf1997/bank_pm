package com.readboy.ssm.controller.mobile.visitor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.readboy.ssm.po.VisitBasicInfo;
import com.readboy.ssm.service.VisitBasicInfoService;
/**
 * 基本拜访信息Controller
 */
@Controller
@RequestMapping("/mobile/visitor/BaseInfo")
public class BasicInfoController extends BaseController{
	
	@Autowired
	VisitBasicInfoService visitBasicInfoService;

	@RequestMapping(value = "/getVisitInfo", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public Object getVisitInfo() throws Exception{
		Map<String, Integer> map = new HashMap<String, Integer>();
		PageData pd = this.getPageData();
		map.put("visitorId", Integer.parseInt(pd.getString("visitorId")));
		map.put("clientNum", Integer.parseInt(pd.getString("clientNum")));
		List<VisitBasicInfo>result = visitBasicInfoService.findListBasicInfo(map);
		
		return result;
	}
	
	@RequestMapping(value = "/saveVisitInfo", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public Object saveVisitInfo() throws Exception{
		VisitBasicInfo baseInfo = this.getBean(VisitBasicInfo.class);
		visitBasicInfoService.insertVisitBasicInfo(baseInfo);
		Map<String, String> map = new HashMap<String, String>();
		map.put("result", "success");
		
		return map;
	}
}
