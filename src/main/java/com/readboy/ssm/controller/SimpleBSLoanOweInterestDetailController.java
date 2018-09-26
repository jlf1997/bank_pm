package com.readboy.ssm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.readboy.ssm.po.SimpleBSLoanOweInterestDetail;
import com.readboy.ssm.service.SimpleBSLoanOweInterestDetailService;

@Controller
@RequestMapping("/mobile")
public class SimpleBSLoanOweInterestDetailController {
	
	@Autowired
	private SimpleBSLoanOweInterestDetailService simpleBSLoanOweInterestDetailService;
	
	//移动端查询存款到期明细
	@ResponseBody
	@RequestMapping(value="/mobileGetSimpleBSLoanOweInterestDetail.action",method={RequestMethod.POST,RequestMethod.GET})
	public List<SimpleBSLoanOweInterestDetail> mobileGetSimpleBSLoanOweInterestDetail(
			@RequestParam(value="gyh",required=true) String bsrgh,	//gyh就是柜员号，和bsrgh一个意思
			@RequestParam(value="ksrq") String ksrq,
			@RequestParam(value="jsrq") String jsrq)throws Exception{
		
		List<SimpleBSLoanOweInterestDetail> list = simpleBSLoanOweInterestDetailService.findSimpleBSLoanOweInterestDetail(bsrgh, ksrq,jsrq);
		return list;
		
	}
}
