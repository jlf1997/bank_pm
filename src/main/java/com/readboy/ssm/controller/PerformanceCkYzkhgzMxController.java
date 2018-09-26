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
import com.readboy.ssm.po.PerformanceCkYzkhgzMx;
import com.readboy.ssm.service.DataInfoService;
import com.readboy.ssm.service.PerformanceCkYzkhgzMxService;
import com.readboy.ssm.utils.TableHelper;
/*
 * 绩效_贡献率
 * */
@Controller
public class PerformanceCkYzkhgzMxController {
	
	@Autowired
	private PerformanceCkYzkhgzMxService performanceCkYzkhgzMxService;
	@Autowired
	private DataInfoService dataInfoService;
	@ResponseBody
	@RequestMapping(value="/mobile/findPerformanceCkYzkhgzMx.action",method={RequestMethod.POST,RequestMethod.GET})
	public  Map<String,Object> mobileFindPerformanceCkYzkhgzMx(
			@RequestParam(value="gyh") String yggh,
			@RequestParam(value="tjrq") String tjrq,
			@RequestParam(value="condition",required=false) String condition,
			 PageOption page) throws Exception{
		String tableName = TableHelper.getTableNameByDate("erp_wage_ckyzkhgzmx", tjrq);
		if(dataInfoService.findWheatherTableExist(tableName) == null)
			return null;
		String ksrq = tjrq + " 00:00:00";
		String jsrq = tjrq + " 23:59:59";
		PageOption.initAppPage(page);
		Integer num = performanceCkYzkhgzMxService.findDataCount(tableName, ksrq, jsrq, yggh, condition);
		List<PerformanceCkYzkhgzMx> list = performanceCkYzkhgzMxService.findPerformanceCkYzkhgzMx(tableName, ksrq, jsrq, yggh, condition,page);
		Map<String,Object> m = new HashMap<String,Object>();
		m.put("num", num);
		m.put("list",list);
		return m;
	}
	
	@RequestMapping(value="/findPerformanceCkYzkhgzMx.action",method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView findPerformanceCkYzkhgzMx(
			@RequestParam(value="yggh") String yggh,
			@RequestParam(value="tjrq")String tjrq,
			@RequestParam(value="condition",required=false) String condition,PageOption page,
			ModelAndView modelAndView) throws Exception{
		String tableName = TableHelper.getTableNameByDate("erp_wage_ckyzkhgzmx", tjrq);
		if(dataInfoService.findWheatherTableExist(tableName) == null){
			modelAndView.addObject("message","你所查询的数据表不存在");
			modelAndView.setViewName("fail");
			return modelAndView;
		}
		String ksrq = tjrq+" 00:00:00";
		String jsrq = tjrq + " 23:59:59";
		page.setTotalResult(performanceCkYzkhgzMxService.findDataCount(tableName, ksrq, jsrq, yggh, condition));
		PageOption.initPage(page);
		List<PerformanceCkYzkhgzMx> list = performanceCkYzkhgzMxService.findPerformanceCkYzkhgzMx(tableName, ksrq, jsrq, yggh, condition,page);
		BigDecimal hj = new BigDecimal(0);
		for(PerformanceCkYzkhgzMx one :list){
			hj = hj.add(one.getYzkhgz());
		}
		modelAndView.addObject("hj",hj);
		modelAndView.addObject("list",list);
		modelAndView.addObject("tjrq",tjrq);
		modelAndView.addObject("yggh",yggh);
		modelAndView.addObject("condition",condition);
		modelAndView.addObject("page",page);
		modelAndView.setViewName("performance/performanceCkYzkhgz");
		return modelAndView;
	}
	
}
