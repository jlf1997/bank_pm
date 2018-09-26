package com.readboy.ssm.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.readboy.ssm.mapper.DataCalendarMapper;
import com.readboy.ssm.po.DataCalendar;
import com.readboy.ssm.po.PageOption;
import com.readboy.ssm.service.DataCalendarService;

public class DataCalendarServiceImpl implements DataCalendarService{
	
	@Autowired
	private DataCalendarMapper dataCalendarMapper;

	@Override
	public Integer insertDataCalendar(DataCalendar dataCalendar) throws Exception {
		// TODO Auto-generated method stub
		return dataCalendarMapper.insertDataCalendar(dataCalendar);
	}

	@Override
	public DataCalendar findDataCalendarByCond(String data_time, Integer data_type, Integer data_status)
			throws Exception {
		// TODO Auto-generated method stub
		return dataCalendarMapper.findDataCalendarByCond(data_time, data_type, data_status);
	}

	@Override
	public List<DataCalendar> pageFindDataCalendarByCond(String data_time, Integer data_type, Integer data_status,
			PageOption page) throws Exception {
		// TODO Auto-generated method stub
		return dataCalendarMapper.pageFindDataCalendarByCond(data_time, data_type, data_status, page);
	}

	@Override
	public Integer pageFindDataCountByCond(String data_time, Integer data_type, Integer data_status) throws Exception {
		// TODO Auto-generated method stub
		return dataCalendarMapper.pageFindDataCountByCond(data_time, data_type, data_status);
	}

	@Override
	public Integer updateDataCalendar(String data_time, Integer data_type, Integer data_status) throws Exception {
		// TODO Auto-generated method stub
		return dataCalendarMapper.updateDataCalendar(data_time, data_type, data_status);
	}

	@Override
	public Long findDataCalendarExistByCond(String data_time, Integer data_type) throws Exception {
		// TODO Auto-generated method stub
		return dataCalendarMapper.findDataCalendarExistByCond(data_time, data_type);
	}

	@Override
	public Integer updateEntireDataCalendar(DataCalendar dataCalendar) throws Exception {
		// TODO Auto-generated method stub
		return dataCalendarMapper.updateEntireDataCalendar(dataCalendar);
	}

	@Override
	public String findMinDateByCond(String data_time, Integer data_type) throws Exception {
		// TODO Auto-generated method stub
		return dataCalendarMapper.findMinDateByCond(data_time, data_type);
	}
	

}
