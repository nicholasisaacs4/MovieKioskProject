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
        Movie movie9 = new Movie("Ghostbusters", "Ivan Reitman", "Comedy");
        addMovie(movie9);
        Movie movie10 = new Movie("Star Wars", "George Lucas", "Sci-Fi");
        addMovie(movie10);
        Movie movie11 = new Movie("Psycho", "Alfred Hitchcock", "Horror");
        addMovie(movie11);
        Movie movie12 = new Movie("The Dark Crystal", "Jim Henson", "Fantasy");
        addMovie(movie12);
        Movie movie13 = new Movie("The Neverending Story", "Wolfgang Peterson", "Fantasy");
        addMovie(movie13);
        Movie movie14 = new Movie("The Last Unicorn", "Arthur Rankin Jr.", "Fantasy");
        addMovie(movie14);
        Movie movie15 = new Movie("The Nightmare Before Christmas", "Henry Selick", "Fantasy"); //genre?
        addMovie(movie15);
        Movie movie16 = new Movie("The Avengers", "Joss Whedon", "Action");
        addMovie(movie16);
        Movie movie17 = new Movie("Jojo Rabbit", "Taika Waititi", "Comedy");
        addMovie(movie17);
        Movie movie18 = new Movie("The Terminator", "James Cameron", "Action");
        addMovie(movie18);
        Movie movie19 = new Movie("Robocop", "Paul Verhoeven", "Action");
        addMovie(movie19);
        Movie movie20 = new Movie("Labryinth", "Jim Henson", "Fantasy");
        addMovie(movie20);
        Movie movie21 = new Movie("Hellraiser", "Clive Barker", "Horror");
        addMovie(movie21);
        Movie movie22 = new Movie("Evil Dead II", "Sam Raimi", "Comedy");
        addMovie(movie22);
        Movie movie23 = new Movie("The Evil Dead", "Sam Raimi", "Horror");
        addMovie(movie23);
        Movie movie24 = new Movie("Army of Darkness", "Sam Raimi", "Comedy");
        addMovie(movie24);
        Movie movie25 = new Movie("A Nightmare on Elm Street ", "Wes Craven", "Horror");
        addMovie(movie25);
    }
}
