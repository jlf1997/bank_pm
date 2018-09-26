package com.readboy.ssm.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.readboy.ssm.po.Area;
import com.readboy.ssm.po.DataCalendar;
import com.readboy.ssm.po.DataLog;
import com.readboy.ssm.po.PageOption;
import com.readboy.ssm.service.AreaService;
import com.readboy.ssm.service.DataCalendarService;
import com.readboy.ssm.service.DataLogService;

@Controller  
public class DataCalendarController {
	
	@Autowired
	private DataCalendarService dataCalendarService;
	
	@RequestMapping(value = "/dataLog.action", method = {
			RequestMethod.POST, RequestMethod.GET })
	public ModelAndView dataLog(HttpServletRequest request,
			@RequestParam(value = "data_time", required = false) String data_time,
			@RequestParam(value = "data_type", required = false) Integer data_type,
			@RequestParam(value = "data_status", required = false) Integer data_status,
			PageOption page , ModelAndView modelAndView) throws Exception {
		page.setTotalResult(dataCalendarService.pageFindDataCountByCond(data_time, data_type, data_status));
		PageOption.initPage(page);
		List<DataCalendar> list = dataCalendarService.pageFindDataCalendarByCond(data_time, data_type, data_status, page);
		System.out.println(page.getCurrentResult()+" "+page.getShowCount());
		modelAndView.addObject("list",list);
		modelAndView.addObject("page",page);
		modelAndView.addObject("data_time",data_time);
		modelAndView.addObject("data_status",data_status);
		modelAndView.setViewName("dataLog");
		return modelAndView;
	}
	
}
