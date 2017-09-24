<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Request 내장객체 예제</title>
</head>
<body>
<h3>학번, 이름, 학년, 선택과목을 입력하는 폼</h3>
<hr>

<form method="post" action="requestTestPro.jsp">
학번 : <input type="text" name="학번"> <br>
이름 : <input type="text" name="이름"> <br>
학년 : <input type="radio" name="학년" value="1">1학년
     <input type="radio" name="학년" value="2">2학년
     <input type="radio" name="학년" value="3">3학년
     <input type="radio" name="학년" value="4">4학년
     <input type="radio" name="학년" value="5">5학년
     <input type="radio" name="학년" value="6">6학년
     <br>
 선택과목 : <select name="과목">
 <option value="JAVA">JAVA</option>
 <option value="JSP">JSP</option>
 <option value="XML">XML</option>
 </select><br>
<input type="submit" value="전송">
</form><br>

<button type="button" onclick="location.href='requestTestPro.jsp'">앞으로 가기</button>


</body>
</html>