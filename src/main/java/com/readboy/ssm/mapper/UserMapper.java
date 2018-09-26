package com.readboy.ssm.mapper;

import org.apache.ibatis.annotations.Param;

import com.readboy.ssm.po.User;

public interface UserMapper {
	
	//检查用户名和密码
	public User checkUsernameAndPassword(User user) throws Exception;
	
	//修改用户登录状态
	public int updateLoginStatusByUserid(
			@Param("userid")long userid,
			@Param("loginstatus") int loginStatus) throws Exception;
	
	public int updateLoginSessionIdByUserid(
			@Param("userid")long userid,
			@Param("loginsessionid") String loginSessionId) throws Exception;
	
	//修改密码
	public long updatePasswordByUserid(@Param("userid") long userid,
			@Param("password") String password)  throws Exception;

	
	//修改上次登录时间
	public long updateLastLoginTimeByUserid(@Param("userid") long userid,
			@Param("lastlogintime") String lastlogintime)  throws Exception;	
}
