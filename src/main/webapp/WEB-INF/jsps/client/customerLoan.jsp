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
    
    <title>贷款客户ge</title>
    
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
    <div class="panel panel-default" style="width:96%;margin:1% auto;">
	  	<div class="panel-heading">贷款</div>
	  	<div class="panel panel-body">
	  		<table class="table table-bordered table-striped table-hover table-condensed" style="margin:1% auto;width:96%;">
				<tr>
					<td>合同号</td>
					<td>产品名称</td>
					<td>开户机构</td>
					<td>五级分类</td>
					<td>发放日期</td>
					<td>到期日期</td>
					<td>利率</td>
					<td>客户经理</td>
					<td>贷款余额</td>
					<td>贷款金额</td>
				</tr>
				<c:forEach items="${list}" var="item">
					<tr>
					<td>${item.hth}</td>
					<td>${item.loanCustomerProduct.cpmc}</td>
					<td>${item.loanCustomerProduct.zzjc}</td>
					<td>
						<c:choose>
							<c:when test="${item.loanCustomerProduct.five_class_type eq 1}">正常</c:when>
							<c:when test="${item.loanCustomerProduct.five_class_type eq 2}">关注</c:when>
							<c:when test="${item.loanCustomerProduct.five_class_type eq 3}">次级</c:when>
							<c:when test="${item.loanCustomerProduct.five_class_type eq 4}">可疑</c:when>
							<c:when test="${item.loanCustomerProduct.five_class_type eq 5}">损失</c:when>  
							<c:otherwise>真奇怪</c:otherwise>
						</c:choose>
					</td>
					<td>${item.loanCustomerProduct.ffrq}</td>	
					<td>${item.loanCustomerProduct.dqrq}</td>
					<td>${item.loanCustomerProduct.ll}</td>
					<td>${item.loanCustomerProduct.khjlmc}</td>
					<td align="right">${item.loanCustomerProduct.dkye}</td>
					<td align="right">${item.loanCustomerProduct.dkje}</td>
					</tr>	
			</table>
 			
			<table class="table table-bordered table-striped table-hover table-condensed" style="margin:1% auto;width:96%;">
				<tr>
					<td>管护类型</td>
					<td>管户人姓名</td>
					<td>管户人比例</td>
					<td>开始时间</td>
					<td>结束时间</td>
				</tr>
				<c:forEach items="${item.loanCustomerPerson}" var="item1">
				<tr>
					<td>
					<c:choose>
						<c:when test="${item1.ghlx eq 1}">拓展</c:when>
						<c:when test="${item1.ghlx eq 2}">管户</c:when>
						<c:when test="${item1.ghlx eq 3}">包收</c:when>
						<c:when test="${item1.ghlx eq 4}">审批</c:when>
						<c:when test="${item1.ghlx eq 5}">调差</c:when>
						<c:when test="${item1.ghlx eq 6}">安装</c:when>
						<c:otherwise>未知</c:otherwise>
					</c:choose>
					</td>
					<td>${item1.ygxm}</td>
					<td>${item1.ghbl}</td>
					<td>${item1.ksrq}</td>
					<td>${item1.jsrq}</td>
				</tr>
				</c:forEach>
			</table>
		</c:forEach>
		</div>
	</div>
  </body>
</html>
