package com.readboy.ssm.appjx.dto;

import com.readboy.ssm.appjx.model.KhgxglBase;

public class KhgxglCkkhyxdjbDto extends KhgxglBase{

	private Integer ckzl;		//存款种类
	private Integer khzl;		//客户种类
	private String jgmc;
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
	public String getJgmc() {
		return jgmc;
	}
	public void setJgmc(String jgmc) {
		this.jgmc = jgmc;
	}
	
	
}
