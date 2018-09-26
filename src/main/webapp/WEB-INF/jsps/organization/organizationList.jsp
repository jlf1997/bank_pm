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
    
    <title>组织信息</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta name="viewport" content="width=device-width,initial-scale=1,
		minimum-scale=1,maximum-scale=1,user-scalable=no">
	<link rel="stylesheet" type="text/css" href="bootstrap-3.3.7-dist/css/bootstrap.css">
	<script src="js/jquery-3.2.1.min.js"> </script>
	<script src="bootstrap-3.3.7-dist/js/bootstrap.js"> </script>
  </head> 
  <body>
  <center>
    <table class="table table-bordered table-striped table-hover">
    	<tr>
    		<td>标志</td>
    		<td>名称</td>
    		<td>类别</td>
    		<td>级别</td>
    		<td>启用标志</td>
    		<td>上级组织标志</td>
    		<td>简称</td>
    		<td>业务机构代码</td>
    		<td>操作</td>
    	</tr>
    	<c:forEach items="${organizationList}" var="item">
    	<tr>
    		<td>${item.zzbz}</td>
    		<td>${item.zzmc}</td>
    		<td>${item.zzlb}</td>
    		<td>${item.zzjb}</td>
    		<td>${item.qybz}</td>
    		<td>${item.sjzzbz}</td>
    		<td>${item.zzjc}</td>
    		<td>${item.ywjgdm}</td>
     		<td><a class="btn btn-info" href="${pageContext.request.contextPath}/viewOrganization.action?zzbz=${item.zzbz}">详情</a>
     		 	<a class="btn btn-primary" href="">编辑</a><a class="btn btn-danger" href="">删除</a>
     		</td>
    	</tr>
    	</c:forEach>  	
    </table>
   </center>	
  </body>
</html>


