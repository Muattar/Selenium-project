package com.cydeo.tests.day2_locators_getText_getAttribute.practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class T4 {

    public static void main(String[] args) throws InterruptedException {

       // TC #4: Practice Cydeo – Class locator practice
        //1- Open a chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //2- Go to: https://practice.cydeo.com/inputs
        driver.get("https://practice.cydeo.com/inputs");

        Thread.sleep(2000);

        //3- Click to “Home” link
        WebElement homeLink = driver.findElement(By.className("nav-link"));
        homeLink.click();

        Thread.sleep(2000);

        //4- Verify title is as expected:
        //Expected: Practice
        String expectedTile = "Practice";
        String actualTile = driver.getTitle();
        if (actualTile.contains(expectedTile)){
            System.out.println("Practice Title is a PASSED!!!");
        }else {
            System.out.println("Practice Title is a FAIL!!!");

        }

        //PS: Locate “Home” link using “className” locator

        driver.close();
    }

}
