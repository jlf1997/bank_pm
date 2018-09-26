package com.readboy.ssm.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.readboy.ssm.mapper.OrganizationMapper;
import com.readboy.ssm.po.Organization;
import com.readboy.ssm.po.SimpleOrganization;
import com.readboy.ssm.service.OrganizationService;

public class OrganizationServiceImpl implements OrganizationService{
	
	@Autowired
	private OrganizationMapper organizationMapper;
	
	@Override
	public List<Organization> findAllOrganizations() throws Exception {
		// TODO Auto-generated method stub
		return organizationMapper.findAllOrganizations();
	}
	
	@Override
	public List<SimpleOrganization> findAllSimpleOrganizations()
			throws Exception {
		// TODO Auto-generated method stub
		return organizationMapper.findAllSimpleOrganizations();
	}	

	@Override
	public Organization getOrganizationByZzbz(String zzbz) throws Exception {
		// TODO Auto-generated method stub
		return organizationMapper.getOrganizationByZzbz(zzbz);
	}

	@Override
	public Organization getOrganizationByYwjgdm(String ywjgdm) throws Exception {
		// TODO Auto-generated method stub
		return organizationMapper.getOrganizationByYwjgdm(ywjgdm);
	}

}
