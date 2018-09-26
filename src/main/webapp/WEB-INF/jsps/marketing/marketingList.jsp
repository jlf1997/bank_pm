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
    
    <title>营销登记记录</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta name="viewport" content="width=device-width,initial-scale=1,
		minimum-scale=1,maximum-scale=1,user-scalable=no">
	<link rel="stylesheet" type="text/css" href="bootstrap-3.3.7-dist/css/bootstrap.css" media="screen" /> 
	<link rel="stylesheet" type="text/css" href="css/bootstrap-datetimepicker.min.css" media="screen" />  
  </head> 
  <body style="overflow:scroll;overflow-x:hidden;">
  <div>
	  <form action="" method="post" id="form" class="form-inline" role="form" style="margin-top:1%;">
		  <div class="form-group" style="margin-left:1%;">
		  <label>
		  	<c:if test="${type eq 'ck'}">存款营销</c:if>
		  	<c:if test="${type eq 'etc'}">ETC营销</c:if>
		  	<c:if test="${type eq 'cellbank'}">手机银行营销</c:if>
		  	<c:if test="${type eq 'pos'}">POS营销</c:if>
		  </label>
		  
		  	<label class="label label-default">员工工号:</label>
		  	<input type="text" class="form-control" id="yggh" name="yggh" value="${yggh}"/>
		  	<input type="text" class="form-control" placeholder="客户名称|手机号码" name="condition" value="${condition}"/>
		  </div>
		  <button type="submit" id="search" class="btn btn-primary">查询</button>
		  <button id="add"class="btn btn-info" type="button">添加</button>
	  </form>
  </div>
  <center>
     <table border="1" class="table table-bordered table-striped table-hover" style="width:98%;margin:0 auto;">
    	<tr>
    		<td>预约编号</td>
    		<td>机构名称</td>
    		<td>客户名称</td>
    		<td>联系电话</td>
    		<td>预约日期</td>
    		<td>操作</td>
    	</tr>
    	<c:forEach items="${list}" var="item">
    	<tr>
    		<td>${item.yybh}</td>
    		<td>${item.zzjc}</td>
    		<td>${item.khmc}</td>
    		<td>${item.sjhm}</td>
    		<td>${item.yyrq}</td>
     		<td><a class="myQue glyphicon glyphicon-pencil" href="${item.yybh}"></a>
     		<a class="myDel glyphicon glyphicon-trash" href="${item.yybh}" style="margin-left:5px;"></a>
    	</tr>
    	</c:forEach>  	
    </table>
   </center>
   <!-- 弹窗 -->
	<div class="modal" id="mymodal" style="margin-top:1px;">
		<div class="modal-dialog">
			 <div class="modal-content">
			 	<div class="modal-header">
			 		<button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">×</span><span class="sr-only">Close</span></button>
					<label><h4>添加记录</h4></label>
					<label style="margin-left:5%;color:red;" id="subInfo">
						提示 消息			
					</label>
				</div>
		<div class="modal-body" style="border:1px solid black;height:73%;">
			<form action="" method="post" id="form1" role="form">
			<table border="1" class="table table-bordered table-condensed" style="width:70%;" align="center">
			<tr>
	    		<td height="20px;">营销人工号</td><td><input class="form-control" name="yggh" type="text" value="${yggh}" readonly/></td>
	    	</tr>
	    	<tr>
	    		<td>机构名称</td>
	    		<td>
	    		<select name="jgdm" size="1" style="width:100%;" class="form-control">
	    			<c:forEach items="${simOrgList}" var="item">
	    				<option value="${item.ywjgdm}">${item.zzjc}</option>
	    			</c:forEach>
	    		</select>
	    		</td>
	    	</tr>
	    	<tr>
	    		<td>预约日期</td><td><input id="yyrq" name="yyrq" class="form_date form-control" type="text" value=""/></td>
	    	</tr>
	    	<tr>
	    		<td>客户名称</td><td><input id="khmc" name="khmc" type="text" value="" class="form-control"/></td>
	    	</tr>
	    	<c:if test="${type eq 'ck'}">
	    		<tr>
	    		<td>存款种类</td>
	    		<td>
	    			<label class="label label-primary">
            		<input type="radio" name="ckzl" value="2" checked>定期
        			</label>
        			<label class="label label-primary" style="margin-left:3%;">
            		<input type="radio" name="ckzl" value="1">活期
        			</label>
	    		</td>
	    	</tr>
	    	<tr>
	    		<td>客户种类</td>
	    		<td>
	    			<label class="label label-primary">
            		<input type="radio" name="khzl" value="1" checked>个人
        			</label>
        			<label class="label label-primary"style="margin-left:3%;">
            		<input type="radio" name="khzl" value="2">企业
        			</label>
	    		</td>
	    	</tr>
	    	</c:if>
	    	<tr>
	    		<td>证件号码</td><td><input name="zjhm" id="zjhm" type="text" value="" class="form-control"/></td>
	    	</tr>
	    	<tr>
	    		<td>手机号码</td><td><input name="sjhm" id="sjhm" type="text" value="" class="form-control"/></td>
	    	</tr>
	    	<tr>
	    		<td>营销比例</td><td><input name="yxbl" id="yxbl" type="text" value="" class="form-control"/></td>
	    	</tr>
	    	<c:if test="${type eq 'pos'}">
	    		<tr>
	    		<td>客户存款账号</td><td><input name="khckzh" id="khckzh" type="text" value="" class="form-control"/></td>
	    	</tr>
	    	</c:if>
	    	
	    </table>
	    </form>
	</div>
	<div class="modal-footer" style="margin-top:0px;">
		<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
		<button id="insertData" type="button" class="btn btn-primary">保存</button>
	</div>
	</div><!-- /.modal-content -->
	</div><!-- /.modal-dialog -->
	</div><!-- /.modal -->	
	
	<!-- 分页部分 -->
	<div style="width:100%;margin-left:1%;">
	<ul class="pagination" style="margin-top:1%;">
		<li><a>共<font color=red>${page.totalResult}</font>条</a></li>
		<li style=""><input type="number" value="" id="jumpPageNumber" 
			style="width:8%;text-align:center;float:left;margin-top:5px;" placeholder="页码"/>
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
			<select title='显示条数' style="width:8%;height:5%;float:left;margin-top:3px;" onchange="onShowCountChange(this.value);">
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
<script type="text/javascript" src="js/jquery-3.2.1.min.js" charset="UTF-8"></script>
<script type="text/javascript" src="bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/data.js"></script>
<script type="text/javascript" src="js/bootstrap-datetimepicker.js" charset="UTF-8"></script>
<script type="text/javascript" src="js/bootstrap-datetimepicker.fr.js" charset="UTF-8"></script>
<script type="text/javascript" src="js/bootstrap-datetimepicker.zh-CN.js" charset="UTF-8"></script>

<script type="text/javascript">
	$(function(){
		if('${type}' == 'etc'){
				$("#form").attr("action",'${pageContext.request.contextPath}/findEtcMarketing.action');
				$("#form1").attr("action",'${pageContext.request.contextPath}/insertEtcMarketing.action');
			}else if('${type}' == 'ck'){
				$("#form").attr("action",'${pageContext.request.contextPath}/findDepositMarketing.action');
				$("#form1").attr("action",'${pageContext.request.contextPath}/insertDepositMarketing.action');
			}else if('${type}' == 'cellbank'){
				$("#form").attr("action",'${pageContext.request.contextPath}/findCellBankMarketing.action');
				$("#form1").attr("action",'${pageContext.request.contextPath}/insertCellBankMarketing.action');
			}else{//pos
				$("#form").attr("action",'${pageContext.request.contextPath}/findPosMarketing.action');
				$("#form1").attr("action",'${pageContext.request.contextPath}/insertPosMarketing.action');
		}
 	});
 	$('#add').click(function(){
	 	$("#mymodal").modal("toggle");
	}); 
 	$('#insertData').click(function(){
		 var yyrq = /^(\d{4})-(\d{2})-(\d{2})$/;
		if (!yyrq.test($("#yyrq").val())){
			$("#subInfo").text("日期格式错误！");
			return false; 
		}
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
 	$(".myQue").click(function(){
 		if('${type}' == 'etc'){
 			$(this).attr("href",'${pageContext.request.contextPath}/queryOneEtcMarketingByYybh.action?yybh='+$(this).attr("href"));
 		}else if('${type}' == 'ck'){
 			$(this).attr("href",'${pageContext.request.contextPath}/queryOneDepositMarketingByYybh.action?yybh='+$(this).attr("href"));
 		}else if('${type}' == 'cellbank'){
			$(this).attr("href",'${pageContext.request.contextPath}/queryOneCellBankMarketingByYybh.action?yybh='+$(this).attr("href"));
 		}else{//pos
 			$(this).attr("href",'${pageContext.request.contextPath}/queryOnePosMarketingByYybh.action?yybh='+$(this).attr("href"));
 		}
	});
	$(".myDel").click(function(){
		if('${type}' == 'etc'){
 			$(this).attr("href",'${pageContext.request.contextPath}/deleteOneEtcMarketingByYybh.action?yybh='+$(this).attr("href"));
 		}else if('${type}' == 'ck'){
 			$(this).attr("href",'${pageContext.request.contextPath}'+'/deleteOneDepositMarketingByYybh.action?yybh='+$(this).attr("href"));
 		}else if('${type}' == 'cellbank'){
 			$(this).attr("href",'${pageContext.request.contextPath}'+'/deleteOneCellBankMarketingByYybh.action?yybh='+$(this).attr("href"));
 		}else{//pos
 			$(this).attr("href",'${pageContext.request.contextPath}'+'/deleteOnePosMarketingByYybh.action?yybh='+$(this).attr("href"));
 		}
	});
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
</script>
<script type="text/javascript">
	if('${type}' == 'etc'){
		$("#form").attr("action",'${pageContext.request.contextPath}/findEtcMarketing.action');
	}else if('${type}' == 'ck'){
		$("#form").attr("action",'${pageContext.request.contextPath}/findDepositMarketing.action');
	}else if('${type}' == 'cellbank'){
		$("#form").attr("action",'${pageContext.request.contextPath}/findCellBankMarketing.action');
	}else{//pos
		$("#form").attr("action","${pageContext.request.contextPath}/findPosMarketing.action");
	}
	var url;
  	function jumpPage(){
  			var curPage = $("#jumpPageNumber").val();
  			if(curPage == null || curPage == "" ){
  				curPage = 1;
  			}
  			url = $("#form").attr("action")+"?currentPage="+curPage+"&showCount="+'${page.showCount}';
			$("#form").attr("action",url);
			$("#form").submit();
		}
	function nextPage(curPage){
		url = $("#form").attr("action")+"?currentPage="+curPage+"&showCount="+'${page.showCount}';
		$("#form").attr("action",url);
		$("#form").submit();
	}
	function onShowCountChange(value){
		url = $("#form").attr("action")+"?currentPage="+'${page.currentPage}'+"&showCount="+value;
		$("#form").attr("action",url);
		$("#form").submit();
	}
</script>
</html>


