package com.readboy.ssm.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.readboy.ssm.po.SimpleBSOverdueLoanDetail;
import com.readboy.ssm.service.SimpleBSOverdueLoanDetailService;

/*
 * 包收逾期贷款明细
 * */
@Controller
@RequestMapping("/mobile")
public class SimpleBSOverdueLoanDetailController {
	
	@Autowired
	private SimpleBSOverdueLoanDetailService simpleBSOverdueLoanDetailService;
	
	@ResponseBody
	@RequestMapping(value="/mobileGetSimpleBSOverdueLoanDetail.action",method={RequestMethod.POST,RequestMethod.GET})
	public List<SimpleBSOverdueLoanDetail> mobileGetSimpleBSOverdueLoanDetail(
			@RequestParam(value="gyh",required=true) String bsrgh,
			@RequestParam(value="ksrq") String ksrq,
			@RequestParam(value="jsrq") String dqrq)throws Exception{
		
		return simpleBSOverdueLoanDetailService.findSimpleBSOverdueLoanDetail(bsrgh, ksrq, dqrq);
	}
}
