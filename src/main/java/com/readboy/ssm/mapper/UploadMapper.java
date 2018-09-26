package com.readboy.ssm.mapper;

import java.util.List;

import com.readboy.ssm.po.UploadModel;



public interface UploadMapper {
	public UploadModel selectAllUploadModel();

	public void insertUploadModel(UploadModel uploadModel);

	public void updateUploadModel(UploadModel uploadModel);

	public void deleteUploadModel(int uploadModelId);
	
	public UploadModel selectUploadModelById(int uploadModelId);
	
	public UploadModel selectUploadModelByPkg (String pkg);
	
}
