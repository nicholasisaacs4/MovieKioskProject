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
    ArrayList<String> transactionHistory = new ArrayList<String>();
    static boolean accountStatus;
    private static int IDCounter = 1;


    public Customer(String emailIn, String password){
        transactionHistory = new ArrayList<>();
        rentedMovies = new ArrayList<>();
        this.email = emailIn;
        this.password = password;
        lateFees = 0;
    }
 
    void setIDNum(int Num){ //Number is passed through because this will be set up in admin class
        IDNum = Num+1;
        IDCounter += 1;
    }

    int getIDNum(){
        return IDNum;
    }

    List<String> getTransactionHistory(){
        if(transactionHistory.isEmpty()){
            throw new IllegalArgumentException("History is Empty");
        }
        return transactionHistory;
    }

    ArrayList<Movie> getRentedMovies(){
        if (!rentedMovies.isEmpty()){
            return rentedMovies;
        }else{
            throw new IllegalArgumentException("no rented movies");
        }
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
        if (email.length() < 1){
            return false;
        } 
        if (!email.contains("@")){
            return false;
        }
        if (!email.contains(".")){
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


    void addToHistory(String message){

        if (!message.isEmpty()){

            transactionHistory.add(message);

        }
        else{

            throw new IllegalArgumentException("empty message");
            
        }

    }

    void  addToRentedMovies(Movie movie){

        rentedMovies.add(movie);

    }

    void  removeFromRentedMovies(Movie movie){

        rentedMovies.remove(movie);

    }

    void resetLateFees(){

        lateFees = 0;

    }
}