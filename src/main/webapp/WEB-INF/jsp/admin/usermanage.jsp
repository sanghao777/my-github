<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>用户界面</title>
</head>
<body>
 <table border="solid 1px">
  <th></th><th>用户名</th><c:if test="${param.show==1}"><th>联系方式</th><th>用户类型</th><th>创建日期</th></c:if>
  <c:forEach items="${users}" var="item">
    <tr>
      <td><input type="checkbox" id="${item.id}"></td><td>${item.username}</td><c:if test="${param.show==1}"><td>${item.phone}</td><td>${item.userClass}</td><td>${item.created}</td></c:if>
    </tr>
  </c:forEach>
 </table>
</body>
</html>