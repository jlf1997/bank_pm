package com.readboy.ssm.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;

import com.readboy.ssm.mapper.StaffInfoMapper;
import com.readboy.ssm.po.StaffInfo;
import com.readboy.ssm.service.StaffInfoService;

public class StaffInfoServiceImpl implements StaffInfoService{
	
	@Autowired
	private StaffInfoMapper staffInfoMapper;
	@Override
	public StaffInfo findStaffInfoByConditions(String zzbz, long gwbz,
			String yggh) throws Exception {
		// TODO Auto-generated method stub
		return staffInfoMapper.findStaffInfoByConditions(zzbz, gwbz, yggh);
	}
	
}
