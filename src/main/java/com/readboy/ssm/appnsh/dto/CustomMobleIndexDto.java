package com.readboy.ssm.appnsh.dto;

import java.util.ArrayList;
import java.util.List;

import com.readboy.ssm.appnsh.model.TB_TJFX_CDKPM;
import com.readboy.ssm.appnsh.model.TB_TJFX_CDZL;

public class CustomMobleIndexDto {
	
	public CustomMobleIndexDto() {
		cdzl = new CDZLDto();
		ckpm = new ArrayList<>();
		dkpm = new ArrayList<>();
		grkh= new CustomerTj();
		qykh = new CustomerTj();
	}

	//存贷总览
	private CDZLDto cdzl;
	//存款排名
	private List<TB_TJFX_CDKPMDto> ckpm;
	//贷款排名
	private List<TB_TJFX_CDKPMDto> dkpm;
	//
	private CustomerTj grkh;
	
	private CustomerTj qykh;

	

	public CDZLDto getCdzl() {
		return cdzl;
	}

	public void setCdzl(CDZLDto cdzl) {
		this.cdzl = cdzl;
	}


	public CustomerTj getGrkh() {
		return grkh;
	}

	public void setGrkh(CustomerTj grkh) {
		this.grkh = grkh;
	}

	public CustomerTj getQykh() {
		return qykh;
	}

	public void setQykh(CustomerTj qykh) {
		this.qykh = qykh;
	}

	public List<TB_TJFX_CDKPMDto> getCkpm() {
		return ckpm;
	}

	public void setCkpm(List<TB_TJFX_CDKPMDto> ckpm) {
		this.ckpm = ckpm;
	}

	public List<TB_TJFX_CDKPMDto> getDkpm() {
		return dkpm;
	}

	public void setDkpm(List<TB_TJFX_CDKPMDto> dkpm) {
		this.dkpm = dkpm;
	}
	
	
	
	
	
}
