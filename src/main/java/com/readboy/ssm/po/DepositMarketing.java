package com.readboy.ssm.po;
import javax.persistence.Entity;
import javax.persistence.Table;

/*
 * 存款营销
 * */

public class DepositMarketing extends Marketing{
	
	private Integer ckzl;		//存款种类
	private Integer khzl;		//客户种类
	public Integer getCkzl() {
		return ckzl;
	}
	public void setCkzl(Integer ckzl) {
		this.ckzl = ckzl;
	}
	public Integer getKhzl() {
		return khzl;
	}
	public void setKhzl(Integer khzl) {
		this.khzl = khzl;
	}
	
	
	

}
