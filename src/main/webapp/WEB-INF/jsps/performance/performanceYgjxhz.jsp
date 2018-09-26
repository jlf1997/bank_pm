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
    
    <title>员工绩效汇总</title>
    
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
	  <form action="${pageContext.request.contextPath}/getPerformanceHome.action" method="post" 
	  class="form-inline" role="form" align="center" style="margin-top:1%;">
		 <div class="form-group">
		  <label class="label label-default">员工工号:</label>
		  <input type="text" class="form-control" name="yggh" value="${yggh}"/>
		 </div>
		  <div class="form-group">
		  	<label class="label label-default">工资日期:</label>
		  	<input type="text" class="form_date form-control" value="${gzrq}" name="gzrq" />
		  </div>
		  
		  <button type="submit" class="btn btn-primary">查询</button>
	  </form>
  </div>
  <div class="panel panel-default" style="width:70%;margin:0 auto;">
  	<div class="panel-heading">员工绩效汇总</div>
  	<div class="panel panel-body">
  		 <table class="table table-bordered table-striped table-hover table-condense">
		   <tr>
		   		<td>工资合计</td>
		   		<td>全行排名</td>
		   		<td>支行排名</td>
		   		<td>组织名称</td>
		   		<td>员工姓名</td>
		   		<td>岗位名称</td>
		   </tr>
		   <tr>
		   		<td align="right">${one.gzhj}</td>
		   		<td>${one.qhgzpm}</td>
		   		<td>${one.zhgzpm}</td>
		   		<td>${staffInfo.zzjc}</td>
		   		<td>${staffInfo.ygxm}</td>
		   		<td>${staffInfo.gwmc}</td>
		   </tr>
		   </table>
		   <label class="panel-title">日绩效工资明细</label>
		   <table class="table table-bordered table-striped table-hover">
  			<tr>
		   		<td>名称</td>
		   		<td>工资</td>
		   		<td>操作</td>
		   </tr>
		   <tr>
		   		<td>存款业绩</td>
		   		<td  align="right">${one.ckgz}</td>
		   		<td><a href="${pageContext.request.contextPath}/getPerformanceMx.action?gzrq=${gzrq}&yggh=${yggh}&zblb=1" class="btn btn-info">查看详情</a></td>
		   </tr>
		   <tr>
		   		<td>贷款业绩</td>
		   		<td  align="right">${one.dkgz}</td>
		   		<td><a href="${pageContext.request.contextPath}/getPerformanceMx.action?gzrq=${gzrq}&yggh=${yggh}&zblb=2" class="btn btn-info">查看详情</a></td>
		   </tr>
		   <tr>
		   		<td>电子银行业绩</td>
		   		<td align="right">${one.dzyhgz}</td>
		   		<td><a href="${pageContext.request.contextPath}/getPerformanceMx.action?gzrq=${gzrq}&yggh=${yggh}&zblb=3" class="btn btn-info">查看详情</a></td>
		   </tr>
		   <tr>
		   		<td>业务量</td>
		   		<td align="right">${one.ywlgz}</td>
		   		<td><a href="${pageContext.request.contextPath}/getPerformanceMx.action?gzrq=${gzrq}&yggh=${yggh}&zblb=4" class="btn btn-info">查看详情</a></td>
		   </tr>
		   <tr>
		   		<td>管理绩效</td>
		   		<td align="right">${one.gljxgz}</td>
		   		<td><a href="${pageContext.request.contextPath}/getPerformanceMx.action?gzrq=${gzrq}&yggh=${yggh}&zblb=5" class="btn btn-info">查看详情</a></td>
		   </tr>
		   <tr>
		   		<td>地区补差</td>
		   		<td align="right">${one.dqbcgz}</td>
		   		<td><a href="${pageContext.request.contextPath}/getPerformanceMx.action?gzrq=${gzrq}&yggh=${yggh}&zblb=6" class="btn btn-info">查看详情</a></td>
		   </tr>
		    <tr>
		   		<td>其他</td>
		   		<td align="right">${one.qt}</td>
		   		<td><a href="${pageContext.request.contextPath}/getPerformanceMx.action?gzrq=${gzrq}&yggh=${yggh}&zblb=7" class="btn btn-info">查看详情</a></td>
		   </tr>
		   <tr>
		   		<td>经营目标</td>
		   		<td align="right">${one.jymbgz}</td>
		   		<td><a href="${pageContext.request.contextPath}/getPerformanceMx.action?gzrq=${gzrq}&yggh=${yggh}&zblb=8" class="btn btn-info">查看详情</a></td>
		   </tr>
		   <tr>
		   		<td>延期兑付</td>
		   		<td align="right">${one.yqdfgz}</td>
		   		<td><a href="${pageContext.request.contextPath}/getPerformanceMx.action?gzrq=${gzrq}&yggh=${yggh}&zblb=9" class="btn btn-info">查看详情</a></td>
		   </tr>
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
		format:'yyyy-mm-dd',
        language: 'zh-CN',
        weekStart: 1,
        todayBtn:  1,
		autoclose: 1,
		todayHighlight: 1,
		startView:2,
		minView: 2,
		maxView: 3,
		forceParse: 0
    });
</script>
</html>
