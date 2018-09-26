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
import com.readboy.ssm.po.PerformanceDkmnlrgzMx;
import com.readboy.ssm.service.DataInfoService;
import com.readboy.ssm.service.PerformanceDkmnlrgzMxService;
import com.readboy.ssm.utils.Constants;
import com.readboy.ssm.utils.TableHelper;
/*
 * 绩效_贷款客户包收明细
 * */
@Controller
public class PerformanceDkmnlrgzMxController {
	
	@Autowired
	private PerformanceDkmnlrgzMxService performanceDkmnlrgzMxService;
	@Autowired
	private DataInfoService dataInfoService;
	
	@ResponseBody
	@RequestMapping(value="/mobile/findPerformanceDkmnlrgzMx.action",method={RequestMethod.POST,RequestMethod.GET})
	public Map<String,Object> mobileFindPerformanceDkmnlrgzMx(
			@RequestParam(value="gyh") String yggh,
			@RequestParam(value="tjrq")String tjrq,
			@RequestParam(value="condition",required=false)String condition,
			PageOption page) throws Exception{
		String tableName = TableHelper.getTableNameByDate(Constants.table_dkmnlrgzmx,tjrq);
		if(dataInfoService.findWheatherTableExist(tableName) == null){
			return null;
		}
		PageOption.initAppPage(page);
		Integer num = performanceDkmnlrgzMxService.findDataCountByCond(yggh, tjrq, tjrq, condition);
		List<PerformanceDkmnlrgzMx> list = performanceDkmnlrgzMxService.findPerformanceDkmnlrgzMx(yggh, tjrq, tjrq,condition,page);
		Map<String,Object> m = new HashMap<String,Object>();
		m.put("num", num);
		m.put("list",list);
		return m;
	}
	
	@RequestMapping(value="/findPerformanceDkmnlrgzMx.action",method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView findPerformanceDkmnlrgzMx(
			@RequestParam(value="yggh") String yggh,
			@RequestParam(value="tjrq")String tjrq,
			@RequestParam(value="type")String type,PageOption page,
			@RequestParam(value="condition",required=false)String condition,ModelAndView modelAndView) throws Exception{
		String tableName = TableHelper.getTableNameByDate(Constants.table_dkmnlrgzmx,tjrq);
		if(dataInfoService.findWheatherTableExist(tableName) == null){
			modelAndView.addObject("message","你所查询的数据表不存在");
			modelAndView.setViewName("fail");
			return modelAndView;
		}
		page.setTotalResult(performanceDkmnlrgzMxService.findDataCountByCond(yggh, tjrq, tjrq, condition));
		PageOption.initPage(page);
		List<PerformanceDkmnlrgzMx> list = performanceDkmnlrgzMxService.findPerformanceDkmnlrgzMx(
				yggh, tjrq, tjrq,condition,page);
		BigDecimal hj = new BigDecimal(0);
		for(PerformanceDkmnlrgzMx one : list){
			if(type.equals("cl")){
				hj = hj.add(one.getClgz());
			}else{
				hj = hj.add(one.getZlgz());
			}
		}
		modelAndView.addObject("list",list);
		modelAndView.addObject("yggh",yggh);
		modelAndView.addObject("condition",condition);
		modelAndView.addObject("type",type);
		modelAndView.addObject("hj",hj);
		modelAndView.addObject("tjrq",tjrq);
		modelAndView.addObject("page",page);
		modelAndView.setViewName("performance/performanceDkmnlr");
		return modelAndView;
	}
	
	
}
