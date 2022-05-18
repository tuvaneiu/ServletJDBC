<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" errorPage="error.jsp"%>
<%@page import="java.util.*"%>
<%@page import="com.model.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Employee Page</title>
</head>
<body>
	<h2>All Employees</h2>
	
	<%
		ArrayList<Employee> employeeList = (ArrayList<Employee>) request.getAttribute("employeeList");
		for(Employee employee : employeeList){
		%>
			<hr>
			<p>Employee ID: <%=employee.getEmployeeId()%></p>
			<p>Name: <%=employee.getFirstName()%> <%=employee.getLastName()%></p>
			<p>Phone: <%=employee.getPhone()%></p>
			<p>Email: <%=employee.getEmail()%></p>
			<p>Date of birth: <%=employee.getDateOfBirth()%></p>
			<br>
			<a href="DeleteEmployeeServlet?id=<%=employee.getId()%>">Delete</a>
			<a href="UpdateEmployeeServlet?id=<%=employee.getId()%>">Update</a>
		<%
		}
	%>
</body>
</html>