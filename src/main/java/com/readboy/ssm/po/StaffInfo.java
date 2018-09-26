package com.readboy.ssm.po;

public class StaffInfo {
	//PC端员工绩效汇总要显示下面的内容
	private String zzjc;	//组织名称,根据zzb
	private String gwmc;	//岗位名称，根据gwbz
	private String ygxm;	//员工姓名，根据yggh
	
	public String getZzjc() {
		return zzjc;
	}
	public String getGwmc() {
		return gwmc;
	}
	public String getYgxm() {
		return ygxm;
	}
	public void setZzjc(String zzjc) {
		this.zzjc = zzjc;
	}
	public void setGwmc(String gwmc) {
		this.gwmc = gwmc;
	}
	public void setYgxm(String ygxm) {
		this.ygxm = ygxm;
	}
	
}
