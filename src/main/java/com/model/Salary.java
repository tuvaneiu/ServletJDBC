package com.model;

public class Salary {
    private int salaryId;
    private int employeeId;
    private double taxRate;
    private double numOfWorkingDay;
    private double allowance;

    public Salary(int employeeId, double taxRate, double numOfWorkingDay, double allowance) {
        this.employeeId = employeeId;
        this.taxRate = taxRate;
        this.numOfWorkingDay = numOfWorkingDay;
        this.allowance = allowance;
    }

    public Salary() {
        super();
    }

    public int getSalaryId() {
        return salaryId;
    }

    public void setSalaryId(int salaryId) {
        this.salaryId = salaryId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public double getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(double taxRate) {
        this.taxRate = taxRate;
    }

    public double getNumOfWorkingDay() {
        return numOfWorkingDay;
    }

    public void setNumOfWorkingDay(double numOfWorkingDay) {
        this.numOfWorkingDay = numOfWorkingDay;
    }

    public double getAllowance() {
        return allowance;
    }

    public void setAllowance(double allowance) {
        this.allowance = allowance;
    }

    @Override
    public String toString() {
        return "Salary{" +
                "salaryId='" + salaryId + '\'' +
                ", employeeId='" + employeeId + '\'' +
                ", taxRate=" + taxRate +
                ", numOfWorkingDay=" + numOfWorkingDay +
                ", allowance=" + allowance +
                '}';
    }
}
