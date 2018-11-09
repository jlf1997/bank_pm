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

import com.readboy.ssm.appjx.jpa.HrBasStaffPostJpa;
import com.readboy.ssm.appnsh.util.Finder;
import com.readboy.ssm.po.StaffAndPost;

@Service
public class HrBasStaffPostService extends Finder<StaffAndPost, Long>{
	
	
	@Autowired
	private HrBasStaffPostJpa jpa;

	@Override
	public JpaSpecificationExecutor<StaffAndPost> specjpa() {
		// TODO Auto-generated method stub
		return jpa;
	}

	@Override
	public JpaRepository<StaffAndPost, Long> jpa() {
		// TODO Auto-generated method stub
		return jpa;
	}

	

	@Override
	public void setSelect(StaffAndPost t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addWhere(Object[] t, List<Predicate> predicates, Root<StaffAndPost> root, CriteriaQuery<?> query,
			CriteriaBuilder cb) {
		// TODO Auto-generated method stub
		
	}


	
	
}
