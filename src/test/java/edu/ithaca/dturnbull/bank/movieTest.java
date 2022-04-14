package edu.ithaca.dturnbull.bank;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;

public class movieTest {
    @Test
    void IDTest(){
        Movie movie = new Movie("title", "director", "genre");
        assertEquals(1, movie.getIDNum()); 
        Movie movie2 = new Movie("title", "director", "genre");
        assertEquals(2, movie.getIDNum()); 
        Movie movie3 = new Movie("title", "director", "genre");
        assertEquals(3, movie.getIDNum()); 
    }

    @Test
    void rankingTest(){
        Movie movie = new Movie("The Nightmare Before Christmas", "Henry Selick", "Animation"); //animation isn't a genre but idk what to put here
        movie.setRanking(1);
        assertEquals(movie.getRanking(), 1);
        movie.setRanking(2);
        assertEquals(movie.getRanking(), 2);
    }

    @Test
    void priceTest(){
        Movie movie = new Movie("The Avengers", "Joss Whedon", "Action");
        movie.setPrice();
        assertEquals(movie.getPrice(), 5);
        movie.setRanking(9);
        movie.setPrice();
        assertEquals(movie.getPrice(), 10);
        movie.setRanking(10);
        movie.setPrice();
        assertEquals(movie.getPrice(), 20);
        

    }

    @Test
    void dateRentedTest(){
        Movie movie = new Movie("Star Wars", "George Lucas", "Sci-fi");
        movie.setDateRented();
        assertEquals(movie.getDateRented(), LocalDate.now());
        Movie movie2 = new Movie("Alien", "Ridley Scott", "Horror");
        movie2.setDateRented();
        assertEquals(movie2.getDateRented(), LocalDate.now());
    }

    @Test
    void dateDueTest(){
        LocalDate dateRented = LocalDate.now();
        Movie movie = new Movie("Beetlejuice", "Tim Burton", "Comedy");
        movie.setDateRented();
        movie.setRanking(1); //1
        movie.setRanking(2); //2
        movie.setDateDue();
        assertEquals(movie.getDateDue(), dateRented.plusDays(7));

        movie.setRanking(3);//3
        movie.setDateDue();
        assertEquals(movie.getDateDue(), dateRented.plusDays(4));
        
        for(int i = 0; i<10; i++){//>10
            movie.setRanking(10);
        }
        movie.setDateDue();
        assertEquals(movie.getDateDue(), dateRented.plusDays(7));
    }

    @Test
    void resetDateTest(){
        LocalDate dateRented = LocalDate.now();
        Movie movie = new Movie("Beetlejuice", "Tim Burton", "Comedy");
        movie.setDateRented();
        movie.setDateDue();
        movie.setDateReturned();
        movie.resetDates();
        assertEquals(null, movie.getDateDue());
        assertEquals(null, movie.getDateRented());
        assertEquals(null, movie.getDateRented());
    }
}
