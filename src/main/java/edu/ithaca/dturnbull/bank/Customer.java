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

    }

    void setUsername(){

    }

    String getPassword(){

    }

    void setPassword(){

    }

    double getLateFees(){

    }

    void setLateFees(){

    }

    Boolean getAccountStatus(){

    }

    void setAccountStatus(){

    }
}