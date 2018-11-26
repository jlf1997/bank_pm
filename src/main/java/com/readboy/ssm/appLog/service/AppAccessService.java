package com.readboy.ssm.appLog.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.readboy.ssm.appLog.dao.AppAccessDao;
import com.readboy.ssm.appLog.model.SysBasQypz;


@Service
public class AppAccessService {
	
	@Autowired
	private AppAccessDao appAccessDao;

	public List<SysBasQypz> getSysBasQypzList(){
		
		
		return appAccessDao.getSysBasQypzList();
		
	}
	
	public Map getSysBasQypzListPate(Integer pageSize, Integer pageIndex){
		
		
		return appAccessDao.getPages(pageSize, pageIndex);
		
	}

	public boolean save(SysBasQypz sysBasQypz) {
		// TODO Auto-generated method stub
		return appAccessDao.save(sysBasQypz);
	}
	
}
