package com.readboy.ssm.appjx.dto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.readboy.ssm.appjx.model.ErpAssessDataJgPhjfk;
import com.readboy.ssm.appjx.model.ErpBasZbk;
import com.readboy.ssm.appjx.service.ErpBasZbkService;

public class ErpAssessDataJgPhjfkDto {

	
	private BigDecimal khqz;//	考核权重
	private String zbid;//	指标ID
	private BigDecimal zbjg;//	指标结果
	private BigDecimal zbdf;//	指标得分
	private BigDecimal zbfz;//	指标分值
	private BigDecimal zbrw;//	指标任务
	
	private String zbmc;

	public BigDecimal getKhqz() {
		return khqz;
	}

	public void setKhqz(BigDecimal khqz) {
		this.khqz = khqz;
	}

	public String getZbid() {
		return zbid;
	}

	public void setZbid(String zbid) {
		this.zbid = zbid;
	}

	public BigDecimal getZbjg() {
		return zbjg;
	}

	public void setZbjg(BigDecimal zbjg) {
		this.zbjg = zbjg;
	}

	public BigDecimal getZbdf() {
		return zbdf;
	}

	public void setZbdf(BigDecimal zbdf) {
		this.zbdf = zbdf;
	}

	public BigDecimal getZbfz() {
		return zbfz;
	}

	public void setZbfz(BigDecimal zbfz) {
		this.zbfz = zbfz;
	}

	public BigDecimal getZbrw() {
		return zbrw;
	}

	public void setZbrw(BigDecimal zbrw) {
		this.zbrw = zbrw;
	}

	public String getZbmc() {
		return zbmc;
	}

	public void setZbmc(String zbmc) {
		this.zbmc = zbmc;
	}
	
	

	public static List<ErpAssessDataJgPhjfkDto> copy(List<ErpAssessDataJgPhjfk> source,ErpBasZbkService erpBasZbkService) {
		List<ErpAssessDataJgPhjfkDto> target = new ArrayList<>();
		ErpBasZbk erpBasZbk ;
		for(int i=0;i<source.size();i++) {
			ErpAssessDataJgPhjfkDto dto = new ErpAssessDataJgPhjfkDto();
			if(source.get(i)!=null) {
				BeanUtils.copyProperties(source.get(i), dto);
			}
			erpBasZbk = new ErpBasZbk();
			erpBasZbk.setZBID(source.get(i).getZbid());
			List<ErpBasZbk> list = erpBasZbkService.findAll(erpBasZbk);
			if(list!=null && list.size()>0) {
				dto.setZbmc(list.get(0).getZBMC());
			}
			
			target.add(dto);
		}
		return target;
	}
	
}
