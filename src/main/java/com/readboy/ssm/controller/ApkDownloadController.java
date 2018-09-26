package com.readboy.ssm.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.alibaba.fastjson.JSONObject;
import com.readboy.ssm.po.UploadModel;
import com.readboy.ssm.serviceImpl.UploadModelService;

@Controller
@RequestMapping("/mobile")
public class ApkDownloadController {
	@RequestMapping(value = "/QueryApkInfo.do")
    public void queryApkInfo(HttpServletRequest request, HttpServletResponse response)  
            throws Exception {  
        String pkg = ServletRequestUtils.getRequiredStringParameter(  
                request, "package");
   //     ServletContext servletContext = request.getSession().getServletContext();    
        UploadModelService uploadModelService = new UploadModelService();
        UploadModel uploadModel = uploadModelService.selectUploadModelByPkg(pkg);
        
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        String jsonStr ="";
        JSONObject jsonObject = new JSONObject();//"{\"name\":\"fly\",\"type\":\"虫子\"}";
        if (uploadModel!=null){
	        jsonObject.put("apkid",uploadModel.getApkId());
	        jsonObject.put("apkname", uploadModel.getApkName());
	        jsonObject.put("apkpackagename", uploadModel.getApkPackageName());
	        jsonObject.put("apkuploader", uploadModel.getApkUploader());
	        jsonObject.put("apkuploadtime", uploadModel.getApkUploadTime());
	        jsonObject.put("apkurl", uploadModel.getApkUrl());
	        jsonObject.put("apkversion", uploadModel.getApkVersion());
	        jsonObject.put("apkforceupdateflag", uploadModel.getApkForceUpdateFlag());
        }else{
        	jsonObject.put("msg", "未找到相应包");
        }
        
        jsonStr = jsonObject.toString();
        PrintWriter out = null;
        try {
            out = response.getWriter();
            out.write(jsonStr);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                out.close();
            }
        }       
//        System.out.println(accountService.verify(username, password));  
    }  
	
	 	@RequestMapping("/DownloadApk/{fileName}")   
	    public ModelAndView download(@PathVariable("fileName") 
	    String fileName, HttpServletRequest request, HttpServletResponse response)   
	            throws Exception {   
	        response.setContentType("text/html;charset=utf-8");   
	        request.setCharacterEncoding("UTF-8");   
	        java.io.BufferedInputStream bis = null;   
	        java.io.BufferedOutputStream bos = null;   
	        RandomAccessFile raf = null;
	        long fileLength;
	        String range = request.getHeader("RANGE");
	        
	        String ctxPath = request.getSession().getServletContext().getRealPath(   
	                "apk/");  
	        fileName=fileName+".apk";
	        String downLoadPath = ctxPath +"\\"+ fileName;   
	        
	        System.out.println(downLoadPath);  
	        long startPos=0;
	        long endPos=0;
	        try {   
		        if (range!=null){
		        	String  rangeBytes = range.replaceAll("bytes=", "");
		            String startStr = rangeBytes.substring(0, rangeBytes.indexOf('-'));  
		            String endStr = rangeBytes.substring(  
		                    rangeBytes.indexOf('-') + 1, rangeBytes.length());  
		            startPos = Long.parseLong(startStr.trim());  
		            endPos = Long.parseLong(endStr);
		            fileLength = endPos - startPos;		        	
		        }else{
		        	fileLength = new File(downLoadPath).length(); 
		        	endPos=fileLength;
		        }
//	            fileLength = new File(downLoadPath).length();   
	            response.setContentType("application/x-msdownload;");   
	            response.setHeader("Content-disposition", "attachment; filename="  
	                    + new String(fileName.getBytes("utf-8"), "ISO8859-1"));   
	            response.setHeader("Content-Length", String.valueOf(fileLength));  
	            raf = new RandomAccessFile(downLoadPath, "r");
//	            bis = new BufferedInputStream(new FileInputStream(downLoadPath));  
	            raf.seek(startPos);
	            bos = new BufferedOutputStream(response.getOutputStream());   
	            byte[] buff = new byte[2048];   
	            int bytesRead;   	              	         
	            while (-1 != (bytesRead = raf.read(buff, 0, buff.length))) {   
	                bos.write(buff, 0, bytesRead);   
	            }   
	        } catch (Exception e) {   
	            e.printStackTrace();   
	        } finally {   
	            if (bis != null)   
	                bis.close();   
	            if (bos != null)   
	                bos.close();   
	        }   
	        return null;   
	    }   
	 
		@RequestMapping("/QueryApkInfoByPkg.do")
		public String queryApkInfoBypkg(Model model){
//			model.addAttribute("greeting", "Hello Spring MVC");
//			model.addAttribute("message", "test next jsp");
			return "helloworld";
		}	 
	} 	