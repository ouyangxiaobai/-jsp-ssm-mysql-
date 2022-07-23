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
    		border:1px solid #cccccc;
    		width: 80%;
    		margin: 50px auto;
    	}
    	td{
    		padding:10px;
    	}
    </style>
</head>
<body>
<div class="panel admin-panel">
  <div class="panel-head"><strong><span class="icon-pencil-square-o"></span>出租单查询</strong></div>
  <div class="body-content">
    <form  action="findRentTableHandler"  method="post">
		<table>
			<tr>
				<td>出租单编号</td>
				<td><input type="text" name="rentNo"/></td>
				<td>还车日期</td>
				<td><input type="text" name="realEndTime" id="realRentEndTime" class="Wdate" onfocus="WdatePicker({readOnly:true})" /></td>
			</tr>
			<tr>
				<td>起租日期</td>
				<td><input type="text" name="beginTime" id="rentStartTime" class="Wdate" onfocus="WdatePicker({readOnly:true})" /></td>
				<td>应还日期</td>
				<td><input type="text" name="endTime"  id="rentEndTime"  class="Wdate" onfocus="WdatePicker({readOnly:true})" /></td>
			</tr>
			<tr>
				<td>出租单状态</td>
				<td>
					<select name="rentFlag">
						<option value="-1">出租状态</option>
						<option value="3">已废弃</option>
						<option value="1">已出租</option>
						<option value="2">已结算</option>
					</select>
				</td>
				<td>服务人员编号</td>
				<td>
					<input type="text" name="username" id="cuserName"  class="required"/>
				</td>
			</tr>
			<tr>
				<td>车号</td>
				<td><input type="text" name="carNumber"  /></td>
				<td>客户身份证号</td>
				<td><input type="text" name="custIdentity" id="cidentity"  class="required"/></td>
			</tr>
			<tr>
				<td colspan="3" style="text-align: center;"><input type="submit" value="确定" id="send" />&nbsp;&nbsp;<input type="reset" value="重置" /></td>
				<td></td>
			</tr>
		</table>
	</form>
  </div>
</div>
</body></html>