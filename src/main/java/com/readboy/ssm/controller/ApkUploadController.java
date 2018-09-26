package com.readboy.ssm.controller;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;
import com.readboy.ssm.po.UploadModel;
import com.readboy.ssm.serviceImpl.UploadModelService;

@Controller("ApkUploadController")  
//@RequestMapping("apk")
public class ApkUploadController {
	
    @RequestMapping(value = "UploadApkCtr.do")  
    public ModelAndView fileUpload(@RequestParam("apkname") String apkName,
    		@RequestParam("apkuploader") String apkUploader,
    		@RequestParam("package") String pkg,
    		@RequestParam("version") String version,
    		@RequestParam("forceflag") String forceFlag,
            @RequestParam("fileupload") CommonsMultipartFile file, HttpServletRequest request) {  
    	System.out.println(apkName+"/"+apkUploader+"/"+pkg+"/"+version+"/"+forceFlag+"/"+
            request.getSession().getServletContext().getRealPath("apk/"));  
        System.out.println(file.getContentType());  
        System.out.println(file.getSize());  
        System.out.println(file.getOriginalFilename());
        String err="";
        String msg="";
        
        if (!file.isEmpty()) {  
        	String path=request.getSession().getServletContext().getRealPath("apk/");
        	String fileName = path+"\\"+file.getOriginalFilename();   
            File localFile = new File(fileName);  
            try {
            	if (!localFile.getParentFile().exists()){
            		localFile.getParentFile().mkdirs();
            	}
                file.transferTo(localFile);  
                UploadModelService uploadModelService = new UploadModelService();
                UploadModel uploadModel;// = new UploadModel();
                UploadModel newUploadModel = new UploadModel();
                if (forceFlag.equalsIgnoreCase("1")){
                	newUploadModel.setApkForceUpdateFlag(1);
                }
                else {
                	newUploadModel.setApkForceUpdateFlag(0);
                }
                newUploadModel.setApkName(apkName);
                newUploadModel.setApkPackageName(pkg);
                newUploadModel.setApkUploader(apkUploader);
                Date date=new Date();
                DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String apkUploadTime=format.format(date);
                newUploadModel.setApkUploadTime(apkUploadTime);
                newUploadModel.setApkVersion(version);
                String apkUrl = "/DownloadApk/"+file.getOriginalFilename().substring(0, file.getOriginalFilename().indexOf('.'));
                newUploadModel.setApkUrl(apkUrl); 
                uploadModel = UploadModelService.selectUploadModelByPkg(pkg);
                int newVersion = Integer.parseInt(version.trim());//parseInt(version.trim());
                int oldVersion = 0;
                if (uploadModel!=null){
                    oldVersion = Integer.parseInt(uploadModel.getApkVersion().trim());
                    if (newVersion>oldVersion){
                    	newUploadModel.setApkId(uploadModel.getApkId());
                    	uploadModelService.updateUploadModel(newUploadModel);
                    	msg="update old version";
                    	err="更新成功";
                    }else{
                    	msg="update failed";
                    	err="更新失败";
                    }
                }
                else{
                	uploadModelService.insertUploadModel(newUploadModel);
                	msg="insert new version";
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
        mv.setViewName("apkmanager/UploadApk");
        return mv; 
    }
    
	@RequestMapping ("/UploadApkView.do")
	public String test2(){
		return "apkmanager/UploadApk";
	}
	
	@RequestMapping ("/findUploadApkInfo.do")
	public String findUploadApkInfo(Model model){
		UploadModelService uploadModelService = new UploadModelService();
		UploadModel uploadModel = uploadModelService.selectAllUploadModel();
		model.addAttribute("one",uploadModel);
		return "apkmanager/UploadApk";

	}
}
