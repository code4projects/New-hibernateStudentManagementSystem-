package com.example.Entities;

import org.hibernate.*;
import org.hibernate.cfg.*;

public class Apps {
    public static void main(String[] args) {
        // Create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(user.class)
                .addAnnotatedClass(Task.class)
                .buildSessionFactory();

        // Create session
        Session session = factory.getCurrentSession();

        try {
            // Start a transaction
            session.beginTransaction();

            // Create a user
            user user1 = new user("John");

            // Create some tasks
            Task task1 = new Task("Read Book");
            Task task2 = new Task("Write code");

            // Add tasks to the user
            user1.addTask(task1);
            user1.addTask(task2);

            // Save the user (cascade operation will save tasks as well)
            session.save(user1);

            // Commit transaction
            session.getTransaction().commit();

            // Retrieve tasks for a particular user
            session = factory.getCurrentSession();
            session.beginTransaction();

            // Get the user by id
            user retrievedUser = session.get(user.class, user1.getId());

            // Display tasks for the user
            System.out.println("Tasks for User: " + retrievedUser.getUsername());
            for (Task task : retrievedUser.getTasks()) {
                System.out.println(task.getDescription());
            }

            // Commit the transaction
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the session factory
            factory.close();
        }
    }
}

