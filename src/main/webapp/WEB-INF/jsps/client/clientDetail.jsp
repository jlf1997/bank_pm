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
    
    <title>客户明细</title>
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
	  	<div class="panel-heading">基本信息</div>
	  	<div class="panel panel-body">
	  		<table class="table table-bordered table-striped table-hover table-condensed" style="margin:1% auto;width:96%;">
				<tr>
					<td>所属部门</td>
					<td>客户编号</td>
					<td>客户名称</td>
					<td>联系电话</td>
					<td>持有产品</td>
					<td>地址</td>
				</tr>
				<tr>
					<td>${one.customer.zzjc}</td>
					<td>${one.customer.khbh}</td>
					<td>${one.customer.khmc}</td>
					<td>${one.customer.sjhm}</td>
					<td>${one.customer.cpxx}</td>
					<td>${one.customer.zz}</td>
				</tr>
			</table>
	  	</div>
	</div>
	<!-- 关联人信息 -->
	 <div class="panel panel-default" style="width:96%;margin:1% auto;">
	  	<div class="panel-heading">关联人信息</div>
	  	<div class="panel panel-body">
	  		<table class="table table-bordered table-striped table-hover table-condensed" style="margin:1% auto;width:96%;">
				<tr>
					<td>关联人类型</td>
					<td>关联人姓名</td>
					<td>联系电话</td>
				</tr>
				<c:forEach items="${one.relatedPerson}" var="item">
					<tr>
						<td>
						<c:choose>
							<c:when test="${item.glrlx eq '401'}">父母与子女</c:when>
							<c:when test="${item.glrlx eq '002'}">配偶</c:when>
							<c:when test="${item.glrlx eq '403'}">兄弟姐妹</c:when>
							<c:when test="${item.glrlx eq 'X'}">其他</c:when>
							<c:otherwise>不明关系</c:otherwise>
						</c:choose>
						</td>
						<td>${item.glrxm}</td>
						<td>${item.lxfs}</td>
					</tr>
				</c:forEach>
			</table>
	  	</div>
	</div>
	
	<!-- 持有产品 -->
	<div class="panel panel-default" style="width:96%;margin:1% auto;">
	  	<div class="panel-heading">持有产品信息</div>
	  	<div class="panel panel-body">
	  		<c:if test="${one.depositAccountFamily != null}">
	  		<label class="label label-primary" style="width:8%;display:inline-block;">存款</label>
	  		<div class="label"  style="width:10%;border:1px solid blue;margin-left:80%;">
	  			<a href="${pageContext.request.contextPath}/findDepositCustomer.action?khbh=${one.depositAccountFamily.khbh}&jgdm=${one.depositAccountFamily.jgdm}">查看更多</a>
	  		</div>
	  		<table class="table table-bordered table-striped table-hover table-condensed" style="margin:1% auto;width:96%;">
				<tr>
					<td>存款账号</td>
					<td>开户机构</td>
					<td>利率</td>
					<td>开户日期</td>
					<td>金额</td>
					<td>营销类型</td>
					<td>拓展人</td>
					<td>拓展比例</td>
				</tr>
				<tr>
					<td>${one.depositAccountFamily.ckzh}</td>
					<td>${one.depositAccountFamily.zzjc}</td>
					<td>${one.depositAccountFamily.ll}</td>
					<td>${one.depositAccountFamily.khrq}</td>
					<td align="right">${one.depositAccountFamily.ckye}</td>
					<td>
					<c:choose>
						<c:when test="${one.depositAccountFamily.yxlx eq 1}">主动营销</c:when>
						<c:when test="${one.depositAccountFamily.yxlx eq 2}">自然增长</c:when>
						<c:otherwise>真奇怪</c:otherwise>
					</c:choose>
					</td>
					<td>${one.depositAccountFamily.tzr}</td>
					<td>${one.depositAccountFamily.tzbl}</td>
					</tr>
			</table>
			<table class="table table-bordered table-striped table-hover table-condensed" style="margin:1% auto;width:96%;">
				<tr>
					<td>管户人姓名</td>
					<td>管户人比例</td>
					<td>开始时间</td>
					<td>结束时间</td>
				</tr>
				<c:forEach items="${one.depositAccountPerson}" var="item">
				<tr>
					<td>${item.ygxm}</td>
					<td>${item.ghbl}</td>
					<td>${item.ksrq}</td>
					<td>${item.jsrq}</td>
				</tr>
				</c:forEach>
			</table>
			</c:if>
			
			<c:if test="${one.loanCustomerProduct != null}">
			<label class="label label-primary" style="width:8%;display:inline-block;">贷款</label>
			<div class="label" style="width:10%;border:1px solid blue;margin-left:80%;">
				<a href="${pageContext.request.contextPath}/findLoanCustomer.action?khbh=${one.loanCustomerProduct.khbh}&jgdm=${one.loanCustomerProduct.jgdm}" >查看更多</a>
			</div>
	  		<table class="table table-bordered table-striped table-hover table-condensed" style="margin:1% auto;width:96%;">
				<tr>
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
				<tr>
					<td>${one.loanCustomerProduct.cpmc}</td>
					<td>${one.loanCustomerProduct.zzjc}</td>
					<td>
						<c:choose>
							<c:when test="${one.loanCustomerProduct.five_class_type eq 1}">正常</c:when>
							<c:when test="${one.loanCustomerProduct.five_class_type eq 2}">关注</c:when>
							<c:when test="${one.loanCustomerProduct.five_class_type eq 3}">次级</c:when>
							<c:when test="${one.loanCustomerProduct.five_class_type eq 4}">可疑</c:when>
							<c:when test="${one.loanCustomerProduct.five_class_type eq 5}">损失</c:when>  
							<c:otherwise>真奇怪</c:otherwise>
						</c:choose>
					</td>
					<td>${one.loanCustomerProduct.ffrq}</td>
					<td>${one.loanCustomerProduct.dqrq}</td>
					<td>${one.loanCustomerProduct.ll}</td>
					<td>${one.loanCustomerProduct.khjlmc}</td>
					<td align="right">${one.loanCustomerProduct.dkye}</td>
					<td align="right">${one.loanCustomerProduct.dkje}</td>
					</tr>
			</table>
			<table class="table table-bordered table-striped table-hover table-condensed" style="margin:1% auto;width:96%;">
				<tr>
					<td>管户人姓名</td>
					<td>管户人比例</td>
					<td>开始时间</td>
					<td>结束时间</td>
				</tr>
				<c:forEach items="${one.loanCustomerPerson}" var="item">
				<tr>
					<td>${item.ygxm}</td>
					<td>${item.ghbl}</td>
					<td>${item.ksrq}</td>
					<td>${item.jsrq}</td>
				</tr>
				</c:forEach>
			</table>
			</c:if>
			<!-- 手机银行 -->
			<c:if test="${one.cellBankCustomerProduct != null}">
			<label class="label label-primary" style="width:8%;display:inline-block;">手机银行</label>
			<div class="label" style="width:20%;border:1px solid blue;margin-left:80%;">
				<a href="${pageContext.request.contextPath}/findCellBankCustomer.action?khbh=${one.cellBankCustomerProduct.khbh}&jgdm=${one.cellBankCustomerProduct.jgdm}">查看更多</a>
			</div>
	  		<table class="table table-bordered table-striped table-hover table-condensed" style="margin:1% auto;width:96%;">
				<tr>
					<td>开户机构</td>
					<td>开户日期</td>
					<td>营销类型</td>
					<td>注销日期</td>
					<td>贴片日期</td>
					<td>拓展人</td>
					<td>拓展比例</td>
				</tr>
				<tr>
					<td>${one.cellBankCustomerProduct.zzjc}</td>
					<td>${one.cellBankCustomerProduct.khrq}</td>
					<td>
						<c:choose>
							<c:when test="${one.depositAccountFamily.yxlx eq 1}">主动营销</c:when>
							<c:when test="${one.depositAccountFamily.yxlx eq 2}">自然增长</c:when>
							<c:otherwise>真奇怪</c:otherwise>
						</c:choose>
					</td>
					<td>${one.cellBankCustomerProduct.zxrq}</td>
					<td>${one.cellBankCustomerProduct.tprq}</td>
					
					<td>${one.cellBankCustomerProduct.tzr}</td>
					<td>${one.cellBankCustomerProduct.tzbl}</td>
					</tr>
			</table>
			<table class="table table-bordered table-striped table-hover table-condensed" style="margin:1% auto;width:96%;">
				<tr>
					<td>管户人姓名</td>
					<td>管户人比例</td>
					<td>开始时间</td>
					<td>结束时间</td>
				</tr>
				<c:forEach items="${one.cellBankCustomerPerson}" var="item">
				<tr>
					<td>${item.ygxm}</td>
					<td>${item.ghbl}</td>
					<td>${item.ksrq}</td>
					<td>${item.jsrq}</td>
				</tr>
				</c:forEach>
			</table>
			</c:if>
			<!-- ETC -->
			<c:if test="${one.etcCustomerFamily != null}">
			<label class="label label-primary" style="width:8%;display:inline-block;">ETC</label>
			<div class="label" style="width:20%;border:1px solid blue;margin-left:80%;">
				<a href="${pageContext.request.contextPath}/findEtcCustomer.action?khbh=${one.etcCustomerFamily.khbh}&jgdm=${one.etcCustomerFamily.jgdm}" >查看更多</a>
			</div>
	  		<table class="table table-bordered table-striped table-hover table-condensed" style="margin:1% auto;width:96%;">
				<tr>
					<td>开户机构</td>
					<td>绑定日期</td>
					<td>营销类型</td>
					<td>拓展人</td>
					<td>拓展比例</td>
					<td>安装人</td>
					<td>安装比例</td>
					<td>湘通卡卡号</td>
					<td>垫付金额</td>
				</tr>
				<tr>
					<td>${one.etcCustomerFamily.zzjc}</td>
					<td>${one.etcCustomerFamily.rq}</td>
					<td>
						<c:choose>
							<c:when test="${one.etcCustomerFamily.yxlx eq 1}">主动营销</c:when>
							<c:when test="${one.etcCustomerFamily.yxlx eq 2}">自然增长</c:when>
							<c:otherwise>真奇怪</c:otherwise>
						</c:choose>
					</td>
					<td>${one.etcCustomerFamily.tzr}</td>
					<td>${one.etcCustomerFamily.tzbl}</td>
					<td>${one.etcCustomerFamily.azr}</td>
					<td>${one.etcCustomerFamily.azbl}</td>
					<td>${one.etcCustomerFamily.xtkkh}</td>
					<td align="right">${one.etcCustomerFamily.dfje}</td>
					</tr>
			</table>
			</c:if>
	  	</div>
	</div>
	
  </body>
</html>
