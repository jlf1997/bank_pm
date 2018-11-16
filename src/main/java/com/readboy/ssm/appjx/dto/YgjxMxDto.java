package com.readboy.ssm.appjx.dto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.readboy.ssm.appjx.model.ErpBasZbk;
import com.readboy.ssm.appjx.model.ErpWageYgjxMx;
import com.readboy.ssm.appjx.service.ErpBasZbkService;

public class YgjxMxDto {
	
	private String zbid;
	private String zzbz;			//组织标识
	private String zbmc;			//指标名称，从表erp_bas_zbk中获取
	private BigDecimal zbdj;		//指标单价
	private BigDecimal zbjg;		//指标结果
	private BigDecimal zbgz;		//指标工资
	
	public YgjxMxDto() {
		
	}

	public String getZbid() {
		return zbid;
	}

	public void setZbid(String zbid) {
		this.zbid = zbid;
	}

	public String getZzbz() {
		return zzbz;
	}

	public void setZzbz(String zzbz) {
		this.zzbz = zzbz;
	}

	public String getZbmc() {
		return zbmc;
	}

	public void setZbmc(String zbmc) {
		this.zbmc = zbmc;
	}

	public BigDecimal getZbdj() {
		return zbdj;
	}

	public void setZbdj(BigDecimal zbdj) {
		this.zbdj = zbdj;
	}

	public BigDecimal getZbjg() {
		return zbjg;
	}

	public void setZbjg(BigDecimal zbjg) {
		this.zbjg = zbjg;
	}

	public BigDecimal getZbgz() {
		return zbgz;
	}

	public void setZbgz(BigDecimal zbgz) {
		this.zbgz = zbgz;
	}

	
	
	public static List<YgjxMxDto> copyList(List<ErpWageYgjxMx> source,ErpBasZbkService service) {
		List<YgjxMxDto> target = new ArrayList<>();
		for(int i=0;i<source.size();i++) {
			YgjxMxDto dto = new YgjxMxDto();
			if(source.get(i)!=null) {
				BeanUtils.copyProperties(source.get(i), dto);
			}
			ErpBasZbk zbk = new ErpBasZbk();
			zbk.setZBID(source.get(i).getZbid());
			zbk = service.find(zbk);
			if(zbk!=null) {
				dto.setZbmc(zbk.getZBMC());
			}
			target.add(dto);
		}
		return target;
	}
	
	

		
}
