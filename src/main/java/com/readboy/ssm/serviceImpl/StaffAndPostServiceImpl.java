package com.readboy.ssm.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.readboy.ssm.appjx.dto.MyInfo;
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

	@Override
	public List<MyInfo> findStaffAndPostsByYggh(String yggh) throws Exception {
		// TODO Auto-generated method stub
		return staffAndPostMapper.findStaffAndPostsByYggh(yggh);
	}

	@Override
	public MyInfo findStaffAndPostsByYgghNow(String yggh) throws Exception {
		// TODO Auto-generated method stub
		return staffAndPostMapper.findStaffAndPostsByYgghNow(yggh);
	}
}
