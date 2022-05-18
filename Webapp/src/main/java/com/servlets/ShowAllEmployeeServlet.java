package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.EmployeeDAO;
import com.model.Employee;


@SuppressWarnings("serial")
public class ShowAllEmployeeServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		try (PrintWriter out = response.getWriter()){
            
			ArrayList<Employee> employeeList = new ArrayList<>();
			EmployeeDAO employeeDAO = new EmployeeDAO();
			
			employeeList = employeeDAO.getAllEmployee();
			
			request.setAttribute("employeeList", employeeList);
            
            RequestDispatcher rd = request.getRequestDispatcher("showAllEmployee.jsp");
            rd.forward(request, response);

            
        } catch (IOException e) {
        }
	}
}
