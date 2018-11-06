package com.readboy.ssm.appnsh.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.readboy.ssm.appnsh.dto.CustomMobleIndexDto;
import com.readboy.ssm.appnsh.dto.CustomerTj;
import com.readboy.ssm.appnsh.model.TB_TJFX_BLDKKH;
import com.readboy.ssm.appnsh.model.TB_TJFX_CDZL;
import com.readboy.ssm.appnsh.service.AppIndexCustomerService;
import com.readboy.ssm.appnsh.service.TB_TJFX_BLDKKHService;
import com.readboy.ssm.appnsh.service.TB_TJFX_CDZLService;

@RestController
@RequestMapping("/demo/mobile/customer")
public class AppIndexCustomerController {

	@Autowired
	private AppIndexCustomerService customerService;
	@Autowired
	private TB_TJFX_CDZLService tB_TJFX_CDZLService;
	@Autowired
	private TB_TJFX_BLDKKHService tB_TJFX_BLDKKHService;
	
	@RequestMapping(value="/index/getInfo.action",method=RequestMethod.GET)
	public CustomMobleIndexDto getAll(
			@RequestParam("yggh") String yggh) {
		//存贷总览
		TB_TJFX_CDZL t = new TB_TJFX_CDZL();
		t.setYggh(yggh);
		CustomMobleIndexDto res = new CustomMobleIndexDto();
		List<TB_TJFX_CDZL>  cdzlList = tB_TJFX_CDZLService.findAll(t);
		if(cdzlList!=null && cdzlList.size()==1) {
			res.setCdzl(tB_TJFX_CDZLService.findAll(t).get(0));
		}
		//
		TB_TJFX_BLDKKH bldkkh = new TB_TJFX_BLDKKH();
		bldkkh.setYggh(yggh);
		tB_TJFX_BLDKKHService.findAll(bldkkh);
		CustomerTj grkh = new CustomerTj();
		grkh.setBldkdkh(tB_TJFX_BLDKKHService.getCount(yggh, 1));
		res.setGrkh(grkh);
		
		
		return res;
	}
	
	
}
