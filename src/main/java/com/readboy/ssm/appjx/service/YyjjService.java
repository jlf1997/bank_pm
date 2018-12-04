package com.readboy.ssm.appjx.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.criteria.Predicate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import com.readboy.ssm.appjx.model.KhgxglCkkhyxdjb;
import com.readboy.ssm.appjx.model.KhgxglSjyhyxdjb;
import com.readboy.ssm.appjx.model.YyyjDetail;
import com.readboy.ssm.appnsh.jpa.JdbcTemplatePageHelper;
import com.readboy.ssm.appnsh.util.NormalSpringDataJpaFinder;
import com.readboy.ssm.appnsh.util.SpringDateJpaOper;


@Service
public class YyjjService {

	
	@Autowired
	private KhgxglCkkhyxdjbService khgxglCkkhyxdjbService;
	@Autowired
	private KhgxglSjyhyxdjbService khgxglSjyhyxdjbService;
	
	
	
	
	@Autowired
	private JdbcTemplatePageHelper jdbcTemplatePageHelper;
	
	
	public class khgxglSDJFinder<T> extends NormalSpringDataJpaFinder<T>{

		@Override
		public boolean setWhere(List<Predicate> predicates, SpringDateJpaOper<T> springDateJpaOper, Object... t) {
			// TODO Auto-generated method stub
			springDateJpaOper.eq(predicates,"yggh", t[0]);
			springDateJpaOper.eq(predicates, "sbzt",t[1]);
//			//过期
//			if((int)t[1]<0) {
//				springDateJpaOper.lt(predicates, "sbzt", new Date());
//			}else {
//				springDateJpaOper.ge(predicates, "sbzt", new Date());
//			}
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
	 * @param type 类型 1匹配 0未匹配
	 * @return
	 */
	public Long getKhgxglSjyhyxdjbServiceCount(String yggh,Integer type) {
		return khgxglSjyhyxdjbService.count(new khgxglSDJFinder<KhgxglSjyhyxdjb>(), yggh,type);
	}
	
	
	public Map getYyyjDetailPage(Integer sbzt,String yggh, Integer pageSize, Integer pageIndex) {
		
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("yggh", yggh);
		params.put("sbzt", sbzt);
		String sql = " select Sum(c) from "
				+ "(SELECT count(*) as c from khgxgl_sjyhyxdjb tb1  where yggh=? and sbzt=? "
				+ "UNION  ALL "
				+ "select count(*) as c  from khgxgl_ckkhyxdjb tb2  where yggh=? and sbzt=? ) as t3"; 
		
		String sqlPage = "select * from (SELECT sbzt,yybh,khmc,sjhm,YYRQ,org.ZZJC as jgmc ,'sj' as type,yggh from khgxgl_sjyhyxdjb tb left JOIN hr_bas_organization org on tb.jgdm = org.YWJGDM where yggh=? and sbzt=? " + 
				" UNION ALL " + 
				" select sbzt,yybh,khmc,sjhm,YYRQ,org.ZZJC as jgmc,'ck' as type ,yggh from khgxgl_ckkhyxdjb tb left JOIN hr_bas_organization org on tb.jgdm = org.YWJGDM where yggh=? and sbzt=? ) as uu ";
		
		RowMapper<YyyjDetail> rowMap = new BeanPropertyRowMapper<YyyjDetail>(YyyjDetail.class);
		Map map =  jdbcTemplatePageHelper.getPageMap(sqlPage,sql, pageIndex, pageSize, rowMap, yggh,sbzt,yggh,sbzt);
		return map;
	}
	
	
}
