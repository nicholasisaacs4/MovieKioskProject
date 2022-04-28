package edu.ithaca.dturnbull.bank;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class Customer {
    ArrayList<Movie> rentedMovies = new ArrayList<Movie>();
    int IDNum;
    String email;
    String password;
    double lateFees;
    static List<String> transactionHistory = new ArrayList<String>();
    static boolean accountStatus;
    private static int IDCounter = 1;


    public Customer(String emailIn, String password){
        this.email = emailIn;
        this.password = password;
    }

    void setIDNum(int IDCounter){ //passed through in Admin, since that holds array list of customers
        IDNum = IDCounter+1;
    }

    int getIDNum(){
        return IDNum;
    }

    List<String> getTransactionHistory(){
        return transactionHistory;
    }

    static void addToHistory(String thisHistory){ //called when certain things are added to history (implemented more in KioskUI, Admin)
        transactionHistory.add(thisHistory);
    }

    ArrayList<Movie> getRentedMovies(){
        if(rentedMovies.size() <= 0){
            throw new IllegalArgumentException("no rented movies");
        }
        return rentedMovies;
    }

    void addToRentedMovies(Movie thisMovie){ //adds to rented movie list
        rentedMovies.add(thisMovie);
    }

    void removeFromRentedMovies(Movie thisMovie){ //removes from rented movie list
        rentedMovies.remove(thisMovie);
    }

    void resetRentedMovies(){ //clears ArrayList
        rentedMovies.clear();
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
        if(email.length() == 0 || !email.contains("@") || !email.contains(".")){
            return false;
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

    void resetLateFees(){
        lateFees = 0;
    }

    void setLateFees(Movie thisMovie){
        Period p = Period.between(thisMovie.getDateDue(), thisMovie.getDateReturned());
        int days = p.getDays();
        if(days <= 0){ //if negative number or 0 this means returned early or on time
            lateFees = 0;
        } 
        else{
            lateFees = days*1.99; //1.99 per day
            if(lateFees >= thisMovie.getPrice()){
                lateFees = thisMovie.getPrice(); //if the late fees exceed the movie price, they will be charged the movie
                Library.removeMovie(thisMovie); //the movie is removed from the library because the customer 'bought' it
            }
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