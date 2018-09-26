<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>贡献率</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="bootstrap-3.3.7-dist/css/bootstrap.css" media="screen" /> 
	<link rel="stylesheet" type="text/css" href="css/bootstrap-datetimepicker.min.css" media="screen" /> 	
  </head>
<body >
	<div class="form-inline form" style="margin-top:1%;text-align:center">
		<label class="label label-default">工资月份:</label> <input type="text" class="form-control" readonly value="${gzyf}"/>
		<label class="label label-default">组织部门:</label> <input type="text" class="form-control" readonly value="${zzjc}"/>
		<label class="label label-default">岗位名称:</label> <input type="text" class="form-control" readonly value="${gwmc}"/>
		<label class="label label-default">工资合计:</label> <input type="text" class="form-control" readonly value="${hj}"/>
	</div>
	<table class="table table-bordered table-striped table-hover" style="margin:1% auto;width:90%;">
		<tr>
			<td>指标名称</td>
			<td>指标任务</td>
			<td>指标结果</td>
			<td>指标贡献率</td>
			<td>指标工资</td>
		</tr>
		<c:forEach items="${list}" var="item">
			<tr>
				<td>${item.zbmc}</td>
				<td>${item.zbrw}</td>
				<td>${item.zbjg}</td>
				<td>${item.zbgxl}</td>
				<td align="right">${item.zbgz}</td>
			</tr>
		</c:forEach>
	</table>
</body>
 <script type="text/javascript" src="js/jquery-3.2.1.min.js" charset="UTF-8"></script>
<script type="text/javascript" src="bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
</html>
