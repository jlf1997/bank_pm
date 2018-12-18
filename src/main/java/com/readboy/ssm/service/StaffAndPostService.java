package com.readboy.ssm.service;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.readboy.ssm.appjx.dto.MyInfo;
import com.readboy.ssm.po.StaffAndPost;

/*
 * 员工和岗位Service
 * */
public interface StaffAndPostService {
	
	public String findYgghByZzbz(String zzbz,int rglx) throws Exception;
	public StaffAndPost findStaffAndPostByYggh(
			@Param("yggh") String yggh) throws Exception;
	
	public List<MyInfo> findStaffAndPostsByYggh(
			@Param("yggh") String yggh) throws Exception;
	
	public MyInfo findStaffAndPostsByYgghNow(
			@Param("yggh") String yggh) throws Exception;
	
	public StaffAndPost findStaffAndPostByYgghAndTjrq(@Param("yggh") String yggh,
			@Param("fd") Date fd,
			@Param("ed") Date ed) throws Exception;
}
