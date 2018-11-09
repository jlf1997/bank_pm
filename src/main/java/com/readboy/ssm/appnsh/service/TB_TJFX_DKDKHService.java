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

import com.readboy.ssm.appnsh.dto.TB_TJFX_DKDKHDto;
import com.readboy.ssm.appnsh.jpa.TB_TJFX_DKDKHJpa;
import com.readboy.ssm.appnsh.model.TB_TJFX_DKDKH;
import com.readboy.ssm.appnsh.util.Finder;

@Service
public class TB_TJFX_DKDKHService extends Finder<TB_TJFX_DKDKH, Long>{
	
	@Autowired
	private TB_TJFX_DKDKHJpa jpa;
	
	@Autowired
	private OrgService orgService;

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
	public void setSelect(TB_TJFX_DKDKH t) {
		// TODO Auto-generated method stub
		
	}

	public int getCount(String yggh,int khlx) {
		TB_TJFX_DKDKH t = new TB_TJFX_DKDKH();
		t.setYggh(yggh);
		t.setKhlx(khlx);
		List<TB_TJFX_DKDKH> list = findAll(t);
		if(list!=null) {
			return list.size();
		}
		return 0;
		
	}
	
	public List<TB_TJFX_DKDKHDto> getTB_TJFX_BLDKKHByYgghAndKHLX(String yggh,Integer khlx){
		TB_TJFX_DKDKH t = new TB_TJFX_DKDKH();
		t.setKhlx(khlx);
		t.setYggh(yggh);
		List<TB_TJFX_DKDKH> list = this.findAll(t);
		return TB_TJFX_DKDKHDto.copyList(list,orgService);
		
	}

	@Override
	public void addWhere(Object[] t, List<Predicate> predicates, Root<TB_TJFX_DKDKH> root, CriteriaQuery<?> query,
			CriteriaBuilder cb) {
		// TODO Auto-generated method stub
		
	}

}
