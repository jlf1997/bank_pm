package com.readboy.ssm.newtest.domain;



import java.util.Date;

/**
 * 表 demo_qq
 * 
 * @author xiangy
 * @date 2019-04-29
 */
public class DemoQq
{
	private static final long serialVersionUID = 1L;
	
	/**  */
	private Integer id;
	/**  */
	private String strPart;
	/**  */
	private Integer intPart;
	/**  */
	private Date datePart;
	/**  */
	private String textPart;
	/**  */
	private Double doublePart;

	public void setId(Integer id) 
	{
		this.id = id;
	}

	public Integer getId() 
	{
		return id;
	}
	public void setStrPart(String strPart) 
	{
		this.strPart = strPart;
	}

	public String getStrPart() 
	{
		return strPart;
	}
	public void setIntPart(Integer intPart) 
	{
		this.intPart = intPart;
	}

	public Integer getIntPart() 
	{
		return intPart;
	}
	public void setDatePart(Date datePart) 
	{
		this.datePart = datePart;
	}

	public Date getDatePart() 
	{
		return datePart;
	}
	public void setTextPart(String textPart) 
	{
		this.textPart = textPart;
	}

	public String getTextPart() 
	{
		return textPart;
	}
	public void setDoublePart(Double doublePart) 
	{
		this.doublePart = doublePart;
	}

	public Double getDoublePart() 
	{
		return doublePart;
	}


}
