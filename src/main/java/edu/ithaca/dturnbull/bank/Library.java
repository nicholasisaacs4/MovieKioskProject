package edu.ithaca.dturnbull.bank;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

public class Library {
    static ArrayList<Movie> allMovies;
    ArrayList<Movie> topTen;

    public Library(){

        this.allMovies = new ArrayList<>();
        this.topTen = new ArrayList<>();

    }
    
    void addMovie(Movie newMovie){ 
        //adds movie to allMovies
        allMovies.add(newMovie);
    }

    ArrayList<Movie> getMovieList(){
        return allMovies;
    }

    ArrayList<Movie> getTopTen(){
        return topTen;
    }   

    static void removeMovie(Movie movie){ 
        //removes movie from allMovies
        if(allMovies.contains(movie)){
            allMovies.remove(movie); //removes the movie from library
        }
        else new NoMovieException("Movie not in library");
    }

    void sortByRank(){
        //sorts all movies in array list by their ranking
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

        if (allMovies.size()<=10){
            for (int x = 0; x<= allMovies.size()-1; x++){
                topTen.add(allMovies.get(x));
            }
        }
        if (allMovies.size()>10){
            for (int x = 0; x<= 10; x++){
                topTen.add(allMovies.get(x));
            }
        }

    }

    void testLibrary(){
        Movie movie = new Movie("Jurassic Park", "Steven Spielberg", "Sci-Fi");
        addMovie(movie);
        Movie movie2 = new Movie("Raiders of the Lost Ark", "Steven Spielberg", "Action");
        addMovie(movie2);
        Movie movie3 = new Movie("The Exorcist", "William Friedkin", "Horror");
        addMovie(movie3);
        Movie movie4 = new Movie("Jaws", "Steven Spielberg", "Thriller");
        addMovie(movie4);
        Movie movie5 = new Movie("The Fly", "David Cronenberg", "Horror");
        addMovie(movie5);
        Movie movie6 = new Movie("The Thing", "John Carpenter", "Horror");
        addMovie(movie6);
        Movie movie7 = new Movie("The Shining", "Stanley Kubrick", "Horror");
        addMovie(movie7);
        Movie movie8 = new Movie("Alien", "Ridley Scott", "Horror");
        addMovie(movie8);
        Movie movie9 = new Movie("name", "dir", "Thriller");
        addMovie(movie9);
        Movie movie10 = new Movie("name", "dir", "Thriller");
        addMovie(movie10);
        Movie movie11 = new Movie("name", "dir", "Thriller");
        addMovie(movie11);
        Movie movie12 = new Movie("name", "dir", "Thriller");
        addMovie(movie12);
        Movie movie13 = new Movie("name", "dir", "Thriller");
        addMovie(movie13);
        Movie movie14 = new Movie("name", "dir", "Thriller");
        addMovie(movie14);
        Movie movie15 = new Movie("name", "dir", "Thriller");
        addMovie(movie15);
        Movie movie16 = new Movie("name", "dir", "Thriller");
        addMovie(movie16);
        Movie movie17 = new Movie("name", "dir", "Thriller");
        addMovie(movie17);
        Movie movie18 = new Movie("name", "dir", "Thriller");
        addMovie(movie18);
        Movie movie19 = new Movie("name", "dir", "Thriller");
        addMovie(movie19);
        Movie movie20 = new Movie("name", "dir", "Thriller");
        addMovie(movie20);
        Movie movie21 = new Movie("name", "dir", "Thriller");
        addMovie(movie21);
        Movie movie22 = new Movie("name", "dir", "Thriller");
        addMovie(movie22);
        Movie movie23 = new Movie("name", "dir", "Thriller");
        addMovie(movie23);
        Movie movie24 = new Movie("name", "dir", "Thriller");
        addMovie(movie24);
        Movie movie25 = new Movie("name", "dir", "Thriller");
        addMovie(movie25);
    }

}
