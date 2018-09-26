package com.readboy.ssm.utils;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.SocketException;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class FtpUtil {
	
//	public static final String ftpHost = "111.231.250.43";
//	public static final String ftpUserName = "lcl";
//	public static final String ftpPassword = "123";
//	public static final int ftpPort = 21;
//	public static final String ftpPath = "appdata/service/";
//	public static final String ftpPathClient = "appdata/client/";
//	public static final String uploadPath = System.getProperty("user.dir");
	
	public static String ftpHost;
	public static String ftpUserName;
	public static String ftpPassword;
	public static int ftpPort;
	public static String ftpPath;
	public static String ftpPathClient;
	public static String downloadPath;
	public static String start_date;
	public static String dataImportExportTime;
	
	
	@Value("${ftpHost}")
	public void setFtpHost(String ftpHost) {
		FtpUtil.ftpHost = ftpHost;
	}
	@Value("${ftpUserName}")
	public void setFtpUserName(String ftpUserName) {
		FtpUtil.ftpUserName = ftpUserName;
	}
	@Value("${ftpPassword}")
	public void setFtpPassword(String ftpPassword) {
		FtpUtil.ftpPassword = ftpPassword;
	}
	@Value("${ftpPort}")
	public void setFtpPort(int ftpPort) {
		FtpUtil.ftpPort = ftpPort;
	}
	@Value("${ftpPath}")
	public void setFtpPath(String ftpPath) {
		FtpUtil.ftpPath = ftpPath;
	}
	@Value("${ftpPathClient}")
	public void setFtpPathClient(String ftpPathClient) {
		FtpUtil.ftpPathClient = ftpPathClient;
	}
	@Value("${start_date}")
	public void setStart_time(String start_date) {
		FtpUtil.start_date = start_date;
	}
	@Value("${downloadPath}")
	public  void setDownloadPath(String downloadPath) {
		FtpUtil.downloadPath = downloadPath;
	}
	@Value("${dataImportExportTime}")
	public void setDataImportExportTime(String dataImportExportTime) {
		FtpUtil.dataImportExportTime = dataImportExportTime;
	}
	/**
     * 获取FTPClient对象
     *
     * @param ftpHost     FTP主机服务器
     * @param ftpPassword FTP 登录密码
     * @param ftpUserName FTP登录用户名
     * @param ftpPort     FTP端口 默认为21
     * @return
     */
    public static FTPClient getFTPClient(String ftpHost, String ftpUserName,
                                         String ftpPassword, int ftpPort) {
        FTPClient ftpClient = new FTPClient();
        try {
            ftpClient = new FTPClient();
            ftpClient.connect(ftpHost, ftpPort);// 连接FTP服务器
            ftpClient.login(ftpUserName, ftpPassword);// 登陆FTP服务器
            if (!FTPReply.isPositiveCompletion(ftpClient.getReplyCode())) {
                System.out.println("未连接到FTP，用户名或密码错误。");
                ftpClient.disconnect();
                return null;
            } else {
                System.out.println("FTP连接成功。");
            }
        } catch (SocketException e) {
            e.printStackTrace();
            System.out.println("FTP的IP地址可能错误，请正确配置。");
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("FTP的端口错误,请正确配置。");
            return null;
        }
        return ftpClient;
    }

    
	/*
     * 从FTP服务器下载文件
     *
     * @param ftpHost FTP IP地址
     * @param ftpUserName FTP 用户名
     * @param ftpPassword FTP用户名密码
     * @param ftpPort FTP端口
     * @param ftpPath FTP服务器中文件所在路径 格式： appdata/service/年月/
     * @param localPath 下载到本地的位置 格式：xx/upload/
     * @param fileName 文件名称  如 app_20180803.zip
     */
    public static boolean downloadFtpFile(String ftpHost, String ftpUserName,
    		String ftpPassword, int ftpPort, String ftpPath, String localPath,String fileName) {
        FTPClient ftpClient = null;
        try {
            ftpClient = getFTPClient(ftpHost, ftpUserName, ftpPassword, ftpPort);
            if(ftpClient == null){
            	//ftp连接不上返回false
            	return false;
            }
            ftpClient.setControlEncoding("UTF-8"); // 中文支持
            ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
            //客户机进入ftp的被动模式，主动向FTP服务器发起数据连接
            ftpClient.enterLocalPassiveMode();
            ftpClient.setDataTimeout(1000*3);
            ftpClient.setBufferSize(1024*200);
            //切换到服务器的指定路径下
            ftpClient.changeWorkingDirectory(ftpPath);
            //创建要下载的文件
            File localFile = new File(localPath+fileName);
            if(!localFile.exists()){
            	localFile.createNewFile();
            }
            OutputStream os = new FileOutputStream(localFile);
            //retrieveFile方法将当前路径下名为fileName的文件放到os输出流中，即进行文件下载
            boolean flag = ftpClient.retrieveFile(fileName, os);
            os.flush();
            os.close();
            ftpClient.logout();
            if(!flag){
            	return false;
            }
            return true;

        } catch (FileNotFoundException e) {
            System.out.println("没有找到" + ftpPath + "文件");
            e.printStackTrace();
            return false;
        } catch (SocketException e) {
            System.out.println("连接FTP失败.");
            e.printStackTrace();
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("文件读取错误。");
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Description: 向FTP服务器上传文件
     * @param ftpHost FTP服务器hostname
     * @param ftpUserName 账号
     * @param ftpPassword 密码
     * @param ftpPort 端口
     * @param ftpPath  FTP服务器中文件所在路径 格式： appdata/client/
     * @param fileName ftp文件名称
     * @param input 文件流
     * @return 成功返回true，否则返回false
     */
    public static boolean uploadFile(String ftpHost, String ftpUserName,
                                     String ftpPassword, int ftpPort, String ftpPath,
                                     String fileName,InputStream input,String yearAndMonth) {
        boolean success = false;
        FTPClient ftpClient = null;
        try {
            int reply;
            ftpClient = getFTPClient(ftpHost, ftpUserName, ftpPassword, ftpPort);
            reply = ftpClient.getReplyCode();
            if (!FTPReply.isPositiveCompletion(reply)) {
                ftpClient.disconnect();
                return success;
            }
 
            ftpClient.setControlEncoding("UTF-8"); // 中文支持
            ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
            ftpClient.enterLocalPassiveMode();
            ftpClient.changeWorkingDirectory(ftpPath);
            String dirName = yearAndMonth;
            //向服务器上查询文件是否存在，若不存在则创建文件
            ftpClient.makeDirectory(dirName);
            //切换到创建的文件夹下
            ftpClient.changeWorkingDirectory(dirName);
            //在ftp服务器上新建一个叫fileName发文件,并将input输入流中的内容写入fileName
            ftpClient.storeFile(fileName, input);
            input.close();
            ftpClient.logout();
            success = true;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (ftpClient.isConnected()) {
                try {
                    ftpClient.disconnect();
                } catch (IOException ioe) {
                }
            }
        }
        return success;
    }
    
    //将位置为srcFilePath的文件夹移动到destFilePath处,若目标处文件存在会自动覆盖
    /**
     * 
     * @param ftpHost		主机地址
     * @param ftpUserName	用户名
     * @param ftpPassword	密码
     * @param ftpPort		端口
     * @param ftpPath		ftp服务器上的工作路径
     * @param downloadPath	存放导入成功后的文文件的文件路径
     * @param yearMonth		文件夹名称
     * @param srcFileName	工作路径下的文件名称
     * @return
     */
  	public static boolean moveFiles(
  			String ftpHost, String ftpUserName,
            String ftpPassword, int ftpPort, String ftpPath,String downloadPath,String yearMonth,
            String srcFileName){
        boolean isSuccess = false;
  		FTPClient ftpClient = null;
        try{
        	ftpClient = getFTPClient(ftpHost, ftpUserName, ftpPassword, ftpPort);
            if(ftpClient == null){
            	//ftp连接不上返回false
            	System.out.println("FTP连接失败！");
            }else{ 
            	ftpClient.enterLocalPassiveMode();
            	//先去创建存放需要移动文件的文件
            	//String curRoot = ftpClient.printWorkingDirectory();
            	ftpClient.changeWorkingDirectory(downloadPath);
            	String s1 = ftpClient.printWorkingDirectory();
            	boolean d = ftpClient.makeDirectory(yearMonth);
            	String s = ftpClient.printWorkingDirectory();
            	ftpClient.changeWorkingDirectory("../");
            	String s2 = ftpClient.printWorkingDirectory();
            	ftpClient.changeWorkingDirectory(yearMonth+"/");
            	//移动文件到另一个路径,下面使用的是相对路径
            	String s3 = ftpClient.printWorkingDirectory();
            	isSuccess = ftpClient.rename(srcFileName, "../download/"+yearMonth+"/"+srcFileName);
            	//移出原文件
            	//ftpClient.deleteFile(srcFilePath);
            }
        }catch(Exception e){
        	e.printStackTrace();
        }finally {
            if (ftpClient.isConnected()) {
                try {
                    ftpClient.disconnect();
                } catch (IOException ioe) {
                }
            }
        }
  		return isSuccess;
  	}
  	
  	public static boolean judgeFileExist(
  			String ftpHost, String ftpUserName,
            String ftpPassword, int ftpPort, String ftpPath,String yearMonth,String yearMonthDay){
  		String zipFileName = "app_"+yearMonthDay+".zip";
  		FTPClient ftpClient = null;
  		InputStream is = null;
        try{
        	ftpClient = getFTPClient(ftpHost, ftpUserName, ftpPassword, ftpPort);
            if(ftpClient == null){
            	//ftp连接不上返回false
            	System.out.println("FTP连接失败！");
            	return false;
            }else{
            	ftpClient.enterLocalPassiveMode();
            	ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
            	ftpClient.setControlEncoding("UTF-8");
            	ftpClient.changeWorkingDirectory(ftpPath+yearMonth+"/");
            	is = ftpClient.retrieveFileStream(zipFileName);
            	if(is == null || ftpClient.getReplyCode() == FTPReply.FILE_UNAVAILABLE){
            		return false;
            	}else{
            		return true;
            	}
            }
        }catch(Exception e){
        	e.printStackTrace();
        }finally {
        	//关闭流
        	if(is != null){
        		try {
					is.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        	}
            if (ftpClient != null && ftpClient.isConnected()) {
                try {
                    ftpClient.disconnect();
                } catch (IOException ioe) {
                }
            }
        }
  		return false;
  	}
    
    
    public static void main(String args[]){
    	//FtpUtil.downloadFtpFile("111.231.250.43", "lcl", "123", 21, "appdata/service/"+"201708/", "F:/", "20170802.zip");
//    	boolean flag = FtpUtil.moveFiles("111.231.250.43", "lcl", "123", 21,"appdata/service/","appdata/service/download/","201708", "app_20170802.zip");
    	FtpUtil.getFTPClient("218.75.147.36", "root", "dnkty2009", 22);
    	
    }
}
