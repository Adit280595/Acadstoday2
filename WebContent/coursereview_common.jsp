<link rel="stylesheet" type="text/css" href="buttons.css">
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
String course_name=session.getAttribute("course_name").toString();
System.out.println(course_name);
if(session.getAttribute("Username")==null){response.sendRedirect("login.jsp");}
%>
</head>
<body>
<jsp:include page="./Intro.jsp" />
<br><br><br>
<div style="float:left;margin-left:125px; width: 1000px;padding: 25px;text-align: center;font-size: 200%;color:#68be23;border: 1px solid navy;border-radius:25px;background-color:#ffe4b5">
<b><%=session.getAttribute("course_name") %></b>
</div>
<br>

<div align="center" style="float:top;margin-top: 100px">
	<form action="course" method="get">
		<input type="submit"  class = "button" value=<%=session.getAttribute("follow")%>>
		<input type="hidden" name="select_dept" value="follow">
	</form>
</div>
<div style="float:top;margin-top:60px">
<div style="float:left;margin-left:150px;">
<form action="course" method="get">
<input type="submit"  value="Course Reviews">
<input type="hidden" name="select_dept" value="course_page">
<input type="hidden" name="Courses" value="deepanjan">
</form>
</div>

<div style="float:left;margin-left: 90px">
<form action="course" method="get">
<input type="submit"  value="Course Material">
</form>
</div>

<div style="float:left;margin-left: 90px">
<input type="button" value="Add a Review" onClick="javascript:window.location='addcoursereview.jsp';">
</div>

<div style="float:left;margin-left: 90px">
<input type="button" value="Add a material" onClick="javascript:window.location='addMaterial.jsp';">

</div>

<div style="float:left;margin-left: 90px">
<input type="button" value="Post a News" onClick="javascript:window.location='postnews.jsp';">
</div>


</div>
</html>