package com.readboy.ssm.service;


import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.readboy.ssm.po.DataCalendar;
import com.readboy.ssm.po.PageOption;

public interface DataCalendarService {
	
		//根据日期和数据状态查询日历表 ,data_type：1导入,0导出 ,status:1成功，0失败
		public DataCalendar findDataCalendarByCond(
				String data_time,Integer data_type,
				Integer data_status) throws Exception;
		
		public Integer insertDataCalendar(DataCalendar dataCalendar)throws Exception;
		
		//条件查询数据导入导出日志
		public List<DataCalendar> pageFindDataCalendarByCond( String data_time,Integer data_type,
				Integer data_status, PageOption page) throws Exception;;
		
		//查询记录条数
		public Integer pageFindDataCountByCond(String data_time,Integer data_type, 
				Integer data_status) throws Exception;
		
		//更新日历表记录
		public Integer updateDataCalendar(String data_time,Integer data_type,Integer data_status) 
				throws Exception;
		
		public Integer updateEntireDataCalendar(DataCalendar dataCalendar) throws Exception;
		
		//查看指定日期是否存在导入或导出记录
		public Long findDataCalendarExistByCond(String data_time,Integer data_type) throws Exception;
		
		public String findMinDateByCond(String data_time,Integer data_type) throws Exception;
}
