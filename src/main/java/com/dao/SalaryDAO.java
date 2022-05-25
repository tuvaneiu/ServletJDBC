package com.dao;

import com.model.ComputeSalary;
import com.model.Employee;
import com.model.Salary;

import java.sql.*;

public class SalaryDAO implements ComputeSalary {

    public Connection getConnection() {
        Connection con = null;

        try
        {
            String dbURL = "jdbc:mysql://localhost:3306/";
            String dbName = "testdb";
            String username = "tuvan";
            String password = "tuvan";
            String url = dbURL + dbName;
            Class.forName("com.mysql.jdbc.Driver");

            con = DriverManager.getConnection(url, username, password);
        }
        catch(ClassNotFoundException | SQLException e){
            System.out.println(e);
        }

        return con;
    }

    public Salary getNewSalary(int employeeId){
        return new Salary(employeeId, 0.0, 0.0, 0.0);
    }

    public Salary getSalaryById(int salaryId) {
        Salary salary = new Salary();

        try
        {
            String sql = "select * from salary where salaryId="+"'"+salaryId+"'";

            Connection con = getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while(rs.next())
            {
                salary.setSalaryId(rs.getInt("salaryId"));
                salary.setEmployeeId(rs.getInt("employeeId"));
                salary.setTaxRate(rs.getDouble("taxRate"));
                salary.setNumOfWorkingDay(rs.getDouble("numOfWorkingDay"));
                salary.setAllowance(rs.getDouble("allowance"));
            }

            st.close();
            con.close();
        }
        catch(SQLException e){
            System.out.println(e);
        }

        return salary;
    }

    public Salary getSalaryByEmployeeId(int employeeId) {
        Salary salary = new Salary();

        try
        {
            String sql = "select * from salary where employeeId="+"'"+employeeId+"'";

            Connection con = getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while(rs.next())
            {
                salary.setSalaryId(rs.getInt("salaryId"));
                salary.setEmployeeId(rs.getInt("employeeId"));
                salary.setTaxRate(rs.getDouble("taxRate"));
                salary.setNumOfWorkingDay(rs.getDouble("numOfWorkingDay"));
                salary.setAllowance(rs.getDouble("allowance"));
            }

            st.close();
            con.close();
        }
        catch(SQLException e){
            System.out.println(e);
        }

        return salary;
    }

    public void addSalary(Salary salary){
        try
        {
            Connection con = getConnection();
            PreparedStatement st = con.prepareStatement("insert into salary values(?, ?, ?, ?, ?)");

            st.setString(1, null);
            st.setInt(2, salary.getEmployeeId());
            st.setDouble(3, salary.getTaxRate());
            st.setDouble(4, salary.getNumOfWorkingDay());
            st.setDouble(5, salary.getAllowance());

            st.executeUpdate();

            st.close();
            con.close();
        }
        catch(SQLException e){
            System.out.println(e);
        }
    }

    public void deleteSalaryById(int salaryId) {
        try
        {
            String sql = "delete from salary where salaryId="+"'"+salaryId+"'";

            Connection con = getConnection();
            Statement st = con.createStatement();

            st.execute(sql);

            st.close();
            con.close();
        }
        catch(SQLException e){
            System.out.println(e);
        }
    }

    public void updateSalary(Salary salary) {
        try
        {
            Connection con = getConnection();
            PreparedStatement st = con.prepareStatement("UPDATE salary SET taxRate=?, numOfWorkingDay=?, allowance=? WHERE employeeId=?");

            st.setDouble(1, salary.getTaxRate());
            st.setDouble(2, salary.getNumOfWorkingDay());
            st.setDouble(3, salary.getAllowance());
            st.setInt(4, salary.getEmployeeId());

            st.executeUpdate();

            st.close();
            con.close();
        }
        catch(SQLException e){
            System.out.println(e);
        }
    }

    @Override
    public double computeSalary(Salary salary) {
        EmployeeDAO employeeDAO = new EmployeeDAO();
        Employee employee = employeeDAO.getEmployeeById(salary.getEmployeeId());

        return (getPayPerHour(employee.getPosition()) * salary.getNumOfWorkingDay() * 8.0 + salary.getAllowance())
                * (1.0 - salary.getTaxRate());
    }
}
