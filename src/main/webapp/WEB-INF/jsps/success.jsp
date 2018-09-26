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
    
    <title>成功页面</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="bootstrap-3.3.7-dist/css/bootstrap.css" /> 
	<script type="text/javascript" src="js/jquery-3.2.1.min.js" charset="UTF-8"></script>
	<script type="text/javascript" src="bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
  </head>
  
  <body style="overflow-y:hidden">
  <div class="panel panel-default" style="width:80%;margin:2% auto;">
  	<div class="panel-heading">数据导入结果</div>
  	<div class="panel panel-body" style="overflow:scroll;overflow-x:hidden;height:70%;">
  		<div>
  			<p class ="text-primary">共有:${fileCount}个txt文件!</p>
	  	</div>
	  	<div>
	  		<c:if test="${message != null}">
		  		<c:forEach items = "${message}" var="item" varStatus="status">
		  		<c:choose>
		  			<c:when test="${status.index mod 2 == 0}">
		  				<label style="width:40%;">${item}</label>
		  			</c:when>
		  			<c:otherwise>
		  				<label style="width:40%;">${item}</label><br>
		  			</c:otherwise>
		  		</c:choose>
		  		</c:forEach>
	  		</c:if>
	  	</div>
  	</div>
  	<div class="panel panel-footer">
  		<c:if test="${importCount != null }">
		 <label>成功导入了 <font class="text-primary"> ${importCount}</font> 张表记录! </label>
		</c:if>
		<c:if test="${deleteCount != null }">
			<label>成功删除了 <font class="text-primary"> ${deleteCount}</font> 张表记录!</label><br>
		</c:if>
		<c:if test="${importCount eq fileCount }">
			<label>导入成功！</label>
		</c:if>
		<c:if test="${importCount ne fileCount }">
			<label>导入有错，请重新尝试</label>
		</c:if>
  	</div>
  </div>
  </body>
</html>
