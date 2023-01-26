package com.cydeo.tests.day3.practice;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T3_xPath_css {
    public static void main(String[] args) {

       // TC #3: Back and forth navigation
       // 1- Open a chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        //2- Go to: https://google.com
        driver.get("https://google.com");

        //3- Click to Gmail from top right.
        WebElement gmailLink = driver.findElement(By.xpath("//a[@data-pid='23']"));
        gmailLink.click();


       // 4- Verify title contains:
      //  Expected: Gmail
        String expectedGmailTile = "Gmail";
        String actualGmailTile = driver.getTitle();

        if (actualGmailTile.contains(expectedGmailTile)){
            System.out.println("Gmail Title verification is PASS!!!");
        }else {
            System.out.println("Gmail Title verification is FAIL!!!" );
        }

        //  5- Go back to Google by using the .back();
        driver.navigate().back();

       // 6- Verify title equals:
       // Expected: Google

        String expectedGoogleTitle = "Google";
        String actualGoogleTitle = driver.getTitle();

        if (actualGoogleTitle.equals(expectedGoogleTitle)){
            System.out.println("Google Title verification is PASS!!!");
        }else {
            System.out.println("Google Title verification is FAIL!!!");
        }

        driver.close();


    }

}
