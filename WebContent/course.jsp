<%@page import="java.sql.Connection"%>
<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<% 
response.setHeader("Cache-Control", "no-cache");
response.setHeader("Cache-Control", "no-store");
response.setHeader("Pragma", "no-cache");
response.setDateHeader("Expires", 0);
if(session.getAttribute("Username")==null){response.sendRedirect("login.jsp");}
%>
</head>
<body>
<jsp:include page="./Intro.jsp" />
<form action="course" method="get" style="float:left;margin-left:100px">
<div style="width:1200px">

<div style="float:left; margin-left:200px;width:200px">
Select the department:
</div>
<div style="float:left;margin-left:40px;width:300px">
	<%=session.getAttribute("departments") %>
</div>
<div style="margin-left:300px">
<input type="submit" value="Select">
<input type="hidden" name="select_dept" value="course">
</div>
</div>
</form>
<%=session.getAttribute("courses") %>
</body>
</html>