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
    
    <title>绩效汇总</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="bootstrap-3.3.7-dist/css/bootstrap.css" media="screen" /> 
	<link rel="stylesheet" type="text/css" href="css/bootstrap-datetimepicker.min.css" media="screen" /> 	
  </head>
  <body >
  <div class="panel panel-default" style="width:70%;margin:0 auto;">
  	<div class="panel-heading">业绩</div>
  	<div class="panel panel-body">
  		<div class="form-inline">
  			<label>工资日期</label>
  			<label class="form-control">${gzrq}</label>
  			<label>工资合计</label>
  			<label class="form-control">${hj}</label>
  		</div>
  		 <table class="table table-bordered table-striped table-hover">
		   <tr>
		   		<td>指标名称</td>
		   		<td>指标工资</td>
		   		<td>操作</td>
		   </tr>
		   <c:forEach items="${list}" var="item">
		   	<c:if test="${item.zbid eq 'D90001'}">
		   		<tr>
			   		<td>存量存款自然增长模拟利润</td>
			   		<td  align="right">${item.zbgz}</td>
			   		<td><a href="${pageContext.request.contextPath}/findPerformanceClCkmnlrgzMx.action?yggh=${yggh}&tjrq=${gzrq}&yxlx=2">查看明细</a></td>
		  		</tr>
		   	</c:if>
		   	<c:if test="${item.zbid eq 'D90002'}">
		   		<tr>
			   		<td>存量存款主动揽储模拟利润</td>
			   		<td align="right">${item.zbgz}</td>
			   		<td><a href="${pageContext.request.contextPath}/findPerformanceClCkmnlrgzMx.action?yggh=${yggh}&tjrq=${gzrq}&yxlx=1">查看明细</a></td>
		  		</tr>
		   	</c:if>
		   	<c:if test="${item.zbid eq 'D90005'}">
		   		<tr>
			   		<td>增量存款自然增长模拟利润</td>
			   		<td align="right">${item.zbgz}</td>
			   		<td><a href="${pageContext.request.contextPath}/findPerformanceZlCkmnlrgzMx.action?yggh=${yggh}&tjrq=${gzrq}&yxlx=2">查看明细</a></td>
		  		</tr>
		   	</c:if>
		   	<c:if test="${item.zbid eq 'D90006'}">
		   		<tr>
			   		<td>增量存款主动揽储模拟利润</td>
			   		<td align="right">${item.zbgz}</td>
			   		<td><a href="${pageContext.request.contextPath}/findPerformanceZlCkmnlrgzMx.action?yggh=${yggh}&tjrq=${gzrq}&yxlx=1">查看明细</a></td>
		  		</tr>
		   	</c:if>
		   	<c:if test="${item.zbid eq 'D90007'}">
		   		<tr>
			   		<td>存量存款户数</td>
			   		<td align="right">${item.zbgz}</td>
			   		<td><a href="${pageContext.request.contextPath}/findPerformanceCkhsMx.action?yggh=${yggh}&tjrq=${gzrq}&yxlx=1">查看明细</a></td>
		  		</tr>
		   	</c:if>
		   	<c:if test="${item.zbid eq 'D90009'}">
		   		<tr>
			   		<td>增量存款户数</td>
			   		<td align="right">${item.zbgz}</td>
			   		<td><a href="${pageContext.request.contextPath}/findPerformanceCkhsMx.action?yggh=${yggh}&tjrq=${gzrq}&yxlx=2">查看明细</a></td>
		  		</tr>
		   	</c:if>
		   	<c:if test="${item.zbid eq 'D90038'}">
		   		<tr>
			   		<td>存量存款自然增长模拟利润(综合户)</td>
		   			<td align="right">${item.zbgz}</td>
		   			<td><a href="${pageContext.request.contextPath}/findZhhPerformanceClCkmnlrgzMx.action?zzbz=${item.zzbz}&tjrq=${gzrq}&yxlx=2">查看明细</a></td>
		  		</tr>
		   	</c:if>
		   	<c:if test="${item.zbid eq 'D90039'}">
		   		<tr>
			   		<td>增量存款自然增长模拟利润(综合户)</td>
		   			<td align="right">${item.zbgz}</td>
		   			<td><a href="${pageContext.request.contextPath}/findZhhPerformanceZlCkmnlrgzMx.action?zzbz=${item.zzbz}&tjrq=${gzrq}&yxlx=2">查看明细</a></td>
		  		</tr>
		   	</c:if>
		   	<c:if test="${item.zbid eq 'D90010'}">
		   		<tr>
			   		<td>营销贷款笔数</td>
		   			<td align="right">${item.zbgz}</td>
		   			<td><a href="${pageContext.request.contextPath}/findPerformanceDkkhbsMx.action?yggh=${yggh}&tjrq=${gzrq}&type=bs">查看明细</a></td>
		  		</tr>
		   	</c:if>
		   	<c:if test="${item.zbid eq 'D90011'}">
		   		<tr>
			   		<td>营销贷款额度</td>
		   			<td align="right">${item.zbgz}</td>
		   			<td><a href="${pageContext.request.contextPath}/findPerformanceDkkhbsMx.action?yggh=${yggh}&tjrq=${gzrq}&type=ed">查看明细</a></td>
		  		</tr>
		   	</c:if>
		   	<c:if test="${item.zbid eq 'D90012'}">
		   		<tr>
			   		<td>存量贷款模拟利润</td>
		   			<td align="right">${item.zbgz}</td>
		   			<td><a href="${pageContext.request.contextPath}/findPerformanceDkmnlrgzMx.action?yggh=${yggh}&tjrq=${gzrq}&type=cl">查看明细</a></td>
		  		</tr>
		   	</c:if>
		   	<c:if test="${item.zbid eq 'D90014'}">
		   		<tr>
			   		<td>增量贷款模拟利润</td>
		   			<td align="right">${item.zbgz}</td>
		   			<td><a href="${pageContext.request.contextPath}/findPerformanceDkmnlrgzMx.action?yggh=${yggh}&tjrq=${gzrq}&type=zl">查看明细</a></td>
		  		</tr>
		   	</c:if>
		   	<c:if test="${item.zbid eq 'D90037'}">
		   		<tr>
			   		<td>表外贷款清收</td>
		   			<td align="right">${item.zbgz}</td>
		   			<td><a href="${pageContext.request.contextPath}/findPerformanceBlqsMx.action?yggh=${yggh}&gzrq=${gzrq}">查看明细</a></td>
		  		</tr>
		   	</c:if>
		   	<c:if test="${item.zbid eq 'D90015'}">
		   		<tr>
			   		<td>手机银行主动营销户数</td>
		   			<td align="right">${item.zbgz}</td>
		   			<td><a href="${pageContext.request.contextPath}/findPerformanceCellBankHsMx.action?yggh=${yggh}&tjrq=${gzrq}&yxlx=1">查看明细</a></td>
		  		</tr>
		   	</c:if>
		   	<c:if test="${item.zbid eq 'D90016'}">
		   		<tr>
			   		<td>手机银行自然增长户数</td>
		   			<td align="right">${item.zbgz}</td>
		   			<td><a href="${pageContext.request.contextPath}/findPerformanceCellBankHsMx.action?yggh=${yggh}&tjrq=${gzrq}&yxlx=2">查看明细</a></td>
		  		</tr>
		   	</c:if>
		   	<c:if test="${item.zbid eq 'D90017'}">
		   		<tr>
			   		<td>手机银行交易笔数</td>
		   			<td align="right">${item.zbgz}</td>
		   			<td><a href="${pageContext.request.contextPath}/findPerformanceCellBankTradeMx.action?yggh=${yggh}&tjrq=${gzrq}">查看明细</a></td>
		  		</tr>
		   	</c:if>
		   	<c:if test="${item.zbid eq 'D90019'}">
		   		<tr>
			   		<td>社保卡激活户数</td>
		   			<td align="right">${item.zbgz}</td>
		   			<td><a href="${pageContext.request.contextPath}/findPerformanceJgpjMx.action?yggh=${yggh}&gzrq=${gzrq}&zbid=${item.zbid}">查看明细</a></td>
		  		</tr>
		   	</c:if>
		   	<c:if test="${item.zbid eq 'D90020'}">
		   		<tr>
			   		<td>ETC营销户数</td>
		   			<td align="right">${item.zbgz}</td>
		   			<td>
		   				<c:choose>
		   					<c:when test="${area.dqcs eq 189210}">
		   						<a href="${pageContext.request.contextPath}/findPerformancePersonalByCountMx.action?yggh=${yggh}&gzrq=${gzrq}&zbid=${item.zbid}">查看明细</a>
		   					</c:when>
		   					<c:otherwise>
		   						<a href="${pageContext.request.contextPath}/findPerformanceEtcHsgzMx.action?yggh=${yggh}&tjrq=${gzrq}&ghlx=1">查看明细</a>
		   					</c:otherwise>
		   				</c:choose>
		   			</td>
		  		</tr>
		   	</c:if>
		   	<c:if test="${item.zbid eq 'D90021'}">
		   		<tr>
			   		<td>ETC安装户数</td>
		   			<td align="right">${item.zbgz}</td>
		   			<td><a href="${pageContext.request.contextPath}/findPerformanceEtcHsgzMx.action?yggh=${yggh}&tjrq=${gzrq}&ghlx=6">查看明细</a></td>
		  		</tr>
		   	</c:if>
		   	<c:if test="${item.zbid eq 'D90022'}">
		   		<tr>
			   		<td>个人网银户数</td>
		   			<td align="right">${item.zbgz}</td>
		   			<td><a href="${pageContext.request.contextPath}/findPerformancePersonalByCountMx.action?yggh=${yggh}&gzrq=${gzrq}&zbid=${item.zbid}">查看明细</a></td>
		  		</tr>
		   	</c:if>
		   	<c:if test="${item.zbid eq 'D90023'}">
		   		<tr>
			   		<td>企业网银户数</td>
		   			<td align="right">${item.zbgz}</td>
		   			<td><a href="${pageContext.request.contextPath}/findPerformancePersonalByCountMx.action?yggh=${yggh}&gzrq=${gzrq}&zbid=${item.zbid}">查看明细</a></td>
		  		</tr>
		   	</c:if>
		   	<c:if test="${item.zbid eq 'D90024'}">
		   		<tr>
			   		<td>POS机营销户数</td>
		   			<td align="right">${item.zbgz}</td>
		   			<td><a href="${pageContext.request.contextPath}/findPerformancePersonalByCountMx.action?yggh=${yggh}&gzrq=${gzrq}&zbid=${item.zbid}">查看明细</a></td>
		  		</tr>
		   	</c:if>
		   	<c:if test="${item.zbid eq 'D90025'}">
		   		<tr>
			   		<td>POS机安装户数</td>
		   			<td align="right">${item.zbgz}</td>
		   			<td><a href="${pageContext.request.contextPath}/findPerformancePersonalByCountMx.action?yggh=${yggh}&gzrq=${gzrq}&zbid=${item.zbid}">查看明细</a></td>
		  		</tr>
		   	</c:if>
		   	<c:if test="${item.zbid eq 'D90026'}">
		   		<tr>
			   		<td>POS机刷卡笔数</td>
		   			<td align="right">${item.zbgz}</td>
		   			<td><a href="${pageContext.request.contextPath}/findPerformancePersonalByCountMx.action?yggh=${yggh}&gzrq=${gzrq}&zbid=${item.zbid}">查看明细</a></td>
		  		</tr>
		   	</c:if>
		   	<c:if test="${item.zbid eq 'D90035'}">
		   		<tr>
			   		<td>支行社保卡激活率</td>
		   			<td align="right">${item.zbgz}</td>
		   			<td>
		   			<c:choose>
		   				<c:when test="${area.dqcs eq 189210}">
		   					<a href="${pageContext.request.contextPath}/findPerformanceCbSjyhdhl.action?yggh=${yggh}&gzrq=${gzrq}&zbid=${item.zbid}">查看明细</a>
		   				</c:when>
		   				<c:otherwise>
		   					<a href="${pageContext.request.contextPath}/findPerformanceJgReductionMx.action?yggh=${yggh}&gzrq=${gzrq}&zbid=${item.zbid}">查看明细</a>
		   				</c:otherwise>
		   			</c:choose>
		   			</td>
		  		</tr>
		   	</c:if>
		   	<c:if test="${item.zbid eq 'D90036'}">
		   		<tr>
			   		<td>支行电子银行代替率</td>
		   			<td align="right">${item.zbgz}</td>
		   			<td>
		   			<c:choose>
		   				<c:when test="${area.dqcs eq 189210}">
		   					<a href="${pageContext.request.contextPath}/findPerformanceCbSjyhdhl.action?yggh=${yggh}&gzrq=${gzrq}&zbid=${item.zbid}">查看明细</a>
		   				</c:when>
		   				<c:otherwise>
		   					<a href="${pageContext.request.contextPath}/findPerformanceJgReductionMx.action?yggh=${yggh}&gzrq=${gzrq}&zbid=${item.zbid}">查看明细</a></td>
		   				</c:otherwise>
		   			</c:choose>	
		  		</tr>
		   	</c:if>
		   	<c:if test="${item.zbid eq 'D90031'}">
		   		<tr>
			   		<td>本人经办业务量</td>
		   			<td align="right">${item.zbgz}</td>
		   			<td><a href="${pageContext.request.contextPath}/findPerformanceBusinessDetail.action?yggh=${yggh}&tjrq=${gzrq}&type=brjb">查看明细</a></td>
		  		</tr>
		   	</c:if>
		   	<c:if test="${item.zbid eq 'D90040'}">
		   		<tr>
			   		<td>现金流量</td>
		   			<td align="right">${item.zbgz}</td>
		   			<td><a href="${pageContext.request.contextPath}/findPerformanceBusinessDetail.action?yggh=${yggh}&tjrq=${gzrq}&type=xjll">查看明细</a></td>
		  		</tr>
		   	</c:if>
		   	<c:if test="${item.zbid eq 'D90033'}">
		   		<tr>
			   		<td>管理绩效</td>
		   			<td align="right">${item.zbgz}</td>
		   			<td><a href="${pageContext.request.contextPath}/findPerformanceGljxgzMx.action?yggh=${yggh}&tjrq=${gzrq}">查看明细</a></td>
		  		</tr>
		   	</c:if>
		   	<c:if test="${item.zbid eq 'D90034'}">
		   		<tr>
			   		<td>地区补差</td>
		   			<td align="right">${item.zbgz}</td>
		   			<td><a href="${pageContext.request.contextPath}/findPerformanceAreaMakeUp.action?yggh=${yggh}&tjrq=${gzrq}">查看明细</a></td>
		  		</tr>
		   	</c:if>
		   	<c:if test="${item.zbid eq 'D90043'}">
		   		<tr>
			   		<td>存量存款月日平余额业绩</td>
		   			<td align="right">${item.zbgz}</td>
		   			<td><a href="${pageContext.request.contextPath}/findPerformanceCkAljcgzMx.action?yggh=${yggh}&tjrq=${gzrq}&type=cl">查看明细</a></td>
		  		</tr>
		   	</c:if>
		   	<c:if test="${item.zbid eq 'D90044'}">
		   		<tr>
			   		<td>增量存款月日平余额业绩</td>
		   			<td align="right">${item.zbgz}</td>
		   			<td><a href="${pageContext.request.contextPath}/findPerformanceCkAljcgzMx.action?yggh=${yggh}&tjrq=${gzrq}&type=zl">查看明细</a></td>
		  		</tr>
		   	</c:if>
		   	<c:if test="${item.zbid eq 'D90056'}">
		   		<tr>
			   		<td>存款新增优质客户</td>
		   			<td align="right">${item.zbgz}</td>
		   			<td><a href="${pageContext.request.contextPath}/findPerformanceCkYzkhgzMx.action?yggh=${yggh}&tjrq=${gzrq}">查看明细</a></td>
		  		</tr>
		   	</c:if>
		   	<c:if test="${item.zbid eq 'D90063'}">
		   		<tr>
			   		<td>存量存款月日平余额业绩(综合户)</td>
		   			<td align="right">${item.zbgz}</td>
		   			<td><a href="${pageContext.request.contextPath}/findZhhPerformanceCkAljcgzMx.action?tjrq=${gzrq}&type=cl&zzbz=${item.zzbz}">查看明细</a></td>
		  		</tr>
		   	</c:if>
		   	<c:if test="${item.zbid eq 'D90064'}">
		   		<tr>
			   		<td>增量存款月日平余额业绩(综合户)</td>
		   			<td align="right">${item.zbgz}</td>
		   			<td><a href="${pageContext.request.contextPath}/findZhhPerformanceCkAljcgzMx.action?tjrq=${gzrq}&type=zl&zzbz=${item.zzbz}">查看明细</a></td>
		  		</tr>
		   	</c:if>
		   	<c:if test="${item.zbid eq 'D90046'}">
		   		<tr>
			   		<td>存量贷款户数</td>
		   			<td align="right">${item.zbgz}</td>
		   			
		   			<td><a href="${pageContext.request.contextPath}/findPerformanceDkKhhsMx.action?yggh=${yggh}&tjrq=${gzrq}&lx=1&showCount=10&currentPage=1">查看明细</a></td>
		  		</tr>
		   	</c:if>
		   	<c:if test="${item.zbid eq 'D90047'}">
		   		<tr>
			   		<td>增量贷款户数</td>
		   			<td align="right">${item.zbgz}</td>
		   			<td><a href="${pageContext.request.contextPath}/findPerformanceDkKhhsMx.action?yggh=${yggh}&tjrq=${gzrq}&lx=2">查看明细</a></td>
		  		</tr>
		   	</c:if>
		   	<c:if test="${item.zbid eq 'D90048'}">
		   		<tr>
			   		<td>贷款月末余额</td>
		   			<td align="right">${item.zbgz}</td>
		   			<td><a href="${pageContext.request.contextPath}/findPerformanceDkAljcgzMx.action?yggh=${yggh}&tjrq=${gzrq}">查看明细</a></td>
		  		</tr>
		   	</c:if>
		   	<c:if test="${item.zbid eq 'D90050'}">
		   		<tr>
			   		<td>新增表内不良贷款占比(比上月)</td>
		   			<td align="right">${item.zbgz}</td>
		   			<td><a href="${pageContext.request.contextPath}/findPerformanceDkXzbnbldkzb.action?yggh=${yggh}&gzrq=${gzrq}&zbid=${item.zbid}">查看明细</a></td>
		  		</tr>
		   	</c:if>
		   	<c:if test="${item.zbid eq 'D90051'}">
		   		<tr>
			   		<td>当年到期贷款收回率</td>
		   			<td align="right">${item.zbgz}</td>
		   			<td><a href="${pageContext.request.contextPath}/findPerformanceDkDndqdkshl.action?yggh=${yggh}&gzrq=${gzrq}&zbid=${item.zbid}">查看明细</a></td>
		  		</tr>
		   	</c:if>
		   	<c:if test="${item.zbid eq 'D90052'}">
		   		<tr>
			   		<td>当月贷款利息收回</td>
		   			<td align="right">${item.zbgz}</td>
		   			<td><a href="${pageContext.request.contextPath}/findPerformanceDkDydklxshMx.action?yggh=${yggh}&tjrq=${gzrq}">查看明细</a></td>
		  		</tr>
		   	</c:if>
		   	<c:if test="${item.zbid eq 'D90053'}">
		   		<tr>
			   		<td>网点贷款户数</td>
		   			<td align="right">${item.zbgz}</td>
		   			<td><a href="${pageContext.request.contextPath}/findPerformanceDkWddkhsMx.action?yggh=${yggh}&tjrq=${gzrq}&zzbz=${item.zzbz}">查看明细</a></td>
		  		</tr>
		   	</c:if>
		   	<c:if test="${item.zbid eq 'D90018'}">
		   		<tr>
			   		<td>手机银行动户率</td>
		   			<td align="right">${item.zbgz}</td>
		   			<td><a href="${pageContext.request.contextPath}/findPerformanceCbSjyhdhl.action?yggh=${yggh}&gzrq=${gzrq}&zbid=${item.zbid}">查看明细</a></td>
		  		</tr>
		   	</c:if>
		   	<c:if test="${item.zbid eq 'D90049'}">
		   		<tr>
			   		<td>便民卡户数</td>
		   			<td align="right">${item.zbgz}</td>
		   			<td><a href="${pageContext.request.contextPath}/findPerformanceCbBmkkhhsMx.action?yggh=${yggh}&tjrq=${gzrq}">查看明细</a></td>
		  		</tr>
		   	</c:if>
		   	<c:if test="${item.zbid eq 'D90032'}">
		   		<tr>
			   		<td>支行总业务量</td>
		   			<td align="right">${item.zbgz}</td>
		   			<td><a href="${pageContext.request.contextPath}/findPerformanceYwlWdywl.action?yggh=${yggh}&gzrq=${gzrq}&zbid=${item.zbid}">查看明细</a></td>
		  		</tr>
		   	</c:if>
		   	<c:if test="${item.zbid eq 'D90041'}">
		   		<tr>
			   		<td>网点现金流量</td>
		   			<td align="right">${item.zbgz}</td>
		   			<td><a href="${pageContext.request.contextPath}/findPerformanceYwlWdywl.action?yggh=${yggh}&gzrq=${gzrq}&zbid=${item.zbid}">查看明细</a></td>
		  		</tr>
		   	</c:if>
		   	<c:if test="${item.zbid eq 'D90058'}">
		   		<tr>
			   		<td>本部室管理目标考核</td>
		   			<td align="right">${item.zbgz}</td>
		   			<td><a href="${pageContext.request.contextPath}/findPerformanceGljxBmkh.action?yggh=${yggh}&gzrq=${gzrq}&zbid=${item.zbid}">查看明细</a></td>
		  		</tr>
		   	</c:if>
		   	<c:if test="${item.zbid eq 'D90059'}">
		   		<tr>
			   		<td>部门挂片考核</td>
		   			<td align="right">${item.zbgz}</td>
		   			<td><a href="${pageContext.request.contextPath}/findPerformanceGljxBmkh.action?yggh=${yggh}&gzrq=${gzrq}&zbid=${item.zbid}">查看明细</a></td>
		  		</tr>
		   	</c:if>
		   	<c:if test="${item.zbid eq 'D90060'}">
		   		<tr>
			   		<td>机构经营目标完成情况计酬</td>
		   			<td align="right">${item.zbgz}</td>
		   			<td><a href="${pageContext.request.contextPath}/findPerformanceJgjymb.action?yggh=${yggh}&gzrq=${gzrq}&zbid=${item.zbid}">查看明细</a></td>
		  		</tr>
		   	</c:if>
		   	
		   	<c:if test="${item.zbid eq 'D99998'}">
		   		<tr>
			   		<td>网点人均工资</td>
		   			<td align="right">${item.zbgz}</td>
		   			<td><a href="${pageContext.request.contextPath}/findPerformanceGljxWdrjgz.action?yggh=${yggh}&gzrq=${gzrq}&zbid=${item.zbid}">查看明细</a></td>
		  		</tr>
		   	</c:if>
		   	<c:if test="${item.zbid eq 'D90055'}">
		   		<tr>
			   		<td>工作质量</td>
		   			<td align="right">${item.zbgz}</td>
		   			<td><a href="${pageContext.request.contextPath}/findPerformanceGzzl.action?yggh=${yggh}&gzrq=${gzrq}&zbid=${item.zbid}">查看明细</a></td>
		  		</tr>
		   	</c:if>
		   	<c:if test="${item.zbid eq 'D99999'}">
		   		<tr>
			   		<td>享受系数工资</td>
		   			<td align="right">${item.zbgz}</td>
		   			<td><a href="${pageContext.request.contextPath}/findPerformanceXsxsgz.action?yggh=${yggh}&gzrq=${gzrq}&zbid=${item.zbid}">查看明细</a></td>
		  		</tr>
		   	</c:if>
		   	<c:if test="${item.zbid eq 'D90054'}">
		   		<tr>
			   		<td>网点贷款月末余额</td>
		   			<td align="right">${item.zbgz}</td>
		   			<td><a href="${pageContext.request.contextPath}/findPerformanceJgaljc.action?yggh=${yggh}&gzrq=${gzrq}&zbid=${item.zbid}">查看明细</a></td>
		  		</tr>
		   	</c:if>
		   	<c:if test="${item.zbid eq 'D90045'}">
		   		<tr>
			   		<td>网点存款月末余额业绩</td>
		   			<td align="right">${item.zbgz}</td>
		   			<td><a href="${pageContext.request.contextPath}/findPerformanceJgaljc.action?yggh=${yggh}&gzrq=${gzrq}&zbid=${item.zbid}">查看明细</a></td>
		  		</tr>
		   	</c:if>
		   	<c:if test="${item.zbid eq 'D90062'}">
		   		<tr>
			   		<td>网点贷款利息收入</td>
		   			<td align="right">${item.zbgz}</td>
		   			<td><a href="${pageContext.request.contextPath}/findPerformanceJgaljc.action?yggh=${yggh}&gzrq=${gzrq}&zbid=${item.zbid}">查看明细</a></td>
		  		</tr>
		   	</c:if>
		   	<c:if test="${item.zbid eq 'D90042'}">
		   		<tr>
			   		<td>电子银行业务</td>
		   			<td align="right">${item.zbgz}</td>
		   			<td><a href="${pageContext.request.contextPath}/findPerformancePersonalByCountMx.action?yggh=${yggh}&gzrq=${gzrq}&zbid=${item.zbid}">查看明细</a></td>
		  		</tr>
		   	</c:if>
		   	<c:if test="${item.zbid eq 'D90065'}">
		   		<tr>
			   		<td>手机银行户数</td>
		   			<td align="right">${item.zbgz}</td>
		   			<td><a href="${pageContext.request.contextPath}/findPerformancePersonalByCountMx.action?yggh=${yggh}&gzrq=${gzrq}&zbid=${item.zbid}">查看明细</a></td>
		  		</tr>
		   	</c:if>
		   	<c:if test="${item.zbid eq 'D90066'}">
		   		<tr>
			   		<td>网上银行户数</td>
		   			<td align="right">${item.zbgz}</td>
		   			<td><a href="${pageContext.request.contextPath}/findPerformancePersonalByCountMx.action?yggh=${yggh}&gzrq=${gzrq}&zbid=${item.zbid}">查看明细</a></td>
		  		</tr>
		   	</c:if>
		   	<c:if test="${item.zbid eq 'D90067'}">
		   		<tr>
			   		<td>贷记卡户数</td>
		   			<td align="right">${item.zbgz}</td>
		   			<td><a href="${pageContext.request.contextPath}/findPerformancePersonalByCountMx.action?yggh=${yggh}&gzrq=${gzrq}&zbid=${item.zbid}">查看明细</a></td>
		  		</tr>
		   	</c:if>
		   	<c:if test="${item.zbid eq 'D90074'}">
		   		<tr>
			   		<td>便民卡</td>
		   			<td align="right">${item.zbgz}</td>
		   			<td><a href="${pageContext.request.contextPath}/findPerformancePersonalByCountMx.action?yggh=${yggh}&gzrq=${gzrq}&zbid=${item.zbid}">查看明细</a></td>
		  		</tr>
		   	</c:if>
		   	<c:if test="${item.zbid eq 'D90057'}">
		   		<tr>
			   		<td>ATM机业务量</td>
		   			<td align="right">${item.zbgz}</td>
		   			<td><a href="${pageContext.request.contextPath}/findPerformancePersonalByCountMx.action?yggh=${yggh}&gzrq=${gzrq}&zbid=${item.zbid}">查看明细</a></td>
		  		</tr>
		   	</c:if>
		   	<c:if test="${item.zbid eq 'D90078'}">
		   		<tr>
			   		<td>调整业务量</td>
		   			<td align="right">${item.zbgz}</td>
		   			<td><a href="${pageContext.request.contextPath}/findPerformancePersonalByCountMx.action?yggh=${yggh}&gzrq=${gzrq}&zbid=${item.zbid}">查看明细</a></td>
		  		</tr>
		   	</c:if>
		   </c:forEach>	    
		   </table>
		   <a href="javascript:history.back(-1)" class="btn btn-primary">返回</a>
  	</div>
  	</div>
  </body>
<script type="text/javascript" src="js/jquery-3.2.1.min.js" charset="UTF-8"></script>
<script type="text/javascript" src="bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/bootstrap-datetimepicker.js" charset="UTF-8"></script>
<script type="text/javascript" src="js/bootstrap-datetimepicker.fr.js" charset="UTF-8"></script>
<script type="text/javascript" src="js/bootstrap-datetimepicker.zh-CN.js" charset="UTF-8"></script>
</html>
