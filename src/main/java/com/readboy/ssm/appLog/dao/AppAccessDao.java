package com.readboy.ssm.appLog.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.readboy.ssm.appLog.model.SysBasQypz;
import com.readboy.ssm.appnsh.jpa.JdbcTemplatePageHelper;


@Repository
public class AppAccessDao {

	
	@Autowired	
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private JdbcTemplatePageHelper jdbcTemplatePageHelper;
	
	public List<SysBasQypz> getSysBasQypzList(){
		
	String sql = "select * from sys_bas_qypz where sfqy=1 ";
	List<SysBasQypz> list = jdbcTemplate.query(sql, new Object[] {}
	,new BeanPropertyRowMapper<SysBasQypz>(SysBasQypz.class));
	return list;
		
	}
	
	
	public Map getPages(Integer pageSize, Integer pageIndex) {
		// TODO Auto-generated method stub
		String sql = "select count(*) from sys_bas_qypz where sfqy=1 ";
		
		String sqlPage = "select * from sys_bas_qypz where sfqy=1 ";
		RowMapper<SysBasQypz> rowMap = new BeanPropertyRowMapper<SysBasQypz>(SysBasQypz.class);
		Map map =  jdbcTemplatePageHelper.getPageMap(sqlPage,sql, pageIndex, pageSize, rowMap);
	
		return map;
	}


	public boolean save(SysBasQypz sysBasQypz) {
		// TODO Auto-generated method stub
		String sql = "insert into sys_bas_qypz(fwdk,fwdz,qydm,qymc,sfqy) values(?,?,?,?,?)";
		Object args[] = {sysBasQypz.getFwdk(),sysBasQypz.getFwdz(),sysBasQypz.getQydm()
				,sysBasQypz.getQymc(),sysBasQypz.getSfqy()};
		int temp = jdbcTemplate.update(sql, args);
		return temp>0;
	}
}



