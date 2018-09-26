package com.readboy.ssm.po;

import java.math.BigDecimal;

/**
 * app_dkkhcpxx 贷款客户产品信息
 * @author Administrator
 *
 */
public class LoanCustomerProduct {
	private String cpmc;			//产品名称
	private String jgdm;			//机构代码
	private String zzjc;			//组织简称
	private String khbh;			//客户编号
	private String hth;				//合同号
	private String dkzh;			//贷款账号
	private String ffrq;			//发放日期
	private String dqrq;			//到期日期
	private BigDecimal dkje;		//贷款金额
	private BigDecimal dkye;		//贷款余额
	private BigDecimal ll;			//利率
	private String khjlmc;			//客户经理名称
	private int five_class_type;	//五级分类
	private String yxr;				//营销人
	private BigDecimal yxbl;		//营销比例
	private String ghr;				//管户人
	private BigDecimal ghbl;		//管护比例
	private String bsr;				//保守人
	private BigDecimal bsbl;		//包收比例
	private String spr;				//审批人
	private BigDecimal spbl;		//审批比例
	private String dcr;				//调查人
	private BigDecimal dcbl;		//调查比例
	private String lrr;				//录入人
	private int lrbz;				//录入标志
	private String lrsj;			//录入时间
	
	public String getZzjc() {
		return zzjc;
	}
	public void setZzjc(String zzjc) {
		this.zzjc = zzjc;
	}
	public String getCpmc() {
		return cpmc;
	}
	public String getJgdm() {
		return jgdm;
	}
	public String getKhbh() {
		return khbh;
	}
	public String getHth() {
		return hth;
	}
	public String getDkzh() {
		return dkzh;
	}
	public String getFfrq() {
		if(ffrq !=null  && ffrq.length() > 10){
			return ffrq.substring(0,10);
		}
		return ffrq;
	}
	public String getDqrq() {
		if(dqrq !=null  && dqrq.length() > 10){
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
	public String getKhjlmc() {
		return khjlmc;
	}
	public int getFive_class_type() {
		return five_class_type;
	}
	public String getYxr() {
		return yxr;
	}
	public BigDecimal getYxbl() {
		return yxbl;
	}
	public String getGhr() {
		return ghr;
	}
	public BigDecimal getGhbl() {
		return ghbl;
	}
	public String getBsr() {
		return bsr;
	}
	public BigDecimal getBsbl() {
		return bsbl;
	}
	public String getSpr() {
		return spr;
	}
	public BigDecimal getSpbl() {
		return spbl;
	}
	public String getDcr() {
		return dcr;
	}
	public BigDecimal getDcbl() {
		return dcbl;
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
	public void setCpmc(String cpmc) {
		this.cpmc = cpmc;
	}
	public void setJgdm(String jgdm) {
		this.jgdm = jgdm;
	}
	public void setKhbh(String khbh) {
		this.khbh = khbh;
	}
	public void setHth(String hth) {
		this.hth = hth;
	}
	public void setDkzh(String dkzh) {
		this.dkzh = dkzh;
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
	public void setKhjlmc(String khjlmc) {
		this.khjlmc = khjlmc;
	}
	public void setFive_class_type(int five_class_type) {
		this.five_class_type = five_class_type;
	}
	public void setYxr(String yxr) {
		this.yxr = yxr;
	}
	public void setYxbl(BigDecimal yxbl) {
		this.yxbl = yxbl;
	}
	public void setGhr(String ghr) {
		this.ghr = ghr;
	}
	public void setGhbl(BigDecimal ghbl) {
		this.ghbl = ghbl;
	}
	public void setBsr(String bsr) {
		this.bsr = bsr;
	}
	public void setBsbl(BigDecimal bsbl) {
		this.bsbl = bsbl;
	}
	public void setSpr(String spr) {
		this.spr = spr;
	}
	public void setSpbl(BigDecimal spbl) {
		this.spbl = spbl;
	}
	public void setDcr(String dcr) {
		this.dcr = dcr;
	}
	public void setDcbl(BigDecimal dcbl) {
		this.dcbl = dcbl;
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
