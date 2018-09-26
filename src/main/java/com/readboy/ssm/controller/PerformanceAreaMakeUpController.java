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

import com.readboy.ssm.po.PerformanceAreaMakeUp;
import com.readboy.ssm.po.PerformanceGljxgzMx;
import com.readboy.ssm.service.PerformanceAreaMakeUpService;
/*
 * 绩效地区补差
 * */
@Controller
public class PerformanceAreaMakeUpController {
	
	@Autowired
	private PerformanceAreaMakeUpService performanceAreaMakeUpService;
	
	@ResponseBody
	@RequestMapping(value="/mobile/findPerformanceAreaMakeUp.action",method={RequestMethod.POST,RequestMethod.GET})
	public List<PerformanceAreaMakeUp> mobileFindPerformanceAreaMakeUp(
			@RequestParam(value="gyh") String yggh,String tjrq) throws Exception{
		return performanceAreaMakeUpService.findPerformanceAreaMakeUp(yggh, tjrq, tjrq);
	}
	
	@RequestMapping(value="/findPerformanceAreaMakeUp.action",method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView findPerformanceAreaMakeUp(
			@RequestParam(value="yggh") String yggh,String tjrq,
			ModelAndView modelAndView) throws Exception{
		List<PerformanceAreaMakeUp> list = performanceAreaMakeUpService.findPerformanceAreaMakeUp(yggh, tjrq, tjrq);
		BigDecimal hj = new BigDecimal(0);
		for(PerformanceAreaMakeUp one : list){
			hj = hj.add(one.getGz());
		}
		modelAndView.addObject("hj",hj);
		modelAndView.addObject("list",list);
		modelAndView.addObject("tjrq",tjrq);
		modelAndView.setViewName("performance/performanceDqbc");
		return modelAndView;
	}
}
