package edu.ithaca.dturnbull.bank;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Customer {
    ArrayList<Movie> rentedMovies;
    int IDNum;
    String username;
    String password;
    double lateFees;
    List<String> transactionHistory;
    boolean accountStatus;
    public Customer(String username, String password){
        this.username = username;
        this.password = password;
    }

    String getUsername(){
        return username;
    }

    void setUsername(String username){
        this.username = username;
    }

    String getPassword(){
        return password;
    }

    void setPassword(){
        this.password = password;
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