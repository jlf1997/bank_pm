package com.readboy.ssm.appnsh.service;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.readboy.ssm.appnsh.jpa.JdbcTemplatePageHelper;
import com.readboy.ssm.appnsh.model.TB_TJFX_CDZL;
import com.readboy.ssm.utils.LogsUtil;

@Service
public class TB_TJFX_CDZLService {
	
	private static final Logger log = LoggerFactory.getLogger(TB_TJFX_CDZLService.class);
	
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private JdbcTemplatePageHelper jdbcTemplatePageHelper;

	
	
	public List<TB_TJFX_CDZL> findByTime(String yggh,Date b,Date end) {
		
		String sql = "select * from tb_tjfx_cdzl where yggh=? and tjrq>=? and tjrq<=?";
		
		List<TB_TJFX_CDZL> list = jdbcTemplate.query(sql, new Object[] {yggh,b,end}
		,new BeanPropertyRowMapper<TB_TJFX_CDZL>(TB_TJFX_CDZL.class));
		
		return list;
		
	}



//	public List<TB_TJFX_CDZL> findByYggh(String yggh) {
//		List<TB_TJFX_CDZL> list = null;
//		try {
//			//tjrq 选最大的
//			String sql = "select * from tb_tjfx_cdzl where yggh=? order by tjrq desc limit 1";
//			
//			list = jdbcTemplate.query(sql, new Object[] {yggh}
//			,new BeanPropertyRowMapper<TB_TJFX_CDZL>(TB_TJFX_CDZL.class));
//		}catch(Exception e ) {
//			log.error("发生异常："+LogsUtil.getStackTrace(e));
//		}
//		
//		
//		return list;
//	}
	
	 



}
