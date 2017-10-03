<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>레코드 수정</title>
</head>
<body>
<h2> member 테이블의 레코드 수정</h2>
<form method="post" action="updateTestPro.jsp">
아이디 : <input type="text" name="id" maxlength="50"> <br>
패스워드 : <input type="text" name="pass" maxlength="16"> <br>
변경할 이름 : <input type="text" name="name" maxlength="10"> <br>
<input type="submit" value="입력완료"> <br>
</form>
</body>
</html>