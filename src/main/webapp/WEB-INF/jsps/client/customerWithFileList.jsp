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
    
    <title>客户媒体资源列表</title>
    
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
    <form action="${pageContext.request.contextPath}/findDistinctCustomer.action?" method="post" 
	  class="form-inline" role="form" style="margin-top:1%;margin-left:10%;">
		  <div class="form-group">
		  	<label class="label label-default">员工工号:</label>
		  	<input type="text" class="form-control" name="ghrgh" value="${ghrgh}"/>
		  	<input type="text" class="form-control" placeholder="客户编号|客户名称" name="condition" value="${condition}"/>
		  </div>
		  <button type="submit" class="btn btn-primary">查询</button>
	  </form>
	  <table class="table table-bordered table-striped table-hover table-condensed" style="margin:1% auto;width:80%;">
		<tr>
			<td>客户编号</td>
			<td>客户名称</td>
			<td>管户人工号</td>
			<td>操作</td>
		</tr>
		<c:forEach items="${list}" var="item">
			<tr>
				<td>${item.khbh}</td>
				<td>${item.khmc}</td>
				<td>${item.ghrgh}</td>
				<td><a href="${pageContext.request.contextPath}/findCustomerPicAndVedio.action?khbh=${item.khbh}&ghrgh=${item.ghrgh}" class="btn btn-primary" title="查看">媒体资源</a></td>
			</tr>
		</c:forEach>
	</table>
  </body>
</html>
