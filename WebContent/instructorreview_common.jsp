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
<br><br><br>
<div style="float:left;margin-left:125px; width: 1000px;padding: 25px;text-align: center;font-size: 200%;color:#68be23;border: 1px solid navy;border-radius:25px;background-color:#ffe4b5">
<b><%=session.getAttribute("instructor_name") %></b>
</div>
<div style="float:top;margin-top:160px">
<div style="float:left;margin-left:150px;">
<input type="button" value="Instructor Reviews" onClick="javascript:window.location='instructorreview.jsp';">
</div>
<div style="float:left;margin-left: 90px">
<input type="button" value="Add a Review" onClick="javascript:window.location='addinstructorreview.jsp';">
</div>
</div>
</body>
</html>