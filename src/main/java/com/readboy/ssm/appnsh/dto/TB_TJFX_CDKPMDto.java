package com.readboy.ssm.appnsh.dto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.readboy.ssm.appnsh.model.TB_TJFX_CDKPM;

public class TB_TJFX_CDKPMDto {

	
	private String khmc	;//客户名称
	private BigDecimal je	;//金额
	public String getKhmc() {
		return khmc;
	}
	public void setKhmc(String khmc) {
		this.khmc = khmc;
	}
	public BigDecimal getJe() {
		return je;
	}
	public void setJe(BigDecimal je) {
		this.je = je;
	}
	
	
	public static List<TB_TJFX_CDKPMDto> copy(List<TB_TJFX_CDKPM> source) {
		List<TB_TJFX_CDKPMDto> target = new ArrayList<>();
		for(int i=0;i<source.size();i++) {
			TB_TJFX_CDKPMDto dto = new TB_TJFX_CDKPMDto();
			if(source.get(i)!=null) {
				BeanUtils.copyProperties(source.get(i), dto);
				target.add(dto);
			}
		}
		return target;
	}
	
}
