import java.time.LocalDate;
import java.util.ArrayList;

public class Library {
    ArrayList<Movie>allMovies;
    ArrayList<Movie>topTen;

    public Library(){
    }
    
void addMovie(Movie newMovie){ //adds movie to allMovies
    allMovies.add(newMovie);
}
ArrayList getMovieList(){
    return allMovies;
}

ArrayList getTopTen(){
    return topTen;
}

void sortByRank(){

}

}
