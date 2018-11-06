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

import com.readboy.ssm.appnsh.jpa.TB_TJFX_DKDKHJpa;
import com.readboy.ssm.appnsh.model.TB_TJFX_DKDKH;
import com.readboy.ssm.appnsh.util.Finder;

@Service
public class TB_TJFX_DKDKHService extends Finder<TB_TJFX_DKDKH, Long>{
	
	@Autowired
	private TB_TJFX_DKDKHJpa jpa;

	@Override
	public JpaSpecificationExecutor<TB_TJFX_DKDKH> specjpa() {
		// TODO Auto-generated method stub
		return jpa;
	}

	@Override
	public JpaRepository<TB_TJFX_DKDKH, Long> jpa() {
		// TODO Auto-generated method stub
		return jpa;
	}

	@Override
	public void addWhere(TB_TJFX_DKDKH[] t, List<Predicate> predicates, Root<TB_TJFX_DKDKH> root,
			CriteriaQuery<?> query, CriteriaBuilder cb) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setSelect(TB_TJFX_DKDKH t) {
		// TODO Auto-generated method stub
		
	}


}
