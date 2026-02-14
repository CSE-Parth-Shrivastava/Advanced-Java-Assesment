package com.assesment1;

import jakarta.persistence.*;

public class App {
    public static void main( String[] args ){
    	EntityManagerFactory emf = Persistence.createEntityManagerFactory("myPersistenceUnit");
    	EntityManager em = emf.createEntityManager();
    	
    	Employee employee = new Employee("John", "john@gmail.com");
    	IDCard idCard = new IDCard("IDC101", " 2026-02-14");
    	
    	employee.setId(idCard);
    	idCard.setEmployee(employee);
    	
    	em.getTransaction().begin();
    	
    	em.persist(employee);
    	em.persist(idCard);
    	
    	em.getTransaction().commit();

    	
    	System.out.println("Employee Created Successfully");
    	
    	employee.setId(idCard);
        idCard.setEmployee(employee);
    
    	
    	em.close();

    }
}






/*
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {

    public static void main(String[] args) {

        // Step 1: Configure
        SessionFactory sessionFactory =
                new Configuration().configure().buildSessionFactory();

        // Step 2: Open Session
        Session session = sessionFactory.openSession();

        // Step 3: Begin Transaction
        Transaction transaction = session.beginTransaction();

        try {
            // Create Employee
            Employee emp1 = new Employee("John", "John@Example@gmail.com");

            // Create IDCard
            IDCard idcard = new IDCard("IDC101", "2026-02-14");

            // Set Relationship
            emp1.setId(idcard);
            idcard.setEmployee(emp1);

            // Save only employee (cascade will save IDCard)
            session.persist(emp1);

            // Commit
            transaction.commit();

            System.out.println("Data inserted successfully!");

        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
            sessionFactory.close();
        }
    }
}

*/
