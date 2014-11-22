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
<Script Language=JavaScript>

function getStats(fName){

fullName = fName;
shortName = fullName.match(/[^\/\\]+$/);
document.forms.Form1.dispName.value = shortName
}

</Script>
</head>
<body>

<jsp:include page="./coursereview_common.jsp" />
<br><br><br>
<form name="material" action="Add" method="post">
<div style="margin-left:400px;color:blue">
Browse your system to add a Material:<br><br>
</div>
<div style="margin-left:500px;">
<input type="file" name="uploadField" onChange="getStats(this.value)">
<br><br>
</div>
<div style="margin-left:400px;color:blue">
File Name for display:</div>
<div style="margin-left:450px;">
<input name='dispName' size=20><br><br>
<br><br>
</div>
<div style="margin-left:500px;">
<input type="submit" value="Upload">
</div>
<input type="hidden" name="type" value="course">
<input type="hidden" name="add" value="material">
</form>

</body>
</html>