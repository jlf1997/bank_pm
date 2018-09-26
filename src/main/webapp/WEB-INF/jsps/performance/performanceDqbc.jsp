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
    
    <title>地区补差</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="bootstrap-3.3.7-dist/css/bootstrap.css" media="screen" /> 
	<link rel="stylesheet" type="text/css" href="css/bootstrap-datetimepicker.min.css" media="screen" /> 	
  </head>
  <body >
  <div>
	  <form action="${pageContext.request.contextPath}" method="post" 
	  	class="form-inline" role="form" align="center" style="margin-top:1%;">
		  <div class="form-group">
		  	<label class="label label-default">工资合计:</label> ${hj} 元
		  	<label class="label label-default">工资日期:</label>
		  	<input type="text" class="form-control" readonly value="${tjrq}" name="tjrq"/>
		  </div>
	  </form>
  </div>
  		 <table class="table table-bordered table-striped table-hover">
		   <tr>
		   		<td>组织名称</td>
		   		<td>在岗天数</td>
		   		<td>绩效档次</td>
		   		<td>工资</td>
		   		<td>补贴标准(人/月)</td>
		   </tr>
		   <c:forEach items="${list}" var="item">
		   <tr>
		   		<td>${item.zzjc}</td>
		   		<td>${item.zgts}</td>
		   		<td>
		   			<c:choose>
		   				<c:when test="${item.xydc eq 1}">一档</c:when>
		   				<c:when test="${item.xydc eq 2}">二档</c:when>
		   				<c:when test="${item.xydc eq 3}">三档</c:when>
		   				<c:when test="${item.xydc eq 4}">四档</c:when>
		   				<c:when test="${item.xydc eq 5}">五档</c:when>
		   				<c:otherwise>不知道什么档</c:otherwise>
		   			</c:choose>
		   		</td>
		   		<td  align="right">${item.gz}</td>
		   		<td  align="right">${item.btbz}</td>
		   </tr>
		  </c:forEach>
	</table>
  </body>
 <script type="text/javascript" src="js/jquery-3.2.1.min.js" charset="UTF-8"></script>
<script type="text/javascript" src="bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
</html>
