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

import com.readboy.ssm.po.PageOption;
import com.readboy.ssm.po.PerformanceCellBankHsMx;
import com.readboy.ssm.po.PerformanceCellBankTradeMx;
import com.readboy.ssm.po.PerformanceJymb;
import com.readboy.ssm.service.PerformanceCellBankTradeMxService;
import com.readboy.ssm.service.PerformanceJymbService;
/*
 * 绩效_手机银行交易
 * */
@Controller
public class PerformanceJymbController {
	
	@Autowired
	private PerformanceJymbService performanceJymbService;
	
	@ResponseBody
	@RequestMapping(value="/mobile/findPerformanceJymb.action",method={RequestMethod.POST,RequestMethod.GET})
	public PerformanceJymb mobileFindPerformanceCellBankTradeMx(
			@RequestParam(value="gyh") String yggh,
			@RequestParam(value="gzrq") String gzrq,
			@RequestParam(value="zbid") String zbid) throws Exception{
		
		return performanceJymbService.findPerformanceJymb(yggh, gzrq, zbid);
	}
	
	
	@RequestMapping(value="/findPerformanceJymb.action",method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView findPerformanceCellBankTradeMx(
			@RequestParam(value="yggh") String yggh,
			@RequestParam(value="gzrq") String gzrq,
			@RequestParam(value="zbid") String zbid,
			ModelAndView modelAndView) throws Exception{
		
		PerformanceJymb one = performanceJymbService.findPerformanceJymb(yggh, gzrq, zbid);
		modelAndView.addObject("one",one);
		modelAndView.addObject("yggh",yggh);
		modelAndView.setViewName("performance/performanceJymb");
		return modelAndView;
	}
}
