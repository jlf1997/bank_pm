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
    
    <title>业务量</title>
    
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
		   		<td>业务机构</td>
		   		<td>业务类型</td>
		   		<td>交易日期</td>
		   		<td>实际笔数</td>
		   		<td>折算笔数</td>
		   		<td>计价</td>
		   </tr>
		   <c:forEach items="${list}" var="item">
		   <tr>
		   		<td>${item.ywjgmc}</td>
		   		<td>${item.ywlx}</td>
		   		<td>${item.tjrq}</td>
		   		<td>${item.jybs}</td>
		   		<td>${item.sjjybs}</td>
		   		<td align="right">
			   		<c:choose>
			   			<c:when test="${type eq 'brjb'}">
			   				${item.ywlgz}
			   			</c:when>
			   			<c:when test="${type eq 'xjll'}">
			   				${item.xjllgz}
			   			</c:when>
			   			<c:otherwise>
			   				未知
			   			</c:otherwise>
			   		</c:choose>
		   		</td>
		   </tr>
		  </c:forEach>
	</table>
  </body>
 <script type="text/javascript" src="js/jquery-3.2.1.min.js" charset="UTF-8"></script>
<script type="text/javascript" src="bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
</html>
