<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

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
	<div class="content">
		<h2>Add Employee</h2>
		<form action="AddEmployeeServlet" method="post" style="margin: 0px">
			<table style="margin: auto;">
				<tr>
					<td><label for="id">ID:</label></td>
					<td><input type="number" id="id" name="id" placeholder="Choose ID..."></td>
				</tr>
				<tr>
					<td><label for="employee_id">Employee ID:</label></td>
					<td><input type="text" id="employee_id" name="employee_id" placeholder="Enter employee ID..."></td>
				</tr>
				<tr>
					<td><label for="fname">First name:</label></td>
					<td><input type="text" id="fname" name="fname" placeholder="Enter first name..."></td>
				</tr>
				<tr>
					<td><label for="lname">Last name:</label></td>
					<td><input type="text" id="lname" name="lname" placeholder="Enter last name..."></td>
				</tr>
				<tr>
					<td><label for="phone">Phone:</label></td>
					<td><input type="text" id="phone" name="phone" placeholder="Enter phone number..."></td>
				</tr>
				<tr>
					<td><label for="email">Email:</label></td>
					<td><input type="email" id="email" name="email" placeholder="Enter email..."></td>
				</tr>
				<tr>
					<td><label for="dob">Date of Birth:</label></td>
					<td><input type="date" id="dob" name="dob"></td>
				</tr>
				<tr>
					<td><label for="position">Position:</label></td>
					<td>
						<select name="position" id="position">
							<option value="Manager">Manager</option>
							<option value="Engineer">Engineer</option>
							<option value="Guard">Guard</option>
						</select>
					</td>
				</tr>
			</table>
			<br>
			<button style="font-size: 20px;" type="submit">Add</button>
			<button style="font-size: 20px;" type="reset">Reset</button>
		</form>
	</div>
</body>
</html>