package com.readboy.ssm.controller;

import com.readboy.ssm.po.EtcMarketing;
import com.readboy.ssm.po.PageOption;
import com.readboy.ssm.po.PosMarketing;
import com.readboy.ssm.po.SimpleOrganization;
import com.readboy.ssm.po.User;
import com.readboy.ssm.service.OrganizationService;
import com.readboy.ssm.service.PosMarketingService;
import com.readboy.ssm.utils.Constants;

import java.text.SimpleDateFormat;
import java.util.*;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PosMarketingController
{
	@Autowired
	private PosMarketingService posMarketingService;
	@Autowired
	private OrganizationService organizationService;
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	//--------------响应手机端请求----------------
	@ResponseBody
	//返回所有Pos营销登记记录
	@RequestMapping("/mobile/responsePosMarketingJson.action")
	public Map<String,Object>  responsePosMarketingJson(
			@RequestParam("gyh") String yggh,
			@RequestParam(value="condition",required=false) String condition,
			PageOption page) throws Exception{
		PageOption.initAppPage(page);
		Integer num = posMarketingService.findDataCountByCond(yggh, condition);
		List<PosMarketing> list = posMarketingService.findPosMarketingByYggh(yggh,condition,page);
		Map<String,Object> m = new HashMap<String,Object>();
		m.put("num", num);
		m.put("list",list);
		return m;
	}
	
	//插入一条Pos营销记录：参数：PosMarketing PosMarketing
	@ResponseBody
	@RequestMapping(value="/mobile/mobileInsertPosMarketing.action",method={RequestMethod.POST,RequestMethod.GET})
	public String mobileInsertPosMarketing(PosMarketing posMarketing) throws Exception{
		String curRq = sdf.format(new Date());
		String yyrq = posMarketing.getYyrq();
		if(yyrq.compareTo(curRq) < 0){
			return Constants.ERROR_CODE1;
		}
		PosMarketing one = posMarketingService.findPosMarketingExits(posMarketing.getJgdm(),posMarketing.getZjhm()
				,posMarketing.getYyrq());
		if(one != null){
			return Constants.ERROR_CODE2;
		}
		long yybh = posMarketingService.insertPosMarketing(posMarketing);
		if(yybh > 0){
			//插入成功
			return Constants.SUCCESS_CODE1;
		}else{
			return Constants.ERROR_CODE3;
		}
	}
	
	//更新Pos营销记录，参数：PosMarketing PosMarketing
	@ResponseBody
	@RequestMapping(value="/mobile/mobileUpdatePosMarketing.action",method={RequestMethod.POST,RequestMethod.GET})
	public String mobileUpdatePosMarketing(PosMarketing posMarketing) throws Exception{
		posMarketingService.updatePosMarketing(posMarketing);
		return "success";
	
	}
	
	//根据预约编号删除一条Pos营销登记记录
	@ResponseBody
	@RequestMapping(value="/mobile/mobileDeleteOnePosMarketingByYybh.action",method={RequestMethod.POST,RequestMethod.GET})
	public String mobileDeleteOnePosMarketingByYybh(@RequestParam(value="yybh",required=true) long yybh) throws Exception{
		long result = posMarketingService.deleteOnePosMarketingByYybh(yybh);
		if(result > 0){
			return "success";
		}else{
			return "fail";
		}
	}
	
	//------------响应电脑端请求-------------
	//根据预约编号查询一条Pos营销记录
	@RequestMapping(value="/queryOnePosMarketingByYybh.action",method={RequestMethod.POST,RequestMethod.GET})
	public String queryOnePoseMarketingByYybh(Model model,
			@RequestParam(value="yybh",required=true) long yybh) throws Exception{
		PosMarketing one = posMarketingService.findPosMarketingByYybh(yybh);
		List<SimpleOrganization> simOrgList = organizationService.findAllSimpleOrganizations();
		model.addAttribute("simOrgList",simOrgList);
		model.addAttribute("one",one);
		model.addAttribute("type","pos");
		return "marketing/oneMarketing";
	}
	
	@RequestMapping("/findPosMarketing.action")
	public ModelAndView findPosMarketing(HttpServletRequest req,
			@RequestParam(value="condition",required=false) String condition,
			@RequestParam(value="yggh",required=true) String yggh,PageOption page) throws Exception{
		ModelAndView modelAndView = new ModelAndView();
		page.setTotalResult(posMarketingService.findDataCountByCond(yggh, condition));
		PageOption.initPage(page);
		List<PosMarketing> list = posMarketingService.findPosMarketingByYggh(yggh, condition,page);
		List<SimpleOrganization> simOrgList = organizationService.findAllSimpleOrganizations();
		modelAndView.addObject("simOrgList",simOrgList);
		modelAndView.addObject("list",list);
		modelAndView.addObject("yggh",yggh);
		modelAndView.addObject("condition",condition);
		modelAndView.addObject("type","pos");
		modelAndView.addObject("page",page);
		modelAndView.setViewName("marketing/marketingList");
		return modelAndView;
	}
	
	//更新Pos营销记录，参数：PosMarketing PosMarketing
	@RequestMapping(value="/updatePosMarketing.action",method={RequestMethod.POST,RequestMethod.GET})
	public String updatePosMarketing(PosMarketing posMarketing) throws Exception{
		posMarketingService.updatePosMarketing(posMarketing);
		return "forward:findPosMarketing.action";
		
	}
	
	//插入一条Pos营销记录：参数：PosMarketing PosMarketing
	@RequestMapping(value="/insertPosMarketing.action",method={RequestMethod.POST,RequestMethod.GET})
	public String insertPosMarketing(PosMarketing posMarketing) throws Exception{
		long yybh = posMarketingService.insertPosMarketing(posMarketing);
		if(yybh > 0){
			//插入成功
			return "forward:findPosMarketing.action";
		}else{
			return "fail";
		}
	}
	
	//根据预约编号删除一条Pos营销登记记录
	@RequestMapping(value="/deleteOnePosMarketingByYybh.action",method={RequestMethod.POST,RequestMethod.GET})
	public String deletePosMarketingByYybh(@RequestParam(value="yybh",required=true) long yybh) throws Exception{
		long result = posMarketingService.deleteOnePosMarketingByYybh(yybh);
		if(result > 0){
			return "forward:findPosMarketing.action";
		}else{
			return "fail";
		}
	}
}
