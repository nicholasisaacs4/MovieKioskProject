package edu.ithaca.dturnbull.bank;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class libraryTest {
    public libraryTest(){
       
    }
    @Test
    void sortByRankTest(){ 
        /*INTEGRATION TEST: Tests movie (setRanking) and library (sortByRank) methods */

        /*Creates 7 new movies*/
        Library library = new Library();
        Movie THG = new Movie("Harry Potter", "Chris Colombus", "Action");
        Movie HP = new Movie("The Hunger Games", "Francis Lawrence", "Sci Fi");
        Movie TW = new Movie("Twilight", "Chris Weitz", "Action");
        Movie DV = new Movie("Divergent", "Neil Burger", "Sci Fi");
        Movie SW = new Movie("Star Wars", "George Lucas", "Sci Fi");
        Movie TMR = new Movie("The Maze Runner", "Wes Ball", "Sci Fi");
        Movie PJ = new Movie("Percy Jackson", "Chris Colombus", "Sci Fi");
 
        /*RANKING MOVIES*/
        assertEquals(0, THG.getRanking()); //makes sure ranking is 0
        THG.setRanking(3); //THG ranking = 3
        assertEquals(3, THG.getRanking()); //makes sure ranking is what it should be

        assertEquals(0, HP.getRanking());
        HP.setRanking(7); //HP ranking = 7
        assertEquals(7, HP.getRanking());


        TW.setRanking(5); //TW ranking = 5
        assertEquals(5, TW.getRanking());

        assertEquals(0, DV.getRanking());

        DV.setRanking(4); //DV ranking = 4
        assertEquals(4, DV.getRanking());

        assertEquals(0, SW.getRanking());

        SW.setRanking(10); //SW ranking = 10
        assertEquals(10, SW.getRanking());

        assertEquals(0, TMR.getRanking());
        TMR.setRanking(1); //TMR ranking = 1
        assertEquals(1, TMR.getRanking());

        assertEquals(0, PJ.getRanking()); //PJ ranking = 0

        /* ADDING ALL MOVIES TO LIBRARY */
         library.addMovie(THG);
         library.addMovie(HP);
         library.addMovie(TW);
         library.addMovie(DV);
         library.addMovie(SW);
         library.addMovie(TMR);
         library.addMovie(PJ);


        /* SORT BY RANK TEST*/
        library.sortByRank();
        assertEquals(0, library.getTopTen().get(0).ranking); 
        assertEquals(1, library.getTopTen().get(1).ranking); 
        assertEquals(3, library.getTopTen().get(2).ranking); 
        assertEquals(4, library.getTopTen().get(3).ranking); 
        assertEquals(5, library.getTopTen().get(4).ranking); 
        assertEquals(7, library.getTopTen().get(5).ranking); 
        assertEquals(10, library.getTopTen().get(6).ranking); 
        



    }
}
