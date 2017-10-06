<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<% request.setCharacterEncoding("UTF-8"); %>

<%  
    String id=request.getParameter("id");
	String name=request.getParameter("name");
	String passwd=request.getParameter("pass");
	Timestamp register = new Timestamp(System.currentTimeMillis());
	
	   Connection conn = null;
	   PreparedStatement pstmt=null;
	   ResultSet rs = null;
	   	   
	   try {
	   String jdbcUrl = "jdbc:mysql://localhost:3306/basicjsp";
	   String dbId="jspid";
	   String dbPass="jsppass";
	   
	   Class.forName("com.mysql.jdbc.Driver");
	   conn = DriverManager.getConnection(jdbcUrl,dbId,dbPass);
	  
	   String sql="select id,passwd from member where id=?";
	   pstmt=conn.prepareStatement(sql);
	   pstmt.setString(1,id);
	   rs=pstmt.executeQuery();
	   
	   if(rs.next()){
		   String rId=rs.getString("id");
		   String rPasswd=rs.getString("passwd");
		   if(id.equals(rId) && passwd.equals(rPasswd)){
			   sql = "update member set name=? where id=?";
			   pstmt=conn.prepareStatement(sql);
			   pstmt.setString(1,name);
			   pstmt.setString(2,id);
			   pstmt.executeUpdate();
		   

		   

%>
<html>

<head>
<title>레코드 수정</title>
</head>
<body>
member 테이블의 레코드를 수정했습니다.
</body>
</html>
<% 
	   }else
		   out.println("패스워드가 틀렸습니다.");
	   }else
		   out.println("아이디가 틀렸습니다.");
	   
	   }catch(Exception e){
	    e.printStackTrace();
	   
	   }finally{
		   if(rs!=null){
			   try{rs.close();}catch(SQLException sqle){}
		   
		    }
		   if(pstmt!=null){
			   try{pstmt.close();}catch(SQLException sqle){}
		   
		    }
			   
		   if(conn!=null){
			   try{conn.close();}catch(SQLException sqle){}
		    }
	   }
	  
%>