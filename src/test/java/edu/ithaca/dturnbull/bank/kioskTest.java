package edu.ithaca.dturnbull.bank;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;

class kioskTest {


    @Test
    void createAccountTest(){

        
        KioskUI testKioskUI = new KioskUI();

        //create valid customer 
        testKioskUI.createAccount("nicholasisaacs4@gmail.com", "password");

        //test if account is made
        assertEquals(1,testKioskUI.customers.size());//tests size
        assertEquals("nicholasisaacs4@gmail.com",testKioskUI.customers.get(0).email);
        assertEquals("password",testKioskUI.customers.get(0).password);

    }

    @Test
    void loginTest(){


        
    


    }
    
}
