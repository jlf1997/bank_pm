package com.readboy.ssm.po;

import java.math.BigDecimal;

/**
 * 
 * @author:	   	LCL
 * @date: 	   	2017-6-24
 * @description:绩效_个人按量计酬明细，对应数据库表v_wage_graljc
 */
public class PerformancePersonalByCountMx {
	
	private String gzrq;		//统计日期
	private String zzbz;		//组织标志
	private String zzjc;		//组织简称
	private int gwbz;			//岗位标志
	private String gwmc;		//岗位名称
	private String yggh;		//员工工号
	private String ygxm;		//员工姓名
	private String zbid;		//指标ID
	private String zbmc;		//指标名称
	private BigDecimal zbgz;	//指标工资
	private BigDecimal zbjg;	//指标结果
	private BigDecimal zbdw;	//指标单位
	private BigDecimal zbdj;	//指标单价
	
	public String getGzrq() {
		if(gzrq != null && gzrq.length() > 10){
			return gzrq.substring(0,10);
		}
		return gzrq;
	}
	public String getZzbz() {
		return zzbz;
	}
	public String getZzjc() {
		return zzjc;
	}
	public int getGwbz() {
		return gwbz;
	}
	public String getGwmc() {
		return gwmc;
	}
	public String getYggh() {
		return yggh;
	}
	public String getYgxm() {
		return ygxm;
	}
	public String getZbid() {
		return zbid;
	}
	public String getZbmc() {
		return zbmc;
	}
	public BigDecimal getZbgz() {
		return zbgz;
	}
	public BigDecimal getZbjg() {
		return zbjg;
	}
	public BigDecimal getZbdw() {
		return zbdw;
	}
	public BigDecimal getZbdj() {
		return zbdj;
	}
	public void setGzrq(String gzrq) {
		this.gzrq = gzrq;
	}
	public void setZzbz(String zzbz) {
		this.zzbz = zzbz;
	}
	public void setZzjc(String zzjc) {
		this.zzjc = zzjc;
	}
	public void setGwbz(int gwbz) {
		this.gwbz = gwbz;
	}
	public void setGwmc(String gwmc) {
		this.gwmc = gwmc;
	}
	public void setYggh(String yggh) {
		this.yggh = yggh;
	}
	public void setYgxm(String ygxm) {
		this.ygxm = ygxm;
	}
	public void setZbid(String zbid) {
		this.zbid = zbid;
	}
	public void setZbmc(String zbmc) {
		this.zbmc = zbmc;
	}
	public void setZbgz(BigDecimal zbgz) {
		this.zbgz = zbgz;
	}
	public void setZbjg(BigDecimal zbjg) {
		this.zbjg = zbjg;
	}
	public void setZbdw(BigDecimal zbdw) {
		this.zbdw = zbdw;
	}
	public void setZbdj(BigDecimal zbdj) {
		this.zbdj = zbdj;
	}
}
