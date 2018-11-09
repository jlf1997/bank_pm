package com.readboy.ssm.appjx.controller;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/demo/mobile/yj")
public class YjController {
	
	/**
	 * 机构业绩
	 * @param yggh 员工工号
	 * @param zblb 指标类别
	 * @param gzrq 工作日期
	 */
	@RequestMapping(value="jgyjPage.action",method=RequestMethod.GET)
	public PageModel findYgyjMxPage(
			@RequestParam("yggh") String yggh,
			@RequestParam("zblb") Integer zblb,
			@RequestParam("gzrq") Long gzrq,
			@RequestParam("pageSize") Integer pageSize,
			@RequestParam("pageIndex") Integer pageIndex
			) {
			return erpWageYgjxMxService.findMxPage(pageSize,pageIndex,yggh, new Date(gzrq), zblb);
		
	}
	
	
}
