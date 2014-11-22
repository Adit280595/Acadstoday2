<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="../menu.js" ></script>
<link rel="stylesheet" type="text/css" href="./style.css" media="screen" />
<title>Insert title here</title>
</head>
<body>
<div style="width:1200px;height:308px">
<div style="float:left; margin-left:100px;width:870px">
<img src="./image.jpg" width="800" height="308" alt="Login">
</div>
 <div style="background-color:black; color:white; margin-left:100px;padding:20px;">
<h2><br><br>ACADS TODAY<br><br></h2>

<p>
Your Helper To a Better Course Selection.
<br>
</p>
<br>
<br>
<br>
</div> 
</div>
<div style="float:left;margin-left:100px;width:1100px">
<div style="float:left;width:435px">
<ul class="navmenu">
  <li><a href="./home.jsp">HOME</a></li>
  <li><a href="./course" accesskey="1">COURSE</a></li>
  <li><a href="./instructor">INSTRUCTOR</a></li>
  <li><a>SEARCH</a><ul>
   <li><a href="./Search?type=students">Students</a></li>
   <li><a href="./Search?type=newsfeed">NewsFeed</a></li>
  </ul></li>
  <li><a href="/tl5">TIMELINE</a></li>
</ul>

</div>
<div style="text-align: right;color: green;">
<form  method="get" action="Validateuser">
<input type="submit" value="Logout" style="color:green;border:thin;cursor: pointer;background-color:yellow ">
<input type="hidden" name="SignUp" value="logout">
</form>
</div>
<p style="color:black;font:italic;"><i><b>Hello <%=session.getAttribute("Username") %> !</b></i></p>
 
 </div>

 
 </body>
</html>