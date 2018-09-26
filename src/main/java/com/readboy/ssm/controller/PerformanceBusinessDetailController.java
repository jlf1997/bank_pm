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

import com.readboy.ssm.po.PerformanceBusinessDetail;
import com.readboy.ssm.po.PerformancePersonalByCountMx;
import com.readboy.ssm.service.PerformanceBusinessDetailService;
/**
 * 
 * @author:	   	LCL
 * @date: 	   	2017-8-7
 * @description:绩效_业务量
 */
@Controller
public class PerformanceBusinessDetailController {
	
	@Autowired
	private PerformanceBusinessDetailService performanceBusinessDetailService;
	
	@ResponseBody
	@RequestMapping(value="/mobile/findPerformanceBusinessDetail.action",method={RequestMethod.POST,RequestMethod.GET})
	public List<PerformanceBusinessDetail> mobileFindPerformanceBusinessDetail(
			@RequestParam(value="gyh") String yggh,@RequestParam(value="tjrq") String tjrq) throws Exception{
		return performanceBusinessDetailService.findPerformanceBusinessDetail(yggh, tjrq, tjrq);
	}
	
	@RequestMapping(value="/findPerformanceBusinessDetail.action",method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView findPerformanceBusinessDetail(
			@RequestParam(value="yggh") String yggh,@RequestParam(value="tjrq") String tjrq,
			@RequestParam(value="type") String type,
			ModelAndView modelAndView) throws Exception{
		List<PerformanceBusinessDetail> list = performanceBusinessDetailService.findPerformanceBusinessDetail(yggh, tjrq, tjrq);
		BigDecimal hj = new BigDecimal(0);
		for(PerformanceBusinessDetail one : list){
			if(type.equals("brjb")){
				hj = hj.add(one.getYwlgz());
			}else{//"xjll"现金流量
				hj = hj.add(one.getXjllgz());
			}
			
		}
		modelAndView.addObject("list",list);
		modelAndView.addObject("hj",hj);
		modelAndView.addObject("tjrq",tjrq);
		modelAndView.addObject("type",type);
		modelAndView.setViewName("performance/performanceYwl");
		return modelAndView;
	}
}
