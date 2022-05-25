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
			int salaryId = employee.getSalary().getSalaryId();
		%>
			<hr>
			<p>Employee ID: <%=employee.getEmployeeId()%></p>
			<p>Name: <%=employee.getFirstName()%> <%=employee.getLastName()%></p>
			<p>Phone: <%=employee.getPhone()%></p>
			<p>Email: <%=employee.getEmail()%></p>
			<p>Date of birth: <%=employee.getDateOfBirth()%></p>
			<p>Position: <%=employee.getPosition()%></p>
			<br>
			<a href="DeleteEmployeeServlet?employeeId=<%=employee.getEmployeeId()%>" onclick="return confirmFunction()">Delete</a>
			<a href="updateEmployee.jsp?employeeId=<%=employee.getEmployeeId()%>">Update</a>
			<a href="showSalary.jsp?salaryId=<%=salaryId%>">Salary info</a>
		<%
		}
	%>
	<hr>
	<a href="index.jsp">Return to home page</a>
	
	<script type="text/javascript">
	    function confirmFunction () {
	    	return confirm("Are you sure to delete this employee?");
	    }
	</script>
	
</body>
</html>