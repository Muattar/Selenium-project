package com.cydeo.tests.day7_webtables_utilities_javafaker;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

public class T1_WindowsHandling {

    //TC #1: Window Handle practice
    //1. Create new test and make setups
    //2. Go to : https://www.amazon.com
    //3. Copy paste the lines from below into your class
    //4. Create a logic to switch to the tab where Etsy.com is open
    //5. Assert: Title contains “Etsy”
    //Lines to be pasted:
    //((JavascriptExecutor) driver).executeScript("window.open('http://google.com','_blank');");
    //((JavascriptExecutor) driver).executeScript("window.open('http://etsy.com','_blank');");
    //((JavascriptExecutor) driver).executeScript("window.open('http://facebook.com','_blank');");
    //These lines will simply open new tabs using something called JavascriptExecutor
    //and get those pages. We will learn JavascriptExecutor later as well.

    WebDriver driver;

    @BeforeMethod
    public void setUpMethod(){
        //1. Create new test and make setups
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //2. Go to : https://www.amazon.com
        driver.get("https://www.amazon.com");

    }

    @Test
    public void window_handling_test(){
         //3. Copy/paste the lines from below into your class
        //These lines will simply open new tabs using something called JavascriptExecutor and get those pages.
        // We will learn JavascriptExecutor later as well.
        ((JavascriptExecutor) driver).executeScript("window.open('http://google.com','_blank');");
        ((JavascriptExecutor) driver).executeScript("window.open('http://etsy.com','_blank');");
        ((JavascriptExecutor) driver).executeScript("window.open('http://facebook.co', '_blank');");

        //4. Create a logic to switch to the tadriver.get("https://www.Etsy.com");
        //return and store all window handles in a Set
        Set<String> allWindowHandle = driver.getWindowHandles();

        for (String each : allWindowHandle) {
            driver.switchTo().window(each);
            System.out.println("Current url: " + driver.getCurrentUrl());

            if (driver.getCurrentUrl().contains("etsy")){
                break;
            }

        }

        //5. Assert: Title contains “Etsy”
      /*  String expectedTitle = "Etsy - Shop for handmade, vintage, custom, and unique gifts for everyone";
        String actualTitle = driver.getTitle();

        Assert.assertEquals(actualTitle, expectedTitle);*/
        BrowserUtils.verifyTitle(driver, "Etsy");



    }


    @Test
    public void window_handling_test2(){
        //3. Copy/paste the lines from below into your class
        //These lines will simply open new tabs using something called JavascriptExecutor and get those pages.
        // We will learn JavascriptExecutor later as well.
        ((JavascriptExecutor) driver).executeScript("window.open('http://google.com','_blank');");
        ((JavascriptExecutor) driver).executeScript("window.open('http://etsy.com','_blank');");
        ((JavascriptExecutor) driver).executeScript("window.open('http://facebook.co', '_blank');");


        BrowserUtils.switchWindowAndVerify(driver, "facebook", "Facebook");




    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }


}
