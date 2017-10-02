<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%request.setCharacterEncoding("UTF-8"); %>

<jsp:useBean id="testBean" class="ch10.bean.Testbean">
<jsp:setProperty name="testBean" property="name"/>
</jsp:useBean>

<h2>자바빈을 사용하는 JSP페이지</h2>

입력된 이름은 <jsp:getProperty name="testBean" property="name"/> 입니다.