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
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<meta name="renderer" content="webkit">
<title>添加新客户信息</title>
<base href="<%=basePath %>">
<link rel="stylesheet" href="css/pintuer.css">
<link rel="stylesheet" href="css/admin.css">
<script src="js/jquery.js"></script>
<script src="js/pintuer.js"></script>

<script type="text/javascript">

	$(function() {

		$("#send").click(function() {
			$("input.required").trigger("blur");
			var numError = $(".formtips").length;
			if(numError){
				return false;
			}
			$.ajax({
				type : "post",
				url : "insertCustomer",
				dataType : "json",
				data : {
					"name" : $("#custName").val(),
					"pwd" : $("#cuserPassword").val(),
					"sex" : $("#csex").val(),
					"identity" : $("#cidentity").val(),
					"phone" : $("#cphone").val(),
					"career" : $("#ccareer").val(),
					"address" : $("#caddress").val()
				},
				success : function(data) {
					if (data.flag == "ok") {
						location.href = "success";
					} else if (data.flag == "ng") {
						alert("添加失败");
					}
				}
			});
		});
	});
</script>
<script src="js/formCheck.js"></script>
<style>
table{
	border:1px solid #CCCCCC;
	width: 70%;
	margin: 50px auto;
}
td{
	vertical-align:middel;
	padding:10px;
}
</style>


</head>
<body  >
<div class="panel admin-panel">
  	<div class="panel-head"><strong><span class="icon-pencil-square-o"></span>添加客户</strong></div>
  	<div class="body-content">
		<table>
			<tr>
				<td width="100px">客户名</td>
				<td width="300px"> <input type="text" id="custName"  name="cust-name" class="required" /> * </td>
				<td width="100px">身份证</td>
				<td > <input type="text" id="cidentity"  name="cust-identity" class="required"   /> * </td>
			</tr>
			<tr>
				<td width="100px">密码</td>
				<td> <input type="password" id="cuserPassword"  name="cust-pwd" class="required"  /> * </td>
				<td>性别：</td>
				<td><select select id="csex" class="select-sex" name="cust-sex">
					<option value="男">男</option>
					<option value="女">女</option>
				</select>
				 *</td>
			</tr>
			<tr>
				<td>手机号</td>
				<td> <input type="text" id="cphone"  name="cust-phone" class="required"  /> * </td>
				<td>职业</td>
				<td> <input type="text" id="ccareer"  name="cust-career" /> </td>
			</tr>
			<tr>
				<td>现居地址</td>
				<td colspan="3"><input type="text" id="caddress" style="width:400px;height:50px"  name="cust-address" /> </td>

			</tr>
		</table>
		<div class="field">
			<button id="send" class="button bg-main icon-check-square-o"	type="submit">提交</button>
		</div>
	</div>
</div>
</body>
</html>