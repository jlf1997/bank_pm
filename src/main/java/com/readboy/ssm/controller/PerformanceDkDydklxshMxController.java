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
import com.readboy.ssm.po.PerformanceDKDydklxshMx;
import com.readboy.ssm.service.PerformanceDkDydklxshMxService;

@Controller
public class PerformanceDkDydklxshMxController {
	
	@Autowired
	private PerformanceDkDydklxshMxService performanceDkDydklxshMxService;
	
	//-----APP端-----
	@ResponseBody
	@RequestMapping(value="/mobile/findPerformanceDkDydklxshMx.action",method={RequestMethod.POST,RequestMethod.GET})
	public Map<String,Object> mobileFindPerformanceDkDydklxshMx(
			@RequestParam(value="gyh") String yggh,
			@RequestParam(value="tjrq") String tjrq,
			@RequestParam(value="condition",required=false) String condition,
			PageOption page) throws Exception{
		String ksrq = tjrq+" 00:00:00";
		String jsrq = tjrq+" 23:59:59";
		PageOption.initAppPage(page);
		Integer num = performanceDkDydklxshMxService.findDataCountByCond(ksrq, jsrq, yggh, condition);
		List<PerformanceDKDydklxshMx> list =  performanceDkDydklxshMxService.findPerformanceDKDydklxshMx(ksrq, jsrq, yggh, condition,page);
		Map<String,Object> m = new HashMap<String,Object>();
		m.put("num", num);
		m.put("list",list);
		return m;
	}
	
	//-----PC端------
	@RequestMapping(value="/findPerformanceDkDydklxshMx.action",method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView findPerformanceDkDydklxshMx(
			@RequestParam(value="yggh") String yggh,
			@RequestParam(value="tjrq")String tjrq,
			@RequestParam(value="condition",required=false) String condition,PageOption page,
			ModelAndView modelAndView) throws Exception{
		String ksrq = tjrq+" 00:00:00";
		String jsrq = tjrq+" 23:59:59";
		page.setTotalResult(performanceDkDydklxshMxService.findDataCountByCond(ksrq, jsrq, yggh, condition));
		PageOption.initPage(page);
		List<PerformanceDKDydklxshMx> list = performanceDkDydklxshMxService.findPerformanceDKDydklxshMx(
				ksrq, jsrq, yggh, condition,page);
		BigDecimal hj = new BigDecimal(0);
		for(PerformanceDKDydklxshMx one : list){
			hj =hj.add(one.getZbgz());
		}
		modelAndView.addObject("hj",hj);
		modelAndView.addObject("list",list);
		modelAndView.addObject("tjrq",tjrq);
		modelAndView.addObject("yggh",yggh);
		modelAndView.addObject("condition",condition);
		modelAndView.addObject("page",page);
		modelAndView.setViewName("performance/performanceDkDydklxsh");
		return modelAndView;
	}
	
}
