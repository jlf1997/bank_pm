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
    
    <title>出错页面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="bootstrap-3.3.7-dist/css/bootstrap.css" /> 
	<script src="js/jquery-3.2.1.min.js"></script>
	<script src="bootstrap-3.3.7-dist/js/bootstrap.js"> </script>
  </head>
  
  <body align="center">
  	 <c:if test="${allErrors!= null}">
  		<c:forEach items="${allErrors}" var="item">
  			${item.defaultMessage}
  		</c:forEach>
  	</c:if>
   	<div style="width:80%;margin:10% auto;">
   		
   		<c:if test="${message != null}">
  			<font size="12" color="red">${message}</font>
  		</c:if>
  		<br/>
   		<font size="14">(─‿‿─)请确保网络连接正常！</font>
   		<a href="javascript:history.back(-1);">返回</a>
   	</div>
  </body>
</html>
