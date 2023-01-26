package com.cydeo.tests.day2_locators_getText_getAttribute.practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class T2BankHeaderVerification {

    public static void main(String[] args) throws InterruptedException {

       // HWP #2: Zero Bank header verification
       // 1. Open Chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        Thread.sleep(2000);

       // 2. Go to http://zero.webappsecurity.com/login.html
        driver.get("http://zero.webappsecurity.com/login.html");

         // 3. Verify header text
        // Expected: “Log in to ZeroBank”
        WebElement headerText = driver.findElement(By.tagName("h3"));

        String expectedHeader = "Log in to ZeroBank";
        String actualHeader = headerText.getText();

        //Verification of actual vs expected
        if (actualHeader.equals(expectedHeader)){
            System.out.println("Header verification PASS!!!");
        }else {
            System.out.println("Header verification FAIL!!!");

        }

        Thread.sleep(2000);


          driver.close();
    }

}
