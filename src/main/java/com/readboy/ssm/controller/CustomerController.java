package com.readboy.ssm.controller;

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

import com.readboy.ssm.po.Customer;
import com.readboy.ssm.po.PageOption;
import com.readboy.ssm.service.CustomerService;

@Controller
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	@ResponseBody
	@RequestMapping(value="/mobile/responseCustomerJson.action",method={RequestMethod.POST,RequestMethod.GET})
	public Map<String,Object> mobileResponseCustomerJson(
	@RequestParam(value="khlx",required=true) String khlx,
	@RequestParam(value="gyh",required=true) String gyh,PageOption page,
	@RequestParam(value="condition",required = false) String condition) throws Exception{	
		PageOption.initAppPage(page);
		List<Customer> list = customerService.findAllCustomerByKhlx(Integer.parseInt(khlx), gyh,condition,page);
		int num = customerService.findDataCountByCond(Integer.parseInt(khlx), gyh, condition);
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("list", list);
		map.put("num", num);
		return map;
	}
	
	@RequestMapping(value="/findCustomer.action",method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView findCustomer(
	@RequestParam(value="khlx",required=true) String khlx,
	@RequestParam(value="yggh",required=true) String yggh,
	@RequestParam(value="condition",required = false) String condition,
	PageOption page,ModelAndView modelAndView) throws Exception{
		
		page.setTotalResult(customerService.findDataCountByCond(Integer.parseInt(khlx), yggh, condition));
		PageOption.initPage(page);
		List<Customer> list = customerService.findAllCustomerByKhlx(Integer.parseInt(khlx), yggh,condition,page);
		modelAndView.addObject("list",list);
		modelAndView.addObject("yggh",yggh);
		modelAndView.addObject("khlx",khlx);
		modelAndView.addObject("condition",condition);
		modelAndView.addObject("page",page);
		modelAndView.setViewName("client/clientList");
		return modelAndView;
	}
}
