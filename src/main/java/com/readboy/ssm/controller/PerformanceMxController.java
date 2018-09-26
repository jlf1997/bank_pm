package com.readboy.ssm.controller;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.readboy.ssm.po.Area;
import com.readboy.ssm.po.PerformanceMx;
import com.readboy.ssm.service.AreaService;
import com.readboy.ssm.service.PerformanceMxService;

@Controller
public class PerformanceMxController {
	
	@Autowired
	private PerformanceMxService performanceService;
	
	@Autowired
	private AreaService areaService;
	
	//返回指标同时返回地区信息
	@ResponseBody
	@RequestMapping(value="/mobile/responsePerformanceMxJson.action",method={RequestMethod.POST,RequestMethod.GET})
	public List<PerformanceMx> responseCustomerJson(String yggh, String gzrq, int zblb) throws Exception{
		List<PerformanceMx> performances = performanceService.findPerformanceMx(yggh, gzrq, zblb);
		return performances;
	}
	
	//--------------PC端查询---------------
	@RequestMapping(value="/getPerformanceMx.action",method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView getPerformanceMx(@RequestParam("yggh") String yggh, 
			@RequestParam("gzrq")String gzrq, @RequestParam("zblb") int zblb) throws Exception{
		ModelAndView modelAndView = new ModelAndView();
		List<PerformanceMx> list = performanceService.findPerformanceMx(yggh, gzrq, zblb);
		BigDecimal hj = new BigDecimal(0);
		for(PerformanceMx one : list){
			hj = hj.add(one.getZbgz());
		}
		Area area = areaService.findArea();
		modelAndView.addObject("area",area);
		modelAndView.addObject("list",list);
		modelAndView.addObject("hj",hj);
		modelAndView.addObject("gzrq",gzrq);
		modelAndView.addObject("yggh",yggh);
		modelAndView.setViewName("performance/performanceJxhz");
		return modelAndView;
	}
}
