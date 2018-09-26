<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>数据日志</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" type="text/css"
	href="bootstrap-3.3.7-dist/css/bootstrap.css" media="screen" />
<link rel="stylesheet" type="text/css"
	href="css/bootstrap-datetimepicker.min.css" media="screen" />
</head>
<body>
	<div>
		<form
			action="${pageContext.request.contextPath}/dataLog.action?"
			method="post" class="form-inline" role="form" id="form" style="margin-top:1%;margin-left:1%;">
			<!-- <div class="form-group">
				<label class="label label-default">日期:</label> <input type="text"
					class="form-control" value="" name="insert_time" />
			</div> -->
			<div class="form-group">
				<select name="data_status" class="form-control">
					<option value="1" <c:if test="${data_status == 1}">selected</c:if> >成功</option>  
					<option value="0" <c:if test="${data_status == 0}">selected</c:if> >失败</option> 
				</select>
			</div>
			<button type="submit" class="btn btn-primary">查询</button>
		</form>
	</div>
	<table class="table table-bordered table-striped table-hover table-condensed" style="width:98%;margin:1% auto;">
		<tr>
			<td>数据处理 ID</td>
			<td>数据日期</td>
			<td>操作类型</td>
			<td>开始时间</td>
			<td>结束时间</td>
			<td>耗时</td>
			<td>失败原因</td>
			<td>最终状态</td>
		</tr>
		<c:forEach items="${list}" var="item">
			<tr>
				<td>${item.data_id}</td>
				<td>${item.data_time}</td>
				<td>${item.data_type}</td>
				<td>${item.start_time}</td>
				<td>${item.end_time}</td>
				<td>${item.consume_time}</td>
				<td>${item.fail_cause}</td>
				<td>${item.data_status}</td>
			</tr>
		</c:forEach>
	</table>
	<!-- 分页 -->
	<div style="width:100%;">
	<ul class="pagination" style="margin-top:0;margin-left:1%;">
		<li><a>共<font color="red">${page.totalResult}</font>条</a></li>
		<li><input type="number" value="" id="jumpPageNumber" 
			style="width:7%;text-align:center;float:left;margin-top:5px;" placeholder="页码"/>
		</li>
		<li style="cursor:pointer;"><a onclick="jumpPage();" class="btn btn-success">跳转</a></li>
		<c:choose>
			<c:when test="${page.currentPage eq 1 }">
				<li><a disabled="true" >首页</a></li>
				<li><a disabled="true" >上页</a></li>
			</c:when>
			<c:otherwise>
				<li style="cursor:pointer;"><a onclick="nextPage(1);">首页</a></li>
				<li style="cursor:pointer;"><a
					onclick="nextPage(${page.currentPage - 1});">上页</a></li>
			</c:otherwise>
		</c:choose>
		<!-- 循环遍历产生页码数目的数字显示-->
		<c:forEach var="pagenumber" begin="${page.currentPage}" end="${page.currentPage + 10 < page.totalPage ? page.currentPage + 10 : page.totalPage }">
			<!-- 判断页码是否是当前页，是的话，就换个颜色来标记 -->
			<c:choose>
				<c:when test="${page.currentPage eq pagenumber}">
					<li><a><b style="color:red;">${ page.currentPage }</b></a></li>
				</c:when>
				<c:otherwise>
					<li style="cursor:pointer;"><a onclick="nextPage(${pagenumber});">${pagenumber}</a></li>
				</c:otherwise>
			</c:choose>
		</c:forEach>
		
		<!-- 处理 当前页是否最后一页，不是的话，就需要添加下一页的点击时间-->
		<c:choose>
			<c:when test="${page.currentPage eq page.totalPage}">
				<li><a disabled="true">下页</a>
				</li>
				<li><a disabled="true">尾页</a>
				</li>
			</c:when>
			<c:otherwise>
				<li style="cursor:pointer;"><a
					onclick="nextPage(${page.currentPage + 1 })">下页</a>
				</li>
				<li style="cursor:pointer;"><a onclick="nextPage(${ page.totalPage });">尾页</a>
				</li>
			</c:otherwise>
		</c:choose>

		<!-- 处理 页面大小的处理-->
		<li><a>共${page.totalPage}页</a></li>
		<!-- 进行每一个页面显示数据条目大小的选择 -->
		<li>
			<select  onchange="onShowCountChange(this.value);" title='显示条数' style="width:7%;height:5%;float:left;margin-top:3px;">
				<option value="${page.showCount}">${page.showCount}</option>
				<option value='5'>5</option>
				<option value='10'>10</option>
				<option value='12'>12</option>
				<option value='15'>15</option>
				<option value='20'>20</option>
				<option value='30'>30</option>
				<option value='50'>50</option>
				<option value='70'>70</option>
				<option value='100'>100</option>
			</select>
		</li>
	</ul>
	</div>
</body>
<script type="text/javascript">
	var url = '${pageContext.request.contextPath}/dataLog.action?';
  	function jumpPage(){
  			var curPage = $("#jumpPageNumber").val();
  			if(curPage == null || curPage == "" ){
  				curPage = 1;
  			}
			$("#form").attr("action",url+"&currentPage="+curPage+"&showCount="+'${page.showCount}');
			$("#form").submit();
		}
		
	function nextPage(curPage){
		$("#form").attr("action",url+"&currentPage="+curPage+"&showCount="+'${page.showCount}');
		$("#form").submit();
	}
	
	function onShowCountChange(value){
		$("#form").attr("action",url+"&currentPage="+"${page.currentPage}"+"&showCount="+value);
		$("#form").submit();
	}
</script>
<script type="text/javascript" src="js/jquery-3.2.1.min.js" charset="UTF-8"></script>
<script type="text/javascript"
	src="bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
</html>
