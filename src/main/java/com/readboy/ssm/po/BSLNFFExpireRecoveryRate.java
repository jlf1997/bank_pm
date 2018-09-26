package com.readboy.ssm.po;

import java.math.BigDecimal;

/*
 * 包收历年发放当年到期收回率，对应数据库表:khgxgl_bslnffdndqshl
 * */
public class BSLNFFExpireRecoveryRate {
	
	private String bsrgh;		//包收人工号
	private String  nd;			//年度
	private BigDecimal dqje;	//到期金额
	private BigDecimal qmje;	//期末金额
	private BigDecimal hsl;		//回收率
	private String lrr;			//录入人
	private int lrbz;			//录入标志
	private String lrsj ;		//录入时间
	public String getBsrgh() {
		return bsrgh;
	}
	public String getNd() {
		return nd;
	}
	public BigDecimal getDqje() {
		return dqje;
	}
	public BigDecimal getQmje() {
		return qmje;
	}
	public BigDecimal getHsl() {
		return hsl;
	}
	public String getLrr() {
		return lrr;
	}
	public int getLrbz() {
		return lrbz;
	}
	public String getLrsj() {
		return lrsj;
	}
	public void setBsrgh(String bsrgh) {
		this.bsrgh = bsrgh;
	}
	public void setNd(String nd) {
		this.nd = nd;
	}
	public void setDqje(BigDecimal dqje) {
		this.dqje = dqje;
	}
	public void setQmje(BigDecimal qmje) {
		this.qmje = qmje;
	}
	public void setHsl(BigDecimal hsl) {
		this.hsl = hsl;
	}
	public void setLrr(String lrr) {
		this.lrr = lrr;
	}
	public void setLrbz(int lrbz) {
		this.lrbz = lrbz;
	}
	public void setLrsj(String lrsj) {
		this.lrsj = lrsj;
	}
}
