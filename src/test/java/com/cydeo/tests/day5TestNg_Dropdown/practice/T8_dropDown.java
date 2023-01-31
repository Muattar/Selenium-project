package com.cydeo.tests.day5TestNg_Dropdown.practice;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class T8_dropDown {

//TC #8: Selecting value from non-select dropdown
//1. Open Chrome browser
//2. Go to https://practice.cydeo.com/dropdown
//3. Click to non-select dropdown
//4. Select Facebook from dropdown
//5. Verify title is “Facebook - Log In or Sign Up”

    WebDriver driver;

    @BeforeMethod
    public void setUpMethod(){
        //1. Open Chrome browser
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        //2. Go to https://practice.cydeo.com/dropdown
        driver.get("https://practice.cydeo.com/dropdown");
    }

    @Test
    public void T8FacebookDropdown() throws InterruptedException {
        //3. Click to non-select dropdown
        //locate the non-select dropdown
        WebElement webSiteDropdown = driver.findElement(By.linkText("Dropdown link"));
        Thread.sleep(2000);

        webSiteDropdown.click();

        Thread.sleep(2000);


        //4. Select Facebook from dropdown
        WebElement facebookLink = driver.findElement(By.linkText("Facebook"));
        Thread.sleep(2000);
        facebookLink.click();
        Thread.sleep(2000);


        //5. Verify title is “Facebook - log In or Sign Up”
        String expectedTitle = "Facebook - log in or sign up";
        String actualTitle = driver.getTitle();

        Assert.assertEquals(actualTitle, expectedTitle, "Title are not equal!!!");

    }

    @AfterMethod
    public void tearDownMethod(){
        driver.close();
    }


}
