package com.readboy.ssm.po;
/**
 * 
 * @author:	   	LCL
 * @date: 	   	2017-7-7
 * @description:综合户类，对应数据库表hr_bas_staff_post.
 */
public class StaffAndPost {
	
	private String zzbz;		//组织标志
	private String yggh;		//员工工号
	private long gwbz;			//岗位标志
	private int rglx;			//入岗类型
	private String rgrq;		//入岗日期
	private String lgrq;		//离岗日期
	private String khjlbz;		//客户经理标志
	private String gyh;			//柜员号
	private String bz;			//备注
	private int scbz;			//删除标志
	private String scsj;		//删除时间
	private String scczy;		//删除操作员
	private long id;			//ID,主键
	private int sfcykh;			//是否参与考核
	public String getZzbz() {
		return zzbz;
	}
	public String getYggh() {
		return yggh;
	}
	public long getGwbz() {
		return gwbz;
	}
	public int getRglx() {
		return rglx;
	}
	public String getRgrq() {
		if(rgrq != null && rgrq.length() > 10){
			return rgrq.substring(0,10);
		}
		return rgrq;
	}
	public String getLgrq() {
		if(lgrq != null && lgrq.length() > 10){
			return lgrq.substring(0,10);
		}
		return lgrq;
	}
	public String getKhjlbz() {
		return khjlbz;
	}
	public String getGyh() {
		return gyh;
	}
	public String getBz() {
		return bz;
	}
	public int getScbz() {
		return scbz;
	}
	public String getScsj() {
		return scsj;
	}
	public String getScczy() {
		return scczy;
	}
	public long getId() {
		return id;
	}
	public int getSfcykh() {
		return sfcykh;
	}
	public void setZzbz(String zzbz) {
		this.zzbz = zzbz;
	}
	public void setYggh(String yggh) {
		this.yggh = yggh;
	}
	public void setGwbz(long gwbz) {
		this.gwbz = gwbz;
	}
	public void setRglx(int rglx) {
		this.rglx = rglx;
	}
	public void setRgrq(String rgrq) {
		this.rgrq = rgrq;
	}
	public void setLgrq(String lgrq) {
		this.lgrq = lgrq;
	}
	public void setKhjlbz(String khjlbz) {
		this.khjlbz = khjlbz;
	}
	public void setGyh(String gyh) {
		this.gyh = gyh;
	}
	public void setBz(String bz) {
		this.bz = bz;
	}
	public void setScbz(int scbz) {
		this.scbz = scbz;
	}
	public void setScsj(String scsj) {
		this.scsj = scsj;
	}
	public void setScczy(String scczy) {
		this.scczy = scczy;
	}
	public void setId(long id) {
		this.id = id;
	}
	public void setSfcykh(int sfcykh) {
		this.sfcykh = sfcykh;
	}
	
}
