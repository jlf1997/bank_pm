<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title></title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" type="text/css"
	href="bootstrap-3.3.7-dist/css/bootstrap.css" media="screen" />
<link rel="stylesheet" type="text/css"
	href="css/bootstrap-datetimepicker.min.css" media="screen" />
</head>
<body>
	<div class="form-inline" style="width:60%;text-align:center;margin:1% auto;">
		<label class="label label-default">工资日期</label>
		<label class="form-control">${one.gzrq}</label>
		<label class="label label-default">组织名称</label>
		<label class="form-control">${one.zzjc}</label>
	</div>
	<table class="table table-bordered table-striped table-hover table-condensed" style="margin:1% auto;width:98%;">
		<tr>
			<td>岗位名称</td>
			<td>员工姓名</td>
			<td>指标标识</td>
			<td>指标名称</td>
			<td>指标结果</td>
			<td>指标单价</td>
			<td>指标工资</td>
		</tr>
		<tr>
			<td>${one.gwmc}</td>
			<td>${one.ygxm}</td>
			<td>${one.zbid}</td>
			<td>${one.zbmc}</td>
			<td>${one.zbjg}</td>
			<td>${one.zbdj}</td>
			<td align="right">${one.zbgz}</td>
		</tr>
	</table>
</body>
<script type="text/javascript" src="js/jquery-3.2.1.min.js"
	charset="UTF-8"></script>
<script type="text/javascript"
	src="bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
</html>
