package com.readboy.ssm.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloWorldController {

	private static Logger logger = LoggerFactory.getLogger(HelloWorldController.class);

	@RequestMapping("/hello.do")
	public String hello(Model model) {
		model.addAttribute("greeting", "Hello Spring MVC");
		model.addAttribute("message", "test next jsp");
		return "apkmanager/helloworld";
	}

	@RequestMapping("/mysql.do")
	public String test(Model model) {
		model.addAttribute("greeting", "3444");
		model.addAttribute("message", "2");
		return "apkmanager/showMessage";
	}

	// 请求上传apk页面
	@RequestMapping("/testlogin.do")
	public String test2(Model model) {
		model.addAttribute("greeting", "3444");
		model.addAttribute("message", "2");
		logger.info ("testlogin");
		logger.debug("sdfsdfsd");
	
		
		return "apkmanager/helloworld";
	}

}
