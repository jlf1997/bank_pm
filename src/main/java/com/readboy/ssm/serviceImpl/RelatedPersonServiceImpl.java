package com.readboy.ssm.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.readboy.ssm.mapper.RelatedPersonMapper;
import com.readboy.ssm.po.PageOption;
import com.readboy.ssm.po.RelatedPerson;
import com.readboy.ssm.service.RelatedPersonService;

public class RelatedPersonServiceImpl implements RelatedPersonService{
	
	@Autowired 
	private RelatedPersonMapper relatedPersonMapper;

	@Override
	public List<RelatedPerson> findRelatedPersonByKhbhAndJgdm(String khbh, String jgdm)
			throws Exception {
		// TODO Auto-generated method stub
		return relatedPersonMapper.findRelatedPersonByKhbhAndJgdm(khbh, jgdm);
	}

	@Override
	public Integer findDataCountByCond(String khbh, String jgdm) throws Exception {
		// TODO Auto-generated method stub
		Integer num = relatedPersonMapper.findDataCountByCond(khbh, jgdm);
		return num != null ? num : 0;
	}
	
}
