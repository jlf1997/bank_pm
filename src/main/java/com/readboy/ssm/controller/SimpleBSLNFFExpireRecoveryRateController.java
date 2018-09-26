package com.readboy.ssm.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.readboy.ssm.po.SimpleBSLNFFExpireRecoveryRate;
import com.readboy.ssm.service.SimpleBSLNFFExpireRecoveryRateService;

@Controller
@RequestMapping("/mobile")
public class SimpleBSLNFFExpireRecoveryRateController {
	
	@Autowired
	private SimpleBSLNFFExpireRecoveryRateService simpleBSLNFFExpireRecoveryRateService;
	
	//移动端查询存款到期明细
	@ResponseBody
	@RequestMapping(value="/mobileGetSimpleBSLNFFExpireRecoveryRate.action",method={RequestMethod.POST,RequestMethod.GET})
	public List<SimpleBSLNFFExpireRecoveryRate> mobileGetSimpleDepositExpireDetail(
			@RequestParam(value="gyh",required=true) String bsrgh,
			@RequestParam(value="ksrq") String ksrq,
			@RequestParam(value="jsrq") String dqrq)throws Exception{
		
		return simpleBSLNFFExpireRecoveryRateService.findSimpleBSLNFFExpireRecoveryRate(bsrgh, ksrq, dqrq);
	}
}
