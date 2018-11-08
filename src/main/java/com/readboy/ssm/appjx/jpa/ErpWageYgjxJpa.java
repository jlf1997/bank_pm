package com.readboy.ssm.appjx.jpa;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import com.readboy.ssm.appjx.model.ErpWageYgjx;
import com.readboy.ssm.appjx.model.pk.JXPK;


/**
 * 类ErpWageYgjxServiceImpl的实现描述：
 * @author suhuanzhao 2018-11-08 17:24:15
 */

public interface ErpWageYgjxJpa extends JpaRepository<ErpWageYgjx, JXPK>,JpaSpecificationExecutor<ErpWageYgjx>  {
    
	@Query(value="select sum(gzhj) from erp_wage_ygjx where GZRQ BETWEEN ?1 and ?2 and yggh=?3",nativeQuery=true)
	public BigDecimal getMonthZj(Date b,Date e,String yggh );
}