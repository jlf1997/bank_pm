package com.readboy.ssm.appnsh.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "demo")
@Entity
public class Demo {

	@Id
	private Long id;
	
	private String name;
	
	private String age;
	
	private Integer iuu;
	
	private String dsd;
	
	

	

	public Integer getIuu() {
		return iuu;
	}

	public void setIuu(Integer iuu) {
		this.iuu = iuu;
	}

	public String getDsd() {
		return dsd;
	}

	public void setDsd(String dsd) {
		this.dsd = dsd;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}
	
	
}
