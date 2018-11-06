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

import com.readboy.ssm.appnsh.jpa.TB_TJFX_BLDKKHJpa;
import com.readboy.ssm.appnsh.model.TB_TJFX_BLDKKH;
import com.readboy.ssm.appnsh.model.TB_TJFX_CDZL;
import com.readboy.ssm.appnsh.util.Finder;

@Service
public class TB_TJFX_BLDKKHService extends Finder<TB_TJFX_BLDKKH, Long>{
	
	@Autowired
	private TB_TJFX_BLDKKHJpa jpa;

	@Override
	public JpaSpecificationExecutor<TB_TJFX_BLDKKH> specjpa() {
		// TODO Auto-generated method stub
		return jpa;
	}

	@Override
	public JpaRepository<TB_TJFX_BLDKKH, Long> jpa() {
		// TODO Auto-generated method stub
		return jpa;
	}

	@Override
	public void addWhere(TB_TJFX_BLDKKH[] t, List<Predicate> predicates, Root<TB_TJFX_BLDKKH> root,
			CriteriaQuery<?> query, CriteriaBuilder cb) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setSelect(TB_TJFX_BLDKKH t) {
		// TODO Auto-generated method stub
		
	}

	
	public int getCount(String yggh,int khlx) {
		TB_TJFX_BLDKKH t = new TB_TJFX_BLDKKH();
		t.setYggh(yggh);
		t.setKhlx(khlx);
		List list = findAll(t);
		if(list!=null) {
			return list.size();
		}
		return 0;
		
	}
	
}
