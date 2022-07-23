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
<script type="text/javascript">
	function deleteTable(rentTableId){
		var flag = window.confirm("确认要废弃这个出租单？");
		if(flag){
			$.ajax({
				type:"post",
				url:"dropRentTable",
				data:{"rentTableId":rentTableId},
				dataType:"json",
				success:function(data){
					if(data.flag == "true"){
						$("tr#"+rentTableId).remove();
					}else{
						alert("废弃失败！");
					}
				}
			})
		}
	}
	
	function updateTable(rentTableId){
		$.ajax({
			type:"post",
			url:"updateRentTable",
			data:{"rentTableId":rentTableId},
			dataType:"json",
			success:function(data){
				if(data.flag == "true"){
					$("tr td"+rentTableId+" td").remove();
				}else{
					alert("废弃失败！");
				}
			}
		})
	}
	
</script>  
</head>
<body>
<div class="panel admin-panel">
  <div class="panel-head"><strong><span class="icon-pencil-square-o"></span>出租单管理</strong></div>
  <div class="body-content">
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
			<th>出租单状态</th>
			<th>操作</th>
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
				<c:if test="${table.rentFlag eq 1}">
					<td>
						已出租
					</td>
					<td>
						<input type="hidden" name="rentid" id="rentTableId" value="${table.rentid}" />
						<a href="javascript:void(0)"  onclick="deleteTable('${table.rentid}')" >作废</a> | 
						<a href="preUpdateRentTable?rentid=${table.rentid}" >修改</a>
					</td>
				</c:if>
				<c:if test="${table.rentFlag eq 2}">
					<td>
						<font color="green" >已结算</font>
					</td>
					<td>
						作废  | 修改
					</td>
				</c:if>
				<c:if test="${table.rentFlag eq 3}">
					<td>
						<font color="red" >已废弃</font>
					</td>
					<td>
						作废  | 修改
					</td>
				</c:if>
			</tr>
		</c:forEach>
	</table>
  </div>
</div>
</body></html>