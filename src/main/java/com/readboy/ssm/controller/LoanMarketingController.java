package com.readboy.ssm.controller;

import com.readboy.ssm.po.LoanMarketing;
import com.readboy.ssm.po.LoanMarketing;
import com.readboy.ssm.service.LoanMarketingService;
import com.readboy.ssm.service.LoanMarketingService;
import java.util.*;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoanMarketingController
{

	@Autowired
	private LoanMarketingService loanMarketingService;
	
	//-------------响应手机端请求-------------------
	@ResponseBody
	//返回所有的贷款营销登记记录
	@RequestMapping("/mobile/responseLoanMarketingJson.action")
	public List<LoanMarketing> responseLoanMarketingJson() throws Exception{
		List<LoanMarketing> list = loanMarketingService.findAllLoanMarketing();
		return list;
	}
	
	//插入一条贷款营销登记记录
	@ResponseBody
	@RequestMapping(value="/mobile/mobileInsertLoanMarketing.action",method={RequestMethod.POST,RequestMethod.GET})
	public String mobileInsertLoanMarketing(LoanMarketing loanMarketing) throws Exception{
		int yybh = loanMarketingService.insertLoanMarketing(loanMarketing);
		if(yybh > 0){
			//插入成功
			return "success";
		}else{
			return "fail";
		}
	}
	//更新贷款营销登记记录
	@ResponseBody
	@RequestMapping(value="/mobile/mobileUpdateLoanMarketing.action",method={RequestMethod.POST,RequestMethod.GET})
	public String mobileUpdateLoanMarketing(LoanMarketing loanMarketing) throws Exception{
		loanMarketingService.updateLoanMarketing(loanMarketing);
		return "success";
	}
	//根据预约编号删除一条贷款营销登记记录
	@ResponseBody
	@RequestMapping(value="/mobile/mobileDeleteOneLoanMarketingByYybh.action",method={RequestMethod.POST,RequestMethod.GET})
	public String mobileDeleteOneLoanMarketingByYybh(@RequestParam(value="yybh",required=true) Integer yybh) throws Exception{
		loanMarketingService.deleteOneLoanMarketingByYybh(yybh);
		return "success";
	}
	
	//-------------PC端请求响应------------
	//根据预约编号查询一条贷款营销记录
	@RequestMapping(value="/queryOneLoaneMarketingByYybh.action",method={RequestMethod.POST,RequestMethod.GET})
	public String queryOneLoaneMarketingByYybh(Model model,@RequestParam(value="yybh",required=true) Integer yybh) throws Exception{
		LoanMarketing loanMarketing = loanMarketingService.findLoanMarketingByYybh(yybh);
		model.addAttribute("loanMarketing",loanMarketing);
		return "marketing/loanMarketing";
	}
	
	@RequestMapping("/queryLoanMarketing.action")
	public ModelAndView queryLoanMarketing() throws Exception{
		ModelAndView modelAndView = new ModelAndView();
		List<LoanMarketing> list = loanMarketingService.findAllLoanMarketing();
		modelAndView.addObject("loanMarketingList",list);
		modelAndView.setViewName("marketing/loanMarketingList");
		return modelAndView;
	}
	
	//更新贷款营销登记记录
	@RequestMapping(value="/updateLoanMarketing.action",method={RequestMethod.POST,RequestMethod.GET})
	public String updateLoanMarketing(LoanMarketing loanMarketing) throws Exception{
		loanMarketingService.updateLoanMarketing(loanMarketing);
		return "forward:queryLoanMarketing.action";
	}
	
	//插入一条贷款营销登记记录
	@RequestMapping(value="/insertLoanMarketing.action",method={RequestMethod.POST,RequestMethod.GET})
	public String insertLoanMarketing(HttpServletRequest r,LoanMarketing loanMarketing) throws Exception{
		int yybh = loanMarketingService.insertLoanMarketing(loanMarketing);
		if(yybh > 0){
			//插入成功
			return "forward:queryLoanMarketing.action";
		}else{
			return "fail";
		}
	}
	
	//根据预约编号删除一条贷款营销登记记录
	@RequestMapping(value="/deleteOneLoanMarketingByYybh.action",method={RequestMethod.POST,RequestMethod.GET})
	public String deleteOneLoanMarketingByYybh(@RequestParam(value="yybh",required=true) Integer yybh) throws Exception{
		loanMarketingService.deleteOneLoanMarketingByYybh(yybh);
		return "forward:queryLoanMarketing.action";
	}
	
}
