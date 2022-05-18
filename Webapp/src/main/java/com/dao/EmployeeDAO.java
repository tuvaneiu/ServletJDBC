package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

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
	
	public void addEmployee(int id, String employeeId, String firstName, String lastName, String phone, String email,
			Date dateOfBirth, Position position){
        try
        {
            String dbURL = "jdbc:mysql://localhost:3306/";
            String dbName = "testdb";
            String username = "tuvan";
            String password = "tuvan";
            String url = dbURL + dbName;
            Class.forName("com.mysql.jdbc.Driver");

            Connection con = DriverManager.getConnection(url, username, password);
            PreparedStatement st = con.prepareStatement("insert into student_info values(?, ?, ?, ?, ?, ?, ?, ?)");
            
            st.setInt(1, id);
            st.setString(2, employeeId);
            st.setString(3, firstName);
            st.setString(4, lastName);
            st.setString(5, phone);
            st.setString(6, email);
            st.setString(7, dateOfBirth.toString());
            st.setString(8, position.toString());
            
            st.executeUpdate();

            st.close();
            con.close();
        }
        catch(ClassNotFoundException | SQLException e){
            System.out.println(e);
        }
    }
}
