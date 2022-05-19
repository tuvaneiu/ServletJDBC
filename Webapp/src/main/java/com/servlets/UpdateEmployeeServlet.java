package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.EmployeeDAO;
import com.model.Employee;
import com.model.Position;

@SuppressWarnings("serial")
public class UpdateEmployeeServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
            
            Employee employee = new Employee(employee_id, fname, lname, phone, email, dob, position);
            
            employeeDAO.updateEmployee(employee);
            
            ArrayList<Employee> employeeList = new ArrayList<>();
			employeeList = employeeDAO.getAllEmployee();
			
			request.setAttribute("employeeList", employeeList);
            
            RequestDispatcher rd = request.getRequestDispatcher("showAllEmployee.jsp");
            rd.forward(request, response);
            
        } catch (IOException e) {
        }
	}

}
