package edu.ithaca.dturnbull.bank;

import java.util.Scanner;

public interface KioskInterface {

    


    public static void main(String[] args) {

        boolean running = true;
        KioskUI kiosk = new KioskUI();
        
        System.out.println("Welcome");
        System.out.println("Press enter to login or press n for new customer");
        Scanner scanner2= new Scanner(System.in);
        String title = scanner2.nextLine();

        if (title.equals("n")){

            //new account process 
            System.out.println("New customer");
            System.out.println("Please Enter new Email");
            Scanner scannerEmail= new Scanner(System.in);
            String email = scannerEmail.nextLine();
            System.out.println("Please Enter new Password");
            Scanner scannerPassword= new Scanner(System.in);
            String Password = scannerPassword.nextLine();
            
            kiosk.createAccount(email, Password);

        }else{

            //login process
            System.out.println("Login");
            System.out.println("Please Enter Email");
            Scanner scannerEmail= new Scanner(System.in);
            String email = scannerEmail.nextLine();
            System.out.println("Please Enter Password");
            Scanner scannerPassword= new Scanner(System.in);
            String Password = scannerPassword.nextLine();

            kiosk.login(email, Password);
        }

        
        System.out.println("1) Rent");
        System.out.println("2) Return");

        //not working 
        while(running == true){

            Scanner scannerOptions= new Scanner(System.in);
            String Option = scannerOptions.nextLine();

            if (Option.equals("1")){

                //rent movie process 
                kiosk.rent();

            }

            if (Option.equals("2")){

                //return movie process

                //print out all rented movies

                if (kiosk.current_customer.rentedMovies.size() > 0){
                    for(int x = 0; x<= kiosk.current_customer.rentedMovies.size()-1; x++){

                        System.out.println(x +" "+ kiosk.current_customer.rentedMovies.get(x).IDNum + " " + 
                        kiosk.current_customer.rentedMovies.get(x).title + " " +
                        kiosk.current_customer.rentedMovies.get(x).dateRented );

                    }
                }else{
                    
                }

                kiosk.returnMovie(//index of selected movie);
                
            }
        }

        

    }
    
}
