package com.cydeo.tests.day5TestNg_Dropdown;

import org.testng.Assert;
import org.testng.annotations.*;

public class TestNgIntro {

    @BeforeClass
    public void setUpClass(){
        System.out.println("----> Before class is running!!!");
    }


    @BeforeMethod// running after each method
    public void setUpMethod(){
        System.out.println("Before method is running....");
    }


    @Test (priority = 1)// help us to class runnable without main method
    public void test1(){
        System.out.println("Test 1 is running....");

        String actual = "apple";
        String expected = "apple";
        Assert.assertEquals(actual, expected );
        //Asser Equals method will  compare two of the same value. If return true, pass. False, fails.
    }


    @Test (priority = 2)
    public void test2(){
        System.out.println("Test 2 is running...");

        String actual = "white";
        String expected = "white";
        Assert.assertTrue(actual.equals(expected));

    }

    @AfterMethod //running after each method
    public void tearDownMethod(){
        System.out.println("After method is running...");
}

    @AfterClass
    public void tearDownClass(){
    System.out.println("---> After class is!!!");
}




}
