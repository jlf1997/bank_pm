package com.readboy.ssm.appjx.jpa;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import com.readboy.ssm.appjx.model.ErpAssessDataJgPhjfk;


/**
 * 类ErpAssessdataJgPhjfkServiceImpl的实现描述：
 * @author suhuanzhao 2018-11-08 19:25:45
 */

public interface ErpAssessdataJgPhjfkJpa extends JpaRepository<ErpAssessDataJgPhjfk, Long>,JpaSpecificationExecutor<ErpAssessDataJgPhjfk>  {
    
	/**
	 * 获取总得分
	 * @param zzbz
	 * @param date
	 * @return
	 */
	@Query(value="SELECT sum(zbdf) from erp_assessdata_jg_phjfk where zzbz=?1 and tjrq BETWEEN ?2 and ?3",nativeQuery=true)
	public BigDecimal getDfs(String zzbz,Date b,Date e);
}