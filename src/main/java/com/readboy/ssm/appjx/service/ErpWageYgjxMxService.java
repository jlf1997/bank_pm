package com.readboy.ssm.appjx.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Service;

import com.readboy.ssm.appjx.dto.YgjxMxDto;
import com.readboy.ssm.appjx.jpa.ErpWageYgjxMxJpa;
import com.readboy.ssm.appjx.model.ErpWageYgjxMx;
import com.readboy.ssm.appnsh.util.Finder;
import com.readboy.ssm.appnsh.util.SpringDataJpaFinder;
import com.readboy.ssm.appnsh.util.SpringDateJpaOper;
import com.readboy.ssm.utils.PageModel;
import com.readboy.ssm.utils.TimeUtil;

/**
 * 绩效明细
 * @author Administrator
 *
 */
@Service
public class ErpWageYgjxMxService extends Finder<ErpWageYgjxMx, String>{
	
	
	@Autowired
	private ErpWageYgjxMxJpa jpa;
	@Autowired
	private ErpBasZbkService erpBasZbkService;

	

	
	/**
	 * 查询明细
	 * @param yggh
	 * @param date
	 * @param zblb
	 * @return
	 */
	public List<YgjxMxDto> findMx(String yggh,Date date,Integer zblb) {
		Date b = TimeUtil.getTheFirstDayOfMonth(date);
		Date e = TimeUtil.getTheLastDayOfMonth(date);
		List<ErpWageYgjxMx> res = findAll(new SpringDataJpaFinder<ErpWageYgjxMx>() {
			@Override
			public boolean where(List<Predicate> predicates, Root<ErpWageYgjxMx> root, CriteriaQuery<?> query,
					CriteriaBuilder cb, Object... t) {
				SpringDateJpaOper<ErpWageYgjxMx> springDateJpaOper = new SpringDateJpaOper<>(root,query,cb);
				springDateJpaOper.between(predicates, "gzrq", t[1], t[2]);
				springDateJpaOper.eq(predicates,"yggh", t[0]);
				springDateJpaOper.eq(predicates,"zblb", t[3]);
				return false;
			}
		}, yggh,b,e,zblb);
		List<YgjxMxDto> list = YgjxMxDto.copyList(res, erpBasZbkService);
		return list;
	}

	public PageModel findMxPage(Integer pageSize,Integer pageIndex,String yggh,Date date,Integer zblb) {
		Date b = TimeUtil.getTheFirstDayOfMonth(date);
		Date e = TimeUtil.getTheLastDayOfMonth(date);
		Page<ErpWageYgjxMx> res = findAllPage(new SpringDataJpaFinder<ErpWageYgjxMx>() {
			@Override
			public boolean where(List<Predicate> predicates, Root<ErpWageYgjxMx> root, CriteriaQuery<?> query,
					CriteriaBuilder cb, Object... t) {
				SpringDateJpaOper<ErpWageYgjxMx> springDateJpaOper = new SpringDateJpaOper<>(root,query,cb);
				springDateJpaOper.between(predicates, "gzrq", t[1], t[2]);
				springDateJpaOper.eq(predicates,"yggh", t[0]);
				springDateJpaOper.eq(predicates,"zblb", t[3]);
				return false;
			}
		},pageSize,pageIndex, yggh,b,e,zblb);
		List<YgjxMxDto> list = YgjxMxDto.copyList(res.getContent(), erpBasZbkService);
		PageModel pm = new PageModel(res);
		pm.setContent(list);
		return pm;
	}


	@Override
	public JpaSpecificationExecutor<ErpWageYgjxMx> specjpa() {
		// TODO Auto-generated method stub
		return jpa;
	}




	@Override
	public JpaRepository<ErpWageYgjxMx, String> jpa() {
		// TODO Auto-generated method stub
		return jpa;
	}




	




	@Override
	public void setSelect(ErpWageYgjxMx t) {
		// TODO Auto-generated method stub
		
	}




	@Override
	public void addWhere(Object[] t, List<Predicate> predicates, Root<ErpWageYgjxMx> root, CriteriaQuery<?> query,
			CriteriaBuilder cb) {
		// TODO Auto-generated method stub
		
	}
	
	
}
