package com.readboy.ssm.po;

/**
 * 客户信息采集，保存的图片视频信息，对应数据库表customer_info_file
 * @author Administrator
 *
 */
public class CustomerInfoFile {
	private String khbh;
	private String khmc;				//客户名称 
	private String ghrgh;
	private String file_name;
	private String file_type;
	private String download_url;
	private String upload_time;
	
	private String info_time; 			//用户信息采集时间
	private String info_address;		//用户信息采集地址
	
	public String getKhmc() {
		return khmc;
	}
	public void setKhmc(String khmc) {
		this.khmc = khmc;
	}
	public String getInfo_time() {
		return info_time;
	}
	public void setInfo_time(String info_time) {
		this.info_time = info_time;
	}
	public String getInfo_address() {
		return info_address;
	}
	public void setInfo_address(String info_address) {
		this.info_address = info_address;
	}
	public String getKhbh() {
		return khbh;
	}
	public void setKhbh(String khbh) {
		this.khbh = khbh;
	}
	public String getGhrgh() {
		return ghrgh;
	}
	public void setGhrgh(String ghrgh) {
		this.ghrgh = ghrgh;
	}
	
	public String getFile_name() {
		return file_name;
	}
	public void setFile_name(String file_name) {
		this.file_name = file_name;
	}
	public String getFile_type() {
		return file_type;
	}
	public void setFile_type(String file_type) {
		this.file_type = file_type;
	}
	public String getDownload_url() {
		return download_url;
	}
	public void setDownload_url(String download_url) {
		this.download_url = download_url;
	}
	public String getUpload_time() {
		return upload_time;
	}
	public void setUpload_time(String upload_time) {
		this.upload_time = upload_time;
	}
	
}
