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

import com.readboy.ssm.po.PerformanceGljxBmkh;
import com.readboy.ssm.service.PerformanceGljxBmkhService;

@Controller
public class PerformanceGljxBmkhController {
	
	@Autowired
	private PerformanceGljxBmkhService performanceGljxBmkhService;
	
	@ResponseBody
	@RequestMapping(value="/mobile/findPerformanceGljxBmkh.action",method={RequestMethod.POST,RequestMethod.GET})
	public PerformanceGljxBmkh mobileFindPerformanceGljxBmkh(
			@RequestParam(value="gyh") String yggh,
			@RequestParam(value="zbid") String zbid,
			@RequestParam(value="gzrq") String gzrq) throws Exception{
		String ksrq = gzrq + " 00:00:00";
		String jsrq = gzrq + " 23:59:59";
		return performanceGljxBmkhService.findPerformanceGljxBmkh(ksrq, jsrq, yggh, zbid);
	}
	
	@RequestMapping(value="/findPerformanceGljxBmkh.action",method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView findPerformanceGljxBmkh(
			@RequestParam(value="yggh") String yggh,
			@RequestParam(value="zbid") String zbid,
			@RequestParam(value="gzrq") String gzrq,
			ModelAndView modelAndView) throws Exception{
		String ksrq = gzrq + " 00:00:00";
		String jsrq = gzrq + " 23:59:59";
		PerformanceGljxBmkh one = performanceGljxBmkhService.findPerformanceGljxBmkh(ksrq, jsrq, yggh, zbid);
		modelAndView.addObject("one",one);
		modelAndView.addObject("gzrq",gzrq);		
		modelAndView.setViewName("performance/performanceGljxBmkh");
		return modelAndView;
	}
}
