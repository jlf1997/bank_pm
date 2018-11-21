package com.readboy.ssm.appjx.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.ConstraintMode;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


/**
 * 机构业绩表
 * @author Administrator
 *
 */
@Table
@Entity(name="erp_assessdata_jg_phjfk")
public class ErpAssessDataJgPhjfk {

	@Id
	@GeneratedValue
	private Long id;
	private String zzbz;//	组织标识
	private BigDecimal khqz;//	考核权重
	
	
	private String khwd;//	考核维度
	
//	@ManyToOne
//	@JoinColumns({
//        // 分别匹配主表联合主键的字段
//		@JoinColumn(name="ZBID",foreignKey= @ForeignKey(value=ConstraintMode.NO_CONSTRAINT,foreignKeyDefinition="none")),
//		@JoinColumn(name="ZBWD",foreignKey= @ForeignKey(value=ConstraintMode.NO_CONSTRAINT,foreignKeyDefinition="none")),
//		@JoinColumn(name="ZBDX",foreignKey= @ForeignKey(value=ConstraintMode.NO_CONSTRAINT,foreignKeyDefinition="none")),
//		@JoinColumn(name="KHFS",foreignKey= @ForeignKey(value=ConstraintMode.NO_CONSTRAINT,foreignKeyDefinition="none"))
//	})
//	private ErpBasZbk erpBasZbk;
	
	
	private String zbid;//	指标ID
	
	private BigDecimal zbqz;//	指标权重
	private BigDecimal zbjg;//	指标结果
	private BigDecimal zbdf;//	指标得分
	private Integer lrbz;//	录入标识
	private Date lrsj;//	录入时间
	private String lrr;//	录入人
	private Date tjrq;//	统计日期
	private BigDecimal zhjzqz;//	支行竞争权重
	private BigDecimal gwjzqz;//	岗位竞争权重
	private BigDecimal zbfz;//	指标分值
	private BigDecimal zbrw;//	指标任务
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getZzbz() {
		return zzbz;
	}
	public void setZzbz(String zzbz) {
		this.zzbz = zzbz;
	}
	public BigDecimal getKhqz() {
		return khqz;
	}
	public void setKhqz(BigDecimal khqz) {
		this.khqz = khqz;
	}
	public BigDecimal getZbqz() {
		return zbqz;
	}
	public void setZbqz(BigDecimal zbqz) {
		this.zbqz = zbqz;
	}
	public BigDecimal getZbjg() {
		return zbjg;
	}
	public void setZbjg(BigDecimal zbjg) {
		this.zbjg = zbjg;
	}
	public BigDecimal getZbdf() {
		return zbdf;
	}
	public void setZbdf(BigDecimal zbdf) {
		this.zbdf = zbdf;
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
	public Date getTjrq() {
		return tjrq;
	}
	public void setTjrq(Date tjrq) {
		this.tjrq = tjrq;
	}
	public BigDecimal getZhjzqz() {
		return zhjzqz;
	}
	public void setZhjzqz(BigDecimal zhjzqz) {
		this.zhjzqz = zhjzqz;
	}
	public BigDecimal getGwjzqz() {
		return gwjzqz;
	}
	public void setGwjzqz(BigDecimal gwjzqz) {
		this.gwjzqz = gwjzqz;
	}
	public BigDecimal getZbfz() {
		return zbfz;
	}
	public void setZbfz(BigDecimal zbfz) {
		this.zbfz = zbfz;
	}
	public BigDecimal getZbrw() {
		return zbrw;
	}
	public void setZbrw(BigDecimal zbrw) {
		this.zbrw = zbrw;
	}
	public String getKhwd() {
		return khwd;
	}
	public void setKhwd(String khwd) {
		this.khwd = khwd;
	}
	public String getZbid() {
		return zbid;
	}
	public void setZbid(String zbid) {
		this.zbid = zbid;
	}

	
	

}
