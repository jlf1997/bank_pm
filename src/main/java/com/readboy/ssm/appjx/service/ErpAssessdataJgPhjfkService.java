package com.readboy.ssm.appjx.service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Service;

import com.readboy.ssm.appjx.dto.ErpAssessDataJgPhjfkDto;
import com.readboy.ssm.appjx.jpa.ErpAssessdataJgPhjfkJpa;
import com.readboy.ssm.appjx.model.ErpAssessDataJgPhjfk;
import com.readboy.ssm.appnsh.util.Finder;
import com.readboy.ssm.appnsh.util.SpringDataJpaFinder;
import com.readboy.ssm.appnsh.util.SpringDateJpaOper;
import com.readboy.ssm.po.StaffAndPost;
import com.readboy.ssm.service.StaffAndPostService;
import com.readboy.ssm.utils.PageModel;
import com.readboy.ssm.utils.TimeUtil;

@Service
public class ErpAssessdataJgPhjfkService extends Finder<ErpAssessDataJgPhjfk, Long>{
	
	
	@Autowired
	private ErpAssessdataJgPhjfkJpa jpa;
	@Autowired
	private ErpBasZbkService erpBasZbkService;


	@Override
	public JpaSpecificationExecutor<ErpAssessDataJgPhjfk> specjpa() {
		// TODO Auto-generated method stub
		return jpa;
	}

	@Override
	public JpaRepository<ErpAssessDataJgPhjfk, Long> jpa() {
		// TODO Auto-generated method stub
		return jpa;
	}

	

	@Override
	public void setSelect(ErpAssessDataJgPhjfk t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addWhere(Object[] t, List<Predicate> predicates, Root<ErpAssessDataJgPhjfk> root,
			CriteriaQuery<?> query, CriteriaBuilder cb) {
		// TODO Auto-generated method stub
		
	}


	
	/**
	 * 分页查询机构业绩
	 * @param pageSize
	 * @param pageIndex
	 * @param yggh
	 * @param date
	 * @return
	 */
	public PageModel findPage(String zbwd,Integer pageSize,Integer pageIndex,String zzbz,Date b,Date end) {
		try {
			
			Page<ErpAssessDataJgPhjfk> page = this.findAllPage(new SpringDataJpaFinder<ErpAssessDataJgPhjfk>() {

				@Override
				public boolean where(List<Predicate> predicates, Root<ErpAssessDataJgPhjfk> root,
						CriteriaQuery<?> query, CriteriaBuilder cb, Object... t) {
					// TODO Auto-generated method stub
//					root.join("erpBasZbk",JoinType.LEFT);
					SpringDateJpaOper<ErpAssessDataJgPhjfk> springDateJpaOper = new SpringDateJpaOper<>(root,query,cb);
					springDateJpaOper.between(predicates, "tjrq", t[1], t[2]);
					springDateJpaOper.eq("zzbz", t[0]);
					springDateJpaOper.eq("khwd", t[3]);
					return false;
				}
				
			}, pageSize, pageIndex, zzbz,b,end,zbwd);
			PageModel pm = new PageModel(page);
			List<ErpAssessDataJgPhjfkDto> list = ErpAssessDataJgPhjfkDto.copy(page.getContent(),erpBasZbkService);
			
			pm.setContent(list);
			return pm;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}
	
	
	/**
	 * 获取总得分
	 * @return
	 */
	public String getDf(String zzbz,Date date) {
		Date b = TimeUtil.getTheFirstDayOfMonth(date);
		Date e = TimeUtil.getTheLastDayOfMonth(date);
		BigDecimal res = jpa.getDfs(zzbz, b,e);
		if(res==null) {
			return "0";
		}
		return res.toString();
	}
	
	
}
