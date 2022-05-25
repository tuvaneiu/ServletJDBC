<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@page import="java.util.*"%>
<%@page import="com.model.*"%>
<%@ page import="com.dao.*" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Salary Info Page</title>
</head>
<body>
    <h2>Salary Info</h2>

    <%
        int salaryId = Integer.parseInt(request.getParameter("salaryId"));
        SalaryDAO salaryDAO = new SalaryDAO();
        EmployeeDAO employeeDAO = new EmployeeDAO();
        Salary salary = salaryDAO.getSalaryById(salaryId);

    %>
        <hr>
        <p>Employee ID: <%=employeeDAO.getEmployeeById(salary.getEmployeeId()).getEmployeeId()%></p>
        <p>Tax Rate: <%=salary.getTaxRate()%></p>
        <p>Working Day: <%=salary.getNumOfWorkingDay()%></p>
        <p>Allowance: <%=salary.getAllowance()%></p>
        <br>
        <a href="updateSalary.jsp?salaryId=<%=salaryId%>">Update</a>
        <a href="computeSalary.jsp?salaryId=<%=salaryId%>">Get Income</a>

    <hr>
    <a href="index.jsp">Return to home page</a>

</body>
</html>