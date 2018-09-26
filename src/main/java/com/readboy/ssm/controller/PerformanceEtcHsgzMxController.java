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
import com.readboy.ssm.po.PerformanceEtcHsgzMx;
import com.readboy.ssm.po.PerformanceJgpjMx;
import com.readboy.ssm.service.PerformanceEtcHsgzMxService;
/*
 * 绩效_Etc户数工资明细
 * */
@Controller
public class PerformanceEtcHsgzMxController {
	
	@Autowired
	private PerformanceEtcHsgzMxService performanceEtcHsgzMxService;
	
	@ResponseBody
	@RequestMapping(value="/mobile/findPerformanceEtcHsgzMx.action",method={RequestMethod.POST,RequestMethod.GET})
	public Map<String,Object> mobileFindPerformanceEtcHsgzMx(
			@RequestParam(value="gyh") String yggh,
			@RequestParam(value="ghlx") int ghlx,
			@RequestParam(value="tjrq")String tjrq,
			@RequestParam(value="condition",required=false) String condition,
			PageOption page) throws Exception{
		String ksrq = tjrq.substring(0,8)+"01 00:00:00";
		String jsrq = tjrq.substring(0,8)+" 23:59:59";
		PageOption.initAppPage(page);
		Integer num = performanceEtcHsgzMxService.findDataCountByCond(yggh, ghlx, ksrq, jsrq, condition);
		List<PerformanceEtcHsgzMx> list =  performanceEtcHsgzMxService.findPerformanceEtcHsgzMx(yggh, ghlx,ksrq, jsrq,condition,page);
		Map<String,Object> m = new HashMap<String,Object>();
		m.put("num", num);
		m.put("list",list);
		return m;
	}
	
	@RequestMapping(value="/findPerformanceEtcHsgzMx.action",method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView findPerformanceEtcHsgzMx(
			@RequestParam(value="yggh") String yggh,
			@RequestParam(value="ghlx") int ghlx,
			@RequestParam(value="tjrq")String tjrq,
			@RequestParam(value="condition",required=false) String condition,PageOption page,
			ModelAndView modelAndView) throws Exception{
		String ksrq = tjrq.substring(0,8)+"01 00:00:00";
		String jsrq = tjrq+" 23:59:59";
		page.setTotalResult(performanceEtcHsgzMxService.findDataCountByCond(yggh, ghlx, ksrq, jsrq, condition));
		PageOption.initPage(page);
		List<PerformanceEtcHsgzMx> list =  performanceEtcHsgzMxService.findPerformanceEtcHsgzMx(
				yggh, ghlx,ksrq, jsrq,condition,page);
		BigDecimal hj = new BigDecimal(0);
		for(PerformanceEtcHsgzMx one : list){
			hj = hj.add(one.getGz() != null ? one.getGz() : new BigDecimal(0));
		}
		modelAndView.addObject("list",list);
		modelAndView.addObject("hj",hj);
		modelAndView.addObject("tjrq",tjrq);
		modelAndView.addObject("yggh",yggh);
		modelAndView.addObject("condition",condition);
		modelAndView.addObject("ghlx",ghlx);
		modelAndView.addObject("page",page);
		modelAndView.setViewName("performance/performanceCbEtchs");
		return modelAndView;
	}
}
