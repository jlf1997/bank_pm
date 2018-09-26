package com.readboy.ssm.controller;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.readboy.ssm.po.PerformanceFindByMonthHome;
import com.readboy.ssm.po.PerformanceGwjxgzMxCustom;
import com.readboy.ssm.po.PerformanceGzhz;
import com.readboy.ssm.service.PerformanceGwjxgzMxCustomService;
import com.readboy.ssm.service.PerformanceGzhzService;
import com.readboy.ssm.utils.TableHelper;

@Controller
public class PerformanceFindByMonthHomeController {
	
	@Autowired
	private PerformanceGwjxgzMxCustomService performanceGwjxgzMxCustomService;
	@Autowired
	private PerformanceGzhzService performanceGzhzService;
	
	@ResponseBody
	@RequestMapping(value="/mobile/findByMonthHome.action",method={RequestMethod.POST,RequestMethod.GET})
	public PerformanceFindByMonthHome mobielFindByMonthHome(
			@RequestParam(value="gyh",required=true) String yggh, 
			@RequestParam(value="ksrq",required=true)String ksrq,
			@RequestParam(value="jsrq",required=true)String jsrq) throws Exception{
		PerformanceFindByMonthHome performanceFindByMonthHome = new PerformanceFindByMonthHome();
		PerformanceGzhz performanceGzhz = performanceGzhzService.findPerformanceGzhz(yggh, ksrq, jsrq);
		List<PerformanceGwjxgzMxCustom> list = performanceGwjxgzMxCustomService.findPerformanceGwjxgzMxCustom(yggh, ksrq, jsrq);
		if(performanceGzhz != null && list !=null){
			performanceFindByMonthHome.setPerformanceGzhz(performanceGzhz);
			performanceFindByMonthHome.setPerformanceGwjxgzMxCustomList(list);
			return performanceFindByMonthHome;
		}
		return null;
	}
	
	@RequestMapping(value="/findByMonthHome.action",method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView findByMonthHome(
			@RequestParam(value="yggh",required=true) String yggh, 
			@RequestParam(value="gzyf",required=true) String gzyf,ModelAndView modelAndView
			) throws Exception{
		String ksrq = gzyf+"-01 00:00:00";
		String jsrq = new StringBuilder(gzyf).append("-").
				append(TableHelper.getDaysOfMonth(gzyf)).append(" 23:59:59").toString();
		PerformanceGzhz one = performanceGzhzService.findPerformanceGzhz(yggh, ksrq, jsrq);
		List<PerformanceGwjxgzMxCustom> list = performanceGwjxgzMxCustomService.findPerformanceGwjxgzMxCustom(yggh, ksrq, jsrq);
		modelAndView.addObject("one",one);
		modelAndView.addObject("list",list);
		modelAndView.addObject("list",list);
		modelAndView.addObject("gzyf",gzyf);
		modelAndView.addObject("yggh",yggh);
		modelAndView.setViewName("performance/performanceMonthHome");
		return modelAndView;
	}
	
}
