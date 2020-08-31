<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%
	String dri = "com.mysql.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/dxc?autoReconnect=true&relaxAutoCommit=true";
	String un = "root";
	String pw = "root";
	try {
		Class.forName(dri);
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	}
	Connection connection = null;
	Statement statement = null;
	ResultSet resultSet = null;
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Marks</title>
</head>
<body>
<h1>Marks</h1>
		<table border="2">
			<tr>
				<td>ID</td>
				<td>Name</td>
				<td>Sub1</td>
				<td>Sub2</td>
				<td>Sub3</td>
				<td>Total</td>
				<td>Actions</td>

			</tr>
			<%
				try {
					connection = DriverManager.getConnection(url, un, pw);
					statement = connection.createStatement();
					String sql = "select * from mark";
					resultSet = statement.executeQuery(sql);
					while (resultSet.next()) {
			%>
			
			<tr>
				<td><%=resultSet.getInt("id")%></td>
				<td><%=resultSet.getString("name")%></td>
				<td><%=resultSet.getInt("sub1")%></td>
				<td><%=resultSet.getInt("sub2")%></td>
				<td><%=resultSet.getInt("sub3")%></td>
				<td><%=resultSet.getInt("total")%></td>
				<td>
                        <a href="/edit?id=<c:out value='${book.id}' />">Edit</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="/delete?id=<c:out value='${book.id}' />">Delete</a>                     
                </td>
			</tr>

			<%
				}
					connection.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			%>
		</table>
		<br></br>
		<a href="AddMark.jsp">Add New Student Marks </a>
		
</body>
</html>