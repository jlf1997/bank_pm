package com.readboy.ssm.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;

import com.readboy.ssm.mapper.UserMapper;
import com.readboy.ssm.po.User;
import com.readboy.ssm.service.UserService;

public class UserServiceImpl implements UserService{

	@Autowired
	private UserMapper userMapper;
	@Override
	public User checkUsernameAndPassword(User user)
			throws Exception {
		// TODO Auto-generated method stub
		
		return userMapper.checkUsernameAndPassword(user);
	}
	@Override
	public int updateLoginStatusByUserid(long userid,int loginStatus) throws Exception {
		// TODO Auto-generated method stub
		return userMapper.updateLoginStatusByUserid(userid,loginStatus);
	}
	@Override
	public int updateLoginSessionByUserid(long userid, String loginSessionId)
			throws Exception {
		// TODO Auto-generated method stub
		return userMapper.updateLoginSessionIdByUserid(userid, loginSessionId);
	}
	@Override
	public long updatePasswordByUserid(long userid, String password)
			throws Exception {
		// TODO Auto-generated method stub
		return userMapper.updatePasswordByUserid(userid, password);
	}
	@Override
	public long updateLastLoginTimeByUserid(long userid, String lastlogintime) throws Exception {
		// TODO Auto-generated method stub
		return userMapper.updateLastLoginTimeByUserid(userid, lastlogintime);
	}
}
