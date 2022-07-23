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
    <style>
    	table{
    		width: 800px;
    		margin: 50px auto;
    	}
    	td{
    		padding:10px;
    	}
    	#body-content-form{
    		padding:20px;
    		border:1px solid #cccccc;
    		text-align:center;
    	}
    </style>  
</head>
<body>
<div class="panel admin-panel">
  <div class="panel-head"><strong><span class="icon-pencil-square-o"></span>查询用户</strong></div>
  <div class="body-content">
    <form method="post" class="form-x" action="findUsers">
    	<div id="body-content-form">
    		<div>登陆名：<input type="text" name="username" id="uname" /> * </div><br/>
    		<div>身份证：<input type="text" name="identity" id="uidentity" /> * </div><br/>
    		<div>联系电话：<input type="text" name="phone" id="uphone" /> * </div><br/>
    	</div>
          <div class="form-group">
        <div class="label">
          <label></label>
        </div>
        <div class="field">
          <button class="button bg-main icon-check-square-o" type="submit"> 提交</button>
        </div>
      </div>
    </form>
  </div>
</div>
</body></html>