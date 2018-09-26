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
    
    <title>绩效按月查询</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="bootstrap-3.3.7-dist/css/bootstrap.css" media="screen" /> 
	<link rel="stylesheet" type="text/css" href="css/bootstrap-datetimepicker.min.css" media="screen" /> 	
  </head>
  <body >
  <div>
	  <form action="${pageContext.request.contextPath}/findByMonthHome.action" method="post" 
	  class="form-inline" role="form" align="center" style="margin-top:1%;">
		 <div class="form-group">
		  <label class="label label-default">员工工号:</label>
		  <input type="text" class="form-control" name="yggh" value="${yggh}"/>
		 </div>
		  <div class="form-group">
		  	<label class="label label-default">工资月份:</label>
		  	<input type="text" class="form_date form-control" value="${gzyf}" name="gzyf" />
		  </div>
		  <button type="submit" class="btn btn-primary">查询</button>
	  </form>
  </div>
  <div class="panel panel-default" style="width:90%;margin:0 auto;">
  	<div class="panel-heading">员工绩效汇总(月)</div>
  	<div class="panel panel-body">
  		 <table class="table table-bordered table-striped table-hover table-condense">
		   <tr>
		   		<td>当月绩效全行排名</td>
		   		<td>当月绩效工资合计</td>
		   </tr>
		   <tr>
		   		<td>${one.qhpm}</td>
		   		<td align="right">${one.gzhj}</td>
		   </tr>
		   </table>
		   <table class="table table-bordered table-striped table-hover">
  			<tr>
		   		<td>组织部门</td>
		   		<td>岗位名称</td>
		   		<td>工资合计</td>
		   		<td>基本绩效工资</td>
		   		<td>调增工资</td>
		   		<td>扣减工资</td>
		   		<td>平衡计分卡工资</td>
		   		<td>贡献率工资</td>
		   		<td>按量计酬工资</td>
		   </tr>
		   
		   <c:forEach items="${list}" var="item" >
		   <tr>
		   		<td>${item.zzjc}</td>
		   		<td>${item.gwmc}</td>
		   		<td align="right">${item.gzhj}</td>
		   		<td align="right">${item.jbjxgz}</td>
		   		<td align="right">${item.tzgz}</td>
		   		<td align="right">${item.kjgz}</td>
		   		<td align="right"><a href="${pageContext.request.contextPath}/findPerformancePhjfkgzMxCustom.action?yggh=${yggh}&zzbz=${item.zzbz}&gwbz=${item.gwbz}&gzyf=${gzyf}&gwmc=${item.gwmc}&zzjc=${item.zzjc}" class="glyphicon glyphicon-search" title="查看"> ${item.phjfkgz}</a></td>
		   		<td align="right"><a href="${pageContext.request.contextPath}/findPerformanceGxlgzMxCustom.action?yggh=${yggh}&zzbz=${item.zzbz}&gwbz=${item.gwbz}&gzyf=${gzyf}&gwmc=${item.gwmc}&zzjc=${item.zzjc}" class="glyphicon glyphicon-search" title="查看"> ${item.gxlgz}</a></td>
		   		<td align="right"><a href="${pageContext.request.contextPath}/findPerformanceAljcgzMxCustom.action?yggh=${yggh}&zzbz=${item.zzbz}&gwbz=${item.gwbz}&gzyf=${gzyf}&gwmc=${item.gwmc}&zzjc=${item.zzjc}" class="glyphicon glyphicon-search" title="查看"> ${item.aljcgz}</a></td>
		   	</tr>
		   </c:forEach>
  		</table>
  	</div>
  	</div>
  </body>
<script type="text/javascript" src="js/jquery-3.2.1.min.js" charset="UTF-8"></script>
<script type="text/javascript" src="bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/bootstrap-datetimepicker.js" charset="UTF-8"></script>
<script type="text/javascript" src="js/bootstrap-datetimepicker.fr.js" charset="UTF-8"></script>
<script type="text/javascript" src="js/bootstrap-datetimepicker.zh-CN.js" charset="UTF-8"></script>
<script type="text/javascript">
	$('.form_date').datetimepicker({
		format:'yyyy-mm',
        language: 'zh-CN',
        weekStart: 1,
        todayBtn:  1,
		autoclose: 1,
		todayHighlight: 1,
		startView:3,
		minView: 3,
		maxView: 3,
		forceParse: 0
    });
</script>
</html>
