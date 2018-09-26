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
    
    <title>用户登录</title>
    
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
		<div style="margin:12% auto;width:30%;height:40%;">
		 	<form action="${pageContext.request.contextPath}/pcLogin.action" method="post" id="form">
		 	<label class="text-primary"><font size="4em">银行绩效管理系统</font></label>
			<div class="input-group" style="width:100%;margin-top:1%;">
	            <span class="input-group-addon glyphicon glyphicon-user" style="width:25%;">用户名</span>
	            <input type="text" class="form-control" name="username" />
	        </div>
	        <div class="input-group" style="margin-top:2%;width:100%;"">
	            <span class="input-group-addon glyphicon glyphicon-lock" style="width:25%;">密码</span>
	            <input type="password" class="form-control"  name="password">
	        </div>
	        <div class="input-group" style="margin-top:2%;width:100%;">
	            <input type="submit"  class="form-control btn-primary" value="登录" />
	        </div>
	        <div class="input-group" style="margin-top:2%;width:100%;text-align:center">
	            <label id="tips"><font color="red" >${info}</font></label>
	        </div>
			</form>
		</div>
</body>
<script type="text/javascript">

</script> 
</html>
