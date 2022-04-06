import java.time.LocalDate;

public class Movie{
    public String title;
    public String genre;
    public String director;
    public int IDNum;
    public double price;
    public int ranking;
    public LocalDate dateRented;
    public LocalDate dateDue;
    public LocalDate dateReturned;

    public Movie(String title, String director, String genre){
        this.title=title;
        this.genre=genre;
        this.director=director;
    }

    int getIDNum(){
        return IDNum;
    }

    void setIDNum(){
        //get IDNum of last movie and add 1 to it
    }

    double getPrice(){
        return price;
    }

    void setPrice(){
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

    void setRanking(){ //when this is called, ranking should increase by 1
        ranking++;
    }

    void resetRanking(){ //resets ranking to zero
        ranking=0;
    }

    LocalDate getDateRented(){
        return dateRented;
    }

    void setDateRented(){ //this will be called on the day it's rented
        dateRented = LocalDate.now();
    }

    static LocalDate getDateDue(){
        return dateDue;
    }

    void setDateDue(){
        if(ranking>10){
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

    void setDateReturned(){ //this will be called on the day it's returned
        dateReturned = LocalDate.now();
    }

    void resetDates(){ //called after movie is returned
        dateDue = null;
        dateRented = null;
        dateReturned = null;
    }
    
}
