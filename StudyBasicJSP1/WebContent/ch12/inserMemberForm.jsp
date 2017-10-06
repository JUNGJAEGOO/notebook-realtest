<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원가입</title>
</head>
<body>
<h2>회원가입 폼</h2>
<form method="post" action="insertMemberPro.jsp">
아이디 : <input type="text" name="id" maxlength="50"> <br>
비밀번호 : <input tpye="password" name="passwd" maxlength="16"> <br>
이름 : <input tpye="text" name="name" maxlength="10">
<input type="submit" value="회원가입">
<input type="reset" value="다시입력">
</form>
</body>
</html>