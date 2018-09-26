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
    
    <title>手机银行客户</title>
    
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
	  	<div class="panel-heading">手机银行</div>
	  	<div class="panel panel-body">
	  		<table class="table table-bordered table-striped table-hover table-condensed" style="margin:1% auto;width:96%;">
				<tr>
					<td>开户机构</td>
					<td>开户日期</td>
					<td>营销类型</td>
					<td>注销日期</td>
					<td>贴片日期</td>
					<td>拓展人</td>
					<td>拓展比例</td>
				</tr>
				<c:forEach items="${one.cellBankCustomerProducts}" var="item">
					<tr>
					<td>${item.zzjc}</td>
					<td>${item.khrq}</td>
					<td>
						<c:choose>
							<c:when test="${item.yxlx eq 1}">主动营销</c:when>
							<c:when test="${item.yxlx eq 2}">自然增长</c:when>
							<c:otherwise>真奇怪</c:otherwise>
						</c:choose>
					</td>
					<td>${item.zxrq}</td>
					<td>${item.tprq}</td>
					
					<td>${item.tzr}</td>
					<td>${item.tzbl}</td>
					</tr>
				</c:forEach>
			</table>
			<table class="table table-bordered table-striped table-hover table-condensed" style="margin:1% auto;width:96%;">
				<tr>
					<td>管户人姓名</td>
					<td>管户人比例</td>
					<td>开始时间</td>
					<td>结束时间</td>
				</tr>
				<c:forEach items="${one.cellBankCustomerPersons}" var="item">
				<tr>
					<td>${item.ygxm}</td>
					<td>${item.ghbl}</td>
					<td>${item.ksrq}</td>
					<td>${item.jsrq}</td>
				</tr>
				</c:forEach>
			</table>
		</div>
	</div>
  </body>
</html>
