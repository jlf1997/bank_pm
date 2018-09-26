package com.readboy.ssm.po;

import java.math.BigDecimal;

/*
 * 包收贷款欠息明细，对应数据库表:khgxgl_bsdkqxmx
 * */
public class BSLoanOweInterestDetail {
	
	 private String jgdm;		//机构代码
	 private String khbh;		//客户编号
	 private String dkzh;		//贷款账号
	 private String khmc;		//客户名称
	 private String qxr;		//欠息日
	 private String jxr;		//结息日
	 private String bsrgh;		//包收人工号
	 private BigDecimal qx;		//欠息
	 private String lrr;		//录入人
	 private String lrsj;		//录入时间
	 private int lrbz;			//录入标志
	 
	public String getJgdm() {
		return jgdm;
	}
	public String getKhbh() {
		return khbh;
	}
	public String getDkzh() {
		return dkzh;
	}
	public String getKhmc() {
		return khmc;
	}
	public String getQxr() {
		return qxr;
	}
	public String getJxr() {
		return jxr;
	}
	public String getBsrgh() {
		return bsrgh;
	}
	public BigDecimal getQx() {
		return qx;
	}
	public String getLrr() {
		return lrr;
	}
	public String getLrsj() {
		return lrsj;
	}
	public int getLrbz() {
		return lrbz;
	}
	public void setJgdm(String jgdm) {
		this.jgdm = jgdm;
	}
	public void setKhbh(String khbh) {
		this.khbh = khbh;
	}
	public void setDkzh(String dkzh) {
		this.dkzh = dkzh;
	}
	public void setKhmc(String khmc) {
		this.khmc = khmc;
	}
	public void setQxr(String qxr) {
		this.qxr = qxr;
	}
	public void setJxr(String jxr) {
		this.jxr = jxr;
	}
	public void setBsrgh(String bsrgh) {
		this.bsrgh = bsrgh;
	}
	public void setQx(BigDecimal qx) {
		this.qx = qx;
	}
	public void setLrr(String lrr) {
		this.lrr = lrr;
	}
	public void setLrsj(String lrsj) {
		this.lrsj = lrsj;
	}
	public void setLrbz(int lrbz) {
		this.lrbz = lrbz;
	}
	 
}
