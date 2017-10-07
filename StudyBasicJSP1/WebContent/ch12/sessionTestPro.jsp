<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<%
String id = request.getParameter("id");
String passwd = request.getParameter("passwd");

session.setAttribute("id", id);
session.setAttribute("passwd",passwd);
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
id 와 passwd 세션 속성을 설정하였습니다. <br>
id속성의 값은 <%=(String)session.getAttribute("id") %> 이고 <br>
passwd 속성의 값은 <%=(String)session.getAttribute("passwd") %> 입니다.
</body>
</html>