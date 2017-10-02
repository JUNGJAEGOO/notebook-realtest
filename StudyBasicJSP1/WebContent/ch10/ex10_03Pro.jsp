<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>좋아하는 숫자 출력</title>
</head>
<body>
<jsp:useBean id="exBean" class="ch10.bean.exbean">
<jsp:setProperty property="id" name="exBean"/>
<jsp:setProperty property="passwd" name="exBean"/>
<jsp:setProperty property="numb" name="exBean"/>
</jsp:useBean>

<h2>입력한 정보 표시</h2>
아이디 : <jsp:getProperty property="id" name="exBean"/> <br>
패스워드 : <jsp:getProperty property="passwd" name="exBean"/> <br>
좋아하는 숫자 : <jsp:getProperty property="numb" name="exBean"/> <br> 
</body>
</html>