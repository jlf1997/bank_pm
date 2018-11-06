package com.readboy.ssm.appnsh.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 存款大客户
 * @author Administrator
 *
 */
@Table(name="TB_TJFX_CKDKH")
@Entity
public class TB_TJFX_CKDKH {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String yggh;//员工工号
	private String jgdm;//机构代码
	private String khmc;//客户名称
	private String lxfs;//联系方式
	private BigDecimal ckye;//存款余额
	private Date zzkhrq;//最早开户日期
	private String dz;//地址
	private Integer khlx;//客户类型
	private Integer lrbz;//录入标识
	private Date lrsj;//录入时间
	private String lrr;//录入人
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getYggh() {
		return yggh;
	}
	public void setYggh(String yggh) {
		this.yggh = yggh;
	}
	public String getJgdm() {
		return jgdm;
	}
	public void setJgdm(String jgdm) {
		this.jgdm = jgdm;
	}
	public String getKhmc() {
		return khmc;
	}
	public void setKhmc(String khmc) {
		this.khmc = khmc;
	}
	public String getLxfs() {
		return lxfs;
	}
	public void setLxfs(String lxfs) {
		this.lxfs = lxfs;
	}
	public BigDecimal getCkye() {
		return ckye;
	}
	public void setCkye(BigDecimal ckye) {
		this.ckye = ckye;
	}
	public Date getZzkhrq() {
		return zzkhrq;
	}
	public void setZzkhrq(Date zzkhrq) {
		this.zzkhrq = zzkhrq;
	}
	public String getDz() {
		return dz;
	}
	public void setDz(String dz) {
		this.dz = dz;
	}
	public Integer getKhlx() {
		return khlx;
	}
	public void setKhlx(Integer khlx) {
		this.khlx = khlx;
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
	public String getLrr() {
		return lrr;
	}
	public void setLrr(String lrr) {
		this.lrr = lrr;
	}
	
	
}
