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

import com.readboy.ssm.appjx.jpa.ErpWageYgjxMxJpa;
import com.readboy.ssm.appnsh.util.Finder;
import com.readboy.ssm.po.PerformanceMx;

/**
 * 绩效明细
 * @author Administrator
 *
 */
@Service
public class ErpWageYgjxMxService extends Finder<PerformanceMx, String>{
	
	
	@Autowired
	private ErpWageYgjxMxJpa jpa;

	@Override
	public JpaSpecificationExecutor<PerformanceMx> specjpa() {
		// TODO Auto-generated method stub
		return jpa;
	}

	@Override
	public JpaRepository<PerformanceMx, String> jpa() {
		// TODO Auto-generated method stub
		return jpa;
	}

	@Override
	public void addWhere(PerformanceMx[] t, List<Predicate> predicates, Root<PerformanceMx> root,
			CriteriaQuery<?> query, CriteriaBuilder cb) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setSelect(PerformanceMx t) {
		// TODO Auto-generated method stub
		
	}



	
	
}
