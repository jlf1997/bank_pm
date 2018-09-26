package com.readboy.ssm.controller.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Date;
import org.springframework.core.convert.converter.Converter;

//自定义日期类型数据的绑定
public class CustomDateConverter implements Converter<String,Date>{

	@Override
	public Date convert(String source) {
		// TODO Auto-generated method stub
		//日期的格式
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  
		try {
			Date d = (Date)sdf.parse(source);
			System.out.println(sdf.format(d));
			return d;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	
}
