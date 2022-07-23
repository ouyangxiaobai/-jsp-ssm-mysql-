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
    <script src="js/formCheck.js"></script>
    <style>
    	table{
    		border:1px solid #cccccc;
    		width: 800px;
    		margin: 50px auto;
    	}
    	td{
    		padding:10px;
    	}
    </style>
    <script type="text/javascript">
    $(function(){
		$.ajax({
			type:"post",
			url:"preAdduserData",
			dataType:"json",
			success:function(data){
				for(var i=0; i<data.length; i++){
					$("#crenting").append("<option value="+data[i].roleid+">"+data[i].rolename+"</option>");
				}
			}
		})
	});
    </script>
</head>
<body>
<div class="panel admin-panel">
  <div class="panel-head"><strong><span class="icon-pencil-square-o"></span>修改用户信息</strong></div>
  <div class="body-content">
  <!-- form表单中的action  基本都跳转到controller中 -->
    <form method="post" class="form-x" action="userUpdate" enctype="multipart/form-data" >
    <!-- hidden前台页面不显示，代码里有 -->
    <input type="hidden" name="userid" value="${user.userid}" />

     <table>
			<tr>
				<td width="100px">登陆名</td>
				<td width="300px"> <input type="text" name="username" id="cuserName" value="${user.username}" class="required" /> * </td>
				<td width="100px">身份证</td>
				<td width="300px"> <input type="text" name="identity" id="cidentity" value="${user.identity}" class="required" /> * </td>
			</tr>
			<tr>
				<td>用户密码</td>
				<td> <input type="text" name="userpwd" id="cuserPassword" value="${user.userpwd}"  class="required" />  </td>
				<td>联系电话</td>
				<td> <input type="text" name="phone" id="cphone"value="${user.phone}" class="required" /> * </td>
			</tr>
			<tr>
				<td>地址</td>
				<td> <input type="text" name="address" id="uaddress" value="${user.address}"/> </td>
				<td>性别</td>
				<td>
					<c:if test="${user.sex eq '男'}">
						<select name="sex">
 							<option value="男" selected="selected">男</option>
 							<option value="女">女</option>
						</select>
					</c:if>
					<c:if test="${user.sex eq '女'}">
						<select name="sex">
 							<option value="男" >男</option>
 							<option value="女" selected="selected">女</option>
						</select>
					</c:if>
				 * </td>
			</tr>

			<tr>
				<td>真实姓名</td>
				<td> <input type="text" name="realname" id="crealname" value="${user.realname}" class="required" /> * </td>
				<td>职位</td>
				<td> <input type="text" name="position" id="uposition"  value="${user.position}"/></td>
			</tr>
			<tr>
				<td>角色</td>
				<td>
					<select name="roleid" id="crenting">
					</select>
				</td>
				<td></td>
				<td></td>
			</tr>
		</table>
        <div class="field">
          <button class="button bg-main icon-check-square-o" type="submit" id="dataSub"> 提交</button>
        </div>
    </form>
  </div>
</div>
</body></html>