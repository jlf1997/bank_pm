package com.readboy.ssm.utils;

import com.readboy.ssm.po.StaffInfo;
import com.readboy.ssm.po.User;
public class LoginStatusMessage {
	
	private User user;
	private String token;
	private StaffInfo staffInfo;
	public User getUser() {
		return user;
	}
	public String getToken() {
		return token;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public StaffInfo getStaffInfo() {
		return staffInfo;
	}
	public void setStaffInfo(StaffInfo staffInfo) {
		this.staffInfo = staffInfo;
	}
}
