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
}
