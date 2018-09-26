package com.readboy.ssm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.readboy.ssm.po.PerformanceJgaljc;
import com.readboy.ssm.service.PerformanceJgaljcService;

@Controller
public class PerformanceJgaljcController {
	
	@Autowired
	private PerformanceJgaljcService performanceJgaljcService;
	
	@ResponseBody
	@RequestMapping(value="/mobile/findPerformanceJgaljc.action",method={RequestMethod.POST,RequestMethod.GET})
	public PerformanceJgaljc mobileFindPerformanceJgaljc(
			@RequestParam(value="gyh") String yggh,
			@RequestParam(value="zbid") String zbid,
			@RequestParam(value="gzrq") String gzrq) throws Exception{
		String ksrq = gzrq + " 00:00:00";
		String jsrq = gzrq + " 23:59:59";
		return performanceJgaljcService.findPerformanceJgaljc(ksrq, jsrq, yggh, zbid);
	}
	
	@RequestMapping(value="/findPerformanceJgaljc.action",method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView findPerformanceJgaljc(
			@RequestParam(value="yggh") String yggh,
			@RequestParam(value="zbid") String zbid,
			@RequestParam(value="gzrq") String gzrq,
			ModelAndView modelAndView) throws Exception{
		String ksrq = gzrq + " 00:00:00";
		String jsrq = gzrq + " 23:59:59";
		PerformanceJgaljc one = performanceJgaljcService.findPerformanceJgaljc(ksrq, jsrq, yggh, zbid);
		modelAndView.addObject("one",one);
		modelAndView.addObject("gzrq",gzrq);		
		modelAndView.setViewName("performance/performanceJgaljc");
		return modelAndView;
	}
}
