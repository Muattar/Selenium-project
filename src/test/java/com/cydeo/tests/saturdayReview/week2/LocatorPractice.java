package com.cydeo.tests.saturdayReview.week2;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class LocatorPractice {

    public static void main(String[] args) throws InterruptedException {

        // TC#1: Practice page Login test
        // 1. Open Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//-----------------------------------------------------------------------------------------------

        // 2. Go to http://practice.cydeo.com/login
        driver.get("http://practice.cydeo.com/login");
//------------------------------------------------------------------------------------------------

        // 3. Enter username: "tomsmith"
        WebElement userNameBox1 = driver.findElement(By.name("username"));
        WebElement userNameBox2 = driver.findElement(By.xpath("//input[@type='text']"));
        userNameBox1.sendKeys("tomsmith");

        Thread.sleep(2000);
//-------------------------------------------------------------------------------------------------

        // 4. Enter password: "SuperSecretPassword"
        WebElement passwordBox1 = driver.findElement(By.xpath("//input[@name='password']"));
        WebElement passwordBox2 = driver.findElement(By.name("password"));
        passwordBox1.sendKeys("SuperSecretPassword");

        Thread.sleep(2000);

//--------------------------------------------------------------------------------------------------
        // 5. Click to Login button
        WebElement logInButton = driver.findElement(By.xpath("//button[text()='Login']"));
        logInButton.click();

        Thread.sleep(2000);

//--------------------------------------------------------------------------------------------------

        // 6. Verify text displayed on page
        // Expected: "You logged into a secure area!"
       // WebElement resutlText1 = driver.findElement(By.id("flash"));
        WebElement resultText2 = driver.findElement(By.xpath("//div[normalize-space (text())='You logged into a secure area!']"));

        String expectedText = "You logged into a secure area!";
        String actualText = resultText2.getText();

        if (actualText.contains(expectedText)){
            System.out.println("Text is PASS!!!");
        }else{
            System.out.println("Text FAIL");
        }


        driver.close();


    }


}
