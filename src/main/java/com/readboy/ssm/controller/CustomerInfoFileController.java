package com.readboy.ssm.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.readboy.ssm.po.Customer;
import com.readboy.ssm.po.CustomerInfoFile;
import com.readboy.ssm.service.CustomerInfoFileService;
import com.readboy.ssm.service.CustomerService;

@Controller
public class CustomerInfoFileController {
	
	@Autowired
	private CustomerInfoFileService customerInfoFileService;
	
	@RequestMapping(value="/findDistinctCustomer.action",method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView mobileResponseCustomerJson(
	@RequestParam(value="ghrgh",required=true) String ghrgh,
	@RequestParam(value="condition",required = false) String condition,
	ModelAndView modelAndView) throws Exception{
		List <CustomerInfoFile> list = customerInfoFileService.findDistinctCustomer(ghrgh, condition);
		modelAndView.addObject("list",list);
		modelAndView.addObject("ghrgh",ghrgh);
		modelAndView.addObject("condition",condition);
		modelAndView.setViewName("client/customerWithFileList");
		return modelAndView;
	}
	
	@RequestMapping(value="/findCustomerPicAndVedio.action",method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView findCustomerPicAndVedio(
	@RequestParam(value="ghrgh",required=true) String ghrgh,
	@RequestParam(value="khbh",required = true) String khbh,
	ModelAndView modelAndView) throws Exception{
		List <CustomerInfoFile> list = customerInfoFileService.findCustomerPicAndVedio(khbh, ghrgh);
		modelAndView.addObject("list",list);
		modelAndView.setViewName("client/customerPicAndVedio");
		return modelAndView;
	}
	
	@RequestMapping(value="/findOneCustomerPicAndVedio.action",method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView findOneCustomerPicAndVedio(
	@RequestParam(value="ghrgh",required=true) String ghrgh,
	@RequestParam(value="khbh",required = true) String khbh,
	@RequestParam(value="file_name",required = true) String file_name,
	@RequestParam(value="file_type",required = true) String file_type,
	ModelAndView modelAndView) throws Exception{
		CustomerInfoFile one = customerInfoFileService.findOneCustomerPicAndVedio(khbh, ghrgh, file_name, file_type);
		modelAndView.addObject("one",one);
		modelAndView.setViewName("client/customerResDetail");
		return modelAndView;
	}
	
	@RequestMapping(value="/showOnePicAndVideo.action",method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView showOnePicAndVideo(HttpServletResponse response,
	ModelAndView modelAndView) throws Exception{
		  FileInputStream fis = null;  
	      OutputStream os = null;  
	      try {
	    	  fis = new FileInputStream("/home/hadoop/2015.jpg");  
	          os = response.getOutputStream();  
	          int count = 0;  
	          byte[] buffer = new byte[1024 * 8];  
	          while ((count = fis.read(buffer)) != -1) {  
	              os.write(buffer, 0, count);  
	              os.flush();  
	          }  
	     }catch (Exception e) {  
	          e.printStackTrace();  
	     }  
	     try {  
	         fis.close();  
	         os.close();  
	     } catch (IOException e) {  
	         e.printStackTrace();  
	     }  
		//modelAndView.addObject("one",one);
		modelAndView.setViewName("client/customerResDetail");
		return modelAndView;
	}
	
}
