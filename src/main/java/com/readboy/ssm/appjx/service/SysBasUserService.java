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

import com.readboy.ssm.appjx.jpa.SysBasUserJpa;
import com.readboy.ssm.appnsh.util.Finder;
import com.readboy.ssm.po.User;

@Service
public class SysBasUserService extends Finder<User, Long>{
	
	
	@Autowired
	private SysBasUserJpa jpa;

	@Override
	public JpaSpecificationExecutor<User> specjpa() {
		// TODO Auto-generated method stub
		return jpa;
	}

	@Override
	public JpaRepository<User, Long> jpa() {
		// TODO Auto-generated method stub
		return jpa;
	}

	@Override
	public void addWhere(User[] t, List<Predicate> predicates, Root<User> root, CriteriaQuery<?> query,
			CriteriaBuilder cb) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setSelect(User t) {
		// TODO Auto-generated method stub
		
	}


	
	
}
