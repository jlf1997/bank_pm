package com.readboy.ssm.appnsh.util;

import java.io.Serializable;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public abstract class DefaultFinder<T,ID extends Serializable> extends Finder<T,ID>{



	@Override
	public void addWhere(Object[] t, List<Predicate> predicates, Root<T> root, CriteriaQuery<?> query,
			CriteriaBuilder cb) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setSelect(T t) {
		// TODO Auto-generated method stub
		
	}

}
