package com.readboy.ssm.service;

import org.apache.ibatis.annotations.Param;

import com.readboy.ssm.po.User;

/*
 * 用户Service
 * */
public interface UserService {
	
	//登录检测
	public User checkUsernameAndPassword(User user) throws Exception;
	
	//修改用户登录状态
	public int updateLoginStatusByUserid(long userid,int loginStatus) throws Exception;
	
	//修改用户登录sessionId
	public int updateLoginSessionByUserid(long userid,String loginSessionId) throws Exception;
	
	//密码修改
	public long updatePasswordByUserid(long userid, String password)  throws Exception;
	
	//密码上次登录时间
	public long updateLastLoginTimeByUserid(long userid, String lastlogintime)  throws Exception;
}
