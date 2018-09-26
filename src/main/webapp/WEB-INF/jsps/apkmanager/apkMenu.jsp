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
    
    <title>APK菜单控制</title>
    
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
    <div class="panel panel-default" style="width:70%;margin:3% auto;">
	  	<div class="panel-heading">APK菜单管理</div>
	  	<div class="panel panel-body">
	  	<form action="${pageContext.request.contextPath}/updateMenus.action" method="post" id="form">
	    	<table class="table table-bordered table-condensed">
	    		<tr>
	    			<td>ID</td><td>菜单名</td><td>显示状态</td><td>备注</td>
	    		</tr>
	    		<c:forEach items="${list}" var="item" varStatus="status">
	    			<tr>
	    				<td>${item.id}<input class="myClass" type="text" value="${item.id}" name="menuList[${status.index}].id" readonly hidden/></td>
	    				<td><input type="text" value="${item.name}" disabled class="myClass" name="menuList[${status.index}].name" /></td>
	    				<td>
	    					<select name="menuList[${status.index}].show"  class="form-control myClass" disabled="disabled"> 
	    						<option value="1" <c:if test="${item.show eq 1}">selected</c:if> >显示</option>
	    						<option value="0" <c:if test="${item.show eq 0}">selected</c:if> >不显示</option>
	    					</select>
	    				</td>
	    				<td>${item.comment}</td>
	    			</tr>
	    		</c:forEach>
	    		<tr>
	    			<td colspan="1"></td><td><label id="modify" class="btn btn-primary">编辑关</label></td>
	    			<td><button class="btn btn-info myClass"  disabled="disabled" >提交</button></td>
	    		</tr>
	    	</table>
	    </form>
	  	</div>
  	</div>
  </body>
  <script type="text/javascript">
  	$("#modify").click(function(){
  		if($("#modify").text() == "编辑关"){
  			$(".myClass").removeAttr("disabled");
  			$("#modify").text("编辑开");
  		}else{
  			$(".myClass").attr("disabled","disabled")
  			$("#modify").text("编辑关");
  		}
  	});
  </script>
</html>
