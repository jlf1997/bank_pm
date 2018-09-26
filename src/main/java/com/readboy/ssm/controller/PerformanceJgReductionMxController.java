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

import com.readboy.ssm.po.PerformanceJgReductionMx;
import com.readboy.ssm.po.PerformancePersonalByCountMx;
import com.readboy.ssm.service.PerformanceJgReductionMxService;
/*
 * 绩效_机构扣减明细
 * */
@Controller
public class PerformanceJgReductionMxController {
	
	@Autowired
	private PerformanceJgReductionMxService performanceJgReductionMxService;
	
	@ResponseBody
	@RequestMapping(value="/mobile/findPerformanceJgReductionMx.action",method={RequestMethod.POST,RequestMethod.GET})
	public List<PerformanceJgReductionMx> mobileFindPerformanceJgReductionMx(
			@RequestParam(value="gyh") String yggh,
			@RequestParam(value="gzrq")String gzrq,
			@RequestParam(value="zbid")String zbid) throws Exception{
			return performanceJgReductionMxService.findPerformanceJgReductionMx(yggh, gzrq, zbid);
	}
	
	@RequestMapping(value="/findPerformanceJgReductionMx.action",method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView findPerformanceJgReductionMx(
			@RequestParam(value="yggh") String yggh,
			@RequestParam(value="gzrq")String gzrq,
			@RequestParam(value="zbid")String zbid,
			ModelAndView modelAndView) throws Exception{
		List<PerformanceJgReductionMx> list = performanceJgReductionMxService.findPerformanceJgReductionMx(yggh, gzrq, zbid);
		BigDecimal hj = new BigDecimal(0);
		for(PerformanceJgReductionMx one : list){
			hj = hj.add(one.getZbgz());
		}
		modelAndView.addObject("list",list);
		modelAndView.addObject("hj",hj);
		modelAndView.addObject("gzrq",gzrq);
		modelAndView.setViewName("performance/performanceCbJgkj");
		return modelAndView;
	}
}
