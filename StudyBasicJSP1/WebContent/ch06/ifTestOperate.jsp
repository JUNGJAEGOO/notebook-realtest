<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>입력한 숫자만큼의 반복수행</h3><br>
<hr>
<%request.setCharacterEncoding("utf-8"); %>
<% 

String strName = request.getParameter("name");

int num = Integer.parseInt(strName);

int count = num;
%>

<table border="1">
<%
out.print("<thead>");
out.print("<tr>");
out.print("<th>글번호</th>");
out.print("<th>글제목</th>");	
out.print("<th>글내용</th>");
out.print("</tr>");
out.print("</thead>");
out.print("<tbody>");
while ( count > 0){
out.println("<tr>");
out.println("<td>"+count+"</td>");
out.println("<td>"+"제목"+count+"</td>");
out.println("<td>"+"내용"+count+"</td>");
out.println("</tr>");
count--;
}
out.print("</tbody>");
out.print("</table>");
%>	
<hr>


</body>
</html>