package com.readboy.ssm.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import com.readboy.ssm.mapper.StaffAndPostMapper;
import com.readboy.ssm.po.StaffAndPost;
import com.readboy.ssm.service.StaffAndPostService;

public class StaffAndPostServiceImpl implements StaffAndPostService{
	
	@Autowired 
	private StaffAndPostMapper staffAndPostMapper;

	@Override
	public String findYgghByZzbz(String zzbz,int rglx) throws Exception {
		// TODO Auto-generated method stub
		return staffAndPostMapper.findYgghByZzbz(zzbz,rglx);
	}

	@Override
	public StaffAndPost findStaffAndPostByYggh(String yggh) throws Exception {
		// TODO Auto-generated method stub
		return staffAndPostMapper.findStaffAndPostByYggh(yggh);
	}
}
