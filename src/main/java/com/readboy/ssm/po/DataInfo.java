package com.readboy.ssm.po;
/**
 * 
 * @author:	   	LCL
 * @date: 	   	2017-7-8
 * @description:文件导入PO类，尝试一种新的方法导入mysql数据库
 */
public class DataInfo {
	private String fileDest;		//文件路径
	private String tableName;  		//要导入的表名
	
	public String getFileDest() {
		return fileDest;
	}
	public String getTableName() {
		return tableName;
	}
	public void setFileDest(String fileDest) {
		this.fileDest = fileDest;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
}
