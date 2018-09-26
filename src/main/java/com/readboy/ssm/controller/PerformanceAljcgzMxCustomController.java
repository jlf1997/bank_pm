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

import com.readboy.ssm.po.PerformanceAljcgzMxCustom;
import com.readboy.ssm.po.PerformanceMx;
import com.readboy.ssm.service.PerformanceAljcgzMxCustomService;
import com.readboy.ssm.utils.TableHelper;
/*
 * 绩效_按量计酬工资明细
 * */
@Controller
public class PerformanceAljcgzMxCustomController {
	
	@Autowired
	private PerformanceAljcgzMxCustomService performanceAljcgzMxCustomService;
	
	@ResponseBody
	@RequestMapping(value="/mobile/findPerformanceAljcgzMxCustom.action",method={RequestMethod.POST,RequestMethod.GET})
	public List<PerformanceAljcgzMxCustom> mobileFindPerformanceAljcgzMxCustom(
			@RequestParam(value="gyh") String yggh,
			@RequestParam(value="zzbz")String zzbz,
			@RequestParam(value="gwbz") String gwbz,
			@RequestParam(value="ksrq") String ksrq,
			@RequestParam(value="jsrq") String jsrq) throws Exception{
		return performanceAljcgzMxCustomService.findPerformanceAljcgzMxCustom(yggh,zzbz,gwbz,ksrq,ksrq);
	}
	
	@RequestMapping(value="/findPerformanceAljcgzMxCustom.action",method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView findPerformanceAljcgzMxCustom(
			@RequestParam(value="yggh") String yggh,
			@RequestParam(value="zzbz")String zzbz,
			@RequestParam(value="gwbz") String gwbz,
			@RequestParam(value="gzyf") String gzyf,
			@RequestParam(value="gwmc") String gwmc,
			@RequestParam(value="zzjc") String zzjc,
			ModelAndView modelAndView) throws Exception{
		String ksrq = gzyf+"-01 00:00:00";
		String jsrq = new StringBuilder(gzyf).append("-").
				append(TableHelper.getDaysOfMonth(gzyf)).append(" 23:59:59").toString();
		
		List<PerformanceAljcgzMxCustom> list =  performanceAljcgzMxCustomService.findPerformanceAljcgzMxCustom(yggh,zzbz,gwbz,ksrq,jsrq);
		BigDecimal hj = new BigDecimal(0);
		for(PerformanceAljcgzMxCustom one : list){
			hj = hj.add(one.getZbgz());
		}
		modelAndView.addObject("list",list);
		modelAndView.addObject("hj",hj);
		modelAndView.addObject("gzyf",gzyf);
		modelAndView.addObject("zzjc",zzjc);
		modelAndView.addObject("gwmc",gwmc);
		modelAndView.setViewName("performance/performanceAljc");
		return modelAndView;
	}
}
