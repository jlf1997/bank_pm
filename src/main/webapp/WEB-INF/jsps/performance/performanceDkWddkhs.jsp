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

<title>贷款客户包收</title>

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
	<table
		class="table table-bordered table-striped table-hover table-condensed" style="width:98%;margin:1% auto;">
		<tr>
			<td>机构名称</td>
			<td>贷款户数</td>
			<td>单价</td>
			<td>工资</td>
		</tr>
		<tr>
			<td>${one.zzjc}</td>
			<td>${one.hs}</td>
			<td>${one.dj}</td>
			<td align="right">${one.gz}</td>
		</tr>
	</table>
</body>
<script type="text/javascript" src="js/jquery-3.2.1.min.js"
	charset="UTF-8"></script>
<script type="text/javascript"
	src="bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
</html>
