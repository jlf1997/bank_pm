package com.readboy.ssm.appnsh.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.readboy.ssm.appnsh.jpa.JdbcTemplatePageHelper;
import com.readboy.ssm.appnsh.model.TB_TJFX_CDZL;
import com.readboy.ssm.appnsh.model.TB_TJFX_CDZL_N;
import com.readboy.ssm.utils.LogsUtil;

@Service
public class TB_TJFX_CDZL_NService {
	
	private static final Logger log = LoggerFactory.getLogger(TB_TJFX_CDZL_NService.class);
	
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private JdbcTemplatePageHelper jdbcTemplatePageHelper;

	
	
	



	public List<TB_TJFX_CDZL_N> findByYggh(String yggh) {
		List<TB_TJFX_CDZL_N> list = null;
		try {
			String sql = "select * from tb_tjfx_cdzl_n where yggh=?  limit 1";
			
			list = jdbcTemplate.query(sql, new Object[] {yggh}
			,new BeanPropertyRowMapper<TB_TJFX_CDZL_N>(TB_TJFX_CDZL_N.class));
		}catch(Exception e ) {
			log.error("发生异常："+LogsUtil.getStackTrace(e));
		}
		
		
		return list;
	}
	
	 



}
