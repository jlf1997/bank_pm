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
    
    <title>客户列表</title>
    
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
    <form action="${pageContext.request.contextPath}/findCustomer.action?&khlx=${khlx}" method="post" 
	  class="form-inline" role="form" style="margin-top:1%;margin-left:2%;" id="form">
	  	<div class="form-group">
		  	<label class="label label-default">员工工号:</label>
		  	<input type="text" class="form-control"  name="yggh" value="${yggh}"/>
		  	<input type="text" class="form-control" placeholder="客户名称|手机号码" name="condition" value="${condition}"/>
		  </div>
		  <button type="submit" class="btn btn-primary">查询</button>
	  </form>
	  <table class="table table-bordered table-striped table-hover table-condense" style="margin:1% auto;width:96%;">
		<tr>
			<td>客户编号</td>
			<td>联系电话</td>
			<td>客户名称</td>
			<td>持有产品</td>
			<td>地址</td>
			<td>操作</td>
		</tr>
		<c:forEach items="${list}" var="item">
			<tr>
				<td>${item.khbh}</td>
				<td>${item.sjhm}</td>
				<td>${item.khmc}</td>
				<td>${item.cpxx}</td>
				<td>${item.zz}</td>
				<td><a href="${pageContext.request.contextPath}/findCustomerDetail.action?khbh=${item.khbh}&ghrgh=${item.ghrgh}" class="glyphicon glyphicon-search" title="查看详情"></a></td>
			</tr>
		</c:forEach>
	</table>
	<div style="width:100%;">
	<ul class="pagination" style="margin-top:0;margin-left:2%;width:98%;">
		<li><a>共<font color=red>${page.totalResult}</font>条</a></li>
		<li style=""><input type="number" value="" id="jumpPageNumber" 
			style="width:5%;text-align:center;float:left;margin-top:5px;" placeholder="页码"/>
		</li>
		<li style="cursor:pointer;"><a onclick="jumpPage();" class="btn btn-success">跳转</a></li>
		<c:choose>
			<c:when test="${page.currentPage eq 1 }">
				<li><a>首页</a></li>
				<li><a>上页</a></li>
				<!-- 分是否为第一页的两种情况，不为第一页的话，那么就要设置首页和上一页为有onclick点击事件 -->
			</c:when>
			<c:otherwise>
				<li style="cursor:pointer;"><a onclick="nextPage(1);">首页</a>
				</li>
				<li style="cursor:pointer;"><a
					onclick="nextPage(${page.currentPage}-1);">上页</a>
				</li>
			</c:otherwise>
		</c:choose>
		<!-- 循环遍历产生页码数目的数字显示-->
		<c:forEach var="pagenumber" begin="${page.currentPage}" end="${page.currentPage + 10 < page.totalPage ? page.currentPage + 10 : page.totalPage }">
			<!-- 判断页码是否是当前页，是的话，就换个颜色来标记 -->
			<c:choose>
				<c:when test="${page.currentPage == pagenumber}">
					<li><a><b style="color: red;">${page.currentPage}</b></a></li>
				</c:when>
				<c:otherwise>
					<li style="cursor:pointer;"><a onclick="nextPage(${pagenumber});">${pagenumber}</a></li>
				</c:otherwise>
			</c:choose>
		</c:forEach>
		
		<!-- 处理 当前页是否最后一页，不是的话，就需要添加下一页的点击时间-->
		<c:choose>
			<c:when test="${page.currentPage == page.totalPage }">
				<li><a>下页</a>
				</li>
				<li><a>尾页</a>
				</li>
			</c:when>
			<c:otherwise>
				<li style="cursor:pointer;"><a
					onclick="nextPage(${page.currentPage}+1)">下页</a>
				</li>
				<li style="cursor:pointer;"><a
					onclick="nextPage(${page.totalPage});">尾页</a>
				</li>
			</c:otherwise>
		</c:choose>

		<!-- 处理 页面大小的处理-->
		<li><a>共${page.totalPage}页</a></li>
		<!-- 进行每一个页面显示数据条目大小的选择 -->
		<li>
			<select title='显示条数' style="width:5%;height:5%;float:left;margin-top:3px;" onchange="onShowCountChange(this.value);">
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
  
   <!-- 分页逻辑 -->
<script type="text/javascript">
	var url = '${pageContext.request.contextPath}/findCustomer.action?&khlx=${khlx}';
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
</html>
