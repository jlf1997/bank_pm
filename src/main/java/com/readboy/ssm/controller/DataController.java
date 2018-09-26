package com.readboy.ssm.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import com.readboy.ssm.po.*;
import com.readboy.ssm.service.CustomerService;
import com.readboy.ssm.service.LoanCustomerProductService;
import com.readboy.ssm.service.PerformanceCkmnlrgzMxService;
import com.readboy.ssm.service.PerformanceDkmnlrgzMxService;
import com.readboy.ssm.utils.Constants;
import com.readboy.ssm.utils.DataHelper;
/** 这个已经不用了，留在这里方便需求更改
 * @author:	   	LCL
 * @date: 	   	2017-6-28
 * @description:这个Controller用来进行数据导入导出。
 */
@Controller
public class DataController {
	@Autowired
	private LoanCustomerProductService loanCustomerProductService;
	@Autowired
	private PerformanceDkmnlrgzMxService performanceDkmnlrgzMxService;
	@Autowired
	private PerformanceCkmnlrgzMxService performanceCkmnlrgzMxService;
	@Autowired
	private CustomerService customerService;
	
	private final String encoding="UTF-8";
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private SimpleDateFormat sdf2 = new SimpleDateFormat("yyyyMMddHHmmss");
	@RequestMapping(value="/importData.action",method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView importData(HttpServletRequest request,
			@RequestParam(value="file",required=true) MultipartFile  file[]
			,ModelAndView modelAndView) throws Exception{
			List<String> message = new ArrayList<String>();
			for(MultipartFile f : file){
				if(!f.isEmpty()){
					String fileName = f.getOriginalFilename();
			        String tableName = fileName.split("\\.")[0];
			        //若此表是需要新建的,则先建数据库表
			        if(tableName.toLowerCase().startsWith(Constants.table_dkmnlrgzmx)){
			        	performanceDkmnlrgzMxService.createTable(tableName);
			        }else if(tableName.toLowerCase().startsWith(Constants.table_ckmnlrgzmx)){
			        	performanceCkmnlrgzMxService.createTable(tableName);
			        }
			        String path = request.getSession().getServletContext().getRealPath("upload/");  
			        File dir = new File(path,sdf2.format(new Date())+".txt");        
			        if(!dir.exists()){  
			            dir.mkdirs();
			        }
			        //MultipartFile自带的解析方法  
			        try {
						f.transferTo(dir);
					} catch (IllegalStateException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			        try {
						InputStreamReader reader = new InputStreamReader(
						//考虑到编码格式
			            new FileInputStream(dir),encoding);
			            BufferedReader br = new BufferedReader(reader);
			            String line="";
			            String defaultStr = "";
			            ArrayList<String> valueList = null;
			            ArrayList<ArrayList<String>> lists = new ArrayList<ArrayList<String>>();
			            while((line = br.readLine()) != null){
			            	int index = 0;
			            	valueList = new ArrayList<String>();
			            	String tmpLine = line;
			            	while((index = tmpLine.indexOf("|")) >= 0){
			            		if(index > 0){
			            			valueList.add(tmpLine.substring(0,index));
			            		}else{
			            			valueList.add(defaultStr);
			            		}
			            		tmpLine = tmpLine.substring(index+1);
			            	}
			            	if(tmpLine.length() > 0){
			            		valueList.add(tmpLine);
			            	}else{
			            		valueList.add(defaultStr);
			            	}
			            	lists.add(valueList);
			            }
			            //此方法会将lists中的数据插入到表中
			            insertIntoTable(tableName,lists);
			            message.add(tableName+"导入成功！");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			if(message.size() > 0){//至少有一个文件导入成功
				modelAndView.addObject("message",message);
				modelAndView.setViewName("success");
				return modelAndView;
			}
			//没有一个文件导入成功
			message.add("数据导入出错");
			modelAndView.addObject("message",message);
			modelAndView.setViewName("fail");
			return modelAndView;
	}
	
	public void insertIntoTable(String tableName,ArrayList<ArrayList<String>> lists) throws Exception{
		String table_name = tableName.toLowerCase();
		DataHelper helper = new DataHelper();
		//若是动态建立带时间的表格
		if(table_name.startsWith(Constants.table_dkmnlrgzmx+"_")){
			List<PerformanceDkmnlrgzMx> list = helper.dataLoad(new PerformanceDkmnlrgzMx().getClass(),lists);
			performanceDkmnlrgzMxService.batchInsertPerformanceDkmnlrgzMx(table_name,list);
			return;
		}else if(table_name.startsWith(Constants.table_ckmnlrgzmx+"_")){
			List<PerformanceCkmnlrgzMx> list = helper.dataLoad(new PerformanceCkmnlrgzMx().getClass(),lists);
			performanceCkmnlrgzMxService.batchInsertPerformanceCkmnlrgzMx(table_name,list);
			return;
		}
		switch(table_name){
		case Constants.table_app_dkkhcpxx:
			batchInert_app_dkkhcpxx(lists);
			break;
		case Constants.table_app_mycust:
			List<Customer> list = helper.dataLoad(Customer.class, lists);
			customerService.batchInsertCustomer(list);
			break;
		case Constants.table_app_sjyhcpxx:
			break;
		default:
				break;
		}
	}
	
	public void batchInert_app_dkkhcpxx(ArrayList<ArrayList<String>> lists) throws Exception{
		List<LoanCustomerProduct> list = new ArrayList<LoanCustomerProduct>();
		LoanCustomerProduct product = null;
		for(List<String> note : lists){
			product = new LoanCustomerProduct();
			product.setLrsj(sdf.format(new Date()));
			for(int i = 0; i < note.size(); i++){
				if(note.get(i).equals("") || note.get(i) == null){
					continue;
				}
				switch(i){
				case 0:
					product.setCpmc(note.get(i));
					break;
				case 1:
					product.setJgdm(note.get(i));
					break;
				case 2:
					product.setKhbh(note.get(i));
					break;
				case 3:
					product.setHth(note.get(i));
					break;
				case 4:
					product.setDkzh(note.get(i));
					break;
				case 5:
					product.setFfrq(note.get(i));
					break;
				case 6:
					product.setDqrq(note.get(i));
					break;
				case 7:
					product.setDkje(new BigDecimal(note.get(i)));
					break;
				case 8:
					product.setDkye(new BigDecimal(note.get(i)));
					break;
				case 9:
					product.setLl(new BigDecimal(note.get(i)));
					break;
				case 10:
					product.setKhjlmc(note.get(i));
					break;
				case 11:
					product.setFive_class_type(Integer.parseInt(note.get(i)));
					break;
				case 12:
					product.setYxr(note.get(i));
					break;
				case 13:
					product.setYxbl(new BigDecimal(note.get(i)));
					break;
				case 14:
					product.setGhr(note.get(i));
					break;
				case 15:
					product.setGhbl(new BigDecimal(note.get(i)));
					break;
				case 16:
					product.setBsr(note.get(i));
					break;
				case 17:
					product.setBsbl(new BigDecimal(note.get(i)));
					break;
				case 18:
					product.setSpr(note.get(i));
					break;
				case 19:
					product.setSpbl(new BigDecimal(note.get(i)));
					break;
				case 20:
					product.setDcr(note.get(i));
					break;
				case 21:
					product.setDcbl(new BigDecimal(note.get(i)));
					break;
				case 22:
					product.setLrr(note.get(i));
					break;
				case 23:
					product.setLrbz(Integer.parseInt(note.get(i)));
					break;
				case 24:
					product.setLrsj(sdf.format(new Date()));
					break;
				default:
					break;
				}
			}
			list.add(product);
		}
		loanCustomerProductService.batchInsertLoanCustomerProduct(list);
	}
	
	public void batchInsert_erp_wage_dkmnlrgzmx(ArrayList<ArrayList<String>> lists){
		List<PerformanceDkmnlrgzMx> list = new ArrayList<PerformanceDkmnlrgzMx>();
		PerformanceDkmnlrgzMx pdm = null;
		for(List<String> note : lists){
			pdm = new PerformanceDkmnlrgzMx();
			for(int i = 0; i < note.size(); i++){
				if(note.get(i).equals("") || note.get(i) == null){
					continue;
				}
				switch(i){
				case 0:
					pdm.setTjrq(note.get(i));
					break;
				case 1:
					pdm.setJgdm(note.get(i));
					break;
				case 2:
					pdm.setZzbz(note.get(i));
					break;
				case 3:
					pdm.setGwbz(Long.parseLong(note.get(i)));
					break;
				case 4:
					pdm.setYggh(note.get(i));
					break;
				case 5:
					pdm.setDkzh(note.get(i));
					break;
				case 6:
					pdm.setHth(note.get(i));
					break;
				case 7:
					pdm.setZhmc(note.get(i));
					break;
				case 8:
					pdm.setZjhm(note.get(i));
					break;
				case 9:
					pdm.setDkje(new BigDecimal(note.get(i)));
					break;
				case 10:
					pdm.setDkye(new BigDecimal(note.get(i)));
					break;
				case 11:
					pdm.setFfrq(note.get(i));
					break;
				case 12:
					pdm.setDqrq(note.get(i));
					break;
				case 13:
					pdm.setWjflbz(Integer.parseInt(note.get(i)));
					break;
				case 14:
					pdm.setNcwjflbz(Integer.parseInt(note.get(i)));
					break;
				case 15:
					pdm.setYwzl(note.get(i));
					break;
				case 16:
					pdm.setZzqxrq(note.get(i));
					break;
				case 17:
					pdm.setLl(new BigDecimal(note.get(i)));
					break;
				case 18:
					pdm.setCbl(new BigDecimal(note.get(i)));
					break;
				case 19:
					pdm.setLlc(new BigDecimal(note.get(i)));
					break;
				case 20:
					pdm.setRllc(new BigDecimal(note.get(i)));
					break;
				case 21:
					pdm.setFcbl(new BigDecimal(note.get(i)));
					break;
				case 22:
					pdm.setQmmnlr(new BigDecimal(note.get(i)));
					break;
				case 23:
					pdm.setQmljmnlr(new BigDecimal(note.get(i)));
					break;
				case 24:
					pdm.setClye(new BigDecimal(note.get(i)));
					break;
				case 25:
					break;
		
				case 26:
					break;
				case 27:
					break;
				case 28:
					break;
				case 29:
					break;
				case 30:
					break;
				case 31:
					break;
				default:
					break;
				}
			}
			list.add(pdm);
		}
//		performanceDkmnlrgzMxService.batchInsertPerformanceDkmnlrgzMx(list);
	}
}
