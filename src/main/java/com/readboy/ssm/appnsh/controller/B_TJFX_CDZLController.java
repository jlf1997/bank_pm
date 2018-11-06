package com.readboy.ssm.appnsh.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.readboy.ssm.appnsh.model.TB_TJFX_CDZL;
import com.readboy.ssm.appnsh.service.TB_TJFX_CDZLService;

@RestController
@RequestMapping("/demo/mobile/customer")
public class B_TJFX_CDZLController {

	@Autowired
	private TB_TJFX_CDZLService tB_TJFX_CDZLService;
	
	@RequestMapping(value="/getAll.action",method=RequestMethod.GET)
	public List getAll(
			@RequestParam("yggh") String yggh) {
		TB_TJFX_CDZL t = new TB_TJFX_CDZL();
		t.setYggh(yggh);
		return tB_TJFX_CDZLService.findAll(t);
	}
	
	@RequestMapping(value="/save.action",method=RequestMethod.GET)
	public void save() {
		TB_TJFX_CDZL t = new TB_TJFX_CDZL();
		t.setCkhs(100);
		t.setDkhs(33);
		 tB_TJFX_CDZLService.save(t);
	}
}