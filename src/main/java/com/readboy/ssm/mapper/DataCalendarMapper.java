package com.readboy.ssm.mapper;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.readboy.ssm.po.DataCalendar;
import com.readboy.ssm.po.PageOption;

public interface DataCalendarMapper {
	
	//根据日期和数据状态查询日历表
	public DataCalendar findDataCalendarByCond(
			@Param("data_time") String data_time, @Param("data_type")Integer data_type,
			@Param("data_status")Integer data_status) throws Exception;
	
	//插入数据导入记录
	public Integer insertDataCalendar(DataCalendar dataCalendar)throws Exception;
	
	//public List<DataCalendar> findAllDataCalendar() throws Exception;
	
	//条件查询数据导入导出日志
	public List<DataCalendar> pageFindDataCalendarByCond(@Param("data_time") String data_time,
			@Param("data_type") Integer data_type,
			@Param("data_status") Integer data_status,@Param("page") PageOption page)throws Exception;;
	
	//查询记录条数
	public Integer pageFindDataCountByCond(@Param("data_time") String data_time,
			@Param("data_type") Integer data_type,@Param("data_status") Integer data_status)throws Exception;
	
	//修改导入状态，标记为2意思是需要重新导入
	public Integer updateDataCalendar(@Param("data_time") String data_time,
			@Param("data_type") Integer data_type,@Param("data_status") Integer data_status);
	
	//查询指定日期是否存在记录，若存在返回主键，否则返回null
	public Long findDataCalendarExistByCond(@Param("data_time") String data_time,
			@Param("data_type") Integer data_type) throws Exception;
	
	public Integer updateEntireDataCalendar(DataCalendar dataCalendar) throws Exception;
	
	//查询未导入成功的最小日期
	public String findMinDateByCond(@Param("data_time") String data_time,
			@Param("data_type") Integer data_type)  throws Exception;
	
}
