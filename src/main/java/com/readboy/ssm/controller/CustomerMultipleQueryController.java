package com.readboy.ssm.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.readboy.ssm.po.CustomerMultipleQuery;
import com.readboy.ssm.service.CustomerMultipleQueryService;
import com.readboy.ssm.serviceImpl.CustomerMultipleQueryServiceImpl;

@Controller
@RequestMapping("/mobile")
public class CustomerMultipleQueryController {
	
	@Autowired
	CustomerMultipleQueryService customerMultipleQueryService;
	@ResponseBody
	@RequestMapping(value="/mobileGetCustomerInfo.action",method={RequestMethod.POST,RequestMethod.GET})
	public CustomerMultipleQuery findCustomedCustomerInfo(@RequestParam(value="khbh",required=true) String khbh) throws Exception{
		CustomerMultipleQuery c = customerMultipleQueryService.findCustomedCustomerInfo(khbh);
		return customerMultipleQueryService.findCustomedCustomerInfo(khbh);
	}
}
