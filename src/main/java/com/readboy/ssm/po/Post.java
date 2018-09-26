package com.readboy.ssm.po;
/**
 * 
 * @author:	   	LCL
 * @date: 	   	2017-7-7
 * @description:岗位名称，对于数据库表hr_bas_post
 */
public class Post {
	
	private long gwbz;			//岗位标志
	private String gwmc;		//岗位名称
	private int sfqy;			//是否启用
	private int gwxz;			//岗位性质
	public long getGwbz() {
		return gwbz;
	}
	public String getGwmc() {
		return gwmc;
	}
	public int getSfqy() {
		return sfqy;
	}
	public int getGwxz() {
		return gwxz;
	}
	public void setGwbz(long gwbz) {
		this.gwbz = gwbz;
	}
	public void setGwmc(String gwmc) {
		this.gwmc = gwmc;
	}
	public void setSfqy(int sfqy) {
		this.sfqy = sfqy;
	}
	public void setGwxz(int gwxz) {
		this.gwxz = gwxz;
	}
}
