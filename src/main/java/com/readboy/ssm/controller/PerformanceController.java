package com.readboy.ssm.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.readboy.ssm.po.Area;
import com.readboy.ssm.po.Performance;
import com.readboy.ssm.po.StaffAndPost;
import com.readboy.ssm.po.StaffInfo;
import com.readboy.ssm.service.AreaService;
import com.readboy.ssm.service.PerformanceService;
import com.readboy.ssm.service.StaffAndPostService;
import com.readboy.ssm.service.StaffInfoService;

@Controller
public class PerformanceController {
	
	@Autowired
	private PerformanceService performanceService;
	@Autowired
	private StaffInfoService staffInfoService;
	@Autowired
	private AreaService areaService;
	@Autowired 
	private StaffAndPostService staffAndPostService;
	
	@ResponseBody
	@RequestMapping(value="/mobile/responsePerformanceJson.action",method={RequestMethod.POST,RequestMethod.GET})
	public Map<String,Object>  responseCustomerJson(String yggh, String gzrq) throws Exception{
		Performance performance = performanceService.findPerformance(yggh, gzrq);
		Area area = areaService.findArea();
		Map<String,Object> map =  new HashMap<String,Object>();
		map.put("performance", performance);
		map.put("area", area);
		return map;
	}

	//------PC端查询------
	@RequestMapping(value="/responseStaffAndPostInfo.action",method={RequestMethod.POST,RequestMethod.GET})
	public JSONObject findStaffAndPostInfo(String yggh) throws Exception{
		StaffInfo staffInfo = null;
		StaffAndPost staffAndPost = staffAndPostService.findStaffAndPostByYggh(yggh);
		if(staffAndPost != null){
			 staffInfo  = staffInfoService.findStaffInfoByConditions(staffAndPost.getZzbz(), staffAndPost.getGwbz(), yggh);
		}
		JSONObject json = (JSONObject) JSON.toJSON(staffInfo);
		return json;
	}
	
	//------PC端查询------
	@RequestMapping(value="/getPerformanceHome.action",method={RequestMethod.POST,RequestMethod.GET})
	public String getPerformanceHome(HttpServletRequest req,@RequestParam("gzrq")String gzrq,
			@RequestParam("yggh") String yggh,Model model) throws Exception{
		StaffInfo staffInfo = null;
		Performance performance = performanceService.findPerformance(yggh, gzrq);
		if(performance != null){
			 staffInfo  = staffInfoService.findStaffInfoByConditions(performance.getZzbz(), performance.getGwbz(), yggh);
		}
		model.addAttribute("staffInfo",staffInfo);
		model.addAttribute("one",performance);
		model.addAttribute("gzrq",gzrq);
		model.addAttribute("yggh",yggh);
		return "performance/performanceYgjxhz";
	}
	
}
