package edu.ithaca.dturnbull.bank;
import java.time.LocalDate;
import java.util.ArrayList;

public class Library {
    ArrayList<Movie>allMovies = new ArrayList();
    ArrayList<Movie>topTen = new ArrayList();

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
