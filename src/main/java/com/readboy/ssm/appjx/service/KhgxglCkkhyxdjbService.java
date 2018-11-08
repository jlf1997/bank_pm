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

import com.readboy.ssm.appjx.jpa.KhgxglCkkhyxdjbJpa;
import com.readboy.ssm.appnsh.util.Finder;
import com.readboy.ssm.po.DepositMarketing;

@Service
public class KhgxglCkkhyxdjbService extends Finder<DepositMarketing, Long>{
	
	
	@Autowired
	private KhgxglCkkhyxdjbJpa jpa;

	@Override
	public JpaSpecificationExecutor<DepositMarketing> specjpa() {
		// TODO Auto-generated method stub
		return jpa;
	}

	@Override
	public JpaRepository<DepositMarketing, Long> jpa() {
		// TODO Auto-generated method stub
		return jpa;
	}

	@Override
	public void addWhere(DepositMarketing[] t, List<Predicate> predicates, Root<DepositMarketing> root,
			CriteriaQuery<?> query, CriteriaBuilder cb) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setSelect(DepositMarketing t) {
		// TODO Auto-generated method stub
		
	}


	
	
}
