package com.readboy.ssm.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.readboy.ssm.po.SimpleCustomerInfo;
import com.readboy.ssm.service.SimpleCustomerInfoService;

@Controller
@RequestMapping("/mobile")
public class SimpleCustomerInfoController {
	@Autowired
	private SimpleCustomerInfoService simpleCustomerInfoService;
	@ResponseBody
	@RequestMapping(value="/mobileGetSimpleCustomerInfo.action",method={RequestMethod.POST,RequestMethod.GET}) 
	public SimpleCustomerInfo mobileGetSimpleCustomerInfo(@RequestParam(value="khbh",required=true) String khbh)throws Exception{
		SimpleCustomerInfo sci = new SimpleCustomerInfo();
		sci = simpleCustomerInfoService.findSimpleCustomerInfo(khbh);
		List<String> strList = new ArrayList<String>();
		if(simpleCustomerInfoService.findDepositNote(khbh) > 0){
			strList.add("存款");
		}
		if(simpleCustomerInfoService.findLoanNote(khbh) > 0){
			strList.add("贷款");
		}
		if(simpleCustomerInfoService.findCellBankNote(khbh) > 0){
			strList.add("手机银行");
		}
		if(simpleCustomerInfoService.findEtcNote(khbh) > 0){
			strList.add("ETC");
		}
		sci.setCpxx(strList);
		return sci;
		
	}
}
