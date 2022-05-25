<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" errorPage="error.jsp"%>
<%@page import="java.util.*"%>
<%@page import="com.model.*"%>
<%@page import="com.dao.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Employee Page</title>

<style type="text/css">
	.container{
		padding-left: 300px;
		padding-right: 300px;
	}
	.content{
		height: 610px;
		padding: 20px;
		text-align: center;
	}
	table tr td{
		padding-bottom: 10px;
	}
	label, input, select {
		float: left;
	}
	select {
		padding: 2px;
	}
</style>
</head>
<body>
	<%
		String id = request.getParameter("employeeId");
		EmployeeDAO employeeDAO = new EmployeeDAO();
		Employee employee = employeeDAO.getEmployeeById(id);
	%>
	<div class="content">
		<!--<div class="invalidId">Please enter another ID!</div>-->
		<h2 style="margin-bottom: 40px;">Edit Employee</h2>
		<form action="UpdateEmployeeServlet" method="post" style="margin: 0px">
			<table style="margin: auto;">
				<tr>
					<td><label for="employee_id">Employee ID:</label></td>
					<td><input type="text" id="employee_id" name="employee_id" readonly="readonly" value="<%=employee.getEmployeeId()%>"></td>
				</tr>
				<tr>
					<td><label for="fname">First name:</label></td>
					<td><input type="text" id="fname" name="fname" value="<%=employee.getFirstName()%>" required="required"></td>
				</tr>
				<tr>
					<td><label for="lname">Last name:</label></td>
					<td><input type="text" id="lname" name="lname" value="<%=employee.getLastName()%>" required="required"></td>
				</tr>
				<tr>
					<td><label for="phone">Phone:</label></td>
					<td><input type="text" id="phone" name="phone" value="<%=employee.getPhone()%>" required="required"></td>
				</tr>
				<tr>
					<td><label for="email">Email:</label></td>
					<td><input type="email" id="email" name="email" value="<%=employee.getEmail()%>" required="required"></td>
				</tr>
				<tr>
					<td><label for="dob">Date of Birth:</label></td>
					<td><input type="date" id="dob" name="dob" value="<%=employee.getDateOfBirth()%>" required="required"></td>
				</tr>
				<tr>
					<td><label for="position">Position:</label></td>
					<td>
						<select name="position" id="position">
							<%
								if(employee.getPosition().toString() == "Manager"){
									%>
										<option value="Manager" selected="selected">Manager</option>
										<option value="Engineer">Engineer</option>
										<option value="Guard">Guard</option>
									<%
								}
								if(employee.getPosition().toString() == "Engineer"){
									%>
										<option value="Manager">Manager</option>
										<option value="Engineer" selected="selected">Engineer</option>
										<option value="Guard">Guard</option>
									<%
								}
								if(employee.getPosition().toString() == "Guard"){
									%>
										<option value="Manager">Manager</option>
										<option value="Engineer">Engineer</option>
										<option value="Guard" selected="selected">Guard</option>
									<%
								}
							%>
						</select>
					</td>
				</tr>
			</table>
			<br>
			<button style="font-size: 20px;" type="submit">Edit</button>
			<button style="font-size: 20px;" type="reset">Reset</button>
		</form>
	</div>
</body>
</html>