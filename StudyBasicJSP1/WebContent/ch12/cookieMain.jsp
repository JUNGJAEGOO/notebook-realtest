<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
String id = "";
try{
	Cookie[] cookies = request.getCookies();
	if(cookies!=null){
		for(int i = 0 ; i<cookies.length;i++){
			if(cookies[i].getName().equals("id")){
				id=cookies[i].getValue();
			}
		}
		if(id.equals("")){
			response.sendRedirect("cookieLoginForm.jsp");
		}
		
	}else{
		response.sendRedirect("cookieLoginForm.jsp");
	}
}catch(Exception e){
	e.printStackTrace();
}
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>쿠키를 사용한 간단한 회원인증</title>
</head>
<body>
<b> <%=id %> 님이 로그인 하셨습니다. </b>
<form method="post" action="cookieLogout.jsp">
<input type="submit" value="로그아웃">
</form>
</body>
</html>