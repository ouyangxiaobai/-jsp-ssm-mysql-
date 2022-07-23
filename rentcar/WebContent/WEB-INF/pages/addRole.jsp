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
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta name="renderer" content="webkit">
    <title>网站信息</title>  
    <base href="<%=basePath %>"  />
    <link rel="stylesheet" href="css/pintuer.css">
    <link rel="stylesheet" href="css/admin.css">
    <script src="js/jquery.js"></script>
    <script src="js/pintuer.js"></script>
    <style>
    	table{
    		width: 800px;
    		margin: 50px auto;
    	}
    	td{
    		padding:10px;
    	}
    	th{
    		padding:10px;
    		font-size: large;
    	}
    </style>  
</head>
<body>
<div class="panel admin-panel">
  <div class="panel-head"><strong><span class="icon-pencil-square-o"></span>添加角色</strong></div>
  <div class="body-content">
    <form method="post" class="form-x" action="addRole.do">
    	<h2>
    	<div align="center">
    		角色名称：
			<input type="text" name="rolename" /> * 
    	</div>
    	</h2>
      <table border="1px">
			<tr>
				<th  align="center"  >选择</th>
				<th  align="center" > 权限名称</th>
			</tr>
				 <c:forEach items="${menus }" var="m">
				 	<tr>
				 	<c:choose>
				  		<c:when test="${m.menuId eq 1 }">
				  		</c:when>
				  		<c:when test="${m.parentid eq 1 }">
				  			<td align="center"><input type="checkbox" name="menuId" value="${m.menuId }" /></td>
				  			<td align="center"><h3>${m.name }</h3> </td>
				  		</c:when>
				  		<c:otherwise>
				  			<td align="center"> <input type="checkbox" name="menuId" value="${m.menuId }" /></td>
				  			 <td align="center">${m.name }</td>
				  		</c:otherwise>
				  	</c:choose>
				  	</tr>
				  </c:forEach>
			<tr>
				<div class="field">
				<td width="100px" colspan="2" align="center">
          		<button class="button bg-main icon-check-square-o" type="submit"> 提交</button>
          		</td>
        		</div>
			</tr>
    </form>
  </div>
</div>
</body></html>