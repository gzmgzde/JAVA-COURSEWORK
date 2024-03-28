/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.w1945822_planemanagement;

/**
 *
 * @author gizem
 */

public class Person {
    //ATTRIBUTES
    private String name ;
    private String surname ;
    private String email ;
    
    //CONSTRUCTOR
    public Person(String name, String surname, String email){
        this.name= name;
        this.surname = surname;
        this.email=email;
    }
    
    //GETTERS 
    public String getName(){
        
        return this.name;   
    }
    public String getSurname(){
        return this.surname;   
    }
    public String getEmail(){
        return this.email;
    }
    
    //SETTERS
    public void setName(String name){
        this.name = name;    
    }
    
    public void setSurname(String surname){
        this.surname = surname;
        
    }
    
    public void setEmail(String email){
        this.email = email;
    }
    
    
    //PRINT ALL INFORMATION
    public void PersonInfo(){ 
        System.out.println("Name: " + name);
        
         
        System.out.println("Surname: " + surname);
        
        
        System.out.println("Email: "+email);
    }
    
}
