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

import com.readboy.ssm.po.PerformanceCellBankTradeMx;
import com.readboy.ssm.po.PerformanceJgpjMx;
import com.readboy.ssm.service.PerformanceJgpjMxService;
/*
 * 绩效_机构扣减明细
 * */
@Controller
public class PerformanceJgpjMxController {
	
	@Autowired
	private PerformanceJgpjMxService performanceJgpjMxService;
	
	@ResponseBody
	@RequestMapping(value="/mobile/findPerformanceJgpjMx.action",method={RequestMethod.POST,RequestMethod.GET})
	public List<PerformanceJgpjMx> mobileFindPerformanceJgpjMx(
			@RequestParam(value="gyh") String yggh,
			@RequestParam(value="gzrq")String gzrq,
			@RequestParam(value="zbid")String zbid) throws Exception{
			return performanceJgpjMxService.findPerformanceJgpjMx(yggh, gzrq, zbid);
	}
	
	@RequestMapping(value="/findPerformanceJgpjMx.action",method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView findPerformanceJgpjMx(
			@RequestParam(value="yggh") String yggh,
			@RequestParam(value="gzrq") String gzrq,
			@RequestParam(value="zbid") String zbid,
			ModelAndView modelAndView) throws Exception{
		List<PerformanceJgpjMx> list = performanceJgpjMxService.findPerformanceJgpjMx(yggh, gzrq, zbid);
		BigDecimal hj = new BigDecimal(0);
		for(PerformanceJgpjMx one : list){
			hj = hj.add(one.getZbgz());
		}
		modelAndView.addObject("list",list);
		modelAndView.addObject("hj",hj);
		modelAndView.addObject("gzrq",gzrq);
		modelAndView.setViewName("performance/performanceCbJgpj");
		return modelAndView;
	}
}
