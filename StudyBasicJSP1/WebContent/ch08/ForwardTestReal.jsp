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
<%String name = request.getParameter("id");
String hobby = request.getParameter("취미"); %>
<%="포워딩 되는 페이지 forwardTestReal.jsp 입니다."%><br>
<%=name+" 님의" %><br>
<%="취미는 "%> <b><%=hobby%></b> <%=" 입니다." %>

</body>
</html>