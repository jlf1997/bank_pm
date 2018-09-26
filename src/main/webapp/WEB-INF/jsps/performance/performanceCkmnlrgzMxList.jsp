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
    <title>存款模拟利润工资明细列表</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="bootstrap-3.3.7-dist/css/bootstrap.css" media="screen" /> 
	<link rel="stylesheet" type="text/css" href="css/bootstrap-datetimepicker.min.css" media="screen" /> 
	
 </head>
<body>
	<div style="height:40px;">
	    <form action="${pageContext.request.contextPath}/pageFindPerformanceCkmnlrgzMx.action" class="form-horizontal form-inline" 
	    	role="form">
	       <div class="form-group" style="margin-left:1px;margin-top:1px;border:1px solid red;">
	       		<input name="currentPage" value="0" hidden/>
				<input size="16" type="text" value="${ksrq}" name="ksrq" placeholder="开始日期" class="form_date form-control">
				<input size="16" type="text" value="${jsrq}" name="jsrq" placeholder="结束日期" class="form_date form-control">
				<input size="20" type="text" value="" name="condition" placeholder="" class="form-control">
				<input type="submit" value="查询" class="form-control"/>
		   </div>
		</form>
	</div>
		<div style="height:40px;border:1px solid red;width:280px;" class="col-md-6 col-md-offset-3">
			<ul class="pagination" style="margin-top:0px;">
				<c:choose>
					<c:when test="${ph.hasPre !=null and ph.hasPre eq false}">
						<li><a style="opacity:0.2">&laquo;</a></li>
					</c:when>
					<c:otherwise>
						<li><a href="${pageContext.request.contextPath}/pageFindPerformanceCkmnlrgzMx.action?currentPage=${ph.currentPage-1}&tjrq=${tjrq}">&laquo;</a></li>
					</c:otherwise>
				</c:choose>
				<c:choose>
					<c:when test="${ph.pageCount != null and ph.pageCount gt ph.currentPage}">
						<li class="active"><a id="page" href="${pageContext.request.contextPath}/pageFindPerformanceCkmnlrgzMx.action?currentPage=${ph.currentPage}&tjrq=${tjrq}">${ph.currentPage+1}</a></li>
					</c:when>
				</c:choose>
				<c:choose>
					<c:when test="${ph.pageCount != null and ph.pageCount gt ph.currentPage+1}">
						<li><a id="page" href="${pageContext.request.contextPath}/pageFindPerformanceCkmnlrgzMx.action?currentPage=${ph.currentPage+1}&tjrq=${tjrq}">${ph.currentPage+2}</a></li>
					</c:when>
				</c:choose>
				<c:choose>
					<c:when test="${ph.pageCount != null and ph.pageCount gt ph.currentPage+2}">
						<li><a id="page" href="${pageContext.request.contextPath}/pageFindPerformanceCkmnlrgzMx.action?currentPage=${ph.currentPage+2}&tjrq=${tjrq}">${ph.currentPage+3}</a></li>
					</c:when>
				</c:choose>
				<c:choose>
					<c:when test="${ph.pageCount != null and ph.pageCount gt ph.currentPage+3}">
						<li><a id="page" href="${pageContext.request.contextPath}/pageFindPerformanceCkmnlrgzMx.action?currentPage=${ph.currentPage+3}&tjrq=${tjrq}">${ph.currentPage+4}</a></li>
					</c:when>
				</c:choose>
				<c:choose>
					<c:when test="${ph.hasNext !=null and ph.hasNext eq false}">
						<li><a style="opacity:0.2">&raquo;</a></li>
					</c:when>
					<c:otherwise>
						<li><a href="${pageContext.request.contextPath}/pageFindPerformanceCkmnlrgzMx.action?currentPage=${ph.currentPage+1}&tjrq=${tjrq}">&raquo;</a></li>
					</c:otherwise>
				</c:choose>
			</ul>
		</div>
		<div class="col-md-6 form-group" style="border:1px solid red;height:40px;width:300px;line-height:38px;">
			共:${ ph.pageCount }页,当前页：${ph.currentPage+1} ,跳转到:
				<input type="text" size="2" id="pageNum" style="height:30px;"/>页
				<a class="btn-info" href="javascript:void(0);" id="turn">跳转 </a>
		</div>
	<div>
	   <table class="table table-bordered table-striped table-hover">
		   <tr>
		   		<td>统计日期</td>
		   		<td>机构代码</td>
		   		<td>员工工号</td>
		   		<td>账号名称</td>
	    		<td>营销类型</td>
	    		<td>存款余额</td>
	    		<td>存量余额</td>
	    		<td>存量工资</td>
	    		<td>存量累积工资</td>
	    		<td>增量累积工资</td>
	    		<td>操作</td>
		   </tr>
		 <c:forEach items="${list}" var="item">
    	<tr>
    		<td>${item.tjrq}</td>
    		<td>${item.jgdm}</td>
    		<td>${item.yggh}</td>
    		<td>${item.zhmc}</td>
    		<td>${item.yxlx}</td>
    		<td>${item.ckye}</td>
    		<td>${item.clye}</td>
    		<td>${item.clgz}</td>
    		<td>${item.clljgz}</td>
    		<td>${item.zlljgz}</td>
    		<td><a href="${pageContext.request.contextPath}/findOnePerformanceCkmnlrgzMx.action?tjrq=${item.tjrq}&zzbz=${item.zzbz}&gwbz=${item.gwbz}&yggh=${item.yggh}&ckzh=${item.ckzh}" 
	    		class="glyphicon glyphicon-search" title="查看详情"> </a>
    		</td>
    	</tr>
    	</c:forEach>  	
	   </table>
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
		maxView: 2,
		forceParse: 0
    });
    
    $('#turn').click(function(){
    	var reg = /^\+?[1-9][0-9]*$/;
    	var num = $.trim($("#pageNum").val());
    	var pageCount = '${ph.pageCount}';
    	if(reg.test(num) && num.length > 0){
    		if( num <= pageCount){
    			num--;
    			var url = '${pageContext.request.contextPath}/pageFindPerformanceCkmnlrgzMx.action?currentPage='+num+'&tjrq=${tjrq}';
    			window.location.href= url;
    		}else{
    			alert('跳转应小于等于总页数！');
    		}
    	}else{
    		alert('输入不合法');
    	}
    });
</script>
</html>
