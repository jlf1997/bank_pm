package com.readboy.ssm.serviceImpl;

import java.util.List;


import com.readboy.ssm.po.Organization;
import org.springframework.beans.factory.annotation.Autowired;

import com.readboy.ssm.mapper.StaffJjGwMapper;
import com.readboy.ssm.po.StaffJjGw;
import com.readboy.ssm.service.StaffJjGwService;

public class StaffJjGwServiceImpl implements StaffJjGwService{
	
	@Autowired
	private StaffJjGwMapper staffJjGwMapper;

	@Override
	public List<StaffJjGw> findStaffJjGw() throws Exception {
		// TODO Auto-generated method stub
		return staffJjGwMapper.findStaffJjGw();
	}

	@Override
	public Organization findOrganization(String tellId) throws Exception {
		return staffJjGwMapper.findOrganization(tellId);
	}

}
