$(function(){
/* 价格验证 */
$("#cprice,#crentprice,#cdeposit").blur(function(){
	var reg = /^[0-9\.]*$/;
	var $parent = $(this).parent();
	var content = $(this).val();
	if(content==""){
		$parent.children("span").remove();
		$parent.append("<span class='formtips'>不能为空</span>");
	}else if(!content.match(reg)){
		$parent.children("span").remove();
		$parent.append("<span class='formtips'>必须为数字</span>");
	}else{
		$parent.children("span").remove();
	}
});

/* 身份证验证 */
$("#cidentity").blur(function(){
	var regex = /(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/;
	var $parent = $(this).parent();
	var content = $(this).val();
	if(content==""){
		$parent.children("span").remove();
		$parent.append("<span class='formtips'>不能为空</span>");
	}else if(!content.match(regex)){
		$parent.children("span").remove();
		$parent.append("<span class='formtips'>未知身份证号</span>");
	}else{
		$parent.children("span").remove();
	}
});

/* 电话号码验证  */
$("#cphone").blur(function(){
	var regex = /^1[34578]\d{9}$/;
	var $parent = $(this).parent();
	var content = $(this).val();
	if(content==""){
		$parent.children("span").remove();
		$parent.append("<span class='formtips'>不能为空</span>");
	}else if(!content.match(regex)){
		$parent.children("span").remove();
		$parent.append("<span class='formtips'>未知电话号码</span>");
	}else{
		$parent.children("span").remove();
	}
});

/* 用户名英文或数字  */
$("#cuserName,#cuserPassword").blur(function(){
	var regex = /^[0-9a-zA-Z]*$/;
	var $parent = $(this).parent();
	var content = $(this).val();
	if(content==""){
		$parent.children("span").remove();
		$parent.append("<span class='formtips'>不能为空</span>");
	}else if(!content.match(regex)){
		$parent.children("span").remove();
		$parent.append("<span class='formtips'>英文或数字</span>");
	}else{
		$parent.children("span").remove();
	}
});

/* 车号,车型，车品牌非空验证  */
$("#ccarNumber,#ccarType,#ccarBrand,#crealname,#ccustName,#crealPay").blur(function(){
	var $parent = $(this).parent();
	var content = $(this).val();
	if(content==""){
		$parent.children("span").remove();
		$parent.append("<span class='formtips'>不能为空</span>");
	}else{
		$parent.children("span").remove();
	}
});

/* 租车起始时间，截止时间  非空且起始<截止*/
$("#priceShouldPay").blur(function(){
	var $parent = $(this).parent();
	var content = $(this).val();
	if(content==""){
		$parent.children("span").remove();
		$parent.append("<span class='formtips'>出租天数大于0</span>");
	}else{
		$parent.children("span").remove();
	}
})

$("#ccarNumber,#ccarType,#ccarBrand,#crealname,#ccustName,#crealPay").blur(function(){
	var $parent = $(this).parent();
	var content = $(this).val();
	if(content==""){
		$parent.children("span").remove();
		$parent.append("<span class='formtips'>不能为空</span>");
	}else{
		$parent.children("span").remove();
	}
});


/* 提交前验证所有是否合乎规则 */
$("#dataSub").click(function(){
	$("form :input.required").trigger("blur");
	var numError = $(".formtips").length;
		if(numError){
			return false;
		}
	});
})