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
    <title>银行绩效管理系统</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta name="viewport" content="width=device-width,initial-scale=1,
	minimum-scale=1,maximum-scale=1,user-scalable=no">
	<link rel="stylesheet" type="text/css" href="bootstrap-3.3.7-dist/css/bootstrap.css" /> 
	<link rel="stylesheet" type="text/css" href="css/text.css" /> 
	<script src="js/jquery-3.2.1.min.js"></script>
	<script src="bootstrap-3.3.7-dist/js/bootstrap.js"> </script> 
	<script type="text/javascript">
		window.onload = clickQuery;
		function clickQuery(){
			document.getElementById("firstlink").click();
		}
	</script>
	<style type="text/css">
		.glyphicon-plus{
			font-size:50px;
			color:red;
		}
		.glyphicon-asterisk{
			font-size:60px;
			color:green;
		}
	</style>
  </head>
  
  <body>
  <!-- 顶部导航 -->
  <div class="class="navbar navbar-fixed-top" role="navigation" style="background-color:#7171C6;">
		<div class="container" style="margin-left:0px;">
				<ul class="nav navbar-nav">
					<li class="active">
					<a href="${pageContext.request.contextPath}/pageSkip.action?jspName=importOrExportData""
					 style="color:white" target="rightFrame" class="glyphicon glyphicon-home" id="firstlink">银行绩效管理系统</a>
					</li>
					<li>
					<c:if test="${user.username != null}">
						<a href="javascript:void(0);" style="color:white" id="modPwd" class="glyphicon glyphicon-user">${user.username}</a>
					</c:if>
					</li>
					<li><a href="${pageContext.request.contextPath}/logout.action" style="color:white" class="glyphicon glyphicon-log-out">退出</a>
					</li>
				</ul>
			<!-- /.nav-header -->
		</div>
		<!-- /.container -->
	</div>
  <!-- 左侧导航窗口 -->
	<div id="left">
  		<ul class="nav nav-pills nav-stacked" style="width:11%;height:88%;float:left">
  			<li><a href="${pageContext.request.contextPath}/findDistinctCustomer.action?ghrgh=${user.tellId}" target="rightFrame" class="glyphicon glyphicon-film">客户拜访</a></li>
	  		<li><a href="" onclick="javascript:return false;" data-toggle="collapse" data-target="#marketing" class="glyphicon glyphicon-book">主动营销申报</a>
	  			<div id="marketing" class="collapse">
					<ul class="list-group">
						<li class="list-group-item li-height"><a href="${pageContext.request.contextPath}/findDepositMarketing.action?yggh=${user.tellId}&currentPage=1&showCount=10" class="li-text"  target="rightFrame">存款营销</a></li>
						<li class="list-group-item li-height"><a href="${pageContext.request.contextPath}/findEtcMarketing.action?yggh=${user.tellId}&currentPage=1&showCount=10" class="li-text" target="rightFrame">ETC营销</a></li>
						<li class="list-group-item li-height"><a href="${pageContext.request.contextPath}/findCellBankMarketing.action?yggh=${user.tellId}&currentPage=1&showCount=10" class="li-text" target="rightFrame">手机银行营销</a></li>
						<li class="list-group-item li-height"><a href="${pageContext.request.contextPath}/findPosMarketing.action?yggh=${user.tellId}&currentPage=1&showCount=10" class="li-text" target="rightFrame">POS机营销</a></li>
					</ul>
				</div>
			</li>
			<li><a href="" onclick="javascript:return false;" data-toggle="collapse" data-target="#client" class="glyphicon glyphicon-folder-open">客户信息管理</a>
	  			<div id="client" class="collapse">
					<ul class="list-group">
						<li class="list-group-item li-height"><a href="${pageContext.request.contextPath}/findCustomer.action?yggh=${user.tellId}&khlx=1&showCount=10&currentPage=1" class="li-text" target="rightFrame">个人客户</a></li>
						<li class="list-group-item li-height"><a href="${pageContext.request.contextPath}/findCustomer.action?yggh=${user.tellId}&khlx=2&currentPage=1&showCount=10" class="li-text" target="rightFrame">对公客户</a></li>
					</ul>
				</div>
			</li>
			<li><a href="" onclick="javascript:return false;" data-toggle="collapse" data-target="#performance" class="glyphicon glyphicon-yen">绩效工资</a>
	  			<div id="performance" class="collapse">
					<ul class="list-group">
						<li class="list-group-item li-height"><a href="${pageContext.request.contextPath}/performanceSkip.action?jspName=performanceYgjxhz" class="li-text" target="rightFrame">员工绩效(按日)</a></li>
						<li class="list-group-item li-height"><a href="${pageContext.request.contextPath}/performanceSkip.action?jspName=performanceMonthHome" class="li-text" target="rightFrame">员工绩效(按月)</a></li>
					</ul>
				</div>
			</li>
	  		<li>
	  			<a href="javascript:return false;" data-toggle="collapse" data-target="#dataLog" class="glyphicon glyphicon-wrench">数据导入导出</a>
	  			<div id="dataLog" class="collapse">
					<ul class="list-group">
						<li class="list-group-item li-height">
							<a href="${pageContext.request.contextPath}/pageSkip.action?jspName=importOrExportData" target="rightFrame" class="li-text" target="rightFrame">手动导入导出</a>
						</li>
						<li class="list-group-item li-height"><a href="${pageContext.request.contextPath}/dataLog.action" class="li-text"  target="rightFrame">数据日志</a></li>
					</ul>
				</div>
	  		</li>
	  		<li><a href="${pageContext.request.contextPath}/messagePush.action" target="rightFrame" class="glyphicon glyphicon-envelope">推送消息</a></li>
	  		<li>
	  			<a href="javascript:return false;" data-toggle="collapse" data-target="#system" class="glyphicon glyphicon-wrench">系统管理</a>
	  			<div id="system" class="collapse">
					<ul class="list-group">
						<li class="list-group-item li-height"><a href="${pageContext.request.contextPath}/findMenus.action" class="li-text"  target="rightFrame">APK菜单管理</a></li>
						<li class="list-group-item li-height"><a href="${pageContext.request.contextPath}/findRes.action" class="li-text"  target="rightFrame">资源路径配置</a></li>
						<li class="list-group-item li-height"><a href="${pageContext.request.contextPath}/findUploadApkInfo.do" class="li-text"  target="rightFrame">APK更新</a></li>
					</ul>
				</div>
	  		</li>
  		</ul>
  	</div>
  	<!-- 右侧主界面 -->
  	<div id="right" style="width:89%;height:88%;float:left;border-left:1px solid #3A5FCD">
  		<iframe src="home.jsp" name="rightFrame"
  		frameborder="0" scrolling="yes" width="100%" height="100%"></iframe>
  	</div>
  	
  	<div id="myPwd" class="panel panel-default" style="width:30%;height:40%;border:1px solid blue;position:absolute;left:35%;top:20%;display:none;" >
    <div class="panel-heading">修改密码  <label style="margin-left:10%;color:red;" id="tips">提示信息</label></div>
    <div class="panel-body" style="text-align:center;">
    	<form action="${pageContext.request.contextPath}/updatePasswordByUserid.action?userid=${user.userid}" method="post" class="form-horizontal" role="form" id="pwdForm">
	    	<div class="form-group">
				<label class="col-sm-3 control-label">用户名:</label>
				<div class="col-sm-9">
					<input type="text" class="form-control" value="${user.username}" readonly name="username"/>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label">新密码:</label>
				<div class="col-sm-9">
					<input type="password" class="form-control" value="" name="pwd1"/>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label">确认密码:</label>
				<div class="col-sm-9">
					<input type="password" class="form-control" value=""  name="pwd2" />
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-6"><label class="btn btn-info" id="close">关闭</label></div>
				<div class="col-sm-6"><label id="sub" class="btn btn-primary">确定</label></div>
			</div>
   	 	</form>
   	 	</div>
    </div>  	
  </body>
  <script type="text/javascript">
  	$("#modPwd").click(function(){
  		$("#myPwd").toggle();
  	});
  	$("#close").click(function(){
  		$("#myPwd").hide();
  	});
  	$("#sub").click(function(){
  		
  		var pwd1 = $("input[name='pwd1']").val();
  		var pwd2 = $("input[name='pwd2']").val();
  		if(pwd1.length < 6 || pwd2.length < 6){
  			$("#tips").text("密码不能少于6位！");
  			return;
  		}
  		if(pwd1 != pwd2){
  			$("#tips").text("两次密码不一致！");
  			return;
  		}
  		$("#pwdForm").submit();
  	});
  </script>
</html>
