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
    
    <title>存款模拟利润</title>
    
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
	  <form action="${pageContext.request.contextPath}/findPerformanceClCkmnlrgzMx.action?yggh=${yggh}&yxlx=2" method="post" 
	  class="form-inline" role="form" style="margin-top:1%;margin-left: 1%;" id="form">
		  <div class="form-group">
		  	<label class="label label-default">工资合计:</label> ${hj} 元
		  	<label class="label label-default">工资日期:</label>
		  	<input type="text" class="form-control" readonly value="${tjrq}" name="tjrq"/>
		  </div>
		  <div class="form-group">
		  	<input type="text" class="form-control" placeholder="账号名称|存款账号" name="condition" value="${condition}"/>
		  </div>
		  <button type="submit" class="btn btn-primary">查询</button>
		 
	  </form>
  </div>
  		 <table class="table table-bordered table-striped table-hover table-condensed" style="width:98%;margin-left:1%;">
		   <tr>
		   		<td>存款账号</td>
		   		<td>机构名称</td>
		   		<td>账户名称</td>
		   		<td>营销类型</td>
		   		<td>FTP利率差</td>
		   		<td>分成比例</td>
		   		<td >存量模拟利润</td>
		   		<c:if test="${type eq 'zl'}">
		   		<td>增量模拟利润</td>
		   		</c:if>
		   		<td>期末模拟利润</td>
		   		<td>余额</td>
		   		<td>单价</td>
		   		<td>工资</td>
		   		<td>累计工资</td>
		   </tr>
		   <c:forEach items="${list}" var="item">
		   	<tr>
		   		<td>${item.ckzh}</td>
		   		<td>${item.zzjc}</td>
		   		<td>${item.zhmc}</td>
		   		<td>
		   		<c:if test="${item.yxlx eq 1 }">
		   			主动营销
		   		</c:if>
		   		<c:if test="${item.yxlx eq 2 }">
		   			自然增长
		   		</c:if>
		   		</td>
		   		<td>${item.llc}</td>
		   		<td>${item.fcbl}</td>
		   		<td>${item.clmnlr}</td>
		  		<c:if test="${type eq 'zl'}">
		   			<td>${item.zlmnlr}</td>
		   		</c:if>
		   		<td>${item.qmmnlr}</td>
		   		<td align="right">${item.ckye}</td>
		   		<c:if test="${type eq 'cl'}">
		   			<td align="right">${item.cldj}</td>
		   			<td align="right">${item.clgz}</td>
		   			<td align="right">${item.clljgz}</td>
		   		</c:if>
		   		<c:if test="${type eq 'zl'}">
		   			<td align="right">${item.zldj}</td>
		   			<td align="right">${item.zlgz}</td>
		   			<td align="right">${item.zlljgz}</td>
		   		</c:if>
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
			<select  onchange="onShowCountChange(this.value);" title='显示条数' style="width:5%;height:5%;float:left;margin-top:3px;">
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
	var url = '${pageContext.request.contextPath}/findPerformanceClCkmnlrgzMx.action?yggh=${yggh}&yxlx=2';
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
<script type="text/javascript" src="bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
</html>
