package org.example;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class Main {

    public static void main(String[] args) {
        // Open a session
        Session session = HibernateUtil.getSession();
        Transaction transaction = null;

        try {
            // Begin a transaction
            transaction = session.beginTransaction();

            // Create a new user instance
            User newUser = new User("test2", "testp@ss");

            // Save the user to the database
            session.save(newUser);

            // Commit the transaction
            transaction.commit();

            System.out.println("User saved successfully: " + newUser);

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            // Close the session
            session.close();
        }

        // Optionally shutdown Hibernate when the application is closing
        HibernateUtil.shutdown();
    }
}
