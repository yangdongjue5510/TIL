
<%--
  Created by IntelliJ IDEA.
  User: MUHN2-031
  Date: 2021/10/05
  Time: 5:04 오후
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="hello.servlet.domain.member.Member" %>
<%@ page import="hello.servlet.domain.member.MemberRepository" %>
<%
    //jsp는 request , response라고 해야 서블릿의 response, request로 인식!
    MemberRepository memberRepository = MemberRepository.getInstance();
    String username = request.getParameter("username");
    int age = Integer.parseInt(request.getParameter("age"));

    Member member = new Member(username, age);
    memberRepository.save(member);
    System.out.println(username +"저장완료");
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
성공
<ul>
    <li>id=<%=member.getId()%></li>
    <li>username=<%=member.getUsername()%></li>
    <li>age=<%=member.getAge()%></li>
</ul>
<a href = "/index.html">메인</a>
</body>
</html>
