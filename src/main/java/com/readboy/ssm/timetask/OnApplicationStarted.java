package com.readboy.ssm.timetask;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;
import org.springframework.web.context.support.WebApplicationContextUtils;

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
@Service
public class OnApplicationStarted implements InitializingBean{
	
	private static final long serialVersionUID = 1L;
	private final  String separator = System.getProperty("line.separator","\n");
	private final  String fileNames[] = {"khgxgl_ckkhyxdjb.txt","khgxgl_sjyhyxdjb.txt",
			"khgxgl_etcyxdjb.txt","khgxgl_posyxdjb.txt"};
	
	private final  String zd[] = {"gzrq","tjrq"};
	private final  long minNum = 99000000000L;
	@Autowired
	private  PerformanceDkmnlrgzMxService performanceDkmnlrgzMxService;
	@Autowired
	private  PerformanceCkmnlrgzMxService performanceCkmnlrgzMxService;
	@Autowired
	private  DataInfoService dataInfoService;
	@Autowired
	private CellBankMarketingService cellBankMarketingService;
	@Autowired
	private DepositMarketingService depositMarketingService;
	@Autowired
	private EtcMarketingService etcMarketingService;
	@Autowired
	private PosMarketingService posMarketingService;
	@Autowired
	private  PerformanceCkAljcgzMxService performanceCkAljcgzMxService;
	@Autowired
	private  PerformanceDkAljcgzMxService performanceDkAljcgzMxService;
	@Autowired
	private  PerformanceCkYzkhgzMxService performanceCkYzkhgzMxService;
	@Autowired
	private DataLogService dataLogService;
	@Autowired
	private DataCalendarService dataCalendarService;
	private  String fileSeparator = System.getProperty("file.separator");
	
	@Autowired
	private FtpUtil ftpUtil;
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	private SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	@Override
	public void afterPropertiesSet(){
		// TODO Auto-generated method stub
		dealWithData();
	}
	
    public void dealWithData(){
    	Date date = null;
		try {
			date = sdf2.parse(ftpUtil.dataImportExportTime);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("您的数据导入导出开始时间设置有误，请重新设置！");
			FileHelper.writeLog("您的数据导入导出开始时间设置有误，请重新设置！");
			return;
		}
		Timer importTimer = new Timer();
		Timer exportTimer = new Timer();
    	TimerTask importTask = new TimerTask(){
			@Override
			public void run() {
				// TODO Auto-generated method stub
				//自动数据导入导出
				FileHelper.writeLog("["+sdf2.format(new Date())+"] "+"dealWithData()执行一次");
				try {
					calendarImport1();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					FileHelper.writeLog("["+sdf2.format(new Date())+"] "+"数据处理出现未知异常");
				}
			}
    	};
    	TimerTask exportTask = new TimerTask(){
			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					calendarExport();
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
    	};
    	//在指定时间执行，如果date是过去的时间，则马上执行
    	importTimer.schedule(importTask, date);
    	exportTimer.schedule(exportTask,date);
    }
    
    public void calendarImport1() throws Exception{
    	System.out.println("进入数据处理...");
		String startDateTime = ftpUtil.start_date;
		//数据导入开始和结束的日期
		Date startDate = sdf.parse(startDateTime);
		Date originalDate = startDate;
		//初始化日历
		Calendar c = Calendar.getInstance();
		c.setTime(startDate);
		Date endDate = sdf.parse(sdf.format(new Date()));
		//生成到项目启动当前为止的日历表
		while(startDate.getTime() <= endDate.getTime()){
			if(insertInitDataCalendar(startDate)){
				FileHelper.writeLog(sdf2.format(new Date())+" "+startDate+"表记录生成");
				c.add(Calendar.DAY_OF_MONTH, 1);
				startDate = c.getTime();
			}
		}
		while(true){
			endDate = sdf.parse(sdf.format(new Date()));
			//查询当前这天的数据是否有了，没有就插入
			insertInitDataCalendar(endDate);
			//查询需要插入数据的日期最小的一天
			String data_time = null;
			boolean queryException = true;
			while(queryException){
				try{
					data_time = dataCalendarService.findMinDateByCond(sdf.format(originalDate), 1);
					queryException = false;
				}catch(Exception e){
					e.printStackTrace();
					Thread.sleep(3000);
				}
			}
			if(data_time == null){
				//全部导入成功了,就休息30S
				Thread.sleep(30000);
			}else{
				//有日期数据需要导入
				boolean importFlag = false;
				Date curDate = sdf.parse(data_time);
				//各种格式日期初始化
				String yearMonth = DateHelper.getYearAndMonth(curDate);
				String yearMonthDay = DateHelper.getYearAndMonthAndDay(curDate);
				String rq = sdf.format(curDate);
				//数据导入
				importFlag = dataImport(yearMonthDay,yearMonth,rq);
				//如果数据导入成功了，把ftp上的文件移动到download目录下
				if(importFlag){
					System.out.println(rq+"数据导入成功");
					String zipFileName = "app_"+yearMonthDay+".zip";
//					boolean res = FtpUtil.moveFiles(ftpUtil.ftpHost, ftpUtil.ftpUserName, ftpUtil.ftpPassword, 
//							ftpUtil.ftpPort,ftpUtil.ftpPath, ftpUtil.downloadPath, yearMonth, zipFileName);
					//若文件移动失败，休息5s再尝试移动
					while(true){
						boolean res = FtpUtil.moveFiles(ftpUtil.ftpHost, ftpUtil.ftpUserName, ftpUtil.ftpPassword, 
								ftpUtil.ftpPort,ftpUtil.ftpPath, ftpUtil.downloadPath, yearMonth, zipFileName);
						if(res) {
							break;
						}else {
							Thread.sleep(5000);
						}
//						FileHelper.writeLog(sdf2.format(new Date())+" "+rq+"数据文件移动到"+ftpUtil.downloadPath+yearMonth+"下失败");
					}
					FileHelper.writeLog(sdf2.format(new Date())+" "+rq+"数据文件移动到"+ftpUtil.downloadPath+yearMonth+"下成功");
					FileHelper.writeLog("");
				}else{
					//导入不成功，休息30S
					Thread.sleep(30000);
				}
			}
			//开始日期初始值重置
			startDate = originalDate;
			c.setTime(startDate);
			//检测文件更新,若文件有更新，则把相应数据日期的导入标志设为未导入
			while(startDate.getTime() <= endDate.getTime()){
				data_time = sdf.format(startDate);
				String yearMonth = DateHelper.getYearAndMonth(startDate);
				String yearMonthDay = DateHelper.getYearAndMonthAndDay(startDate);
				String rq = sdf.format(startDate);
				boolean isExist = FtpUtil.judgeFileExist(ftpUtil.ftpHost, ftpUtil.ftpUserName, 
						ftpUtil.ftpPassword, ftpUtil.ftpPort, ftpUtil.ftpPath, yearMonth,yearMonthDay);
				//以前导入成功过，但是有新文件更新，就将导入状态标记设置为2，意思为需要再导入，到下一次循环的时候再去导入
				if(isExist){
					//若有文件更新,把这天的导入状态设为0,下次循环的时候再去导入
					 dataCalendarService.updateDataCalendar(data_time, 1, 0);
					 FileHelper.writeLog(sdf2.format(new Date())+" "+rq+"数据需要重新导入");
				}
				c.add(Calendar.DAY_OF_MONTH, 1);
				startDate = c.getTime();
			}
		}
    }
    
    public boolean insertInitDataCalendar(Date startDate){
    	String data_time = sdf.format(startDate);
    	boolean flag = false;
		Long res = null;
		try {
			res = dataCalendarService.findDataCalendarExistByCond(data_time, 1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return flag;
		}
		if(res == null){
			DataCalendar dataCalendar = new DataCalendar();
			dataCalendar.setData_time(data_time);
			dataCalendar.setData_type(1);
			dataCalendar.setData_status(0);
			try {
				dataCalendarService.insertDataCalendar(dataCalendar);
				flag = true;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return flag;
			}
		}else{
			flag=true;
		}
		return flag;
    }
    
	//生成日历表导入数据
	public void calendarImport() throws Exception{
		System.out.println("进入数据处理...");
		String startDateTime = ftpUtil.start_date;
		//数据导入开始和结束的日期
		Date startDate = sdf.parse(startDateTime);
		Date originalDate = startDate;
		//初始化日历
		Calendar c = Calendar.getInstance();
		c.setTime(startDate);
		while(true){
			//当前日期作为日历表最后日期
			Date endDate = sdf.parse(sdf.format(new Date()));
			//走完一遍日历表，重头再开始
			if(startDate.getTime() > endDate.getTime()){
				startDate = originalDate;
				c.setTime(startDate);
				continue;
			}
			while(startDate.getTime() <= endDate.getTime()){
				//查询当前日期的数据是否已经有了
				String date_time = sdf.format(startDate);
				DataCalendar dataCalendar = null;
				//由于网络原因，这里查询可能出错
				boolean queryException = true;
				while(queryException){
					try{
						dataCalendar = dataCalendarService.findDataCalendarByCond(date_time,1, 1);
						queryException = false;
					}catch(Exception e){
						e.printStackTrace();
						System.out.println(date_time+"数据库查询失败，休息3s ...");
						Thread.sleep(3000);
					}
				}
				boolean importFlag = false;
				//各种格式日期初始化
				String yearMonth = DateHelper.getYearAndMonth(startDate);
				String yearMonthDay = DateHelper.getYearAndMonthAndDay(startDate);
				String rq = sdf.format(startDate);
				if(dataCalendar == null){
					//数据导入
					importFlag = dataImport(yearMonthDay,yearMonth,rq);
					//如果数据导入成功了，把ftp上的文件移动到download目录下
					if(importFlag){
						System.out.println(rq+"数据导入成功");
						String zipFileName = "app_"+yearMonthDay+".zip";
						boolean res = FtpUtil.moveFiles(ftpUtil.ftpHost, ftpUtil.ftpUserName, ftpUtil.ftpPassword, 
								ftpUtil.ftpPort,ftpUtil.ftpPath, ftpUtil.downloadPath, yearMonth, zipFileName);
						//若文件移动失败，休息5s再尝试移动
						while(res == false){
							Thread.sleep(5000);
							res = FtpUtil.moveFiles(ftpUtil.ftpHost, ftpUtil.ftpUserName, ftpUtil.ftpPassword, 
									ftpUtil.ftpPort,ftpUtil.ftpPath, ftpUtil.downloadPath, yearMonth, zipFileName);
							FileHelper.writeLog(sdf2.format(new Date())+" "+rq+"数据文件移动到"+ftpUtil.downloadPath+yearMonth+"下失败");
						}
						FileHelper.writeLog(sdf2.format(new Date())+" "+rq+"数据文件移动到"+ftpUtil.downloadPath+yearMonth+"下成功");
						FileHelper.writeLog("");
					}
				}else{ 
					//已经导入过
					//查看是否当前日期文件是否有更新
					System.out.println(rq+"数据已成功导入过...");
					boolean isExist = FtpUtil.judgeFileExist(ftpUtil.ftpHost, ftpUtil.ftpUserName, 
							ftpUtil.ftpPassword, ftpUtil.ftpPort, ftpUtil.ftpPath, yearMonth,yearMonthDay);
					//以前导入成功过，但是有新文件更新，就将导入状态标记设置为2，意思为需要再导入，到下一次循环的时候再去导入
					if(isExist){
						//若有文件更新,把这天的导入状态设为0,下次循环的时候再去导入
						 dataCalendarService.updateDataCalendar(date_time, 1, 0);
						 FileHelper.writeLog(sdf2.format(new Date())+" "+rq+"数据需要重新导入");
					}
				}
				if(importFlag){
					//导入完成，日期增加1
					c.add(Calendar.DAY_OF_MONTH, 1);
					startDate = c.getTime();
				}
				//如果startDate是今天，并且导入失败，就不循环这一天，因为要去检测更新
				if(!importFlag && startDate.getTime() == endDate.getTime()){
					c.add(Calendar.DAY_OF_MONTH, 1);
					startDate = c.getTime();
					System.out.println(rq+"数据导入失败...暂停30秒");
					Thread.sleep(30*1000);
				}
				//如果导入失败且日期不是当日，什么也不做，即日期不变再次尝试
			}
		}
	}
	
	public void calendarExport() throws ParseException{
		String startDateTime = ftpUtil.start_date;
		//数据导入开始和结束的日期
		Date startDate;
		try {
			startDate = sdf.parse(startDateTime);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			System.out.println("开始日期配置有错！");
			return;
		}
		Calendar c = Calendar.getInstance();
		c.setTime(startDate);
		while(true){
			Date endDate = sdf.parse(sdf.format(new Date()));
			if(startDate.getTime() > endDate.getTime()){
				try {
					//System.out.println("已经导出全部日期数据，休息30秒");
					Thread.sleep(30000);
					continue;
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			while(startDate.getTime() <= endDate.getTime()){
				String date_time = sdf.format(startDate);
				//查询这个日期的导出是否完成
				boolean queryExportSuccess = true;
				DataCalendar dataCalendar = null;
				boolean exportFlag = false;
				while(queryExportSuccess){
					try{
						dataCalendar = dataCalendarService.findDataCalendarByCond(date_time,0, 1);
						queryExportSuccess = false;
					}catch(Exception e){
						e.printStackTrace();
						try {
							Thread.sleep(5000);
						} catch (InterruptedException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				}
				//各种格式日期初始化
				String yearMonthDay = DateHelper.getYearAndMonthAndDay(startDate);
				String rq = sdf.format(startDate);
				if(dataCalendar == null){	//还未导出
					try {
						exportFlag = dataExport(yearMonthDay,startDate);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
						exportFlag = false;
					}
					if(!exportFlag){
						try {
							System.out.println(rq+"数据导出失败...暂停30秒");
							Thread.sleep(30000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}else{
						FileHelper.writeExportLog("["+sdf2.format(new Date())+"] "+rq+"数据导出成功");
						//导出出完成，日期增加1
						c.add(Calendar.DAY_OF_MONTH, 1);
						startDate = c.getTime();
					}
				}else{//已经导出过
					c.add(Calendar.DAY_OF_MONTH, 1);
					startDate = c.getTime();
				}
			}
		}
	}
  	
	public boolean dataImport(String yearMonthDay,String yearMonth,String rq) throws Exception{
		Long data_id = dataCalendarService.findDataCalendarExistByCond(rq, 1);
		DataCalendar dataCalendar = new DataCalendar();
		//初始化日历表时间
		dataCalendar.setData_time(yearMonthDay);
		dataCalendar.setStart_time(sdf2.format(new Date()));
		long startMillions = System.currentTimeMillis();
		//localPath是文件下载下来需要存放的路径
		String localPath = System.getProperty("user.dir")+"/"+"download"+"/";
		File file = new File(localPath);
		if(!file.exists()){
			file.mkdir();
		}
		//解密后的文件存放文件夹
		File deCryptFiles = new File(System.getProperty("user.dir")+"/"+"download"+"/"+"deCyptFile"+"/");
		if(!deCryptFiles.exists()){
			deCryptFiles.mkdir();
		}
		//导入前清除文件夹中的残余文件
		FileHelper.deleteFilesInDirectory(file);
		//删除解密文件夹里残余的文件
		FileHelper.deleteFilesInDirectory(deCryptFiles);
		String fileName = "app_"+yearMonthDay+".zip";
		System.out.println("开始下载..."+new Date());
		boolean isDownload = FtpUtil.downloadFtpFile(FtpUtil.ftpHost,
				FtpUtil.ftpUserName, FtpUtil.ftpPassword,
				FtpUtil.ftpPort, FtpUtil.ftpPath+yearMonth+"/", localPath, fileName);
		System.out.println("下载结束..."+new Date());
		if(isDownload){ //下载成功
			//解压
			try{
				Zipper.unzip(localPath+fileName, localPath);
			}catch(Exception e){
				e.printStackTrace();
				if(data_id == null){
					insertDataCalendar(dataCalendar,"文件解压失败",1,0,startMillions);
				}else{
					updateDataCalendar(dataCalendar,"文件解压失败",1,0,startMillions,data_id);
				}
				return false;
			}
			//解密
//			File undecryptFiles[] = file.listFiles();
//			deCryptFiles(undecryptFiles,deCryptFiles);
//			File files[] = deCryptFiles.listFiles();
			File files[] = file.listFiles();
		    //执行数据导入
			System.out.println("开始数据导入");
			if(dataImort(rq,files)){
				System.out.println("导入成功！");
				if(data_id == null){
					insertDataCalendar(dataCalendar,null,1,1,startMillions);
				}else{
					//将导入状态标志变为1
					updateDataCalendar(dataCalendar,null,1,1,startMillions,data_id);
				}
				return true;
			}else{
			    //再尝试一次下载和导入
				if(data_id == null){
					insertDataCalendar(dataCalendar,"数据导入失败",1,0,startMillions);
				}else{
					updateDataCalendar(dataCalendar,"数据导入失败",1,0,startMillions,data_id);
				}
				return false;
			}
		}else{ 
			//下载失败
			//再尝试一次下载和导入
			if(data_id == null){
				insertDataCalendar(dataCalendar,"下载失败",1,0,startMillions);
			}else{
				updateDataCalendar(dataCalendar,"下载失败",1,0,startMillions,data_id);
			}
			return false;
		}
	}
	
	public void insertDataCalendar(DataCalendar dataCalendar,String fail_cause,Integer data_type
			,Integer data_status,long startMillions) throws Exception{
		long endMillionds = System.currentTimeMillis();
		dataCalendar.setFail_cause(fail_cause);
		dataCalendar.setEnd_time(sdf2.format(new Date()));
		dataCalendar.setData_type(data_type);
		dataCalendar.setData_status(data_status);
		dataCalendar.setConsume_time((int)((endMillionds-startMillions)/60000));
		dataCalendarService.insertDataCalendar(dataCalendar);
	}
	
	public void updateDataCalendar(DataCalendar dataCalendar,String fail_cause,Integer data_type
			,Integer data_status,long startMillions,Long data_id) throws Exception{
		long endMillionds = System.currentTimeMillis();
		dataCalendar.setFail_cause(fail_cause);
		dataCalendar.setEnd_time(sdf2.format(new Date()));
		dataCalendar.setData_type(data_type);
		dataCalendar.setData_status(data_status);
		dataCalendar.setConsume_time((int)((endMillionds-startMillions)/60000));
		dataCalendar.setData_id(data_id);
		dataCalendarService.updateEntireDataCalendar(dataCalendar);
	}
	
	
	public void deCryptFiles(File[] files,File destFile){
		// deCryptFiles文件夹下要存放的是解密后的txt文件
		//解密文件到另一个文件夹
		for(File f : files){
			String fName = f.getName().toLowerCase();
			if(fName.endsWith(".txt")){
				try {
					CipherUtil.decryptFile(f.getAbsolutePath(), destFile.getAbsolutePath()+"/"+fName);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	//真正执行数据导入的方法
		public  boolean dataImort(String rq , File[] files){
			String ksrq = rq + " 00:00:00";	
			String jsrq = rq + " 23:59:59";
			ArrayList<File> list = new ArrayList<File>();
			for(File f : files){
				String fName = f.getName().toLowerCase();
				if (fName.endsWith(".txt")){
					list.add(f);
				}
			}
			FileHelper.writeLog(sdf2.format(new Date())+" 日期为"+rq+"的文件共有"+list.size()+"个txt文件需要导入");
			//防止因为一个表出错，无限循环
			int cnt = 0;
			//list中是将要导入的文件列表，当文件全部导入成功的时候才结束
			while(list != null && list.size() > 0){
				File f = list.get(0);
				String fName = f.getName().toLowerCase();
				// 是TXT文件
				if (fName.endsWith(".txt")){
					String tableName = fName.substring(0,fName.length() - 4).toLowerCase();
					if (tableName.contains(Constants.table_dkmnlrgzmx)) {
						try {
							performanceDkmnlrgzMxService.createTable(tableName);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
							continue;
						}
					}else if (tableName.contains(Constants.table_ckmnlrgzmx)) {
						try {
							performanceCkmnlrgzMxService.createTable(tableName);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
							continue;
						}
					}else if(tableName.contains("erp_wage_ckaljcgzmx")){
						try {
							performanceCkAljcgzMxService.createTable(tableName);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
							continue;
						}
					}else if(tableName.contains("erp_wage_ckyzkhgzmx")){
						try {
							performanceCkYzkhgzMxService.createTable(tableName);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
							continue;
						}
					}else if(tableName.contains("erp_wage_dkaljcgzmx")){
						try {
							performanceDkAljcgzMxService.createTable(tableName);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
							continue;
						}
					}
					//删除表记录
					if(fName.equals(fileNames[0]) || fName.equals(fileNames[1]) 
							|| fName.equals(fileNames[2]) || fName.equals(fileNames[3])){
						try {
							dataInfoService.deleteMarketingData(tableName, minNum);
							
						} catch (Exception e) {
							e.printStackTrace();
							continue;
						}
					}else if(fName.equals("erp_wage_ygjx.txt") || fName.equals("erp_wage_ygjx_mx.txt")){
						try {
							dataInfoService.deleteTableDataByrq(tableName, zd[0], ksrq, jsrq);

						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
							continue;
						}
					}else if(fName.contains("erp_wage_ckmnlrgzmx_") || fName.equals("erp_wage_ckkhhsmx.txt")
							|| fName.contains("erp_wage_dkmnlrgzmx_") || fName.equals("erp_wage_dkkhbsmx.txt")
							|| fName.contains("erp_wage_ckaljcgzmx_") || fName.contains("erp_wage_ckyzkhgzmx_")
							|| fName.contains("erp_wage_dkaljcgzmx_")|| fName.equals("erp_wage_dkkhhsmx.txt")
							|| fName.equals("erp_wage_dydklxshmx.txt") || fName.equals("erp_wage_bmkkhhsmx.txt")){
						try {
							dataInfoService.deleteTableDataByrq(tableName, zd[1], ksrq, jsrq);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
							continue;
						}
					}else{
						try {
							dataInfoService.deleteTableData(tableName);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
							continue;
						}
					}
					String fPath = f.getAbsolutePath();
					try {
						dataInfoService.dataload(tableName, fPath,separator);
						FileHelper.writeLog(sdf2.format(new Date())+" 日期为"+rq+"的表"+tableName+"数据导入成功");
						list.remove(0);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						FileHelper.writeLog(sdf2.format(new Date())+ "日期为"+rq+"的表"+tableName+"数据导入失败");
					}
				}
				cnt++;
				//导入次数太多，跳出循环，避免无限循环
				if(cnt > 200){
					FileHelper.writeLog(rq+"的数据循环导入次数太多，退出导入..");
					break;
				}
			}
			//写入一个回车
			FileHelper.writeLog("");
			return list.size() == 0 ? true : false;
		}
		
		//数据导出
		public boolean dataExport(String yearMonthDay,Date startDate) throws Exception{
			String data_time = sdf.format(startDate);
			//查找是否存在导出记录，若不存在就插入记录，否则更新记录
			DataCalendar failNote = dataCalendarService.findDataCalendarByCond(data_time, 0, 0);
			long startMillions = System.currentTimeMillis();
			DataCalendar dataCalendar = new DataCalendar();
			dataCalendar.setStart_time(sdf2.format(new Date()));
			dataCalendar.setData_time(sdf.format(startDate));
			String path = System.getProperty("user.dir")+"/"+"upload"+"/";
			File upload = new File(path);
			if(!upload.exists()){
				upload.mkdir();
			}
			//String path = request.getSession().getServletContext().getRealPath("upload/");
			File zipParent = new File(path,"data");
			if(!zipParent.exists() || !zipParent.isDirectory()){
				zipParent.mkdir();
			}
			//创建加密文件存放的文件
			File enCryptFiles = new File(path,"enCryptFiles");
			if(!enCryptFiles.exists()){
				enCryptFiles.mkdir();
			}
			File zipTmpDirectory = new File(path,"zipTmpDirectory");
			if(!zipTmpDirectory.exists()){
				zipTmpDirectory.mkdir();
			}
			//删除上次导出的生成的zip文件
			FileHelper.deleteFilesInDirectory(zipTmpDirectory);
			//首先删除当前文件夹中的文件(上次导出存留的文件)
			FileHelper.deleteFilesInDirectory(zipParent);
			//删除之前加密文件夹里面的文件
			FileHelper.deleteFilesInDirectory(enCryptFiles);
			for(int i = 0; i < fileNames.length; i++){
				String line = "";
				File file = new File(zipParent.getAbsolutePath(),fileNames[i]);
				if(!file.exists()){
					try {
						file.createNewFile();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						return false;
					}
				}
				//查询以99开头的
				if(i == 0){
					//判断要求yybh字段长度至少12
					List<DepositMarketing> list = new ArrayList<DepositMarketing>();
					try {
						list = depositMarketingService.findDepositMarketingByPrefix("99", 12);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						//记录为空就插入，否则就更新错误信息
						if(failNote == null){
							insertDataCalendar(dataCalendar,"数据库访问失败",0,0,startMillions);
						}else{
							updateDataCalendar(dataCalendar,"数据库访问失败",0,0,startMillions,failNote.getData_id());
						}
						return false;
					}
					for(int j = 0; j < list.size(); j++){
						StringBuilder sb = new StringBuilder();
						DepositMarketing one = list.get(j);
						line += sb.append(one.getJgdm()).append("|")
								.append(one.getCkzl()).append("|")
								.append(one.getKhzl()).append("|")
								.append(one.getZjlb()).append("|")
								.append(one.getZjhm()).append("|")
								.append(one.getKhmc()).append("|")
								.append(one.getYxbl()).append("|")
								.append(one.getSbzt()).append("|")
								.append(one.getLrr()).append("|")
								.append(one.getLrbz()).append("|")
								.append(one.getLrsj()).append("|")
								.append(one.getYyrq()).append("|")
								.append(one.getYybh()).append("|")
								.append(one.getYggh()).append("|")
								.append(one.getYgxm()).append("|")
								.append(one.getSjhm() == null ? "" : one.getSjhm()).append(separator).toString();
					}
				}else if(i == 1){
					List<CellBankMarketing> list = new ArrayList<CellBankMarketing>();
					try {
						list = cellBankMarketingService.findCellBankMarketingByPrefix("99", 12);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						//记录为空就插入，否则就更新错误信息
						if(failNote == null){
							insertDataCalendar(dataCalendar,"数据库访问失败",0,0,startMillions);
						}else{
							updateDataCalendar(dataCalendar,"数据库访问失败",0,0,startMillions,failNote.getData_id());
						}
						return false;
					}
					for(int j = 0; j < list.size(); j++){
						StringBuilder sb = new StringBuilder();
						CellBankMarketing one = list.get(j);
						line += sb.append(one.getJgdm()).append("|")
								.append(one.getZjlb()).append("|")
								.append(one.getZjhm()).append("|")
								.append(one.getKhmc()).append("|")
								.append(one.getSjhm()).append("|")
								.append(one.getYxbl()).append("|")
								.append(one.getSbzt()).append("|")
								.append(one.getLrr()).append("|")
								.append(one.getLrbz()).append("|")
								.append(one.getLrsj()).append("|")
								.append(one.getYyrq()).append("|")
								.append(one.getYybh()).append("|")
								.append(one.getYggh()).append("|")
								.append(one.getYgxm() == null ? "" : one.getYgxm()).append(separator).toString();
					}
				}else if(i == 2){
					List<EtcMarketing> list = new ArrayList<EtcMarketing>();
					try {
						list = etcMarketingService.findEtcMarketingByPrefix("99", 12);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						//记录为空就插入，否则就更新错误信息
						if(failNote == null){
							insertDataCalendar(dataCalendar,"数据库访问失败",0,0,startMillions);
						}else{
							updateDataCalendar(dataCalendar,"数据库访问失败",0,0,startMillions,failNote.getData_id());
						}
						return false;
					}
					for(int j = 0; j < list.size(); j++){
						StringBuilder sb = new StringBuilder();
						EtcMarketing one = list.get(j);
						line += sb.append(one.getJgdm()).append("|")
								.append(one.getZjlb()).append("|")
								.append(one.getZjhm()).append("|")
								.append(one.getKhmc()).append("|")
								.append(one.getSjhm()).append("|")
								.append(one.getYxbl()).append("|")
								.append(one.getSbzt()).append("|")
								.append(one.getLrr()).append("|")
								.append(one.getLrbz()).append("|")
								.append(one.getLrsj()).append("|")
								.append(one.getYyrq()).append("|")
								.append(one.getYybh()).append("|")
								.append(one.getYggh()).append("|")
								.append(one.getYgxm() == null ? "" : one.getYgxm()).append(separator).toString();
					}
				}else{//khgxgl_posyxdjb
					List<PosMarketing> list = new ArrayList<PosMarketing>();
					try {
						list = posMarketingService.findPosMarketingByPrefix("99",12);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						//记录为空就插入，否则就更新错误信息
						if(failNote == null){
							insertDataCalendar(dataCalendar,"数据库访问失败",0,0,startMillions);
						}else{
							updateDataCalendar(dataCalendar,"数据库访问失败",0,0,startMillions,failNote.getData_id());
						}
						return false;
					}
					for(int j = 0; j < list.size(); j++){
						StringBuilder sb = new StringBuilder();
						PosMarketing one = list.get(j);
						line += sb.append(one.getJgdm()).append("|")
								.append(one.getZjlb()).append("|")
								.append(one.getZjhm()).append("|")
								.append(one.getKhmc()).append("|")
								.append(one.getSjhm()).append("|")
								.append(one.getYxbl()).append("|")
								.append(one.getSbzt()).append("|")
								.append(one.getLrr()).append("|")
								.append(one.getLrbz()).append("|")
								.append(one.getLrsj()).append("|")
								.append(one.getYyrq()).append("|")
								.append(one.getYybh()).append("|")
								.append(one.getYggh()).append("|")
								.append(one.getYgxm()).append("|")
								.append(one.getKhckzh() == null ? "" : one.getKhckzh()).append(separator).toString();
					}
				}
				line = line.replace("|null|", "||");
				FileOutputStream fos = new FileOutputStream(file);
				if(!file.exists()){
					try {
						file.createNewFile();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						if(failNote == null){
							insertDataCalendar(dataCalendar,"文件创建失败",0,0,startMillions);
						}else{
							updateDataCalendar(dataCalendar,"文件创建失败",0,0,startMillions,failNote.getData_id());
						}
						fos.close();
						return false;
					}
				}
				byte[] contentInBytes = line.getBytes();
				try {
					fos.write(contentInBytes);
					fos.flush();
					fos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					if(failNote == null){
						insertDataCalendar(dataCalendar,"导出数据写文件失败",0,0,startMillions);
					}else{
						updateDataCalendar(dataCalendar,"导出数据写文件失败",0,0,startMillions,failNote.getData_id());
					}
					return false;
				}
			}
			String zipName = "app_"+yearMonthDay+".zip";
			File zipFile = new File(zipTmpDirectory,zipName);
			File files[] = zipParent.listFiles();
			//加密文件
//			for(File f : files){
//				try {
//					String txtPath = enCryptFiles.getAbsolutePath()+"/"+f.getName().toLowerCase();
//					CipherUtil.encryptFile(f.getAbsolutePath(),txtPath);
//				} catch (Exception e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//					return false;
//				}
//			}
			//压缩未加密文件
			try{
				Zipper.zip(zipParent.getAbsolutePath(),zipFile.getAbsolutePath());
			}catch(Exception e){
				e.printStackTrace();
				if(failNote == null){
					insertDataCalendar(dataCalendar,"文件压缩失败",0,0,startMillions);
				}else{
					updateDataCalendar(dataCalendar,"文件压缩失败",0,0,startMillions,failNote.getData_id());
				}
				return false;
			}
			//压缩加密后的文件
			//Zipper.zip(enCryptFiles.getAbsolutePath(),zipFile.getAbsolutePath());
			//上传解压后的文件
			FileInputStream input = new FileInputStream(zipFile);
			boolean flag = FtpUtil.uploadFile(FtpUtil.ftpHost, FtpUtil.ftpUserName, FtpUtil.ftpPassword,
					FtpUtil.ftpPort, FtpUtil.ftpPathClient, zipName, input,yearMonthDay.substring(0,yearMonthDay.length()-2));
			if(flag){
				System.out.println("上传成功!");
				insertDataCalendar(dataCalendar,null,0,1,startMillions);
			}else{
				//导出失败
				System.out.println("上传失败!");
				if(failNote == null){
					insertDataCalendar(dataCalendar,"上传失败",0,0,startMillions);
				}else{
					updateDataCalendar(dataCalendar,"上传失败",0,0,startMillions,failNote.getData_id());
				}
			}
			return flag;
		}
}  