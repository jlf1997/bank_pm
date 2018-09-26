package com.readboy.ssm.serviceImpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.readboy.ssm.mapper.PerformanceDkkhbsMxMapper;
import com.readboy.ssm.po.PageOption;
import com.readboy.ssm.po.PerformanceDkkhbsMx;
import com.readboy.ssm.service.PerformanceDkkhbsMxService;

public class PerformanceDkkhbsMxServiceImpl implements PerformanceDkkhbsMxService{
	
	@Autowired 
	private PerformanceDkkhbsMxMapper performanceDkkhbsMxMapper;

	@Override
	public List<PerformanceDkkhbsMx> findPerformanceDkkhbsMx(String yggh,
			String ksrq, String jsrq,String condition,PageOption page) throws Exception {
		// TODO Auto-generated method stub
		return performanceDkkhbsMxMapper.findPerformanceDkkhbsMx(yggh, ksrq, jsrq,condition,page);
	}

	@Override
	public Integer findDataCount(String yggh, String ksrq, String jsrq,
			String condition) throws Exception {
		// TODO Auto-generated method stub
		Integer num = performanceDkkhbsMxMapper.findDataCountByCond(yggh, ksrq, jsrq, condition);
		return num != null ? num : 0;
	}
	
}
