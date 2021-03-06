package edu.ithaca.dturnbull.bank;
import java.time.LocalDate;

public class Movie{
    public String title;
    public String genre;
    public String director;
    public int IDNum;
    public double price;
    public int ranking;
    public LocalDate dateRented;
    public static LocalDate dateDue;
    public LocalDate dateReturned;
    private static int IDCounter = 1;

    public Movie(String title, String director, String genre){
        this.title=title;
        this.genre=genre;
        this.director=director;
    }

    String getTitle(){
        return title;
    }

    String getGenre(){
        return genre;
    }

    String getDirector(){
        return director;
    }

    int getIDNum(){
        return IDNum;
    }

    void setIDNum(){
            IDNum = IDCounter;
            IDCounter += 1;
    }

    double getPrice(){
        return price;
    }

    void setPrice(){
        //sets price according to ranking
        if(ranking>=10){ //if rented >10 times
            price = 20;
        }
        else if(ranking>1 && ranking<10){ //if rented between 2-10 times
            price = 10;
        }
        else if(ranking<=1){ //if rented 0 or 1 time
            price = 5;
        }
    }

    int getRanking(){
        return ranking;
    }

    void setRanking(int rank){ //when this is called, ranking should increase by 1
        ranking = rank;
    }

    void resetRanking(){ //resets ranking to zero
        ranking=0;
    }

    LocalDate getDateRented(){
        return dateRented;
    }

    void setDateRented(LocalDate thisDate){ //this will be called on the day it's rented
        dateRented = thisDate;
    }

    LocalDate getDateDue(){
        return dateDue;
    }

    void setDateDue(){
        //sets due date according to ranking
        if(ranking>=10){
            dateDue = dateRented.plusDays(3); //popular movie = less days
        }
        else if(ranking <10 && ranking>2){
            dateDue = dateRented.plusDays(4);
        }
        else{
            dateDue = dateRented.plusDays(7); //unpopular movie = more days
        }
    }

    LocalDate getDateReturned(){
        return dateReturned;
    }

    void setDateReturned(LocalDate returnDate){ //usually will call the same date
        dateReturned = returnDate;
    }

    void resetDates(){ //called after movie is returned
        dateDue = null;
        dateRented = null;
        dateReturned = null;
    }
    
}
