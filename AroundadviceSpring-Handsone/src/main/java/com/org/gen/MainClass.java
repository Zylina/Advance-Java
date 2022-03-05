package com.org.gen;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class MainClass {
    public static void main(String[] args) {
    	     System.out.println("HELLO WORLD !!!");
    	        Configuration con = new Configuration().configure()
    			.addAnnotatedClass(Student.class)
    			.addAnnotatedClass(Address.class)
    			.addAnnotatedClass(Account.class);
    			// Prepare the transaction
    			//ServiceRegistry serviceRegistry = new
    	 	//ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
    			SessionFactory sf = con.buildSessionFactory();
    			Session session = sf.openSession();
    			Transaction tx = session.beginTransaction(); 
    			// ********* create 2 students *********
    			Student student_1 = new Student();
    			student_1.setEmail("student_1@mail.com");
    			student_1.setName("Happy Name");
    			Student student_2 = new Student();
    			student_2.setEmail("student_2@mail.com");
    			student_2.setName("Creamy Name");
    			// ********* create 2 addresses *********
    			Address address_1 = new Address();
    			
    			address_1.setCity("New York");
    			address_1.setState("NY");
    			Address address_2 = new Address();
    			
    			address_2.setCity("Atlanta");
    			address_2.setState("GA");
    			
    			student_1.setAddress(address_1);
    			student_2.setAddress(address_2);
    			// Save addresses to session
    			session.saveOrUpdate(address_1);
    			session.saveOrUpdate(address_2);
    			// 
    			// ********* create 3 accounts *********
    			Account account1 = new Account();
    			account1.setUsername("happy_1");
    			Account account2 = new Account();
    			account2.setUsername("happy_2");
    			Account account3 = new Account();
    			account3.setUsername("icecream_1");
    			// ********* Assign accounts to students *********
    			student_1.getAccounts().add(account1);
    			student_1.getAccounts().add(account2);
    			student_2.getAccounts().add(account3);
    			// ********* Save students *********
    			session.save(student_1);
    			session.save(student_2);
    			tx.commit();
    }
}     
