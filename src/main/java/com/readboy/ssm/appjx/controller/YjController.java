package com.readboy.ssm.appjx.controller;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.readboy.ssm.appjx.dto.YgjxDto;
import com.readboy.ssm.appjx.dto.YgjxMxDto;
import com.readboy.ssm.appjx.service.ErpWageYgjxService;
import com.readboy.ssm.po.Performance;
import com.readboy.ssm.service.PerformanceService;
import com.readboy.ssm.utils.TimeUtil;


@RestController
@RequestMapping("/demo/mobile/yj")
public class YjController {
	
	@Autowired
	private ErpWageYgjxService erpWageYgjxService;
	@Autowired
	private PerformanceService performanceService;

	/**
	 * 
	 * @param yggh 员工工号
	 * @param zblb 指标类别
	 * @param gzrq 工作日期
	 */
	public List<YgjxMxDto> findYgyjMx(
			String yggh,
			Integer zblb,
			Long gzrq
			) {
				return null;
		
	}
	
	@RequestMapping(value="index",method=RequestMethod.GET)
	public YgjxDto findYgjx(
			String yggh,
			Long gzrq
			) {
		try {
			YgjxDto dto = new YgjxDto();
			Date d = new Date(gzrq);
			String ds = "";
//			Performance performance = performanceService.findPerformance(yggh, ds);
			BigDecimal dygz = erpWageYgjxService.getMonthZj(d, yggh);
			dto.setDygz(dygz);
			return dto;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return null;
		
	}
}
