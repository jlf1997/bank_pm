package com.readboy.ssm.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.readboy.ssm.po.Res;
import com.readboy.ssm.service.ResService;

@Controller
public class ResController {
	
	@Autowired
	private ResService resService;
	@ResponseBody
	@RequestMapping(value="/findRes.action",method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView findRes(
	ModelAndView modelAndView) throws Exception{
		Res res = resService.findRes();
		if(res == null){
			modelAndView.addObject("info","你还没有配置过资源文件路径!");
		}else{
			modelAndView.addObject("info","你已成功配置资源路径，路径如下：");
		}
		modelAndView.addObject("one",res);
		modelAndView.setViewName("system/resConfig");
		return modelAndView;
	}
	
	@RequestMapping(value="/updateRes.action",method={RequestMethod.POST,RequestMethod.GET})
	public String updateRes(
	@RequestParam(value="path",required=true) String path) throws Exception{
		if(resService.findRes() == null){
			resService.insertRes(path);
			return "redirect:findRes.action";
		}else{
			long flag = resService.updateRes(path);
			if(flag > 0){
				return "redirect:findRes.action";
			}
			return "fail";
		}
	}
	
	@RequestMapping(value="/resConfig.action",method={RequestMethod.POST,RequestMethod.GET})
	public String resConfig(
	@RequestParam(value="path",required=true) String path,HttpServletRequest req) throws Exception{
		String p = req.getServletContext().getRealPath("");
		File f = new File(p);
		File server = new File(f.getParentFile().getParentFile().getAbsolutePath(),"conf/server.xml");
		FileInputStream fis = null;
		FileOutputStream fos = null;
		fis = new FileInputStream(server);
		BufferedReader r = new BufferedReader(new InputStreamReader(fis));
		String serverLine = null;
		StringBuilder sb = new StringBuilder();
		String sep = System.getProperty("line.separator", "\r\n"); 
		while((serverLine = r.readLine()) != null){
			sb.append(serverLine).append(sep);
		}
		String ctxtStr = "<Context path=\"/res\" docBase=\""+path+"\\\" reloadable=\"true\"></Context>";
		System.out.println("tomcat下的conf/server.xml配置文件中配置虚拟路径成功！");
		fos = new FileOutputStream(server);
		Res res = null;
		//插入数据库
		if((res = resService.findRes()) == null){
			resService.insertRes(path);
			int index = -1;
			if((index = sb.indexOf("</Host>")) != -1){
				sb.insert(index,ctxtStr);
			}
			serverLine = sb.toString();
			fos.write(serverLine.getBytes());
			fis.close();
			fos.close();
			return "redirect:findRes.action";
		}else{
			serverLine = sb.toString();
			String oldCtxtStr = "<Context path=\"/res\" docBase=\""+res.getPath()+"\\\" reloadable=\"true\"></Context>";
			if(serverLine.contains(oldCtxtStr)){
				serverLine = serverLine.replace(oldCtxtStr, ctxtStr);
			}
			fos.write(serverLine.getBytes());
			fis.close();
			fos.close();
			long flag = resService.updateRes(path);
			if(flag > 0){
				return "redirect:findRes.action";
			}
			return "fail";
		}
	}
	
}
