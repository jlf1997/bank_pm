package com.readboy.ssm.appnsh.util;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public abstract class  NormalSpringDataJpaFinder <T> implements SpringDataJpaFinder<T>{

	
	public abstract boolean setWhere(List<Predicate> predicates,SpringDateJpaOper<T> springDateJpaOper,Object... t);
	
	@Override
	public boolean where(List<Predicate> predicates, Root<T> root, CriteriaQuery<?> query, CriteriaBuilder cb,
			Object... t) {
		SpringDateJpaOper<T> springDateJpaOper = new SpringDateJpaOper<>(root,query,cb);
		return setWhere(predicates,springDateJpaOper,t);
		
	}

	

}
