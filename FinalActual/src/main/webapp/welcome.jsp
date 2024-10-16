<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
Welome.jsp  
<jsp:useBean id = "reg" class = "Bean.RegisterBean" scope = "request"></jsp:useBean>
<jsp:getProperty name = "reg" property = "username"/>


</body>
</html>