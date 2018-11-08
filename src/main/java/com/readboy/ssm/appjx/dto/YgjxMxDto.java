package com.readboy.ssm.appjx.dto;

import java.math.BigDecimal;

import javax.persistence.Id;

public class YgjxMxDto {
	
	private String zbid;
	private String zzbz;			//组织标识
	private String zbmc;			//指标名称，从表erp_bas_zbk中获取
	private BigDecimal zbdj;		//指标单价
	private BigDecimal zbjg;		//指标结果
	private BigDecimal zbgz;		//指标工资
	public String getZbid() {
		return zbid;
	}
	public void setZbid(String zbid) {
		this.zbid = zbid;
	}
	public String getZzbz() {
		return zzbz;
	}
	public void setZzbz(String zzbz) {
		this.zzbz = zzbz;
	}
	public String getZbmc() {
		return zbmc;
	}
	public void setZbmc(String zbmc) {
		this.zbmc = zbmc;
	}
	public BigDecimal getZbdj() {
		return zbdj;
	}
	public void setZbdj(BigDecimal zbdj) {
		this.zbdj = zbdj;
	}
	public BigDecimal getZbjg() {
		return zbjg;
	}
	public void setZbjg(BigDecimal zbjg) {
		this.zbjg = zbjg;
	}
	public BigDecimal getZbgz() {
		return zbgz;
	}
	public void setZbgz(BigDecimal zbgz) {
		this.zbgz = zbgz;
	}

	
}
