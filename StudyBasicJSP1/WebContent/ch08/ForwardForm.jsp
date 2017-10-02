<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>forward 액션태그</h3>
<form method="post" action="ForwardTest.jsp">
아이디  : <input type="text" name="id"> <br>
취미 : <select name="취미">
<option value="WOW">WOW</option>
<option value="군단의 심장">군단의 심장</option>
<option value="디아블로3">디아블로3</option>
</select> <br>
<input type="submit" value="입력완료">
</form>



</body>
</html>