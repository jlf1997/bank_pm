package com.readboy.ssm.appjx.service;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Service;

import com.readboy.ssm.appjx.jpa.ErpAssessdataJgPhjfkJpa;
import com.readboy.ssm.appjx.model.ErpAssessDataJgPhjfk;
import com.readboy.ssm.appnsh.util.Finder;

@Service
public class ErpAssessdataJgPhjfkService extends Finder<ErpAssessDataJgPhjfk, Long>{
	
	
	@Autowired
	private ErpAssessdataJgPhjfkJpa jpa;

	@Override
	public JpaSpecificationExecutor<ErpAssessDataJgPhjfk> specjpa() {
		// TODO Auto-generated method stub
		return jpa;
	}

	@Override
	public JpaRepository<ErpAssessDataJgPhjfk, Long> jpa() {
		// TODO Auto-generated method stub
		return jpa;
	}

	

	@Override
	public void setSelect(ErpAssessDataJgPhjfk t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addWhere(Object[] t, List<Predicate> predicates, Root<ErpAssessDataJgPhjfk> root,
			CriteriaQuery<?> query, CriteriaBuilder cb) {
		// TODO Auto-generated method stub
		
	}


	
	
}
