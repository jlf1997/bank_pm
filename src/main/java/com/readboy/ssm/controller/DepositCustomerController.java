package com.readboy.ssm.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.readboy.ssm.po.DepositAccountFamily;
import com.readboy.ssm.po.DepositAccountPerson;
import com.readboy.ssm.service.DepositAccountFamilyService;
import com.readboy.ssm.service.DepositAccountPersonService;

@Controller
public class DepositCustomerController {
	
	@Autowired
	private DepositAccountFamilyService depositAccountFamilyService;
	
	@Autowired
	private DepositAccountPersonService depositAccountPersonService;
	
//	@ResponseBody
//	@RequestMapping(value="/responseDepositAccountFamilyJson.action",method={RequestMethod.POST,RequestMethod.GET})
//	public List<DepositAccountFamily> responseDepositAccountFamilyJson(String khbh, String jgdm) throws Exception{
//		List<DepositAccountFamily> list = depositAccountFamilyService.findAllDepositAccountFamilyByKhbhAndJgdm(khbh, jgdm);
//		return list;
//	}
//	
//	@ResponseBody
//	@RequestMapping(value="/responseDepositAccountPersonJson.action",method={RequestMethod.POST,RequestMethod.GET})
//	public List<DepositAccountPerson> responseDepositAccountPersonJson(String khbh, String jgdm) throws Exception{
//		List<DepositAccountPerson> list = depositAccountPersonService.findAllDepositAccountPersonByKhbhAndJgdm(khbh, jgdm);
//		return list;
//	}

}
