package com.readboy.ssm.appnsh.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.readboy.ssm.appnsh.model.TB_TJFX_CDZL;

@Service
public class TB_TJFX_CDZLService {
	
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	
	
	public List<TB_TJFX_CDZL> findByTime(String yggh,Date b,Date end) {
		
		String sql = "select * from tb_tjfx_cdzl where yggh=? and tjrq>=? and tjrq<=?";
		
		List<TB_TJFX_CDZL> list = jdbcTemplate.query(sql, new Object[] {yggh,b,end}
		,new BeanPropertyRowMapper<TB_TJFX_CDZL>(TB_TJFX_CDZL.class));
		
		return list;
		
	}



	public List<TB_TJFX_CDZL> findByYggh(String yggh) {
		String sql = "select * from tb_tjfx_cdzl where yggh=? ";
		
		List<TB_TJFX_CDZL> list = jdbcTemplate.query(sql, new Object[] {yggh}
		,new BeanPropertyRowMapper<TB_TJFX_CDZL>(TB_TJFX_CDZL.class));
		
		return list;
	}
	
	 


}
