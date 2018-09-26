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
import com.readboy.ssm.po.PerformanceDkAljcgzMx;
import com.readboy.ssm.service.DataInfoService;
import com.readboy.ssm.service.PerformanceDkAljcgzMxService;
import com.readboy.ssm.utils.TableHelper;
/*
 * 绩效_贷款按量计酬工资明细
 * */
@Controller
public class PerformanceDkAljcgzMxController {
	
	@Autowired
	private PerformanceDkAljcgzMxService performanceDkAljcgzMxService;
	@Autowired
	private DataInfoService dataInfoService;
	//-----APP端-----
	@ResponseBody
	@RequestMapping(value="/mobile/findPerformanceDkAljcgzMx.action",method={RequestMethod.POST,RequestMethod.GET})
	public Map<String,Object>  mobileFindPerformanceDkAljcgzMx(
			@RequestParam(value="gyh") String yggh,
			@RequestParam(value="tjrq") String tjrq,
			@RequestParam(value="condition",required=false) String condition,
			PageOption page) throws Exception{
		String tableName = TableHelper.getTableNameByDate("erp_wage_dkaljcgzmx", tjrq);
		if(dataInfoService.findWheatherTableExist(tableName) == null){
			return null;
		}
		String ksrq = tjrq+" 00:00:00";
		String jsrq = tjrq+" 23:59:59";
		PageOption.initAppPage(page);
		Integer num = performanceDkAljcgzMxService.findDataCountByCond(tableName, ksrq, jsrq, yggh, condition);
		List<PerformanceDkAljcgzMx> list =  performanceDkAljcgzMxService.findPerformanceDkAljcgzMx(tableName, ksrq, jsrq, yggh, condition,page);
		Map<String,Object> m = new HashMap<String,Object>();
		m.put("num", num);
		m.put("list",list);
		return m;
	}
	
	//-----PC端------
	@RequestMapping(value="/findPerformanceDkAljcgzMx.action",method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView findPerformanceDkAljcgzMx(
			@RequestParam(value="yggh") String yggh,
			@RequestParam(value="tjrq")String tjrq,
			@RequestParam(value="condition",required=false) String condition,PageOption page,
			ModelAndView modelAndView) throws Exception{
		String tableName = TableHelper.getTableNameByDate("erp_wage_dkaljcgzmx", tjrq);
		if(dataInfoService.findWheatherTableExist(tableName) == null){
			modelAndView.addObject("message","你查询的数据表并不存在！");
			modelAndView.setViewName("fail");
			return modelAndView;
		}
		String ksrq = tjrq+" 00:00:00";
		String jsrq = tjrq+" 23:59:59";
		page.setTotalResult(performanceDkAljcgzMxService.findDataCountByCond(tableName, 
				ksrq, jsrq, yggh, condition));
		PageOption.initPage(page);
		List<PerformanceDkAljcgzMx> list = performanceDkAljcgzMxService.findPerformanceDkAljcgzMx(
				tableName, ksrq, jsrq,yggh, condition,page);
		BigDecimal hj = new BigDecimal(0);
		for(PerformanceDkAljcgzMx one :list){
			hj = hj.add(one.getYmgz());
		}
		modelAndView.addObject("hj",hj);
		modelAndView.addObject("list",list);
		modelAndView.addObject("tjrq",tjrq);
		modelAndView.addObject("yggh",yggh);
		modelAndView.addObject("condition",condition);
		modelAndView.addObject("page",page);
		modelAndView.setViewName("performance/performanceDkAljc");
		return modelAndView;
	}
	
}
