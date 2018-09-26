package com.readboy.ssm.controller.mobile.visitor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.readboy.ssm.po.VisitFamilyInfo;
import com.readboy.ssm.service.VisitFamilyInfoService;

/**
 * 家庭成员信息Controller
 */
@Controller
@RequestMapping("/mobile/visitor/BaseInfo")
public class FamilyInfoController extends BaseController{
	@Autowired
	VisitFamilyInfoService visitFamilyInfoService;


	@RequestMapping(value = "/getFamilyNumberNames",method = {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public List<String> getFamilyNumberNames(){
		Map<String, Object> map = new HashMap<String, Object>();
		PageData pd = this.getPageData();
		map.put("visitorId", Integer.parseInt(pd.getString("visitorId")));
		map.put("clientNum", Integer.parseInt(pd.getString("clientNum")));
		map.put("memberType", "1");
		List<VisitFamilyInfo> visitFamilyInfos = visitFamilyInfoService.findListFamilyInfo(map);
		ArrayList<String> names = new ArrayList<>();
		for (VisitFamilyInfo visitFamilyInfo : visitFamilyInfos){
			names.add(visitFamilyInfo.getMemberName());
		}
		return names;
	}

	@RequestMapping(value = "/getContactsInfo", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public Object getContactsInfo() throws Exception{
		Map<String, Object> map = new HashMap<String, Object>();
		PageData pd = this.getPageData();
		map.put("visitorId", Integer.parseInt(pd.getString("visitorId")));
		map.put("clientNum", Integer.parseInt(pd.getString("clientNum")));
		map.put("memberType", pd.getString("memberType"));
		List<VisitFamilyInfo> result = visitFamilyInfoService.findListFamilyInfo(map);

		return result;
	}


	@RequestMapping(value = "/getFamilyInfo", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public Object getVisitInfo() throws Exception{
		Map<String, Object> map = new HashMap<String, Object>();
		PageData pd = this.getPageData();
		map.put("visitorId", Integer.parseInt(pd.getString("visitorId")));
		map.put("clientNum", Integer.parseInt(pd.getString("clientNum")));
		map.put("memberType", "1");
		List<VisitFamilyInfo> result = visitFamilyInfoService.findListFamilyInfo(map);
		
		return result;
	}
	
	@RequestMapping(value = "/saveFamilyInfo", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public Object saveVisitInfo() throws Exception{
		VisitFamilyInfo familyInfo = this.getBean(VisitFamilyInfo.class);
		visitFamilyInfoService.insertVisitFamilyInfo(familyInfo);
		Map<String, String> map = new HashMap<String, String>();
		map.put("result", "success");
		
		return map;
	}
	
	@RequestMapping(value = "/deleteFamilyInfo", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public Object deleteVisitInfo() throws Exception{
		int id = Integer.parseInt(this.getPageData().getString("id"));
		visitFamilyInfoService.deleteById(id);;
		Map<String, String> map = new HashMap<String, String>();
		map.put("result", "success");
		
		return map;
	}
}
