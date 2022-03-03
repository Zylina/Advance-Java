package com.org.demo;

import javax.persistence.*;  
 

@Entity  
@Table(name="std12")  
public class Student {    
      
    @Id  
    @GeneratedValue(strategy=GenerationType.AUTO)  
    @PrimaryKeyJoinColumn  
private int Id;    
private String name,email;    
@OneToOne(targetEntity=Address.class,cascade=CascadeType.ALL)  
private Address address;  
public int getId() {  
    return Id;  
}  
public void setId(int Id) {  
    this.Id = Id;  
}  
public String getName() {  
    return name;  
}  
public void setName(String name) {  
    this.name = name;  
}  
public String getEmail() {  
    return email;  
}  
public void setEmail(String email) {  
    this.email = email;  
}  
public Address getAddress() {  
    return address;  
}  
public void setAddress(Address address) {  
    this.address = address;  
}    
  
}    