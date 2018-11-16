package com.readboy.ssm.appnsh.dto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.readboy.ssm.appnsh.model.Org;
import com.readboy.ssm.appnsh.model.TB_TJFX_CKDKH;
import com.readboy.ssm.appnsh.service.OrgService;

/**
 * 存款大客户dto
 * @author Administrator
 *
 */
public class TB_TJFX_CKDKHDto {
	private String yggh;//员工工号
	private String jgmc;//机构代码
	private String khmc;//客户名称
	private String lxfs;//联系方式
	private BigDecimal ckye;//存款余额
	private String dz;//地址
	private Integer khlx;//客户类型
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
	public String getLxfs() {
		return lxfs;
	}
	public void setLxfs(String lxfs) {
		this.lxfs = lxfs;
	}
	public BigDecimal getCkye() {
		return ckye;
	}
	public void setCkye(BigDecimal ckye) {
		this.ckye = ckye;
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
	public static List<TB_TJFX_CKDKHDto> copyList(List<TB_TJFX_CKDKH> source,OrgService orgService) {
		List<TB_TJFX_CKDKHDto> target = new ArrayList<>();
		for(int i=0;i<source.size();i++) {
			TB_TJFX_CKDKHDto dto = new TB_TJFX_CKDKHDto();
			if(source.get(i)!=null)
				BeanUtils.copyProperties(source.get(i), dto);
			Org org = new Org();
			org.setYwjgdm(source.get(i).getJgdm());
			org = orgService.find(org);
			if(org!=null) {
				dto.setJgmc(org.getZzmc());
			}
			target.add(dto);
		}
		return target;
	}
	
}
