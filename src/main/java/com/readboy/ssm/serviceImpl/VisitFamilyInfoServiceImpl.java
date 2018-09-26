package com.readboy.ssm.serviceImpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.readboy.ssm.mapper.VisitFamilyInfoMapper;
import com.readboy.ssm.po.VisitFamilyInfo;
import com.readboy.ssm.service.VisitFamilyInfoService;

public class VisitFamilyInfoServiceImpl implements VisitFamilyInfoService {

	@Autowired
	VisitFamilyInfoMapper visitFamilyInfoMapper;
	
	@Override
	public List<VisitFamilyInfo> findListFamilyInfo(Map<String, Object> map) {
		List<VisitFamilyInfo> list = visitFamilyInfoMapper.selectAllByMemeberTypeAndVisitorIdAndClientNum(map);
		return list;
	}

	@Override
	public void insertVisitFamilyInfo(VisitFamilyInfo familyInfo) {
		visitFamilyInfoMapper.insert(familyInfo);
	}

	@Override
	public void deleteById(int id) {
		visitFamilyInfoMapper.deleteByPrimaryKey(id);
	}



}
