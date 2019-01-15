package com.readboy.ssm.appnsh.dto;

import java.math.BigDecimal;

public class CDZLDto {
	
	private BigDecimal dkze;
	
	//存款总额
	private BigDecimal ckze;
	
	private Integer ckhs;
	
	private Integer dkhs;
	
//	//经办业务笔数
//	private Integer jbywbs;
//	//经办现金流量
//	private BigDecimal jbxjll;

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

//	public Integer getJbywbs() {
//		return jbywbs;
//	}
//
//	public void setJbywbs(Integer jbywbs) {
//		this.jbywbs = jbywbs;
//	}
//
//	public BigDecimal getJbxjll() {
//		return jbxjll;
//	}
//
//	public void setJbxjll(BigDecimal jbxjll) {
//		this.jbxjll = jbxjll;
//	}
	
	
	
}
