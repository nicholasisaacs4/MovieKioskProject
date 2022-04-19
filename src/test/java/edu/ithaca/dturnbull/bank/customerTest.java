package edu.ithaca.dturnbull.bank;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;

public class customerTest {
    @Test
    void IDNumTest(){
        
    }
    @Test
    void rentedMoviesTest(){

    }

    @Test
    void transactionHistoryTest(){

    }

    @Test
    void lateFeesTest(){ //started but this won't work right now
        Customer cus1 = new Customer();
        Movie movie2 = new Movie("title", "director", "genre");
        Library newLibrary = new Library();
        newLibrary.addMovie(movie2);

        cus1.rent(movie2);

        cus1.return(movie2);
    }

    @Test
    void isEmailValidTest(){

    }
}
