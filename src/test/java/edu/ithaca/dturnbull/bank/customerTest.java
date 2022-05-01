package edu.ithaca.dturnbull.bank;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class customerTest {
    @Test
    void IDNumTest(){
        //passes for Sprint 2, would implement with admin for sprint 3
        //tests if IDNumbers would be created properly
        Customer customer1 = new Customer("customer@c.com", "customer");
        Customer customer2 = new Customer("customer@c.com", "customer");
        Customer customer3 = new Customer("customer@c.com", "customer");
        ArrayList<Customer> customerList = new ArrayList<Customer>();
        customer1.setIDNum(0);
        customer2.setIDNum(1);
        customer3.setIDNum(2);

        customerList.add(customer1);
        customerList.add(customer2);
        customerList.add(customer3);
        assertEquals(1, customer1.getIDNum());
        assertEquals(2, customer2.getIDNum());
        assertEquals(3, customer3.getIDNum());
    }
    @Test
    void rentedMoviesTest(){ 
        //tests when movies are added and removed 
        Customer customer = new Customer("customer@c.com", "customer");
        Movie movie =  new Movie("title", "director", "genre");
        Movie movie2 =  new Movie("title", "director", "genre");
        Movie movie3 =  new Movie("title", "director", "genre");
        assertThrows(IllegalArgumentException.class, () -> customer.getRentedMovies());
        ArrayList<Movie> mArrayList = new ArrayList<>();
        mArrayList.add(movie); //adds a movie
        customer.addToRentedMovies(movie);
        assertEquals(customer.getRentedMovies(), mArrayList);
        customer.addToRentedMovies(movie2); //adds multiple movies
        mArrayList.add(movie2);
        customer.addToRentedMovies(movie3);
        mArrayList.add(movie3);
        assertEquals(customer.getRentedMovies(), mArrayList);
        mArrayList.remove(movie2); //removes a movie 
        customer.removeFromRentedMovies(movie2);
        assertEquals(customer.getRentedMovies(), mArrayList);
    }

    @Test
    void transactionHistoryTest(){
        //returns string representing transaction history
        Customer customer = new Customer("customer", "customer");
        assertThrows(IllegalArgumentException.class, () -> customer.getTransactionHistory()); //nothing in transaction history so error is thrown
        assertThrows(IllegalArgumentException.class, () -> customer.addToHistory("")); //nothing entered
        Movie movie =  new Movie("title", "director", "genre");
        Library library = new Library();
        library.addMovie(movie);
        customer.addToRentedMovies(movie);
        customer.addToHistory("added to rented movies");
        assertEquals("[added to rented movies]", customer.transactionHistory.toString()); //tests that get/add are same
    }

    @Test
    void isEmailValidTest(){
        //tests if emails are valid
        assertTrue(Customer.isEmailValid( "a@b.com"));   // valid email address
        assertFalse(Customer.isEmailValid("")); //invalid email, nothing there
        assertFalse(Customer.isEmailValid("a.com")); //invalid email no at sign
        assertFalse(Customer.isEmailValid("a@com")); //invalid email no at sign
    }
}
