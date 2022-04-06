package edu.ithaca.dturnbull.bank;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

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

        /* ADDING ALL MOVIES TO LIBRARY */
        library.addMovie(THG);
        library.addMovie(HP);
        library.addMovie(TW);
        library.addMovie(DV);
        library.addMovie(SW);
        library.addMovie(TMR);
        library.addMovie(PJ);

        /*RANKING MOVIES*/
        assertEquals(0, THG.getRanking()); //makes sure ranking is 0
        THG.setRanking();
        THG.setRanking();
        THG.setRanking(); //THG ranking = 3
        assertEquals(3, THG.getRanking()); //makes sure ranking is what it should be

        assertEquals(0, HP.getRanking());
        HP.setRanking();
        HP.setRanking();
        HP.setRanking();
        HP.setRanking();
        HP.setRanking();
        HP.setRanking();
        HP.setRanking(); //HP ranking = 7
        assertEquals(7, HP.getRanking());

        TW.setRanking();
        TW.setRanking();
        TW.setRanking();
        TW.setRanking();
        TW.setRanking(); //TW ranking = 5
        assertEquals(5, TW.getRanking());

        assertEquals(0, DV.getRanking());
        DV.setRanking();
        DV.setRanking();
        DV.setRanking();
        DV.setRanking(); //DV ranking = 4
        assertEquals(4, DV.getRanking());

        assertEquals(0, SW.getRanking());
        SW.setRanking();
        SW.setRanking();
        SW.setRanking();
        SW.setRanking();
        SW.setRanking();
        SW.setRanking();
        SW.setRanking();
        SW.setRanking();
        SW.setRanking();
        SW.setRanking(); //SW ranking = 10
        assertEquals(10, SW.getRanking());

        assertEquals(0, TMR.getRanking());
        TMR.setRanking(); //TMR ranking = 1
        assertEquals(1, TMR.getRanking());

        assertEquals(0, PJ.getRanking()); //PJ ranking = 0

        /* SORT BY RANK TEST*/
        library.sortByRank();
        assertEquals(null, library.getTopTen()); //TODO: fix this when sort by rank is written
    }
}
