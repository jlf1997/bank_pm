package com.readboy.ssm.appjx.controller;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
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
	@RequestMapping(value="detail.action")
	public Map findYgyjMx(
			@RequestParam("yggh") String yggh,
			@RequestParam("zblb") Integer zblb,
			@RequestParam("gzrq") Long gzrq
			) {
			Map map = new HashMap<>();
			BigDecimal zj = erpWageYgjxMxService.getZj(yggh, new Date(gzrq), zblb);
			map.put("zj", zj);
			List list = erpWageYgjxMxService.findMx(yggh, new Date(gzrq), zblb);
			map.put("content", list);
			return map;
		
	}
	
	/**
	 * 绩效详情
	 * @param yggh 员工工号
	 * @param zblb 指标类别
	 * @param gzrq 工作日期
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value="detailPage.action")
	public Map findYgyjMxPage(
			@RequestParam("yggh") String yggh,
			@RequestParam("zblb") Integer zblb,
			@RequestParam("gzrq") Long gzrq,
			@RequestParam("pageSize") Integer pageSize,
			@RequestParam("pageIndex") Integer pageIndex
			) {
			BigDecimal zj = erpWageYgjxMxService.getZj(yggh, new Date(gzrq), zblb);
			PageModel p =  erpWageYgjxMxService.findMxPage(pageSize,pageIndex,yggh, new Date(gzrq), zblb);
			Map map = new HashMap<>();
			map.put("zj", zj);
			map.put("content", p.getContent());
			map.put("totalPages", p.getTotalPages());
			map.put("totalSize", p.getTotalSize());
			return map;
	}
	
	/**
	 * 员工日工资总览
	 * @param yggh
	 * @param gzrq
	 * @return
	 */
	@RequestMapping(value="index.action")
	public YgjxDto findYgjx(
			@RequestParam("yggh") String yggh,
			@RequestParam("gzrq") Long gzrq
			) {
		try {
			YgjxDto dto = new YgjxDto();
			Date d = new Date(gzrq);
			ErpWageYgjx jx = erpWageYgjxService.findPerformance(d, yggh);
			if(jx!=null) {
				BeanUtils.copyProperties(jx, dto);
			}
			
			//当日工资
			BigDecimal drgz = erpWageYgjxService.getGz(d, yggh);
			dto.setDrgz(drgz);
			//上日工资
			Date fdInMonth = TimeUtil.getTheFirstDayOfMonth(d);
			boolean isFirstDay = TimeUtil.isInDay(d, fdInMonth);
			if(isFirstDay) {
				dto.setGzzf(new BigDecimal("0"));
			}else {
				BigDecimal srgz = erpWageYgjxService.getGz(TimeUtil.getDay(d, -1), yggh);
				dto.setGzzf(drgz.subtract(srgz));
			}
			
			
			//当月工资
			BigDecimal dygz = erpWageYgjxService.getGzMonth(d, yggh);
			dto.setDygz(dygz);
			
			
			
			return dto;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return null;
	}
}
