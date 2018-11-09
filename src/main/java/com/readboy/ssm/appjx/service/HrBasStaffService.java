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

import com.readboy.ssm.appjx.jpa.HrBasStaffJpa;
import com.readboy.ssm.appnsh.util.Finder;
import com.readboy.ssm.po.Staff;

@Service
public class HrBasStaffService extends Finder<Staff, String>{
	
	
	@Autowired
	private HrBasStaffJpa jpa;

	@Override
	public JpaSpecificationExecutor<Staff> specjpa() {
		// TODO Auto-generated method stub
		return jpa;
	}

	@Override
	public JpaRepository<Staff, String> jpa() {
		// TODO Auto-generated method stub
		return jpa;
	}

	

	@Override
	public void setSelect(Staff t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addWhere(Object[] t, List<Predicate> predicates, Root<Staff> root, CriteriaQuery<?> query,
			CriteriaBuilder cb) {
		// TODO Auto-generated method stub
		
	}


	
	
}
