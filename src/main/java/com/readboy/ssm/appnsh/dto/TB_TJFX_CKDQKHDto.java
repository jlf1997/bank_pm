package com.readboy.ssm.appnsh.dto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.readboy.ssm.appnsh.model.Org;
import com.readboy.ssm.appnsh.model.TB_TJFX_CKDKH;
import com.readboy.ssm.appnsh.model.TB_TJFX_CKDQKH;
import com.readboy.ssm.appnsh.service.OrgService;

/**
 * 存款到期客户
 * @author Administrator
 *
 */
public class TB_TJFX_CKDQKHDto {

	private String yggh;//员工工号
	private String jgmc;//机构代码
	private String khmc;//客户名称
	private String ckzh;//存款账号
	private BigDecimal ckye;//存款余额
	private Date khrq;//开户日期
	private Date dqrq;//到期日期
	private String lxfs;//联系方式
	private String dz;//地址
	private Integer khlx;//客户类型
	
	public static List<TB_TJFX_CKDQKHDto> copyList(List<TB_TJFX_CKDQKH> source,OrgService orgService) {
		List<TB_TJFX_CKDQKHDto> target = new ArrayList<>();
		for(int i=0;i<source.size();i++) {
			TB_TJFX_CKDQKHDto dto = new TB_TJFX_CKDQKHDto();
			if(source.get(i)!=null)
				BeanUtils.copyProperties(source.get(i), dto);
			Org org = new Org();
			org.setYwjgdm(source.get(i).getJgdm());
			org = orgService.find(org);
			if(org!=null) {
				dto.setJgmc(org.getZzjc());
			}
			target.add(dto);
		}
		return target;
	}

	public String getYggh() {
		return yggh;
	}

	public void setYggh(String yggh) {
		this.yggh = yggh;
	}

	public String getJgmc() {
		return jgmc;
	}

	public void setJgmc(String jgmc) {
		this.jgmc = jgmc;
	}

	public String getKhmc() {
		return khmc;
	}

	public void setKhmc(String khmc) {
		this.khmc = khmc;
	}

	public String getCkzh() {
		return ckzh;
	}

	public void setCkzh(String ckzh) {
		this.ckzh = ckzh;
	}

	public BigDecimal getCkye() {
		return ckye;
	}

	public void setCkye(BigDecimal ckye) {
		this.ckye = ckye;
	}

	public Date getKhrq() {
		return khrq;
	}

	public void setKhrq(Date khrq) {
		this.khrq = khrq;
	}

	public Date getDqrq() {
		return dqrq;
	}

	public void setDqrq(Date dqrq) {
		this.dqrq = dqrq;
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
	
	
}
