package com.readboy.ssm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.readboy.ssm.po.PerformanceGzzl;
import com.readboy.ssm.service.PerformanceGzzlService;

@Controller
public class PerformanceGzzlController {
	
	@Autowired
	private PerformanceGzzlService PerformanceGzzlService;
	
	@ResponseBody
	@RequestMapping(value="/mobile/findPerformanceGzzl.action",method={RequestMethod.POST,RequestMethod.GET})
	public PerformanceGzzl mobileFindPerformanceGzzl(
			@RequestParam(value="gyh") String yggh,
			@RequestParam(value="zbid") String zbid,
			@RequestParam(value="gzrq") String gzrq) throws Exception{
		String ksrq = gzrq + " 00:00:00";
		String jsrq = gzrq + " 23:59:59";
		return PerformanceGzzlService.findPerformanceGzzl(ksrq, jsrq, yggh, zbid);
	}
	
	@RequestMapping(value="/findPerformanceGzzl.action",method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView findPerformanceGzzl(
			@RequestParam(value="yggh") String yggh,
			@RequestParam(value="zbid") String zbid,
			@RequestParam(value="gzrq") String gzrq,
			ModelAndView modelAndView) throws Exception{
		String ksrq = gzrq + " 00:00:00";
		String jsrq = gzrq + " 23:59:59";
		PerformanceGzzl one = PerformanceGzzlService.findPerformanceGzzl(ksrq, jsrq, yggh, zbid);
		modelAndView.addObject("one",one);
		modelAndView.addObject("gzrq",gzrq);		
		modelAndView.setViewName("performance/performanceGzzl");
		return modelAndView;
	}
}
