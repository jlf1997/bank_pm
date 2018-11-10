package com.readboy.ssm.appjx.service;

import java.util.Date;
import java.util.List;

import javax.persistence.criteria.Predicate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.readboy.ssm.appjx.model.KhgxglCkkhyxdjb;
import com.readboy.ssm.appjx.model.KhgxglSjyhyxdjb;
import com.readboy.ssm.appnsh.util.NormalSpringDataJpaFinder;
import com.readboy.ssm.appnsh.util.SpringDateJpaOper;


@Service
public class YyjjService {

	
	@Autowired
	private KhgxglCkkhyxdjbService khgxglCkkhyxdjbService;
	@Autowired
	private KhgxglSjyhyxdjbService khgxglSjyhyxdjbService;
	
	
	public class khgxglSDJFinder<T> extends NormalSpringDataJpaFinder<T>{

		@Override
		public boolean setWhere(List<Predicate> predicates, SpringDateJpaOper<T> springDateJpaOper, Object... t) {
			// TODO Auto-generated method stub
			springDateJpaOper.eq(predicates,"yggh", t[0]);
			//过期
			if((int)t[1]<0) {
				springDateJpaOper.lt(predicates, "yyrq", new Date());
			}else {
				springDateJpaOper.ge(predicates, "yyrq", new Date());
			}
			return false;
		}

		
	}
	
	/**
	 * 存款预约数
	 * @param yggh 一员工工号
	 * @param type 类型 1匹配 -1过期
	 * @return
	 */
	public Long getKhgxglCkkhyxdjbCount(String yggh,Integer type) {
		return khgxglCkkhyxdjbService.count(new khgxglSDJFinder<KhgxglCkkhyxdjb>(), yggh,type);
	}
	/**
	 * 手机银行预约数
	 * @param yggh 一员工工号
	 * @param type 类型 1匹配 -1过期
	 * @return
	 */
	public Long getKhgxglSjyhyxdjbServiceCount(String yggh,Integer type) {
		return khgxglSjyhyxdjbService.count(new khgxglSDJFinder<KhgxglSjyhyxdjb>(), yggh,type);
	}
	
	
}
