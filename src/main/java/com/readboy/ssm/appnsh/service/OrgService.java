package com.readboy.ssm.appnsh.service;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Service;

import com.readboy.ssm.appnsh.jpa.OrgJpa;
import com.readboy.ssm.appnsh.model.Org;
import com.readboy.ssm.appnsh.util.Finder;

@Service
public class OrgService extends Finder<Org, String>{

	@Autowired
	private OrgJpa jpa;
	
	@Override
	public JpaSpecificationExecutor<Org> specjpa() {
		// TODO Auto-generated method stub
		return jpa;
	}

	@Override
	public JpaRepository<Org, String> jpa() {
		// TODO Auto-generated method stub
		return jpa;
	}

	@Override
	public void addWhere(Org[] t, List<Predicate> predicates, Root<Org> root, CriteriaQuery<?> query,
			CriteriaBuilder cb) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setSelect(Org t) {
		// TODO Auto-generated method stub
		
	}

}
