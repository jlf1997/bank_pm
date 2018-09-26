package com.readboy.ssm.po;

/**
 * 员工信息，对应表 hr_bas_staff
 * @author Administrator
 *
 */
public class Staff {
	private String yggh;	//员工工号
	private String ygxm;	//员工姓名
	private int yglx;		//员工类型
	private int ygzt;		//员工状态
	private int xb;			//性别
	private String sfzh;	//身份证号
	private String sjhm;	//手机号码
	private String gzkh;	//工资卡号
	private String rzrq;	//入职日期
	private String zzrq;	//转正日期
	private String lzrq;	//离职日期
	private int scbz;		//删除标志
	private String scsj;	//删除时间
	private String scczy;	//删除操作员
	private String gyh;		//柜员号
	private String khjlbh;	//客户经理编号
	public String getYggh() {
		return yggh;
	}
	public void setYggh(String yggh) {
		this.yggh = yggh;
	}
	public String getYgxm() {
		return ygxm;
	}
	public void setYgxm(String ygxm) {
		this.ygxm = ygxm;
	}
	public int getYglx() {
		return yglx;
	}
	public void setYglx(int yglx) {
		this.yglx = yglx;
	}
	public int getYgzt() {
		return ygzt;
	}
	public void setYgzt(int ygzt) {
		this.ygzt = ygzt;
	}
	public int getXb() {
		return xb;
	}
	public void setXb(int xb) {
		this.xb = xb;
	}
	public String getSfzh() {
		return sfzh;
	}
	public void setSfzh(String sfzh) {
		this.sfzh = sfzh;
	}
	public String getSjhm() {
		return sjhm;
	}
	public void setSjhm(String sjhm) {
		this.sjhm = sjhm;
	}
	public String getGzkh() {
		return gzkh;
	}
	public void setGzkh(String gzkh) {
		this.gzkh = gzkh;
	}
	public String getRzrq() {
		if(rzrq != null && rzrq.length() > 10){
			return rzrq.substring(0,10);
		}
		return rzrq;
	}
	public void setRzrq(String rzrq) {
		this.rzrq = rzrq;
	}
	public String getZzrq() {
		if(zzrq != null && zzrq.length() > 10){
			return zzrq.substring(0,10);
		}
		return zzrq;
	}
	public void setZzrq(String zzrq) {
		this.zzrq = zzrq;
	}
	public String getLzrq() {
		if(lzrq != null && lzrq.length() > 10){
			return lzrq.substring(0,10);
		}
		return lzrq;
	}
	public void setLzrq(String lzrq) {
		this.lzrq = lzrq;
	}
	public int getScbz() {
		return scbz;
	}
	public void setScbz(int scbz) {
		this.scbz = scbz;
	}
	public String getScsj() {
		return scsj;
	}
	public void setScsj(String scsj) {
		this.scsj = scsj;
	}
	public String getScczy() {
		return scczy;
	}
	public void setScczy(String scczy) {
		this.scczy = scczy;
	}
	public String getGyh() {
		return gyh;
	}
	public void setGyh(String gyh) {
		this.gyh = gyh;
	}
	public String getKhjlbh() {
		return khjlbh;
	}
	public void setKhjlbh(String khjlbh) {
		this.khjlbh = khjlbh;
	}
	
	
}
