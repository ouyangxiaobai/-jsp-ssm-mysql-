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
    		width:90%;
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
    	a {
			padding: 3px 10px;
			background-color:#D9DEE8; height: 25px; width: 150px; 
			text-align: center; border: #D9DEE8; border-style: outset; 
			border-width: 2px; 
			-moz-border-radius:5px;
			-webkit-border-radius:5px;
			border-radius:5px;
		}
    </style>
<script type="text/javascript"  src="js/jquery.js" ></script>
<script type="text/javascript">
	function deleteCar(carId){
		var flag = window.confirm("确定删除车辆信息？");
		if(flag){
			window.location.href="deleteCar?carid="+carId;
		}
	}
</script>  
</head>
<body>
<div class="panel admin-panel">
  <div class="panel-head"><strong><span class="icon-pencil-square-o"></span>查询汽车</strong></div>
  <div class="body-content">
    <table>
		<tr>
			<th>车号</th>
			<th>型号</th>
			<th>品牌</th>
			<th>颜色</th>
			<th>价值（万元）</th>
			<th>租金</th>
			<th>押金</th>
			<th>租用情况</th>
			<th>汽车图片</th>
			<th style="width:200px">简介</th>
			<th>操作</th>
		</tr>
		<c:forEach items="${cars}" var="car" >
			<tr>
				<td>${car.number}</td>
				<td>${car.type}</td>
				<td>${car.brand}</td>
				<td>${car.color}</td>
				<td>${car.price}</td>
				<td>${car.rentprice}</td>
				<td>${car.deposit}</td>
				<td>
					<c:if test="${car.isrenting eq 0}">
						未出租
					</c:if>
					<c:if test="${car.isrenting eq 1}">
						已出租
					</c:if>
				</td>
				<td>
					<img src="images/cars/${car.img}" alt="暂无图片" style="width:100px;height:80px" />
				</td>
				<td><span id="cdes">${car.description}</span></td>
				<td>
					<a href="javascript:void(0)" onclick="deleteCar('${car.carid}')" id="del" />删除</a> | 
					<a href="preUpdateCar?carId=${car.carid}" />修改</a>
				</td>
			</tr>
		</c:forEach>
	</table>
  </div>
</div>
</body></html>