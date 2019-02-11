package com.readboy.ssm.controller;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.readboy.ssm.controller.validation.MarketingValidationGroup;
import com.readboy.ssm.po.DepositMarketing;
import com.readboy.ssm.po.Organization;
import com.readboy.ssm.po.PageOption;
import com.readboy.ssm.po.SimpleOrganization;
import com.readboy.ssm.po.User;
import com.readboy.ssm.service.DepositMarketingService;
import com.readboy.ssm.service.OrganizationService;
import com.readboy.ssm.utils.Constants;

@Controller
public class DepositMarketingController {
	
	@Autowired
	private DepositMarketingService depositMarketingService;
	@Autowired
	private OrganizationService organizationService;
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	//--------------------响应手机端请求----------------------
	//查询所有存款营销记录
	@ResponseBody
	@RequestMapping(value="/mobile/responseDepositMarketingJson.action",method={RequestMethod.POST,RequestMethod.GET})
	public Map<String,Object> responseDepositMarketingJson(
			@RequestParam(value="gyh") String yggh,
			@RequestParam(value="condition",required=false) String condition,
			PageOption page) throws Exception{
		PageOption.initAppPage(page);
		Integer num = depositMarketingService.findDataCountByCond(yggh, condition);
		List<DepositMarketing> list = depositMarketingService.findDepositMarketingByYggh(yggh,condition,page);
		Map<String,Object> m = new HashMap<String,Object>();
		m.put("num", num);
		m.put("list",list);
		return m;
	}
	//更新存款营销记录
	@ResponseBody
	@RequestMapping(value="/mobile/mobileUpdateDepositMarketing.action",method={RequestMethod.POST,RequestMethod.GET})
	public String mobileUpdateDepositMarketing(DepositMarketing depositMarketing) throws Exception{
		depositMarketingService.updateDepositMarketing(depositMarketing);
		return "success";
	}
	//增加一条存款营销记录
	@ResponseBody
	@RequestMapping(value="/mobile/mobileInsertDepositMarketing.action",method={RequestMethod.POST,RequestMethod.GET})
	public String mobileInsertDepositMarketing(DepositMarketing depositMarketing) throws Exception{
		String curRq = sdf.format(new Date());
		String yyrq = depositMarketing.getYyrq();
		if(yyrq.compareTo(curRq) < 0){
			return Constants.ERROR_CODE1;
			//return "预约日期必须大于当前日期";
		}
		DepositMarketing one = depositMarketingService.findDepoditMarketingExitsForNewVersion(depositMarketing.getJgdm(),depositMarketing.getKhmc(),depositMarketing.getZjhm()
				,depositMarketing.getYyrq());
		if(one != null){
			return Constants.ERROR_CODE2;
			//return "同一机构的同一客户一天只能预约一次";
		}
		long yybh = depositMarketingService.insertDepositMarketing(depositMarketing);
		if(yybh > 0){
			//插入成功
			return Constants.SUCCESS_CODE1;
		}else{
			return Constants.ERROR_CODE3;
		}
	}
	
	
//	@ResponseBody
//	@RequestMapping(value="demo/getDepositMarketing",method={RequestMethod.POST,RequestMethod.GET})
//	public DepositMarketing getDepositMarketing(String jgdm,String khmc,String zjhm) throws Exception{
//		
//		DepositMarketing one = depositMarketingService.findDepoditMarketingExitsForNewVersion(jgdm,khmc,zjhm
//				,"2018-05-06");
//		return one;
//	}
	
	//删除一条手机营销记录
	@ResponseBody
	@RequestMapping(value="/mobile/mobileDeleteOneDepositMarketingByYybh.action",method={RequestMethod.POST,RequestMethod.GET})
	public String deletedepositMarketingByYybh(@RequestParam(value="yybh",required=true) long yybh) throws Exception{
		depositMarketingService.deleteOneDepositMarketingByYybh((yybh));
		return "success";
	}
	
	//----------------响应PC端请求-------------------------
	@RequestMapping(value="/queryOneDepositMarketingByYybh.action",method={RequestMethod.POST,RequestMethod.GET})
	public String queryOneDepositeMarketingByYybh(Model model,@RequestParam(value="yybh",required=true) long yybh) throws Exception{
		DepositMarketing one = depositMarketingService.findDepositMarketingByYybh(yybh);
		List<SimpleOrganization> simOrgList = organizationService.findAllSimpleOrganizations();
		model.addAttribute("one",one);
		model.addAttribute("simOrgList",simOrgList);
		model.addAttribute("type","ck");
		return "marketing/oneMarketing";
	}
	
	@RequestMapping(value="/findDepositMarketing.action",method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView findDepositMarketing(HttpServletRequest req,
			@RequestParam(value="condition",required=false) String condition,
			@RequestParam(value="yggh",required=true) String yggh,PageOption page,
			ModelAndView modelAndView) throws Exception{
		page.setTotalResult(depositMarketingService.findDataCountByCond(yggh, condition));
		PageOption.initPage(page);
		List<DepositMarketing> list = depositMarketingService.findDepositMarketingByYggh(yggh,condition,page);
		List<SimpleOrganization> simOrgList = organizationService.findAllSimpleOrganizations();
		modelAndView.addObject("simOrgList",simOrgList);
		modelAndView.addObject("list",list);
		modelAndView.addObject("type", "ck");
		modelAndView.addObject("yggh",yggh);
		modelAndView.addObject("condition",condition);
		modelAndView.addObject("page",page);
		modelAndView.setViewName("marketing/marketingList");
		return modelAndView;
	}
	
	@RequestMapping(value="/updateDepositMarketing.action",method={RequestMethod.POST,RequestMethod.GET})
	public String updateDepositMarketing(DepositMarketing depositMarketing) throws Exception{
		depositMarketingService.updateDepositMarketing(depositMarketing);
		
		return "forward:findDepositMarketing.action";
	}
	
	//这里使用了校验，@Validated实现对Po类的校验，BindingResult用于接收校验结果，并与@Validated成对且按此顺序出现
//	@RequestMapping(value="/insertDepositMarketing.action",method={RequestMethod.POST,RequestMethod.GET})
//	public String insertDepositMarketing(@Validated(value={MarketingValidationGroup.class}) DepositMarketing depositMarketing,BindingResult bindingResult
//			,Model model) throws Exception{
//		
//		List<ObjectError> allErrors = bindingResult.getAllErrors();
//		if(bindingResult.hasErrors()){
//			for(ObjectError error : allErrors){
//				System.out.println(error.getDefaultMessage());
//			}
//			model.addAttribute("allErrors",allErrors);
//			return "fail";
//		}
//		long yybh = depositMarketingService.insertDepositMarketing(depositMarketing);
//		if(yybh > 0){
//			//插入成功
//			return "forward:queryDepositMarketing.action";
//		}else{
//			return "fail";
//		}
//	}
	
	@RequestMapping(value="/deleteOneDepositMarketingByYybh.action",method={RequestMethod.POST,RequestMethod.GET})
	public String deleteOneDepositMarketingByYybh(@RequestParam(value="yybh",required=true) long yybh) throws Exception{
		long flag = depositMarketingService.deleteOneDepositMarketingByYybh(yybh);
		if(flag > 0){
			return "forward:findDepositMarketing.action";
		}
		return "fail";
	}
	
	//增加一条存款营销记录
	@RequestMapping(value="/insertDepositMarketing.action",method={RequestMethod.POST,RequestMethod.GET})
	public String insertDepositMarketing(DepositMarketing depositMarketing) throws Exception{
		long yybh = depositMarketingService.insertDepositMarketing(depositMarketing);
		if(yybh > 0){
			//插入成功
			return "forward:findDepositMarketing.action";
		}else{
			return "fail";
		}
	}
	
}
