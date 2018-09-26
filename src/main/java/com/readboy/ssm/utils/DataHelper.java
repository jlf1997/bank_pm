package com.readboy.ssm.utils;
import java.util.ArrayList;
import java.util.List;
import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import com.readboy.ssm.po.*;
/**
 * @author:	   	LCL
 * @param <T>
 * @date: 	   	2017-7-4
 * @description:数据导入类，利用反射和泛型，需要PO类和TXT文件中的字段顺序一致，所以PO类的字段顺序不可乱改
 */
public class DataHelper<T>{
	
	public <T>List<T> dataLoad(Class<?> clazz,ArrayList<ArrayList<String>> lists){
		List<T> mList = new ArrayList<T>();
		Field fields[]= clazz.getDeclaredFields();
		//取出每一条记录
		for(List<String> note : lists){
			try {
				T obj = (T)clazz.newInstance();
				//对每条记录的每个字段遍历
				for(int i = 0,len = note.size(); i < len; i++){
					String v = note.get(i);
					if(v.equals("") || v == null){
						continue;
					}
					String fieldName = fields[i].getName();
					Method setMethod = clazz.getMethod("set"+fieldName.substring(0,1).toUpperCase()+
							fieldName.substring(1),fields[i].getType());
					String fieldTypeName = fields[i].getType().getSimpleName();
					if(fieldTypeName.equalsIgnoreCase("String")){
						setMethod.invoke(obj, v);
					}else if(fieldTypeName.equalsIgnoreCase("BigDecimal")){
						setMethod.invoke(obj, new BigDecimal(v));
					}else if(fieldTypeName.equalsIgnoreCase("int")){
						setMethod.invoke(obj, Integer.parseInt(v));
					}else if(fieldTypeName.equalsIgnoreCase("long")){
						setMethod.invoke(obj, Long.parseLong(note.get(i)));
					}else{//其他
						setMethod.invoke(obj, v);
					}
				}
				mList.add(obj);
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NoSuchMethodException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return mList;
	}
	
}
