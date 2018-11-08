package com.readboy.ssm.po;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 业绩工资首页，对应数据库表erp_wage_ygjx_mx
 * 2017-06-23
 */
@Entity
@Table(name = "erp_wage_ygjx_mx")
public class PerformanceMx {
	
	private String zzbz;			//组织标识
	private String gzrq;			//工资日期
	@Id
	private String zbid;			//指标ID
	private String zbmc;			//指标名称，从表erp_bas_zbk中获取
	private BigDecimal zbdj;		//指标单价
	private BigDecimal zbjg;		//指标结果
	private BigDecimal zbgz;		//指标工资
	private Integer gwbz;				//岗位标志
	private String yggh;			//员工工号
	private Integer zblb;				//指标类别
	private String khwd;			//考核维度
	private Integer lrbz;				//录入标志
	private String lrr;				//录入人
	private String lrsj;			//录入时间
	
	
	
	public String getGzrq() {
		if(gzrq != null && gzrq.length() > 10){
			return gzrq.substring(0,10);
		}
		return gzrq;
	}



	public String getZzbz() {
		return zzbz;
	}



	public void setZzbz(String zzbz) {
		this.zzbz = zzbz;
	}



	public String getZbid() {
		return zbid;
	}



	public void setZbid(String zbid) {
		this.zbid = zbid;
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



	public String getLrsj() {
		return lrsj;
	}



	public void setLrsj(String lrsj) {
		this.lrsj = lrsj;
	}



	public void setGzrq(String gzrq) {
		this.gzrq = gzrq;
	}

	
}
