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
    
    <title>APK上传</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="bootstrap-3.3.7-dist/css/bootstrap.css" /> 
	<script type="text/javascript" src="js/jquery-3.2.1.min.js" charset="UTF-8"></script>
	<script type="text/javascript" src="bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
  </head>
<body>
	<div class="panel panel-default" style="width:40%;margin:3% auto;">
		<div class="panel-heading">
			APK更新 <label style="margin-left:3%;"><font color="red" id="tips">提示信息</font></label>
		</div>
		<div class="panel panel-body col-sm-12">
			<form class="form-horizontal" role="form" method="post" id="form"
				enctype="multipart/form-data" action="UploadApkCtr.do">
				<div class="form-group">
					<label for="apkname" class="col-sm-3 control-label">apk名称</label>
					<div class="col-sm-9">
						<input type="text" class="form-control" id="apkname" 
						name="apkname" placeholder="请输入apk名称" value="${one.apkName}" />
					</div>
				</div>
				<div class="form-group">
					<label for="apkuploader" class="col-sm-3 control-label">apk上传者</label>
					<div class="col-sm-9">
						<input type="text" class="form-control" id="apkuploader"
							name="apkuploader" placeholder="请输入apk上传者" value="${one.apkUploader }">
					</div>
				</div>

				<div class="form-group">
					<label for="package" class="col-sm-3 control-label">包名</label>
					<div class="col-sm-9">
						<input type="text" class="form-control" id="package"
							name="package" placeholder="请输入包名" value="${one.apkPackageName}">
					</div>
				</div>
				<div class="form-group">
					<label for="version" class="col-sm-3 control-label">版本号</label>
					<div class="col-sm-9">
						<input type="text" class="form-control" id="version"
							name="version" placeholder="请输入版本号" value="${one.apkVersion}">
					</div>
				</div>
				<div class="form-group">
					<label for="forceflag" class="col-sm-3 control-label">是否强制更新</label>
					<div class="col-sm-9">
						<label class="label label-info col-sm-3"><input type="radio"
							name="forceflag" value="1" 
							<c:if test="${one.apkForceUpdateFlag eq 1}"> checked</c:if> />是</label>
						<label class="label label-info col-sm-3" style="margin-left:3%;"><input type="radio" 
							name="forceflag" value="0" 
							<c:if test="${one.apkForceUpdateFlag eq 0}"> checked</c:if>  />否</label>
					</div>
				</div>
				<div class="form-group">
					<label for="inputfile" class="col-sm-3 control-label">apk文件</label>
					<input type="file" class="col-sm-9 control-label" id="inputfile"
						name="fileupload">
				</div>
				<div class="form-group">
					<div class="col-sm-12 control-label">
						<label  class="btn btn-primary col-sm-12" id="sub">提交</label>
					</div>			
				</div>
				<div class="form-group">
					<div class="col-sm-12 control-label" style="text-align:center">
						<div class="alert alert-warning" id="alert" style="display:none;">
							<a href="#" class="close" data-dismiss="alert">&times;</a>
							<font color="green">${greeting}</font>
						</div>
					</div>			
				</div>
			</form>
		</div>
	</div>
</body>
<script type="text/javascript">

	$("#sub").click(function(){
		var file = $("#inputfile").val();
		var version = $("#version").val();
		if(version.length == 0){
			$("#tips").text("请输入版本号！");
			return;
		}
		if(file.length == 0){
			$("#tips").text("请选择文件！");
			return;
		}	
		$("#form").submit();
	});
 	if('${greeting}' != null && '${greeting}'.length > 0){
		$("#alert").show();
	} 
</script>
</html>