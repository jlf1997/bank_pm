package com.readboy.ssm.appnsh.dto;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.readboy.ssm.appnsh.model.Org;
import com.readboy.ssm.appnsh.model.TB_TJFX_YQDKKH;
import com.readboy.ssm.appnsh.service.OrgService;
import com.readboy.ssm.utils.TimeUtil;

public class TB_TJFX_YQDKKHDto {
	private String jgmc	;//机构代码
	private String khmc	;//客户名称
	private String dkzh	;//贷款账号
	private Date ffrq	;//发放日期
	private Date dqrq	;//到期日期
	private BigDecimal dkje	;//贷款金额
	private BigDecimal dkye	;//贷款余额
	private String lxfs	;//联系方式
	private String dz	;//地址
	private Integer khlx	;//客户类型
	
	private Integer wjflbz	;//五级分类标识
	
	private String yqts;//逾期天数
	
	
	
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
	
	



	public Integer getWjflbz() {
		return wjflbz;
	}



	public void setWjflbz(Integer wjflbz) {
		this.wjflbz = wjflbz;
	}
	
	

	








	public String getYqts() {
		return yqts;
	}



	public void setYqts(double yqts) {
		if(yqts<1 && yqts>-1) {
			String s = String.format("%.1f", yqts);
			this.yqts = s;
		}else {
			DecimalFormat df = new DecimalFormat("#");
			this.yqts = df.format(yqts);
		}
		
	}



	public static List<TB_TJFX_YQDKKHDto> copyList(List<TB_TJFX_YQDKKH> source,OrgService orgService) {
		List<TB_TJFX_YQDKKHDto> target = new ArrayList<>();
		for(int i=0;i<source.size();i++) {
			TB_TJFX_YQDKKHDto dto = new TB_TJFX_YQDKKHDto();
			if(source.get(i)!=null)
				BeanUtils.copyProperties(source.get(i), dto);
			Org org = new Org();
			org.setYwjgdm(source.get(i).getJgdm());
			org = orgService.find(org);
			if(org!=null) {
				dto.setJgmc(org.getZzjc());
			}
			if(dto.getDqrq()!=null) {
				double yqts = TimeUtil.getDaySpan(dto.getDqrq(), new Date());
				dto.setYqts(yqts);
			}
			target.add(dto);
		}
		return target;
	}
}
