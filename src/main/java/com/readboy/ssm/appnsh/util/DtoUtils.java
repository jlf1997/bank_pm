package com.readboy.ssm.appnsh.util;

import java.util.List;

import org.springframework.beans.BeanUtils;

public class DtoUtils {

	
	public void copeList(List source,List target) {
		
		for(int i=0;i<source.size();i++) {
			BeanUtils.copyProperties(source.get(i), target);
		}
	}
}
