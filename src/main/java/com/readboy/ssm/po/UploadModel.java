package com.readboy.ssm.po;

import java.io.Serializable;

public class UploadModel implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer apkId;			
	private String apkName;
	private String apkUrl;
	private String apkUploader;
	private String apkVersion;
	private String apkUploadTime;
	private String apkPackageName;
	private Integer apkForceUpdateFlag;
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Integer getApkId() {
		return apkId;
	}

	public String getApkName() {
		return apkName;
	}

	public String getApkUrl() {
		return apkUrl;
	}

	public String getApkUploader() {
		return apkUploader;
	}

	public String getApkVersion() {
		return apkVersion;
	}

	public String getApkUploadTime() {
		return apkUploadTime;
	}

	public String getApkPackageName() {
		return apkPackageName;
	}

	public Integer getApkForceUpdateFlag() {
		return apkForceUpdateFlag;
	}

	public void setApkId(Integer apkId) {
		this.apkId = apkId;
	}

	public void setApkName(String apkName) {
		this.apkName = apkName;
	}

	public void setApkUrl(String apkUrl) {
		this.apkUrl = apkUrl;
	}

	public void setApkUploader(String apkUploader) {
		this.apkUploader = apkUploader;
	}

	public void setApkVersion(String apkVersion) {
		this.apkVersion = apkVersion;
	}

	public void setApkUploadTime(String apkUploadTime) {
		this.apkUploadTime = apkUploadTime;
	}

	public void setApkPackageName(String apkPackageName) {
		this.apkPackageName = apkPackageName;
	}

	public void setApkForceUpdateFlag(Integer apkForceUpdateFlag) {
		this.apkForceUpdateFlag = apkForceUpdateFlag;
	}

	@Override
	public String toString() {
		return "UploadModel [apkid=" + apkId + ", apkname=" + apkName +",apkurl="+apkUrl 
				+",apkuploader="+apkUploader +",apkversion="+apkVersion +","
			    + "apkuploadtime="+apkUploadTime +",apkpackagename="+apkPackageName
			    +",apkforceupdateflag="+apkForceUpdateFlag+ "]";
	}	
}
