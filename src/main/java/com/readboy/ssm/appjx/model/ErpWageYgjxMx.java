package com.readboy.ssm.appjx.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "erp_wage_ygjx_mx")
public class ErpWageYgjxMx {

	private String zzbz;			//组织标识
	private Date gzrq;			//工资日期
	@Id
	private String zbid;			//指标ID
 
	private BigDecimal zbdj;		//指标单价
	private BigDecimal zbjg;		//指标结果
	private BigDecimal zbgz;		//指标工资
	private Integer gwbz;				//岗位标志
	private String yggh;			//员工工号
	private Integer zblb;				//指标类别
	private String khwd;			//考核维度
	private Integer lrbz;				//录入标志
	private String lrr;				//录入人
	private Date lrsj;			//录入时间
	public String getZzbz() {
		return zzbz;
	}
	public void setZzbz(String zzbz) {
		this.zzbz = zzbz;
	}
	public Date getGzrq() {
		return gzrq;
	}
	public void setGzrq(Date gzrq) {
		this.gzrq = gzrq;
	}
	public String getZbid() {
		return zbid;
	}
	public void setZbid(String zbid) {
		this.zbid = zbid;
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
	public Integer getGwbz() {
		return gwbz;
	}
	public void setGwbz(Integer gwbz) {
		this.gwbz = gwbz;
	}
	public String getYggh() {
		return yggh;
	}
	public void setYggh(String yggh) {
		this.yggh = yggh;
	}
	public Integer getZblb() {
		return zblb;
	}
	public void setZblb(Integer zblb) {
		this.zblb = zblb;
	}
	public String getKhwd() {
		return khwd;
	}
	public void setKhwd(String khwd) {
		this.khwd = khwd;
	}
	public Integer getLrbz() {
		return lrbz;
	}
	public void setLrbz(Integer lrbz) {
		this.lrbz = lrbz;
	}
	public String getLrr() {
		return lrr;
	}
	public void setLrr(String lrr) {
		this.lrr = lrr;
	}
	public Date getLrsj() {
		return lrsj;
	}
	public void setLrsj(Date lrsj) {
		this.lrsj = lrsj;
	}
	
	
}
