package com.readboy.ssm.controller;

import java.math.BigDecimal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.readboy.ssm.po.PerformanceYwlWdywl;
import com.readboy.ssm.service.PerformanceYwlWdywlService;

@Controller
public class PerformanceYwlWdywlController {
	
	@Autowired
	private PerformanceYwlWdywlService performanceYwlWdywlService;
	
	@ResponseBody
	@RequestMapping(value="/mobile/findPerformanceYwlWdywl.action",method={RequestMethod.POST,RequestMethod.GET})
	public PerformanceYwlWdywl mobileFindPerformanceYwlWdywl(
			@RequestParam(value="gyh") String yggh,
			@RequestParam(value="gzrq") String gzrq,
			@RequestParam(value="zbid") String zbid) throws Exception{
		String ksrq = gzrq + " 00:00:00";
		String jsrq = gzrq + " 23:59:59";
		return performanceYwlWdywlService.findPerformanceYwlWdywl(ksrq, jsrq, yggh, zbid);
	}
	
	@RequestMapping(value="/findPerformanceYwlWdywl.action",method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView findPerformanceYwlWdywl(
			@RequestParam(value="yggh") String yggh,
			@RequestParam(value="gzrq")String gzrq,
			@RequestParam(value="zbid") String zbid,
			ModelAndView modelAndView) throws Exception{
		String ksrq = gzrq+" 00:00:00";
		String jsrq = gzrq + " 23:59:59";
		PerformanceYwlWdywl one = performanceYwlWdywlService.findPerformanceYwlWdywl(ksrq, jsrq, yggh, zbid);
		modelAndView.addObject("one",one);
		modelAndView.addObject("gzrq",gzrq);
		modelAndView.setViewName("performance/performanceYwlWdywl");
		return modelAndView;
	}
	
}
