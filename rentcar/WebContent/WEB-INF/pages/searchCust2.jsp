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
<meta name="renderer" content="webkit">
<title>添加新客户信息</title>
<base href="<%=basePath %>">
<link rel="stylesheet" href="css/pintuer.css">
<link rel="stylesheet" href="css/admin.css">
<script src="js/jquery.js"></script>
<script src="js/pintuer.js"></script>
<style type="text/css">
	table{
   		border:1px solid #cccccc;
   		width: 80%;
   		margin: 50px auto;
   	}
   	input[disabled],input:disabled{
   		background-color:#FFFACD;
   	}
   	td{
   		border:1px solid #cccccc;
   		padding:10px;
   	}
   	.info{
   		border:none;
   	}
</style>
<script type="text/javascript">
	$(function() {
		$("#tab-select-custs tr:not(:first)").remove(); 
		var c1 = null;
		var c2 ="<tr ><td >客户编号</td><td>客户姓名</td><td >密码</td><td >性别</td><td >身份证号</td>"+
		"<td >手机电话</td><td >职业</td><td >住址</td><td colspan='2' style='width:500px'>操作</td></tr>";
		$.ajax({
			type : "post",
			url : "findCusts",
			data:{"name":$("#search-name").val(),
				"identity":$("#search-identity").val()},
			dataType : "json",
			success : function(custs) {
				$("#tab-select-custs").append(c2);
				if(custs!=null){
					for(var i=0;i<custs.length;i++){
						c1 = "<tr ><td><input type='text' id='cid' style='width:60px' class='info' disabled='true' value='"+custs[i].custId+"'/></td>"+ 
							"<td > <input type='text' id='cname' style='width:60px'   class='info'   disabled='true'  value='"+custs[i].name+"'/> </td>" + 
							"<td > <input type='text' id='cpwd'  class='info'  disabled='true'  value='"+custs[i].pwd+"'/> </td>"+ 
							"<td > <input type='text' id='csex' class='info' style='width:60px'    disabled='true'  value='"+custs[i].sex+"'/> </td>"+ 
							"<td > <input type='text' id='cidentity'  class='info'   disabled='true' value='"+custs[i].identity+"'/> </td>"+ 
							"<td > <input type='text' id='cphone'  class='info'   disabled='true' value='"+custs[i].phone+"'/> </td>"+ 
							"<td > <input type='text' id='ccareer' style='width:60px'   class='info'   disabled='true' value='"+custs[i].career+"'/> </td>"+ 
							"<td > <input type='text' id='caddress' class='info'   disabled='true'  value='"+custs[i].address+"'/> </td>"+  
							"<td > <input type='button' id='sub-deletecust' class='sub-deletecust'  value='删除' onclick='deleteTr("+this+")' /> </td>"+  
							"<td > <input type='button' id='sub-updatecust' class='sub-updatecust' value='修改'/> </td></tr>" 
						$("#tab-select-custs").append(c1);
					} 
				}
			}
		})
		
		
		
		var flagUpdateBtn = 0;
		$("#sub-search").click(function() {
			$("#tab-select-custs tr").remove(); 
			var content = null;
			var content2 ="<tr ><td >客户编号</td><td>客户姓名</td><td >密码</td><td >性别</td><td >身份证号</td>"+
			"<td >手机电话</td><td >职业</td><td >住址</td><td colspan='2' style='width:500px'>操作</td></tr>";
			$.ajax({
				type : "post",
				url : "findCusts",
				data:{"name":$("#search-name").val(),
					"identity":$("#search-identity").val()},
				dataType : "json",
				success : function(custs) {
					$("#tab-select-custs").append(content2);
					if(custs!=null){
						for(var i=0;i<custs.length;i++){
							content = "<tr ><td><input type='text' id='cid' style='width:60px' class='info' disabled='true' value='"+custs[i].custId+"'/></td>"+ 
								"<td > <input type='text' id='cname' style='width:60px'   class='info'   disabled='true'  value='"+custs[i].name+"'/> </td>" + 
								"<td > <input type='text' id='cpwd'  class='info'  disabled='true'  value='"+custs[i].pwd+"'/> </td>"+ 
								"<td > <input type='text' id='csex' class='info' style='width:60px'    disabled='true'  value='"+custs[i].sex+"'/> </td>"+ 
								"<td > <input type='text' id='cidentity'  class='info'   disabled='true' value='"+custs[i].identity+"'/> </td>"+ 
								"<td > <input type='text' id='cphone'  class='info'   disabled='true' value='"+custs[i].phone+"'/> </td>"+ 
								"<td > <input type='text' id='ccareer' style='width:60px'   class='info'   disabled='true' value='"+custs[i].career+"'/> </td>"+ 
								"<td > <input type='text' id='caddress' class='info'   disabled='true'  value='"+custs[i].address+"'/> </td>"+  
								"<td > <input type='button' id='sub-deletecust' class='sub-deletecust'  value='删除' onclick='deleteTr("+this+")' /> </td>"+  
								"<td > <input type='button' id='sub-updatecust' class='sub-updatecust' value='修改'/> </td></tr>" 
							$("#tab-select-custs").append(content);
						} 
						
						$("input#sub-deletecust").click(function(){
							$.ajax({
								type : "post",
								url : "deleteCustomer",
								dataType : "json",
								data : {
									"custId" : $(this).parents("tr").children().eq(0).eq(0).children().attr("value")
								},
								success : function(data) {
									
									
									
									//location.href = "searchCust";
									if (data.flag == "ok") {
										alert("删除成功!");
										//location.href = "searchCust";
									} else if (data.flag == "error") {
										alert("删除失败!");
									}
								}
							}); 
							
							$(this).parents("tr").remove();
						});
						
						
			     		
							
							
						// 更新某一条数据
						$("input#sub-updatecust").click(function() {
							//alert($("#sub-updatecust").parent().attr("id"));
							if(flagUpdateBtn==0){
								flagUpdateBtn +=1;
								$(this).parents("tr").children().eq(1).eq(0).children().attr("disabled",false);
								$(this).parents("tr").children().eq(2).eq(0).children().attr("disabled",false);
								$(this).parents("tr").children().eq(3).eq(0).children().attr("disabled",false);
								$(this).parents("tr").children().eq(4).eq(0).children().attr("disabled",false);
								$(this).parents("tr").children().eq(5).eq(0).children().attr("disabled",false);
								$(this).parents("tr").children().eq(6).eq(0).children().attr("disabled",false);
								$(this).parents("tr").children().eq(7).eq(0).children().attr("disabled",false);
								$(this).attr("value","继续");
							}else{
								
								flagUpdateBtn=0;
								
								$(this).parents("tr").children().eq(1).eq(0).children().attr("disabled",true);
								$(this).parents("tr").children().eq(2).eq(0).children().attr("disabled",true);
								$(this).parents("tr").children().eq(3).eq(0).children().attr("disabled",true);
								$(this).parents("tr").children().eq(4).eq(0).children().attr("disabled",true);
								$(this).parents("tr").children().eq(5).eq(0).children().attr("disabled",true);
								$(this).parents("tr").children().eq(6).eq(0).children().attr("disabled",true);
								$(this).parents("tr").children().eq(7).eq(0).children().attr("disabled",true);
								$(this).attr("value","修改");
								
						 	  $.ajax({
						 		  
									type : "post",
									url : "updateCustomer",
									dataType : "json",
									data : {
										"custId" : $(this).parents("tr").children().eq(0 ).eq(0).children().val(),
										"name" : $(this).parents("tr").children().eq(1 ).eq(0).children().val(),
										"pwd" : $(this).parents("tr").children().eq(2 ).eq(0).children().val(),
										"sex" : $(this).parents("tr").children().eq(3 ).eq(0).children().val(),
										"identity" : $(this).parents("tr").children().eq(4 ).eq(0).children().val(),
										"phone" : $(this).parents("tr").children().eq(5 ).eq(0).children().val(),
										"career" : $(this).parents("tr").children().eq(6 ).eq(0).children().val(),
										"address" : $(this).parents("tr").children().eq(7 ).eq(0).children().val()
									},
									success : function(data) {
										
										if (data.flag == "list") {
											alert("更新成功!");
											location.href = "searchCust";
										} else if (data.flag == "error") {
											alert("更新失败!");
										}
									}
								});  
						 	  
						 	 alert("更新成功!"); 
							}
						});  
						}
					}
			});
		})
		
		
		
		
		
		
		
	});
			
</script>

</head>
<body >
	<div class="panel admin-panel">
		<div class="panel-head">
			<strong><span class="icon-pencil-square-o"></span> 查询客户信息</strong>
		</div>
		<div class="body-content">
			<div class="form-group">
				<div class="field" style="vertical-align: center;">
					用户名：<input type="text" id="search-name" class="inputadd"
						name="sub-search" value=""  /> &nbsp;&nbsp;
					身份证号：<input type="text" id="search-identity" class="inputadd"
						name="sub-search" value="" /> 
					<input type="submit" id="sub-search" class="sub-search" name="sub-search"
					 style="font-size: 20px; vertical-align: center;" value="查询" />
				</div>
			</div>
				<table id="tab-select-custs">
			</table>
		</div>
	</div>
</body>
</html>