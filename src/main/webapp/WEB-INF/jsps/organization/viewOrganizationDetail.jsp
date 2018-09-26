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
    
    <title>组织信息详情</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head> 
  <body>
  <center>
 	<h1>组织详情</h1>
    <table border="1">
    	<tr>
    		<td>组织标志</td><td>${organization.zzbz}</td>
    	</tr>
    	<tr>
    		<td>组织名称</td><td>${organization.zzmc}</td>
    	</tr>
    	<tr>
    		<td>组织类别</td><td>${organization.zzlb}</td>
    	</tr>
    	<tr>
    		<td>组织级别</td><td>${organization.zzjb}</td>
    	</tr>
    	<tr>
    		<td>启用标志</td><td>${organization.qybz}</td>
    	</tr>
    	<tr>
    		<td>上级组织标志</td><td>${organization.sjzzbz}</td>
    	</tr>
    	<tr>
    		<td>组织组织简称</td><td>${organization.zzjc}</td>
    	</tr>
    	<tr>
    		<td>业务机构代码</td><td>${organization.ywjgdm}</td>
    	</tr>
    	<tr>
    		<td>报表权限机构代码</td><td>${organization.bbqxjgdm}</td>
    	</tr>
    	<tr>
    		<td>业务机构类型</td><td>${organization.ywjglx}</td>
    	</tr>
    	<tr>
    		<td>业务机构性质</td><td>${organization.ywjgxz}</td>
    	</tr>
    	<tr>
    		<td>业务机构标识</td><td>${organization.ywjgbz}</td>
    	</tr>
    	<tr>
    		<td>排序序号</td><td>${organization.pxxh}</td>
    	</tr>
    	<tr>
    		<td>所在区域</td><td>${organization.szqy}</td>
    	</tr>	
    </table>
    </center>
  </body>
</html>


