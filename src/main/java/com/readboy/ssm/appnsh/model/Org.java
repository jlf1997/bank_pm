package com.readboy.ssm.appnsh.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="hr_bas_organization")
@Entity
public class Org {
	@Id
	private String zzbz;		//组织标志
	private String zzmc;		//组织名称
	private Integer zzlb;			//组织类别
	private Integer zzjb;			//组织级别
	private Integer qybz;			//启用标志
	private String sjzzbz;		//上级组织标志
	private String zzjc;		//组织简称
	private String ywjgdm;		//业务机构代码
	private String bbqxjgdm;	//报表权限机构代码
	private Integer ywjglx;			//业务机构类型
	private Integer ywjgxz;			//业务机构性质
	private Integer ywjgbz;			//业务机构标志
	private Double pxxh;		//排序序号
	private String szqy;		//所在区域
	public String getZzbz() {
		return zzbz;
	}
	public void setZzbz(String zzbz) {
		this.zzbz = zzbz;
	}
	public String getZzmc() {
		return zzmc;
	}
	public void setZzmc(String zzmc) {
		this.zzmc = zzmc;
	}
	public Integer getZzlb() {
		return zzlb;
	}
	public void setZzlb(Integer zzlb) {
		this.zzlb = zzlb;
	}
	public Integer getZzjb() {
		return zzjb;
	}
	public void setZzjb(Integer zzjb) {
		this.zzjb = zzjb;
	}
	public Integer getQybz() {
		return qybz;
	}
	public void setQybz(Integer qybz) {
		this.qybz = qybz;
	}
	public String getSjzzbz() {
		return sjzzbz;
	}
	public void setSjzzbz(String sjzzbz) {
		this.sjzzbz = sjzzbz;
	}
	public String getZzjc() {
		return zzjc;
	}
	public void setZzjc(String zzjc) {
		this.zzjc = zzjc;
	}
	public String getYwjgdm() {
		return ywjgdm;
	}
	public void setYwjgdm(String ywjgdm) {
		this.ywjgdm = ywjgdm;
	}
	public String getBbqxjgdm() {
		return bbqxjgdm;
	}
	public void setBbqxjgdm(String bbqxjgdm) {
		this.bbqxjgdm = bbqxjgdm;
	}
	public Integer getYwjglx() {
		return ywjglx;
	}
	public void setYwjglx(Integer ywjglx) {
		this.ywjglx = ywjglx;
	}
	public Integer getYwjgxz() {
		return ywjgxz;
	}
	public void setYwjgxz(Integer ywjgxz) {
		this.ywjgxz = ywjgxz;
	}
	public Integer getYwjgbz() {
		return ywjgbz;
	}
	public void setYwjgbz(Integer ywjgbz) {
		this.ywjgbz = ywjgbz;
	}
	public Double getPxxh() {
		return pxxh;
	}
	public void setPxxh(Double pxxh) {
		this.pxxh = pxxh;
	}
	public String getSzqy() {
		return szqy;
	}
	public void setSzqy(String szqy) {
		this.szqy = szqy;
	}

	
	
	
}
