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

import com.readboy.ssm.po.PerformanceDKWddkhsMx;
import com.readboy.ssm.service.PerformanceDkWddkhsMxService;
/*
 * 绩效_贷款客户包收明细
 * */
@Controller
public class PerformanceDkWddkhsMxController {
	
	@Autowired
	private PerformanceDkWddkhsMxService performanceDkWddkhsMxService;
	
	@ResponseBody
	@RequestMapping(value="/mobile/findPerformanceDkWddkhsMx.action",method={RequestMethod.POST,RequestMethod.GET})
	public PerformanceDKWddkhsMx mobileFindPerformanceDkWddkhsMx(
			@RequestParam(value="gyh") String yggh,
			@RequestParam(value="tjrq")String tjrq,
			@RequestParam(value="zzbz") String zzbz) throws Exception{
		String ksrq = tjrq+" 00:00:00";
		String jsrq = tjrq+" 23:59:59";
		return performanceDkWddkhsMxService.findPerformanceDKWddkhsMx(ksrq, jsrq, zzbz);
	}
	
	@RequestMapping(value="/findPerformanceDkWddkhsMx.action",method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView findPerformanceDkWddkhsMx(
			@RequestParam(value="yggh") String yggh,
			@RequestParam(value="tjrq")String tjrq,
			@RequestParam(value="zzbz") String zzbz,
			ModelAndView modelAndView) throws Exception{
		String ksrq = tjrq+" 00:00:00";
		String jsrq = tjrq+" 23:59:59";
		PerformanceDKWddkhsMx one = performanceDkWddkhsMxService.findPerformanceDKWddkhsMx(ksrq, jsrq, zzbz);
		modelAndView.addObject("one",one);
		modelAndView.addObject("tjrq",tjrq);
		modelAndView.setViewName("performance/performanceDkWddkhs");
		return modelAndView;
	}
}
