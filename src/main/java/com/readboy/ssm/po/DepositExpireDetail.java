package com.readboy.ssm.po;

import java.math.BigDecimal;

/*存款到期明细表，对应数据库表KHGXGL_TZDQCKDQMX
 * */
public class DepositExpireDetail {
	private String tjyf;		
	private String ckzh;		//存款账号
	private String khbh;		//客户编号
	private String jgdm; 		//机构代码
	private String khmc;  		//客户名称
	private String tzrgh;		//拓展人工号
	private String khrq;		//开户日期
	private String dqrq;		//到期日期
	private BigDecimal ll;    	//利率
	private BigDecimal cq;  	
	private BigDecimal ye;  	//余额
	private String lrr;			//录入人
	private int lrbz;			//录入标志
	private String lrsj;		//录入时间
	
	public String getTjyf() {
		return tjyf;
	}
	public String getCkzh() {
		return ckzh;
	}
	public String getKhbh() {
		return khbh;
	}
	public String getJgdm() {
		return jgdm;
	}
	public String getKhmc() {
		return khmc;
	}
	public String getTzrgh() {
		return tzrgh;
	}
	public String getKhrq() {
		if(khrq != null && khrq.length() > 10){
			return khrq.substring(0,10);
		}
		return khrq;
	}
	public String getDqrq() {
		if(dqrq != null && dqrq.length() > 10){
			return dqrq.substring(0,10);
		}
		return dqrq;
	}
	public BigDecimal getLl() {
		return ll;
	}
	public BigDecimal getCq() {
		return cq;
	}
	public BigDecimal getYe() {
		return ye;
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
	public void setCkzh(String ckzh) {
		this.ckzh = ckzh;
	}
	public void setKhbh(String khbh) {
		this.khbh = khbh;
	}
	public void setJgdm(String jgdm) {
		this.jgdm = jgdm;
	}
	public void setKhmc(String khmc) {
		this.khmc = khmc;
	}
	public void setTzrgh(String tzrgh) {
		this.tzrgh = tzrgh;
	}
	public void setKhrq(String khrq) {
		this.khrq = khrq;
	}
	public void setDqrq(String dqrq) {
		this.dqrq = dqrq;
	}
	public void setLl(BigDecimal ll) {
		this.ll = ll;
	}
	public void setCq(BigDecimal cq) {
		this.cq = cq;
	}
	public void setYe(BigDecimal ye) {
		this.ye = ye;
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
