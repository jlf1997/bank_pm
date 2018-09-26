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
    
    <title>资源配置</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="bootstrap-3.3.7-dist/css/bootstrap.css" /> 
	<script type="text/javascript" src="js/jquery-3.2.1.min.js" charset="UTF-8"></script>
	<script type="text/javascript" src="bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
  </head>
  
  <body>
  <div class="panel panel-default" style="width:70%;margin:3% auto;">
	  	<div class="panel-heading">路径配置</div>
	  	<div class="panel panel-body">
  		<p class="text-info">${info}</p>
		<form action="${pageContext.request.contextPath}/resConfig.action" method="post"
	    	enctype="multipart/form-data" class="form-inline" role="form">
	    	<div class="form-group">
		 		<label class="label label-primary">请选择资源路径:</label>
		 		<input type="text" name="path" value="${one.path}" class="form-control" size="50"/>
		 		<input type="submit" class="form-control" value="确定"/>
	 		</div>
 		</form>
 		</div>
 		</div>
  </body>
</html>
