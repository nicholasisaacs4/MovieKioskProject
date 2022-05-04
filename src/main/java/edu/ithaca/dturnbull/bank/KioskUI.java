package edu.ithaca.dturnbull.bank;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class KioskUI {


    Customer current_customer;
    ArrayList<Customer> customers;
    int test;


    public KioskUI(){
        this.customers = new ArrayList<Customer>();
        this.test = 1;
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
            current_customer.addToHistory("paid late fees on "+LocalDate.now()+" for $"+current_customer.lateFees);
            current_customer.lateFees = 0;
            
        }else{

            throw new IllegalArgumentException("No Late fees");
        }
    }

    public void returnMovie(int movieID){

        if(current_customer.rentedMovies.size()>0){

            for (int x = 0; x<= current_customer.rentedMovies.size()-1; x++){
               if (current_customer.rentedMovies.get(x).IDNum == movieID){
                 current_customer.rentedMovies.remove(x);
                 current_customer.addToHistory("returned Movie#"+movieID+" on "+LocalDate.now());
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
            //idk what would go here :P
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
        // String userChoice = "1";
        String userChoice = scanner.nextLine();
        

        // BY TITLE //
        if(userChoice.equals("1")){
            System.out.println("Enter title:");
            Scanner scanner2= new Scanner(System.in);
            String title = scanner2.nextLine();
            boolean movieExists = false;
            //makes list of search results
            ArrayList<Movie> movieList = new ArrayList<>();
            for(Movie movie:Library.allMovies){
                if(movie.title.equals(title)){
                    movieList.add(movie);
                    movieExists = true;
                }
            }
            //if no movies in list, initiates noMovie() (see above method)
            if (movieExists = false){
                noMovie();
            }

            //if only one movie matches search, movie is rented
            else if(movieList.size() == 1){
                rent(movieList.get(0));
            }

            //if mult. movies in search result, user is asked to select the correct one
            else{
                System.out.println("Please make a selection:");
                int i = 1;
                //lists each movie that matches search param
                for(Movie movie:movieList){
                    System.out.println(i+".\t"+movie.title);
                    i++;
                }
                Scanner scanner3= new Scanner(System.in);
                //uses index to rent correct movie
                int selection = Integer.parseInt(scanner3.nextLine()) -1;
                rent(movieList.get(selection));
                /* 
                 if time, add failsafe for incorrect input, and add and option to cancel search
                 make it print (i+1)".\t<- back" or something, make if statement where index+1 = rent()
                */
            }  
        }

        
    }
    
    public void rent(Movie movie){
        current_customer.rentedMovies.add(movie);
        current_customer.addToHistory("rented" + movie.getTitle() + "on" +LocalDate.now()+ "for" + movie.getPrice());

    } 
    public static void main(String[] args) {
        System.out.println("Welcome!  Would you like to:\n");
        KioskUI testKioskUI = new KioskUI();
        testKioskUI.createAccount("nicholasisaacs4@gmail.com", "password");
        testKioskUI.login("nicholasisaacs4@gmail.com", "password");
        Library testLibrary = new Library();
        testLibrary.testLibrary();
        testKioskUI.rent();

        //testing:
        // System.out.println("Rented Movies:");
        // for(int i = 0; i < testKioskUI.current_customer.rentedMovies.size(); i++){
        //     System.out.println(testKioskUI.current_customer.rentedMovies.get(i).getTitle()1);
        // }
    }
}
