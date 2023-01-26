package com.cydeo.tests.day2_locators_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class T1_CydeoVerification {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

       driver.get("https://practice.cydeo.com");


       Thread.sleep(2000);

        String expectedInURL = "cydeo";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.contains(expectedInURL)){
            System.out.println("URL verification Passed!!!");
        }else{
            System.out.println("URL verification Failed!!!");
        }

        String expectedTitle = "Practice";
        String actualTitle = driver.getTitle();

        if (actualTitle.equals(expectedTitle)){
            System.out.println("Title verification is Passed!!!");
        }else {
            System.out.println("Title verification is Failed!!!");
        }

        driver.close();


    }
}


/*
TC #1: Cydeo practice tool verifications
1. Open Chrome browser
2. Go to https://practice.cydeo.com
3. Verify URL contains
Expected: cydeo
4. Verify title:
Expected: Practice
 */

