package com.readboy.ssm.controller;

import java.io.File;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;
import com.readboy.ssm.po.CustomerInfoFile;
import com.readboy.ssm.po.Res;
import com.readboy.ssm.service.CustomerInfoFileService;
import com.readboy.ssm.service.ResService;

@Controller 
//@RequestMapping("apk") 
@RequestMapping("/mobile")
public class UploadCustomerFileController {

	@Autowired
	private CustomerInfoFileService customerInfoFileService;
	@Autowired
	private ResService resService;
	@RequestMapping(value = "UploadCustomerInfoFile.action", method={RequestMethod.POST,RequestMethod.GET})  
	public ModelAndView fileUpload(
			@RequestParam("khbh") String khbh,
			@RequestParam("ghrgh") String ghrgh,
			@RequestParam("khmc") String khmc,
			@RequestParam("type") String type,
			@RequestParam("time") String time,
			@RequestParam("address") String address,
			@RequestParam("fileupload") CommonsMultipartFile file, HttpServletRequest request) throws Exception {  
		
		System.out.println(khbh + "/" + ghrgh  + "/" + type  + "/" + file.toString());
		String err="";
		String msg="";
		String path = null;
		if (!file.isEmpty()) {
			Res res = resService.findRes();
			if(res != null){
				path=res.getPath();
			}
			path = path + "\\" + ghrgh + "\\" + khbh + "\\" + type;
			String file_name = file.getOriginalFilename();
			String fileName = path+"\\"+ file_name;  
			File localFile = new File(fileName);  
			try {  
				if (!localFile.getParentFile().exists()){
					localFile.getParentFile().mkdirs();
				}
				file.transferTo(localFile);  

				CustomerInfoFile customerInfoFile = new CustomerInfoFile();
				customerInfoFile.setKhbh(khbh);
				customerInfoFile.setGhrgh(ghrgh);
				customerInfoFile.setFile_name(file_name);
				customerInfoFile.setFile_type(type);
				customerInfoFile.setKhmc(khmc);
				customerInfoFile.setInfo_time(time);
				System.out.println("address: " + address);
				customerInfoFile.setInfo_address(address);
				Date date=new Date();
				DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String upload_time=format.format(date);
				customerInfoFile.setUpload_time(upload_time);
				String download_url = "/DownloadFile/"+file_name.substring(0, file.getOriginalFilename().indexOf('.'));
				customerInfoFile.setDownload_url(download_url);

				CustomerInfoFile customer = customerInfoFileService.findCustomerInfoFile(khbh, ghrgh, file_name, type);
				if (customer!=null){
					customerInfoFileService.updateCustomerInfoFile(customerInfoFile);
					msg="update";
					err="success";
				}else{
					customerInfoFileService.insertCustomerInfoFile(customerInfoFile);
					msg="insert";
					err="success";
				}
			} catch (IllegalStateException e) {  
				e.printStackTrace();  
			} catch (IOException e) {  
				e.printStackTrace();  
			}  
		}  
		ModelAndView mv = new ModelAndView();
		mv.addObject("message",""+msg);
		mv.addObject("greeting",""+err);
		mv.setViewName("apkmanager/showMessage");
		return mv; 
	} 
}
