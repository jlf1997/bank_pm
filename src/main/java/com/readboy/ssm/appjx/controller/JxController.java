package com.readboy.ssm.appjx.controller;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.readboy.ssm.appjx.dto.YgjxDto;
import com.readboy.ssm.appjx.dto.YgjxMxDto;
import com.readboy.ssm.appjx.model.ErpWageYgjx;
import com.readboy.ssm.appjx.service.ErpWageYgjxMxService;
import com.readboy.ssm.appjx.service.ErpWageYgjxService;
import com.readboy.ssm.utils.PageModel;
import com.readboy.ssm.utils.TimeUtil;


@RestController
@RequestMapping("/mobile/jx")
public class JxController {

	@Autowired
	private ErpWageYgjxService erpWageYgjxService;
	@Autowired
	private ErpWageYgjxMxService erpWageYgjxMxService;

	/**
	 * 绩效详情
	 * @param yggh 员工工号
	 * @param zblb 指标类别
	 * @param gzrq 工作日期
	 */
	@RequestMapping(value="detail.action",method=RequestMethod.GET)
	public List<YgjxMxDto> findYgyjMx(
			@RequestParam("yggh") String yggh,
			@RequestParam("zblb") Integer zblb,
			@RequestParam("gzrq") Long gzrq
			) {
			return erpWageYgjxMxService.findMx(yggh, new Date(gzrq), zblb);
		
	}
	
	/**
	 * 绩效详情
	 * @param yggh 员工工号
	 * @param zblb 指标类别
	 * @param gzrq 工作日期
	 */
	@RequestMapping(value="detailPage.action",method=RequestMethod.GET)
	public PageModel findYgyjMxPage(
			@RequestParam("yggh") String yggh,
			@RequestParam("zblb") Integer zblb,
			@RequestParam("gzrq") Long gzrq,
			@RequestParam("pageSize") Integer pageSize,
			@RequestParam("pageIndex") Integer pageIndex
			) {
			return erpWageYgjxMxService.findMxPage(pageSize,pageIndex,yggh, new Date(gzrq), zblb);
		
	}
	
	/**
	 * 员工日工资总览
	 * @param yggh
	 * @param gzrq
	 * @return
	 */
	@RequestMapping(value="index.action",method=RequestMethod.GET)
	public YgjxDto findYgjx(
			@RequestParam("yggh") String yggh,
			@RequestParam("gzrq") Long gzrq
			) {
		try {
			YgjxDto dto = new YgjxDto();
			Date d = new Date(gzrq);
			ErpWageYgjx now = erpWageYgjxService.findPerformance(d, yggh);
			BeanUtils.copyProperties(now, dto);
			BigDecimal dygz = erpWageYgjxService.getMonthZj(d, yggh);
			dto.setDygz(dygz);
			if(now!=null) {
				dto.setDrgz(now.getGzhj());
			}else {
				dto.setDrgz(new BigDecimal("0"));
			}
			
			ErpWageYgjx lastDay = erpWageYgjxService.findPerformance(TimeUtil.getDay(d,-1), yggh);
			if(lastDay!=null) {
				dto.setGzzf(dto.getDrgz().subtract(lastDay.getGzhj()));
			}else {
				dto.setGzzf(dto.getDrgz());
			}
			
			return dto;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return null;
	}
}
