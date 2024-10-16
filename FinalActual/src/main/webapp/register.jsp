<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="debug.BeanUtils" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Register</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>

<jsp:useBean id = "reg" class = "Bean.RegisterBean" scope = "request"></jsp:useBean>

<jsp:useBean id = "regdao" class = "Dao.RegisterDao"></jsp:useBean>
<jsp:useBean id = 'sqlbean' class = "sql.ConnectionProvider"></jsp:useBean>


 
<jsp:setProperty name = "reg"  property = "*" />
<% String message= regdao.save(reg);
out.println("<h1>" + message + "</h1>");

%>


      
<jsp:forward page="welcome.jsp"></jsp:forward>      
</body>
</html>

