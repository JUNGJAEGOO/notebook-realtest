<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<%@ page import="ch12.member.LogonDBBean" %>

<%

String id = request.getParameter("id");
String passwd = request.getParameter("passwd");

LogonDBBean logon = LogonDBBean.getInstance();
int check = logon.userCheck(id, passwd);

if( check == 1){
	session.setAttribute("id", id);
	response.sendRedirect("sessionMain.jsp");
}
else if(check == -1){
	%>
	<script>
	alert("해당 아이디는 존재하지 않습니다.");
	history.go(-1);
	</script>
	<% 
}
else if(check == 0){
	%>
	<script>
	alert("비밀번호를 재확인 하세요.");
	history.go(-1);
	</script>
	<%
}

%>



<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>