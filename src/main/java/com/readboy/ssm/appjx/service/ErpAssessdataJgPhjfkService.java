package com.readboy.ssm.appjx.service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.readboy.ssm.appjx.dto.ErpAssessDataJgPhjfkDto;
import com.readboy.ssm.appjx.model.ErpAssessDataJgPhjfk;
import com.readboy.ssm.appnsh.model.TB_TJFX_BLDKKH;
import com.readboy.ssm.appnsh.util.SpringDataJpaFinder;
import com.readboy.ssm.appnsh.util.SpringDateJpaOper;
import com.readboy.ssm.utils.PageModel;
import com.readboy.ssm.utils.TimeUtil;

@Service
public class ErpAssessdataJgPhjfkService {
	
	
	
	@Autowired
	private ErpBasZbkService erpBasZbkService;


	@Autowired
	private JdbcTemplate jdbcTemplate;

	
	/**
	 * 分页查询机构业绩
	 * @param pageSize
	 * @param pageIndex
	 * @param yggh
	 * @param date
	 * @return
	 */
	public PageModel findPage(String zbwd,Integer pageSize,Integer pageIndex,String zzbz,Date b,Date end) {
		
		String sql =  "SELECT * from erp_assessdata_jg_phjfk "
				+ "where zzbz=? and tjrq >= ? and tjrq<=? and khwd= ? limit "+pageIndex*pageSize+","+pageSize ;
		List<ErpAssessDataJgPhjfk> content = jdbcTemplate.query(sql, new Object[] {zzbz,b,end,zbwd}, new BeanPropertyRowMapper<ErpAssessDataJgPhjfk>(ErpAssessDataJgPhjfk.class));
		PageModel pm = new PageModel();
		List<ErpAssessDataJgPhjfkDto> list = ErpAssessDataJgPhjfkDto.copy(content,erpBasZbkService);
		
		pm.setContent(list);
		
		String countsizeSql = "SELECT count(*) from erp_assessdata_jg_phjfk "
				+ "where zzbz=? and tjrq >= ? and tjrq<=? and khwd= ? ";
		long totalSize = jdbcTemplate.queryForLong(countsizeSql,zzbz,b,end,zbwd);
		int totalPages;
		if(totalSize%pageSize==0) {
			totalPages=(int) (totalSize/pageSize);
		}else {
			 totalPages = (int) ((totalSize/pageSize)+1);
		}
		
		pm.setTotalPages(totalPages);
		pm.setTotalSize(totalSize);
		return pm;
//		try {
//			
//			Page<ErpAssessDataJgPhjfk> page = this.findAllPage(new SpringDataJpaFinder<ErpAssessDataJgPhjfk>() {
//
//				@Override
//				public boolean where(List<Predicate> predicates, Root<ErpAssessDataJgPhjfk> root,
//						CriteriaQuery<?> query, CriteriaBuilder cb, Object... t) {
//					// TODO Auto-generated method stub
////					root.join("erpBasZbk",JoinType.LEFT);
//					SpringDateJpaOper<ErpAssessDataJgPhjfk> springDateJpaOper = new SpringDateJpaOper<>(root,query,cb);
//					springDateJpaOper.between(predicates, "tjrq", t[1], t[2]);
//					springDateJpaOper.eq("zzbz", t[0]);
//					springDateJpaOper.eq("khwd", t[3]);
//					return false;
//				}
//				
//			}, pageSize, pageIndex, zzbz,b,end,zbwd);
//			PageModel pm = new PageModel(page);
//			List<ErpAssessDataJgPhjfkDto> list = ErpAssessDataJgPhjfkDto.copy(page.getContent(),erpBasZbkService);
//			
//			pm.setContent(list);
//			return pm;
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return null;
		
	}
	
	
	/**
	 * 获取总得分
	 * @param zzbz
	 * @param date
	 * @return
	 */
	public String getDf(String zzbz,Date date,String KHWD) {
		Date b = TimeUtil.getTheFirstDayOfMonth(date);
		Date e = TimeUtil.getTheLastDayOfMonth(date);
		String sql =  "SELECT sum(zbdf) from erp_assessdata_jg_phjfk "
				+ "where zzbz=? and tjrq >= ? and tjrq<=? and khwd=?";
		BigDecimal res =  jdbcTemplate.queryForObject(sql, new Object[] {zzbz,b,e,KHWD}, BigDecimal.class);
		if(res==null) {
			return "0";
		}
		return res.toString();
	}
	
	
}
