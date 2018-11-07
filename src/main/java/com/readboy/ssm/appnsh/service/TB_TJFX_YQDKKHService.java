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

import com.readboy.ssm.appnsh.dto.TB_TJFX_YQDKKHDto;
import com.readboy.ssm.appnsh.jpa.TB_TJFX_YQDKKHJpa;
import com.readboy.ssm.appnsh.model.TB_TJFX_YQDKKH;
import com.readboy.ssm.appnsh.util.Finder;

@Service
public class TB_TJFX_YQDKKHService extends Finder<TB_TJFX_YQDKKH, Long>{
	
	@Autowired
	private TB_TJFX_YQDKKHJpa jpa;
	
	@Autowired
	private OrgService orgService;

	@Override
	public JpaSpecificationExecutor<TB_TJFX_YQDKKH> specjpa() {
		// TODO Auto-generated method stub
		return jpa;
	}

	@Override
	public JpaRepository<TB_TJFX_YQDKKH, Long> jpa() {
		// TODO Auto-generated method stub
		return jpa;
	}

	@Override
	public void addWhere(TB_TJFX_YQDKKH[] t, List<Predicate> predicates, Root<TB_TJFX_YQDKKH> root,
			CriteriaQuery<?> query, CriteriaBuilder cb) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setSelect(TB_TJFX_YQDKKH t) {
		// TODO Auto-generated method stub
		
	}

	public int getCount(String yggh,int khlx) {
		TB_TJFX_YQDKKH t = new TB_TJFX_YQDKKH();
		t.setYggh(yggh);
		t.setKhlx(khlx);
		List<TB_TJFX_YQDKKH> list = findAll(t);
		if(list!=null) {
			return list.size();
		}
		return 0;
		
	}
	
	public List<TB_TJFX_YQDKKHDto> getTB_TJFX_BLDKKHByYgghAndKHLX(String yggh,Integer khlx){
		TB_TJFX_YQDKKH t = new TB_TJFX_YQDKKH();
		t.setKhlx(khlx);
		t.setYggh(yggh);
		List<TB_TJFX_YQDKKH> list = this.findAll(t);
		return TB_TJFX_YQDKKHDto.copyList(list,orgService);
		
	}
}
