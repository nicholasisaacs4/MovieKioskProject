package edu.ithaca.dturnbull.bank;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Customer {
    ArrayList<Movie> rentedMovies;
    int IDNum;
    String email;
    String password;
    double lateFees;
    List<String> transactionHistory;
    boolean accountStatus;


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

    void setPassword(){
        this.password = password;
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

    void setLateFees(){
        //TODO
    }

    Boolean getAccountStatus(){
        return accountStatus;
    }

    void setAccountStatus(){
        //TODO
    }
}