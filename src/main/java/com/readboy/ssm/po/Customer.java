package com.readboy.ssm.po;

/**
 * 客户信息，对应表 app_mycust
 * @author Administrator
 *@description:组织简称请放在最后，不要动字段定义的位置
 */
public class Customer {
	private String jgdm;			//机构代码
	private String khbh;			//客户编号
	private String khmc;			//客户名称
	private String zjhm;			//证件号码
	private String zz;				//住址
	private String cpxx;			//产品信息
	private String ssdj;			//所属等级
	private String sjhm;			//手机号码
	private String ghrgh;			//管户人工号
	private String ghrxm;			//管户人姓名
	private int khlx;				//客户类型
	private String zzjc;			//组织简称
	
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
	public String getZjhm() {
		return zjhm;
	}
	public String getZz() {
		return zz;
	}
	public String getCpxx() {
		return cpxx;
	}
	public String getSsdj() {
		return ssdj;
	}
	public String getSjhm() {
		return sjhm;
	}
	public String getGhrgh() {
		return ghrgh;
	}
	public String getGhrxm() {
		return ghrxm;
	}
	public int getKhlx() {
		return khlx;
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
	public void setZjhm(String zjhm) {
		this.zjhm = zjhm;
	}
	public void setZz(String zz) {
		this.zz = zz;
	}
	public void setCpxx(String cpxx) {
		this.cpxx = cpxx;
	}
	public void setSsdj(String ssdj) {
		this.ssdj = ssdj;
	}
	public void setSjhm(String sjhm) {
		this.sjhm = sjhm;
	}
	public void setGhrgh(String ghrgh) {
		this.ghrgh = ghrgh;
	}
	public void setGhrxm(String ghrxm) {
		this.ghrxm = ghrxm;
	}
	public void setKhlx(int khlx) {
		this.khlx = khlx;
	}
	
}
