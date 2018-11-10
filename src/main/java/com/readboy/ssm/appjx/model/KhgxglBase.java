package com.readboy.ssm.appjx.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.Size;

import com.readboy.ssm.controller.validation.MarketingValidationGroup;


@MappedSuperclass
public class KhgxglBase {

		private String jgdm;			//机构代码
		private Integer zjlb; 			//证件类别
		private String zjhm; 			//证件号码
		private String khmc; 			//客户名称
		private String sjhm;			//手机号码
		private BigDecimal yxbl; 		//营销比例
		private Integer sbzt; 				//申报状态
		private String lrr;				//录入人
		private Integer lrbz; 				//录入标志
		private Date lrsj; 		//录入时间
		private Date yyrq;			//预约日期
		@Id
		private Long yybh; 				//预约编号,主键
		private String yggh; 			//员工工号
		private String ygxm; 			//员工姓名
		public String getJgdm() {
			return jgdm;
		}
		public void setJgdm(String jgdm) {
			this.jgdm = jgdm;
		}
		public Integer getZjlb() {
			return zjlb;
		}
		public void setZjlb(Integer zjlb) {
			this.zjlb = zjlb;
		}
		public String getZjhm() {
			return zjhm;
		}
		public void setZjhm(String zjhm) {
			this.zjhm = zjhm;
		}
		public String getKhmc() {
			return khmc;
		}
		public void setKhmc(String khmc) {
			this.khmc = khmc;
		}
		public String getSjhm() {
			return sjhm;
		}
		public void setSjhm(String sjhm) {
			this.sjhm = sjhm;
		}
		public BigDecimal getYxbl() {
			return yxbl;
		}
		public void setYxbl(BigDecimal yxbl) {
			this.yxbl = yxbl;
		}
		public Integer getSbzt() {
			return sbzt;
		}
		public void setSbzt(Integer sbzt) {
			this.sbzt = sbzt;
		}
		public String getLrr() {
			return lrr;
		}
		public void setLrr(String lrr) {
			this.lrr = lrr;
		}
		public Integer getLrbz() {
			return lrbz;
		}
		public void setLrbz(Integer lrbz) {
			this.lrbz = lrbz;
		}
		public Date getLrsj() {
			return lrsj;
		}
		public void setLrsj(Date lrsj) {
			this.lrsj = lrsj;
		}
		public Date getYyrq() {
			return yyrq;
		}
		public void setYyrq(Date yyrq) {
			this.yyrq = yyrq;
		}
		public Long getYybh() {
			return yybh;
		}
		public void setYybh(Long yybh) {
			this.yybh = yybh;
		}
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
		
		
}
