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

        KioskUI testKioskUI = new KioskUI();
        //create valid customer 
        testKioskUI.createAccount("nicholasisaacs4@gmail.com", "password");
        testKioskUI.login("nicholasisaacs4@gmail.com", "password");
        assertEquals("nicholasisaacs4@gmail.com",testKioskUI.current_customer.email);
        assertThrows(IllegalArgumentException.class, () -> testKioskUI.login("nicholassaacs4@gmail.com", "password"));
        testKioskUI.createAccount("chris@gmail.com", "password");
        testKioskUI.createAccount("roger@gmail.com", "password");
        testKioskUI.login("chris@gmail", "password");
        assertEquals("chris@gmail.com",testKioskUI.current_customer.email);
        testKioskUI.login("roger@gmail", "password");
        assertEquals("roger@gmail.com",testKioskUI.current_customer.email);


    }

    @Test
    void payLateFeesTest(){

        KioskUI testKioskUI = new KioskUI();
        //create valid customer 
        testKioskUI.createAccount("nicholasisaacs4@gmail.com", "password");
        testKioskUI.login("nicholasisaacs4@gmail.com", "password");
        testKioskUI.current_customer.lateFees = 3.00;
        assertEquals(3.00,testKioskUI.current_customer.lateFees);
        testKioskUI.payLateFees();
        assertEquals(0.0,testKioskUI.current_customer.lateFees);

    }

    @Test
    void returnMovieTest(){

        

    }

    @Test
    void rentTest(){

    }

    @Test 
    void getSetTransaction(){

        
    }
    
}
