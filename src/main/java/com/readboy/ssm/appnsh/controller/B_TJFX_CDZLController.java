package com.readboy.ssm.appnsh.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.readboy.ssm.appjx.jpa.ErpWageYgjxJpa;
import com.readboy.ssm.appjx.service.ErpWageYgjxMxService;
import com.readboy.ssm.appnsh.model.TB_TJFX_CDZL;
import com.readboy.ssm.appnsh.service.TB_TJFX_CDZLService;

@RestController
@RequestMapping("/demo/mobile/test")
public class B_TJFX_CDZLController {

	@Autowired
	private TB_TJFX_CDZLService tB_TJFX_CDZLService;
	@Autowired
	private ErpWageYgjxMxService erpWageYgjxMxService;
	@Autowired
	private ErpWageYgjxJpa erpWageYgjxJpa;
	
	@RequestMapping(value="/getAll.action",method=RequestMethod.GET)
	public List getAll(
			) {
		return erpWageYgjxJpa.findAll();
	}
	
	@RequestMapping(value="/save.action",method=RequestMethod.GET)
	public void save() {
		TB_TJFX_CDZL t = new TB_TJFX_CDZL();
		t.setCkhs(100);
		t.setDkhs(33);
		 tB_TJFX_CDZLService.save(t);
	}
}
