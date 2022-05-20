package com.servlets;

import com.dao.EmployeeDAO;
import com.model.Employee;
import com.model.Position;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;

@WebServlet(name = "AddEmployeeServlet", value = "/AddEmployeeServlet")
public class AddEmployeeServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        response.setContentType("text/html");

        try (PrintWriter out = response.getWriter()){

            String employee_id = request.getParameter("employee_id");
            String fname = request.getParameter("fname");
            String lname = request.getParameter("lname");
            String phone = request.getParameter("phone");
            String email = request.getParameter("email");
            Date dob = Date.valueOf(request.getParameter("dob"));
            Position position = Position.valueOf(request.getParameter("position"));

            EmployeeDAO employeeDAO = new EmployeeDAO();
            Employee checkEmployeeExist = employeeDAO.getEmployeeById(employee_id);

            if(checkEmployeeExist.getEmployeeId() != null) {
                out.println("<div class=\"invalidId\">Please enter another ID!</div>");

                RequestDispatcher rd = request.getRequestDispatcher("addEmployee.jsp");
                rd.include(request, response);
            }else {
                Employee employee = new Employee(employee_id, fname, lname, phone, email, dob, position);

                employeeDAO.addEmployee(employee);

                ArrayList<Employee> employeeList;
                employeeList = employeeDAO.getAllEmployee();

                request.setAttribute("employeeList", employeeList);

                RequestDispatcher rd = request.getRequestDispatcher("showAllEmployee.jsp");
                rd.forward(request, response);
            }

        } catch (IOException ignored) {
        }
    }
}
