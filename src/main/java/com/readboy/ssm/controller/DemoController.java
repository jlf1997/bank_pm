package com.readboy.ssm.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(tags="账户信息控制类")
@RequestMapping("/swaggerDemo")
public class DemoController {

	@ApiOperation(value = "获取盈豆数量", notes = "获取盈豆数量", httpMethod = "POST")
	@RequestMapping(value="getBeansNumber", method=RequestMethod.POST)
	public String demo() {
		return "demo";
	}
	
	
}
