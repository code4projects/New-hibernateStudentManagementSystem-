package com.example.Entities;

import javax.persistence.*;

@Entity
public class Employee {
    @Id
    private String empid;
    private String empname;
    private int salary;

    // Default Constructor
    public Employee() {
        super();
        // No need for the TODO comment if the constructor is not auto-generated
    }

    // Parameterized constructor
    public Employee(String empid, String empname, int salary) {
        super();
        this.empid = empid;
        this.empname = empname;
        this.salary = salary;
    }

    // Getters and Setters
    public String getEmpid() {
        return empid;
    }

    public void setEmpid(String empid) {
        this.empid = empid;
    }

    public String getEmpname() {
        return empname;
    }

    public void setEmpname(String empname) {
        this.empname = empname;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    // You might want to add other methods or annotations as needed

}
