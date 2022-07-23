<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" 
			+ request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta name="renderer" content="webkit">
    <title>网站信息</title>  
    <base href="<%=basePath %>"  />
    <link rel="stylesheet" href="css/pintuer.css">
    <link rel="stylesheet" href="css/admin.css">
    <script src="js/jquery.js"></script>
    <script src="js/pintuer.js"></script>
    <script>
			$(function(){
				$("#moreTypeHref").click(function(){
					$("#moreTypeDiv").slideToggle(200);
					var tip = $(this).text();
					if(tip.indexOf("更多")==-1){
						$(this).text("查看更多>>>>");
					}else{
						$(this).text("<<<<隐藏");
					}
				})
				$("#moreBrandHref").click(function(){
					$("#moreBrandDiv").slideToggle(200);
					var tip = $(this).text();
					if(tip.indexOf("更多")==-1){
						$(this).text("查看更多>>>>");
					}else{
						$(this).text("<<<<隐藏");
					}
				})
				$.ajax({
					type:"post",
					url:"findCarsInfo",
					dataType:"json",
					success:function(data){
						var typeContent = "车型：";
						var brandContent = "品牌：";
						for( var i=0; i<data.length; i++ ){
							if(data[i].type){
								typeContent += "<lable><input type='checkbox' name='type' value='"+data[i].type+"' />"+data[i].type+"</lable>";
							}
							if(data[i].brand){
								brandContent += "<lable><input type='checkbox' name='brand' value='"+data[i].brand+"' />"+data[i].brand+"</lable>";
							}
						}
						$("#search-type").append(typeContent);
						$("#search-brand").append(brandContent);
					}
				})
			});
			function rentCar(carId, carNumber,rentPrice){
				var custIdentity = $("#custIdentity").val();
				var custId = $("#custId").val();
				var href="preAddRentTable?carid="+carId+"&carNumber="+carNumber+"&custIdentity="+
						custIdentity+"&custId="+custId+"&rentPrice="+rentPrice;
				window.location.href = href;
			}
		</script>
		<style>
			#search{
				text-align:left;
				margin: 20px;
			}
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
	    	#del{
	    		font-size: 20px;
	    		font-weight: bold;
	    	}
	    	.more{
	    		color:red;
	    	}
	    	lable{
	    		border:1px solid #cccccc;
	    		margin:5px;
	    		padding:5px;
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
</head>
<body>
<div class="panel admin-panel">
  <div class="panel-head"><strong><span class="icon-pencil-square-o"></span>客户选车</strong></div>
  <div class="body-content" style="text-align:center" >
  欢迎客户身份证号为<font color="red" >【${identity}】</font>来选车
  <hr/>
     <div id="search">
			<form method="post" action="findSomeCarsForCust">
			<input type="hidden" name="identity" id="custIdentity" value="${identity}" /> 
			<input type="hidden" name="custid" id="custId" value="${custid}" />
			<div id="search-type" >
			</div>
			<br/><br/>
			<div id="search-brand" >
			</div>
			<br/><br/>
			<div id="search-rentPrice" >
				租金：
				<input type="text" name="lowRentPrice" id="clowRentPrice" class="priceStyle" />~
				<input type="text" name="highRentPrice" id="chighRentPrice" class="priceStyle" />
			</div>
			<br/>
			<button class="button bg-main icon-check-square-o" type="submit"  id="sub">查询</button>
		</form>
	</div>
		<hr />
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
			<th>简介</th>
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
					<img src="images/cars/${car.img}" alt="暂无图片"  style="width:100px;height:80px"/>
				</td>
				<td><span id="cdes">${car.description}</span></td>
				<td>
					<c:if  test="${car.isrenting eq 0}">
						<a href="javascript:;" onclick="rentCar('${car.carid}','${car.number}','${car.rentprice}')">租车</a>
					</c:if>
					<c:if  test="${car.isrenting eq 1}">
						<input type="button"  id="rentCar" value="已租"  disabled="disabled" />
					</c:if>
				</td>
			</tr>
		</c:forEach>
	</table>
  </div>
</div>
</body></html>