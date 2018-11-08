package com.readboy.ssm.po;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="sys_bas_user")
@Entity
public class User {
	@Id
	private Long userid; 	
	private String username;
	private String password;
	private String realname;
	private String email;
	private String phone;
	private String status;
	private String createUser;
	private String createTime;
	private Long posiId;
	private Long roleId;
	private String tellId;
	private String updateUser;
	private String updateTime;
	private String jgdm;
	private String postName;
	private String roleName;
	private String qxjgdm;
	private String lastLoginTime;
	private String lastLoginIp;
	private String lastLoginPort;
	private Integer loginStatus;
	private String loginSessionId;
	private String logoutTime;
	private String notifyInfo;
	private String notifySessionId;
	private String statusUpdateTime;
	public Long getUserid() {
		return userid;
	}
	public void setUserid(Long userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRealname() {
		return realname;
	}
	public void setRealname(String realname) {
		this.realname = realname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getCreateUser() {
		return createUser;
	}
	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public Long getPosiId() {
		return posiId;
	}
	public void setPosiId(Long posiId) {
		this.posiId = posiId;
	}
	public Long getRoleId() {
		return roleId;
	}
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}
	public String getTellId() {
		return tellId;
	}
	public void setTellId(String tellId) {
		this.tellId = tellId;
	}
	public String getUpdateUser() {
		return updateUser;
	}
	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}
	public String getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}
	public String getJgdm() {
		return jgdm;
	}
	public void setJgdm(String jgdm) {
		this.jgdm = jgdm;
	}
	public String getPostName() {
		return postName;
	}
	public void setPostName(String postName) {
		this.postName = postName;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getQxjgdm() {
		return qxjgdm;
	}
	public void setQxjgdm(String qxjgdm) {
		this.qxjgdm = qxjgdm;
	}
	public String getLastLoginTime() {
		return lastLoginTime;
	}
	public void setLastLoginTime(String lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}
	public String getLastLoginIp() {
		return lastLoginIp;
	}
	public void setLastLoginIp(String lastLoginIp) {
		this.lastLoginIp = lastLoginIp;
	}
	public String getLastLoginPort() {
		return lastLoginPort;
	}
	public void setLastLoginPort(String lastLoginPort) {
		this.lastLoginPort = lastLoginPort;
	}
	public Integer getLoginStatus() {
		return loginStatus;
	}
	public void setLoginStatus(Integer loginStatus) {
		this.loginStatus = loginStatus;
	}
	public String getLoginSessionId() {
		return loginSessionId;
	}
	public void setLoginSessionId(String loginSessionId) {
		this.loginSessionId = loginSessionId;
	}
	public String getLogoutTime() {
		return logoutTime;
	}
	public void setLogoutTime(String logoutTime) {
		this.logoutTime = logoutTime;
	}
	public String getNotifyInfo() {
		return notifyInfo;
	}
	public void setNotifyInfo(String notifyInfo) {
		this.notifyInfo = notifyInfo;
	}
	public String getNotifySessionId() {
		return notifySessionId;
	}
	public void setNotifySessionId(String notifySessionId) {
		this.notifySessionId = notifySessionId;
	}
	public String getStatusUpdateTime() {
		return statusUpdateTime;
	}
	public void setStatusUpdateTime(String statusUpdateTime) {
		this.statusUpdateTime = statusUpdateTime;
	}
	
	
}
