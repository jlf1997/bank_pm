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

import com.readboy.ssm.po.PerformancePhjfkgzMxCustom;
import com.readboy.ssm.service.PerformancePhjfkgzMxCustomService;
import com.readboy.ssm.utils.TableHelper;
/*
 * 绩效_平衡积分卡工资明细
 * */
@Controller
public class PerformancePhjfkgzMxCustomController {
	
	@Autowired
	private PerformancePhjfkgzMxCustomService performancePhjfkgzMxCustomService;
	
	@ResponseBody
	@RequestMapping(value="/mobile/findPerformancePhjfkgzMxCustom.action",method={RequestMethod.POST,RequestMethod.GET})
	public List<PerformancePhjfkgzMxCustom> mobileFindPerformancePhjfkgzMxCustom(
			@RequestParam(value="gyh") String yggh,
			@RequestParam(value="zzbz")String zzbz,
			@RequestParam(value="gwbz") String gwbz,
			@RequestParam(value="ksrq") String ksrq,
			@RequestParam(value="jsrq") String jsrq) throws Exception{
		return performancePhjfkgzMxCustomService.findPerformancePhjfkgzMxCustom(yggh,zzbz,gwbz,ksrq,ksrq);
	}
	
	@RequestMapping(value="/findPerformancePhjfkgzMxCustom.action",method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView findPerformancePhjfkgzMxCustom(
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
		List<PerformancePhjfkgzMxCustom> list = performancePhjfkgzMxCustomService.findPerformancePhjfkgzMxCustom(yggh,zzbz,gwbz,ksrq,jsrq);
		BigDecimal hj = new BigDecimal(0);
		for(PerformancePhjfkgzMxCustom one :list){
			hj = hj.add(one.getZbgz());
		}
		modelAndView.addObject("hj",hj);
		modelAndView.addObject("list",list);
		modelAndView.addObject("gzyf",gzyf);
		modelAndView.addObject("zzjc",zzjc);
		modelAndView.addObject("gwmc",gwmc);
		modelAndView.setViewName("performance/performancePhjfk");
		return modelAndView;
	}
	
}
