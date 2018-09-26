package com.readboy.ssm.controller;

import java.io.File;

import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
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
import com.readboy.ssm.service.DepositMarketingService;
import com.readboy.ssm.service.EtcMarketingService;
import com.readboy.ssm.service.PerformanceCkmnlrgzMxService;
import com.readboy.ssm.service.PerformanceDkmnlrgzMxService;
import com.readboy.ssm.service.PosMarketingService;
import com.readboy.ssm.utils.Constants;
/**
 * 这个已经不用了，留在这里方便需求更改
 * @author:	   	LCL
 * @date: 	   	2017-7-9
 * @description:使用mysql语句：data load批量插入数据
 */
@Controller
public class DataInfoController {
	
	@Autowired
	private PerformanceDkmnlrgzMxService performanceDkmnlrgzMxService;
	@Autowired
	private PerformanceCkmnlrgzMxService performanceCkmnlrgzMxService;
	@Autowired
	private DataInfoService dataInfoService;
	@Autowired
	private DepositMarketingService depositMarketingService;
	@Autowired
	private CellBankMarketingService cellBankMarketingService;
	@Autowired
	private EtcMarketingService etcMarketingService;
	@Autowired
	private PosMarketingService posMarketingService;
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
	private String separator = System.getProperty("line.separator","\n");
	@RequestMapping(value="/dataload.action",method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView dataload(HttpServletRequest request,
		@RequestParam(value="file",required=true) MultipartFile  file[]){
		List<String> message = new ArrayList<String>();
		String tableNames[] = request.getParameterValues("tableName");
		String rqs[] = request.getParameterValues("rq"); 
		for(int i = 0; i < file.length; i++){
			MultipartFile  f = file[i];
			//选择了表名且导入了文件
			if(!f.isEmpty() && !tableNames[i].equals("") && tableNames[i] != null){
				//String fileName = f.getOriginalFilename();
		        //若此表是需要新建的,则先建数据库表
		        if(tableNames[i].equals(Constants.table_dkmnlrgzmx) && !rqs[i].equals("")){
		        	try {
		        		tableNames[i] += "_"+rqs[i];
						performanceDkmnlrgzMxService.createTable(tableNames[i]);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		        }else if(tableNames[i].equals(Constants.table_ckmnlrgzmx) && !rqs[i].equals("")){
		        	try {
		        		tableNames[i] += "_"+rqs[i]; 
						performanceCkmnlrgzMxService.createTable(tableNames[i]);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		        }
		        String path = request.getSession().getServletContext().getRealPath("upload/");
		        //上传文件命名为:表名+时间+后缀
		        File dir = new File(path,tableNames[i]+sdf.format(new Date())+".txt");
		        String fileDest = dir.getAbsolutePath();
		        System.out.print(fileDest);
		        if(!dir.exists()){  
		            dir.mkdirs();
		        }
		        //MultipartFile自带的解析方法  
		        try {
		        	//文件上传
					f.transferTo(dir);
				} catch (IllegalStateException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		        //文件导入数据库
		        try {
					dataInfoService.dataload(tableNames[i], fileDest,separator);
					message.add(tableNames[i]+"导入成功...");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					message.add(tableNames[i]+"导入失败！");
				}
		        
			}
		}
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("message",message);
		modelAndView.setViewName("success");
		return modelAndView;
	}
	
	@RequestMapping(value="/dataexport.action",method={RequestMethod.POST,RequestMethod.GET})
	public ResponseEntity<byte[]> dataExport(HttpServletRequest request) throws Exception{
		String tableName = request.getParameter("exportTable");
		File file = new File(tableName+".txt");
		String line = "";
		if(tableName.equals(Constants.table_khgxgl_ckkhyxdjb)){
			List<DepositMarketing> list = depositMarketingService.findAllDepositMarketing();
			for(int i = 0; i < list.size(); i++){
				StringBuilder sb = new StringBuilder();
				DepositMarketing one = list.get(i);
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
						.append(one.getSjhm() == null ? "" : one.getSjhm()).append("\r\n").toString();
			}
			
			
		}else if(tableName.equals(Constants.table_khgxgl_sjyhyxdjb)){
			List<CellBankMarketing> list = cellBankMarketingService.findAllCellBankMarketing();
			for(int i = 0; i < list.size(); i++){
				StringBuilder sb = new StringBuilder();
				CellBankMarketing one = list.get(i);
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
						.append(one.getYgxm() == null ? "" : one.getYgxm()).append("\r\n").toString();
			}
		}else if(tableName.equals(Constants.table_khgxgl_etcyxdjb)){
			List<EtcMarketing> list = etcMarketingService.findAllEtcMarketing();
			for(int i = 0; i < list.size(); i++){
				StringBuilder sb = new StringBuilder();
				EtcMarketing one = list.get(i);
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
						.append(one.getYgxm() == null ? "" : one.getYgxm()).append("\r\n").toString();
			}
		}else{//khgxgl_posyxdjb
			List<PosMarketing> list = posMarketingService.findAllPosMarketing();
			for(int i = 0; i < list.size(); i++){
				StringBuilder sb = new StringBuilder();
				PosMarketing one = list.get(i);
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
						.append(one.getKhckzh() == null ? "" : one.getKhckzh()).append("\r\n").toString();
			}
		}
		//
		line = line.replace("|null|", "||");
		FileOutputStream fos = new FileOutputStream(file);
		if(!file.exists()){
			file.createNewFile();
		}
		byte[] contentInBytes = line.getBytes();
		fos.write(contentInBytes);
		fos.flush();
		fos.close();
		System.out.println("写入完毕");
		//文件下载
		HttpHeaders headers = new HttpHeaders();    
        line=new String(line.getBytes("UTF-8"),"iso-8859-1");//为了解决中文名称乱码问题  
        headers.setContentDispositionFormData("attachment",tableName+".txt");   
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);   
        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),    
                                          headers, HttpStatus.CREATED);    
	}
}
