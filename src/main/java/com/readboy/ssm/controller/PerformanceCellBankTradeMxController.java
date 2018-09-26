package com.readboy.ssm.controller;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.readboy.ssm.service.PerformanceCellBankTradeMxService;
/*
 * 绩效_手机银行交易
 * */
@Controller
public class PerformanceCellBankTradeMxController {
	
	@Autowired
	private PerformanceCellBankTradeMxService performanceCellBankTradeMxService;
	
	@ResponseBody
	@RequestMapping(value="/mobile/findPerformanceCellBankTradeMx.action",method={RequestMethod.POST,RequestMethod.GET})
	public Map<String,Object> mobileFindPerformanceCellBankTradeMx(
			@RequestParam(value="gyh") String yggh,
			@RequestParam(value="stt") String stt,
			@RequestParam(value="tjrq")String tjrq,
			@RequestParam(value="condition",required=false)String condition,
			 PageOption page) throws Exception{
		String ksrq = tjrq.substring(0,8)+"01 00:00:00";
		String jsrq = tjrq+" 23:59:59";
		PageOption.initAppPage(page);
		Integer num = performanceCellBankTradeMxService.findDataCountByCond(yggh, stt, ksrq, jsrq, condition);
		List<PerformanceCellBankTradeMx> list = performanceCellBankTradeMxService.findPerformanceCellBankTradeMx(yggh, stt,ksrq, jsrq,condition,page);
		Map<String,Object> m = new HashMap<String,Object>();
		m.put("num", num);
		m.put("list",list);
		return m;
	}
	
	
	@RequestMapping(value="/findPerformanceCellBankTradeMx.action",method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView findPerformanceCellBankTradeMx(
			@RequestParam(value="yggh") String yggh,
			@RequestParam(value="tjrq")String tjrq,
			@RequestParam(value="condition",required=false)String condition,PageOption page,
			ModelAndView modelAndView) throws Exception{
		String ksrq = tjrq.substring(0,8)+"01 00:00:00";
		String jsrq = tjrq+" 23:59:59";
		//第二个参数stt写死为20
		page.setTotalResult(performanceCellBankTradeMxService.findDataCountByCond(yggh, "20", ksrq, jsrq, condition));
		PageOption.initPage(page);
		List<PerformanceCellBankTradeMx> list = performanceCellBankTradeMxService.findPerformanceCellBankTradeMx(yggh, "20",ksrq, jsrq,condition,page);
		BigDecimal hj = new BigDecimal(0);
		for(PerformanceCellBankTradeMx one : list){
			hj = hj.add(one.getGz());	
		}
		modelAndView.addObject("list",list);
		modelAndView.addObject("yggh",yggh);
		modelAndView.addObject("condition",condition);
		modelAndView.addObject("hj",hj);
		modelAndView.addObject("tjrq",tjrq);
		modelAndView.addObject("page",page);
		modelAndView.setViewName("performance/performanceCbSjyhjy");
		return modelAndView;
	}
}
