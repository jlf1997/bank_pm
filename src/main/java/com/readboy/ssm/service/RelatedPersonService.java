package com.readboy.ssm.service;

import java.util.List;

import com.readboy.ssm.po.PageOption;
import com.readboy.ssm.po.RelatedPerson;

public interface RelatedPersonService {
	
	public List<RelatedPerson> findRelatedPersonByKhbhAndJgdm(String khbh, String jgdm) throws Exception;
	
	public Integer findDataCountByCond(String khbh, String jgdm) throws Exception;
}
