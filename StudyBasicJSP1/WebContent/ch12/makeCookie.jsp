<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
String cookieName = "id";
Cookie cookie = new Cookie(cookieName,"hongkd");
cookie.setMaxAge(5*2);
response.addCookie(cookie);
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>쿠키 생성</title>

</head>
<body>
<h2>쿠키를 생성하는 페이지</h2>
"<%=cookie.getName()%>" 쿠키가 생성 되었습니다.
<form method="post" action="useCookie.jsp">
<input type="submit" value="생성된 쿠키 확인">
</form>
</body>
</html>