<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" 
			+ request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html lang="zh-cn"> 
<head>
    <meta http-equiv="Content-Type" constent="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta name="renderer" content="webkit">
    <title>网站信息</title>  
    <base href="<%=basePath %>"  />
    <link rel="stylesheet" href="css/pintuer.css">
    <link rel="stylesheet" href="css/admin.css">
    <script src="js/jquery.js"></script>
    <script src="js/pintuer.js"></script>
    <script src="My97DatePicker/WdatePicker.js"></script>
    <style>
    	table{
    		width:90%;
    		margin: 50px auto;
    	}
    	td,th{
    		vertical-align: middle; 
    		margin:20px;
    		padding:5px;
    		border:1px solid #CCCCCC;
    		border-left:none;
    		border-right:none;
    	}
    	.tableInfo{
    		color:red;
    		font-weight: 600;
    		font-size: 20px;
    		text-align:center;
    	}
    </style>  
</head>
<body>
<div class="panel admin-panel">
  <div class="panel-head"><strong><span class="icon-pencil-square-o"></span>车辆入库</strong></div>
  <div class="body-content">
    <form  action="updateChecktable"  method="post">
		<table>
			<tr>
				<td>检查单号：</td>
				<td><input type="text" name="checkno" readonly="readonly" value="${checktable.checkno}" /></td>
				<td>检查时间：</td>
				<td><input type="text" name="checktime" readonly="readonly" value="${checktable.checktime}"  /></td>
			</tr>
			<tr>
				<td>检查员姓名：</td>
				<td><input type="text" name="username" readonly="readonly" value="${checktable.username}" /></td>
				<td>出租单编号：</td>
				<td><input type="text" name="rentid" readonly="readonly" value="${checktable.rentid}" /></td>
				
			</tr>
			<tr>
				<td>备注：</td>
				<td><input type="text" name="type" value="${checktable.type}" /></td>
				<td>赔费：</td>
				<td><input type="text" name="paying" value="${checktable.paying}" /></td>
			</tr>
			<tr>
				<td>车辆问题：</td>
				<td ><input type="text" name="problem" value="${checktable.problem}" /></td>
				<td>检查单状态</td>
				<td>
					<select name="flag">
						<option value="1">正常</option>
						<option value="0">损坏</option>
					</select>
				</td>
			</tr>
			<tr>
				<td colspan="3" style="text-align: center;">
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="submit" value="修改" id="send" />
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="reset" value="重置" /></td>
				<td></td>
			</tr>
		</table>
	</form>
	
	
		<table>
			<tr> 
			<td colspan="6" class="tableInfo">租车单信息</td>
		</tr>
			<tr>
				<td>出租单编号</td>
				<td>${table.rentNo}</td>
				<td>预付金</td>
				<td>${table.imprest}</td>
			</tr>
			<tr>
				<td>应付金额</td>
				<td>${table.pricePayAble}</td>
				<td>实际交付金额</td>
				<td>${table.realPay}元</td>
			</tr>
			<tr>
				<td>起租日期</td>
				<td>${table.beginTime}</td>
				<td>应还日期</td>
				<td>${table.endTime}</td>
			</tr>
			<tr>
				<td>服务人员编号</td>
				<td>
					${currentUser.username}
				</td>
				<td>出租单状态</td>
				<td>
					已出租
				</td>
			</tr>
		</table>
	
	<table>
		<tr> 
			<td colspan="6" class="tableInfo">客户信息</td>
		</tr>
		<tr>
			<td>身份证</td>
			<td>${customer.identity}</td>
			<td>姓名</td>
			<td>${customer.name}</td>
			<td>性别</td>
			<td>${customer.sex}</td>
		</tr>
		<tr>
			<td>地址</td>
			<td>${customer.address}</td>
			<td>电话</td>
			<td>${customer.phone}</td>
			<td>职业</td>
			<td>${customer.career}</td>
		</tr>
	</table>
	
	<table>
		<tr>
			<td colspan="6" class="tableInfo">汽车信息</td>
		</tr>
		<tr>
			<td>车号</td>
			<td>${car.number}</td>
			<td>型号</td>
			<td>${car.type}</td>
			<td>颜色</td>
			<td>${car.color}</td>
		</tr>
		<tr>
			<td>价值</td>
			<td>${car.price}</td>
			<td>租金</td>
			<td>${car.rentprice}</td>
			<td>押金</td>
			<td>${car.deposit}</td>
		</tr>
		<tr>
			<td>租用情况</td>
			<td>
			<c:if test="${car.isrenting eq 0}">
					未出租
				</c:if>
				<c:if test="${car.isrenting eq 1}">
					已出租
				</c:if>
			</td>
			<td cospan="2">简介</td>
			<td>${car.description}</td>
		</tr>
	</table>
  </div>
</div>
</body></html>