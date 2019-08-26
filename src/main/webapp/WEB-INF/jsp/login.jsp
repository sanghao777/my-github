<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="/css/login.css" rel="stylesheet" type="text/css">
<meta charset="UTF-8">
<title>登录入口</title>
</head>
<body>
  <div id="title"><h2>欢迎登录智慧旅游系统</h2></div>
  <div id="login">
   <table>
     <form>
       <tr><td>用户：<input type="text" name="username" id="username" placeholder="请输入用户名"></td></tr>
       <tr><td>密码：<input type="password" name="password" id="password" placeholder="请输入密码"></td></tr>
       <tr><td><input type="button" value="登录" onclick="login()"></td></tr>
       
     </form>
   </table>
   <a  href="#" id="regist" onclick="regist()">免费注册</a>
 </div>
</body>
</html>
<script>
var forms=document.getElementsByTagName("form");
 function login(){
	 forms[0].action="/user/validate";
	 forms[0].method="post";
	 forms[0].submit();
 }
 function regist(){
	 forms[0].action="/user/reg";
	 forms[0].method="post";
	 forms[0].submit();
 }
</script>