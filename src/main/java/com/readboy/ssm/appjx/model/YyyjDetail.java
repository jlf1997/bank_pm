package com.readboy.ssm.appjx.model;

import java.util.Date;

public class YyyjDetail {
	private String jgmc;			//机构代码
	private String khmc; 			//客户名称
	private String sjhm;			//手机号码
	private Integer sbzt; 				//申报状态
	private Date yyrq;			//预约日期
	private Long yybh; 				//预约编号,主键
	
	private String type;
	public String getJgmc() {
		return jgmc;
	}
	public void setJgmc(String jgmc) {
		this.jgmc = jgmc;
	}
	public String getKhmc() {
		return khmc;
	}
	public void setKhmc(String khmc) {
		this.khmc = khmc;
	}
	public String getSjhm() {
		return sjhm;
	}
	public void setSjhm(String sjhm) {
		this.sjhm = sjhm;
	}
	public Integer getSbzt() {
		return sbzt;
	}
	public void setSbzt(Integer sbzt) {
		this.sbzt = sbzt;
	}
	public Date getYyrq() {
		return yyrq;
	}
	public void setYyrq(Date yyrq) {
		this.yyrq = yyrq;
	}
	public Long getYybh() {
		return yybh;
	}
	public void setYybh(Long yybh) {
		this.yybh = yybh;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	
}
