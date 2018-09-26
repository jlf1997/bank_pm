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
import com.readboy.ssm.po.PerformanceCbBmkkhhsMx;
import com.readboy.ssm.service.PerformanceCbBmkkhhsMxService;

@Controller
public class PerformanceCbBmkkhhsMxController {
	
	@Autowired
	private PerformanceCbBmkkhhsMxService performanceCbBmkkhhsMxService;
	
	//-----APP端-----
	@ResponseBody
	@RequestMapping(value="/mobile/findPerformanceCbBmkkhhsMx.action",method={RequestMethod.POST,RequestMethod.GET})
	public Map<String,Object>  mobileFindPerformanceCbBmkkhhsMx(
			@RequestParam(value="gyh") String yggh,
			@RequestParam(value="tjrq") String tjrq,
			@RequestParam(value="condition",required=false) String condition,
			PageOption page) throws Exception{
		String ksrq = tjrq.substring(0,8)+"01 00:00:00";
		String jsrq = tjrq+" 23:59:59";
		PageOption.initAppPage(page);
		Integer num = performanceCbBmkkhhsMxService.findDataCountByCond(ksrq, jsrq, yggh, condition);
		List<PerformanceCbBmkkhhsMx> list = performanceCbBmkkhhsMxService.findPerformanceCbBmkkhhsMx(ksrq, jsrq, yggh, condition,page);
		Map<String,Object> m = new HashMap<String,Object>();
		m.put("num", num);
		m.put("list",list);
		return m;
	}
	
	//-----PC端------
	@RequestMapping(value="/findPerformanceCbBmkkhhsMx.action",method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView findPerformanceCbBmkkhhsMx(
			@RequestParam(value="yggh") String yggh,
			@RequestParam(value="tjrq")String tjrq,
			@RequestParam(value="condition",required=false) String condition,PageOption page,
			ModelAndView modelAndView) throws Exception{
		String ksrq = tjrq.substring(0,8)+"01 00:00:00";
		String jsrq = tjrq+" 23:59:59";
		page.setTotalResult(performanceCbBmkkhhsMxService.findDataCountByCond(ksrq, jsrq, yggh, condition));
		PageOption.initPage(page);
		List<PerformanceCbBmkkhhsMx> list = performanceCbBmkkhhsMxService.findPerformanceCbBmkkhhsMx(ksrq, jsrq, yggh, condition,page);
		BigDecimal hj = new BigDecimal(0);
		for(PerformanceCbBmkkhhsMx one : list){
			hj = hj.add(one.getGz());
		}
		modelAndView.addObject("hj",hj);
		modelAndView.addObject("list",list);
		modelAndView.addObject("tjrq",tjrq);
		modelAndView.addObject("yggh",yggh);
		modelAndView.addObject("condition",condition);
		modelAndView.addObject("page",page);
		modelAndView.setViewName("performance/performanceCbBmkkhhs");
		return modelAndView;
	}
	
}
