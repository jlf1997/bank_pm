package com.readboy.ssm.appnsh.jpa;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.readboy.ssm.timetask.OnApplicationStarted;
import com.readboy.ssm.utils.LogsUtil;

@Component
public class JdbcTemplatePageHelper {
	
	private static final Logger log = LoggerFactory.getLogger(JdbcTemplatePageHelper.class);

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	
	public  <T> Map<String,Object> getPageMap(String sql,String countSql,Integer pageIndex,Integer pageSize,RowMapper<T> rowMap,Object...args) {
		Map<String,Object> map = new HashMap<>();
		try {
			String pageSql = "("+sql+" ) limit "+pageIndex*pageSize+","+pageSize;
			List<T> content = jdbcTemplate.query(pageSql,args,rowMap);
			long totalSize = jdbcTemplate.queryForLong(countSql,args);
			int totalPages;
			if(totalSize%pageSize==0) {
				totalPages=(int) (totalSize/pageSize);
			}else {
				 totalPages = (int) ((totalSize/pageSize)+1);
			}
			map.put("content",content);
			map.put("totalPages",totalPages);
			map.put("totalSize",totalSize);
		}catch(Exception e) {
			log.error(LogsUtil.getStackTrace(e));
		}
		return map;
	}
	
	public  <T> Map<String,Object> getPageMapTemp(String sql,Integer pageIndex,Integer pageSize,RowMapper<T> rowMap,Object...args) {
		String listSql = "select * "+sql;
		String countSql = "select count(*) "+sql;
		return this.getPageMap(listSql, countSql, pageIndex, pageSize, rowMap, args);
	}
}
