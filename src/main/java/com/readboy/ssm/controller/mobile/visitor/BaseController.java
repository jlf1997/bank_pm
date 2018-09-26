package com.readboy.ssm.controller.mobile.visitor;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConversionException;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;

public class BaseController {

	{
		ConvertUtils.register(new Converter(){

			@Override
			public Object convert(Class arg0, Object value) {

				if(!(value instanceof String)){
					throw new ConversionException("不是String数据类型！");
				}
				String strValue = (String)value;
				if(strValue.trim().equals("")){
					return null;
				}
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				try {
					return sdf.parse(strValue);
				} catch (ParseException e) {
					throw new RuntimeException(e);
				}
			}
		}, Date.class);
	}
	
	/**
	 * 得到PageData
	 */
	public PageData getPageData() {
		return new PageData(this.getRequest());
	}

	/**
	 * 得到request对象
	 */
	public HttpServletRequest getRequest() {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		return request;
	}
	
	/**
	 * 得到JavaBean对象
	 */
	public <T> T getBean(Class<T> beanClass) {
		HttpServletRequest request = getRequest();
		try {
			T bean = beanClass.newInstance();
			Enumeration en = request.getParameterNames();
			while (en.hasMoreElements()) {
				String name = (String) en.nextElement();
				String value = request.getParameter(name);
				BeanUtils.setProperty(bean, name, value);
			}
			return bean;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
