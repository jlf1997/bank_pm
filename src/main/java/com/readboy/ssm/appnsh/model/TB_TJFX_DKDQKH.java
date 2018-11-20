package com.readboy.ssm.appnsh.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 贷款到期客户
 * @author Administrator
 *
 */
@Table(name="tb_tjfx_dkdqkh")
@Entity
public class TB_TJFX_DKDQKH {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String yggh;//员工工号
	private String jgdm;//机构代码
	private String khmc;//客户名称
	private String dkzh;//贷款账号
	private Date ffrq;//发放日期
	private Date dqrq;//到期日期
	private BigDecimal dkje;//贷款金额
	private BigDecimal dkye;//贷款余额
	private String ywzl;//业务种类
	private Integer wjflbz;//五级分类标识
	private BigDecimal ll;//利率
	private String dkqx;//贷款期限
	private String lxfs;//联系方式
	private String dz;//地址
	private Integer khlx;//客户类型
	private Integer lrbz;//录入标识
	private Date lrsj;//录入时间
	private String lrr;//录入人
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
	public String getJgdm() {
		return jgdm;
	}
	public void setJgdm(String jgdm) {
		this.jgdm = jgdm;
	}
	public String getKhmc() {
		return khmc;
	}
	public void setKhmc(String khmc) {
		this.khmc = khmc;
	}
	public String getDkzh() {
		return dkzh;
	}
	public void setDkzh(String dkzh) {
		this.dkzh = dkzh;
	}
	public Date getFfrq() {
		return ffrq;
	}
	public void setFfrq(Date ffrq) {
		this.ffrq = ffrq;
	}
	public Date getDqrq() {
		return dqrq;
	}
	public void setDqrq(Date dqrq) {
		this.dqrq = dqrq;
	}
	public BigDecimal getDkje() {
		return dkje;
	}
	public void setDkje(BigDecimal dkje) {
		this.dkje = dkje;
	}
	public BigDecimal getDkye() {
		return dkye;
	}
	public void setDkye(BigDecimal dkye) {
		this.dkye = dkye;
	}
	public String getYwzl() {
		return ywzl;
	}
	public void setYwzl(String ywzl) {
		this.ywzl = ywzl;
	}
	public Integer getWjflbz() {
		return wjflbz;
	}
	public void setWjflbz(Integer wjflbz) {
		this.wjflbz = wjflbz;
	}
	public BigDecimal getLl() {
		return ll;
	}
	public void setLl(BigDecimal ll) {
		this.ll = ll;
	}
	public String getDkqx() {
		return dkqx;
	}
	public void setDkqx(String dkqx) {
		this.dkqx = dkqx;
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
	public Integer getKhlx() {
		return khlx;
	}
	public void setKhlx(Integer khlx) {
		this.khlx = khlx;
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
	
	
}
