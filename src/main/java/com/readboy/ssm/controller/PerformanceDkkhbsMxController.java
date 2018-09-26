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
import com.readboy.ssm.po.PerformanceDkkhbsMx;
import com.readboy.ssm.service.PerformanceDkkhbsMxService;
/*
 * 绩效_贷款客户包收明细
 * */
@Controller
public class PerformanceDkkhbsMxController {
	
	@Autowired
	private PerformanceDkkhbsMxService performanceDkkhbsMxService;
	
	@ResponseBody
	@RequestMapping(value="/mobile/findPerformanceDkkhbsMx.action",method={RequestMethod.POST,RequestMethod.GET})
	public Map<String,Object>  mobileFindPerformanceDkkhbsMx(
			@RequestParam(value="gyh") String yggh,
			@RequestParam(value="tjrq")String tjrq,
			@RequestParam(value="condition",required=false) String condition,
			 PageOption page) throws Exception{
		//"8即yyyy-mm-,将开始时间替换成当月第一天"
		String ksrq = tjrq.substring(0,8)+"01";
		PageOption.initAppPage(page);
		Integer num = performanceDkkhbsMxService.findDataCount(yggh, ksrq, tjrq, condition);
		List<PerformanceDkkhbsMx> list =  performanceDkkhbsMxService.findPerformanceDkkhbsMx(yggh,ksrq, tjrq,condition,page);
		Map<String,Object> m = new HashMap<String,Object>();
		m.put("num", num);
		m.put("list",list);
		return m;
		
	}
	
	@RequestMapping(value="/findPerformanceDkkhbsMx.action",method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView findPerformanceDkkhbsMx(
			@RequestParam(value="yggh") String yggh,
			@RequestParam(value="tjrq")String tjrq,
			@RequestParam(value="type")String type,
			@RequestParam(value="condition",required=false) String condition,PageOption page,
			ModelAndView modelAndView) throws Exception{
		//"8即yyyy-mm-,将开始时间替换成当月第一天"
		String ksrq = tjrq.substring(0,8)+"01";
		BigDecimal hj = new BigDecimal(0);
		page.setTotalResult(performanceDkkhbsMxService.findDataCount(yggh, ksrq, tjrq, condition));
		PageOption.initPage(page);
		try {
			List<PerformanceDkkhbsMx> list =  performanceDkkhbsMxService.findPerformanceDkkhbsMx(
					yggh,ksrq, tjrq,condition,page);
			for(PerformanceDkkhbsMx one : list){
				if(type == "bs"){
					hj = hj.add(one.getBsgz());
				}else{
					hj = hj.add(one.getEdgz());
				}
			}
			modelAndView.addObject("list",list);
			modelAndView.addObject("condition",condition);
			modelAndView.addObject("yggh",yggh);
			modelAndView.addObject("type",type);
			modelAndView.addObject("hj",hj);
			modelAndView.addObject("tjrq",tjrq);
			modelAndView.addObject("page",page);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		modelAndView.setViewName("performance/performanceDkkhbs");
		return modelAndView;
	}
}
