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

import com.readboy.ssm.appjx.jpa.ErpBasZbkJpa;
import com.readboy.ssm.appjx.model.ErpBasZbk;
import com.readboy.ssm.appjx.model.pk.ErpBasZbkPk;
import com.readboy.ssm.appnsh.util.Finder;

@Service
public class ErpBasZbkService extends Finder<ErpBasZbk, ErpBasZbkPk>{
	
	
	@Autowired
	private ErpBasZbkJpa jpa;

	@Override
	public JpaSpecificationExecutor<ErpBasZbk> specjpa() {
		// TODO Auto-generated method stub
		return jpa;
	}

	@Override
	public JpaRepository<ErpBasZbk, ErpBasZbkPk> jpa() {
		// TODO Auto-generated method stub
		return jpa;
	}

	@Override
	public void addWhere(Object[] t, List<Predicate> predicates, Root<ErpBasZbk> root, CriteriaQuery<?> query,
			CriteriaBuilder cb) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setSelect(ErpBasZbk t) {
		// TODO Auto-generated method stub
		
	}


	
	
}
