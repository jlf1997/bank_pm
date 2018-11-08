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

import com.readboy.ssm.appjx.jpa.ErpWageYgjxJpa;
import com.readboy.ssm.appjx.model.JXPK;
import com.readboy.ssm.appnsh.util.Finder;
import com.readboy.ssm.po.Performance;

@Service
public class ErpWageYgjxService extends Finder<Performance, JXPK>{
	
	
	@Autowired
	private ErpWageYgjxJpa jpa;

	@Override
	public JpaSpecificationExecutor<Performance> specjpa() {
		// TODO Auto-generated method stub
		return jpa;
	}

	@Override
	public JpaRepository<Performance, JXPK> jpa() {
		// TODO Auto-generated method stub
		return jpa;
	}

	@Override
	public void addWhere(Performance[] t, List<Predicate> predicates, Root<Performance> root, CriteriaQuery<?> query,
			CriteriaBuilder cb) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setSelect(Performance t) {
		// TODO Auto-generated method stub
		
	}


	
	
}
