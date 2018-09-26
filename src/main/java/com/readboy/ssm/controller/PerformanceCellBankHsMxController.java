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
import com.readboy.ssm.po.PerformanceBlqsMx;
import com.readboy.ssm.po.PerformanceCellBankHsMx;
import com.readboy.ssm.service.PerformanceCellBankHsMxService;
/*
 * 绩效_Etc户数工资明细
 * */
@Controller
public class PerformanceCellBankHsMxController {
	
	@Autowired
	private PerformanceCellBankHsMxService performanceCellBankHsMxService;
	
	@ResponseBody
	@RequestMapping(value="/mobile/findPerformanceCellBankHsMx.action",method={RequestMethod.POST,RequestMethod.GET})
	public Map<String,Object>  mobildeFindPerformanceCellBankHsMx(
			@RequestParam(value="gyh") String yggh,
			@RequestParam(value="yxlx") int yxlx,
			@RequestParam(value="tjrq")String tjrq,
			@RequestParam(value="condition",required=false)String condition,
			PageOption page) throws Exception{
		//"8即yyyy-mm-,将开始时间替换成当月第一天"
		String ksrq = tjrq.substring(0,8)+"01";
		PageOption.initAppPage(page);
		Integer num = performanceCellBankHsMxService.findDataCountByCond(yggh, yxlx, ksrq, tjrq, condition);
		List<PerformanceCellBankHsMx> list =  performanceCellBankHsMxService.findPerformanceCellBankHsMx(yggh, yxlx,ksrq, tjrq,condition,page);
		Map<String,Object> m = new HashMap<String,Object>();
		m.put("num", num);
		m.put("list",list);
		return m;
	}
	
	@RequestMapping(value="/findPerformanceCellBankHsMx.action",method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView findPerformanceCellBankHsMx(
			@RequestParam(value="yggh") String yggh,
			@RequestParam(value="yxlx") int yxlx,
			@RequestParam(value="tjrq") String tjrq,
			@RequestParam(value="condition",required=false)String condition,PageOption page,
			ModelAndView modelAndView) throws Exception{
		//"8即yyyy-mm-,将开始时间替换成当月第一天"
		String ksrq = tjrq.substring(0,8)+"01 00:00:00";
		String jsrq = tjrq+" 23:59:59";
		page.setTotalResult(performanceCellBankHsMxService.findDataCountByCond(yggh, yxlx, ksrq, jsrq, condition));
		PageOption.initPage(page);
		List<PerformanceCellBankHsMx> list=  performanceCellBankHsMxService.findPerformanceCellBankHsMx(yggh, yxlx,ksrq, jsrq,condition,page);
		BigDecimal hj = new BigDecimal(0);
		for(PerformanceCellBankHsMx one : list){
			//工资为空时可能出现空指针异常
			hj = hj.add((one.getGz() == null ? new BigDecimal(0) : one.getGz()));	
		}
		modelAndView.addObject("list",list);
		modelAndView.addObject("yggh",yggh);
		modelAndView.addObject("condition",condition);
		modelAndView.addObject("hj",hj);
		modelAndView.addObject("yxlx",yxlx);
		modelAndView.addObject("tjrq",tjrq);
		modelAndView.addObject("page",page);
		modelAndView.setViewName("performance/performanceCbSjyhhs");
		return modelAndView;
	}
}
