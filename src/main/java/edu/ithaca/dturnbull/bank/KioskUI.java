package edu.ithaca.dturnbull.bank;
import java.time.LocalDate;
import java.util.ArrayList;

public class KioskUI {

    ArrayList<Customer> customers;


    public KioskUI(){
        this.customers = new ArrayList<>();
    }

    public String login(String email, String password){

        for(int x= 0; x<= customers.size()-1; x++){

            if(customers.get(x).email == email){
                //email passes 
                if (customers.get(x).password == password){
                    
                    return("Logged in");
                    
                }

                return("Log in fail");
            }

            return("Log in fail");
        }

        return("Log in fail");

    }

    public void createAccount(String email, String password){

        Customer newCust = new Customer(email, password);
        customers.add(newCust);

    }

    
}
