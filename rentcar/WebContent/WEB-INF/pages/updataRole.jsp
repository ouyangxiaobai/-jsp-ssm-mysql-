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
  <div class="panel-head"><strong><span class="icon-pencil-square-o"></span>修改角色</strong></div>
  <div class="body-content">
    <form method="post" class="form-x" action="updataRole.do">
    	<h2>
    	<div align="center">
    		角色名称：
			<input type="text" name="rolename" value="${role.rolename }"/> * 
			<input type="hidden" name="roleid" value="${role.roleid }"/> * 
    	</div>
    	</h2>
      <table border="1px">
			<tr>
				<th  align="center"  >选择</th>
				<th  align="center" > 权限名称</th>
			</tr>
				 <c:forEach items="${menus }" var="m">
				 	<c:set var="count" value="${0 }"></c:set>
				  	
				 	<tr>
						<c:choose>
							<c:when test="${m.menuId eq 1 }">
							</c:when>
							<c:when test="${m.parentid eq 1 }">
								<c:forEach items="${roleMenus }" var="rm">
									<c:if test="${m.menuId == rm.menuId && count==0}">
										<c:set var="count" value="${count+1 }"></c:set>
										<td align="center"><input type="checkbox" checked="checked" name="menuId" value="${m.menuId } " /></td>
										<td align="center"><h3>${m.name }</h3> </td>
									</c:if>
								</c:forEach>
								<c:if test="${count==0 }">
									<td align="center"><input type="checkbox" name="menuId" value="${m.menuId }" /></td>
									<td align="center"><h3>${m.name }</h3> </td>
								</c:if>
							</c:when>
							<c:otherwise>
								<c:forEach items="${roleMenus }" var="rm">
									<c:if test="${m.menuId == rm.menuId && count==0}">
										<c:set var="count" value="${count+1 }"></c:set>
										<td align="center"> <input type="checkbox" checked="checked" c name="menuId" value="${m.menuId }" /></td>
										<td align="center">${m.name }</td>
									</c:if>
								</c:forEach>
								<c:if test="${count==0 }">
										<td align="center"> <input type="checkbox" c name="menuId" value="${m.menuId }" /></td>
										<td align="center">${m.name }</td>
								</c:if>
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