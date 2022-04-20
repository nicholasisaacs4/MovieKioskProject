package edu.ithaca.dturnbull.bank;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class customerTest {
    @Test
    void IDNumTest(){
        Customer customer = new Customer("customer", "customer");
        Admin.admin = new Admin();//will as later
        
        admin.allCustomers.add(customer);
        customer.setIDNum();
        assertEquals(1, customer.getIDNum()); 
       
        Customer customer2 = new Customer("customer", "customer");
        admin.allCustomers.add(customer2);
        customer2.setIDNum();
        assertEquals(2, customer2.getIDNum()); 
        Customer customer3 = new Customer("customer", "customer");
        admin.allCustomers.add(customer3);
        customer3.setIDNum();
        assertEquals(3, customer3.getIDNum()); 
    }
    @Test
    void rentedMoviesTest(){
        //would rent be a pass-through function??
        Customer customer = new Customer("customer", "customer");
        Movie movie =  new Movie("title", "director", "genre");
        Movie movie2 =  new Movie("title", "director", "genre");
        Movie movie3 =  new Movie("title", "director", "genre");
        assertThrows(NoMovieException.class, () -> customer.getRentedMovies());
        customer.rent(movie);
        ArrayList<Movie> mArrayList = new ArrayList<>();
        mArrayList.add(movie);
        assertEquals(customer.getRentedMovies(), mArrayList);
        customer.rent(movie2);
        mArrayList.add(movie2);
        customer.rent(movie3);
        mArrayList.add(movie3);
        assertEquals(customer.getRentedMovies(), mArrayList);
    }

    @Test
    void transactionHistoryTest(){
        //returns string representing transaction history
        Customer customer = new Customer("customer", "customer");
        assertThrows(NoTransactionHistoryException.class, () -> customer.getTransactionHistory());
        Movie movie =  new Movie("title", "director", "genre");
        Library library = new Library();
        library.addMovie(movie);
        customer.rent(movie);
        //each time rent is called getTH needs to be called b4 completed so price doesn't change
        assertEquals("rented Movie#1 on "+LocalDate.now()+" for "+movie.getPrice(), customer.getTransactionHistory());
        customer.return(movie);
        assertEquals("rented Movie#1 on "+LocalDate.now()+" for "+movie.getPrice()+"\nreturned Movie#1 on "+LocalDate.now(), customer.getTransactionHistory());
        //add more as kiosk is implemented i.e. payLateFees, etc.
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
