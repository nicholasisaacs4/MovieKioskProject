package edu.ithaca.dturnbull.bank;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class Customer {
    ArrayList<Movie> rentedMovies;
    int IDNum;
    String email;
    String password;
    double lateFees;
    List<String> transactionHistory;
    static boolean accountStatus;


    public Customer(String emailIn, String password){
        this.email = emailIn;
        this.password = password;
    }

    public String getEmail(){
        return email;
    }

    public static boolean isEmailValid(String email){
        //check for special characters
        for(int i = 0; i < email.length(); i++){
            if (email.charAt(i) == '#' || email.charAt(i) == '!' || email.charAt(i) == '&' || email.charAt(i) == '$' || email.charAt(i) == '%' || email.charAt(i) == '^' || email.charAt(i) == '*'){
                return false;
            }
        }
        return true;
    }

    String getPassword(){
        return password;
    }

    void setPassword(String pass){
        this.password = pass;
    }

    boolean checkPassword(String passInput){
        if(password == passInput){
            return true;
        }
        return false;
    }

    double getLateFees(){
        return lateFees;
    }

    void setLateFees(Movie thisMovie){
        Period p = Period.between(thisMovie.getDateDue(), thisMovie.getDateReturned());
        for(int i=0; i<p.getDays(); i++){
            lateFees += 1.99; //1.99 per day of being late
        }
        if(lateFees >= thisMovie.getPrice()){
            lateFees = thisMovie.getPrice(); //if the late fees exceed the movie price, they will be charged the movie
            Library.removeMovie(thisMovie); //the movie is removed from the library because the customer 'bought' it
            Customer.setAccountStatus(0);
        }
        if(p.getDays() <= 0){
            Customer.setAccountStatus(1); //paid on time
        } 
    }

    Boolean getAccountStatus(){
        return accountStatus;
    }

    static void setAccountStatus(int num){ //specific numbers will be entered to set account status type
        if(num ==0){
            accountStatus = false; //too many late fees
            throw new IllegalArgumentException("Account Frozen: too many late fees");
        }
        if(num ==1){
            accountStatus = true;
        }
        else throw new IllegalArgumentException("please enter number 0 or 1");
    }
}