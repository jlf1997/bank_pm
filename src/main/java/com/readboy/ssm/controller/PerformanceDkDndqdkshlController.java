package com.readboy.ssm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.readboy.ssm.po.PerformanceDkDndqdkshl;
import com.readboy.ssm.service.PerformanceDkDndqdkshlService;

@Controller
public class PerformanceDkDndqdkshlController {
	
	@Autowired
	private PerformanceDkDndqdkshlService performanceDkDndqdkshlService;
	
	//-----APP端-----
	@ResponseBody
	@RequestMapping(value="/mobile/findPerformanceDkDndqdkshl.action",method={RequestMethod.POST,RequestMethod.GET})
	public PerformanceDkDndqdkshl mobileFindPerformanceDkDndqdkshl(
			@RequestParam(value="gyh") String yggh,
			@RequestParam(value="gzrq") String gzrq,
			@RequestParam(value="zbid") String zbid) throws Exception{
		String ksrq = gzrq+" 00:00:00";
		String jsrq = gzrq+" 23:59:59";
		return performanceDkDndqdkshlService.findPerformanceDkDndqdkshl(ksrq, jsrq, yggh, zbid);
	}
	
	//-----PC端------
	@RequestMapping(value="/findPerformanceDkDndqdkshl.action",method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView findPerformanceDkDndqdkshl(
			@RequestParam(value="yggh") String yggh,
			@RequestParam(value="gzrq")String gzrq,
			@RequestParam(value="zbid") String zbid,
			ModelAndView modelAndView) throws Exception{
		String ksrq = gzrq+" 00:00:00";
		String jsrq = gzrq+" 23:59:59";
		PerformanceDkDndqdkshl one = performanceDkDndqdkshlService.findPerformanceDkDndqdkshl(ksrq, jsrq, yggh, zbid);
		modelAndView.addObject("one",one);
		modelAndView.addObject("gzrq",gzrq);
		modelAndView.setViewName("performance/performanceDkDndqdkshl");
		return modelAndView;
	}
	
}
