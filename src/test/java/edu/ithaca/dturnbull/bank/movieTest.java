package test;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;

public class movieTest {
    @Test
    void IDTest(){
        Movie movie = new Movie("The Fly", "David Cronenberg", "Horror");
        movie.setIDNum();
        assertEquals(movie.getIDNum(), 1); //TODO: change once setMovie is implemented
        Movie movie2 = new Movie("The Thing", "John Carpenter", "Horror");
        movie2.setIDNum();
        assertEquals(movie2.getIDNum(), 2); //TODO: change once setMovie is implemented
    }


    @Test
    void rankingTest(){
        Movie movie = new Movie("The Nightmare Before Christmas", "Henry Selick", "Animation"); //animation isn't a genre but idk what to put here
        movie.setRanking();
        assertEquals(movie.getRanking(), 1);
        movie.setRanking();
        assertEquals(movie.getRanking(), 2);
    }

    @Test
    void priceTest(){
        Movie movie = new Movie("The Avengers", "Joss Whedon", "Action");
        movie.setPrice();
        assertEquals(movie.getPrice(), 5);
        for(int i = 0; i<10; i++){
            movie.setRanking();
        }
        assertEquals(movie.getPrice(), 10);
        movie.setRanking();
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
        movie.setRanking(); //1
        movie.setRanking(); //2
        movie.setDateDue();
        assertEquals(movie.getDateDue(), dateRented.plusDays(7));

        movie.setRanking();//3
        movie.setDateDue();
        assertEquals(movie.getDateDue(), dateRented.plusDays(4));
        
        for(int i = 0; i<10; i++){//>10
            movie.setRanking();
        }
        movie.setDateDue();
        assertEquals(movie.getDateDue(), dateRented.plusDays(3));
    }
}
