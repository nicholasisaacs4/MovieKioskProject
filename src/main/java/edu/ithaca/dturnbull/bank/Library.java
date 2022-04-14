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

    void removeMovie(Movie movie){ //removes movie from allMovies
        if(allMovies.contains(movie)){
            allMovies.remove(movie); //removes the movie from library
        }
        else new NoMovieException("Movie not in library");
    }

    void sortByRank(){

        ArrayList<Movie> tempMovies = allMovies;

        int n = tempMovies.size();  
        for (int j = 1; j < n; j++) {  
            int key = tempMovies.get(j).ranking;  
            int i = j-1;  
            while ( (i > -1) && ( tempMovies.get(i).ranking > key ) ) {  
                tempMovies.get(i+1).ranking = tempMovies.get(i).ranking;  
                i--;  
            }  
            tempMovies.get(i+1).ranking  = key;  
        }  

        if (tempMovies.size()<=10){
            for (int x = 0; x<= tempMovies.size()-1; x++){
                topTen.add(tempMovies.get(x));
            }
        }
        if (tempMovies.size()>10){
            for (int x = 0; x<= 10; x++){
                topTen.add(tempMovies.get(x));
            }
        }

    }

}
