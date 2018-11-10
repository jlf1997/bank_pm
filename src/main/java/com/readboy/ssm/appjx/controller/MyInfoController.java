package com.readboy.ssm.appjx.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.readboy.ssm.appjx.dto.MyInfo;
import com.readboy.ssm.po.StaffAndPost;
import com.readboy.ssm.service.StaffAndPostService;

@RestController
@RequestMapping("/mobile/myInfo")
public class MyInfoController {

	@Autowired
	public StaffAndPostService staffAndPostService;
	
	
	/**
	 * 我的 页面信息
	 * @param yggh
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/info.action",method=RequestMethod.GET)
	public Map<String,Object> findYgyjMxDayPage(
			@RequestParam("yggh") String yggh
			) throws Exception {
		Map<String,Object> map = new HashMap<>();
		map.put("history", staffAndPostService.findStaffAndPostsByYggh(yggh));
		MyInfo sf = staffAndPostService.findStaffAndPostsByYgghNow(yggh);
		map.put("info", sf);
		return map;
		
	}
}
