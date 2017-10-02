<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%request.setCharacterEncoding("UTF-8"); %>
</head>
<body>
<%
String name = request.getParameter("NAME");
String page2 = request.getParameter("PAGE");
%>

<%
String str="포함되는 페이지 "+page2+".jsp 입니다.";
%>
<%=str %> <br>
<b> <%=name%> </b> <%="님 오셨구려" %> <br>
</body>
</html>