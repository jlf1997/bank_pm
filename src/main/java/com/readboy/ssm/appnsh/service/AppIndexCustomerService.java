package com.readboy.ssm.appnsh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.readboy.ssm.appnsh.model.TB_TJFX_BLDKKH;
import com.readboy.ssm.appnsh.util.Finder;

@Service
public class AppIndexCustomerService {

	
	public int getCount(String yggh,int khlx,Finder finder,Object t) {
		List list = finder.findAll(t);
		if(list!=null) {
			return list.size();
		}
		return 0;
		
	}
}
