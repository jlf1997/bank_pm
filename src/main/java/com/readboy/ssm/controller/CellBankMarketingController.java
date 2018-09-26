package com.readboy.ssm.controller;

import com.readboy.ssm.po.CellBankMarketing;
import com.readboy.ssm.po.EtcMarketing;
import com.readboy.ssm.po.CellBankMarketing;
import com.readboy.ssm.po.PageOption;
import com.readboy.ssm.po.SimpleOrganization;
import com.readboy.ssm.po.User;
import com.readboy.ssm.service.CellBankMarketingService;
import com.readboy.ssm.service.CellBankMarketingService;
import com.readboy.ssm.service.OrganizationService;
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
public class CellBankMarketingController
{
	@Autowired
	private CellBankMarketingService cellBankMarketingService;
	
	@Autowired
	private OrganizationService organizationService;
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	//---------响应手机端请求---------------
	//返回所有手机银行营销登记
	@ResponseBody
	@RequestMapping("/mobile/responseCellBankMarketingJson.action")
	public Map<String,Object> responseCellBankMarketingJson(
			@RequestParam(value="gyh") String yggh,
			@RequestParam(value="condition",required=false) String condition,
			PageOption page) throws Exception{
		PageOption.initAppPage(page);
		Map<String,Object> m = new HashMap<String,Object>();
		Integer num = cellBankMarketingService.findDataCountByCond(yggh, condition);
		List<CellBankMarketing> list = new ArrayList<CellBankMarketing>(num);
		list = cellBankMarketingService.findCellBankMarketingByYggh(yggh,condition,page);
		m.put("num", num);
		m.put("list", list);
		return m;
	}
	
	//插入一条手机银行营销登记记录
	@ResponseBody
	@RequestMapping(value="/mobile/mobileInsertCellBankMarketing.action",method={RequestMethod.POST,RequestMethod.GET})
	public String mobileInsertCellBankMarketing(CellBankMarketing cellBankMarketing) throws Exception{
		String curRq = sdf.format(new Date());
		String yyrq = cellBankMarketing.getYyrq();
		if(yyrq.compareTo(curRq) < 0){
			return Constants.ERROR_CODE1;
			
		}
		CellBankMarketing one = cellBankMarketingService.findCellBankMarketingExits(cellBankMarketing.getJgdm(),cellBankMarketing.getZjhm()
				,cellBankMarketing.getYyrq());
		if(one != null){
			return Constants.ERROR_CODE2;
			
		}
		long yybh = cellBankMarketingService.insertCellBankMarketing(cellBankMarketing);
		if(yybh > 0){
			//插入成功
			return Constants.SUCCESS_CODE1;
		}else{
			return Constants.ERROR_CODE3;
		}
	}
	//更新手机银行营销登记
	@ResponseBody
	@RequestMapping(value="/mobile/mobileUpdateCellBankMarketing.action",method={RequestMethod.POST,RequestMethod.GET})
	public String mobileUpdateCellBankMarketing(CellBankMarketing cellBankMarketing) throws Exception{
		cellBankMarketingService.updateCellBankMarketing(cellBankMarketing);
		return "success";
	}
	
	//根据预约编号删除一条手机银行营销登记
	@ResponseBody
	@RequestMapping(value="/mobile/mobileDeleteOneCellBankMarketingByYybh.action",method={RequestMethod.POST,RequestMethod.GET})
	public String mobileDeleteOneCellBankMarketingByYybh(@RequestParam(value="yybh",required=true) long yybh) throws Exception{
		cellBankMarketingService.deleteOneCellBankMarketingByYybh(yybh);
		return "success";
	}
	//------------响应PC端请求-----------
	//根据预约编号查询一条手机银行营销登记
	@RequestMapping(value="/queryOneCellBankMarketingByYybh.action",method={RequestMethod.POST,RequestMethod.GET})
	public String queryOneCellBankMarketingByYybh(Model model,@RequestParam(value="yybh",required=true) long yybh) throws Exception{
		List<SimpleOrganization> simOrgList = organizationService.findAllSimpleOrganizations();
		CellBankMarketing one = cellBankMarketingService.findCellBankMarketingByYybh(yybh);
		model.addAttribute("one",one);
		model.addAttribute("simOrgList",simOrgList);
		model.addAttribute("type","cellbank");
		return "marketing/oneMarketing";
	}
	
	@RequestMapping("/findCellBankMarketing.action")
	public ModelAndView findCellBankMarketing(@RequestParam(value="condition",required=false) String condition,
			@RequestParam(value="yggh",required=true) String yggh,PageOption page,
			HttpServletRequest req) throws Exception{
		ModelAndView modelAndView = new ModelAndView();
		List<SimpleOrganization> simOrgList = organizationService.findAllSimpleOrganizations();
		List<CellBankMarketing> list = cellBankMarketingService.findCellBankMarketingByYggh(yggh ,condition,page);
		page.setTotalResult(cellBankMarketingService.findDataCountByCond(yggh, condition));
		PageOption.initPage(page);
		modelAndView.addObject("list",list);
		modelAndView.addObject("yggh",yggh);
		modelAndView.addObject("simOrgList",simOrgList);
		modelAndView.addObject("type","cellbank");
		modelAndView.addObject("condition",condition);
		modelAndView.addObject("page",page);
		modelAndView.setViewName("marketing/marketingList");
		return modelAndView;
	}
	
	//更新手机银行营销登记
	@RequestMapping(value="/updateCellBankMarketing.action",method={RequestMethod.POST,RequestMethod.GET})
	public String updateCellBankMarketing(CellBankMarketing cellBankMarketing) throws Exception{
		cellBankMarketingService.updateCellBankMarketing(cellBankMarketing);
		return "forward:findCellBankMarketing.action";
	}
	
	//插入手机一条手机银行营销登记记录
	@RequestMapping(value="/insertCellBankMarketing.action",method={RequestMethod.POST,RequestMethod.GET})
	public String insertCellBankMarketing(CellBankMarketing cellBankMarketing) throws Exception{
		long yybh = cellBankMarketingService.insertCellBankMarketing(cellBankMarketing);
		if(yybh > 0){
			//插入成功
			return "forward:findCellBankMarketing.action";
		}else{
			return "fail";
		}
	}
	
	//根据预约编号删除一条手机银行营销登记
	@RequestMapping(value="/deleteOneCellBankMarketingByYybh.action",method={RequestMethod.POST,RequestMethod.GET})
	public String deleteCellBankMarketingByYybh(@RequestParam(value="yybh",required=true) long yybh) throws Exception{
		long flag = cellBankMarketingService.deleteOneCellBankMarketingByYybh(yybh);
		if(flag > 0){
			return "forward:findCellBankMarketing.action";
		}
		return "fail";
	}
	
}
