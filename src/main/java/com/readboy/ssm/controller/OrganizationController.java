package com.readboy.ssm.controller;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.readboy.ssm.po.Organization;
import com.readboy.ssm.po.SimpleOrganization;
import com.readboy.ssm.service.OrganizationService;

@Controller
public class OrganizationController {
	
	@Autowired
	private OrganizationService organizationService;
	
	//--------------------响应手机端请求----------------------
	//
	@ResponseBody
	@RequestMapping("/mobile/responseOrganizationJson.action")
	public List<Organization> responseOrganizationJson() throws Exception{
		List<Organization> organizationList = organizationService.findAllOrganizations();
		return organizationList;
	}
	
	@ResponseBody
	@RequestMapping("/mobile/responseSimpleOrganizationJson.action")
	public List<SimpleOrganization> responseSimpleOrganizationJson() throws Exception{
//		List<Organization> organizationList = organizationService.findAllOrganizations();
//		
//		List<SimpleOrganization> sos = new ArrayList<SimpleOrganization>();
//		for(Organization o : organizationList){
//			sos.add(new SimpleOrganization(o.getZzbz(), o.getZzjc(), o.getYwjgdm()));
//		}
		
		List<SimpleOrganization> sos = organizationService.findAllSimpleOrganizations();
		
		return sos;
	}

	
	@RequestMapping("/queryOrganization.action")
	public ModelAndView queryOrganization() throws Exception{
		ModelAndView modelAndView = new ModelAndView();
		List<Organization> organizationList = organizationService.findAllOrganizations();
		modelAndView.addObject("organizationList",organizationList);
		modelAndView.setViewName("organization/organizationList");
		return modelAndView;
	}
	
	@RequestMapping(value="/viewOrganization.action",method={RequestMethod.POST,RequestMethod.GET})
	public String viewOrganization(Model model,@RequestParam(value="zzbz",required=true) String zzbz) throws Exception{
		Organization organization = organizationService.getOrganizationByZzbz(zzbz);
		model.addAttribute("organization",organization);
		return "organization/viewOrganizationDetail";
	}
	
}
