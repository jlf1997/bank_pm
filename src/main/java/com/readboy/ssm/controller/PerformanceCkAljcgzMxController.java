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
import com.readboy.ssm.po.PerformanceCkAljcgzMx;
import com.readboy.ssm.po.PerformancePhjfkgzMxCustom;
import com.readboy.ssm.service.DataInfoService;
import com.readboy.ssm.service.PerformanceCkAljcgzMxService;
import com.readboy.ssm.service.StaffAndPostService;
import com.readboy.ssm.utils.TableHelper;
/*
 * 绩效_贡献率
 * */
@Controller
public class PerformanceCkAljcgzMxController {
	
	@Autowired
	private PerformanceCkAljcgzMxService performanceCkAljcgzMxService;
	@Autowired
	private StaffAndPostService staffAndPostService;
	@Autowired
	private DataInfoService dataInfoService;
	
	@ResponseBody
	@RequestMapping(value="/mobile/findPerformanceCkAljcgzMx.action",method={RequestMethod.POST,RequestMethod.GET})
	public Map<String,Object>  mobileFindPerformanceCkAljcgzMx(
			@RequestParam(value="gyh") String yggh,
			@RequestParam(value="tjrq") String tjrq,
			@RequestParam(value="type") String type,
			@RequestParam(value="condition",required=false) String condition,
			PageOption page) throws Exception{
		String tableName = TableHelper.getTableNameByDate("erp_wage_ckaljcgzmx", tjrq);
		//先判断表是否存在
		if(dataInfoService.findWheatherTableExist(tableName) == null){
			return null;
		}
		String ksrq = tjrq + " 00:00:00";
		String jsrq = tjrq + " 23:59:59";
		PageOption.initAppPage(page);
		Integer num = performanceCkAljcgzMxService.findDataCountByCond(tableName, ksrq, jsrq, yggh, condition, type);
		List<PerformanceCkAljcgzMx> list = performanceCkAljcgzMxService.findPerformanceCkAljcgzMx(tableName, ksrq, jsrq, yggh, condition, type,page);
		Map<String,Object> m = new HashMap<String,Object>();
		m.put("num", num);
		m.put("list",list);
		return m;
	}
	
	@ResponseBody
	@RequestMapping(value="/mobile/findZhhPerformanceCkAljcgzMx.action",method={RequestMethod.POST,RequestMethod.GET})
	public Map<String,Object> mobileFindZhhPerformanceCkAljcgzMx(
			@RequestParam(value="tjrq")String tjrq,
			@RequestParam(value="zzbz")String zzbz,
			@RequestParam(value="type") String type,
			@RequestParam(value="condition",required=false) String condition,PageOption page,
			ModelAndView modelAndView) throws Exception{
		String tableName = TableHelper.getTableNameByDate("erp_wage_ckaljcgzmx", tjrq);
		//先判断表是否存在
		if(dataInfoService.findWheatherTableExist(tableName) == null)
			return null;
		String ksrq = tjrq+" 00:00:00";
		String jsrq = tjrq + " 23:59:59";
		//这里入岗类型写死为4
		String yggh = staffAndPostService.findYgghByZzbz(zzbz,4);
		PageOption.initAppPage(page);
		Integer num = performanceCkAljcgzMxService.findDataCountByCond(tableName, ksrq, jsrq, yggh, condition, type);
		List<PerformanceCkAljcgzMx> list = null;
		if(yggh != null){
			list = performanceCkAljcgzMxService.findPerformanceCkAljcgzMx(tableName, ksrq, jsrq, yggh, condition, type,page);
		}
		Map<String,Object> m = new HashMap<String,Object>();
		m.put("num", num);
		m.put("list",list);
		return m;
	}

	//-------PC端请求------
	@RequestMapping(value="/findPerformanceCkAljcgzMx.action",method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView findPerformanceCkAljcgzMx(
			@RequestParam(value="yggh") String yggh,
			@RequestParam(value="tjrq")String tjrq,
			@RequestParam(value="type") String type,
			@RequestParam(value="condition",required=false) String condition,PageOption page,
			ModelAndView modelAndView) throws Exception{
		String tableName = TableHelper.getTableNameByDate("erp_wage_ckaljcgzmx", tjrq);
		if(dataInfoService.findWheatherTableExist(tableName) == null){
			modelAndView.addObject("message","你所查询的月份的数据表不存在！");
			modelAndView.setViewName("fail");
			return modelAndView;
		}
		String ksrq = tjrq+" 00:00:00";
		String jsrq = tjrq + " 23:59:59";
		long t1 = System.currentTimeMillis();
		page.setTotalResult(performanceCkAljcgzMxService.findDataCountByCond(tableName, ksrq, jsrq, yggh, condition, type));
		long t2 = System.currentTimeMillis();
		System.out.println("查询记录条数用时:"+(t2-t1)+"ms");
		PageOption.initPage(page);
		long t3 = System.currentTimeMillis();
		List<PerformanceCkAljcgzMx> list = performanceCkAljcgzMxService.findPerformanceCkAljcgzMx(tableName, ksrq, jsrq, yggh, condition, type,page);
		long t4 = System.currentTimeMillis();
		System.out.println("查询记录用时"+(t4-t3)+"ms");
		BigDecimal hj = new BigDecimal(0);
		long t5 = System.currentTimeMillis();
		for(PerformanceCkAljcgzMx one :list){
			if(type.equals("cl")){
				hj = hj.add(one.getClyrpgz());
			}else{
				hj = hj.add(one.getZlyrpgz());
			}
		}
		long t6 = System.currentTimeMillis();
		System.out.println("循环统计价格用时:"+(t6-t5)+"ms");
		System.out.println("--------------------");
		modelAndView.addObject("hj",hj);
		modelAndView.addObject("list",list);
		modelAndView.addObject("tjrq",tjrq);
		modelAndView.addObject("type",type);
		modelAndView.addObject("yggh",yggh);
		modelAndView.addObject("condition",condition);
		modelAndView.addObject("page",page);
		modelAndView.setViewName("performance/performanceCkAljc");
		return modelAndView;
	}
	
	@RequestMapping(value="/findZhhPerformanceCkAljcgzMx.action",method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView findZhhPerformanceCkAljcgzMx(
			@RequestParam(value="tjrq")String tjrq,
			@RequestParam(value="zzbz")String zzbz,
			@RequestParam(value="type") String type,
			@RequestParam(value="condition",required=false) String condition,PageOption page,
			ModelAndView modelAndView) throws Exception{
		String tableName = TableHelper.getTableNameByDate("erp_wage_ckaljcgzmx", tjrq);
		if(dataInfoService.findWheatherTableExist(tableName) == null){
			modelAndView.addObject("message","你所查询的月份的数据表不存在！");
			modelAndView.setViewName("fail");
			return modelAndView;
		}
		String ksrq = tjrq+" 00:00:00";
		String jsrq = tjrq + " 23:59:59";
		//这里入岗类型写死为4
		String yggh = staffAndPostService.findYgghByZzbz(zzbz,4);
		List<PerformanceCkAljcgzMx> list = null;
		page.setTotalResult(performanceCkAljcgzMxService.findDataCountByCond(tableName, ksrq, jsrq, yggh, condition, type));
		PageOption.initPage(page);
		if(yggh != null){
			list = performanceCkAljcgzMxService.findPerformanceCkAljcgzMx(tableName, ksrq, jsrq, yggh, condition, type,page);
		}
		BigDecimal hj = new BigDecimal(0);
		for(PerformanceCkAljcgzMx one :list){
			if(type.equals("cl")){
				hj = hj.add(one.getClyrpgz());
			}else{
				hj = hj.add(one.getZlyrpgz());
			}
		}
		modelAndView.addObject("hj",hj);
		modelAndView.addObject("list",list);
		modelAndView.addObject("tjrq",tjrq);
		modelAndView.addObject("type",type);
		modelAndView.addObject("zzbz",zzbz);
		modelAndView.addObject("condition",condition);
		modelAndView.addObject("page",page);
		modelAndView.setViewName("performance/performanceCkAljcZhh");
		return modelAndView;
	}
	
}
