package com.readboy.ssm.po;

import java.math.BigDecimal;

/**
 * 持有产品中存款信息，对应表 khgxgl_ckzhghxx
 * @author Administrator
 *
 */
public class DepositAccountFamily {
	private String jgdm;
	private String zzjc;
	private String khbh;
	private String khmc;
	private String zjlx;
	private String zjhm;
	private int yxlx;
	private String ckzh;
	private String zhlx;
	private String khrq;
	private String dqrq;
	private BigDecimal ll;
	private BigDecimal ckye;
	private String tzr;
	private String tzrq;
	private BigDecimal dnrlje;
	private int lrbz;
	private String lrr;
	private String lrsj;
	private String cq;
	private String tzbl;
	public String getZzjc() {
		return zzjc;
	}
	public void setZzjc(String zzjc) {
		this.zzjc = zzjc;
	}
	public String getJgdm() {
		return jgdm;
	}
	public String getKhbh() {
		return khbh;
	}
	public String getKhmc() {
		return khmc;
	}
	public String getZjlx() {
		return zjlx;
	}
	public String getZjhm() {
		return zjhm;
	}
	public int getYxlx() {
		return yxlx;
	}
	public String getCkzh() {
		return ckzh;
	}
	public String getZhlx() {
		return zhlx;
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
	public BigDecimal getCkye() {
		return ckye;
	}
	public String getTzr() {
		return tzr;
	}
	public String getTzrq() {
		if(tzrq != null && tzrq.length() > 10){
			return tzrq.substring(0,10);
		}
		return tzrq;
	}
	public BigDecimal getDnrlje() {
		return dnrlje;
	}
	public int getLrbz() {
		return lrbz;
	}
	public String getLrr() {
		return lrr;
	}
	public String getLrsj() {
		return lrsj;
	}
	public String getCq() {
		return cq;
	}
	public String getTzbl() {
		return tzbl;
	}
	public void setJgdm(String jgdm) {
		this.jgdm = jgdm;
	}
	public void setKhbh(String khbh) {
		this.khbh = khbh;
	}
	public void setKhmc(String khmc) {
		this.khmc = khmc;
	}
	public void setZjlx(String zjlx) {
		this.zjlx = zjlx;
	}
	public void setZjhm(String zjhm) {
		this.zjhm = zjhm;
	}
	public void setYxlx(int yxlx) {
		this.yxlx = yxlx;
	}
	public void setCkzh(String ckzh) {
		this.ckzh = ckzh;
	}
	public void setZhlx(String zhlx) {
		this.zhlx = zhlx;
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
	public void setCkye(BigDecimal ckye) {
		this.ckye = ckye;
	}
	public void setTzr(String tzr) {
		this.tzr = tzr;
	}
	public void setTzrq(String tzrq) {
		this.tzrq = tzrq;
	}
	public void setDnrlje(BigDecimal dnrlje) {
		this.dnrlje = dnrlje;
	}
	public void setLrbz(int lrbz) {
		this.lrbz = lrbz;
	}
	public void setLrr(String lrr) {
		this.lrr = lrr;
	}
	public void setLrsj(String lrsj) {
		this.lrsj = lrsj;
	}
	public void setCq(String cq) {
		this.cq = cq;
	}
	public void setTzbl(String tzbl) {
		this.tzbl = tzbl;
	}
	
	
}
