package com.test;

import java.lang.reflect.InvocationTargetException;

import java.lang.reflect.Method;
import java.io.File;
import java.lang.reflect.Field;
import java.math.BigDecimal;

import com.readboy.ssm.po.Marketing;
import com.readboy.ssm.po.PerformanceDkmnlrgzMx;
import com.readboy.ssm.po.PosMarketing;

public class RefelctTest {
	
	public static void main(String args[]){
		
	}
	
	

	
	
	
	
	
	private void f1() {
		PosMarketing pdm = new PosMarketing();
		Class<?> clazz = pdm.getClass();
		Field fields[] = null;
		if(!clazz.getSuperclass().getSimpleName().equals("Object")){
			fields = clazz.getSuperclass().getDeclaredFields();
/*			System.out.println(clazz.getSuperclass().getSimpleName());
			System.out.println(new Marketing().getClass().getSuperclass().getSimpleName());*/
		}
		fields = clazz.getSuperclass().getDeclaredFields();
	        for(int i = 0; i < fields.length; i++){
	            String fieldName = fields[i].getName();
	            String fieldType = fields[i].getType().getSimpleName();
	            System.out.println(fieldType);
	            //System.out.println(fields[i].getGenericType());
				Method setMethod;
				try {
					setMethod = clazz.getMethod("set"+fieldName.substring(0,1).toUpperCase()+
							fieldName.substring(1),fields[i].getType());
					String test = "111";
					if(fieldType.equals("String")){
						setMethod.invoke(pdm,test);
					}else if(fieldType.equals("long")){
						setMethod.invoke(pdm, Long.parseLong(test));
					}else if(fieldType.equals("BigDecimal")){
						setMethod.invoke(pdm, new BigDecimal(test));
					}else if(fieldType.equals("int")){
						setMethod.invoke(pdm, Integer.parseInt(test));
					}else{
						setMethod.invoke(pdm,test);
					}
				} catch (NoSuchMethodException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SecurityException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
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
	        System.out.println("-----------------开始输出-------------------");
	        for(int i = 0; i < fields.length; i++){
	        	String fieldName = fields[i].getName();
	        	try {
					Method getMethod = clazz.getMethod("get"+fieldName.substring(0,1).toUpperCase()+
							fieldName.substring(1));
					System.out.println(fieldName+":"+getMethod.invoke(pdm));
					} catch (IllegalAccessException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IllegalArgumentException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
				} catch (NoSuchMethodException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SecurityException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	        }
	}
}
