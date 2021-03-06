package com.readboy.ssm.appnsh.controller;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
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
import com.readboy.ssm.appnsh.model.TB_TJFX_CDZL_N;
import com.readboy.ssm.appnsh.service.AppIndexCustomerService;
import com.readboy.ssm.appnsh.service.TB_TJFX_BLDKKHService;
import com.readboy.ssm.appnsh.service.TB_TJFX_CDZLService;
import com.readboy.ssm.appnsh.service.TB_TJFX_CDZL_NService;
import com.readboy.ssm.appnsh.service.TB_TJFX_CKDKHService;
import com.readboy.ssm.appnsh.service.TB_TJFX_CKDQKHService;
import com.readboy.ssm.appnsh.service.TB_TJFX_DKDKHService;
import com.readboy.ssm.appnsh.service.TB_TJFX_DKDQKHService;
import com.readboy.ssm.appnsh.service.TB_TJFX_YQDKKHService;
import com.readboy.ssm.timetask.OnApplicationStarted;

@RestController
@RequestMapping("/mobile/customer")
public class AppIndexCustomerController {

	@Autowired
	private AppIndexCustomerService customerService;
	@Autowired
	private TB_TJFX_CDZL_NService tB_TJFX_CDZL_NService;
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
		
		CustomMobleIndexDto res = new CustomMobleIndexDto();
		//存贷总览
		CDZLDto dto = new CDZLDto();
		List<TB_TJFX_CDZL_N> list = tB_TJFX_CDZL_NService.findByYggh(yggh);
		if(list!=null && list.size()>0 && list.get(0)!=null) {
			BeanUtils.copyProperties(list.get(0), dto);
		}
		res.setCdzl(dto);
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
	@RequestMapping(value="/index/detaiBLDKDKH.action")
	public List<TB_TJFX_BLDKKHDto> getBLDKDetai(
			String yggh,
			Integer khlx
			) {
		return tB_TJFX_BLDKKHService.getTB_TJFX_BLDKKHByYgghAndKHLX(yggh, khlx);
	}
	
	@RequestMapping(value="/index/detaiBLDKDKHPage.action")
	public Map getBLDKDetaiPage(
			String yggh,
			Integer khlx,
			Integer pageSize,
			Integer pageIndex
			) {
		return tB_TJFX_BLDKKHService.getPages(yggh, khlx,pageSize,pageIndex);
	}
	
	@RequestMapping(value="/index/detaiCKDKH.action")
	public List<TB_TJFX_CKDKHDto> getCKDKHDetai(
			String yggh,
			Integer khlx
			) {
		return tB_TJFX_CKDKHService.getTB_TJFX_BLDKKHByYgghAndKHLX(yggh, khlx);
	}
	
	@RequestMapping(value="/index/detaiCKDKHPage.action")
	public Map getCKDKHDetaiPage(
			String yggh,
			Integer khlx,
			Integer pageSize,
			Integer pageIndex
			) {
		return tB_TJFX_CKDKHService.getPages(yggh, khlx,pageSize,pageIndex);
	}
	
	@RequestMapping(value="/index/detaiCKDQKH.action")
	public List<TB_TJFX_CKDQKHDto> getCKDQKHDetai(
			String yggh,
			Integer khlx
			) {
		return tB_TJFX_CKDQKHService.getTB_TJFX_BLDKKHByYgghAndKHLX(yggh, khlx);
	}
	
	@RequestMapping(value="/index/detaiCKDQKHPage.action")
	public Map getCKDQKHDetaiPage(
			String yggh,
			Integer khlx,
			Integer pageSize,
			Integer pageIndex
			) {
		return tB_TJFX_CKDQKHService.getPages(yggh, khlx,pageSize,pageIndex);
	}
	
	@RequestMapping(value="/index/detaiDKDKH.action")
	public List<TB_TJFX_DKDKHDto> getDKDKHDetai(
			String yggh,
			Integer khlx
			) {
		return tB_TJFX_DKDKHService.getTB_TJFX_BLDKKHByYgghAndKHLX(yggh, khlx);
	}
	
	@RequestMapping(value="/index/detaiDKDKHPage.action")
	public Map getDKDKHDetaiPage(
			String yggh,
			Integer khlx,
			Integer pageSize,
			Integer pageIndex
			) {
		return tB_TJFX_DKDKHService.getPages(yggh, khlx,pageSize,pageIndex);
	}
	
	@RequestMapping(value="/index/detaiDKDQKH.action")
	public List<TB_TJFX_DKDQKHDto> getDKDQKHDetai(
			String yggh,
			Integer khlx
			) {
		return tB_TJFX_DKDQKHService.getTB_TJFX_BLDKKHByYgghAndKHLX(yggh, khlx);
	}
	
	@RequestMapping(value="/index/detaiDKDQKHPage.action")
	public Map getDKDQKHDetaiPage(
			String yggh,
			Integer khlx,
			Integer pageSize,
			Integer pageIndex
			) {
		return tB_TJFX_DKDQKHService.getPages(yggh, khlx,pageSize,pageIndex);
	}
	
	@RequestMapping(value="/index/detaiYQDKDKH.action")
	public List<TB_TJFX_YQDKKHDto> getYQDKKHDetai(
			String yggh,
			Integer khlx
			) {
		return tB_TJFX_YQDKKHService.getTB_TJFX_BLDKKHByYgghAndKHLX(yggh, khlx);
	}
	
	@RequestMapping(value="/index/detaiYQDKDKHPage.action")
	public Map getYQDKKHDetaiPage(
			String yggh,
			Integer khlx,
			Integer pageSize,
			Integer pageIndex
			) {
		return tB_TJFX_YQDKKHService.getPages(yggh, khlx,pageSize,pageIndex);
	}
	
	@Autowired
	private OnApplicationStarted onApplicationStarted;
	
	@RequestMapping(value="/index/test.action")
	public void test(
			
			) {
		File f1 = new File("C:\\Users\\Administrator\\Desktop\\KHGXGL_CKKHYXDJB.txt");
		File f2 = new File("C:\\Users\\Administrator\\Desktop\\KHGXGL_SJYHYXDJB.txt");
		File[] files = new File[] {f1,f2};
		onApplicationStarted.dataImort("20181121",files);
	}
	
}
