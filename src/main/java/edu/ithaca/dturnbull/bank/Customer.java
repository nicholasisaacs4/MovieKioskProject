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
    private static int IDCounter = 1;


    public Customer(String emailIn, String password){
        this.email = emailIn;
        this.password = password;
    }

    void setIDNum(){
        IDNum = IDCounter;
        IDCounter += 1;
    }

    int getIDNum(){
        return IDNum;
    }

    List<String> getTransactionHistory(){
        return transactionHistory;
    }

    ArrayList<Movie> getRentedMovies(){
        return rentedMovies;
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
        if(p.getDays() <= 0){ //if returned on time or early
            lateFees = 0;
        }
        else{
            lateFees = p.getDays()*1.99; //1.99 per day
        }
        if(lateFees >= thisMovie.getPrice()){
            lateFees = thisMovie.getPrice(); //if the late fees exceed the movie price, they will be charged the movie
            Library.removeMovie(thisMovie); //the movie is removed from the library because the customer 'bought' it
        }
    }

    Boolean getAccountStatus(){
        return accountStatus;
    }

    void setAccountStatus(int num){ //specific numbers will be entered to set account status type
        if(num ==0){
            accountStatus = false; //bad status
            throw new IllegalArgumentException("Account Frozen: too many late fees");
        }
        else if(num ==1){
            accountStatus = false; //bad password (in kiosk)
            throw new IllegalArgumentException("Account Frozen: password entered incorrectly");
        }
        else if(num ==2){
            accountStatus = true; //good status
        }
        else throw new IllegalArgumentException("please enter number between 0 and 2");
    }
}