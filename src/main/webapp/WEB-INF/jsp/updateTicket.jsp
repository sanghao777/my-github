<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.util.*"%>
    <%@page import="java.text.SimpleDateFormat"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<%
		Date d = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String now = df.format(d);
	%>
<head>

<meta charset="UTF-8">
<title>票务修改</title>
</head>
	
<body>
   <table>
      <form>
         <tr><td>票种类：</td><td><input type="text" name="tName" id="tName" value=""></td></tr>
         <tr><td>持有人：</td><td><input type="text" name="tUser" id="tUser" value=""></td></tr>
         <tr><td>日期：</td><td><input type="text" name="tDate"  id="tDate" value="<%=now %>"></td></tr>
         <tr><td>价格：</td><td><input type="text" name="tPrice" id="tPrice" value=""></td></tr>
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