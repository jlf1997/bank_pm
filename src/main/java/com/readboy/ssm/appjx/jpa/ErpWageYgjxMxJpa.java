package com.readboy.ssm.appjx.jpa;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import com.readboy.ssm.appjx.dto.YgjxMxDto;
import com.readboy.ssm.appjx.model.ErpWageYgjxMx;


/**
 * 类ErpWageYgjxMxServiceImpl的实现描述：
 * @author suhuanzhao 2018-11-08 17:24:15
 */

public interface ErpWageYgjxMxJpa extends JpaRepository<ErpWageYgjxMx, String>,JpaSpecificationExecutor<ErpWageYgjxMx>  {
    
	@Query(value="SELECT zbk.zbmc as ZBMC from erp_wage_ygjx_mx mx left join erp_bas_zbk zbk on mx.ZBID=zbk.ZBID "
			+ "where yggh=?1 and gzrq BETWEEN ?2 and ?3 and mx.zblb = ?4",nativeQuery=true)
	public List<YgjxMxDto> findMx(String yggh,Date b,Date e,Integer zblb);
	
	@Query(value="SELECT sum(zbgz)  from erp_wage_ygjx_mx mx  "
			+ "where yggh=?1 and gzrq BETWEEN ?2 and ?3 and mx.zblb = ?4",nativeQuery=true)
	public BigDecimal findZj(String yggh,Date b,Date e,Integer zblb);
	
	
}