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
import com.readboy.ssm.po.PerformanceDepositHushuMx;
import com.readboy.ssm.service.PerformanceDepositHushuMxService;

/*
 * 绩效_存款户数明细Controller
 * */
@Controller
public class PerformanceDepositHushuMxController {
	
	@Autowired
	private PerformanceDepositHushuMxService performanceDepositHushuMxService;
	
	@ResponseBody
	@RequestMapping(value="/mobile/responsePerformanceCkhsMxJson.action",method={RequestMethod.POST,RequestMethod.GET})
	public Map<String,Object> responseCustomerJson(
			@RequestParam(value="gyh",required=true) String yggh, 
			@RequestParam(value="tjrq") String tjrq, 
			@RequestParam(value="yxlx") String yxlx,
			@RequestParam(value="condition",required=false) String condition,
			 PageOption page) throws Exception{
		PageOption.initAppPage(page);
		Integer num = performanceDepositHushuMxService.findDataCountByCond(yggh, tjrq, yxlx, condition);
		List<PerformanceDepositHushuMx> list = performanceDepositHushuMxService.findPerformanceDepositHushuMx(yggh, tjrq, yxlx,condition,page);
		Map<String,Object> m = new HashMap<String,Object>();
		m.put("num", num);
		m.put("list",list);
		return m;
	}
	
	//------------PC端查询------------------
	@RequestMapping(value="/findPerformanceCkhsMx.action",method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView findPerformanceCkhsMx(
			@RequestParam(value="yggh",required=true) String yggh, 
			@RequestParam(value="tjrq") String tjrq, 
			@RequestParam(value="yxlx") String yxlx,
			@RequestParam(value="condition",required=false) String condition,PageOption page,
			ModelAndView modelAndView) throws Exception{
		
		page.setTotalResult(performanceDepositHushuMxService.findDataCountByCond(yggh, tjrq, yxlx, condition));
		PageOption.initPage(page);
		List<PerformanceDepositHushuMx> list = performanceDepositHushuMxService.findPerformanceDepositHushuMx(yggh, tjrq, yxlx,condition,page);
		BigDecimal hj = new BigDecimal(0);
		for(PerformanceDepositHushuMx one : list){
			hj = hj.add(one.getGz());
		}
		modelAndView.addObject("list",list);
		modelAndView.addObject("yggh",yggh);
		modelAndView.addObject("tjrq",tjrq);
		modelAndView.addObject("hj",hj);
		modelAndView.addObject("yxlx",yxlx);
		modelAndView.addObject("condition",condition);
		modelAndView.addObject("page",page);
		modelAndView.setViewName("performance/performanceCkhs");
		return modelAndView;
	}
}
