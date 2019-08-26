<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>票务界面</title>
</head>
<body>
 <table border="solid 1px">
  <th></th><th>票务名</th><th>持有人</th><th>价格</th><th>日期</th><th>日期</th>
  <c:forEach items="${tickets}" var="item">
    <tr>
    <form action="/ticket/delete" method="post">
      <td><input type="checkbox" id="${item.tId}"></td><td>${item.tName}</td><td>${item.tUser}</td><td>${item.tPrice}</td><td>${item.tDate}</td><td><input type="submit" value="删除"></td>
   </form>
    </tr>
  </c:forEach>
 </table>
</body>
</html>