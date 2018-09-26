package com.readboy.ssm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.readboy.ssm.po.PerformanceGljxWdrjgz;
import com.readboy.ssm.service.PerformanceGljxWdrjgzService;

@Controller
public class PerformanceGljxWdrjgzController {
	
	@Autowired
	private PerformanceGljxWdrjgzService performanceGljxWdrjgzService;
	
	@ResponseBody
	@RequestMapping(value="/mobile/findPerformanceGljxWdrjgz.action",method={RequestMethod.POST,RequestMethod.GET})
	public PerformanceGljxWdrjgz mobileFindPerformanceGljxWdrjgz(
			@RequestParam(value="gyh") String yggh,
			@RequestParam(value="zbid") String zbid,
			@RequestParam(value="gzrq") String gzrq) throws Exception{
		String ksrq = gzrq + " 00:00:00";
		String jsrq = gzrq + " 23:59:59";
		return performanceGljxWdrjgzService.findPerformanceGljxWdrjgz(ksrq, jsrq, yggh, zbid);
	}
	
	@RequestMapping(value="/findPerformanceGljxWdrjgz.action",method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView findPerformanceGljxWdrjgz(
			@RequestParam(value="yggh") String yggh,
			@RequestParam(value="zbid") String zbid,
			@RequestParam(value="gzrq") String gzrq,
			ModelAndView modelAndView) throws Exception{
		String ksrq = gzrq + " 00:00:00";
		String jsrq = gzrq + " 23:59:59";
		PerformanceGljxWdrjgz one = performanceGljxWdrjgzService.findPerformanceGljxWdrjgz(ksrq, jsrq, yggh, zbid);
		modelAndView.addObject("one",one);
		modelAndView.setViewName("performance/performanceGljxWdrjgz");
		return modelAndView;
	}
}
