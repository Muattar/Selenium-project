package com.cydeo.tests.day2_locators_getText_getAttribute.practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class T1EtsyTitleVerification {

    public static void main(String[] args) throws InterruptedException {

        //HWP #1: Etsy Title Verification
        //1. Open Chrome browser
        //Setting up our chromedriver using WebDriver
        WebDriverManager.chromedriver().setup();

        //creating a new chrome driver and storing it in "driver
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

       // 2. Go to https://www.etsy.com
        driver.get("https://www.etsy.com");
        Thread.sleep(2000);

       // 3. Search for “wooden spoon”
        WebElement eatsySeachbutton =  driver.findElement(By.id("global-enhancements-search-query"));
        eatsySeachbutton.sendKeys("wooden spoon");
        Thread.sleep(2000);

        eatsySeachbutton.sendKeys(Keys.ENTER);

       // 4. Verify title:
       // Expected: “Wooden spoon - Etsy”
        String expectedTitle = "Wooden spoon - Etsy";
        String actualTitle = driver.getTitle();

        if (actualTitle.equals(expectedTitle)){
            System.out.println("Etsy title verification PASSED!");
        }else{
            System.out.println("Etsy title verification FAILED!");
        }

        Thread.sleep(2000);

        driver.close();
    }

}
