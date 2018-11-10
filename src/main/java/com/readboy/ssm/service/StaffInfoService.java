package com.readboy.ssm.service;

import com.readboy.ssm.po.Organization;
import com.readboy.ssm.po.StaffInfo;

public interface StaffInfoService {
	
	public StaffInfo findStaffInfoByConditions(
			 String zzbz,long gwbz, String yggh) throws Exception;
	
}
