package com.servlets;

import com.dao.EmployeeDAO;
import com.model.Employee;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ShowAllEmployeeServlet", value = "/ShowAllEmployeeServlet")
public class ShowAllEmployeeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        response.setContentType("text/html");

        try {

            ArrayList<Employee> employeeList;
            EmployeeDAO employeeDAO = new EmployeeDAO();

            employeeList = employeeDAO.getAllEmployee();

            request.setAttribute("employeeList", employeeList);

            RequestDispatcher rd = request.getRequestDispatcher("showAllEmployee.jsp");
            rd.forward(request, response);

        } catch (IOException ignored) {
        }
    }
}
