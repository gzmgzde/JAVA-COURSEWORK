/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.w1945822_planemanagement;

/**
 *
 * @author gizem
 */
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
public class Ticket {
    //ATTRIBUTES
    private String row;
    private int seat;
    private double price;
    private Person person; 
    
    //CONSTRUCTOR
    public Ticket(String row, int seat, double price, Person person){
        this.row = row;
        this.seat = seat;
        this.price = price;
        this.person = person; 
        Ticket[] tickets ;
        tickets = new Ticket[100];
    }
    
    //GETTERS
    public String getRow(){
        return row;   
    }
    public int getSeat(){
        return seat;   
    }
    public double getPrice(){
        return price;
    }
    public Person getPerson(){
        return person;
    }
    
    //SETTERS
     public void setRow(String row){
        this.row = row;    
    }
    
    public void setSeat(int seat){
        this.seat = seat;
        
    }
    
    public void setPrice(double price){
        this.price = price;
    }
    
    public void setPerson(Person person){
        this.person = person;
    }
 
    public void TicketInfo(){
        System.out.println("**     Here is the Ticketing Information      **");
        System.out.println("Seat: " + row + seat );
        System.out.println("Price:£ " + price );
        System.out.println("\n Personal details: " + "\n Name:" + person.getName()+ "\n Surname:" + person.getSurname()+ "\n Email:" + person.getEmail());
        
        
    }
    public void PrintText(){
        
        String filename = row + seat + ".txt";
        File file = new File(filename);
        try {
            boolean file_created = file.createNewFile();
            if (file_created ){
                FileWriter writer = new FileWriter(filename);
                writer.write("\n Seat: " + row + seat);
                writer.write("\n Price:£ " + price );
                writer.write("\n Personal details: " + "\n Name:" + person.getName()+ "\n Surname:" + person.getSurname()+ "\n Email:" + person.getEmail());
                writer.close();
            }
        } 
        catch (IOException ex) 
        {System.out.println("ERROR: File could not be created.");
        }
    }
    
   
}
