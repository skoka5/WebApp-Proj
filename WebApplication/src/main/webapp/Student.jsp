<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
<head>

<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Welcome to AJAX</h2>
	SL.NO :
	<select name="slno" onchange="fetchName(this.value)">
<option value="0">-- select --</option>
<%
ArrayList<Student> students = new StudentServiceImpl().findAll();
for (Student student : students){
	
}
%>

</body>
</html>