package com.readboy.ssm.po;

import java.util.List;

public class SimpleCustomerInfo {
	private String zzjc;
	private String khbh;
	private String khmc;
	private String sjhm;
	private List<String> cpxx;
	private String zz;
	public String getZzjc() {
		return zzjc;
	}
	public String getKhbh() {
		return khbh;
	}
	public String getKhmc() {
		return khmc;
	}
	public String getSjhm() {
		return sjhm;
	}
	public List<String> getCpxx() {
		return cpxx;
	}
	public String getZz() {
		return zz;
	}
	public void setZzjc(String zzjc) {
		this.zzjc = zzjc;
	}
	public void setKhbh(String khbh) {
		this.khbh = khbh;
	}
	public void setKhmc(String khmc) {
		this.khmc = khmc;
	}
	public void setSjhm(String sjhm) {
		this.sjhm = sjhm;
	}
	public void setCpxx(List<String> cpxx) {
		this.cpxx = cpxx;
	}
	public void setZz(String zz) {
		this.zz = zz;
	}
}
