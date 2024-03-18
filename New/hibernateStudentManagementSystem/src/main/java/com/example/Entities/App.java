package com.example.Entities;

import org.hibernate.*;
import org.hibernate.cfg.*;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");

        SessionFactory factory = configuration.buildSessionFactory();
        Session session = factory.openSession();
        // Entity Creation
        Transaction transaction = session.beginTransaction();

        Scanner sc = new Scanner(System.in);
        int numberOfEmployees;

        System.out.println("Enter the number of employees: ");
        numberOfEmployees = sc.nextInt();
        sc.nextLine(); // consume the newline character

        for (int i = 0; i < numberOfEmployees; i++) {
            Employee emp = new Employee();
            
            System.out.println("Enter Employee ID for Employee " + (i + 1) + ": ");
            emp.setEmpid(sc.nextLine());
            
            System.out.println("Enter Employee Name for Employee " + (i + 1) + ": ");
            emp.setEmpname(sc.nextLine());
            
            System.out.println("Enter Employee Salary for Employee " + (i + 1) + ": ");
            emp.setSalary(sc.nextInt());
            
            sc.nextLine(); // consume the newline character
            
            session.save(emp); // Persisting emp into session
        }

        transaction.commit();

        System.out.println("Employees Inserted into employee table");
        
        sc.close();
        session.close();
        factory.close();
    }
}
