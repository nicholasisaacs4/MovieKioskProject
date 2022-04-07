package edu.ithaca.dturnbull.bank;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

public class Library {
    ArrayList<Movie> allMovies;
    ArrayList<Movie> topTen;

    public Library(){

        this.allMovies = new ArrayList<>();
        this.topTen = new ArrayList<>();

    }
    
    void addMovie(Movie newMovie){ //adds movie to allMovies
        allMovies.add(newMovie);
    }
    ArrayList<Movie> getMovieList(){
        return allMovies;
    }

    ArrayList<Movie> getTopTen(){
        return topTen;
    }   

    void sortByRank(){

        int n = allMovies.size();  
        for (int j = 1; j < n; j++) {  
            int key = allMovies.get(j).ranking;  
            int i = j-1;  
            while ( (i > -1) && ( allMovies.get(i).ranking > key ) ) {  
                allMovies.get(i+1).ranking = allMovies.get(i).ranking;  
                i--;  
            }  
            allMovies.get(i+1).ranking  = key;  
        }  

    }

}
