package com.readboy.ssm.controller;

import com.readboy.ssm.po.DepositMarketing;
import com.readboy.ssm.po.EtcMarketing;
import com.readboy.ssm.po.Organization;
import com.readboy.ssm.po.PageOption;
import com.readboy.ssm.po.SimpleOrganization;
import com.readboy.ssm.po.User;
import com.readboy.ssm.service.AreaService;
import com.readboy.ssm.service.EtcMarketingService;
import com.readboy.ssm.service.OrganizationService;
import com.readboy.ssm.utils.Constants;

import java.text.SimpleDateFormat;
import java.util.*;

import javax.servlet.http.HttpServletRequest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EtcMarketingController
{
	@Autowired
	private EtcMarketingService etcMarketingService;
	
	@Autowired
	private OrganizationService organizationService;
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	//--------------响应手机端请求----------------
	@ResponseBody
	//返回所有Etc营销登记记录
	@RequestMapping("/mobile/responseEtcMarketingJson.action")
	public Map<String,Object> responseEtcMarketingJson(
			@RequestParam(value="gyh",required=true) String yggh,
			@RequestParam(value="condition",required=false) String condition,
			PageOption page) throws Exception{
		PageOption.initAppPage(page);
		Integer num = etcMarketingService.findDataCountByCond(yggh, condition);
		List<EtcMarketing> list = etcMarketingService.findEtcMarketingByYggh(yggh,condition,page);
		Map<String,Object> m = new HashMap<String,Object>();
		m.put("num", num);
		m.put("list",list);
		return m;
	}
	
	//插入一条Etc营销记录：参数：EtcMarketing etcMarketing
	@ResponseBody
	@RequestMapping(value="/mobile/mobileInsertEtcMarketing.action",method={RequestMethod.POST,RequestMethod.GET})
	public String mobileInsertEtcMarketing(EtcMarketing etcMarketing) throws Exception{
		String curRq = sdf.format(new Date());
		String yyrq = etcMarketing.getYyrq();
		if(yyrq.compareTo(curRq) < 0){
			return Constants.ERROR_CODE1;
		}
		EtcMarketing one = etcMarketingService.findEtcMarketingExits(etcMarketing.getJgdm(),etcMarketing.getZjhm()
				,etcMarketing.getYyrq());
		if(one != null){
			return Constants.ERROR_CODE2;
		}
		long yybh = etcMarketingService.insertEtcMarketing(etcMarketing);
		if(yybh > 0){
			//插入成功
			return Constants.SUCCESS_CODE1;
		}else{
			return Constants.ERROR_CODE3;
		}
	}
	
	//更新etc营销记录，参数：EtcMarketing etcMarketing
	@ResponseBody
	@RequestMapping(value="/mobile/mobileUpdateEtcMarketing.action",method={RequestMethod.POST,RequestMethod.GET})
	public String mobileUpdateEtcMarketing(EtcMarketing etcMarketing) throws Exception{
		etcMarketingService.updateEtcMarketing(etcMarketing);
		return "success";
	}
	
	//根据预约编号删除一条etc营销登记记录
	@ResponseBody
	@RequestMapping(value="/mobile/mobileDeleteOneEtcMarketingByYybh.action",method={RequestMethod.POST,RequestMethod.GET})
	public String mobileDeleteOneEtcMarketingByYybh(@RequestParam(value="yybh",required=true) long yybh) throws Exception{
		etcMarketingService.deleteOneEtcMarketingByYybh(yybh);
		return "success";
	}
	
	//------------响应电脑端请求-------------
	//根据预约编号查询一条etc营销记录
	@RequestMapping(value="/queryOneEtcMarketingByYybh.action",method={RequestMethod.POST,RequestMethod.GET})
	public String queryOneEtceMarketingByYybh(Model model,@RequestParam(value="yybh",required=true) long yybh) throws Exception{
		EtcMarketing one = etcMarketingService.findEtcMarketingByYybh(yybh);
		List<SimpleOrganization> simOrgList = organizationService.findAllSimpleOrganizations();
		model.addAttribute("simOrgList",simOrgList);
		model.addAttribute("one",one);
		model.addAttribute("type","etc");
		return "marketing/oneMarketing";
	}
	
	@RequestMapping("/findEtcMarketing.action")
	public ModelAndView findEtcMarketing(HttpServletRequest req,
			@RequestParam(value="condition",required=false) String condition,
			@RequestParam(value="yggh",required=true) String yggh,PageOption page) throws Exception{
		ModelAndView modelAndView = new ModelAndView();
		
		page.setTotalResult(etcMarketingService.findDataCountByCond(yggh, condition));
		PageOption.initPage(page);
		List<EtcMarketing> list = etcMarketingService.findEtcMarketingByYggh(yggh, condition,page);
		List<SimpleOrganization> simOrgList = organizationService.findAllSimpleOrganizations();
		modelAndView.addObject("type","etc");
		modelAndView.addObject("list",list);
		modelAndView.addObject("yggh",yggh);
		modelAndView.addObject("simOrgList",simOrgList);
		modelAndView.addObject("condition",condition);
		modelAndView.addObject("page",page);
		modelAndView.setViewName("marketing/marketingList");
		return modelAndView;
	}
	
	//更新etc营销记录，参数：EtcMarketing etcMarketing
	@RequestMapping(value="/updateEtcMarketing.action",method={RequestMethod.POST,RequestMethod.GET})
	public String updateEtcMarketing(EtcMarketing etcMarketing) throws Exception{
		etcMarketingService.updateEtcMarketing(etcMarketing);
		return "forward:findEtcMarketing.action";
	}
	
	//插入一条Etc营销记录：参数：EtcMarketing etcMarketing
	@RequestMapping(value="/insertEtcMarketing.action",method={RequestMethod.POST,RequestMethod.GET})
	public String insertEtcMarketing(EtcMarketing etcMarketing) throws Exception{
		long yybh = etcMarketingService.insertEtcMarketing(etcMarketing);
		if(yybh > 0){
			//插入成功
			return "forward:findEtcMarketing.action";
		}else{
			return "fail";
		}
	}
	
	//根据预约编号删除一条etc营销登记记录
	@RequestMapping(value="/deleteOneEtcMarketingByYybh.action",method={RequestMethod.POST,RequestMethod.GET})
	public String deleteEtcMarketingByYybh(@RequestParam(value="yybh",required=true) long yybh) throws Exception{
		long flag = etcMarketingService.deleteOneEtcMarketingByYybh(yybh);
		if(flag > 0 ){
			return "forward:findEtcMarketing.action";
		}
		return "fail";
	}
}
