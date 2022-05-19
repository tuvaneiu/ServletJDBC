package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.model.Employee;
import com.model.Position;

public class EmployeeDAO {
	
	public ArrayList<Employee> getAllEmployee(){
        ArrayList<Employee> employeeList = new ArrayList<Employee>();
        
        try
        {
            String dbURL = "jdbc:mysql://localhost:3306/";
            String dbName = "testdb";
            String username = "tuvan";
            String password = "tuvan";
            String url = dbURL + dbName;
            String sql = "select * from employee";
            Class.forName("com.mysql.jdbc.Driver");

            Connection con = DriverManager.getConnection(url, username, password);
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while(rs.next())
            {
            	Employee employee = new Employee();
            	
                employee.setId(rs.getInt("id"));
                employee.setEmployeeId(rs.getString("employeeId"));
                employee.setFirstName(rs.getString("firstName"));
                employee.setLastName(rs.getString("lastName"));
                employee.setPhone(rs.getString("phone"));
                employee.setEmail(rs.getString("email"));
                employee.setDateOfBirth(rs.getDate("dateOfBirth"));
                employee.setPosition(Position.valueOf(rs.getObject("position").toString()));
                
                employeeList.add(employee);
            }

            st.close();
            con.close();
        }
        catch(ClassNotFoundException | SQLException e){
            System.out.println(e);
        }
        
        return employeeList;
    }
	
	public Employee getEmployeeById(String employeeId) {
		Employee employee = new Employee();
		
		try
        {
            String dbURL = "jdbc:mysql://localhost:3306/";
            String dbName = "testdb";
            String username = "tuvan";
            String password = "tuvan";
            String url = dbURL + dbName;
            String sql = "select * from employee where employeeId="+"'"+employeeId+"'";
            Class.forName("com.mysql.jdbc.Driver");

            Connection con = DriverManager.getConnection(url, username, password);
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while(rs.next())
            {	
                employee.setId(rs.getInt("id"));
                employee.setEmployeeId(rs.getString("employeeId"));
                employee.setFirstName(rs.getString("firstName"));
                employee.setLastName(rs.getString("lastName"));
                employee.setPhone(rs.getString("phone"));
                employee.setEmail(rs.getString("email"));
                employee.setDateOfBirth(rs.getDate("dateOfBirth"));
                employee.setPosition(Position.valueOf(rs.getObject("position").toString()));
            }

            st.close();
            con.close();
        }
        catch(ClassNotFoundException | SQLException e){
            System.out.println(e);
        }
		
		return employee;
	}
	
	public void addEmployee(Employee employee){
        try
        {
            String dbURL = "jdbc:mysql://localhost:3306/";
            String dbName = "testdb";
            String username = "tuvan";
            String password = "tuvan";
            String url = dbURL + dbName;
            Class.forName("com.mysql.jdbc.Driver");

            Connection con = DriverManager.getConnection(url, username, password);
            PreparedStatement st = con.prepareStatement("insert into employee values(?, ?, ?, ?, ?, ?, ?, ?)");
            
            st.setString(1, null);
            st.setString(2, employee.getEmployeeId());
            st.setString(3, employee.getFirstName());
            st.setString(4, employee.getLastName());
            st.setString(5, employee.getPhone());
            st.setString(6, employee.getEmail());
            st.setString(7, employee.getDateOfBirth().toString());
            st.setString(8, employee.getPosition().toString());
            
            st.executeUpdate();

            st.close();
            con.close();
        }
        catch(ClassNotFoundException | SQLException e){
            System.out.println(e);
        }
    }
	
	public void deleteEmployeeById(String employeeId) {
		try
        {
			String dbURL = "jdbc:mysql://localhost:3306/";
            String dbName = "testdb";
            String username = "tuvan";
            String password = "tuvan";
            String url = dbURL + dbName;
            String sql = "delete from employee where employeeId="+"'"+employeeId+"'";
            Class.forName("com.mysql.jdbc.Driver");

            Connection con = DriverManager.getConnection(url, username, password);
            Statement st = con.createStatement();
            
            st.execute(sql);

            st.close();
            con.close();
        }
        catch(ClassNotFoundException | SQLException e){
            System.out.println(e);
        }
	}
	
	public void updateEmployee(Employee employee) {
		try
        {
            String dbURL = "jdbc:mysql://localhost:3306/";
            String dbName = "testdb";
            String username = "tuvan";
            String password = "tuvan";
            String url = dbURL + dbName;
            Class.forName("com.mysql.jdbc.Driver");

            Connection con = DriverManager.getConnection(url, username, password);
            PreparedStatement st = con.prepareStatement("UPDATE employee SET firstName=?, lastName=?, phone=?, email=?, dateOfBirth=?, position=? WHERE employeeId=?");
            
            st.setString(1, employee.getFirstName());
            st.setString(2, employee.getLastName());
            st.setString(3, employee.getPhone());
            st.setString(4, employee.getEmail());
            st.setString(5, employee.getDateOfBirth().toString());
            st.setString(6, employee.getPosition().toString());
            st.setString(7, employee.getEmployeeId());
            
            st.executeUpdate();

            st.close();
            con.close();
        }
        catch(ClassNotFoundException | SQLException e){
            System.out.println(e);
        }
	}
}
