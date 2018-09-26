package com.readboy.ssm.timetask;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import com.readboy.ssm.po.CellBankMarketing;
import com.readboy.ssm.po.DataCalendar;
import com.readboy.ssm.po.DepositMarketing;
import com.readboy.ssm.po.EtcMarketing;
import com.readboy.ssm.po.PosMarketing;
import com.readboy.ssm.service.AreaService;
import com.readboy.ssm.service.CellBankMarketingService;
import com.readboy.ssm.service.DataCalendarService;
import com.readboy.ssm.service.DataInfoService;
import com.readboy.ssm.service.DataLogService;
import com.readboy.ssm.service.DepositMarketingService;
import com.readboy.ssm.service.EtcMarketingService;
import com.readboy.ssm.service.PerformanceCkAljcgzMxService;
import com.readboy.ssm.service.PerformanceCkYzkhgzMxService;
import com.readboy.ssm.service.PerformanceCkmnlrgzMxService;
import com.readboy.ssm.service.PerformanceDkAljcgzMxService;
import com.readboy.ssm.service.PerformanceDkmnlrgzMxService;
import com.readboy.ssm.service.PosMarketingService;
import com.readboy.ssm.utils.CipherUtil;
import com.readboy.ssm.utils.Constants;
import com.readboy.ssm.utils.DateHelper;
import com.readboy.ssm.utils.FileHelper;
import com.readboy.ssm.utils.FtpUtil;
import com.readboy.ssm.utils.Zipper;

@Component("taskJob")
public class TimeTask {
	
	@Autowired
	private AreaService areaService;
//	private final  String separator = System.getProperty("line.separator","\n");
//	private final  String fileNames[] = {"khgxgl_ckkhyxdjb.txt","khgxgl_sjyhyxdjb.txt",
//			"khgxgl_etcyxdjb.txt","khgxgl_posyxdjb.txt"};
//	
//	private final  String zd[] = {"gzrq","tjrq"};
//	private final  long minNum = 99000000000L;
//	@Autowired
//	private  PerformanceDkmnlrgzMxService performanceDkmnlrgzMxService;
//	@Autowired
//	private  PerformanceCkmnlrgzMxService performanceCkmnlrgzMxService;
//	@Autowired
//	private  DataInfoService dataInfoService;
//	@Autowired
//	private CellBankMarketingService cellBankMarketingService;
//	@Autowired
//	private DepositMarketingService depositMarketingService;
//	@Autowired
//	private EtcMarketingService etcMarketingService;
//	@Autowired
//	private PosMarketingService posMarketingService;
//	@Autowired
//	private  PerformanceCkAljcgzMxService performanceCkAljcgzMxService;
//	@Autowired
//	private  PerformanceDkAljcgzMxService performanceDkAljcgzMxService;
//	@Autowired
//	private  PerformanceCkYzkhgzMxService performanceCkYzkhgzMxService;
//	@Autowired
//	private DataLogService dataLogService;
//	@Autowired
//	private DataCalendarService dataCalendarService;
//	private  String fileSeparator = System.getProperty("file.separator");
//	@Autowired
//	private FtpUtil ftpUtil;
//	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//	private SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	@Scheduled(cron="0 0 0-23 * * ?")
	public void keepConnectToMysql(){
		try {
			areaService.findArea();
			System.out.println(new Date().toString()+"数据库连接正常...");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//每天的21点30分触发这个任务，
	//@Scheduled(cron="${ftp.importTime}")
//	public void autoDataImport(){
//		String yearMonthDay = DateHelper.getYearAndMonthAndDay();
//		String yearMonth = DateHelper.getYearAndMonth();
//		String rq = DateHelper.getRq();
//		//dataImport(1,yearMonthDay,yearMonth,rq);
//	}
	
	//生成日历表导入数据
//	public void calendarImportAndExport() throws Exception{
//		String endDateTime = sdf.format(new Date());
//		String startDateTime = ftpUtil.start_date;
//		//数据导入开始和结束的日期
//		Date startDate = new SimpleDateFormat("yyyy-MM-dd").parse(startDateTime);
//		//获取最开始进来的日期
//		Date firstDateTime = new Date();
//		Date endDate = new SimpleDateFormat("yyyy-MM-dd").parse(endDateTime);
//		Calendar c = Calendar.getInstance();
//		c.setTime(startDate);
////		//一天的毫秒数
////		long nd = 1000 * 24 * 60 * 60;
////		//一个小时的毫秒数
////	    long nh = 1000 * 60 * 60;
//		while(startDate.getTime() <= endDate.getTime()){
//			//查询当前日期的数据是否已经有了
//			//获取当前日期
//			Date curDateTime = new Date();
//			//如果连续执行了超21小时，停止
////			if(((curDateTime.getTime()-firstDateTime.getTime()) % nd / nh) >=21){
////				break;
////			}
//			String date_time = sdf.format(startDate);
//			DataCalendar dataCalendar = null;
//			//由于网络原因，这里查询可能出错
//			boolean queryException = true;
//			while(queryException){
//				try{
//					dataCalendar = dataCalendarService.findDataCalendarByCond(date_time,1, 1);
//					queryException = false;
//				}catch(Exception e){
//					e.printStackTrace();
//					Thread.sleep(5000);
//				}
//			}
//			boolean importFlag = false;
//			if(dataCalendar == null){
//				//数据处理
//				String yearMonthDay = DateHelper.getYearAndMonthAndDay(startDate);
//				String yearMonth = DateHelper.getYearAndMonth(startDate);
//				String rq = sdf.format(startDate);
//				//数据导入
//				importFlag = dataImport(yearMonthDay,yearMonth,rq);
//				//如果数据导入成功了，把ftp上的文件复制到download目录下
//				String zipFileName = "app_"+yearMonth+".zip";
//				if(importFlag){
//					boolean res = FtpUtil.moveFiles(ftpUtil.ftpHost, ftpUtil.ftpUserName, ftpUtil.ftpPassword, 
//							ftpUtil.ftpPort,ftpUtil.ftpPath, ftpUtil.downloadPath, yearMonth, zipFileName);
//					// 若文件移动失败，休息10S再尝试移动
//					while(res == false){
//						Thread.sleep(1000*10);
//						res = FtpUtil.moveFiles(ftpUtil.ftpHost, ftpUtil.ftpUserName, ftpUtil.ftpPassword, 
//								ftpUtil.ftpPort,ftpUtil.ftpPath, ftpUtil.downloadPath, yearMonth, zipFileName);
//					}
//				}
//			}else{ //已经导入过
//				//查看是否当前日期文件是否有更新 
//				//TO DO
//				importFlag = true;
//				
//			}
//			if(importFlag){	//导入成功,日期加1
//				String yearMonthDay = DateHelper.getYearAndMonthAndDay(startDate);
//				boolean exportFlag = false;
//				while(!exportFlag){ //导出
//					//查询这个日期的导出是否完成
//					boolean queryExportSuccess = true;
//					while(queryExportSuccess){
//						try{
//							dataCalendar = dataCalendarService.findDataCalendarByCond(date_time,0, 1);
//							queryExportSuccess = false;
//						}catch(Exception e){
//							e.printStackTrace();
//							Thread.sleep(5000);
//						}
//					}
//					if(dataCalendar == null){	//还未导出
//						exportFlag = dataExport(yearMonthDay,startDate);
//						if(!exportFlag){
//							try {
//								System.out.println("数据导出失败...暂停10秒");
//								Thread.sleep(10*1000);
//							} catch (InterruptedException e) {
//								// TODO Auto-generated catch block
//								e.printStackTrace();
//							}
//						}
//					}else{//已经导出过
//						break;
//					}
//				}
//				//导入导出出完成，日期增加1
//				c.add(Calendar.DAY_OF_MONTH, 1);
//				startDate = c.getTime();
//			}else{	//导入失败,休息一会
//				try {
//					System.out.println("数据导入失败...暂停30秒");
//					Thread.sleep(30*1000);
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
//		}
//	}
//	
//		//生成日历表导入数据
//		public void calendarImportAndExport1() throws Exception{
//			String startDateTime = ftpUtil.start_date;
//			//数据导入开始和结束的日期
//			Date startDate = sdf.parse(startDateTime);
//			Date originalDate = startDate;
//			//初始化日历
//			Calendar c = Calendar.getInstance();
//			c.setTime(startDate);
//			while(true){
//				//当前日期作为日历表最后日期
//				Date endDate = sdf.parse(sdf.format(new Date()));
//				//走完一遍日历表，重头再开始
//				if(startDate.getTime() > endDate.getTime()){
//					startDate = originalDate;
//					c.setTime(startDate);
//					continue;
//				}
//				while(startDate.getTime() <= endDate.getTime()){
//					//查询当前日期的数据是否已经有了
//					String date_time = sdf.format(startDate);
//					DataCalendar dataCalendar = null;
//					//由于网络原因，这里查询可能出错
//					boolean queryException = true;
//					while(queryException){
//						try{
//							dataCalendar = dataCalendarService.findDataCalendarByCond(date_time,1, 1);
//							queryException = false;
//						}catch(Exception e){
//							e.printStackTrace();
//							System.out.println("数据库查询失败，休息3s ...");
//							Thread.sleep(3000);
//						}
//					}
//					boolean importFlag = false;
//					//各种格式日期初始化
//					String yearMonth = DateHelper.getYearAndMonth(startDate);
//					String yearMonthDay = DateHelper.getYearAndMonthAndDay(startDate);
//					String rq = sdf.format(startDate);
//					if(dataCalendar == null){
//						//数据导入
//						importFlag = dataImport(yearMonthDay,yearMonth,rq);
//						//如果数据导入成功了，把ftp上的文件移动到download目录下
//						if(importFlag){
//							String zipFileName = "app_"+yearMonthDay+".zip";
//							boolean res = FtpUtil.moveFiles(ftpUtil.ftpHost, ftpUtil.ftpUserName, ftpUtil.ftpPassword, 
//									ftpUtil.ftpPort,ftpUtil.ftpPath, ftpUtil.downloadPath, yearMonth, zipFileName);
//							//若文件移动失败，休息5s再尝试移动
//							while(res == false){
//								Thread.sleep(5000);
//								res = FtpUtil.moveFiles(ftpUtil.ftpHost, ftpUtil.ftpUserName, ftpUtil.ftpPassword, 
//										ftpUtil.ftpPort,ftpUtil.ftpPath, ftpUtil.downloadPath, yearMonth, zipFileName);
//							}
//						}
//					}else{ 
//						//已经导入过
//						//查看是否当前日期文件是否有更新
//						boolean isExist = FtpUtil.judgeFileExist(ftpUtil.ftpHost, ftpUtil.ftpUserName, 
//								ftpUtil.ftpPassword, ftpUtil.ftpPort, ftpUtil.ftpPath, yearMonth,yearMonthDay);
//						//以前导入成功过，但是有新文件更新，就将导入状态标记设置为2，意思为需要再导入，到下一次循环的时候再去导入
//						if(isExist){
//							//若有文件更新,把这天的导入状态设为0,下次循环的时候再去导入
//							dataCalendarService.updateDataCalendar(date_time, 1, 0);
//						}
//						importFlag = true;
//					}
//					
//					if(importFlag){	//导入成功,日期加1
//						boolean exportFlag = false;
//						while(!exportFlag){ //导出
//							//查询这个日期的导出是否完成
//							boolean queryExportSuccess = true;
//							while(queryExportSuccess){
//								try{
//									dataCalendar = dataCalendarService.findDataCalendarByCond(date_time,0, 1);
//									queryExportSuccess = false;
//								}catch(Exception e){
//									e.printStackTrace();
//									Thread.sleep(5000);
//								}
//							}
//							if(dataCalendar == null){	//还未导出
//								exportFlag = dataExport(yearMonthDay,startDate);
//								if(!exportFlag){
//									try {
//										System.out.println("数据导出失败...暂停10秒");
//										Thread.sleep(10000);
//									} catch (InterruptedException e) {
//										// TODO Auto-generated catch block
//										e.printStackTrace();
//									}
//								}
//							}else{//已经导出过
//								break;
//							}
//						}
//						//导入导出出完成，日期增加1
//						c.add(Calendar.DAY_OF_MONTH, 1);
//						startDate = c.getTime();
//					}else{
//						//导入失败,休息一会
//						try {
//							//如果startDate是今天，并且导入失败，就不循环这一天，因为要去检测更新
//							if(startDate.getTime() == endDate.getTime()){
//								c.add(Calendar.DAY_OF_MONTH, 1);
//								startDate = c.getTime();
//							}
//							System.out.println("数据导入失败...暂停10秒");
//							Thread.sleep(10*1000);
//						} catch (InterruptedException e) {
//							// TODO Auto-generated catch block
//							e.printStackTrace();
//						}
//					}
//				}
//			}
//			
//		}
//	
////生成日历表导出数据
////	public void calendarExport() throws Exception{
////		String yearMonthDay = DateHelper.getYearAndMonthAndDay();
////		dataExport(yearMonthDay);
////	}
//
//	public boolean dataImport(String yearMonthDay,String yearMonth,String rq) throws Exception{
//		Long data_id = dataCalendarService.findDataCalendarExistByCond(rq, 1);
//		DataCalendar dataCalendar = new DataCalendar();
//		//初始化日历表时间
//		dataCalendar.setData_time(yearMonthDay);
//		dataCalendar.setStart_time(sdf2.format(new Date()));
//		long startMillions = System.currentTimeMillis();
//		//localPath是文件下载下来需要存放的路径
//		String localPath = System.getProperty("user.dir")+"/"+"download"+"/";
//		File file = new File(localPath);
//		if(!file.exists()){
//			file.mkdir();
//		}
//		//解密后的文件存放文件夹
//		File deCryptFiles = new File(System.getProperty("user.dir")+"/"+"download"+"/"+"deCyptFile"+"/");
//		if(!deCryptFiles.exists()){
//			deCryptFiles.mkdir();
//		}
//		//导入前清除文件夹中的残余文件
//		FileHelper.deleteFilesInDirectory(file);
//		//删除解密文件夹里残余的文件
//		FileHelper.deleteFilesInDirectory(deCryptFiles);
//		String fileName = "app_"+yearMonthDay+".zip";
//		System.out.println("开始下载...");
//		boolean isDownload = FtpUtil.downloadFtpFile(FtpUtil.ftpHost,
//				FtpUtil.ftpUserName, FtpUtil.ftpPassword,
//				FtpUtil.ftpPort, FtpUtil.ftpPath+yearMonth+"/", localPath, fileName);
//		if(isDownload){ //下载成功
//			//解压
//			try{
//				Zipper.unzip(localPath+fileName, localPath);
//			}catch(Exception e){
//				e.printStackTrace();
//				if(data_id == null){
//					insertDataCalendar(dataCalendar,"文件解压失败",1,0,startMillions);
//				}else{
//					updateDataCalendar(dataCalendar,"文件解压失败",1,0,startMillions,data_id);
//				}
//				return false;
//			}
//			//解密
////			File undecryptFiles[] = file.listFiles();
////			deCryptFiles(undecryptFiles,deCryptFiles);
////			File files[] = deCryptFiles.listFiles();
//			File files[] = file.listFiles();
//		    //执行数据导入
//			System.out.println("开始数据导入");
//			if(dataImort(rq,files)){
//				System.out.println("导入成功！");
//				if(data_id == null){
//					insertDataCalendar(dataCalendar,null,1,1,startMillions);
//				}else{
//					//将导入状态标志变为1
//					updateDataCalendar(dataCalendar,null,1,1,startMillions,data_id);
//				}
//				return true;
//			}else{
//			    //再尝试一次下载和导入
//				if(data_id == null){
//					insertDataCalendar(dataCalendar,"数据导入失败",1,0,startMillions);
//				}else{
//					updateDataCalendar(dataCalendar,"数据导入失败",1,0,startMillions,data_id);
//				}
//				return false;
//			}
//		}else{ 
//			//下载失败
//			//再尝试一次下载和导入
//			if(data_id == null){
//				insertDataCalendar(dataCalendar,"下载失败",1,0,startMillions);
//			}else{
//				updateDataCalendar(dataCalendar,"下载失败",1,0,startMillions,data_id);
//			}
//			return false;
//		}
//	}
//	
//	public void insertDataCalendar(DataCalendar dataCalendar,String fail_cause,Integer data_type
//			,Integer data_status,long startMillions) throws Exception{
//		long endMillionds = System.currentTimeMillis();
//		dataCalendar.setFail_cause(fail_cause);
//		dataCalendar.setEnd_time(sdf2.format(new Date()));
//		dataCalendar.setData_type(data_type);
//		dataCalendar.setData_status(data_status);
//		dataCalendar.setConsume_time((int)((endMillionds-startMillions)/60000));
//		dataCalendarService.insertDataCalendar(dataCalendar);
//	}
//	
//	public void updateDataCalendar(DataCalendar dataCalendar,String fail_cause,Integer data_type
//			,Integer data_status,long startMillions,Long data_id) throws Exception{
//		long endMillionds = System.currentTimeMillis();
//		dataCalendar.setFail_cause(fail_cause);
//		dataCalendar.setEnd_time(sdf2.format(new Date()));
//		dataCalendar.setData_type(data_type);
//		dataCalendar.setData_status(data_status);
//		dataCalendar.setConsume_time((int)((endMillionds-startMillions)/60000));
//		dataCalendar.setData_id(data_id);
//		dataCalendarService.updateEntireDataCalendar(dataCalendar);
//	}
//	
//	
//	public void deCryptFiles(File[] files,File destFile){
//		// deCryptFiles文件夹下要存放的是解密后的txt文件
//		//解密文件到另一个文件夹
//		for(File f : files){
//			String fName = f.getName().toLowerCase();
//			if(fName.endsWith(".txt")){
//				try {
//					CipherUtil.decryptFile(f.getAbsolutePath(), destFile.getAbsolutePath()+"/"+fName);
//				} catch (Exception e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
//		}
//	}
//	
//	//每天的21点0分触发这个任务，
////	@Scheduled(cron="0 30 21 * * ?")
////	public void autoDataExport() throws Exception{
////		String yearMonthDay = DateHelper.getYearAndMonthAndDay();
////		dataExport(yearMonthDay);
////	}
//	
//	//真正执行数据导入的方法
//	public  boolean dataImort(String rq , File[] files){
//		String ksrq = rq + " 00:00:00";	
//		String jsrq = rq + " 23:59:59";
//		boolean flag = true;
//		for(File f :files){
//			String fName = f.getName().toLowerCase();
//			// 是TXT文件
//			if (fName.endsWith(".txt")){
//				String tableName = fName.substring(0,fName.length() - 4).toLowerCase();
//				if (tableName.contains(Constants.table_dkmnlrgzmx)) {
//					try {
//						performanceDkmnlrgzMxService.createTable(tableName);
//					} catch (Exception e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//						flag = false;
//						break;
//					}
//				}else if (tableName.contains(Constants.table_ckmnlrgzmx)) {
//					try {
//						performanceCkmnlrgzMxService.createTable(tableName);
//					} catch (Exception e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//						flag = false;
//						break;
//					}
//				}else if(tableName.contains("erp_wage_ckaljcgzmx")){
//					try {
//						performanceCkAljcgzMxService.createTable(tableName);
//					} catch (Exception e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//						flag = false;
//						break;
//					}
//				}else if(tableName.contains("erp_wage_ckyzkhgzmx")){
//					try {
//						performanceCkYzkhgzMxService.createTable(tableName);
//					} catch (Exception e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//						flag = false;
//						break;
//					}
//				}else if(tableName.contains("erp_wage_dkaljcgzmx")){
//					try {
//						performanceDkAljcgzMxService.createTable(tableName);
//					} catch (Exception e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//						flag = false;
//						break;
//					}
//				}
//				
//				//删除表记录
//				if(fName.equals(fileNames[0]) || fName.equals(fileNames[1]) 
//						|| fName.equals(fileNames[2]) || fName.equals(fileNames[3])){
//					try {
//						dataInfoService.deleteMarketingData(tableName, minNum);
//		
//					} catch (Exception e) {
//			
//						e.printStackTrace();
//						flag = false;
//						break;
//					}
//				}else if(fName.equals("erp_wage_ygjx.txt") || fName.equals("erp_wage_ygjx_mx.txt")){
//					try {
//						dataInfoService.deleteTableDataByrq(tableName, zd[0], ksrq, jsrq);
//
//					} catch (Exception e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//						flag = false;
//						break;
//					}
//				}else if(fName.contains("erp_wage_ckmnlrgzmx_") || fName.equals("erp_wage_ckkhhsmx.txt")
//						|| fName.contains("erp_wage_dkmnlrgzmx_") || fName.equals("erp_wage_dkkhbsmx.txt")
//						|| fName.contains("erp_wage_ckaljcgzmx_") || fName.contains("erp_wage_ckyzkhgzmx_")
//						|| fName.contains("erp_wage_dkaljcgzmx_")|| fName.equals("erp_wage_dkkhhsmx.txt")
//						|| fName.equals("erp_wage_dydklxshmx.txt") || fName.equals("erp_wage_bmkkhhsmx.txt")){
//					try {
//						dataInfoService.deleteTableDataByrq(tableName, zd[1], ksrq, jsrq);
//					} catch (Exception e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//						flag = false;
//						break;
//					}
//				}else{
//					try {
//						dataInfoService.deleteTableData(tableName);
//					} catch (Exception e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//						flag = false;
//						break;
//					}
//				}
//				String fPath = f.getAbsolutePath();
//				try {
//					dataInfoService.dataload(tableName, fPath,separator);
//				} catch (Exception e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//					flag = false;
//					break;
//				}
//			}
//		}
//		return flag;
//	}
//	
//	//数据导出
//	public boolean dataExport(String yearMonthDay,Date startDate) throws Exception{
//		String data_time = sdf.format(startDate);
//		//查找是否存在导出记录，若不存在就插入记录，否则更新记录
//		DataCalendar failNote = dataCalendarService.findDataCalendarByCond(data_time, 0, 0);
//		long startMillions = System.currentTimeMillis();
//		DataCalendar dataCalendar = new DataCalendar();
//		dataCalendar.setStart_time(sdf2.format(new Date()));
//		dataCalendar.setData_time(sdf.format(startDate));
//		String path = System.getProperty("user.dir")+"/"+"upload"+"/";
//		//String path = request.getSession().getServletContext().getRealPath("upload/");
//		File zipParent = new File(path,"data");
//		if(!zipParent.exists() || !zipParent.isDirectory()){
//			zipParent.mkdir();
//		}
//		//创建加密文件存放的文件
//		File enCryptFiles = new File(path,"enCryptFiles");
//		if(!enCryptFiles.exists()){
//			enCryptFiles.mkdir();
//		}
//		if(!zipParent.exists() || !zipParent.isDirectory()){
//			zipParent.mkdir();
//		}
//		//首先删除当前文件夹中的文件(上次导出存留的文件)
//		FileHelper.deleteFilesInDirectory(zipParent);
//		//删除之前加密文件夹里面的文件
//		FileHelper.deleteFilesInDirectory(enCryptFiles);
//		for(int i = 0; i < fileNames.length; i++){
//			String line = "";
//			File file = new File(zipParent.getAbsolutePath(),fileNames[i]);
//			if(!file.exists()){
//				try {
//					file.createNewFile();
//				} catch (IOException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//					return false;
//				}
//			}
//			//查询以99开头的
//			if(i == 0){
//				//判断要求yybh字段长度至少12
//				List<DepositMarketing> list = new ArrayList<DepositMarketing>();
//				try {
//					list = depositMarketingService.findDepositMarketingByPrefix("99", 12);
//				} catch (Exception e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//					//记录为空就插入，否则就更新错误信息
//					if(failNote == null){
//						insertDataCalendar(dataCalendar,"数据库访问失败",0,0,startMillions);
//					}else{
//						updateDataCalendar(dataCalendar,"数据库访问失败",0,0,startMillions,failNote.getData_id());
//					}
//					return false;
//				}
//				for(int j = 0; j < list.size(); j++){
//					StringBuilder sb = new StringBuilder();
//					DepositMarketing one = list.get(j);
//					line += sb.append(one.getJgdm()).append("|")
//							.append(one.getCkzl()).append("|")
//							.append(one.getKhzl()).append("|")
//							.append(one.getZjlb()).append("|")
//							.append(one.getZjhm()).append("|")
//							.append(one.getKhmc()).append("|")
//							.append(one.getYxbl()).append("|")
//							.append(one.getSbzt()).append("|")
//							.append(one.getLrr()).append("|")
//							.append(one.getLrbz()).append("|")
//							.append(one.getLrsj()).append("|")
//							.append(one.getYyrq()).append("|")
//							.append(one.getYybh()).append("|")
//							.append(one.getYggh()).append("|")
//							.append(one.getYgxm()).append("|")
//							.append(one.getSjhm() == null ? "" : one.getSjhm()).append(separator).toString();
//				}
//			}else if(i == 1){
//				List<CellBankMarketing> list = new ArrayList<CellBankMarketing>();
//				try {
//					list = cellBankMarketingService.findCellBankMarketingByPrefix("99", 12);
//				} catch (Exception e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//					//记录为空就插入，否则就更新错误信息
//					if(failNote == null){
//						insertDataCalendar(dataCalendar,"数据库访问失败",0,0,startMillions);
//					}else{
//						updateDataCalendar(dataCalendar,"数据库访问失败",0,0,startMillions,failNote.getData_id());
//					}
//					return false;
//				}
//				for(int j = 0; j < list.size(); j++){
//					StringBuilder sb = new StringBuilder();
//					CellBankMarketing one = list.get(j);
//					line += sb.append(one.getJgdm()).append("|")
//							.append(one.getZjlb()).append("|")
//							.append(one.getZjhm()).append("|")
//							.append(one.getKhmc()).append("|")
//							.append(one.getSjhm()).append("|")
//							.append(one.getYxbl()).append("|")
//							.append(one.getSbzt()).append("|")
//							.append(one.getLrr()).append("|")
//							.append(one.getLrbz()).append("|")
//							.append(one.getLrsj()).append("|")
//							.append(one.getYyrq()).append("|")
//							.append(one.getYybh()).append("|")
//							.append(one.getYggh()).append("|")
//							.append(one.getYgxm() == null ? "" : one.getYgxm()).append(separator).toString();
//				}
//			}else if(i == 2){
//				List<EtcMarketing> list = new ArrayList<EtcMarketing>();
//				try {
//					list = etcMarketingService.findEtcMarketingByPrefix("99", 12);
//				} catch (Exception e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//					//记录为空就插入，否则就更新错误信息
//					if(failNote == null){
//						insertDataCalendar(dataCalendar,"数据库访问失败",0,0,startMillions);
//					}else{
//						updateDataCalendar(dataCalendar,"数据库访问失败",0,0,startMillions,failNote.getData_id());
//					}
//					return false;
//				}
//				for(int j = 0; j < list.size(); j++){
//					StringBuilder sb = new StringBuilder();
//					EtcMarketing one = list.get(j);
//					line += sb.append(one.getJgdm()).append("|")
//							.append(one.getZjlb()).append("|")
//							.append(one.getZjhm()).append("|")
//							.append(one.getKhmc()).append("|")
//							.append(one.getSjhm()).append("|")
//							.append(one.getYxbl()).append("|")
//							.append(one.getSbzt()).append("|")
//							.append(one.getLrr()).append("|")
//							.append(one.getLrbz()).append("|")
//							.append(one.getLrsj()).append("|")
//							.append(one.getYyrq()).append("|")
//							.append(one.getYybh()).append("|")
//							.append(one.getYggh()).append("|")
//							.append(one.getYgxm() == null ? "" : one.getYgxm()).append(separator).toString();
//				}
//			}else{//khgxgl_posyxdjb
//				List<PosMarketing> list = new ArrayList<PosMarketing>();
//				try {
//					list = posMarketingService.findPosMarketingByPrefix("99",12);
//				} catch (Exception e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//					//记录为空就插入，否则就更新错误信息
//					if(failNote == null){
//						insertDataCalendar(dataCalendar,"数据库访问失败",0,0,startMillions);
//					}else{
//						updateDataCalendar(dataCalendar,"数据库访问失败",0,0,startMillions,failNote.getData_id());
//					}
//					return false;
//				}
//				for(int j = 0; j < list.size(); j++){
//					StringBuilder sb = new StringBuilder();
//					PosMarketing one = list.get(j);
//					line += sb.append(one.getJgdm()).append("|")
//							.append(one.getZjlb()).append("|")
//							.append(one.getZjhm()).append("|")
//							.append(one.getKhmc()).append("|")
//							.append(one.getSjhm()).append("|")
//							.append(one.getYxbl()).append("|")
//							.append(one.getSbzt()).append("|")
//							.append(one.getLrr()).append("|")
//							.append(one.getLrbz()).append("|")
//							.append(one.getLrsj()).append("|")
//							.append(one.getYyrq()).append("|")
//							.append(one.getYybh()).append("|")
//							.append(one.getYggh()).append("|")
//							.append(one.getYgxm()).append("|")
//							.append(one.getKhckzh() == null ? "" : one.getKhckzh()).append(separator).toString();
//				}
//			}
//			line = line.replace("|null|", "||");
//			FileOutputStream fos = new FileOutputStream(file);
//			if(!file.exists()){
//				try {
//					file.createNewFile();
//				} catch (IOException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//					if(failNote == null){
//						insertDataCalendar(dataCalendar,"文件创建失败",0,0,startMillions);
//					}else{
//						updateDataCalendar(dataCalendar,"文件创建失败",0,0,startMillions,failNote.getData_id());
//					}
//					fos.close();
//					return false;
//				}
//			}
//			byte[] contentInBytes = line.getBytes();
//			try {
//				fos.write(contentInBytes);
//				fos.flush();
//				fos.close();
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//				if(failNote == null){
//					insertDataCalendar(dataCalendar,"导出数据写文件失败",0,0,startMillions);
//				}else{
//					updateDataCalendar(dataCalendar,"导出数据写文件失败",0,0,startMillions,failNote.getData_id());
//				}
//				return false;
//			}
//		}
//		String zipName = "app_"+yearMonthDay+".zip";
//		File zipFile = new File(zipName);
//		File files[] = zipParent.listFiles();
//		//加密文件
////		for(File f : files){
////			try {
////				String txtPath = enCryptFiles.getAbsolutePath()+"/"+f.getName().toLowerCase();
////				CipherUtil.encryptFile(f.getAbsolutePath(),txtPath);
////			} catch (Exception e) {
////				// TODO Auto-generated catch block
////				e.printStackTrace();
////				return false;
////			}
////		}
//		//压缩未加密文件
//		try{
//			Zipper.zip(zipParent.getAbsolutePath(),zipFile.getAbsolutePath());
//		}catch(Exception e){
//			e.printStackTrace();
//			if(failNote == null){
//				insertDataCalendar(dataCalendar,"文件压缩失败",0,0,startMillions);
//			}else{
//				updateDataCalendar(dataCalendar,"文件压缩失败",0,0,startMillions,failNote.getData_id());
//			}
//			return false;
//		}
//		//压缩加密后的文件
//		//Zipper.zip(enCryptFiles.getAbsolutePath(),zipFile.getAbsolutePath());
//		//上传解压后的文件
//		FileInputStream input = new FileInputStream(zipFile);
//		boolean flag = FtpUtil.uploadFile(FtpUtil.ftpHost, FtpUtil.ftpUserName, FtpUtil.ftpPassword,
//				FtpUtil.ftpPort, FtpUtil.ftpPathClient, zipName, input,yearMonthDay.substring(0,yearMonthDay.length()-2));
//		if(flag){
//			System.out.println("上传成功!");
//			insertDataCalendar(dataCalendar,null,0,1,startMillions);
//		}else{
//			//导出失败
//			System.out.println("上传失败!");
//			if(failNote == null){
//				insertDataCalendar(dataCalendar,"上传失败",0,0,startMillions);
//			}else{
//				updateDataCalendar(dataCalendar,"上传失败",0,0,startMillions,failNote.getData_id());
//			}
//		}
//		return flag;
//	}
//	
//
//	
//	@Test
//	public void main(){
//		
//	}
	
}
