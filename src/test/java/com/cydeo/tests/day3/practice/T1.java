package com.cydeo.tests.day3.practice;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T1 {

    public static void main(String[] args) throws InterruptedException {

       // HWP #1: Etsy Title Verification
       // 1. Open Chrome browser

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

       // 2. Go to https://www.etsy.com
        driver.get("https://www.etsy.com");

        Thread.sleep(2000);

       // 3. Search for “wooden spoon”
       // WebElement searchButton = driver.findElement(By.xpath("//input[@type='text']"));
        //WebElement searchButton = driver.findElement(By.xpath("//input[@data-id='search-query']"));
        //WebElement searchButton = driver.findElement(By.xpath("//input[@id='global-enhancements-search-query']"));
       // WebElement searchButton = driver.findElement(By.xpath("//input[@name='search_query']"));
        WebElement searchButton = driver.findElement(By.xpath("//input[@placeholder='Search for anything']"));
        searchButton.sendKeys("wooden spoon" + Keys.ENTER);

        // 4. Verify title:
       // Expected: “Wooden spoon - Etsy”
        String expectedTitle = "Wooden spoon - Etsy";
        String actualTitle = driver.getTitle();

        if (actualTitle.equals(expectedTitle)){
            System.out.println("Title verification PASS!!!");
        }else {
            System.out.println("Title verification FAIL!!!");
        }

        Thread.sleep(2000);


        driver.close();
    }

}
