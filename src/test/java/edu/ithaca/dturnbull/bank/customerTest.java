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
        Customer cus1 = new Customer("first@last.com", "password");
        Movie movie2 = new Movie("title", "director", "genre");
        Movie movie3 = new Movie("title", "director", "genre");
        Movie movie4 = new Movie("title", "director", "genre");
        Library newLibrary = new Library();
        newLibrary.addMovie(movie2);
        newLibrary.addMovie(movie3);
        newLibrary.addMovie(movie4);
        
        //Movie 2: Returned on time 
        movie2.setDateRented(LocalDate.of(1999, 8, 30)); //sets due date
        movie2.setRanking(10);
        movie2.setDateDue(); //sets due date to 3 days after
        movie2.setDateReturned(LocalDate.of(1999, 9, 1)); //returned before due date
        cus1.setLateFees(movie2);
        assertEquals(0, cus1.getLateFees()); //returned on time so 0 late fees

        //Movie 3: Returned a few days late
        movie3.setDateRented(LocalDate.of(1999, 8, 30)); //sets due date
        movie3.setRanking(10);
        movie3.setDateDue(); //sets due date to 3 days after
        movie3.setDateReturned(LocalDate.of(1999, 9, 4)); //returned 2 days after due date
        cus1.setLateFees(movie3);
        assertEquals(3.98, cus1.getLateFees());

        //Movie 4: Returned way late & movie is bought out
        movie4.setDateRented(LocalDate.of(1999, 8, 30)); //sets due date
        movie4.setRanking(10);
        movie4.setDateDue(); //sets due date to 3 days after
        movie4.setDateReturned(LocalDate.of(1999, 12, 30)); //returned 4 months after due date
        cus1.setLateFees(movie4);
        assertEquals(20, cus1.getLateFees());
    }

    @Test
    void isEmailValidTest(){
        assertTrue(Customer.isEmailValid( "a@b.com"));   // valid email address
        assertFalse( Customer.isEmailValid("")); //invalid email 
    }
}
