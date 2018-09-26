package com.readboy.ssm.service;

import java.util.List;

import com.readboy.ssm.mapper.StaffJjGwMapper;
import com.readboy.ssm.po.Organization;
import com.readboy.ssm.po.StaffJjGw;


public interface StaffJjGwService{
	
	public List<StaffJjGw> findStaffJjGw() throws Exception;


	public Organization findOrganization(String tellId) throws Exception;
}
