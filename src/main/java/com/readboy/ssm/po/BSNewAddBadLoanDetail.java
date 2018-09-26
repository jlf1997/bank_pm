package com.readboy.ssm.po;

import java.math.BigDecimal;

/*
 * 包收新增不良贷款明细,对应数据库表:khgxgl_bsxzbldkmx 
 */

public class BSNewAddBadLoanDetail {
	private String tjyf;		//统计月份
	private String khbh ;		//客户编号
	private String khmc ;		//客户名称
	private String dkzh;		//贷款账号
	private String hth ;		//合同号
	private String jgdm;		//机构代码
	private String bsrgh;		//包收人工号
	private String ffrq;		//发放日期
	private String dqrq;		//到期日期
	private BigDecimal dkje;	//贷款金额
	private BigDecimal dkye;	//贷款余额
	private BigDecimal ll;		//利率
	private String ncwjfl;		//年初五级分类
	private String qmwjfl;		//期末五级分类
	private String lrr;			//录入人
	private int lrbz;			//录入标志
	private String lrsj;		//录入时间
	public String getTjyf() {
		return tjyf;
	}
	public String getKhbh() {
		return khbh;
	}
	public String getKhmc() {
		return khmc;
	}
	public String getDkzh() {
		return dkzh;
	}
	public String getHth() {
		return hth;
	}
	public String getJgdm() {
		return jgdm;
	}
	public String getBsrgh() {
		return bsrgh;
	}
	public String getFfrq() {
		if(ffrq != null && ffrq.length() > 10){
			return ffrq.substring(0,10);
		}
		return ffrq;
	}
	public String getDqrq() {
		if(dqrq != null && dqrq.length() > 10){
			return dqrq.substring(0,10);
		}
		return dqrq;
	}
	public BigDecimal getDkje() {
		return dkje;
	}
	public BigDecimal getDkye() {
		return dkye;
	}
	public BigDecimal getLl() {
		return ll;
	}
	public String getNcwjfl() {
		return ncwjfl;
	}
	public String getQmwjfl() {
		return qmwjfl;
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
	public void setTjyf(String tjyf) {
		this.tjyf = tjyf;
	}
	public void setKhbh(String khbh) {
		this.khbh = khbh;
	}
	public void setKhmc(String khmc) {
		this.khmc = khmc;
	}
	public void setDkzh(String dkzh) {
		this.dkzh = dkzh;
	}
	public void setHth(String hth) {
		this.hth = hth;
	}
	public void setJgdm(String jgdm) {
		this.jgdm = jgdm;
	}
	public void setBsrgh(String bsrgh) {
		this.bsrgh = bsrgh;
	}
	public void setFfrq(String ffrq) {
		this.ffrq = ffrq;
	}
	public void setDqrq(String dqrq) {
		this.dqrq = dqrq;
	}
	public void setDkje(BigDecimal dkje) {
		this.dkje = dkje;
	}
	public void setDkye(BigDecimal dkye) {
		this.dkye = dkye;
	}
	public void setLl(BigDecimal ll) {
		this.ll = ll;
	}
	public void setNcwjfl(String ncwjfl) {
		this.ncwjfl = ncwjfl;
	}
	public void setQmwjfl(String qmwjfl) {
		this.qmwjfl = qmwjfl;
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
