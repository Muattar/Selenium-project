package com.cydeo.tests.day2_locators_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class T3 {

    public static void main(String[] args) throws InterruptedException {


       // TC#3: Google search
       // 1- Open a chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // 2- Go to: https://google.com
        driver.get("https://google.com");

        // 3- Write “apple” in search box
        //locate search box
        WebElement googleSearchBox = driver.findElement(By.name("q"));
        //enter "apple" key
        googleSearchBox.sendKeys("apple" + Keys.ENTER);

        Thread.sleep(2000);

        // 4- Press ENTER to search
        //googleSearchBox.sendKeys(Keys.ENTER);
        //Thread.sleep(2000);

       // 5- Verify title:
       // Expected: Title should start with “apple” word
        String expectedTile = "apple";
        String actualTitle = driver.getTitle();

        if (actualTitle.startsWith(expectedTile)){
            System.out.println("Title verification is Passed!!!");
        }else{
            System.out.println("Title verification is Fail!!!");
        }

        Thread.sleep(2000);


        driver.close();
    }

}
