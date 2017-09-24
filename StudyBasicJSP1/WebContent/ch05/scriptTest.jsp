<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>scipt예제 </title>
</head>
<body>
<h2> 선언문, 스크립트릿, 표현식의 쓰임을 알아보는 예제</h2>
<%!
String str="전역 변수 입니다.";
%>

<%!
String gerStr(){
return str;
}%>

<% String str2="지역 변수 입니다."; %>

스크립트에서 선언한 변수 str2 는 <%=str2 %> <br>
선언문에서 선언한 변수 str 은 <%=str %> <br>
</body>
</html>