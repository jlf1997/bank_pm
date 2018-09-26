package com.readboy.ssm.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class TableHelper {
	
	public static String getTableNameByDate(String prefix,String suffix){
		StringBuilder sb = new StringBuilder(prefix);
		sb.append("_").append(suffix.substring(0,4));
		sb.append(suffix.substring(5,7));
		return sb.toString();
	}
	
	public static int getDaysOfMonth(String dateStr){
		if(dateStr.length() >= 7){
			dateStr = dateStr.substring(0,7)+"-01";
		}
		 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		 Calendar c = Calendar.getInstance();
		 try {
			c.setTime(sdf.parse(dateStr));
			return c.getActualMaximum(Calendar.DAY_OF_MONTH);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return 0;
	}
}
