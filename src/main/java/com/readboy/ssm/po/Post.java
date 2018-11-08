package com.readboy.ssm.po;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author:	   	LCL
 * @date: 	   	2017-7-7
 * @description:岗位名称，对于数据库表hr_bas_post
 */
@Entity
@Table(name = "hr_bas_post")
public class Post {
	@Id
	private Long gwbz;			//岗位标志
	private String gwmc;		//岗位名称
	private Integer sfqy;			//是否启用
	private Integer gwxz;			//岗位性质
	public Long getGwbz() {
		return gwbz;
	}
	public void setGwbz(Long gwbz) {
		this.gwbz = gwbz;
	}
	public String getGwmc() {
		return gwmc;
	}
	public void setGwmc(String gwmc) {
		this.gwmc = gwmc;
	}
	public Integer getSfqy() {
		return sfqy;
	}
	public void setSfqy(Integer sfqy) {
		this.sfqy = sfqy;
	}
	public Integer getGwxz() {
		return gwxz;
	}
	public void setGwxz(Integer gwxz) {
		this.gwxz = gwxz;
	}
	
	
}
