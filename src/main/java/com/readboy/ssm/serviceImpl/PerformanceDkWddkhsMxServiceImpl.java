package com.readboy.ssm.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.readboy.ssm.mapper.PerformanceDKWddkhsMxMapper;
import com.readboy.ssm.po.PerformanceDKWddkhsMx;
import com.readboy.ssm.service.PerformanceDkWddkhsMxService;


public class PerformanceDkWddkhsMxServiceImpl implements PerformanceDkWddkhsMxService{
	
	@Autowired
	private PerformanceDKWddkhsMxMapper performanceDkWddkhsMxMapper;

	@Override
	public PerformanceDKWddkhsMx findPerformanceDKWddkhsMx(String ksrq,
			String jsrq, String zzbz) throws Exception {
		// TODO Auto-generated method stub
		return performanceDkWddkhsMxMapper.findPerformanceDKWddkhsMx(ksrq, jsrq, zzbz);
	}



	
}
