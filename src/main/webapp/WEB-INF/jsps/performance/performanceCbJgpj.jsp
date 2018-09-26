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
    
    <title>手机银行机构平均</title>
    
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
	  <form action="${pageContext.request.contextPath}/" method="post" 
	  class="form-inline" role="form" align="center" style="margin-top:1%;">
		  <div class="form-group">
		  	<label class="label label-default">工资合计:</label> ${hj} 元
		  	<label class="label label-default">工资日期:</label>
		  	<input type="text" class="form-control" readonly value="${gzrq}" name="gzrq"/>
		  </div>
		 <%--  <div class="form-group">
		  	<input type="text" class="form-control" placeholder="客户名称|手机号码" name="condition" value="${condition}"/>
		  </div>
		  <button type="submit" class="btn btn-primary">查询</button> --%>
	  </form>
  </div>
  		 <table class="table table-bordered table-striped table-hover table-condensed" style="width:98%;margin:1% auto;">
		   <tr>
		   		<td>组织名称</td>
		   		<td>统计日期</td>
		   		<td>岗位名称</td>
		   		<td>员工姓名</td>
		   		<td>指标标识</td>
		   		<td>指标名称</td>
		   		<td>指标结果</td>
		   		<td>指标单价</td>
		   		<td>指标工资</td>
		   </tr>
		   <c:forEach items="${list}" var="item">
		   <tr>
		   		<td>${item.zzjc}</td>
		   		<td>${item.gzrq}</td>
		   		<td>${item.gwmc}</td>
		   		<td>${item.ygxm}</td>
		   		<td>${item.zbid}</td>
		   		<td>${item.zbmc}</td>
		   		<td>${item.zbjg}</td>
		   		<td align="right">${item.zbdj}</td>
		   		<td align="right">${item.zbgz}</td>
		   </tr>
		  </c:forEach>
	</table>
  </body>
 <script type="text/javascript" src="js/jquery-3.2.1.min.js" charset="UTF-8"></script>
<script type="text/javascript" src="bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
</html>
