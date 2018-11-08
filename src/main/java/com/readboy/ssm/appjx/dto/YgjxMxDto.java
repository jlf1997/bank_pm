package com.readboy.ssm.appjx.dto;

import java.math.BigDecimal;

import javax.persistence.Id;

public class YgjxMxDto {

	private String zzbz;			//组织标识
	private String gzrq;			//工资日期
	private String zbmc;			//指标名称，从表erp_bas_zbk中获取
	private BigDecimal zbdj;		//指标单价
	private BigDecimal zbjg;		//指标结果
	private BigDecimal zbgz;		//指标工资
	private Integer gwbz;				//岗位标志
	private String yggh;			//员工工号
	private Integer zblb;				//指标类别
	private String khwd;			//考核维度
	private Integer lrbz;				//录入标志
	private String lrr;				//录入人
	private String lrsj;			//录入时间
}
