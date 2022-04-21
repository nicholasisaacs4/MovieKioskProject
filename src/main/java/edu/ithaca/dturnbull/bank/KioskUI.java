package edu.ithaca.dturnbull.bank;
import java.time.LocalDate;
import java.util.ArrayList;

public class KioskUI {


    Customer current_customer;
    ArrayList<Customer> customers;


    public KioskUI(){
        this.customers = new ArrayList<>();
    }

    public void login(String email, String password){

        if(customers.size() > 0){
            for(int x= 0; x<= customers.size()-1; x++){

                if(customers.get(x).email == email){
                    //email passes 
                    if (customers.get(x).password == password){

                        current_customer = customers.get(x);
                        
                    }
                }
            }
        }else{
            throw new IllegalArgumentException("login failed");
        }

    }

    public void createAccount(String email, String password){

        Customer newCust = new Customer(email, password);
        customers.add(newCust);

    }


    public void payLateFees(){

        if (current_customer.lateFees > 0){
            current_customer.lateFees = 0;
        }else{

            throw new IllegalArgumentException("No Late fees");
        }

    }

    public void returnMovie(int movieID){

        if(current_customer.rentedMovies.size()>0){

            for (int x = 0; x<= current_customer.rentedMovies.size(); x++){
               if (current_customer.rentedMovies.get(x).IDNum == movieID){
                 current_customer.rentedMovies.remove(x);
               }
            }

        } else{

            throw new IllegalArgumentException("No Movies rented");
        }


    }

    public void rent(String title, String director, String genre){

        Movie newMovie = new Movie(title, director, genre);
        current_customer.rentedMovies.add(newMovie);
        
    }



    
}
