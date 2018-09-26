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
    <title>客户照片与视频</title>
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
  	<div class="panel panel-default" style="width:96%;margin:1% auto;">
	  	<div class="panel-heading">图片</div>
	  	<div class="panel panel-body">
		  	<c:forEach items="${list}" var="item">
				<c:if test="${item.file_type eq 'image'}">
				<div class="col-md-2">
		        	<a href="${pageContext.request.contextPath}/findOneCustomerPicAndVedio.action?khbh=${item.khbh}&ghrgh=${item.ghrgh}&file_name=${item.file_name}&file_type=${item.file_type}" class="thumbnail">
		           		<img src="/res/${item.ghrgh}/${item.khbh}/${item.file_type}/${item.file_name}" alt="图片不存在" style="height:20%;"/>
		       	 	</a>
		       	 	<div class="caption" style="text-align:center">${item.upload_time }</div>
		    	</div>
				</c:if>
		</c:forEach>
	  	</div>
	  </div>
	<div class="panel panel-default" style="width:96%;margin:1% auto;">
	  	<div class="panel-heading">视频</div>
	  	<div class="panel panel-body">
	  		<c:forEach items="${list}" var="item">
			<c:if test="${item.file_type  eq 'video'}">
				<div class="col-md-3">
		        <a href="${pageContext.request.contextPath}/findOneCustomerPicAndVedio.action?khbh=${item.khbh}&ghrgh=${item.ghrgh}&file_name=${item.file_name}&file_type=${item.file_type}" class="thumbnail">
		       	 		<img src="image/timg.jpg" />	
		       	 	</a>
		       	 	<div class="caption" style="text-align:center">
		       	 	${item.upload_time}
		       	 	</div>
		    	</div>
			</c:if>
			</c:forEach>
	  	</div>
	</div>
	
  </body>
</html>
