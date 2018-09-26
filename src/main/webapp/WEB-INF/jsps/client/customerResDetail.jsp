<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>客户资源明细</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="bootstrap-3.3.7-dist/css/bootstrap.css" /> 
	<script src="js/jquery-3.2.1.min.js"></script>
	<script src="bootstrap-3.3.7-dist/js/bootstrap.js"> </script>
  </head>
  
  <body>
  	<div class="panel panel-default" style="width:70%;margin:1% auto;">
	  	<div class="panel-heading">详情</div>
	  	<div class="panel panel-body">
		  		<div style="text-align:center;">
			  		<c:if test="${one.file_type eq 'image' }">
			  		<img src="/res/${one.ghrgh}/${one.khbh}/${one.file_type}/${one.file_name}" alt="图片不存在"/>
			  		</c:if>
			  		<c:if test="${one.file_type eq 'video' }">
			  			<embed src="/res/${one.ghrgh}/${one.khbh}/${one.file_type}/${one.file_name}" autostart="false" loop="true" style="width:70%;height:50%;"/>
			  		</c:if>
			  	</div>
		  		<div style="width:80%;margin:1% auto;">
		  			<table class="table table-condensed table-bordered">
		  				<tr>
		  					<td>客户编号</td><td>${one.khbh }</td>
		  				</tr>
		  				<tr>
		  					<td>客户名称</td><td>${one.khmc}</td>
		  				</tr>
		  				<tr>
		  					<td>管户人工号</td><td>${one.ghrgh}</td>
		  				</tr>
		  				<tr>
		  					<td>采集时间</td><td>${one.info_time}</td>
		  				</tr>
		  				<tr>
		  					<td>采集地址</td><td>${one.info_address}</td>
		  				</tr>
		  				<tr>
		  					<td>上传时间</td><td>${one.upload_time}</td>
		  				</tr>
		  			</table>
		  		</div>
		  	</div>
		</div>
	</div>
	
	
  </body>
</html>
