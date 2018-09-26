package com.readboy.ssm.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.readboy.ssm.po.PerformanceManageDetail;
import com.readboy.ssm.service.PerformanceManageDetailService;

@Controller
public class PerformanceManageDetailController {
	@Autowired
	private PerformanceManageDetailService performanceManageDetailService;
	
	@ResponseBody
	@RequestMapping(value="/mobile/findPerformanceManageDetail.action",method={RequestMethod.POST,RequestMethod.GET})
	public List<PerformanceManageDetail> findPerformanceManageDetail(
		@RequestParam(value="gyh") String yggh) throws Exception{
		return performanceManageDetailService.findPerformanceManageDetail(yggh);
	}
}
