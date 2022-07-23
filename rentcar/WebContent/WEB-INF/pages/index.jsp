<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<% 
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + 
			request.getServerPort()	+ path + "/";
%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta name="renderer" content="webkit">
    <title>【XXXXX】租车系统后台管理中心</title>
    <base href="<%=basePath %>" />
    <link rel="stylesheet" href="css/pintuer.css">
    <link rel="stylesheet" href="css/admin.css">
    <script src="js/jquery.js"></script>   
</head>
<body style="background-color:#f2f9fd;">
<div class="header bg-main">
  <div class="logo margin-big-left fadein-top">
    <h1><img src="images/y.jpg" class="radius-circle rotate-hover" height="50" alt="" />后台管理中心</h1>
  </div>
  <div class="head-l"> &nbsp;&nbsp;<a class="button button-little bg-red" href="logout"><span class="icon-power-off"></span> 退出登录</a> </div>
</div>
<div class="leftnav">
  <div class="leftnav-title"><strong><span class="icon-list"></span>菜单列表</strong></div>
  <c:forEach items="${menus }" var="m">
  	<c:choose>
  		<c:when test="${m.menuId eq 1 }">
  		</c:when>
  		<c:when test="${m.parentid eq 1 }">
  			<h2><span class="icon-user"></span>${m.name }</h2>
  			<c:set var="flag" value="true"></c:set>
  		</c:when>
  		<c:otherwise>
  			<c:if test="${flag eq true }">
  				  <ul style="display:block">
  			</c:if>
  			 <li><a href="${m.url}" target="right"><span class="icon-caret-right"></span>${m.name }</a></li>
  		</c:otherwise>
  	</c:choose>
  </c:forEach>
</div>
<script type="text/javascript">
$(function(){
  $(".leftnav h2").click(function(){
	  $(this).next().slideToggle(200);
	  $(this).toggleClass("on"); 
  })
});
</script>
<div class="admin">
  <iframe scrolling="auto" rameborder="0" src="info" name="right" width="100%" height="100%"></iframe>
</div>
<div style="text-align:center;">
</div>
</body>
</html>