package com.servlets;

import com.dao.EmployeeDAO;
import com.dao.SalaryDAO;
import com.model.Employee;
import com.model.Position;
import com.model.Salary;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;

@WebServlet(name = "UpdateSalaryServlet", value = "/UpdateSalaryServlet")
public class UpdateSalaryServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/html");

        try {
            int employeeId = Integer.parseInt(request.getParameter("employeeId"));
            double tax = Double.parseDouble(request.getParameter("tax"));
            double numOfDay = Double.parseDouble(request.getParameter("numOfDay"));
            double allowance = Double.parseDouble(request.getParameter("allowance"));

            SalaryDAO salaryDAO = new SalaryDAO();
            Salary salary = new Salary(employeeId, tax, numOfDay, allowance);

            salaryDAO.updateSalary(salary);

            int salaryId = salaryDAO.getSalaryByEmployeeId(employeeId).getSalaryId();

            RequestDispatcher rd = request.getRequestDispatcher("showSalary.jsp?salaryId=" + salaryId);
            rd.forward(request, response);

        } catch (IOException | ServletException ignored) {
        }
    }
}
