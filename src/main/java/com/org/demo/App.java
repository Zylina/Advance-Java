package com.org.demo;

/**
 * Hello world!
 *
 */
import org.hibernate.*;  
import org.hibernate.boot.Metadata;  
import org.hibernate.boot.MetadataSources;  
import org.hibernate.boot.registry.StandardServiceRegistry;  
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;    
    
public class App {    
public static void main(String[] args) {    
      
    StandardServiceRegistry ssr=new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();  
    Metadata meta=new MetadataSources(ssr).getMetadataBuilder().build();  
      
    SessionFactory factory=meta.getSessionFactoryBuilder().build();  
    Session session=factory.openSession();  
      
    Transaction t=session.beginTransaction();   
      
    Student s1=new Student();    
    s1.setName("Ravi Malik");    
    s1.setEmail("ravi@gmail.com");    
        
    Address address1=new Address();    
    address1.setAddressLine1("G-21,Lohia nagar");    
    address1.setCity("Ghaziabad");    
    address1.setState("UP");    
    address1.setCountry("India");    
    address1.setPincode(201301);    
        
    s1.setAddress(address1);    
    address1.setStudent(s1);    
        
    session.persist(s1);    
    t.commit();    
        
    session.close();    
    System.out.println("success");    
}    
}

