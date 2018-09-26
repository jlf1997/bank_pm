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

import com.readboy.ssm.po.PerformanceGxlgzMxCustom;
import com.readboy.ssm.po.PerformancePhjfkgzMxCustom;
import com.readboy.ssm.service.PerformanceGxlgzMxCustomService;
import com.readboy.ssm.utils.TableHelper;
/*
 * 绩效_贡献率
 * */
@Controller
public class PerformanceGxlgzMxCustomController {
	
	@Autowired
	private PerformanceGxlgzMxCustomService performanceGxlgzMxCustomService;
	
	@ResponseBody
	@RequestMapping(value="/mobile/findPerformanceGxlgzMxCustom.action",method={RequestMethod.POST,RequestMethod.GET})
	public List<PerformanceGxlgzMxCustom> mobileFindPerformanceGxlgzMxCustom(
			@RequestParam(value="gyh") String yggh,
			@RequestParam(value="zzbz")String zzbz,
			@RequestParam(value="gwbz") String gwbz,
			@RequestParam(value="ksrq") String ksrq,
			@RequestParam(value="jsrq") String jsrq) throws Exception{
		return performanceGxlgzMxCustomService.findPerformanceGxlgzMxCustom(yggh,zzbz,gwbz,ksrq,ksrq);
	}
	
	@RequestMapping(value="/findPerformanceGxlgzMxCustom.action",method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView findPerformanceGxlgzMxCustom(
			@RequestParam(value="yggh") String yggh,
			@RequestParam(value="zzbz")String zzbz,
			@RequestParam(value="gwbz") String gwbz,
			@RequestParam(value="gzyf") String gzyf,
			@RequestParam(value="zzjc") String zzjc,
			@RequestParam(value="gwmc") String gwmc,
			ModelAndView modelAndView) throws Exception{
		String ksrq = gzyf+"01 00:00:00";
		String jsrq = new StringBuilder(gzyf).append("-").
				append(TableHelper.getDaysOfMonth(gzyf)).append(" 23:59:59").toString();
		List<PerformanceGxlgzMxCustom> list = performanceGxlgzMxCustomService.findPerformanceGxlgzMxCustom(yggh,zzbz,gwbz,ksrq,jsrq);
		BigDecimal hj = new BigDecimal(0);
		for(PerformanceGxlgzMxCustom one :list){
			hj = hj.add(one.getZbgz());
		}
		modelAndView.addObject("hj",hj);
		modelAndView.addObject("list",list);
		modelAndView.addObject("gzyf",gzyf);
		modelAndView.addObject("zzjc",zzjc);
		modelAndView.addObject("gwmc",gwmc);
		modelAndView.setViewName("performance/performanceGxl");
		return modelAndView;
	}
	
}
