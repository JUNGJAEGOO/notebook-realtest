<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="ch12.member.LogonDBBean" %>

<%request.setCharacterEncoding("UTF-8"); %>

<jsp:useBean id="member" class="ch12.member.LogonDataBean">
	<jsp:setProperty name="member" property="*"/>
</jsp:useBean>	

<% 

member.setReg_date(new Timestamp(System.currentTimeMillis()) );
LogonDBBean logon = LogonDBBean.getInstance();
logon.insertMember(member);

%>

<jsp:getProperty property="id" name="member"/> 님의 회원가입을 축하 드립니다.

<form method="post" action="inserMemberForm.jsp">
<input type="submit" value="처음으로 가기">
</form>
