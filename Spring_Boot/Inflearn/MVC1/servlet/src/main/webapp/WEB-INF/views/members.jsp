<%--
  Created by IntelliJ IDEA.
  User: MUHN2-031
  Date: 2021/10/05
  Time: 11:22 오후
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--JSTL 태그 라이브러리 임포트~!--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
  <meta charset="UTF-8">
  <title>Title</title>
</head>
<body>
<a href="/index.html">메인</a>
<table>
  <thead>
  <th>id</th>
  <th>username</th>
  <th>age</th>
  </thead>
  <tbody>
    <c:forEach var="item" items="${members}">
        <tr>
          <td>${item.id}</td>
          <td>${item.username}</td>
          <td>${item.age}</td>
        </tr>
    </c:forEach>
  </tbody>
</table>
</body>
</html>
