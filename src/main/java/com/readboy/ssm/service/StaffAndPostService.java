package com.readboy.ssm.service;

import org.apache.ibatis.annotations.Param;

import com.readboy.ssm.po.StaffAndPost;

/*
 * 员工和岗位Service
 * */
public interface StaffAndPostService {
	
	public String findYgghByZzbz(String zzbz,int rglx) throws Exception;
	public StaffAndPost findStaffAndPostByYggh(
			@Param("yggh") String yggh) throws Exception;
}
