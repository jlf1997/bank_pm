package com.readboy.ssm.po;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author:	   	LCL
 * @date: 	   	2017-7-7
 * @description:综合户类，对应数据库表hr_bas_staff_post.
 */
@Table(name="hr_bas_staff_post")
@Entity
public class StaffAndPost {
	
	private String zzbz;		//组织标志
	private String yggh;		//员工工号
	private Long gwbz;			//岗位标志
	private Integer rglx;		//入岗类型
	private String rgrq;		//入岗日期
	private String lgrq;		//离岗日期
	private String khjlbz;		//客户经理标志
	private String gyh;			//柜员号
	private String bz;			//备注
	private Integer scbz;			//删除标志
	private String scsj;		//删除时间
	private String scczy;		//删除操作员
	@Id
	private Long id;			//ID,主键
	private Integer sfcykh;			//是否参与考核
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
	public String getZzbz() {
		return zzbz;
	}
	public void setZzbz(String zzbz) {
		this.zzbz = zzbz;
	}
	public String getYggh() {
		return yggh;
	}
	public void setYggh(String yggh) {
		this.yggh = yggh;
	}
	public Long getGwbz() {
		return gwbz;
	}
	public void setGwbz(Long gwbz) {
		this.gwbz = gwbz;
	}
	public Integer getRglx() {
		return rglx;
	}
	public void setRglx(Integer rglx) {
		this.rglx = rglx;
	}
	public String getGyh() {
		return gyh;
	}
	public void setGyh(String gyh) {
		this.gyh = gyh;
	}
	public String getBz() {
		return bz;
	}
	public void setBz(String bz) {
		this.bz = bz;
	}
	public Integer getScbz() {
		return scbz;
	}
	public void setScbz(Integer scbz) {
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
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getSfcykh() {
		return sfcykh;
	}
	public void setSfcykh(Integer sfcykh) {
		this.sfcykh = sfcykh;
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
	
	
}
