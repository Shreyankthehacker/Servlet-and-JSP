<%@page import="packages.A"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import = "java.util.Date" extends = "packages.B" errorPage="error.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
String name = "Shreyank";
out.println(new Date());
//out.println(A.show()/0);
out.println(s);
pageContext.setAttribute("name",name,pageContext.SESSION_SCOPE);

%>
<h1>
welcome ${name}
<br>
<%=s %></h1>
</body>
</html>