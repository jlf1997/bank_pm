package com.readboy.ssm.appnsh.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="tb_tjfx_cdzl")
@Entity
public class TB_TJFX_CDZL {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long ckzlid;
	
	private Date tjrq;
	
	private Integer ckhs;
	
	private Integer dkhs;
	
	private BigDecimal dkze;
	
	//存款总额
	private BigDecimal ckze;
	
	private Integer jbywbs;
	
	private BigDecimal jbxjll;
	
	private Integer lrbz;
	
	private Date lrsj;
	
	private String lrr;
	
	private String yggh;

	public Long getCkzlid() {
		return ckzlid;
	}

	public void setCkzlid(Long ckzlid) {
		this.ckzlid = ckzlid;
	}

	public Date getTjrq() {
		return tjrq;
	}

	public void setTjrq(Date tjrq) {
		this.tjrq = tjrq;
	}

	public Integer getCkhs() {
		return ckhs;
	}

	public void setCkhs(Integer ckhs) {
		this.ckhs = ckhs;
	}

	public Integer getDkhs() {
		return dkhs;
	}

	public void setDkhs(Integer dkhs) {
		this.dkhs = dkhs;
	}

	public BigDecimal getDkze() {
		return dkze;
	}

	public void setDkze(BigDecimal dkze) {
		this.dkze = dkze;
	}

	public BigDecimal getCkze() {
		return ckze;
	}

	public void setCkze(BigDecimal ckze) {
		this.ckze = ckze;
	}

	public Integer getJbywbs() {
		return jbywbs;
	}

	public void setJbywbs(Integer jbywbs) {
		this.jbywbs = jbywbs;
	}

	public BigDecimal getJbxjll() {
		return jbxjll;
	}

	public void setJbxjll(BigDecimal jbxjll) {
		this.jbxjll = jbxjll;
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

	public String getYggh() {
		return yggh;
	}

	public void setYggh(String yggh) {
		this.yggh = yggh;
	}

	
	

	
	
	
	
}
