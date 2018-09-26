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

import com.readboy.ssm.po.PerformanceGljxgzMx;
import com.readboy.ssm.service.PerformanceGljxgzMxService;

@Controller
public class PerformanceGljxgzMxController {
	@Autowired
	private PerformanceGljxgzMxService performanceGljxgzMxService;
	
	@ResponseBody
	@RequestMapping(value="/mobile/findPerformanceGljxgzMx.action",method={RequestMethod.POST,RequestMethod.GET})
	public List<PerformanceGljxgzMx> mobileFindPerformanceGljxgzMx(
		@RequestParam(value="gyh") String yggh,
		@RequestParam(value="tjrq") String tjrq) throws Exception{
		return performanceGljxgzMxService.findPerformanceGljxgzMx(yggh, tjrq);
	}
	
	@RequestMapping(value="/findPerformanceGljxgzMx.action",method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView findPerformanceGljxgzMx(
		@RequestParam(value="yggh") String yggh,
		@RequestParam(value="tjrq") String tjrq,
		ModelAndView modelAndView) throws Exception{
		List<PerformanceGljxgzMx> list =  performanceGljxgzMxService.findPerformanceGljxgzMx(yggh, tjrq);
		BigDecimal hj = new BigDecimal(0);
		for(PerformanceGljxgzMx one : list){
			hj = hj.add(one.getPerformanceManageDetail().getGz());
		}
		modelAndView.addObject("hj",hj);
		modelAndView.addObject("list",list);
		modelAndView.addObject("tjrq",tjrq);
		modelAndView.setViewName("performance/performanceGljx");
		return modelAndView;
		
	}
}
