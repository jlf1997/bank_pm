package com.readboy.ssm.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.readboy.ssm.po.Area;
import com.readboy.ssm.po.User;
import com.readboy.ssm.service.AreaService;

//这个Controller纯粹是用来做页面跳转的
@Controller
public class PageController {
	@Autowired
	private AreaService areaService;
	
	@RequestMapping("pageSkip.action")
	public String PageSkip(@RequestParam("jspName") String jspName){
		if(jspName.length() > 0){
			return jspName;
		}
		return "fail";
	}
	
	//消息推送页面跳转
	@RequestMapping(value="/messagePush.action",method={RequestMethod.POST,RequestMethod.GET})
	public String MesssagePush(HttpServletRequest request,Model model) throws Exception{	
		//一些操作，暂时不知道
		String url = request.getRequestURL().toString();
		int index = url.indexOf("/bank_pm");
		url = url.substring(0,index);
		if(url.contains("http://")){
			url = url.replace("http://","");
		}
		model.addAttribute("url",url);
		//如果时在本地服务器上登录
		return "websocket";
	}
	
	//绩效工资跳转页面
	@RequestMapping("performanceSkip.action")
	public String performanceSkip(@RequestParam("jspName") String jspName,HttpServletRequest req,Model model){
		if(jspName.length() > 0){
			if(jspName.equals("performanceYgjxhz") || jspName.equals("performanceMonthHome")){
				User u = (User) req.getSession().getAttribute("admin");
				String yggh = u.getTellId();
				model.addAttribute("yggh",yggh);
			}
			return "performance"+"/"+jspName;
		}
		return "fail";
	}
	
	//特殊指标处理
//	@RequestMapping("spUrlTransfer.action")
//	public String urlTransfer(@RequestParam(value="url",required=true) String url,
//			@RequestParam("url")String tjrq,
//			@RequestParam(value="yggh",required=true) String yggh,
//			@RequestParam(value="zbid",required=false) String zbid,
//			@RequestParam(value="ghlx",required=false) int ghlx) throws Exception{
//		Area area =  areaService.findArea();
//		if(area.getDqcs() == 189210){  //会同
//			if(url.equals("findPerformanceEtcHsgzMx.action")){ //ETC营销户数
//				return "redirect:"+"/mobile/findPerformancePersonalByCountMx.action?gyh="+yggh+"&gzrq="+tjrq+"&zbid="+zbid;
//			}else{		//参数url= findPerformanceJgReductionMx.action
//				return "redirect:"+"/mobile/findPerformanceCbSjyhdhl.action?gyh="+yggh+"&gzrq="+tjrq+"&zbid="+zbid;
//			}
//		}else{
//			if(url.equals("findPerformanceEtcHsgzMx.action")){
//				return "redirect:"+url+"?"+"";
//			}else{
//				
//			}
//		}
//	}
	
}
