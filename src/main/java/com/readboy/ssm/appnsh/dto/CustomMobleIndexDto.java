package com.readboy.ssm.appnsh.dto;

import java.util.ArrayList;
import java.util.List;

import com.readboy.ssm.appnsh.model.TB_TJFX_CDKPM;
import com.readboy.ssm.appnsh.model.TB_TJFX_CDZL;

public class CustomMobleIndexDto {
	
	public CustomMobleIndexDto() {
		cdzl = new TB_TJFX_CDZL();
		ckpm = new ArrayList<>();
		dkpm = new ArrayList<>();
		grkh= new CustomerTj();
		qykh = new CustomerTj();
	}

	//存贷总览
	private TB_TJFX_CDZL cdzl;
	//存款排名
	private List<TB_TJFX_CDKPM> ckpm;
	//贷款排名
	private List<TB_TJFX_CDKPM> dkpm;
	//
	private CustomerTj grkh;
	
	private CustomerTj qykh;

	public TB_TJFX_CDZL getCdzl() {
		return cdzl;
	}

	public void setCdzl(TB_TJFX_CDZL cdzl) {
		this.cdzl = cdzl;
	}

	public List<TB_TJFX_CDKPM> getCkpm() {
		return ckpm;
	}

	public void setCkpm(List<TB_TJFX_CDKPM> ckpm) {
		this.ckpm = ckpm;
	}

	public List<TB_TJFX_CDKPM> getDkpm() {
		return dkpm;
	}

	public void setDkpm(List<TB_TJFX_CDKPM> dkpm) {
		this.dkpm = dkpm;
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
	
	
	
	
	
}
