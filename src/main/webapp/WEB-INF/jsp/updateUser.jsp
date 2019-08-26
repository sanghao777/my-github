<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link href="/css/updateUser" rel="stylesheet" type="text/css"> 
<meta charset="UTF-8">
<title>用户修改</title>
</head>
<body>
   <table>
      <form>
         <tr><td>用户：</td><td><input type="text" name="username" id="username" value="${sessionScope.user.username }"></td></tr>
         <tr><td> 密码：</td><td><input type="password" name="password" id="password" value=""></td></tr>
         <tr><td>确认密码：</td><td><input type="password" name="confpwd"  id="confpwd" value=""></td></tr>
         <tr><td>手机：</td><td>${user.phone }</td></tr>
         <tr><td>用户类型：</td><td>管理员</td></tr>
         <tr><td><input type="button" onclick="userForm()" value="提交"></td></tr>
     </form>
   </table>
</body>
</html>
<script>
  function userForm(){
	  var forms=document.getElementsByTagName("form");
	  forms[0].action="/user/update";
	  forms[0].method="post";
	  forms[0].submit();
  }
</script>