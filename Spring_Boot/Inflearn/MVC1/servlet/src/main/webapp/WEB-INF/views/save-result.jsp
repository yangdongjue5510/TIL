<%@ page import="hello.servlet.domain.member.Member" %>
<%--
  Created by IntelliJ IDEA.
  User: MUHN2-031
  Date: 2021/10/05
  Time: 5:04 오후
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
성공
<ul>
<%--    가능은 하지만 끔찍한 방식!!!!!!--%>
<%--    <li>id=<%= ((Member)request.getAttribute("member")).getId() %></li>--%>
<%--    <li>username=<%=((Member)request.getAttribute("member")).getUsername()%></li>--%>
<%--    <li>age=<%=((Member)request.getAttribute("member")).getAge()%></li>--%>

<%--    jsp에서 제공하는 프로퍼티 접근법 표현 방법--%>
    <li>id=${member.id}</li>
    <li>username=${member.username}</li>
    <li>age=${member.age}</li>
</ul>
<a href = "/index.html">메인</a>
</body>
</html>
