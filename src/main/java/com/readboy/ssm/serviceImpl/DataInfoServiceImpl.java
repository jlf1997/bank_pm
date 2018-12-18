package com.readboy.ssm.serviceImpl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.readboy.ssm.appjx.service.KhgxglCkkhyxdjbService;
import com.readboy.ssm.appjx.service.KhgxglSjyhyxdjbService;
import com.readboy.ssm.mapper.DataInfoMapper;
import com.readboy.ssm.service.DataInfoService;
import com.readboy.ssm.utils.LogsUtil;

@Service
public class DataInfoServiceImpl implements DataInfoService{
	
	private static final Logger log = LoggerFactory.getLogger(DataInfoServiceImpl.class);
	
	@Autowired
	private KhgxglCkkhyxdjbService khgxglCkkhyxdjbService;
	
	@Autowired
	private KhgxglSjyhyxdjbService khgxglSjyhyxdjbService;
	
	@Autowired
	private DataInfoMapper dataInfoMapper;
	
	@Override
	public long dataload(String tableName, String fileDest,String separator) throws Exception {
		return dataInfoMapper.dataload(tableName, fileDest,separator);
	}

	@Override
	public void deleteTableData(String tableName) throws Exception {
		dataInfoMapper.deleteTableData(tableName);
	}

	@Override
	public void deleteMarketingData(String tableName, long minNum)
			throws Exception {
		dataInfoMapper.deleteMarketingData(tableName, minNum);
	}

	@Override
	public void deleteTableDataByrq(String tableName, String zd, String ksrq,
			String jsrq) throws Exception {
		dataInfoMapper.deleteTableDataByrq(tableName, zd, ksrq, jsrq);
	}
	
	@Override
	public long getDataCount(String tableName) throws Exception {
		return dataInfoMapper.getDataCount(tableName);
	}

	@Override
	public String findWheatherTableExist(String tableName) throws Exception {
		return dataInfoMapper.findWheatherTableExist(tableName);
	}

	@Override
	public long parseFile(int type,String tableName, File f , String separator) throws Exception{
		// TODO Auto-generated method stub
		List<String> list = new ArrayList<>();
		readFileByLines(type,f,list);
		//修改原来文件
		String newFilePath =f.getAbsolutePath()+"back";
		File newFile = new File(newFilePath);
		writeFile(newFile,list,separator);
		return dataload(tableName,newFile.getAbsolutePath(),separator);
	}
	
	
	private void writeFile(File file,List<String> list,String separator) throws IOException {
		String line ="";
		for(int j = 0; j < list.size(); j++){
			line += list.get(j)+separator;
		}
		line = line.replace("|null|", "||");
		FileOutputStream fos = new FileOutputStream(file);
		if(!file.exists()){
			try {
				file.createNewFile();
			} catch (IOException e) {
				log.error("创建文件失败："+file.getAbsolutePath()+",异常为："+LogsUtil.getStackTrace(e));
				fos.close();
				return ;
			}
		}
		byte[] contentInBytes = line.getBytes();
		try {
			fos.write(contentInBytes);
			fos.flush();
			fos.close();
		} catch (IOException e) {
			log.error(LogsUtil.getStackTrace(e));
			return ;
		}
	
	}
	
	  /** 
     * 以行为单位读取文件，常用于读面向行的格式化文件 
     */  
    private  void readFileByLines(int type,File file,List<String> list) {  
        BufferedReader reader = null;  
        try {  
        	log.debug("以行为单位读取文件内容，一次读一整行：");  
            reader = new BufferedReader(new FileReader(file));  
            String tempString = null;  
            // 一次读入一行，直到读入null为文件结束  
            while ((tempString = reader.readLine()) != null) {  
                // 显示行号  
            	
            	switch(type) {
            	case 0:
            	case 1:
            		parsesKHGXG(type,tempString,list);
            		break;
            	default :
            		log.error("未知类型");
            	}
            }  
            reader.close();  
        } catch (IOException e) {  
            e.printStackTrace();  
        } finally {  
            if (reader != null) {  
                try {  
                    reader.close();  
                } catch (IOException e1) {  
                }  
            }  
        }  
    }
    private void parsesKHGXG(int type,String tempString,List<String> list) {
		switch(type) {
		case 0:
			parsesKHGXGL_CKKHYXDJB(tempString,list);
			break;
		case 1:
			parsesKHGXGL_SJYHYXDJB(tempString,list);
			break;
		default:
			break;
			
		}
		
		
    }
    //处理KHGXGL_CKKHYXDJB
	private void parsesKHGXGL_CKKHYXDJB(String tempString,List<String> list) {
		String[] filds = tempString.split("\\|");
		Integer sbzt = Integer.parseInt(filds[7]);
		String yybhStr = filds[12];
		Long yybh = Long.parseLong(yybhStr);
		//手机端记录进行更新
		if(yybhStr.startsWith("99") && yybhStr.length()>=12) {
			khgxglCkkhyxdjbService.update(sbzt, yybh);
		}else {
			list.add(tempString);
		}
		
	}
	//处理KHGXGL_SJYHYXDJB
	private void parsesKHGXGL_SJYHYXDJB(String tempString,List<String> list) {
		String[] filds = tempString.split("|");
		Integer sbzt = Integer.parseInt(filds[6]);
		String yybhStr = filds[11];
		Long yybh = Long.parseLong(yybhStr);
		//手机端记录进行更新
		if(yybhStr.startsWith("99") && yybhStr.length()>=12) {
			khgxglSjyhyxdjbService.update(sbzt, yybh);
		}else {
			list.add(tempString);
		}
	}
}
