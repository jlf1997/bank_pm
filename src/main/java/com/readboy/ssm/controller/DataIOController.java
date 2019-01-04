package com.readboy.ssm.controller;


import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.readboy.ssm.po.CellBankMarketing;
import com.readboy.ssm.po.DepositMarketing;
import com.readboy.ssm.po.EtcMarketing;
import com.readboy.ssm.po.PosMarketing;
import com.readboy.ssm.service.CellBankMarketingService;
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
import com.readboy.ssm.timetask.OnApplicationStarted;
import com.readboy.ssm.utils.Constants;
import com.readboy.ssm.utils.Zipper;
/**
 * @author:	   	LCL
 * @date: 	   	2017-6-28
 * @description:这个Controller用来进行数据导入导出。
 */
@Controller
public class DataIOController {
	
	@Autowired
	private PerformanceDkmnlrgzMxService performanceDkmnlrgzMxService;
	@Autowired
	private PerformanceCkmnlrgzMxService performanceCkmnlrgzMxService;
	@Autowired
	private DataInfoService dataInfoService;
	@Autowired
	private CellBankMarketingService cellBankMarketingService;
	@Autowired
	private DepositMarketingService depositMarketingService;
	@Autowired
	private EtcMarketingService etcMarketingService;
	@Autowired
	private PosMarketingService posMarketingService;
	@Autowired
	private PerformanceCkAljcgzMxService performanceCkAljcgzMxService;
	@Autowired
	private PerformanceDkAljcgzMxService performanceDkAljcgzMxService;
	@Autowired
	private PerformanceCkYzkhgzMxService performanceCkYzkhgzMxService;
	@Autowired 
	private DataLogService dataLogService;
	@Autowired
	private OnApplicationStarted onApplicationStarted;
	private final long minNum = 99000000000L;
	private final String separator = System.getProperty("line.separator","\n");
	private final String fileNames[] = {"khgxgl_ckkhyxdjb.txt","khgxgl_sjyhyxdjb.txt",
			"khgxgl_etcyxdjb.txt","khgxgl_posyxdjb.txt"};
	
	private final String zd[] = {"gzrq","tjrq"};
	
	private static final Logger log = LoggerFactory.getLogger(DataIOController.class);
	
	@RequestMapping(value = "/dataImport.action", method = {
			RequestMethod.POST, RequestMethod.GET })
	public ModelAndView importData(HttpServletRequest request,
			@RequestParam(value = "file", required = true) MultipartFile file,
			ModelAndView modelAndView) {
		String fileName = file.getOriginalFilename();
		log.info("开始导入数据："+fileName);
		if(fileName.length() < 12){
			log.error("文件名字长度有错");
			modelAndView.addObject("message", "文件名字长度有错！");
			modelAndView.setViewName("fail");
			return modelAndView;
		}
		String rq = new StringBuilder(fileName.substring(4,8)).append("-").append(fileName.substring(8,10))
				.append("-").append(fileName.substring(10,12)).toString();
		String ksrq = rq + " 00:00:00";	
		String jsrq = rq + " 23:59:59";
		List<String> message = new ArrayList<String>();
		int importCount = 0,deleteCount = 0,fileCount = 0;
		String path = request.getSession().getServletContext().getRealPath("upload/");
		File upload = new File(path);
		//残余文件删除
		Zipper.deleteAllFile(upload);
		if(!upload.exists()){
			upload.mkdirs();
		}
		if (!file.isEmpty()) {
			File dir = new File(path, fileName);
			if (!dir.exists()) {
				dir.mkdirs();
			}
			// MultipartFile自带的解析方法
			try {
				file.transferTo(dir);
			} catch (Exception e) {
				e.printStackTrace();
			}
			String dirPath = dir.getAbsolutePath();
			log.info("开始解压"+dirPath);
			Zipper.unzip(dirPath, dir.getParentFile().getAbsolutePath());
			log.info("解压完成");
			if (upload.isDirectory()){
				File files[] = upload.listFiles();
				for (File f : files) {
					String fName = f.getName().toLowerCase();
					// 是TXT文件
					if (fName.endsWith(".txt")) {
						fileCount++;
						String tableName = fName.substring(0,fName.length() - 4).toLowerCase();
						if (tableName.contains(Constants.table_dkmnlrgzmx)) {
							try {
								performanceDkmnlrgzMxService.createTable(tableName);
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
								log.error("创建表erp_wage_dkmnlrgzmx异常");
							}
						}else if (tableName.contains(Constants.table_ckmnlrgzmx)) {
							try {
								performanceCkmnlrgzMxService.createTable(tableName);
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
								log.error("创建表erp_wage_ckmnlrgzmx异常");
							}
						}else if(tableName.contains("erp_wage_ckaljcgzmx")){
							try {
								performanceCkAljcgzMxService.createTable(tableName);
							} catch (Exception e) {
								e.printStackTrace();
								log.error("创建表erp_wage_ckaljcgzmx异常");
							}
						}else if(tableName.contains("erp_wage_ckyzkhgzmx")){
							try {
								performanceCkYzkhgzMxService.createTable(tableName);
							} catch (Exception e) {
								e.printStackTrace();
								log.error("创建表erp_wage_ckyzkhgzmx异常");
							}
						}else if(tableName.contains("erp_wage_dkaljcgzmx")){
							try {
								performanceDkAljcgzMxService.createTable(tableName);
							} catch (Exception e) {
								e.printStackTrace();
								log.error("创建表erp_wage_dkaljcgzmx异常");
							}
						}
						
						//删除表记录
						if(fName.equals(fileNames[0]) || fName.equals(fileNames[1]) 
								|| fName.equals(fileNames[2]) || fName.equals(fileNames[3])){
							try {
								dataInfoService.deleteMarketingData(tableName, minNum);
								message.add("表 "+tableName+" 删除记录成功!");
								deleteCount++;
							} catch (Exception e) {
								// TODO Auto-generated catch block
								message.add("表 "+tableName+" 删除记录失败!");
								e.printStackTrace();
							}
						}else if(fName.equals("erp_wage_ygjx.txt") || fName.equals("erp_wage_ygjx_mx.txt")){
							try {
								dataInfoService.deleteTableDataByrq(tableName, zd[0], ksrq, jsrq);
								message.add("表 "+tableName+"("+rq.toString()+")"+" 删除记录成功!");
								deleteCount++;
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}else if(fName.contains("erp_wage_ckmnlrgzmx_") || fName.equals("erp_wage_ckkhhsmx.txt")
								|| fName.contains("erp_wage_dkmnlrgzmx_") || fName.equals("erp_wage_dkkhbsmx.txt")
								|| fName.contains("erp_wage_ckaljcgzmx_") || fName.contains("erp_wage_ckyzkhgzmx_")
								|| fName.contains("erp_wage_dkaljcgzmx_")|| fName.equals("erp_wage_dkkhhsmx.txt")
								|| fName.equals("erp_wage_dydklxshmx.txt") || fName.equals("erp_wage_bmkkhhsmx.txt")
								|| fName.equals("erp_assessdata_jg_phjfk.txt") || fName.equals("tb_tjfx_cdzl.txt")	
								|| fName.equals("tb_tfjx_cdzl.txt") 
										){
							try {
								dataInfoService.deleteTableDataByrq(tableName, zd[1], ksrq, jsrq);
								message.add("表 "+tableName+"("+rq+")"+" 删除记录成功!");
								deleteCount++;
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}else{
							try {
								dataInfoService.deleteTableData(tableName);
								message.add("表 "+tableName+" 删除记录成功!");
								log.info("表 "+tableName+" 删除记录成功!");
								deleteCount++;
							} catch (Exception e) {
								// TODO Auto-generated catch block
								message.add("表 "+tableName+" 删除记录失败!");
								log.error("表 "+tableName+" 删除记录成功!");
								e.printStackTrace();
							}
						}
						String fPath = f.getAbsolutePath();
						try {
							if(fileNames[0].equals(fName)) {
								dataInfoService.parseFile(0,tableName, f, separator);
							}else if(fileNames[1].equals(fName)) {
								dataInfoService.parseFile(1,tableName, f, separator);
							}
							else {
								dataInfoService.dataload(tableName, fPath,separator);
							}
							message.add("表 "+tableName+" 导入成功！");
							log.info("表 "+tableName+" 导入成功!");
							importCount++;
						} catch (Exception e) {
							// TODO Auto-generated catch block
							message.add("表 "+tableName + " 导入失败！");
							log.error("表 "+tableName+" 导入失败!");
							e.printStackTrace();
						}
					}else {
						log.error("文件不是以txt结尾");
					}
				}
			}else {
				log.error("upload 不是文件夹");
			}
			//删除upload文件夹
			if(upload.exists()){
				Zipper.deleteAllFile(upload);
			}
			log.info("upload文件夹下内容删除成功!");
		}
		modelAndView.addObject("message", message);
		modelAndView.addObject("importCount", importCount);
		modelAndView.addObject("deleteCount", deleteCount);
		modelAndView.addObject("fileCount", fileCount);
		modelAndView.setViewName("success");
		return modelAndView;
	}
	
	@RequestMapping(value="/dataExport.action",method={RequestMethod.POST,RequestMethod.GET})
	public ResponseEntity<byte[]> dataExport(HttpServletRequest request) throws Exception{
		String path = request.getSession().getServletContext().getRealPath("upload/");
		File zipParent = new File(path,"data");
		if(!zipParent.exists() || !zipParent.isDirectory()){
			zipParent.mkdir();
		}
		for(int i = 0; i < fileNames.length; i++){
			String line = "";
			File file = new File(zipParent.getAbsolutePath(),fileNames[i]);
			if(!file.exists()){
				file.createNewFile();
			}
			//查询以99开头的
			if(i == 0){
				//判断要求yybh字段长度至少12
				List<DepositMarketing> list = depositMarketingService.findDepositMarketingByPrefix("99", 12);
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
				List<CellBankMarketing> list = cellBankMarketingService.findCellBankMarketingByPrefix("99", 12);
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
				List<EtcMarketing> list = etcMarketingService.findEtcMarketingByPrefix("99", 12);
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
				List<PosMarketing> list = posMarketingService.findPosMarketingByPrefix("99",12);
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
			//line=new String(line.getBytes("UTF-8"),"iso-8859-1");//为了解决中文名称乱码问题  
			FileOutputStream fos = new FileOutputStream(file);
			if(!file.exists()){
				file.createNewFile();
			}
			byte[] contentInBytes = line.getBytes();
			fos.write(contentInBytes);
			fos.flush();
			fos.close();
		}
		File zipFile = new File("data.zip");
		Zipper.zip(zipParent.getAbsolutePath(),zipFile.getAbsolutePath());
		//文件下载
		HttpHeaders headers = new HttpHeaders();    
        headers.setContentDispositionFormData("attachment",zipFile.getName());   
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);   
        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(zipFile),    
                                          headers, HttpStatus.CREATED);    
	}
	
}
