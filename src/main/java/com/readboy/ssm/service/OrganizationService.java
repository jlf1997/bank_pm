package com.readboy.ssm.service;

import java.util.List;

import com.readboy.ssm.po.Organization;
import com.readboy.ssm.po.SimpleOrganization;

public interface OrganizationService {
	//获取组织信息List
	public List<Organization> findAllOrganizations() throws Exception;
	
	//获取简略组织信息List
	public List<SimpleOrganization> findAllSimpleOrganizations() throws Exception;
		
	//获取一个组织详细信息
	public Organization getOrganizationByZzbz(String zzbz) throws Exception;
	
	//获取一个组织详细信息
	public Organization getOrganizationByYwjgdm(String ywjgdm) throws Exception;
}	
