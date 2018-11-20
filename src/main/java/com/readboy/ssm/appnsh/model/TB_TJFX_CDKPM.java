package com.readboy.ssm.appnsh.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * 存贷金额排名
 * @author Administrator
 *
 */
@Table(name="tb_tjfx_cdkpm")
@Entity
public class TB_TJFX_CDKPM {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String yggh	;//员工工号
	private String khmc	;//客户名称
	private BigDecimal je	;//金额
	private Integer pm	;//排名
	private Integer ywlx	;//业务类型
	private Integer lrbz	;//录入标识
	private Date lrsj	;//录入时间
	private String lrr	;//录入人
	private String lxfs	;//联系方式
	private String dz	;//地址
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
	public String getKhmc() {
		return khmc;
	}
	public void setKhmc(String khmc) {
		this.khmc = khmc;
	}
	public BigDecimal getJe() {
		return je;
	}
	public void setJe(BigDecimal je) {
		this.je = je;
	}
	public Integer getPm() {
		return pm;
	}
	public void setPm(Integer pm) {
		this.pm = pm;
	}
	public Integer getYwlx() {
		return ywlx;
	}
	public void setYwlx(Integer ywlx) {
		this.ywlx = ywlx;
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
	
	
}
