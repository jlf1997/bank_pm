package com.readboy.ssm.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.readboy.ssm.po.CellBankCustomerPerson;
import com.readboy.ssm.po.CellBankCustomerProduct;
import com.readboy.ssm.po.Customer;
import com.readboy.ssm.po.DepositAccountFamily;
import com.readboy.ssm.po.DepositAccountPerson;
import com.readboy.ssm.po.EtcCustomerFamily;
import com.readboy.ssm.po.RelatedPerson;
import com.readboy.ssm.service.CellBankCustomerPersonService;
import com.readboy.ssm.service.CellBankCustomerProductService;
import com.readboy.ssm.service.CustomerService;
import com.readboy.ssm.service.DepositAccountFamilyService;
import com.readboy.ssm.service.DepositAccountPersonService;
import com.readboy.ssm.service.EtcCustomerFamilyService;
import com.readboy.ssm.service.RelatedPersonService;

@Controller
public class TestController {
	
	@Autowired
	private RelatedPersonService relatedPersonService;
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private DepositAccountFamilyService depositAccountFamilyService;
	
	@Autowired
	private DepositAccountPersonService depositAccountPersonService;
	
	@Autowired
	private CellBankCustomerProductService cellBankCustomerProductService;
	
	@Autowired
	private CellBankCustomerPersonService cellBankCustomerPersonService;
	
	@Autowired
	private EtcCustomerFamilyService etcCustomerFamilyService;
	
	@ResponseBody
	@RequestMapping(value="/responseRelatedPersonJson.action",method={RequestMethod.POST,RequestMethod.GET})
	public List<RelatedPerson> responseRelatedPersonJson(String khbh, String jgdm) throws Exception{
		List<RelatedPerson> list = relatedPersonService.findRelatedPersonByKhbhAndJgdm(khbh, jgdm);
		return list;
	}
	
	@ResponseBody
	@RequestMapping(value="/responseCustomerJsonTest.action",method={RequestMethod.POST,RequestMethod.GET})
	public Customer responseCustomerJson(String khbh, String ghrgh,String condition) throws Exception{
		Customer customer = customerService.findCustomerByKhbhAndGhrgh(khbh, ghrgh,condition);
		return customer;
	}
	
	@ResponseBody
	@RequestMapping(value="/responseDepositAccountFamilyJson.action",method={RequestMethod.POST,RequestMethod.GET})
	public List<DepositAccountFamily> responseDepositAccountFamilyJson(String khbh, String jgdm) throws Exception{
		List<DepositAccountFamily> list = depositAccountFamilyService.findAllDepositAccountFamilyByKhbhAndJgdm(khbh, jgdm);
		return list;
	}
	
	@ResponseBody
	@RequestMapping(value="/responseDepositAccountPersonJson.action",method={RequestMethod.POST,RequestMethod.GET})
	public List<DepositAccountPerson> responseDepositAccountPersonJson(String khbh, String jgdm) throws Exception{
		List<DepositAccountPerson> list = depositAccountPersonService.findAllDepositAccountPersonByKhbhAndJgdm(khbh, jgdm);
		return list;
	}
	
	@ResponseBody
	@RequestMapping(value="/responseDepositAccountPersonJson2.action",method={RequestMethod.POST,RequestMethod.GET})
	public List<DepositAccountPerson> responseDepositAccountPersonJson2(String khbh) throws Exception{
		List<DepositAccountPerson> list = depositAccountPersonService.findAllDepositAccountPersonByKhbh(khbh);
		return list;
	}
	
	@ResponseBody
	@RequestMapping(value="/responseCellProduct.action",method={RequestMethod.POST,RequestMethod.GET})
	public List<CellBankCustomerProduct> responseCellProduct(String khbh, String jgdm) throws Exception{
		List<CellBankCustomerProduct> list = cellBankCustomerProductService.findCellBankProductsByKhbhAndJgdm(khbh, jgdm);
		return list;
	}
	
	@ResponseBody
	@RequestMapping(value="/responseCellPerson.action",method={RequestMethod.POST,RequestMethod.GET})
	public List<CellBankCustomerPerson> responseCellPerson(String khbh, String jgdm) throws Exception{
		List<CellBankCustomerPerson> list = cellBankCustomerPersonService.findCellBankPersonsByKhbhAndJgdm(khbh, jgdm);
		return list;
	}
	
	@ResponseBody
	@RequestMapping(value="/responseEtc.action",method={RequestMethod.POST,RequestMethod.GET})
	public List<EtcCustomerFamily> responseEtc(String khbh, String jgdm) throws Exception{
		List<EtcCustomerFamily> list = etcCustomerFamilyService.findEtcCustomerFamilysByKhbhAndJgdm(khbh, jgdm);
		return list;
	}
}
