<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@page import="java.util.*"%>
<%@page import="com.model.*"%>
<%@ page import="com.dao.*" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>All Employee Page</title>
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
    <hr>
    <b>Income: <%=salaryDAO.computeSalary(salary)%> VNĐ</b>

    <hr>
    <a href="index.jsp">Return to home page</a>

</body>
</html>