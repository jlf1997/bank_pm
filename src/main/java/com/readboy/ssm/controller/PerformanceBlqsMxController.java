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
import com.readboy.ssm.po.PerformanceDkmnlrgzMx;
import com.readboy.ssm.service.PerformanceBlqsMxService;
/*
 * 绩效_Etc户数工资明细
 * */
@Controller
public class PerformanceBlqsMxController {
	
	@Autowired
	private PerformanceBlqsMxService performanceBlqsMxService;
	
	@ResponseBody
	@RequestMapping(value="/mobile/findPerformanceBlqsMx.action",method={RequestMethod.POST,RequestMethod.GET})
	public Map<String,Object> mobileFindPerformanceBlqsMx(
			@RequestParam(value="gyh") String shrgh,
			@RequestParam(value="gzrq")String gzrq,
			@RequestParam(value="condition",required=false) String condition,
			PageOption page) throws Exception{
		String ksrq = gzrq.substring(0,8)+"01";
		PageOption.initAppPage(page);
		Integer num = performanceBlqsMxService.findDataCountByCond(shrgh, ksrq, gzrq, condition);
		List<PerformanceBlqsMx> list = performanceBlqsMxService.findPerformanceBlqsMx(shrgh,ksrq,gzrq,condition,page);
		Map<String,Object> m = new HashMap<String,Object>();
		m.put("num", num);
		m.put("list",list);
		return m;
	}
	
	@RequestMapping(value="/findPerformanceBlqsMx.action",method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView findPerformanceBlqsMx(
			@RequestParam(value="yggh") String shrgh,
			@RequestParam(value="gzrq")String gzrq,
			@RequestParam(value="condition",required=false) String condition,
			PageOption page,
			ModelAndView modelAndView) throws Exception{
		String ksrq = gzrq.substring(0,8)+"01 00:00:00";
		String jsrq = gzrq+" 23:59:59";
		page.setTotalResult(performanceBlqsMxService.findDataCountByCond(shrgh, ksrq, jsrq, condition));
		PageOption.initPage(page);
		List<PerformanceBlqsMx> list = performanceBlqsMxService.findPerformanceBlqsMx(shrgh,ksrq,jsrq,condition,page);
		BigDecimal hj = new BigDecimal(0);
		for(PerformanceBlqsMx one : list){
			hj = hj.add(one.getZbgz());	
		}
		modelAndView.addObject("list",list);
		modelAndView.addObject("yggh",shrgh);
		modelAndView.addObject("condition",condition);
		modelAndView.addObject("hj",hj);
		modelAndView.addObject("gzrq",gzrq);
		modelAndView.addObject("page",page);
		modelAndView.setViewName("performance/performanceDkblqs");
		return modelAndView;
	}
}
