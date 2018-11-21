package com.readboy.ssm.appnsh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.readboy.ssm.appnsh.dto.TB_TJFX_CKDKHDto;
import com.readboy.ssm.appnsh.model.TB_TJFX_CKDKH;

@Service
public class TB_TJFX_CKDKHService{
	
	
	
	@Autowired
	private OrgService orgService;

	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	

	

	public int getCount(String yggh,int khlx) {
		String sql = "select * from tb_tjfx_ckdkh where yggh=? and khlx=? ";
		List<TB_TJFX_CKDKH> list = jdbcTemplate.query(sql, new Object[] {yggh,khlx}
		,new BeanPropertyRowMapper<TB_TJFX_CKDKH>(TB_TJFX_CKDKH.class));
		if(list!=null) {
			return list.size();
		}
		return 0;
		
	}
	
	public List<TB_TJFX_CKDKHDto> getTB_TJFX_BLDKKHByYgghAndKHLX(String yggh,Integer khlx){
		String sql = "select * from tb_tjfx_ckdkh where yggh=? and khlx=? ";
		List<TB_TJFX_CKDKH> list = jdbcTemplate.query(sql, new Object[] {yggh,khlx}
		,new BeanPropertyRowMapper<TB_TJFX_CKDKH>(TB_TJFX_CKDKH.class));
		return TB_TJFX_CKDKHDto.copyList(list,orgService);
		
	}


}
