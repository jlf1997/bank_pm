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
    <title>存款模拟利润工资明细</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="bootstrap-3.3.7-dist/css/bootstrap.css" media="screen" /> 
	<script type="text/javascript" src="js/jquery-3.2.1.min.js" charset="UTF-8"></script>
	<script type="text/javascript" src="bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
	<script type="text/javascript">
		
	</script>
  </head>
<body align="center">
	<h4>${one.yggh}的存款模拟利润工资明细</h4>
	<table class="table-bordered table-striped table-hover" align="center">
		   <tr>
		   		<td>统计日期</td><td>${one.tjrq}</td>
		   		<td>机构代码</td><td>${one.jgdm}</td>
		   </tr>
		   	<tr>
		   		<td>组织标志</td><td>${one.zzbz}</td>
		   		<td>岗位标志</td><td>${one.gwbz}</td>
		   	</tr>
		   	<tr>
		   		<td>员工工号</td><td>${one.yggh}</td>
		   		<td>存款账号</td><td>${one.ckzh}</td>
		   	</tr>	
	    	<tr>
	    		<td>账号名称</td><td>${one.zhmc}</td>
	    		<td>账号类型</td><td>${one.zhlx}</td>
	    	</tr>
	    	<tr>
	    		<td>营销类型</td><td>${one.yxlx}</td>
	    		<td>证件号码</td><td>${one.zjhm}</td>
	    	</tr>
	    	<tr>
	    		<td>开户日期</td><td>${one.khrq}</td>
	    		<td>到期日期</td><td>${one.dqrq}</td>
	    	</tr>
	    	<tr>
	    		<td>存款余额</td><td align="right">${one.ckye}</td>
	    		<td>利率</td><td align="right">${one.ll}</td>
	    	</tr>
	    	<tr>
	    		<td>成本率</td><td align="right">${one.cbl}</td>
	    		<td>利率差</td><td align="right">${one.llc}</td>
	    	</tr>
	    	<tr>
	    		<td>日利率差</td><td align="right">${one.rllc}</td>
	    		<td>分成比率</td><td align="right">${one.fcbl}</td>
	    	</tr>
	    	<tr>
	    		<td>期末模拟利润</td><td align="right">${one.qmmnlr}</td>
	    		<td>期末累计模拟利润</td><td align="right">${one.qmljmnlr}</td>
	    	</tr>
	    	<tr>
	    		<td>存量余额</td><td align="right">${one.clye}</td>
	    		<td>存量模拟利润</td><td align="right">${one.clmnlr}</td>
	    	</tr>
	    	<tr>
	    		<td>存量累积模拟利润</td><td align="right">${one.clljmnlr}</td>
	    		<td>存量单价</td><td align="right">${one.cldj}</td>
	    	</tr>
	    	<tr>
	    		<td>存量工资</td><td align="right">${one.clgz}</td>
	    		<td>存量累积工资</td><td align="right">${one.clljgz}</td>
	    	</tr>
	    	<tr>
	    		<td>增量模拟利润</td><td align="right">${one.zlmnlr}</td>
	    		<td>增量累积模拟利润</td><td align="right">${one.zlljmnlr}</td>
	    	</tr>
	    	<tr>
	    		<td>增量单价</td><td align="right">${one.zldj}</td>
	    		<td>存量单位</td><td align="right">${one.zldw}</td>
	    	</tr>
	    	<tr>
	    		<td>增量工资</td><td align="right">${one.zlgz}</td>
	    		<td>增量累积工资</td><td align="right">${one.zlljgz}</td>
	    	</tr>
	</table>
	<a href="javascript:history.back(-1)" class="btn btn-primary">返回</a>
</body>
</html>