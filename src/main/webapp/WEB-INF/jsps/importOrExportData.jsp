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
    
    <title>数据导入导出</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="bootstrap-3.3.7-dist/css/bootstrap.css" />
	<link rel="stylesheet" type="text/css" href="css/bootstrap-datetimepicker.min.css" media="screen" /> 
  </head>
  
  <body style="overflow:-Scroll;overflow-x:hidden">
  	<div class="panel panel-default" style="width:70%;margin:3% auto;">
	  	<div class="panel-heading">数据导入（所有）</div>
	  	<div class="panel panel-body">
	  	<form action="${pageContext.request.contextPath}/dataImport.action" method="post" id="importForm"
	    	enctype="multipart/form-data" class="form-inline" role="form">
	    	<div class="row">
	    	<label class="text-success">请选择zip文件:</label>
	    	<input type="file" name="file" id="file" value="" style="width:20%" class="form-control"/>
	    	<input type="button" id="import" value="提交" class="btn btn-primary"/>
	    	<label id="info"></label>
    		</div>
    	</form>
	  	</div>
  	</div>

  	<div class="panel panel-default" style="width:70%;margin:0 auto;">
	  	<div class="panel-heading">数据导出</div>
	  	<div class="panel panel-body">
	  		<form action="${pageContext.request.contextPath}/dataExport.action" method="post">
    		<input type="submit" value="导出数据" class="btn btn-primary" style="width:10%"/>
    	</form>
	  	</div>
	</div>
  </body>
  <script type="text/javascript" src="js/jquery-3.2.1.min.js" charset="UTF-8"></script>
  <script type="text/javascript">
  		$("#import").click(function(){
  			var file = document.getElementById("file").value;
			if(file.length == 0){
				$("#info").text("请选择文件");
				return;
			}
			var str = "(.zip)$";
			var reg = new RegExp(str);
			if(!reg.test(file)){
				$("#info").text("请选择zip文件");
				return;
			}
  			$("#import").attr("disabled","true"); //设置变灰按钮  
    		$("#importForm").submit();			//提交表单  
    		$("#info").text("正在导入... 这可能需要点时间,不要重复点击哦!");	
    		setTimeout(function(){
    			$("#import").removeAttr("disabled");
    			$("#info").text("");
    		},100000);   //设置100秒后才刷新，低于这个时间已经跳转页面了，所以也无所谓了！
  		});
  </script>

  <script type="text/javascript" src="bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
  	<script type="text/javascript" src="js/bootstrap-datetimepicker.js" charset="UTF-8"></script>
	<script type="text/javascript" src="js/bootstrap-datetimepicker.fr.js" charset="UTF-8"></script>
	<script type="text/javascript" src="js/bootstrap-datetimepicker.zh-CN.js" charset="UTF-8"></script>
	<script type="text/javascript">
	$('.form_date').datetimepicker({
		format:'yyyy-mm-dd',
        language: 'zh-CN',
        weekStart: 1,
        todayBtn:  1,
		autoclose: 1,
		todayHighlight: 1,
		startView:2,
		minView: 2,
		maxView: 2,
		forceParse: 0
    });
</script> 
</html>
