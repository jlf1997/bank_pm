<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
<h2>Hello World!</h2>
<body>
    <!-- ship是我的项目名-->
    <!--  
    <form id="loginform_id">
        登录名:<input type="text" name="username"/><br/>
        密码 : <input type="text" name="password"/><br/>
        <input type="button" id="login_btn_id" value="登录"/>
    </form>-->
    
    <form method="post" action="websocket/login">
        登录名:<input type="text" name="username"/><br/>
        密码 : <input type="text" name="password"/><br/>
        <input type="submit" id="login_btn_id" value="登录"/>
    </form>    
    <!--  
	<script src="http://cdn.static.runoob.com/libs/jquery/1.10.2/jquery.min.js">
	</script>
	<script type="text/javascript">  
	$(function() { 
		$('#login_btn_id').click(function(){
			$.ajax({ url: "websocket/login",
                type: "post", 
                dataType:"json",
                data: $("#loginform_id").serializeArray(),
				 success: function(msg) 
				 { 
					 <%--
					 alert("获取数据:"+msg.sessionID);--%>
					 alert("获取数据:"+JSON.stringify(msg));
				 } 
			}); 			
		});
	});
	
	</script>-->
</body>
</body>
</html>