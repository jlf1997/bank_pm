package com.readboy.ssm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.readboy.ssm.po.PerformanceXsxsgz;
import com.readboy.ssm.service.PerformanceXsxsgzService;

@Controller
public class PerformanceXsxsgzController {
	
	@Autowired
	private PerformanceXsxsgzService performanceXsxsgzService;
	
	@ResponseBody
	@RequestMapping(value="/mobile/findPerformanceXsxsgz.action",method={RequestMethod.POST,RequestMethod.GET})
	public PerformanceXsxsgz mobileFindPerformanceXsxsgz(
			@RequestParam(value="gyh") String yggh,
			@RequestParam(value="zbid") String zbid,
			@RequestParam(value="gzrq") String gzrq) throws Exception{
		String ksrq = gzrq + " 00:00:00";
		String jsrq = gzrq + " 23:59:59";
		return performanceXsxsgzService.findPerformanceXsxsgz(ksrq, jsrq, yggh, zbid);
	}
	
	@RequestMapping(value="/findPerformanceXsxsgz.action",method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView findPerformanceXsxsgz(
			@RequestParam(value="yggh") String yggh,
			@RequestParam(value="zbid") String zbid,
			@RequestParam(value="gzrq") String gzrq,
			ModelAndView modelAndView) throws Exception{
		String ksrq = gzrq + " 00:00:00";
		String jsrq = gzrq + " 23:59:59";
		PerformanceXsxsgz one = performanceXsxsgzService.findPerformanceXsxsgz(ksrq, jsrq, yggh, zbid);
		modelAndView.addObject("one",one);		
		modelAndView.setViewName("performance/performanceXsxsgz");
		return modelAndView;
	}
}
