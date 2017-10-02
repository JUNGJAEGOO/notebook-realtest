<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
String str = "포함하는 페이지는 includedTest.jsp 입니다.";

%>
<%=str %>
<hr>
<jsp:include page="includedTest.jsp" flush="false"/>
<hr>
<%
out.println("includeTest.jps의 나머지 내용 입니다.");
%>
</body>
</html>