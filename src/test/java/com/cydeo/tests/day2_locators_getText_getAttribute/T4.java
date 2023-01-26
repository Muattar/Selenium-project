package com.cydeo.tests.day2_locators_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class T4 {

    public static void main(String[] args) throws InterruptedException {

       // TC #4: Library verifications
       // 1. Open Chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // 2. Go to https://library2.cybertekschool.com/login.html
        driver.get("https://library2.cybertekschool.com/login.html");

        Thread.sleep(2000);

       // 3. Enter username: “incorrect@email.com”
        WebElement usernameBox = driver.findElement(By.className("form-control"));
        usernameBox.sendKeys("incorrect@email.com");

        Thread.sleep(1000);

       // 4. Enter password: “incorrect password”
        WebElement passwordBox = driver.findElement(By.id("inputPassword"));
        passwordBox.sendKeys("inputPassword" );
        Thread.sleep(2000);

        //5.Locate Sign.in button using: tagName locator
        WebElement signInButton = driver.findElement(By.tagName("button"));
        signInButton.click();

        // 6. Verify: visually “Sorry, Wrong Email or Password”
        String expectedVisual = "Sorry, Wrong Email or Password";

        if (expectedVisual.equals("Sorry, Wrong Email or Password")){
            System.out.println("Passed!!!");
        }else {
            System.out.println("Fail!!!");
        }
        Thread.sleep(2000);


       /* displayed
        PS: Locate username input box using “className” locator
        Locate password input box using “id” locator
        Locate Sign in button using “tagName” locator*/
        driver.close();
    }
}
