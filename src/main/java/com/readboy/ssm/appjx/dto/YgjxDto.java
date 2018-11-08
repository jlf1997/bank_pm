package com.readboy.ssm.appjx.dto;

import java.math.BigDecimal;

import javax.persistence.Id;

/**
 * 员工绩效dto
 * @author Administrator
 *
 */
public class YgjxDto {
	
	private BigDecimal dygz;//当月工资
	
	private BigDecimal drgz;//当日工资
	
	private BigDecimal gzzf;//对比上日工资增幅
	
	

	private BigDecimal ckgz;		//存款工资
	private BigDecimal dkgz;		//贷款工资
	private BigDecimal dzyhgz;		//电子银行工资
	private BigDecimal ywlgz;		//业务量工资
	private BigDecimal gljxgz;		//管理绩效工资
	private BigDecimal dqbcgz;		//地区补差工资
	private BigDecimal gzhj;		//工资合计
	@Id
	private String yggh;			//员工工号
	private Integer zhgzpm;				//支行工资排名
	private Integer qhgzpm;				//全行工资排名
	@Id
	private String khwd;			//考核维度
	private BigDecimal qt;			//其他
	private BigDecimal jymbgz;		//经营目标工资
	private BigDecimal yqdfgz;		//延期兑付工资
	public BigDecimal getDygz() {
		return dygz;
	}
	public void setDygz(BigDecimal dygz) {
		this.dygz = dygz;
	}
	public BigDecimal getDrgz() {
		return drgz;
	}
	public void setDrgz(BigDecimal drgz) {
		this.drgz = drgz;
	}
	public BigDecimal getGzzf() {
		return gzzf;
	}
	public void setGzzf(BigDecimal gzzf) {
		this.gzzf = gzzf;
	}
	public BigDecimal getCkgz() {
		return ckgz;
	}
	public void setCkgz(BigDecimal ckgz) {
		this.ckgz = ckgz;
	}
	public BigDecimal getDkgz() {
		return dkgz;
	}
	public void setDkgz(BigDecimal dkgz) {
		this.dkgz = dkgz;
	}
	public BigDecimal getDzyhgz() {
		return dzyhgz;
	}
	public void setDzyhgz(BigDecimal dzyhgz) {
		this.dzyhgz = dzyhgz;
	}
	public BigDecimal getYwlgz() {
		return ywlgz;
	}
	public void setYwlgz(BigDecimal ywlgz) {
		this.ywlgz = ywlgz;
	}
	public BigDecimal getGljxgz() {
		return gljxgz;
	}
	public void setGljxgz(BigDecimal gljxgz) {
		this.gljxgz = gljxgz;
	}
	public BigDecimal getDqbcgz() {
		return dqbcgz;
	}
	public void setDqbcgz(BigDecimal dqbcgz) {
		this.dqbcgz = dqbcgz;
	}
	public BigDecimal getGzhj() {
		return gzhj;
	}
	public void setGzhj(BigDecimal gzhj) {
		this.gzhj = gzhj;
	}
	public String getYggh() {
		return yggh;
	}
	public void setYggh(String yggh) {
		this.yggh = yggh;
	}
	public Integer getZhgzpm() {
		return zhgzpm;
	}
	public void setZhgzpm(Integer zhgzpm) {
		this.zhgzpm = zhgzpm;
	}
	public Integer getQhgzpm() {
		return qhgzpm;
	}
	public void setQhgzpm(Integer qhgzpm) {
		this.qhgzpm = qhgzpm;
	}
	public String getKhwd() {
		return khwd;
	}
	public void setKhwd(String khwd) {
		this.khwd = khwd;
	}
	public BigDecimal getQt() {
		return qt;
	}
	public void setQt(BigDecimal qt) {
		this.qt = qt;
	}
	public BigDecimal getJymbgz() {
		return jymbgz;
	}
	public void setJymbgz(BigDecimal jymbgz) {
		this.jymbgz = jymbgz;
	}
	public BigDecimal getYqdfgz() {
		return yqdfgz;
	}
	public void setYqdfgz(BigDecimal yqdfgz) {
		this.yqdfgz = yqdfgz;
	}
	
	
}
