package com.readboy.ssm.appnsh.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import com.readboy.ssm.appnsh.jpa.JdbcTemplatePageHelper;
import com.readboy.ssm.appnsh.model.TB_TJFX_BLDKKH;
import com.readboy.ssm.appnsh.model.TB_TJFX_CDKPM;

@Service
public class TB_TJFX_CDKPMService {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private JdbcTemplatePageHelper jdbcTemplatePageHelper;
	

	public List<TB_TJFX_CDKPM> findTop10(int ywlx, String yggh) {
		// TODO Auto-generated method stub
		String sql = "select * from tb_tjfx_cdkpm where yggh=? and ywlx=?  order by je desc limit 10";
		
		List<TB_TJFX_CDKPM> list = jdbcTemplate.query(sql, new Object[] {yggh,ywlx}
		,new BeanPropertyRowMapper<TB_TJFX_CDKPM>(TB_TJFX_CDKPM.class));
		
		return list;
	}
	
	
//	public Map getPages(String yggh, Integer khlx, Integer pageSize, Integer pageIndex) {
//		// TODO Auto-generated method stub
//		String sql = " from tb_tjfx_cdkpm where yggh=? and khlx=? ";
//		RowMapper<TB_TJFX_CDKPM> rowMap = new BeanPropertyRowMapper<TB_TJFX_CDKPM>(TB_TJFX_CDKPM.class);
//		return jdbcTemplatePageHelper.getPageMapTemp(sql, pageIndex, pageSize, rowMap, yggh,khlx);
//		
//	}
	

	



}
