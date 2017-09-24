<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Request 내장객체 예제</title>
<%request.setCharacterEncoding("utf-8"); %>
</head>
<body>
<h3>학생정보 </h3>
<hr>
<%
String name = request.getParameter("이름");
String num = request.getParameter("학번");
String grade = request.getParameter("학년");
String sub = request.getParameter("과목");
%>
<table border="1">

<tr>
<td>학번</td>
<td><%=num%></td>
</tr>

<tr>
<td>이름</td>
<td><%=name%></td>
</tr>

<tr>
<td>학년</td>
<td><%=grade%></td>
</tr>

<tr>
<td>선택과목</td>
<td><%=sub%></td>
</tr>

</table><br>
<button type="button" onclick="location.href='requestTestForm.jsp'">뒤로 가기</button>
</body>
</html>