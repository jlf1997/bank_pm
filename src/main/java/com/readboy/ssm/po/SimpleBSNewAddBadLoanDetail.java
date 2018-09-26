package com.readboy.ssm.po;

import java.math.BigDecimal;

public class SimpleBSNewAddBadLoanDetail {
	
	private String zzjc;		//机构名称,在organization表中
	private String khmc;		//客户名称
	private String ffrq;		//开户日期
	private String dqrq;		//到期日期
	private BigDecimal dkje;	//贷款金额
	private BigDecimal dkye;	//贷款余额
	private BigDecimal ll;		//利率	
	private String ncwjfl;		//年初五级分类
	private String qmwjfl;		//期末五级分类
	
	public String getZzjc() {
		return zzjc;
	}
	public String getKhmc() {
		return khmc;
	}
	public String getFfrq() {
		if(ffrq != null && ffrq.length() > 10){
			return ffrq.substring(0,10);
		}
		return ffrq;
	}
	public String getDqrq() {
		if(dqrq != null && dqrq.length() > 10){
			return dqrq.substring(0,10);
		}
		return dqrq;
	}
	public BigDecimal getDkje() {
		return dkje;
	}
	public BigDecimal getDkye() {
		return dkye;
	}
	public BigDecimal getLl() {
		return ll;
	}
	public String getNcwjfl() {
		return ncwjfl;
	}
	public String getQmwjfl() {
		return qmwjfl;
	}
	public void setZzjc(String zzjc) {
		this.zzjc = zzjc;
	}
	public void setKhmc(String khmc) {
		this.khmc = khmc;
	}
	public void setFfrq(String ffrq) {
		this.ffrq = ffrq;
	}
	public void setDqrq(String dqrq) {
		this.dqrq = dqrq;
	}
	public void setDkje(BigDecimal dkje) {
		this.dkje = dkje;
	}
	public void setDkye(BigDecimal dkye) {
		this.dkye = dkye;
	}
	public void setLl(BigDecimal ll) {
		this.ll = ll;
	}
	public void setNcwjfl(String ncwjfl) {
		this.ncwjfl = ncwjfl;
	}
	public void setQmwjfl(String qmwjfl) {
		this.qmwjfl = qmwjfl;
	}
}
