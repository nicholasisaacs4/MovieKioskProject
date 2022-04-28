package edu.ithaca.dturnbull.bank;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class customerTest {
    @Test
    void IDNumTest(){
        Customer customer1 = new Customer("customer@c.com", "customer");
        Customer customer2 = new Customer("customer@c.com", "customer");
        Customer customer3 = new Customer("customer@c.com", "customer");
        ArrayList<Customer> customerList = new ArrayList<Customer>();
        customer1.setIDNum();
        customer2.setIDNum();
        customer3.setIDNum();

        customerList.add(customer1);
        customerList.add(customer2);
        customerList.add(customer3);
        assertEquals(1, customer1.getIDNum());

        /* ADMIN: For Sprint 3, will implement when Admin is impl
        Admin.admin = new Admin();//will add later
        
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
        */
    }
    @Test
    void rentedMoviesTest(){ //tests when movies are added and removed 
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
        assertThrows(NoTransactionHistoryException.class, () -> customer.getTransactionHistory());
        Movie movie =  new Movie("title", "director", "genre");
        Library library = new Library();
        library.addMovie(movie);
        customer.addToRentedMovies(movie);
        //each time rent is called getTH needs to be called b4 completed so price doesn't change
        assertEquals("rented Movie#1 on "+LocalDate.now()+" for "+movie.getPrice(), customer.getTransactionHistory());
        customer.removeFromRentedMovies(movie);
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
        assertFalse(Customer.isEmailValid("")); //invalid email 
    }
}
