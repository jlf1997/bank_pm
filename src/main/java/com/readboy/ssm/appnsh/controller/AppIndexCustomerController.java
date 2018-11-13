package com.readboy.ssm.appnsh.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.readboy.ssm.appnsh.dto.CDZLDto;
import com.readboy.ssm.appnsh.dto.CustomMobleIndexDto;
import com.readboy.ssm.appnsh.dto.CustomerTj;
import com.readboy.ssm.appnsh.dto.TB_TJFX_BLDKKHDto;
import com.readboy.ssm.appnsh.dto.TB_TJFX_CDKPMDto;
import com.readboy.ssm.appnsh.dto.TB_TJFX_CKDKHDto;
import com.readboy.ssm.appnsh.dto.TB_TJFX_CKDQKHDto;
import com.readboy.ssm.appnsh.dto.TB_TJFX_DKDKHDto;
import com.readboy.ssm.appnsh.dto.TB_TJFX_DKDQKHDto;
import com.readboy.ssm.appnsh.dto.TB_TJFX_YQDKKHDto;
import com.readboy.ssm.appnsh.model.TB_TJFX_CDZL;
import com.readboy.ssm.appnsh.service.AppIndexCustomerService;
import com.readboy.ssm.appnsh.service.TB_TJFX_BLDKKHService;
import com.readboy.ssm.appnsh.service.TB_TJFX_CDZLService;
import com.readboy.ssm.appnsh.service.TB_TJFX_CKDKHService;
import com.readboy.ssm.appnsh.service.TB_TJFX_CKDQKHService;
import com.readboy.ssm.appnsh.service.TB_TJFX_DKDKHService;
import com.readboy.ssm.appnsh.service.TB_TJFX_DKDQKHService;
import com.readboy.ssm.appnsh.service.TB_TJFX_YQDKKHService;

@RestController
@RequestMapping("/mobile/customer")
public class AppIndexCustomerController {

	@Autowired
	private AppIndexCustomerService customerService;
	@Autowired
	private TB_TJFX_CDZLService tB_TJFX_CDZLService;
	@Autowired
	private TB_TJFX_BLDKKHService tB_TJFX_BLDKKHService;
	@Autowired
	private TB_TJFX_CKDKHService tB_TJFX_CKDKHService;
	@Autowired
	private TB_TJFX_CKDQKHService tB_TJFX_CKDQKHService;
	@Autowired
	private TB_TJFX_DKDKHService tB_TJFX_DKDKHService;
	@Autowired
	private TB_TJFX_DKDQKHService tB_TJFX_DKDQKHService;
	@Autowired
	private TB_TJFX_YQDKKHService tB_TJFX_YQDKKHService;
	
	@RequestMapping(value="/index/getInfo.action")
	public CustomMobleIndexDto getAll(
			@RequestParam("yggh") String yggh) {
		//存贷总览
		TB_TJFX_CDZL t = new TB_TJFX_CDZL();
		t.setYggh(yggh);
		CustomMobleIndexDto res = new CustomMobleIndexDto();
		//存贷总览
		List<TB_TJFX_CDZL>  cdzlList = tB_TJFX_CDZLService.findAll(t);
		if(cdzlList!=null && cdzlList.size()==1) {
			CDZLDto dto = new CDZLDto();
			BeanUtils.copyProperties(tB_TJFX_CDZLService.findAll(t).get(0), dto);
			res.setCdzl(dto);
		}
		//个人客户
		CustomerTj grkh = new CustomerTj();
		grkh.setBldkdkh(tB_TJFX_BLDKKHService.getCount(yggh, 1));
		grkh.setCkdkh(tB_TJFX_CKDKHService.getCount(yggh, 1));
		grkh.setCkdq(tB_TJFX_CKDQKHService.getCount(yggh, 1));
		grkh.setDkdkh(tB_TJFX_DKDKHService.getCount(yggh, 1));
		grkh.setDkdq(tB_TJFX_DKDQKHService.getCount(yggh, 1));
		grkh.setQydkdkh(tB_TJFX_YQDKKHService.getCount(yggh, 1));
		res.setGrkh(grkh);
		//企业客户
		CustomerTj qykh = new CustomerTj();
		qykh.setBldkdkh(tB_TJFX_BLDKKHService.getCount(yggh, 2));
		qykh.setCkdkh(tB_TJFX_CKDKHService.getCount(yggh, 2));
		qykh.setCkdq(tB_TJFX_CKDQKHService.getCount(yggh, 2));
		qykh.setDkdkh(tB_TJFX_DKDKHService.getCount(yggh, 2));
		qykh.setDkdq(tB_TJFX_DKDQKHService.getCount(yggh, 2));
		qykh.setQydkdkh(tB_TJFX_YQDKKHService.getCount(yggh, 2));
		res.setQykh(qykh);
		
		//top10
		res.setCkpm(TB_TJFX_CDKPMDto.copy(customerService.getcdTop10(1, yggh)));//存款
		res.setDkpm(TB_TJFX_CDKPMDto.copy(customerService.getcdTop10(2, yggh)));//贷款
		
		return res;
	}
	
	/**
	 * 
	 * @return
	 */
	@RequestMapping(value="/index/detaiBLDK.action")
	public List<TB_TJFX_BLDKKHDto> getBLDKDetai(
			String yggh,
			Integer khlx
			) {
		return tB_TJFX_BLDKKHService.getTB_TJFX_BLDKKHByYgghAndKHLX(yggh, khlx);
	}
	
	@RequestMapping(value="/index/detaiCKDKH.action")
	public List<TB_TJFX_CKDKHDto> getCKDKHDetai(
			String yggh,
			Integer khlx
			) {
		return tB_TJFX_CKDKHService.getTB_TJFX_BLDKKHByYgghAndKHLX(yggh, khlx);
	}
	
	@RequestMapping(value="/index/detaiCKDQKH.action")
	public List<TB_TJFX_CKDQKHDto> getCKDQKHDetai(
			String yggh,
			Integer khlx
			) {
		return tB_TJFX_CKDQKHService.getTB_TJFX_BLDKKHByYgghAndKHLX(yggh, khlx);
	}
	
	@RequestMapping(value="/index/detaiDKDKH.action")
	public List<TB_TJFX_DKDKHDto> getDKDKHDetai(
			String yggh,
			Integer khlx
			) {
		return tB_TJFX_DKDKHService.getTB_TJFX_BLDKKHByYgghAndKHLX(yggh, khlx);
	}
	
	@RequestMapping(value="/index/detaiDKDQKH.action")
	public List<TB_TJFX_DKDQKHDto> getDKDQKHDetai(
			String yggh,
			Integer khlx
			) {
		return tB_TJFX_DKDQKHService.getTB_TJFX_BLDKKHByYgghAndKHLX(yggh, khlx);
	}
	
	@RequestMapping(value="/index/detaiYQDKKH.action")
	public List<TB_TJFX_YQDKKHDto> getYQDKKHDetai(
			String yggh,
			Integer khlx
			) {
		return tB_TJFX_YQDKKHService.getTB_TJFX_BLDKKHByYgghAndKHLX(yggh, khlx);
	}
	
}
