package com.readboy.ssm.controller;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.readboy.ssm.po.PageOption;
import com.readboy.ssm.po.PerformanceDkKhhsMx;
import com.readboy.ssm.service.DataInfoService;
import com.readboy.ssm.service.PerformanceDkKhhsMxService;
import com.readboy.ssm.utils.TableHelper;
/*
 * 绩效_贡献率
 * */
@Controller
public class PerformanceDkKhhsMxController {
	
	@Autowired
	private PerformanceDkKhhsMxService performanceDkKhhsMxService;
	@Autowired
	private DataInfoService dataInfoService;
	@ResponseBody
	@RequestMapping(value="/mobile/findPerformanceDkKhhsMx.action",method={RequestMethod.POST,RequestMethod.GET})
	public Map<String,Object> mobileFindPerformanceDkKhhsMx(
			@RequestParam(value="gyh") String yggh,
			@RequestParam(value="tjrq") String tjrq,
			@RequestParam(value="condition",required=false) String condition,
			@RequestParam(value="lx") String lx,
			 PageOption page) throws Exception{
		int days = TableHelper.getDaysOfMonth(tjrq);
		String ksrq = tjrq.substring(0,8)+"01 00:00:00";
		String jsrq = tjrq+" 23:59:59";
		PageOption.initAppPage(page);
		Integer num = performanceDkKhhsMxService.findDataCountByCondition(ksrq, jsrq, yggh, condition, lx);
		List<PerformanceDkKhhsMx> list = performanceDkKhhsMxService.findPerformanceDkKhhsMx(ksrq, jsrq, yggh, condition, lx,page);
		Map<String,Object> m = new HashMap<String,Object>();
		m.put("num", num);
		m.put("list",list);
		return m;
	}
	
	@RequestMapping(value="/findPerformanceDkKhhsMx.action",method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView findPerformanceDkKhhsMx(
			@RequestParam(value="yggh") String yggh,
			@RequestParam(value="tjrq")String tjrq,
			@RequestParam(value="condition",required=false) String condition,
			@RequestParam(value="lx") String lx,PageOption page,
			ModelAndView modelAndView) throws Exception{
		String ksrq = tjrq.substring(0,8)+"01 00:00:00";
		String jsrq = tjrq+" 23:59:59";
		//设置查询结果集记录总条数
		page.setTotalResult(performanceDkKhhsMxService.findDataCountByCondition(ksrq, jsrq, yggh, condition, lx));
		PageOption.initPage(page);
		List<PerformanceDkKhhsMx> list = performanceDkKhhsMxService.findPerformanceDkKhhsMx(ksrq, jsrq, yggh, condition, lx,page);
		BigDecimal hj = new BigDecimal(0);
		for(PerformanceDkKhhsMx one :list){
			hj = hj.add(one.getGz());
		}
		modelAndView.addObject("hj",hj);
		modelAndView.addObject("list",list);
		modelAndView.addObject("tjrq",tjrq);
		modelAndView.addObject("yggh",yggh);
		modelAndView.addObject("condition",condition);
		modelAndView.addObject("lx",lx);
		modelAndView.addObject("page",page);
		modelAndView.setViewName("performance/performanceDkkhhs");
		return modelAndView;
	}
	
}
