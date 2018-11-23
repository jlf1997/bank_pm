package com.readboy.ssm.appjx.service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Service;

import com.readboy.ssm.appjx.jpa.ErpWageYgjxJpa;
import com.readboy.ssm.appjx.model.ErpWageYgjx;
import com.readboy.ssm.appjx.model.pk.JXPK;
import com.readboy.ssm.appnsh.util.Finder;
import com.readboy.ssm.utils.TimeUtil;

@Service
public class ErpWageYgjxService extends Finder<ErpWageYgjx, JXPK>{
	
	
	@Autowired
	private ErpWageYgjxJpa jpa;

	@Override
	public JpaSpecificationExecutor<ErpWageYgjx> specjpa() {
		// TODO Auto-generated method stub
		return jpa;
	}

	@Override
	public JpaRepository<ErpWageYgjx, JXPK> jpa() {
		// TODO Auto-generated method stub
		return jpa;
	}


	@Override
	public void setSelect(ErpWageYgjx t) {
		// TODO Auto-generated method stub
		
	}

	
	/**
	 * 获取当月
	 * @param month
	 * @param yggh
	 * @return
	 */
	public BigDecimal getMonthZj(Date month,String yggh) {
		Date b = TimeUtil.getTheFirstDayOfMonth(month);
		Date e = TimeUtil.getTheLastDayOfMonth(month);
		return jpa.getMonthZj(b, e, yggh);
	}

	/**
	 * 获取当日
	 * @param day
	 * @param yggh
	 * @return
	 */
	public ErpWageYgjx findPerformance(Date day,String yggh) {
		Date b = TimeUtil.getStartTime(day);
		Date e = TimeUtil.getEndTime(day);
		return jpa.findPerformance(b, e, yggh);
	}
	
	/**
	 * 获取真实工资
	 * @param day
	 * @param yggh
	 * @return
	 */
	public BigDecimal getGz(Date day,String yggh) {
		ErpWageYgjx ygjx = findPerformance(day,yggh);
		BigDecimal ngz = new BigDecimal("0");
		if(ygjx!=null) {
			ngz = ygjx.getGzhj();
		}
		//判断day是否是第一天 如果是则直接返回
		Date fdInMonth = TimeUtil.getTheFirstDayOfMonth(day);
		boolean isFirstDay = TimeUtil.isInDay(day, fdInMonth);
		if(isFirstDay) {
			return ngz;
		}
		ErpWageYgjx lastDay = findPerformance(TimeUtil.getDay(day, -1),yggh);
		BigDecimal ygz = new BigDecimal("0");
		if(lastDay!=null) {
			ygz = lastDay.getGzhj();
		}
		return ngz.subtract(ygz);
	}
	
	public BigDecimal getGzMonth(Date day,String yggh) {
		ErpWageYgjx ygjx;
		Date now = new Date();
		
		//如果day是当前月 取现在时间的数据
//		if(TimeUtil.isInMonth(day, now)) {
//			 ygjx = findPerformance(day,yggh);
//		}else {//否则取day所在月最后一天的数据
//			 ygjx = findPerformance(TimeUtil.getTheLastDayOfMonth(day),yggh);
//		}
		
		ygjx = findPerformance(day,yggh);
		BigDecimal ngz = new BigDecimal("0");
		if(ygjx!=null) {
			ngz = ygjx.getGzhj();
		}
		return ngz;
		
		
		
		
	}

	@Override
	public void addWhere(Object[] t, List<Predicate> predicates, Root<ErpWageYgjx> root, CriteriaQuery<?> query,
			CriteriaBuilder cb) {
		// TODO Auto-generated method stub
		
	}
	
	
}
