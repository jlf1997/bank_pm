package com.readboy.ssm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.readboy.ssm.po.SimpleDepositExpireDetail;
import com.readboy.ssm.service.SimpleDepositExpireDetailService;

@Controller
@RequestMapping("/mobile")
public class SimpleDepositExpireDetailController {
	
	@Autowired
	private SimpleDepositExpireDetailService simpleDepositExpireDetailService;
	
	//移动端查询存款到期明细
	@ResponseBody
	@RequestMapping(value="/mobileGetSimpleDepositExpireDetail.action",method={RequestMethod.POST,RequestMethod.GET})
	public List<SimpleDepositExpireDetail> mobileGetSimpleDepositExpireDetail(
			@RequestParam(value="gyh",required=true) String tzrgh,
			@RequestParam(value="ksrq") String ksrq,
			@RequestParam(value="jsrq") String dqrq)throws Exception{
		List<SimpleDepositExpireDetail> list = simpleDepositExpireDetailService.findDepositExpireDetail(tzrgh, ksrq,dqrq);
		return list;
		
	}
}
