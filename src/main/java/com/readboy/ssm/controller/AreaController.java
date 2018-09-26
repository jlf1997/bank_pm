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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.readboy.ssm.po.Area;
import com.readboy.ssm.service.AreaService;

@Controller  
public class AreaController {
	
	@Autowired
	private AreaService areaService;
	@ResponseBody
	@RequestMapping(value="/mobie/findArea.action",method={RequestMethod.POST,RequestMethod.GET})
	public Area findArea() throws Exception{
		return areaService.findArea();
	}
	
	@RequestMapping(value="/dtest.action",method={RequestMethod.POST,RequestMethod.GET})
	public void download() throws Exception{
		autoDataImport();
	}
	
	public void autoDataImport(){
		System.out.println("当前时间:"+new Date().toString());
		String url = "https://timgsa.baidu.com/timg?image&quality=80&"
				+ "size=b9999_10000&sec=1516011583198&di=470c65a7193107"
				+ "ee7e435f8be482940b&imgtype=0&src=http%3A%2F%2Fimgsrc.baidu"
				+ ".com%2Fimgad%2Fpic%2Fitem%2Fe1fe9925bc315c600dce09d386b1cb13495477b6.jpg";
		//执行下载任务
		try {
			download(url);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//执行数据导入
		System.out.println("开始数据导入");
		//数据导入日志
		System.out.println("日志填写");
	}
	
	 public void download(String fileUrl) throws Exception {
	        int pointIndex = fileUrl.lastIndexOf(".");
	        BufferedInputStream bis = null;
	        //如果有找到符号"."，
	        if (pointIndex != -1) {
	            String fileName = fileUrl.substring(pointIndex, fileUrl.length());
	            URL url = new URL(fileUrl);
	            URLConnection conn = url.openConnection();
	            bis = new BufferedInputStream(conn.getInputStream());
	            BufferedOutputStream os = new BufferedOutputStream(new FileOutputStream(new File("E://test//"+fileName+".zip")));
	            // 从输入流中读入字节流，然后写到文件中
	            byte[] buffer = new byte[1024];
	            int nRead;
	            while ((nRead = bis.read(buffer, 0, 1024)) > 0) { // bis为网络输入流
	                os.write(buffer, 0, nRead);
	            }
	            bis.close();
	            os.flush();
	            os.close();
	        }
	  }
	
	
}
