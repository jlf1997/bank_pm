package com.readboy.ssm.serviceImpl;

import java.io.InputStream;
import java.io.Reader;
import java.net.URI;
import java.net.URL;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;

import com.readboy.ssm.mapper.UploadMapper;
import com.readboy.ssm.po.UploadModel;


public class UploadModelService {
	static Logger logger = Logger.getLogger(UploadModelService.class);
	public static SqlSessionFactory sqlSessionFactory;
	public static Reader reader;
	public static InputStream inputStream = null;

	static {
		URL path=null;
		try {
			reader = Resources.getResourceAsReader("mybatis/configure.xml");
			logger.debug("reader="+reader);;
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static SqlSession getSession() {
		return sqlSessionFactory.openSession();
	}

	public void insertUploadModel(UploadModel uploadModel) {
		SqlSession session = getSession();
		UploadMapper mapper = session.getMapper(UploadMapper.class);

		try {
			mapper.insertUploadModel(uploadModel);
			System.out.println(uploadModel.toString());
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		}
	}

	public void updateUploadModel(UploadModel uploadModel) {
		SqlSession session = getSession();
		UploadMapper mapper = session.getMapper(UploadMapper.class);
		try {
			// List<User> user = mapper.selectAllUser();
			mapper.updateUploadModel(uploadModel);
			System.out.println(uploadModel.toString());
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		}
	}

	public void deleteUploadModel(int uploadModelId) {
		SqlSession session = getSession();
		UploadMapper mapper = session.getMapper(UploadMapper.class);
		try {
			mapper.deleteUploadModel(uploadModelId);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		}
	}

	public static void selectUploadModelById(int uploadModelId) {
		SqlSession session = getSession();
		UploadMapper mapper = session.getMapper(UploadMapper.class);
		try {
			UploadModel uploadModel = mapper.selectUploadModelById(uploadModelId);
			System.out.println(uploadModel.toString());
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		}
	}
	
	public static UploadModel selectUploadModelByPkg(String pkg) {
		SqlSession session = getSession();
		UploadMapper mapper = session.getMapper(UploadMapper.class);
		try {
			UploadModel uploadModel = mapper.selectUploadModelByPkg(pkg);
			if (uploadModel!=null){
				System.out.println(uploadModel.toString());
			}
			session.commit();
			return uploadModel;
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		}
		return null;
	}	

	public UploadModel selectAllUploadModel() {
		SqlSession session = getSession();
		UploadMapper mapper = session.getMapper(UploadMapper.class);
		UploadModel uploadModel = null;
		try {
			uploadModel = mapper.selectAllUploadModel();
			System.out.println(uploadModel.toString());
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		}
		return uploadModel;
	}
}
