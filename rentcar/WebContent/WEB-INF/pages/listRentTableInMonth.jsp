<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" 
			+ request.getServerPort() + path + "/";
	String carImgPath = request.getSession().getServletContext().getRealPath("/") + "WEB-INF/static/images/cars/";
%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta name="renderer" content="webkit">
    <title>汽车列表页面</title>  
    <base href="<%=basePath %>"  />
    <link rel="stylesheet" href="css/pintuer.css">
    <link rel="stylesheet" href="css/admin.css">
    <script src="js/jquery.js"></script>
    <script src="js/pintuer.js"></script>
    <style>
    	table{
    		width:99%;
    		margin: 10px auto;
    		border:1px solid #CCCCCC;
    	}
    	td,th{
    		vertical-align: middle; 
    		text-align: center;
    		margin:20px;
    		padding:5px;
    		border:1px solid #CCCCCC;
    	}
    	.priceStyle{
    		width:50px;
    	}
    	#cdes{
    		width:200px;
    	}
    </style>
</head>
<body>
<div class="panel admin-panel">
  <div class="panel-head"><strong><span class="icon-pencil-square-o"></span>出租单管理</strong></div>
  <div class="body-content">
  	<c:if test="${not empty tables}">
    <table>
		<tr>
			<th>出租单编号</th>
			<th>预付金</th>
			<th>应付金</th>
			<th>起租日期</th>
			<th>应还日期</th>
			<th>归还日期</th>
			<th>客户身份证</th>
			<th>车号</th>
			<th>服务人员编号</th>
		</tr>
	
		<c:forEach items="${tables}" var="table" >
			<tr id="${table.rentid}">
				<td>${table.rentNo}</td>
				<td>￥${table.imprest}</td>
				<td>￥${table.pricePayAble}</td>
				<td>${table.beginTime}</td>
				<td>${table.endTime}</td>
				<td>${table.realEndTime}</td>
				<td>${table.custIdentity}</td>
				<td>${table.carNumber}</td>
				<td>${table.userName}</td>
			</tr>
		</c:forEach>
	</table>
	</c:if>
	<c:if test="${empty tables}">
		<h3 align="center" style="color: red">***********************************当月没有还车********************************</h3>
	</c:if>
  </div>
</div>
</body></html>