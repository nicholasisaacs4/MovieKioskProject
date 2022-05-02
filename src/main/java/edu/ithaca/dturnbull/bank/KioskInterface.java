package edu.ithaca.dturnbull.bank;

import java.util.Scanner;

public interface KioskInterface {

    


    public static void main(String[] args) {

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

        System.out.println("1) Search");
        System.out.println("2) Rent");
        System.out.println("3) Return");

        Scanner scannerOptions= new Scanner(System.in);
        String Option = scannerOptions.nextLine();

        if (Option.equals("1")){

            //search movie process 

        }

        if (Option.equals("2")){

            //rent movie process
            
        }

        if (Option.equals("3")){

            //return movie process

        }

    }
    
}
