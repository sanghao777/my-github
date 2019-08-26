<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link href="/css/reg.css" type="texr/css" rel="stylesheet">
<title>注册页面</title>
</head>
<body>
 <div id="regist" >
  <fieldset>
     <legend>请注册</legend>
   <form action="" method="post">
      用户：<input type="text" name="username" id="username" value="" onblur="checkUser()">
      <div id="resultmsg1" style="display:inline"></div><br>
      密码：<input type="password" name="password" id="pwd" value="" >
      <div id="resultmsg2" style="display:inline"></div><br>
      手机：<input type="text" name="phone" id="phone" value=""><br>
        验证码：<input type="text" name="code" style="width:80px;height:35px;" > 
        <img id="img" src="/getImage" align="middle" style="margin-top:-10px;"> <br> 
        <a href="" onclick="changeImg()" style="font-size:12px;color:red;margin-left:156px;">看不清,换一个</a><br>
        <input type="button" value="提交" onclick="check()">
   </form>
   </fieldset>
   </div>
</body>
</html>
<script>
 function check(){
	 if(document.getElementById("username").value==""||document.getElementById("pwd").value==""){
		 alert("用户名或密码不能为空");
	 }else{
		    document.forms[0].action="/user/checkreg";
		 	document.forms[0].submit(); 
	 }
	 
 }
	function  checkUser(){
		var uri ="/user/check.do?"+Math.random();//用于发起不同请求设置。
		ajaxByXML(uri);
	}
	//1.创建一个请求对象XMLHttpRequest.
	
	var  xmlHttpRequest;
	function ajaxCreate(){
		if(window.ActiveXObject){
			xmlHttpRequest = new ActiveXObject("Microsoft.XMLHTTP");
		}else if(window.XMLHttpRequest){
			xmlHttpRequest = new XMLHttpRequest();
		}
	}
	//2.设置xml请求对象的属性。
	
	function ajaxByXML(uri){
		ajaxCreate()//创建一个异步请求对象。
		var method = "post";//"get"方法。
		var url = uri;//请求的URL
		  var username=document.getElementById("username").value;
		 if(username==""){
			 document.getElementById("resultmsg1").innerHTML="<font color=red>用户名不能为空</font>";
		 }else{
			    xmlHttpRequest.open(method,url,true);//打开数据访问通道。true为异步调用，false为同步调用。
				xmlHttpRequest.setRequestHeader("Content-Type","application/x-www-form-urlencoded;charset=UTF-8");
				xmlHttpRequest.send("username="+username);//传递参数的方法 。""
				xmlHttpRequest.onreadystatechange=callBack;//回调函数属性设置 为callBack方法 。 
		 }
		
		//alert(xmlHttpRequest);
	}
	//3.回调函数的操作过程设置 。
	
	function   callBack(){
		if(xmlHttpRequest.status==200&&xmlHttpRequest.readyState==4){
			//...
			document.getElementById("resultmsg1").innerHTML="<font color=red>"+xmlHttpRequest.responseText+"</font>";
		}
		
	}
	 function changeImg(){
	        var img = document.getElementById("img"); 
	        img.src = httpurl+"/getImage?date=" + new Date();
	    }
		 

 </script>