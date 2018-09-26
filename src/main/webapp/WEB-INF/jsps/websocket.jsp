<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>消息推送</title>
</head>
<body>
<script type="text/javascript" src="http://cdn.bootcss.com/jquery/3.1.0/jquery.min.js"></script>
<script type="text/javascript" src="http://cdn.bootcss.com/sockjs-client/1.1.1/sockjs.js"></script>

  

<script type="text/javascript">
var username = "<%=request.getSession().getAttribute("SESSION_USERID")%>"
    var websocket = null;
    if ('WebSocket' in window) {
        websocket = new WebSocket("ws://"+'${url}'+"/bank_pm/websocket/socketServer.do");
    }
    else if ('MozWebSocket' in window) {
        websocket = new MozWebSocket("ws://"+'${url}'+"/bank_pm/websocket/socketServer.do");
    } 
    else {
        websocket = new SockJS("http://"+'${url}'+"/bank_pm/sockjs/socketServer.do");
    }
    websocket.onopen = onOpen;  	
    websocket.onmessage = onMessage;
    websocket.onerror = onError;
    websocket.onclose = onClose;
              
    function onOpen(openEvt) {
    	//websocket.send(username);
        //alert(openEvt.Data+username);
    }
    
    function onMessage(evt) {
    }
    function onError() {
    	alert("出错"+"onError");
    }
    function onClose() {
    	alert("关闭"+"onClose");
    }
    
    function doSend() {
        if (websocket.readyState == websocket.OPEN) {          
            var msg = document.getElementById("inputMsg").value.trim();
            var title = document.getElementById("title").value.trim();
            var tips = document.getElementById("tips");
            if(title.length == 0 || title == null){
            	tips.innerText = "请输入标题！";
            	return;
            }
            if(msg.length == 0 || msg == null){
            	tips.innerText = "请输入消息！";
            	return;
            } 
           	var str = title+"|||"+msg;
            websocket.send(str); //调用后台handleTextMessage方法
            alert("发送成功!");
        } else {  
            alert("连接失败!");  
        }  
    }
	window.close=function(){
		websocket.onclose();
	}
</script>
<body>
	<div class="panel panel-default" style="width:70%;margin:5% auto;">
	  	<div class="panel-heading">消息推送 <label style="color:red;margin-left:2%;" id="tips">提示消息</label></div>
	  	<div class="panel panel-body">
	  		<div class="form-inline">
				<label class="text-primary">标题:&nbsp;</label><input type="text" name="title" id="title" size="49" class="form-control"/>
			</div>
			<div class="form-inline" style="margin-top:1%;">
				<label class="text-primary">内容:</label>
				<textarea rows="8" cols="51" id="inputMsg" name="inputMsg" class="form-control"></textarea>
				<button onclick="doSend();" class="form-control">发送</button>
			</div>
	  	</div>
	 </div>
	<br>
	${addr}
</body>
<link rel="stylesheet" type="text/css" href="bootstrap-3.3.7-dist/css/bootstrap.css" /> 
<script src="js/jquery-3.2.1.min.js"></script>
<script src="bootstrap-3.3.7-dist/js/bootstrap.js"> </script>
</html>