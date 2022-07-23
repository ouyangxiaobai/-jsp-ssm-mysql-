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
</head>
<body>
<div class="panel admin-panel">
  <div class="panel-head"><strong><span class="icon-pencil-square-o"></span>修改汽车信息</strong></div>
  <div class="body-content">
    <form method="post" class="form-x" action="updateCarHandler" enctype="multipart/form-data" >
    <input type="hidden" name="carId" value="${car.carid}" /> 
      <table>
			<tr>
				<td width="100px">车号</td>
				<td width="300px"> <input type="text" name="number"  id="ccarNumber" value="${car.number}" class="required" />* </td>
				<td width="100px">汽车型号</td>
				<td width="300px"> <input type="text" name="type" id="ccarType" value="${car.type}" class="required" /> * </td>
			</tr>
			<tr>
				<td>颜色</td>
				<td> <input type="text" name="color" id="ccolor" value="${car.color}"/> </td>
				<td>价值</td>
				<td> <input type="text" name="price" id="cprice" value="${car.price}" class="required"/> * </td>
			</tr>
			<tr>
				<td>租金</td>
				<td> <input type="text" name="rentprice" id="crentprice" value="${car.rentprice}" class="required"/> * </td>
				<td>押金</td>
				<td> <input type="text" name="deposit" id="cdeposit" value="${car.deposit}" class="required"/>* </td>
			</tr>
			<tr>
				<td>租用情况</td>
				<td>
					<select name="isrenting" id="crenting">
						<c:if test="${car.isrenting eq 0}" >
							<option value="0" selected="selected" >未出租</option>
							<option value="1">已出租</option>
						</c:if>
						<c:if test="${car.isrenting eq 1}" >
							<option value="0" >未出租</option>
							<option value="1"  selected="selected">已出租</option>
						</c:if> 
					</select>
				</td>
				<td width="100px">汽车品牌</td>
				<td> <input type="text" name="brand" id="ccarBrand" value="${car.brand}" class="required" /> * </td>
			</tr>
			<tr>
				<td>上传汽车图片</td>
				<td colspan="3"> <input type="file" name="imgFile" id="cimg" /> </td>
			</tr>
			<tr>
				<td>简介</td>
				<td colspan="3">
				<div class="form-group">
        		<div class="field">
         		<textarea name="description" class="input" style="height:120px;">${car.description}</textarea>
        		</div>
      			</div>
      		</td>
			<tr>
		</table>
      <div class="form-group">
        <div class="label">
          <label></label>
        </div>
        <div class="field">
          <button class="button bg-main icon-check-square-o" type="submit" id="dataSub"> 提交</button>
        </div>
      </div>
    </form>
  </div>
</div>
</body></html>