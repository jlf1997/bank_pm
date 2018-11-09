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

import com.readboy.ssm.appjx.jpa.KhgxglSjyhyxdjbJpa;
import com.readboy.ssm.appnsh.util.Finder;
import com.readboy.ssm.po.CellBankMarketing;

@Service
public class KhgxglSjyhyxdjbService extends Finder<CellBankMarketing, Long>{
	
	
	@Autowired
	private KhgxglSjyhyxdjbJpa jpa;

	@Override
	public JpaSpecificationExecutor<CellBankMarketing> specjpa() {
		// TODO Auto-generated method stub
		return jpa;
	}

	@Override
	public JpaRepository<CellBankMarketing, Long> jpa() {
		// TODO Auto-generated method stub
		return jpa;
	}

	

	@Override
	public void setSelect(CellBankMarketing t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addWhere(Object[] t, List<Predicate> predicates, Root<CellBankMarketing> root, CriteriaQuery<?> query,
			CriteriaBuilder cb) {
		// TODO Auto-generated method stub
		
	}


	
	
}
