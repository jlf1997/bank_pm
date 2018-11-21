package com.readboy.ssm.appnsh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.readboy.ssm.appnsh.dto.TB_TJFX_DKDQKHDto;
import com.readboy.ssm.appnsh.model.TB_TJFX_DKDQKH;

@Service
public class TB_TJFX_DKDQKHService {
	

	
	@Autowired
	private OrgService orgService;

	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	

	
	public int getCount(String yggh,int khlx) {
		String sql = "select * from tb_tjfx_dkdqkh where yggh=? and khlx=? ";
		List<TB_TJFX_DKDQKH> list = jdbcTemplate.query(sql, new Object[] {yggh,khlx}
		,new BeanPropertyRowMapper<TB_TJFX_DKDQKH>(TB_TJFX_DKDQKH.class));
		if(list!=null) {
			return list.size();
		}
		return 0;
		
	}
	
	public List<TB_TJFX_DKDQKHDto> getTB_TJFX_BLDKKHByYgghAndKHLX(String yggh,Integer khlx){
		String sql = "select * from tb_tjfx_dkdqkh where yggh=? and khlx=? ";
		List<TB_TJFX_DKDQKH> list = jdbcTemplate.query(sql, new Object[] {yggh,khlx}
		,new BeanPropertyRowMapper<TB_TJFX_DKDQKH>(TB_TJFX_DKDQKH.class));
		return TB_TJFX_DKDQKHDto.copyList(list,orgService);
		
	}

	

}
