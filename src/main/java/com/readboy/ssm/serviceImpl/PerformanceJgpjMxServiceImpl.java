package com.readboy.ssm.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.readboy.ssm.mapper.PerformanceJgpjMxMapper;
import com.readboy.ssm.po.PageOption;
import com.readboy.ssm.po.PerformanceJgpjMx;
import com.readboy.ssm.service.PerformanceJgpjMxService;

public class PerformanceJgpjMxServiceImpl implements PerformanceJgpjMxService{
	
	@Autowired 
	private PerformanceJgpjMxMapper PerformanceJgpjMxMapper;

	@Override
	public List<PerformanceJgpjMx> findPerformanceJgpjMx(
			String yggh, String gzrq, String zbid) throws Exception {
		// TODO Auto-generated method stub
		return PerformanceJgpjMxMapper.findPerformanceJgpjMx(yggh, gzrq, zbid);
	}

	@Override
	public Integer findDataCountByCond(String yggh, String gzrq, String zbid)
			throws Exception {
		// TODO Auto-generated method stub
		Integer num =  PerformanceJgpjMxMapper.findDataCountByCond(yggh, gzrq, zbid);
		return num != null ? num : 0;
	}


}
