package com.readboy.ssm.serviceImpl;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.readboy.ssm.po.PageOption;
import org.springframework.beans.factory.annotation.Autowired;

import com.readboy.ssm.mapper.StaffJjCustomMapper;
import com.readboy.ssm.mapper.StaffJjMapper;
import com.readboy.ssm.po.StaffJj;
import com.readboy.ssm.po.StaffJjCustom;
import com.readboy.ssm.service.StaffJjService;

public class StaffJjServiceImpl implements StaffJjService{
	
	@Autowired
	private StaffJjMapper staffJjMapper;
	@Autowired
	private StaffJjCustomMapper staffJjCustomMapper;
	@Override
	public List<StaffJj> findStaffJjbyCond(String yggh, String jjrq, String jjgw, PageOption page) throws Exception {
		// TODO Auto-generated method stub
		return staffJjMapper.findStaffJjByCond(yggh, jjrq, jjgw,page);
	}
	
	@Override
	public StaffJjCustom findStaffJjCustom(String zzbz, String yggh) throws Exception {
		// TODO Auto-generated method stub
		Calendar cal = Calendar.getInstance(); 
        cal.setTime(new Date());
        //获取当月第一天
        cal.set(Calendar.DAY_OF_MONTH,1);
		String firstDayOfMonth = new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());
		//获取当月最后一天
		cal.roll(Calendar.DAY_OF_MONTH, -1);
		String lastDayOfMonth = new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());
		return staffJjCustomMapper.findStaffJjCustom(zzbz, yggh, firstDayOfMonth, lastDayOfMonth);
	}

	@Override
	public Integer insertStaffJj(StaffJj staffJj) throws Exception {
		// TODO Auto-generated method stub
		return staffJjMapper.insertStaffJj(staffJj);
	}

}
