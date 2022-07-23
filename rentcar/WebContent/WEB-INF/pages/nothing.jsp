<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" 
			+ request.getServerPort() + path + "/";
	String carImgPath = request.getSession().getServletContext().getRealPath("/") + "WEB-INF/static/images/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查无结果</title>
<base href="<%=basePath %>"  />

<style>
	body{
		background:url(images/nothing.gif) no-repeat;
		background-position:100px 100px;
	}
</style>
</head>
<body>
</body>
</html>