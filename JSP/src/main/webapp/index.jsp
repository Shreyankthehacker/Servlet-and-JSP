<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="math.tld" prefix = "maths" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<input type="number" id="num1" placeholder="Enter first number" required>
        <input type="number" id="num2" placeholder="Enter second number" required>
        <button type="submit">Get Sum</button>
<%
String n1 = request.getParameter("n1");
String n2 = request.getParameter("n2");
int sum = Integer.parseInt(n1)+Integer.parseInt(n2);
%>
<maths:sum num1="<%=n1%>" num2 = "<%=n2 %>"/>

</body>
</html>