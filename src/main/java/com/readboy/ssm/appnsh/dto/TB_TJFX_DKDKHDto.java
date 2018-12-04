package com.readboy.ssm.appnsh.dto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.readboy.ssm.appnsh.model.Org;
import com.readboy.ssm.appnsh.model.TB_TJFX_DKDKH;
import com.readboy.ssm.appnsh.service.OrgService;
/**
 * 贷款到期
 * @author Administrator
 *
 */
public class TB_TJFX_DKDKHDto {

	private String jgmc	;//机构代码
	private String khmc	;//客户名称
	private String dkzh	;//贷款账号
	private Date zzffrq	;//发放日期
	private Date zzdqrq	;//到期日期
	private BigDecimal dkje	;//贷款金额
	private BigDecimal dkye	;//贷款余额
	private String lxfs	;//联系方式
	private String dz	;//地址
	
	
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


	public String getDkzh() {
		return dkzh;
	}


	public void setDkzh(String dkzh) {
		this.dkzh = dkzh;
	}


	


	public Date getZzffrq() {
		return zzffrq;
	}


	public void setZzffrq(Date zzffrq) {
		this.zzffrq = zzffrq;
	}


	public Date getZzdqrq() {
		return zzdqrq;
	}


	public void setZzdqrq(Date zzdqrq) {
		this.zzdqrq = zzdqrq;
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


	public static List<TB_TJFX_DKDKHDto> copyList(List<TB_TJFX_DKDKH> source,OrgService orgService) {
		List<TB_TJFX_DKDKHDto> target = new ArrayList<>();
		for(int i=0;i<source.size();i++) {
			TB_TJFX_DKDKHDto dto = new TB_TJFX_DKDKHDto();
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
}
