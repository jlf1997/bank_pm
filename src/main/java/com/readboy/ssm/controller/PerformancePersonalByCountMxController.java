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

import com.readboy.ssm.po.Area;
import com.readboy.ssm.po.PerformanceAljcgzMxCustom;
import com.readboy.ssm.po.PerformancePersonalByCountMx;
import com.readboy.ssm.service.AreaService;
import com.readboy.ssm.service.PerformancePersonalByCountMxService;
/*
 * 绩效_个人按量计酬
 * */
@Controller
public class PerformancePersonalByCountMxController {
	
	@Autowired
	private PerformancePersonalByCountMxService performancePersonalByCountMxService;
	@Autowired
	
	private AreaService areaService;
	@ResponseBody
	@RequestMapping(value="/mobile/findPerformancePersonalByCountMx.action",method={RequestMethod.POST,RequestMethod.GET})
	public List<PerformancePersonalByCountMx> mobielFindPerformancePersonalByCountMx(
			@RequestParam(value="gyh") String yggh,
			@RequestParam(value="gzrq")String gzrq,
			@RequestParam(value="zbid")String zbid) throws Exception{
			String ksrq = gzrq + " 00:00:00";
			String jsrq = gzrq + " 23:59:59";
			return performancePersonalByCountMxService.findPerformancePersonalByCountMx(yggh, ksrq,jsrq, zbid);
	}
	
	@RequestMapping(value="/findPerformancePersonalByCountMx.action",method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView findPerformancePersonalByCountMx(
			@RequestParam(value="yggh") String yggh,
			@RequestParam(value="gzrq")String gzrq,
			@RequestParam(value="zbid")String zbid,
			ModelAndView modelAndView) throws Exception{
		String ksrq = gzrq + " 00:00:00";
		String jsrq = gzrq + " 23:59:59";
		List<PerformancePersonalByCountMx> list =  performancePersonalByCountMxService.findPerformancePersonalByCountMx(yggh, ksrq,jsrq, zbid);
		BigDecimal hj = new BigDecimal(0);
		for(PerformancePersonalByCountMx one : list){
			hj = hj.add(one.getZbgz());
		}
		modelAndView.addObject("list",list);
		modelAndView.addObject("hj",hj);
		modelAndView.addObject("gzrq",gzrq);
		modelAndView.addObject("zbid",zbid);
		modelAndView.setViewName("performance/performanceCbGraljc");
		return modelAndView;
	}
}
