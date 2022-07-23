<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<base href="<%=basePath%>" />
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<link rel="stylesheet" href="css/pintuer.css" />
    <link rel="stylesheet" href="css/admin.css" />
    <script src="js/jquery.js"></script>
    <script src="js/pintuer.js"></script>
	<title></title>
 <style>
    	table{
    		width: 900px;
    		margin: 10px auto;
    	}
    	td,th{
    		text-align:center;
    		border:1px solid #cccccc;
    		vertical-align:middle;
    		padding:10px;
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
		.search-content{
    		text-align:center;
    	}
    	.search-content span{
    		font-weight: bold;
    		font-size:20px;
    	}
    	.search-value{
    		width:200px;
    		height:30px;
    	}
    	.search-sub{
    		width:80px;
    		height:30px;
    		font-size:19px;
    	}
    </style>
<script src="js/jquery.js"></script>
  <script type="text/javascript">
	function deleteConfirm(obj){
		var flag = window.confirm("您确定要删除吗？");
		if (flag) {
			window.location.href=("deleteRole?roleid="+obj);
		}
	}
	$(function(){
		$("#subHref").click(function(){
			$("#findRoleForm").submit();
		})
	})
</script>
</head>
 
	

<body >
<div class="panel admin-panel">
  <div class="panel-head"><strong><span class="icon-pencil-square-o"></span>角色信息管理</strong></div>
   <div class="body-content">
   	<form action="findRoleByName" method="post" id="findRoleForm">
	   	<div class="search-content">
			<span class="newfont06">用户名称 : </span>
			<input name="rolename" class="search-value" type="text" size="12" value="${rolename }"  />&emsp; 
			<a href="javascript:;" class="myButton" id="subHref">查询</a>&nbsp;
			<a href="showMenu" class="myButton">添加角色</a>
		</div>
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
		</table>
	</form>
	<br />
	<table >
		<tr>
			<th colspan="5">角色列表</th>
		</tr>
		<tr>
			<th >选择</th>
			<th >编号</th>
			<th >角色名</th>
			<th >编辑</th>
			<th >删除</th>
		</tr>
		<c:forEach items="${roles}" var="role">
			<tr>
			<td><input  type="checkbox" name="delid"/></td>
			<td>${role.roleid }</td>
			<td>${role.rolename }</td>
			<td><a href="showRoleMenu?roleid=${role.roleid }&rolename=${role.rolename }">
			编辑</a></td>
			<td ><a href="javascript:void(0)" onclick="deleteConfirm(${role.roleid});">删除</a></td>
		</tr>
		</c:forEach>
	</table>
   </div>
</div>
</body>
</html>