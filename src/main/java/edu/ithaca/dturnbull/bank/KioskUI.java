package edu.ithaca.dturnbull.bank;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

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
            addToTransactionHistory(current_customer);
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

    public void noMovie(){
        System.out.println("No movies with this title are available.\nSearch again?\n1.\tyes\n2.\tno");
        Scanner scanner = new Scanner(System.in);
        String userChoice = scanner.nextLine();
        if(userChoice.equals("1")){
            rent();
        }
        else if(userChoice.equals("2")){
            //idk what would go here
            System.out.println("Sorry for the inconvenience\nCome again soon!"); 
        }
        else{
            System.out.println("----invalid response----");
            noMovie();
        }
    }
    //kioskUI
    public void rent(){
        System.out.println("Search by:\n1.\ttitle\n2.\tdirector\n3.\tgenre\n4.\tmost popular");
        Scanner scanner = new Scanner(System.in);
        String userChoice = scanner.nextLine();
        if(userChoice.equals("1")){
            System.out.println("Enter title:");
            Scanner scanner2 = new Scanner(System.in);
            String title = scanner2.nextLine();
            boolean movieExists = false;
            for(Movie movie:Library.allMovies){
                if(movie.title.equals(title)){
                    rent(movie);
                    movieExists = true;
                }
            }
            if (movieExists = false){
                

            }
        }
    }
    
    //for testing
    public void rent(Movie movie){
        //create search function
        current_customer.rentedMovies.add(movie);
        current_customer.addToHistory("rented" + movie.getTitle() + "on" +LocalDate.now()+ "for" + movie.getPrice());

    } 
    
    public void addToRentedMovies(Customer customer, Movie movie){
        customer.rentedMovies.add(movie);
    }

    /*
     ACTION KEY
     rent - "rent"
     return - "return"
    */
    public void addToTransactionHistory(Customer customer){
        customer.addToHistory("paid late fees on "+LocalDate.now()+" for $"+customer.lateFees);
    }
    public void addToTransactionHistory(Customer customer, Movie movie, String action){
        if(action.equals("rent")){
            customer.addToHistory("rented Movie#"+movie.getIDNum()+" on "+LocalDate.now()+" for $"+movie.getPrice());
        }
        else{
            customer.addToHistory("returned Movie#"+movie.getIDNum()+" on "+LocalDate.now());
        }
    }
}
