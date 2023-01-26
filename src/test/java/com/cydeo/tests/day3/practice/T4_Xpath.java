package com.cydeo.tests.day3.practice;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T4_Xpath {

    public static void main(String[] args) throws InterruptedException {

        //HWP #4: Practice Cydeo – xpath locator practice
        //1- Open a chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        //2- Go to: https://practice.cydeo.com/inputs
        driver.get("https://practice.cydeo.com/inputs");

        //3- Click to “Home” link
        WebElement homeLink = driver.findElement(By.xpath("//a[@class='nav-link']"));
        homeLink.click();

        Thread.sleep(2000);

        //4- Verify title is as expected:
        //Expected: Practice

        String expectedTitle = "Practice";
        String actualTitle = driver.getTitle();

        if (actualTitle.equals(expectedTitle)){
            System.out.println("Practice title verification is PASS!!!");
        }else{
            System.out.println("Practice title verification is FAIL!!!");
        }


        //PS: Locate “Home” link using “xpath” locator
         driver.close();
    }

}
