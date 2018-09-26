package com.readboy.ssm.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import com.readboy.ssm.mapper.AreaMapper;
import com.readboy.ssm.service.AreaService;
import com.readboy.ssm.serviceImpl.AreaServiceImpl;

public class FileHelper {
	private static final String logFilePath = "log.txt";
	private static final String exportLogFilePath = "exportLog.txt";
	//删除一个文件夹下的所有文件
	public static void deleteFilesInDirectory(File parentFile){
		if(!parentFile.exists()) return;
		File[] files = parentFile.listFiles();
		for(File f : files){
			if(f.isFile()){
				f.delete();
			}
		}
	}
	
	public static void writeLog(String data){
		File logFile = new File(logFilePath);
		BufferedWriter bw = null;
		FileWriter fw = null;
		try {
			if(!logFile.exists()){
				logFile.createNewFile();
			}
			fw = new FileWriter(logFile.getName(),true);
			bw = new BufferedWriter(fw);
			bw.write(data+System.getProperty("line.separator"));
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void writeExportLog(String data){
		File logFile = new File(exportLogFilePath);
		BufferedWriter bw = null;
		FileWriter fw = null;
		try {
			if(!logFile.exists()){
				logFile.createNewFile();
			}
			fw = new FileWriter(logFile.getName(),true);
			bw = new BufferedWriter(fw);
			bw.write(data+System.getProperty("line.separator"));
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		//writeLog("2018-06-08数据导入成功");
		String path = System.getProperty("user.dir")+"/"+"upload"+"/";
		System.out.println(path);
		File upload = new File(path);
		if(!upload.exists()){
			upload.mkdir();
		}
		File zipParent = new File(path,"data");
		if(!zipParent.exists() || !zipParent.isDirectory()){
			zipParent.mkdir();
		}
	}
}
