package com.readboy.ssm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.readboy.ssm.po.PerformanceCbSjyhdhl;
import com.readboy.ssm.service.PerformanceCbSjyjdhlService;

/**
 * 查表：手机银行动户率
 * @author:	   	LCL
 * @date: 	   	2017-10-17
 * @description:
 */
@Controller
public class PerformanceCbSjyhdhlController {
	
	@Autowired
	private PerformanceCbSjyjdhlService performanceCbSjyhdhlService;
	
	//-----APP端-----
	@ResponseBody
	@RequestMapping(value="/mobile/findPerformanceCbSjyhdhl.action",method={RequestMethod.POST,RequestMethod.GET})
	public PerformanceCbSjyhdhl mobileFindPerformanceCbSjyhdhl(
			@RequestParam(value="gyh") String yggh,
			@RequestParam(value="gzrq") String gzrq,
			@RequestParam(value="zbid") String zbid) throws Exception{
		String ksrq = gzrq+" 00:00:00";
		String jsrq = gzrq+" 23:59:59";
		return performanceCbSjyhdhlService.findPerformanceCbSjyjdhl(ksrq, jsrq, yggh, zbid);
	}
	
	//-----PC端------
	@RequestMapping(value="/findPerformanceCbSjyhdhl.action",method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView findPerformanceCbSjyhdhl(
			@RequestParam(value="yggh") String yggh,
			@RequestParam(value="gzrq")String gzrq,
			@RequestParam(value="zbid") String zbid,
			ModelAndView modelAndView) throws Exception{
		String ksrq = gzrq+" 00:00:00";
		String jsrq = gzrq+" 23:59:59";
		PerformanceCbSjyhdhl one = performanceCbSjyhdhlService.findPerformanceCbSjyjdhl(ksrq, jsrq, yggh, zbid);
		modelAndView.addObject("one",one);
		modelAndView.addObject("gzrq",gzrq);
		modelAndView.setViewName("performance/performanceCbSjyhdhl");
		return modelAndView;
	}
	
}
