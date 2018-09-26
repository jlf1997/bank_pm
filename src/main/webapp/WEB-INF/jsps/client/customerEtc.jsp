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
    
    <title>ETC客户</title>
    
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
	  	<div class="panel-heading">ETC</div>
	  	<div class="panel panel-body">
	  		<table class="table table-bordered table-striped table-hover table-condensed" style="margin:1% auto;width:96%;">
				<tr>
					<td>开户机构</td>
					<td>绑定日期</td>
					<td>营销类型</td>
					<td>拓展人</td>
					<td>拓展比例</td>
					<td>安装人</td>
					<td>安装比例</td>
					<td>湘通卡卡号</td>
					<td>垫付金额</td>
				</tr>
				<c:forEach items="${list}" var="item">
				<tr>
					<td>${item.zzjc}</td>
					<td>${item.rq}</td>
					<td>
						<c:choose>
							<c:when test="${item.yxlx eq 1}">主动营销</c:when>
							<c:when test="${item.yxlx eq 2}">自然增长</c:when>
						</c:choose>
					</td>
					<td>${item.tzr}</td>
					<td>${item.tzbl}</td>
					<td>${item.azr}</td>
					<td>${item.azbl}</td>
					<td>${item.xtkkh}</td>
					<td align="right">${item.dfje}</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
  </body>
</html>
