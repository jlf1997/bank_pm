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

import com.readboy.ssm.appnsh.dto.TB_TJFX_DKDQKHDto;
import com.readboy.ssm.appnsh.jpa.TB_TJFX_DKDQKHJpa;
import com.readboy.ssm.appnsh.model.TB_TJFX_DKDQKH;
import com.readboy.ssm.appnsh.util.Finder;

@Service
public class TB_TJFX_DKDQKHService extends Finder<TB_TJFX_DKDQKH, Long>{
	
	@Autowired
	private TB_TJFX_DKDQKHJpa jpa;
	
	@Autowired
	private OrgService orgService;

	@Override
	public JpaSpecificationExecutor<TB_TJFX_DKDQKH> specjpa() {
		// TODO Auto-generated method stub
		return jpa;
	}

	@Override
	public JpaRepository<TB_TJFX_DKDQKH, Long> jpa() {
		// TODO Auto-generated method stub
		return jpa;
	}

	@Override
	public void addWhere(TB_TJFX_DKDQKH[] t, List<Predicate> predicates, Root<TB_TJFX_DKDQKH> root,
			CriteriaQuery<?> query, CriteriaBuilder cb) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setSelect(TB_TJFX_DKDQKH t) {
		// TODO Auto-generated method stub
		
	}

	public int getCount(String yggh,int khlx) {
		TB_TJFX_DKDQKH t = new TB_TJFX_DKDQKH();
		t.setYggh(yggh);
		t.setKhlx(khlx);
		List<TB_TJFX_DKDQKH> list = findAll(t);
		if(list!=null) {
			return list.size();
		}
		return 0;
		
	}
	
	public List<TB_TJFX_DKDQKHDto> getTB_TJFX_BLDKKHByYgghAndKHLX(String yggh,Integer khlx){
		TB_TJFX_DKDQKH t = new TB_TJFX_DKDQKH();
		t.setKhlx(khlx);
		t.setYggh(yggh);
		List<TB_TJFX_DKDQKH> list = this.findAll(t);
		return TB_TJFX_DKDQKHDto.copyList(list,orgService);
		
	}

}
