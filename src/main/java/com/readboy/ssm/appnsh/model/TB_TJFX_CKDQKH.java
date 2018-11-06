package com.readboy.ssm.appnsh.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * 存款到期客户
 * @author Administrator
 *
 */
@Table(name="TB_TJFX_CKDQKH")
@Entity
public class TB_TJFX_CKDQKH {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String yggh;//员工工号
	private String jgdm;//机构代码
	private String khmc;//客户名称
	private String ckzh;//存款账号
	private BigDecimal ckye;//存款余额
	private Date khrq;//开户日期
	private Date dqrq;//到期日期
	private String lxfs;//联系方式
	private String dz;//地址
	private Integer khlx;//客户类型
	private Integer lrbz;//录入标识
	private Date lrsj;//录入时间
	private String lrr;//录入人
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
	public String getCkzh() {
		return ckzh;
	}
	public void setCkzh(String ckzh) {
		this.ckzh = ckzh;
	}
	public BigDecimal getCkye() {
		return ckye;
	}
	public void setCkye(BigDecimal ckye) {
		this.ckye = ckye;
	}
	public Date getKhrq() {
		return khrq;
	}
	public void setKhrq(Date khrq) {
		this.khrq = khrq;
	}
	public Date getDqrq() {
		return dqrq;
	}
	public void setDqrq(Date dqrq) {
		this.dqrq = dqrq;
	}
	public String getLxfs() {
		return lxfs;
	}
	public void setLxfs(String lxfs) {
		this.lxfs = lxfs;
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
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	
}
