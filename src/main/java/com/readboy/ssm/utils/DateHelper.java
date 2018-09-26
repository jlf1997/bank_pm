package com.readboy.ssm.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateHelper {
	static SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
	static SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
	static SimpleDateFormat sdf3 = new SimpleDateFormat("yyyyMM");
	//以"yyyyMM"这样的格式返回当前的年月
	public static  String getYearAndMonthAndDay(){
		Date date = new Date();
		return sdf.format(date);
	}
	public static  String getYearAndMonthAndDay(Date date){
		return sdf.format(date);
	}
	public static  String getRq(){
		Date date = new Date();
		return sdf2.format(date);
	}
	public static  String getRq(Date date){
		return sdf2.format(date);
	}
	public static String getYearAndMonth(){
		Date date = new Date();
		return sdf3.format(date);
	}
	public static String getYearAndMonth(Date date){
		return sdf3.format(date);
	}
	//timeStr is like 'yyyy-MM-dd'
	public static String getYearAndMonth(String timeStr){
		return timeStr.substring(0,timeStr.length()-3);
	}
}
