package com.readboy.ssm.po;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import com.readboy.ssm.appjx.model.JXPK;
/**
 * 业绩工资首页，对应数据库表erp_wage_ygjx
 * 2017-06-21
 */
@Entity
@Table(name = "erp_wage_ygjx")
@IdClass(JXPK.class)
public class Performance {
	
	@Id
	private String zzbz;			//组织标识
	@Id
	private String gzrq;			//工资日期
	private BigDecimal ckgz;		//存款工资
	private BigDecimal dkgz;		//贷款工资
	private BigDecimal dzyhgz;		//电子银行工资
	private BigDecimal ywlgz;		//业务量工资
	private BigDecimal gljxgz;		//管理绩效工资
	private BigDecimal dqbcgz;		//地区补差工资
	private BigDecimal gzhj;		//工资合计
	@Id
	private Integer gwbz;				//岗位标志
	@Id
	private String yggh;			//员工工号
	private Integer zhgzpm;				//支行工资排名
	private Integer qhgzpm;				//全行工资排名
	@Id
	private String khwd;			//考核维度
	private Integer lrbz;				//录入标志
	private String lrr;				//录入人
	private String lrsj;			//录入时间
	private BigDecimal qt;			//其他
	private BigDecimal jymbgz;		//经营目标工资
	private BigDecimal yqdfgz;		//延期兑付工资
	
	
	public String getGzrq() {
		if(gzrq !=null  && gzrq.length() > 10){
			return gzrq.substring(0,10);
		}
		return gzrq;
	}


	public String getZzbz() {
		return zzbz;
	}


	public void setZzbz(String zzbz) {
		this.zzbz = zzbz;
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


	public Integer getGwbz() {
		return gwbz;
	}


	public void setGwbz(Integer gwbz) {
		this.gwbz = gwbz;
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


	public Integer getLrbz() {
		return lrbz;
	}


	public void setLrbz(Integer lrbz) {
		this.lrbz = lrbz;
	}


	public String getLrr() {
		return lrr;
	}


	public void setLrr(String lrr) {
		this.lrr = lrr;
	}


	public String getLrsj() {
		return lrsj;
	}


	public void setLrsj(String lrsj) {
		this.lrsj = lrsj;
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


	public void setGzrq(String gzrq) {
		this.gzrq = gzrq;
	}
	
	
	
}
