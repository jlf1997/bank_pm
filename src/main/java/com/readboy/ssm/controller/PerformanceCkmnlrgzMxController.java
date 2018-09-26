package com.readboy.ssm.controller;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.readboy.ssm.po.PageOption;
import com.readboy.ssm.po.PerformanceCkmnlrgzMx;
import com.readboy.ssm.service.DataInfoService;
import com.readboy.ssm.service.PerformanceCkmnlrgzMxService;
import com.readboy.ssm.service.StaffAndPostService;
import com.readboy.ssm.utils.Constants;
import com.readboy.ssm.utils.PageHelper;
import com.readboy.ssm.utils.TableHelper;
/*
 * 绩效_存款模拟利润工资明细
 * */
@Controller
public class PerformanceCkmnlrgzMxController {
	
	@Autowired
	private PerformanceCkmnlrgzMxService performanceCkmnlrgzMxService;
	@Autowired
	private StaffAndPostService staffAndPostService;
	@Autowired
	private DataInfoService dataInfoService;
	
	@ResponseBody
	@RequestMapping(value="/mobile/findPerformanceClCkmnlrgzMx.action",method={RequestMethod.POST,RequestMethod.GET})
	public Map<String,Object>  mobileFindPerformanceClCkmnlrgzMx(
			@RequestParam(value="gyh") String yggh,
			@RequestParam(value="tjrq")String tjrq,
			@RequestParam(value="yxlx") int yxlx,
			@RequestParam(value="condition",required=false) String condition,
			PageOption page) throws Exception{
		String tableName = TableHelper.getTableNameByDate(Constants.table_ckmnlrgzmx,tjrq);
		if(dataInfoService.findWheatherTableExist(tableName) == null)
			return null;
		PageOption.initAppPage(page);
		Integer num = performanceCkmnlrgzMxService.findClDataCount(yggh, yxlx, tjrq, tjrq, condition);
		List<PerformanceCkmnlrgzMx> list =  performanceCkmnlrgzMxService.findPerformanceClCkmnlrgzMx(yggh,yxlx,tjrq, tjrq,condition,page);
		Map<String,Object> m = new HashMap<String,Object>();
		m.put("num", num);
		m.put("list",list);
		return m;
	}
	
	@ResponseBody
	@RequestMapping(value="/mobile/findPerformanceZlCkmnlrgzMx.action",method={RequestMethod.POST,RequestMethod.GET})
	public Map<String,Object> mobileFindPerformanceZlCkmnlrgzMx(
			@RequestParam(value="gyh") String yggh,
			@RequestParam(value="tjrq")String tjrq,
			@RequestParam(value="yxlx") int yxlx,
			@RequestParam(value="condition",required=false) String condition,PageOption page) throws Exception{
		String tableName = TableHelper.getTableNameByDate(Constants.table_ckmnlrgzmx,tjrq);
		if(dataInfoService.findWheatherTableExist(tableName) == null)
			return null;
		PageOption.initAppPage(page);
		Integer num = performanceCkmnlrgzMxService.findDataCountByCond(tableName, tjrq, tjrq);
		List<PerformanceCkmnlrgzMx> list =  performanceCkmnlrgzMxService.findPerformanceZlCkmnlrgzMx(yggh,yxlx,tjrq,tjrq,condition,page);
		Map<String,Object> m = new HashMap<String,Object>();
		m.put("num", num);
		m.put("list",list);
		return m;
	}
	
	//综合户：存量存款模拟利润工资明细
	@ResponseBody
	@RequestMapping(value="/mobile/findZhhPerformanceClCkmnlrgzMx.action",method={RequestMethod.POST,RequestMethod.GET})
	public Map<String,Object> mobileFindZhhPerformanceClCkmnlrgzMx(
			@RequestParam(value="zzbz") String zzbz,
			@RequestParam(value="tjrq")String tjrq,
	 		@RequestParam(value="yxlx") int yxlx,
			@RequestParam(value="condition",required=false)String condition,PageOption page) throws Exception{
		String tableName = TableHelper.getTableNameByDate(Constants.table_ckmnlrgzmx,tjrq);
		if(dataInfoService.findWheatherTableExist(tableName) == null){
			return null;
		}
		//这里根据组织标志查yggh时,入岗类型写死为4
		String yggh = staffAndPostService.findYgghByZzbz(zzbz,4);
		PageOption.initAppPage(page);
		Integer num = performanceCkmnlrgzMxService.findDataCountByCond(tableName, tjrq, tjrq);
		List<PerformanceCkmnlrgzMx> list =  null;
		if(yggh != null && !yggh.equals("")){
			list = performanceCkmnlrgzMxService.findPerformanceClCkmnlrgzMx(yggh,yxlx,tjrq,tjrq,condition,page);
		}
		Map<String,Object> m = new HashMap<String,Object>();
		m.put("num", num);
		m.put("list",list);
		return m;
	}
	//综合户：增量存款模拟利润工资明细
	@ResponseBody
	@RequestMapping(value="/mobile/findZhhPerformanceZlCkmnlrgzMx.action",method={RequestMethod.POST,RequestMethod.GET})
	public Map<String,Object> mobileFindZhhPerformanceZlCkmnlrgzMx(
			@RequestParam(value="zzbz") String zzbz,
			@RequestParam(value="tjrq")String tjrq,
			@RequestParam(value="yxlx") int yxlx,
			@RequestParam(value="condition",required=false) String condition,PageOption page) throws Exception{
		
		String tableName = TableHelper.getTableNameByDate(Constants.table_ckmnlrgzmx,tjrq);
		if(dataInfoService.findWheatherTableExist(tableName) == null){
			return null;
		}
		Integer num = performanceCkmnlrgzMxService.findDataCountByCond(tableName, tjrq, tjrq);
		List<PerformanceCkmnlrgzMx> list =  null;
		//这里根据组织标志查yggh时,入岗类型写死为4
		String yggh = staffAndPostService.findYgghByZzbz(zzbz,4);
		PageOption.initAppPage(page);
		if(yggh != null && !yggh.equals("")){
			list =  performanceCkmnlrgzMxService.findPerformanceZlCkmnlrgzMx(yggh,yxlx,tjrq,tjrq,condition,page);
		}
		Map<String,Object> m = new HashMap<String,Object>();
		m.put("num", num);
		m.put("list",list);
		return m;
	}
	
	//---------------PC端查询---------------
	@RequestMapping(value="/findPerformanceCkmnlrgzMxBycondition.action",method={RequestMethod.POST,RequestMethod.GET})
	public String findPerformanceClCkmnlrgzMx(
			@RequestParam(value="tjrq")String tjrq,Model model) throws Exception{
		String tableName = TableHelper.getTableNameByDate(Constants.table_ckmnlrgzmx,tjrq);
		if(dataInfoService.findWheatherTableExist(tableName) == null){
			model.addAttribute("message","你所选择的数据表不存在！");
			return "fail";
		}
		int days = TableHelper.getDaysOfMonth(tjrq);
		String ksrq = tjrq + "-01";
		String jsrq = tjrq +"-"+days;
		List<PerformanceCkmnlrgzMx> list = performanceCkmnlrgzMxService.findPerformanceCkmnlrgzMxByCondition(tableName,ksrq,jsrq);
		model.addAttribute("list",list);
		return "performance/performanceCkmnlrgzMx";
	}
	
	//分页查询
	@RequestMapping(value="/pageFindPerformanceCkmnlrgzMx.action",method={RequestMethod.POST,RequestMethod.GET})
	public String pageFindPerformanceCkmnlrgzMx
			(@RequestParam(value="tjrq") String tjrq,
			@RequestParam(value="currentPage",required=true) long currentPage,Model model) throws Exception{
		String tableName = TableHelper.getTableNameByDate(Constants.table_ckmnlrgzmx,tjrq);
		if(dataInfoService.findWheatherTableExist(tableName) == null){
			model.addAttribute("message","你所选择的数据表不存在！");
			return "fail";
		}
		PageHelper ph = new PageHelper();
		List<PerformanceCkmnlrgzMx> list = null;
		long noteCount = 0;
		try {
			noteCount = performanceCkmnlrgzMxService.getNoteCount(tableName);
			ph.pageSetup(currentPage, noteCount);
			list = performanceCkmnlrgzMxService.pageFindPerformanceCkmnlrgzMx(
					tableName,ph.getStartIndex() ,ph.getPageSize());
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.addAttribute("list",list);
		model.addAttribute("ph",ph);
		model.addAttribute("tjrq",tjrq);
		return "performance/performanceCkmnlrgzMxList";
	}
	
	
	//多条件查询唯一记录
	@RequestMapping(value="/findOnePerformanceCkmnlrgzMx.action",method={RequestMethod.POST,RequestMethod.GET})
	public String findOnePerformanceCkmnlrgzMx(
			@RequestParam(value="tjrq")String tjrq,
			@RequestParam(value="zzbz")String zzbz,
			@RequestParam(value="gwbz")long gwbz,
			@RequestParam(value="yggh")String yggh,
			@RequestParam(value="ckzh")String ckzh,
			Model model) throws Exception{
		String tableName = TableHelper.getTableNameByDate(Constants.table_ckmnlrgzmx,tjrq);
		if(dataInfoService.findWheatherTableExist(tableName) == null){
			model.addAttribute("message","你所选择的数据表不存在！");
			return "fail";
		}
		PerformanceCkmnlrgzMx one = performanceCkmnlrgzMxService.findOnePerformanceCkmnlrgzMx(tableName, tjrq, zzbz, gwbz, yggh, ckzh);
		model.addAttribute("one",one);
		return "performance/performanceCkmnlrgzMx";
	}
	
	//查询存量存款
	@RequestMapping(value="/findPerformanceClCkmnlrgzMx.action",method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView findPerformanceClCkmnlrgzMx(
			@RequestParam(value="yggh") String yggh,
			@RequestParam(value="tjrq")String tjrq,
			@RequestParam(value="yxlx") int yxlx,
			@RequestParam(value="condition",required=false) String condition,PageOption page,
			ModelAndView modelAndView) throws Exception{
		String tableName = TableHelper.getTableNameByDate(Constants.table_ckmnlrgzmx,tjrq);
		if(dataInfoService.findWheatherTableExist(tableName) == null){
			modelAndView.addObject("message","你所选择的数据表不存在！");
			modelAndView.setViewName("fail");
			return modelAndView;
		}
		page.setTotalResult(performanceCkmnlrgzMxService.findClDataCount(yggh, yxlx, tjrq, tjrq, condition));
		PageOption.initPage(page);
		List<PerformanceCkmnlrgzMx> list = performanceCkmnlrgzMxService.findPerformanceClCkmnlrgzMx(yggh,yxlx,tjrq, tjrq,condition,page);
		BigDecimal hj = new BigDecimal(0);
		for(PerformanceCkmnlrgzMx one: list){
			hj = hj.add(one.getClgz());
		}
		modelAndView.addObject("list",list);
		modelAndView.addObject("tjrq",tjrq);
		modelAndView.addObject("yggh",yggh);
		modelAndView.addObject("condition",condition);
		modelAndView.addObject("hj",hj);
		modelAndView.addObject("type","cl");
		modelAndView.addObject("page",page);
		modelAndView.setViewName("performance/performanceCkmnlr");
		return modelAndView;
	}
	
	//增量存款模拟利润工资明细
	@RequestMapping(value="/findPerformanceZlCkmnlrgzMx.action",method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView findPerformanceZlCkmnlrgzMx(
			@RequestParam(value="yggh") String yggh,
			@RequestParam(value="tjrq")String tjrq,
			@RequestParam(value="yxlx") int yxlx,
			@RequestParam(value="condition",required=false) String condition,PageOption page,
			ModelAndView modelAndView) throws Exception{
		String tableName = TableHelper.getTableNameByDate(Constants.table_ckmnlrgzmx,tjrq);
		if(dataInfoService.findWheatherTableExist(tableName) == null){
			modelAndView.addObject("message","你所选择的数据表不存在！");
			modelAndView.setViewName("fail");
			return modelAndView;
		}
		page.setTotalResult(performanceCkmnlrgzMxService.findZlDataCount(yggh, yxlx, tjrq, tjrq, condition));
		PageOption.initPage(page);
		List<PerformanceCkmnlrgzMx> list = performanceCkmnlrgzMxService.findPerformanceZlCkmnlrgzMx(yggh, yxlx, tjrq, tjrq, condition,page);
		BigDecimal hj = new BigDecimal(0);
		for(PerformanceCkmnlrgzMx one: list){
			hj = hj.add(one.getZlgz());
		}
		modelAndView.addObject("list",list);
		modelAndView.addObject("tjrq",tjrq);
		modelAndView.addObject("yggh",yggh);
		modelAndView.addObject("condition",condition);
		modelAndView.addObject("type","zl");
		modelAndView.addObject("hj",hj);
		modelAndView.addObject("page",page);
		modelAndView.setViewName("performance/performanceCkmnlr");
		return modelAndView;
	}
	
	//综合户：存量存款模拟利润工资明细
	@RequestMapping(value="/findZhhPerformanceClCkmnlrgzMx.action",method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView findZhhPerformanceClCkmnlrgzMx(
			@RequestParam(value="zzbz") String zzbz,
			@RequestParam(value="tjrq")String tjrq,
		 	@RequestParam(value="yxlx") int yxlx,
			@RequestParam(value="condition",required=false)String condition,PageOption page,
			ModelAndView modelAndView) throws Exception{
		
		String tableName = TableHelper.getTableNameByDate(Constants.table_ckmnlrgzmx,tjrq);
		if(dataInfoService.findWheatherTableExist(tableName) == null){
			modelAndView.addObject("message","你所选择的数据表不存在！");
			modelAndView.setViewName("fail");
			return modelAndView;
		}
		//这里根据组织标志查yggh时,入岗类型写死为4
		String yggh = staffAndPostService.findYgghByZzbz(zzbz,4);
		List<PerformanceCkmnlrgzMx> list = null;
		page.setTotalResult(performanceCkmnlrgzMxService.findClDataCount(yggh, yxlx, tjrq, tjrq, condition));
		PageOption.initPage(page);
		if(yggh != null && !yggh.equals("")){
			list =  performanceCkmnlrgzMxService.findPerformanceClCkmnlrgzMx(yggh,yxlx,tjrq,tjrq,condition,page);
		}
		BigDecimal hj = new BigDecimal(0);
		for(PerformanceCkmnlrgzMx one : list){
			hj = hj.add(one.getClgz());
		}
		modelAndView.addObject("hj",hj);
		modelAndView.addObject("list",list);
		modelAndView.addObject("yggh",yggh);
		modelAndView.addObject("tjrq",tjrq);
		modelAndView.addObject("type","cl");
		modelAndView.addObject("condition",condition);
		modelAndView.addObject("page",page);
		modelAndView.setViewName("performance/performanceCkmnlr");
		return modelAndView;
	}
	//综合户：增量存款模拟利润工资明细
	@RequestMapping(value="findZhhPerformanceZlCkmnlrgzMx.action",method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView findZhhPerformanceZlCkmnlrgzMx(
			@RequestParam(value="zzbz") String zzbz,
			@RequestParam(value="tjrq")String tjrq,
			@RequestParam(value="yxlx") int yxlx,
			@RequestParam(value="condition",required=false) String condition,PageOption page,
			ModelAndView modelAndView) throws Exception{
		String tableName = TableHelper.getTableNameByDate(Constants.table_ckmnlrgzmx,tjrq);
		if(dataInfoService.findWheatherTableExist(tableName) == null){
			modelAndView.addObject("message","你所选择的数据表不存在！");
			modelAndView.setViewName("fail");
			return modelAndView;
		}
		//这里根据组织标志查yggh时,入岗类型写死为4
		String yggh = staffAndPostService.findYgghByZzbz(zzbz,4);
		List<PerformanceCkmnlrgzMx> list = null;
		page.setTotalResult(performanceCkmnlrgzMxService.findZlDataCount(yggh, yxlx, tjrq, tjrq, condition));
		PageOption.initPage(page);
		if(yggh != null && !yggh.equals("")){
			list = performanceCkmnlrgzMxService.findPerformanceZlCkmnlrgzMx(yggh,yxlx,tjrq,tjrq,condition,page);
		}
		BigDecimal hj = new BigDecimal(0);
		for(PerformanceCkmnlrgzMx one : list){
			hj = hj.add(one.getZlgz());
		}
		modelAndView.addObject("type","zl");
		modelAndView.addObject("list",list);
		modelAndView.addObject("yggh",yggh);
		modelAndView.addObject("tjrq",tjrq);
		modelAndView.addObject("hj",hj);
		modelAndView.addObject("condition",condition);
		modelAndView.addObject("page",page);
		modelAndView.setViewName("performance/performanceCkmnlr");
		return modelAndView;
	}
}
