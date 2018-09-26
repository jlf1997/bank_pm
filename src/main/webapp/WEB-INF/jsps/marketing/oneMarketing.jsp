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
    
    <title>营销详情</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="bootstrap-3.3.7-dist/css/bootstrap.css" media="screen" /> 
	<link rel="stylesheet" type="text/css" href="css/bootstrap-datetimepicker.min.css" media="screen" />
  </head> 
  <body>
  <center>
  <label>
  <h4>
	  <c:choose>
	  	<c:when test="${type eq 'ck'}">存款营销</c:when>
	 	<c:when test="${type eq 'etc'}">ETC营销</c:when>
		<c:when test="${type eq 'cellbank'}">手机银行营销</c:when>
	  	<c:when test="${type eq 'pos'}">POS营销</c:when>
	  </c:choose>
  </h4>
  </label>
  <label id="subInfo" style="color:red;margin-left:2%;">提示信息</label>
 <form action="" method="post" id="form1">
   <table border="1" class="table table-bordered table-condensed" style="width:70%;" align="center">
			<tr>
	    		<td>预约编号</td><td><input class="form-control" name="yybh" type="text" value="${one.yybh}" readonly/></td>
	    	</tr>
			<tr>
	    		<td>营销人工号</td><td><input class="form-control" name="yggh" type="text" value="${one.yggh}" readonly/></td>
	    	</tr>
	    	<tr>
	    		<td>预约日期</td><td><input name="yyrq" class="form-control" type="text" readonly value="${one.yyrq}"/></td>
	    	</tr>
	    	<tr>
	    		<td>机构名称</td>
	    		<td>
	    		<select name="jgdm" size="1" class="form-control">
	    			<c:forEach items="${simOrgList}" var="item">
	    				<option value="${item.ywjgdm}" 
	    				<c:if test="${item.ywjgdm eq depositMarketing.jgdm}">selected</c:if> >${item.zzjc}</option>
	    			</c:forEach>
	    		</select>
	    		</td>
	    	</tr>
	    	<tr>
	    		<td>客户名称</td><td><input name="khmc" id="khmc" type="text" value="${one.khmc}" class="form-control"/></td>
	    	</tr>
	    	<c:if test="${type eq 'ck'}">
	    		<tr>
	    		<td>存款种类</td>
	    		<td>
	    			<label class="label label-primary">
            		<input type="radio" name="ckzl" value="2" 
            		<c:if test="${one.ckzl eq 2}">checked</c:if> />定期
        			</label>
        			<label class="label label-primary" style="margin-left:3%;">
            		<input type="radio" name="ckzl" value="1"
            		<c:if test="${one.ckzl eq 1}">checked</c:if> />活期
        			</label>
	    		</td>
	    	</tr>
	    	<tr>
	    		<td>客户种类</td>
	    		<td>
	    			<label class="label label-primary">
            		<input type="radio" name="khzl" value="1" 
            		<c:if test="${one.khzl eq 1}">checked</c:if>/>个人
        			</label>
        			<label class="label label-primary"style="margin-left:3%;">
            		<input type="radio" name="khzl" value="2"
            		<c:if test="${one.khzl eq 2}">checked</c:if>/>企业
        			</label>
	    		</td>
	    	</tr>
	    	</c:if>
	    	<tr>
	    		<td>证件号码</td><td><input name="zjhm" id="zjhm" type="text" value="${one.zjhm}" class="form-control"/></td>
	    	</tr>
	    	<tr>
	    		<td>手机号码</td><td><input name="sjhm" id="sjhm" type="text" value="${one.sjhm}" class="form-control"/></td>
	    	</tr>
	    	<tr>
	    		<td>营销比例</td><td><input name="yxbl" id="yxbl" type="text" value="${one.yxbl}" class="form-control"/></td>
	    	</tr>
	    	<c:if test="${type eq 'pos'}">
	    		<tr>
	    		<td>客户存款账号</td><td><input name="khckzh" id="khckzh" type="text" value="${one.khckzh}" class="form-control"/></td>
	    	</tr>
	    	</c:if>
	    	<tr>
	    		<td><a href="javascript:history.back(-1);" class="btn btn-info">返回</a></td><td><input type="button" id="modify" value="修改" class="btn btn-primary form-control"/></td>
	    	</tr>
	    </table>
    </form>
    </center>
  </body>
 <script type="text/javascript" src="js/jquery-3.2.1.min.js" charset="UTF-8"></script>
<script type="text/javascript" src="bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/bootstrap-datetimepicker.js" charset="UTF-8"></script>
<script type="text/javascript" src="js/bootstrap-datetimepicker.fr.js" charset="UTF-8"></script>
<script type="text/javascript" src="js/bootstrap-datetimepicker.zh-CN.js" charset="UTF-8"></script>
<script type="text/javascript">
	$(function(){
		if('${type}' == 'etc'){
			$("#form1").attr("action",'${pageContext.request.contextPath}/updateEtcMarketing.action');
		}else if('${type}' == 'ck'){
			$("#form1").attr("action",'${pageContext.request.contextPath}/updateDepositMarketing.action');
		}else if('${type}' == 'cellbank'){
			$("#form1").attr("action",'${pageContext.request.contextPath}/updateCellBankMarketing.action');
		}else{//pos
			$("#form1").attr("action",'${pageContext.request.contextPath}/updatePosMarketing.action');
		}	
		$("#modify").click(function(){
			var khmc = /^[\u4e00-\u9fa5]{1,30}|[a-zA-Z0-9\s]{1,30}/;
			if(!khmc.test($.trim($("#khmc").val()))){
				$("#subInfo").text("客户名称非法!");
				return;
			}
			var zjhm = /(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/;
			if(!zjhm.test($.trim($("#zjhm").val()))){
				$("#subInfo").text("身份证号码错误!");
				return;
			}
			var sjhm = /^(((13[0-9]{1})|(15[0-9]{1})|(18[0-9]{1}))+\d{8})$/;
			if(!sjhm.test($.trim($("#sjhm").val()))){
				$("#subInfo").text("手机号码格式错误!");
				return;
			}
			var yxbl = $.trim($("#yxbl").val());
		 	var number = /^[0-9]+.?[0-9]*$/;
			if(!number.test(yxbl)){
				$("#subInfo").text("输入的比例不合法!");
				return;
			}
			var v = parseFloat(yxbl);
			if(isNaN(v)){
				$("#subInfo").text("请输入数字!");
				return;
			}
			if(v < 0 || v > 100){
				$("#subInfo").text("比例在0到100!");
				return;
			}
			if('${type}' == 'pos'){
				var khckzh = $.trim($("#khckzh").val());
				if(khckzh.length == 0){
					$("#subInfo").text("客户存款账号不能为空");
					return;
				}
			}
			$('#form1').submit();
		});
	});时
</script>
</html>


