/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.w1945822_planemanagement;

/**
 *
 * @author gizem
 */
import java.util.Scanner;

public class W1945822_PlaneManagement {

    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int ticketnum=0;

        //WELCOME MESSAGE
        System.out.println("                   Welcome to                   ");
        System.out.println("       the Plane Management Application         ");
        System.out.println(" ");

        //SEAT MANAGEMENT SYSTEM
        String[] A = {"O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O"};
        String[] B = {"O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O"};
        String[] C = {"O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O"};
        String[] D = {"O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O"};
        

        double price = 0;
        String seat_row = "";
        int seat_number = 0;
       
        
        
         //ARRAY OF TICKETS
        Ticket[] tickets = new Ticket[52];
   
        //MENU
        System.out.println("************************************************");
        System.out.println("*                MENU OPTIONS                  *");
        System.out.println("************************************************");
        System.out.println(" ");
        System.out.println("    1) Buy a seat");
        System.out.println("    2) Cancel a seat");
        System.out.println("    3) Find first available seat");
        System.out.println("    4) Show seating plan");
        System.out.println("    5) Print tickets information and total sales");
        System.out.println("    6) Search ticket");
        System.out.println("    0) Quit");
        System.out.println(" ");
        System.out.println("************************************************");
        System.out.println(" ");
        
        //OPTIONS
        boolean quit = false;

        while (!quit) {
            System.out.println(" ");
            System.out.println(" ");
            System.out.println("Please select an option: ");
            String option = input.next();
            switch (option) {
                case "1":
                    buy_seat(A, B, C, D, price, tickets, ticketnum);
                    ticketnum++;
                    break;

                case "2":
                    cancel_seat(A, B, C, D);
                    break;
                    
                case "3":
                    find_first_available(A,B,C,D,seat_row, seat_number,price);
                    break;
                    
                case "4":
                    show_seating_plan(A,B,C,D);
                    break;
                    
                case "5":
                
                    print_tickets_info(tickets,ticketnum);
                    break;
                    
                case "6":
                    search_ticket(tickets, ticketnum);
                    break;
             
                case "0":
                    System.out.println("Thanks for using the application. \nHave a good day!");
                    quit = true;
                    break;
                    
                default: 
                    System.out.println("Invalid value, please try again.");

            }
        }

    }

    private static void buy_seat(String[] A, String[] B, String[] C, String[] D, double price, Ticket []tickets, int ticketnum) {
       
        Scanner input = new Scanner(System.in);
        System.out.println(" ");

        System.out.println("**                 BUY A SEAT                 **");
        System.out.println(" ");
        System.out.println(" ");

        //SELECTING SEAT
        
        System.out.println("Please select row (A,B,C,D): ");
        String seat_row = input.next();
        System.out.println("Please select seat number (A,D: 1-14 || B,C: 1-12 ): ");
        int seat_number = input.nextInt();
        

        // IF INPUT FOR SEAT ROW IS "A"
        if (seat_row.equals("A")) {
            
            if (seat_number >= 1 && seat_number <= 14) {
                //INDEX IS 1 LESS THAN INPUT VALUE
                int i = seat_number - 1;
                //IF SEAT IS ALREADY BOOKED, IT WARNS USER.
                if (A[i] == "X") {
                    System.out.println("This seat is not available.");
                    ticketnum=ticketnum-1;
                    return;

                } 
                //IF EVERYTHING IS GOOD, SEAT IS SELECTED.
                else {
                    A[i] = "X";
                    
                     //PERSONAL DETAILS
                    System.out.println("Please enter personal details.");
                    System.out.println("Your name: ");
                    String name = input.next();
                    System.out.println("Your surname: ");
                    String surname = input.next();
                    System.out.println("Your email: ");
                    String email = input.next();
                  
                    //SEAT PRICE
                    if(seat_number>=1 && seat_number<=5){ 
                        price=200;
                        
                    }
                    else if (seat_number>=6 && seat_number<=9){
                        price = 150;
                    }
                    else{
                        price= 180;
                    }
                    
                    //ADDS TICKET AND PERSONAL INFO
                    Person person = new Person(name,surname,email); 
                    Ticket ticket = new Ticket(seat_row,seat_number,price,person);
                    tickets[ticketnum] = ticket;
                    
                    //SAVES AS TXT FILE
                    ticket.PrintText();
                    
                    
                    
                }

            } else {
                //IF INPUT DOES NOT BETWEEN 1-14, IT WARNS USER TO ENTER A NEW INPUT AND TRY AGAIN
                System.out.println("Please enter a valid seat number (1-14): ");
                seat_number = input.nextInt();
                int i = seat_number - 1;
                if (A[i] == "X") {
                    System.out.println("This seat is not available.");
                    ticketnum=ticketnum-1;
                    return;

                } else {
                    A[i] = "X";
                    
                     //PERSONAL DETAILS
                    System.out.println("Please enter personal details.");
                    System.out.println("Your name: ");
                    String name = input.next();
                    System.out.println("Your surname: ");
                    String surname = input.next();
                    System.out.println("Your email: ");
                    String email = input.next();
                  
                    //SEAT PRICE
                    if(seat_number>=1 && seat_number<=5){ 
                        price=200;
                        
                    }
                    else if (seat_number>=6 && seat_number<=9){
                        price = 150;
                    }
                    else{
                        price= 180;
                    }
                    
                    //ADDS TICKET AND PERSONAL INFO
                    Person person = new Person(name,surname,email); 
                    Ticket ticket = new Ticket(seat_row,seat_number,price,person);
                    tickets[ticketnum] = ticket;
                    
                    //SAVES AS TXT FILE
                    ticket.PrintText();
                    
                }
            }
            
            System.out.println(" ");
            System.out.println(" ");
        
            //AFTER THERE IS NO ERRORS, SEAT IS BOOKED
            System.out.println("Your Seat " + seat_row + seat_number + " has booked.");

        } 
        // IF INPUT FOR SEAT ROW IS "B"
        else if (seat_row.equals("B")) {
            if (seat_number >= 1 && seat_number <= 12) {
                int i = seat_number - 1;
                if (B[i] == "X") {
                    System.out.println("This seat is not available.");
                    ticketnum=ticketnum-1;
                    return;

                } else {
                    B[i] = "X";
                    
                     //PERSONAL DETAILS
                    System.out.println("Please enter personal details.");
                    System.out.println("Your name: ");
                    String name = input.next();
                    System.out.println("Your surname: ");
                    String surname = input.next();
                    System.out.println("Your email: ");
                    String email = input.next();
                  
                    //SEAT PRICE
                    if(seat_number>=1 && seat_number<=5){ 
                        price=200;
                        
                    }
                    else if (seat_number>=6 && seat_number<=9){
                        price = 150;
                    }
                    else{
                        price= 180;
                    }
                    
                    //ADDS TICKET AND PERSONAL INFO
                    Person person = new Person(name,surname,email); 
                    Ticket ticket = new Ticket(seat_row,seat_number,price,person);
                    tickets[ticketnum] = ticket;
                    
                    //SAVES AS TXT FILE
                    ticket.PrintText();
                    
                }

            } else {
                System.out.println("Please enter a valid seat number (1-12): ");
                seat_number = input.nextInt();
                int i = seat_number - 1;
                if (B[i] == "X") {
                    System.out.println("This seat is not available.");
                    ticketnum=ticketnum-1;
                    return;

                } else {
                    B[i] = "X";
                     //PERSONAL DETAILS
                    System.out.println("Please enter personal details.");
                    System.out.println("Your name: ");
                    String name = input.next();
                    System.out.println("Your surname: ");
                    String surname = input.next();
                    System.out.println("Your email: ");
                    String email = input.next();
                  
                    //SEAT PRICE
                    if(seat_number>=1 && seat_number<=5){ 
                        price=200;
                        
                    }
                    else if (seat_number>=6 && seat_number<=9){
                        price = 150;
                    }
                    else{
                        price= 180;
                    }
                    
                    //ADDS TICKET AND PERSONAL INFO
                    Person person = new Person(name,surname,email); 
                    Ticket ticket = new Ticket(seat_row,seat_number,price,person);
                    tickets[ticketnum] = ticket;
                    
                    //SAVES AS TXT FILE
                    ticket.PrintText();
                    
                }

            }
        
            
            System.out.println(" ");
            System.out.println(" ");

            System.out.println("Your Seat " + seat_row + seat_number + " has booked.");

        } 
        // IF INPUT FOR SEAT ROW IS "C"
        else if (seat_row.equals( "C")) {
            if (seat_number >= 1 && seat_number <= 12) {
                int i = seat_number - 1;
                if (C[i] == "X") {
                    System.out.println("This seat is not available.");
                    return;

                } else {
                    C[i] = "X";
                     //PERSONAL DETAILS
                    System.out.println("Please enter personal details.");
                    System.out.println("Your name: ");
                    String name = input.next();
                    System.out.println("Your surname: ");
                    String surname = input.next();
                    System.out.println("Your email: ");
                    String email = input.next();
                  
                    //SEAT PRICE
                    if(seat_number>=1 && seat_number<=5){ 
                        price=200;
                        
                    }
                    else if (seat_number>=6 && seat_number<=9){
                        price = 150;
                    }
                    else{
                        price= 180;
                    }
                    
                    //ADDS TICKET AND PERSONAL INFO
                    Person person = new Person(name,surname,email); 
                    Ticket ticket = new Ticket(seat_row,seat_number,price,person);
                    tickets[ticketnum] = ticket;
                    ticketnum=ticketnum+1;
                    
                    //SAVES AS TXT FILE
                    ticket.PrintText();
                }

            } else {
                System.out.println("Please enter a valid seat number (1-12): ");
                seat_number = input.nextInt();
                int i = seat_number - 1;
                if (C[i] == "X") {
                    System.out.println("This seat is not available.");
                    return;

                } else {
                    C[i] = "X";
                     //PERSONAL DETAILS
                    System.out.println("Please enter personal details.");
                    System.out.println("Your name: ");
                    String name = input.next();
                    System.out.println("Your surname: ");
                    String surname = input.next();
                    System.out.println("Your email: ");
                    String email = input.next();
                  
                    //SEAT PRICE
                    if(seat_number>=1 && seat_number<=5){ 
                        price=200;
                        
                    }
                    else if (seat_number>=6 && seat_number<=9){
                        price = 150;
                    }
                    else{
                        price= 180;
                    }
                    
                    //ADDS TICKET AND PERSONAL INFO
                    Person person = new Person(name,surname,email); 
                    Ticket ticket = new Ticket(seat_row,seat_number,price,person);
                    tickets[ticketnum] = ticket;
                    ticketnum=ticketnum+1;
                    
                    //SAVES AS TXT FILE
                    ticket.PrintText();
                }
            }

            
            System.out.println(" ");
            System.out.println(" ");

            System.out.println("Your Seat " + seat_row + seat_number + " has booked.");

        } // IF INPUT FOR SEAT ROW IS "D"
        else if (seat_row.equals(
                "D")) {
            if (seat_number >= 1 && seat_number <= 14) {
                int i = seat_number - 1;
                if (D[i] == "X") {
                    System.out.println("This seat is not available.");
                    return;

                } else {
                    D[i] = "X";
                     //PERSONAL DETAILS
                    System.out.println("Please enter personal details.");
                    System.out.println("Your name: ");
                    String name = input.next();
                    System.out.println("Your surname: ");
                    String surname = input.next();
                    System.out.println("Your email: ");
                    String email = input.next();
                  
                    //SEAT PRICE
                    if(seat_number>=1 && seat_number<=5){ 
                        price=200;
                        
                    }
                    else if (seat_number>=6 && seat_number<=9){
                        price = 150;
                    }
                    else{
                        price= 180;
                    }
                    
                    //ADDS TICKET AND PERSONAL INFO
                    Person person = new Person(name,surname,email); 
                    Ticket ticket = new Ticket(seat_row,seat_number,price,person);
                    tickets[ticketnum] = ticket;
                    ticketnum=ticketnum+1;
                    
                    //SAVES AS TXT FILE
                    ticket.PrintText();
                }

            } else {
                System.out.println("Please enter a valid seat number (1-14): ");
                seat_number = input.nextInt();
                int i = seat_number - 1;
                if (D[i] == "X") {
                    System.out.println("This seat is not available.");
                    return;

                } else {
                    D[i] = "X";
                     //PERSONAL DETAILS
                    System.out.println("Please enter personal details.");
                    System.out.println("Your name: ");
                    String name = input.next();
                    System.out.println("Your surname: ");
                    String surname = input.next();
                    System.out.println("Your email: ");
                    String email = input.next();
                  
                    //SEAT PRICE
                    if(seat_number>=1 && seat_number<=5){ 
                        price=200;
                        
                    }
                    else if (seat_number>=6 && seat_number<=9){
                        price = 150;
                    }
                    else{
                        price= 180;
                    }
                    
                    //ADDS TICKET AND PERSONAL INFO
                    Person person = new Person(name,surname,email); 
                    Ticket ticket = new Ticket(seat_row,seat_number,price,person);
                    tickets[ticketnum] = ticket;
                    ticketnum=ticketnum+1;
                    
                    //SAVES AS TXT FILE
                    ticket.PrintText();
                }

            }
            
            System.out.println(" ");
            System.out.println(" ");

            System.out.println("Your Seat " + seat_row + seat_number + " has booked.");

        } //IF ENTERED VALUES ARE INCORRECT
        else {
            System.out.println("Invalid Value.");

        }

    }

    private static void cancel_seat(String[] A, String[] B, String[] C, String[] D) {
        Scanner input = new Scanner(System.in);

        System.out.println(" ");
        System.out.println(" ");
        System.out.println("**               CANCEL A SEAT                **");
        System.out.println(" ");
        System.out.println(" ");

        //ASKS USER SEAT ROW AND NUMBER
        
        System.out.println("Please enter row (A,B,C,D): ");
        String seat_row = input.next();
        System.out.println("Please enter seat number (A,D: 1-14 || B,C: 1-12 ): ");
        int seat_number = input.nextInt();

        if (seat_row.equals("A")) {
            if (seat_number >= 1 && seat_number <= 14) {
                //INDEX IS 1 SMALLER THAN SEAT NUMBER
                int i = seat_number - 1;
                //IF ENTERED SEAT IS ALREADY EMPTY, WARNS THE USER
                if (A[i] == "O") {
                    System.out.println("This seat is already empty.");
                    return;

                } //CANCELLING THE SEAT
                else {
                    A[i] = "O";
                }}
                    
         //IF ENTERED VALUES ARE INCORRECT, WARNS THE USER TO ENTER A NEW VALUE AND TRIES AGAIN
               
            else {
                System.out.println("Please enter a valid seat number (1-14): ");
                seat_number = input.nextInt();
                int i = seat_number - 1;
                if (A[i] == "O") {
                    System.out.println("This seat is already empty.");
                    return;

                } else {
                    A[i] = "O";
                }
            }
            
            // TELLS USER THAT SEAT IS CANCELLED
            System.out.println("Your Seat " + seat_row + seat_number + " has been cancelled.");

        } else if (seat_row.equals("B")) {
            if (seat_number >= 1 && seat_number <= 12) {
                int i = seat_number - 1;
                if (B[i] == "O") {
                    System.out.println("This seat is already empty.");
                    return;

                } else {
                    B[i] = "O";
                }

            } else {
                System.out.println("Please enter a valid seat number (1-12): ");
                seat_number = input.nextInt();
                int i = seat_number - 1;
                if (B[i] == "O") {
                    System.out.println("This seat is already empty.");
                    return;

                } else {
                    B[i] = "O";
                }
            }

            System.out.println("Your Seat " + seat_row + seat_number + " has been cancelled.");

        } else if (seat_row.equals("C")) {
            if (seat_number >= 1 && seat_number <= 12) {
                int i = seat_number - 1;
                if (C[i] == "O") {
                    System.out.println("This seat is already empty.");
                    return;

                } else {
                    C[i] = "O";
                }

            } else {
                System.out.println("Please enter a valid seat number (1-12): ");
                seat_number = input.nextInt();
                int i = seat_number - 1;
                if (C[i] == "O") {
                    System.out.println("This seat is already empty.");
                    return;

                } else {
                    C[i] = "O";
                }
            }

            System.out.println("Your Seat " + seat_row + seat_number + " has been cancelled.");

        } else if (seat_row.equals("D")) {
            if (seat_number >= 1 && seat_number <= 14) {
                int i = seat_number - 1;
                if (D[i] == "O") {
                    System.out.println("This seat is already empty.");
                    return;

                } else {
                    D[i] = "O";
                }

            } else {
                System.out.println("Please enter a valid seat number (1-14): ");
                seat_number = input.nextInt();
                int i = seat_number - 1;
                if (D[i] == "O") {
                    System.out.println("This seat is already empty.");
                    return;

                } else {
                    D[i] = "O";
                }
            }

            System.out.println("Your Seat " + seat_row + seat_number + " has been cancelled.");
        } 
        
        
        //ENTERED VALUES ARE INCORRECT
        else {
            System.out.println("Invalid Value.");

        }

    }

    private static void find_first_available(String[] A, String[] B, String[] C, String[] D, String seat_row, int seat_number, double price){
        
        Scanner input = new Scanner(System.in);
        
        System.out.println(" ");
        System.out.println(" ");
        System.out.println("**           FIRST AVAILABLE SEAT             **");
        System.out.println(" ");
        System.out.println(" ");
        
        // EMPTY SEAT IS O, SO SEARCHES FOR THAT VALUE
        String searchValue="O";
        //STARTS AT INDEX 0
        int index = 0;
        //WHEN INDEX IS SMALLER THAN LENGTH OF ARRAY, SEARCHES FOR VALUE TILL FINDING IT
        while (index < A.length && A[index] != searchValue){
        index++;
    }
        //IF THERE ARE NO EMPTY SEATS, END OF ARRAY, ZEROES THE INDEX NUMBER AND SEARCHES IN THE NEXT ARRAY
        if (index == A.length) 
        {
            index = 0;
            while (index < B.length && B[index] != searchValue){
        index++;}
        if (index == B.length) 
        {
            index=0;
            while (index < C.length && C[index] != searchValue){
        index++;}
        if (index == C.length) 
        {index=0; 
        while (index < D.length && D[index] != searchValue){
        index++;}
        //IF THERE ARE NO EMPTY SEATS IN ALL ARRAYS, OUTPUT IS "NO AVAILABLE SEATS"
        if (index == D.length) {
            System.out.println("No available seats.");
            return;
             
        } 
        
        else {
            //IF EMPTY SEAT HAS FOUND, TELLS THE USER (BECAUSE THAT INDEX IS 1 LESS THAN SEAT NUMBER, ADDS 1)
            index= index+1 ;
            System.out.println("First available seat is D"+ index );
            
        }}
        
        
        else {
            index= index+1 ;
            System.out.println("First available seat is C"+ index );
            
        }
                
                
        } 
        
        else {
            index= index+1 ;
            System.out.println("First available seat is B"+ index );
            
            
        }
                
                
        } 
        
        else {
            index= index+1 ;
            System.out.println("First available seat is A"+ index );
            }
             
            
            
        
        
        
    }

    private static void show_seating_plan(String[] A, String[] B, String[] C, String[] D){
        
        System.out.println(" ");
        System.out.println(" ");
        System.out.println("**               SEATING PLAN                 **");
        System.out.println(" ");
        System.out.println(" ");
        
        //DEFINES ROW 
            System.out.print("Row A: ");
            
            //PRINTS ALL VALUES TILL END OF THE ARRAY IN ONE LINE
            for (int x = 0; x <= 13; x++) {
                System.out.print(A[x]);
            }
            System.out.println(" ");

            System.out.print("Row B: ");
            for (int x = 0; x <= 11; x++) {
                System.out.print(B[x]);
            }
            System.out.println(" ");
            System.out.println(" ");

            System.out.print("Row C: ");
            for (int x = 0; x <= 11; x++) {
                System.out.print(C[x]);
            }
            System.out.println(" ");

            System.out.print("Row D: ");
            for (int x = 0; x <= 13; x++) {
                System.out.print(D[x]);
            }
            
            System.out.println(" \n ");
            
            //HELPS USER TO UNDERSTAND WHICH SEATS ARE EMPTY AND WHICH ARE BOOKED. 
            System.out.println("Empty seats: O ");
            System.out.println("Booked seats: X ");
    }
    
    private static void print_tickets_info(Ticket[] tickets, int ticketnum) {
    double totalsale = 0;

    System.out.println("****************************************************");
    System.out.println("*                  TICKETS INFORMATION             *");
    System.out.println("****************************************************");
    System.out.println(" ");
    

    for (int x = 0; x < ticketnum; x++) {
                    
        //IF THERE ARE NO TICKETS BOOKED, PRINTS "NO TICKETS"
                    if(ticketnum==0){
                        System.out.println("No tickets.");
                        
                    } 
                    
                    // PRINTS EVERY TICKET BOOKED 
                    else {
                        
                        Ticket ticket = tickets[x];
                    System.out.println("Seat: " + ticket.getRow() +ticket.getSeat());
                    System.out.println("Price: £" + ticket.getPrice());
                    System.out.println("Person: " + "\n Name: "+ ticket.getPerson().getName() + "\n Surname: " + ticket.getPerson().getSurname() + "\n Email: "+ ticket.getPerson().getEmail());
                    System.out.println();
                    totalsale= totalsale + ticket.getPrice(); 
                    
                    

                    }
                    
                    //CALCULATES AND PRINTS TOTAL PRICE OF ALL TICKETS
                    System.out.println("Total Price: £" + totalsale +"\n \n");
                    
                    }
    
    
    
}
     private static void search_ticket(Ticket[] tickets,int ticketnum){
        
        Scanner input = new Scanner(System.in);
        
        System.out.println("****************************************************");
        System.out.println("*                     SEARCH TICKET                *");
        System.out.println("****************************************************");
        System.out.println(" ");
        
        // ASKS USER TO INPUT VALUES
        System.out.println("Please select row (A,B,C,D): ");
        String search_row = input.next();
        System.out.println("Please select seat number (A,D: 1-14 || B,C: 1-12 ): ");
        int search_number = input.nextInt();
        
        //STARTS AT INDEX 0
        int index = 0;
        Ticket ticket = tickets[index];
        
        //WHEN INDEX IS SMALLER THAN LENGTH OF ARRAY, SEARCHES FOR VALUE TILL FINDING IT
        while (index < ticketnum){
        
        //PRINTS SEAT IS AVAILABLE IF IT HAS NOT BOOKED
        if (search_row != tickets[index].getRow() && search_number!=tickets[index].getSeat()){ 
            index++;
            System.out.println("Seat is available.");}
        
        //PRINTS TICKET INFO
        else{System.out.println("Seat: " + ticket.getRow() +ticket.getSeat());
            System.out.println("Price: £" + ticket.getPrice());
            System.out.println("Person: " + "\n Name: "+ ticket.getPerson().getName() + "\n Surname: " + ticket.getPerson().getSurname() + "\n Email: "+ ticket.getPerson().getEmail());
            System.out.println();
            return;
           
            
        } }
        
                    
                    }
    }





