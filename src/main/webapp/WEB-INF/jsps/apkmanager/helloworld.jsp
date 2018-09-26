<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>文件上传</title>
</head>
<body>
	<%--<form action="fileUpload" method="post" enctype="multipart/form-data">--%>
	<form action="UploadApkCtr.do" method="post" enctype="multipart/form-data">
		<input type="file" name="fileupload" /> <input type="submit"
			value="上传" />
	</form>

	<form action="QueryApkInfo.do" method="post">
		<label>请输入查询应用包名</label> <input type="text" name="package" /> <input
			type="submit" value="查询" />
	</form>
<%--
	<form action="login" method="post">
		用户名:<input type="text" name="username" /> <br /> 密码:<input
			type="text" name="password" /> <br /> <input type="submit"
			value="登录" />
	</form> --%>

	<form id="myForm">
		用户名:<input type="text" name="username" /> <br /> 密码:<input
			type="text" name="password" /> <br /> <input type="button"
			id="btn_id" value="登录" />
	</form>
	<script src="http://cdn.static.runoob.com/libs/jquery/1.10.2/jquery.min.js">
	</script>
	<script type="text/javascript">
	var sessionID=0;
	$(function() { 
		$('#btn_id').click(function() {
			$.ajax({ url: "login",
	                 type: "post", 
	                 dataType:"json",
	                 data: $("#myForm").serializeArray(),
					 success: function(msg) 
					 { 
						 sessionID = msg.sessionID;
						 <%--
						 alert("获取数据:"+msg.sessionID);--%>
						 alert("获取数据:"+msg.sessionID);
					 } 
				}); 
			}); 
		});
	</script>
	
	<form id="mdForm">
		修改用户名:<input type="text" name="username" /> <br /> 
		<input type="button" id="btn_id_1" value="修改" />
	</form>	
	
	<script type="text/javascript">
	$(function() { 
		$('#btn_id_1').click(function() {
			$.ajax({ url: "modifyUser",
	                 type: "get", 
	                 dataType:"json",
	                 data: $("#mdForm").serializeArray(),
	                 beforeSend: function(request) {
	                        request.setRequestHeader("sessionId", sessionID);
	                 },
					 success: function(msg) 
					 { 
						 <%--
						 alert("获取数据:"+msg.sessionID);
						 将json格式化为字符串--%>
						 alert("获取数据:"+JSON.stringify(msg));
					 } 
				}); 
			}); 
		});
	</script>	
</body>
</html>
