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

import com.readboy.ssm.appjx.jpa.HrBasPostJpa;
import com.readboy.ssm.appnsh.util.Finder;
import com.readboy.ssm.po.Post;

@Service
public class HrBasPostService extends Finder<Post, Long>{
	
	
	@Autowired
	private HrBasPostJpa jpa;

	@Override
	public JpaSpecificationExecutor<Post> specjpa() {
		// TODO Auto-generated method stub
		return jpa;
	}

	@Override
	public JpaRepository<Post, Long> jpa() {
		// TODO Auto-generated method stub
		return jpa;
	}

	

	@Override
	public void setSelect(Post t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addWhere(Object[] t, List<Predicate> predicates, Root<Post> root, CriteriaQuery<?> query,
			CriteriaBuilder cb) {
		// TODO Auto-generated method stub
		
	}


	
	
}
