package com.cydeo.tests.day2_locators_getText_getAttribute.practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class T3_ {

    public static void main(String[] args) {

       // TC #3: Back and forth navigation
       // 1- Open a chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

       // 2- Go to: https://www.google.com
        driver.get("https://www.google.com");

       // 3- Click to Gmail from top right.
        //Locating the Gmail link using "linkText" Locator
        WebElement gmailLink = driver.findElement(By.linkText("Gmail"));

        //Click the gmail link
        gmailLink.click();

        // 4- Verify title contains:
       // Expected: Gmail
        String expectedGmailTitle = "Gmail";
        String actualGmailTitle = driver.getTitle();

        if (actualGmailTitle.contains(expectedGmailTitle)){
            System.out.println("Gmail title verification PASSED!!!");
        }else {
            System.out.println("Gmail title verification FAIL!!!");
        }

       // 5- Go back to Google by using the .back();
        driver.navigate().back();

       // 6- Verify title equals:
       // Expected: Google
        String expectedTitle = "Google";
        String actualTitle = driver.getTitle();

        if (actualTitle.equals(expectedTitle)){
            System.out.println("Google Title Verification PASSED!!!");
        }else {
            System.out.println("Google Title Verification FAIL!!!");
        }

      driver.close();
    }

}
