package edu.ithaca.dturnbull.bank;

import java.util.Scanner;
import java.util.function.Function;

public interface KioskInterface {


    public static void main(String[] args) {

        boolean Functions = false;
        boolean running = true;
        KioskUI kiosk = new KioskUI();
        Library lib = new Library();
        lib.testLibrary(); // loads test library
        
        while(true){

            System.out.println("Welcome");
            System.out.println("Press enter 'login' to login or enter 'new' for new customer:");
            Scanner scanner2= new Scanner(System.in);
            String title = scanner2.nextLine();

            if (title.equals("new")){

                //new account process 
                System.out.println("New customer");
                System.out.println("Please Enter new Email:");
                Scanner scannerEmail= new Scanner(System.in);
                String email = scannerEmail.nextLine();
                System.out.println("Please Enter new Password:");
                Scanner scannerPassword= new Scanner(System.in);
                String Password = scannerPassword.nextLine();
                kiosk.createAccount(email, Password);
                Functions  = true;

            }
            if (title.equals("login")){

                //login process
                System.out.println("new");
                System.out.println("Please Enter Email");
                Scanner scannerEmail= new Scanner(System.in);
                String email = scannerEmail.nextLine();
                System.out.println("Please Enter Password");
                Scanner scannerPassword= new Scanner(System.in);
                String Password = scannerPassword.nextLine();
                kiosk.login(email, Password);
                System.out.println("hello" + " " + email);
                Functions = true;
            }

            
            while(Functions == true){ 

                System.out.println("please choose from options below");
                System.out.println("________________________________________");

                System.out.println("1) Rent");
                System.out.println("2) Return");
                System.out.println("3) logout");
                System.out.println("________________________________________");

                Scanner scannerOptions= new Scanner(System.in);
                String Option = scannerOptions.nextLine();

                if (Option.equals("1")){

                    //rent movie process 
                    kiosk.rent(lib);
                }

                if (Option.equals("2")){

                    System.out.println("Please enter movie ID you want to return");
                    //return movie process
                    //print out all rented movies
                    if (kiosk.current_customer.rentedMovies.size() > 0){
                        for(int x = 0; x<= kiosk.current_customer.rentedMovies.size()-1; x++){

                            System.out.println(x +" "+ kiosk.current_customer.rentedMovies.get(x).IDNum + " " + 
                            kiosk.current_customer.rentedMovies.get(x).title + " " +
                            kiosk.current_customer.rentedMovies.get(x).dateRented );

                        }

                        Scanner scannerID= new Scanner(System.in);
                        int ID = scannerID.nextInt();
                        kiosk.returnMovie(ID);

                    }else{
                        System.out.println("you have no rented movies, returning to the main screen");
                    }

                }
                if (Option.equals("3")){

                    System.out.println("Logged out");
                    Functions = false;
                    
                }
            }
        }
    }
    
}
