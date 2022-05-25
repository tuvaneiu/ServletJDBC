package com.servlets;

import com.dao.EmployeeDAO;
import com.dao.SalaryDAO;
import com.model.Employee;
import com.model.Salary;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "DeleteEmployeeServlet", value = "/DeleteEmployeeServlet")
public class DeleteEmployeeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        response.setContentType("text/html");

        try {

            String id = request.getParameter("employeeId");

            EmployeeDAO employeeDAO = new EmployeeDAO();
            SalaryDAO salaryDAO = new SalaryDAO();

            Employee employee = employeeDAO.getEmployeeById(id);

            salaryDAO.deleteSalaryById(employee.getSalary().getSalaryId());
            employeeDAO.deleteEmployeeById(id);

            ArrayList<Employee> employeeList;
            employeeList = employeeDAO.getAllEmployee();

            request.setAttribute("employeeList", employeeList);

            RequestDispatcher rd = request.getRequestDispatcher("showAllEmployee.jsp");
            rd.forward(request, response);

        } catch (IOException ignored) {
        }
    }
}
